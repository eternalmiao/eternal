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
		

		         
		// ʹ��Properties������Session����  
		Session session = Session.getInstance(props);
		session.setDebug(false);
		
		
		try {
			Store store = session.getStore(protocal);
			store.connect(pop3Server,username, password);
			
			//��ȡ�ռ���  
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);  //��ֻ��Ȩ�޴��ռ���  
			
			
			/**
			 * Folder.READ_ONLY����ʾֻ��Ȩ�ޡ�
			 * Folder.READ_WRITE����ʾ�����޸Ĳ���ȡ�ʼ����е��ʼ���
			 **/
			             
			//��ȡ�ռ����е��ʼ�
			Message[] messages = folder.getMessages();
			System.out.println("�ܵ��ʼ���Ŀ��"+messages.length);
			System.out.println("���ʼ���Ŀ��"+folder.getNewMessageCount());
			System.out.println("δ���ʼ���Ŀ��"+folder.getUnreadMessageCount());
			
			for(int i=0;i<messages.length;i++) {
				Mail mail = new Mail();
				
			    HandleReceivedMail handleOneMail = new HandleReceivedMail((MimeMessage) messages[i]);
//			    System.out.println("Message "+ i + " :" + handleOneMail.isNew());
//			    System.out.println("Message "+ i + " : ���⣺"+handleOneMail.getSubject());
//			    System.out.println("Message "+ i + " : ʱ�䣺"+handleOneMail.getSendDate());
//			    System.out.println("Message "+ i + " : �����ˣ�"+handleOneMail.getFrom());
//			    System.out.println("Message "+ i + " : Message-ID��"+handleOneMail.getMessageID());
//			    System.out.println("Message "+ i + " : ��ִ��"+handleOneMail.getReplySign());
			    handleOneMail.getMailContent((Part)messages[i]);
//			    System.out.println("Message "+ i + " : ���ģ�"+handleOneMail.getBodyText());
//			    System.out.println("Message "+ i + " : ������"+handleOneMail.isContainAttach((Part)messages[i]));
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
