package com.courage.ccu_monitor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.courage.ccu_monitor.model.Account;
import com.courage.ccu_monitor.model.UserMsg;


public interface UserMsgManage {

	public int addUserMsg(UserMsg uMsg);
	
	public int removeUseMsg(int id);
	
	public int modifyUserMsg(UserMsg uMsg);
	
	public List<UserMsg> getListUserMsg();
	
	public int addAccount(Account ac);

	public int removeAccount(int id);
	
	public int modifyAccount(Account ac);
	
	public List<Account> getListAccount();
}
