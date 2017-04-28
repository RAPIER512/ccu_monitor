package com.courage.ccu_monitor.util.mail;


public class Mail {

	public static void send(String[] toUser,String subject,String msg){
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setSubject(subject);
		mailInfo.setContent(msg);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendHtmlMail(mailInfo,toUser);// 发送html格式
	}
}
