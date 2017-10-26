package cn.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class HandleReceivedMail {
	
	MimeMessage mimeMessage;
	private StringBuffer bodytext = new StringBuffer();
	
	public HandleReceivedMail(MimeMessage mimeMessage) {
		super();
		this.mimeMessage = mimeMessage;
	}
 

	public boolean isNew() {
		boolean isnew = false;
		try {
			Flags flags = mimeMessage.getFlags();
			Flags.Flag[] flag = flags.getSystemFlags();
			for(int i=0; i<flag.length; i++) {
				if (flag[i] == Flags.Flag.SEEN) {
	                isnew = true;
	                break;

	            }
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return isnew;
	}

	public String changeEncode(String str) {
        try {
             if (str == null || "".equals(str)) 
                 str = ""; 
             else
                 str = MimeUtility.decodeText(str); 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
	
	public String getSubject(){
        String subject = "";
        try {
            subject = changeEncode(mimeMessage.getSubject());
        	if(subject == null)
                subject = "";
            return subject;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	public String getSendDate(){
        try {
            Date sendDate = mimeMessage.getSentDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
            return dateFormat.format(sendDate);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
	
	public String getFrom(){
        try {
            InternetAddress[] address = (InternetAddress[]) mimeMessage.getFrom();
            String person = address[0].getPersonal();  //姓名
            if(person == null)
                person = "";
            String from = address[0].getAddress();  //地址
            if(from == null)
                from = "";
            return person+"<"+from+">";
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        return null;
    }
	
	
	public String getMessageID(){
        try {
            return mimeMessage.getMessageID();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
	
	

	public boolean getReplySign(){
	    try {
	        String[] reply = mimeMessage.getHeader("Disposition-Notification-To");
	        if(reply != null)
	            return true;  
	    } catch (MessagingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return false; 
	}  
	
	
	
	
	public void getMailContent(Part part){
        try {
            String contentType = part.getContentType();
            int nameIndex = contentType.indexOf("name");
            boolean isContainTextAttach = false;  //判断邮件中是否含有嵌套体
            if(nameIndex != -1)
                isContainTextAttach = true;
            if(part.isMimeType("text/plain") && !isContainTextAttach)
                bodytext.append((String)part.getContent());
            else if(part.isMimeType("text/html") && !isContainTextAttach)
                bodytext.append((String)part.getContent());  //对于HTML格式邮件，可以在前后加上标签<html><head>subject</head><body>bodytext</body></html>，保存为html格式文件（PS：未写）
            else if(part.isMimeType("message/rfc822"))
                getMailContent((Part) part.getContent());
            else if(part.isMimeType("multipart/*")){
                Multipart multipart = (Multipart) part.getContent();
                int count = multipart.getCount();
                for(int i=0;i<count;i++)
                    getMailContent(multipart.getBodyPart(i));
            }
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
    }
	
	

	public String getBodyText(){
	        return bodytext.toString();
	    }
	
	
	
	
	public boolean isContainAttach(Part part){
        boolean attachflag = false;  //是否有附件
        try {
            String contentType = part.getContentType();
            if(part.isMimeType("multipart/*")){
                Multipart multipart = (Multipart) part.getContent();
                for(int i=0;i<multipart.getCount();i++){
                    BodyPart bodyPart = multipart.getBodyPart(i);
                    String disposition = bodyPart.getDisposition();
                    if((disposition != null) && (disposition.equals(Part.ATTACHMENT) || disposition.equals(Part.INLINE)))
                        attachflag = true;
                    else if(bodyPart.isMimeType("multipart/*"))
                        attachflag = isContainAttach((Part)bodyPart);
                    else{
                        String bodytype = bodyPart.getContentType();
                        if(bodytype.toLowerCase().indexOf("application") !=-1)
                            attachflag = true;
                        if(bodytype.toLowerCase().indexOf("name") !=-1)
                            attachflag = true;
                    }
                     
                }
            }
            else if(part.isMimeType("message/rfc822"))
                attachflag = isContainAttach((Part)part.getContent());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
        return attachflag;
    }
	
}
