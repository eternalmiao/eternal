package cn.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import cn.bean.Mail;
import cn.bean.TokenCount;
import cn.dao.TokenCountDao;

public class BayesFilter {
	// 统计垃圾邮件出现的次数
	private int spamNumber = 0;
	// 统计正常邮件出现的次数
	private int normalNumber = 0;
	List<String> ham = new ArrayList<String>();
	List<String> spam = new ArrayList<String>();
	Map<String, TokenCount> tokenMap = new HashMap<String, TokenCount>();
	
	public TokenCountDao td;
	
	public TokenCountDao getTd() {
		return td;
	}

	public void setTd(TokenCountDao td) {
		this.td = td;
	}


	public void pretreat() {

		FileIO io = new FileIO();
		String mailFile = null;
		List<String> list = io.getContentFromFile("trec06c/full/index");
		for(int i=0; i<list.size(); i++) {
			String mailContent = null;
			if(list.get(i).startsWith("Spam") || list.get(i).startsWith("SPAM")) {
				spamNumber++;
				mailFile = list.get(i).replaceAll("Spam", "").replaceAll("SPAM", "").replace("..", "trec06c").trim();
				mailContent = io.getMail(mailFile).replaceAll("[a-zA-Z0-9]", "");
				spam.add(mailContent);
			} else {
				normalNumber++;
				mailFile = list.get(i).replaceAll("Ham", "").replaceAll("HAM", "").replace("..", "trec06c").trim();
				mailContent = io.getMail(mailFile).replaceAll("[a-zA-Z0-9]", "");
				ham.add(mailContent);	
			}
			

		}
		System.out.println("垃圾邮件：" + spamNumber);
		
		System.out.println("正常邮件：" + normalNumber);
		
		for(int i=0; i<spam.size(); i++) {
			List<Word> words = WordSegmenter.seg(spam.get(i));
			String token = null;
			for (Word word : words)
			{
				token = word.getText();
				tokenMap.put(token, new TokenCount(0, token, 0, 0, 0, 0, 0));
			}
		}
		
		for(int i=0; i<ham.size(); i++) {
			List<Word> words = WordSegmenter.seg(ham.get(i));
			String token = null;
			for (Word word : words)
			{
				token = word.getText();
				tokenMap.put(token, new TokenCount(0, token, 0, 0, 0, 0, 0));
			}
		}
	
		System.out.println(tokenMap.size());
	
	}
	
	
	public void training() {
		System.out.println("training...");
		for(int i=0; i<spam.size(); i++) {
			System.out.println("spam[" + i + "]:");
//			System.out.print("contain:");
			for (Map.Entry<String, TokenCount> entry : tokenMap.entrySet())
			{
				
				boolean contain = filterToken(spam.get(i), entry.getKey());
				TokenCount tokenCount = entry.getValue();

				if (contain == true)
				{
					tokenCount.setSpamAdd(1);
//					System.out.print(tokenCount.getToken() + "/");
				}
				tokenCount.setSpamAllAdd(1);
			}
		}
		
		for(int i=0; i<ham.size(); i++) {
			System.out.println("ham[" + i + "]:");
//			System.out.print("contain:");
			for (Map.Entry<String, TokenCount> entry : tokenMap.entrySet())
			{
				boolean containFlag = filterToken(ham.get(i), entry.getKey());
				TokenCount tokenCount = entry.getValue();

				if (containFlag == true)
				{
					tokenCount.setNormalAdd(1);
//					System.out.print(tokenCount.getToken() + "/");
				}
				tokenCount.setNormalAllAdd(1);

			}
		}
		
		List<String> needRemoveToken = new ArrayList<String>();
		
		System.out.println("计算关键字概率:");
		// 得到每一个关键字出现的情况下是垃圾邮件的概率的概率
		for (Map.Entry<String, TokenCount> entry : tokenMap.entrySet())
		{
			TokenCount token = entry.getValue();
			System.out.println(token.getToken());
			if (token.getSpam() + token.getNormal() == 0)
			{
				needRemoveToken.add(entry.getKey());
				continue;
			}

			double Spam = 1.0 * token.getSpam() / token.getSpamAll();
			double SpamAll = 1.0 * token.getSpamAll() / (token.getSpamAll() + token.getNormalAll());
			double Normal = 1.0 * token.getNormal() / token.getNormalAll();
			double NormalAll = 1.0 * token.getNormalAll() / (token.getSpamAll() + token.getNormalAll());

			token.setProbability((Spam * SpamAll) / (Spam * SpamAll + Normal * NormalAll)); // 根据（公式2）

			if (token.getProbability() < 0.93)
			{
				needRemoveToken.add(entry.getKey());
			}
		}

		// 过滤得到所有符合要求的对垃圾邮件有较高识别度的关键词
		for (String s : needRemoveToken)
		{
			tokenMap.remove(s);
		}

		System.out.println(tokenMap.size());
		
		td.insertTokenCount(tokenMap);
//		// 查看结果
//		for (Map.Entry<String, TokenCount> entry : tokenMap.entrySet())
//		{
//			System.out.println(entry.getValue().toString());
//		}
		
	}
	
	
	public String filter(Mail mail) {
		String tag = "normal";
		tokenMap = td.findAllTokenCount();
		String subject = mail.getSubject().replaceAll("[^(\\u4e00-\\u9fa5)]", "");
		String content = mail.getContent().replaceAll("[^(\\u4e00-\\u9fa5)]", "");
		
		List<String> oneMailTokenList = new ArrayList<String>();

		for (Map.Entry<String, TokenCount> entry : tokenMap.entrySet())
		{
			spamNumber = entry.getValue().getSpamAll();
			normalNumber = entry.getValue().getNormalAll();
			boolean subjectFlag = filterToken(mail.getSubject(), entry.getKey());
			boolean contentFlag = filterToken(mail.getSubject(), entry.getKey());
			if (subjectFlag == true || contentFlag==true)
			{
				oneMailTokenList.add(entry.getKey());
			}
		}

		if (oneMailTokenList.size() <= 0)
		{
			// System.out.println("没有含有关键字,应该是正常邮件");
			return tag;
		}

		// 得到这封邮件所有关键词的联合概率,根据(公式3)
		double Pup = 1.0 * spamNumber / (spamNumber + normalNumber);
		double Pdown = 1.0f;
		for (String kw : oneMailTokenList)
		{
			Pup = Pup * tokenMap.get(kw).getSpam() / tokenMap.get(kw).getSpamAll();
			Pdown = Pdown * (tokenMap.get(kw).getSpam() + tokenMap.get(kw).getNormal()) / (spamNumber + normalNumber);
		}
		double Pmail = Pup / (Pup + Pdown);

		System.out.println("该封邮件是垃圾邮件的概率为:" + Pmail);
		
		if(Pmail > 0.8) {
			tag = "spam";
		}
		
		return tag;
		
	}
	
	private static boolean filterToken(String content, String token)
	{
		boolean flag = false;

		if (content.toLowerCase().indexOf(token.toLowerCase()) >= 0)
		{
			flag = true;
		}

		return flag;
	}

}
