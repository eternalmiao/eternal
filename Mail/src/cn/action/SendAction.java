package cn.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.User;
import cn.util.SendMailBySSL;

public class SendAction extends ActionSupport{
	private String server = "smtp.qq.com";
	private String port = "465";
	
	private String recipent;
	private String subject;
	private String content;
	
	public String getRecipent() {
		return recipent;
	}
	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");					
		List<String> recipients = new ArrayList<String>();
		recipients.add(recipent);
		List<String> attachmentNames = new ArrayList<String>();
//		attachmentNames.add("");
		
		SendMailBySSL sendMailBySSL = new SendMailBySSL(server, port,
				user.getEmail(), user.getPassword(), recipients, subject, content,
				attachmentNames);
	
		try {
			sendMailBySSL.sendMail();
		} catch (Exception e) {
			return "error";
		}
		
		return super.execute();
	}
}
