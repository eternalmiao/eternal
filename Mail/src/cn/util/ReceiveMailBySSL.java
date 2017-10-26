package cn.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import cn.bean.Mail;

public class ReceiveMailBySSL {

	String protocal;
	String pop3Server;
	String username;
	String password;
	
	public ReceiveMailBySSL(String protocal, String pop3Server, String username, String password) {
		super();
		this.protocal = protocal;
		this.pop3Server = pop3Server;
		this.username = username;
		this.password = password;
	}


	public List<Mail> connect(){
		List<Mail> list = new ArrayList();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.pop3.host", pop3Server);
        props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        props.setProperty("mail.pop3.auth", "true");		
		

		         
		// 使用Properties对象获得Session对象  
		Session session = Session.getInstance(props);
		session.setDebug(false);
		
		
		try {
			Store store = session.getStore(protocal);
			store.connect(pop3Server,username, password);
			
			//获取收件箱  
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);  //以只读权限打开收件箱  
			
			
			/**
			 * Folder.READ_ONLY：表示只读权限。
			 * Folder.READ_WRITE：表示可以修改并读取邮件夹中的邮件。
			 **/
			             
			//获取收件箱中的邮件
			Message[] messages = folder.getMessages();
			System.out.println("总的邮件数目："+messages.length);
			System.out.println("新邮件数目："+folder.getNewMessageCount());
			System.out.println("未读邮件数目："+folder.getUnreadMessageCount());
			
			for(int i=0;i<messages.length;i++) {
				Mail mail = new Mail();
				
			    HandleReceivedMail handleOneMail = new HandleReceivedMail((MimeMessage) messages[i]);
//			    System.out.println("Message "+ i + " :" + handleOneMail.isNew());
//			    System.out.println("Message "+ i + " : 主题："+handleOneMail.getSubject());
//			    System.out.println("Message "+ i + " : 时间："+handleOneMail.getSendDate());
//			    System.out.println("Message "+ i + " : 发件人："+handleOneMail.getFrom());
//			    System.out.println("Message "+ i + " : Message-ID："+handleOneMail.getMessageID());
//			    System.out.println("Message "+ i + " : 回执："+handleOneMail.getReplySign());
			    handleOneMail.getMailContent((Part)messages[i]);
//			    System.out.println("Message "+ i + " : 正文："+handleOneMail.getBodyText());
//			    System.out.println("Message "+ i + " : 附件："+handleOneMail.isContainAttach((Part)messages[i]));
//			    System.out.println();
			    mail.setItem(handleOneMail.getMessageID());
			    mail.setSender(handleOneMail.getFrom());
			    mail.setRecipient(username);
			    mail.setDate(handleOneMail.getSendDate());
			    mail.setSubject(handleOneMail.getSubject());
			    mail.setContent(handleOneMail.getBodyText());
			    list.add(mail);
			}
		
		
			folder.close(false);
			store.close();
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
		return list;
	}

}
