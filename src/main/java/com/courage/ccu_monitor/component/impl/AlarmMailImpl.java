package com.courage.ccu_monitor.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.courage.ccu_monitor.component.AlarmMail;
import com.courage.ccu_monitor.dao.AlarmRecordMapper;
import com.courage.ccu_monitor.model.AlarmRecord;
import com.courage.ccu_monitor.util.Config;
import com.courage.ccu_monitor.util.mail.Mail;

@Component
public class AlarmMailImpl implements AlarmMail {

	@Autowired
	AlarmRecordMapper alarmRecor;

	@Scheduled(cron = "0 0/15 * * * ?")
	public void CheckAndSndMail() {
		List<AlarmRecord> list = alarmRecor.selectAlarmRecordByStatus(1);
		StringBuffer mailContent = new StringBuffer();
		for (AlarmRecord ar : list) {
			mailContent.append(ar.getRecord() + "" + ar.getCreteTime() + "\n");
			alarmRecor.updateByPrimaryKeySelective(new AlarmRecord(ar.getId(),
					0));
		}
		if (mailContent.length() > 0) {
			// 发送邮件给相关管理人员
			Mail.send(new String[] { Config.mail_user }, "舆情监控关键词报警",
					mailContent.toString());
		}
	}
}
