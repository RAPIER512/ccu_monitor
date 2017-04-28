package com.courage.ccu_monitor.util.mail;


public class MailTest {

	public static void main(String[] args) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setSubject("设置邮箱标题");
		mailInfo.setContent("时间:" + System.currentTimeMillis());
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		// sms.sendTextMail(mailInfo);// 发送文体格式
		sms.sendHtmlMail(mailInfo,null);// 发送html格式
	}
}
