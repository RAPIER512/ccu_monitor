package com.courage.ccu_monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courage.ccu_monitor.dao.AccountMapper;
import com.courage.ccu_monitor.dao.UserMsgMapper;
import com.courage.ccu_monitor.model.Account;
import com.courage.ccu_monitor.model.UserMsg;
import com.courage.ccu_monitor.service.UserMsgManage;
@Service
public class UserMsgManageImpl implements UserMsgManage {

	@Autowired
	UserMsgMapper uMsgm;
	
	@Autowired
	AccountMapper am;
	
	public int addUserMsg(UserMsg uMsg) {
		return uMsgm.insert(uMsg);
	}

	public int removeUseMsg(int id) {
		return uMsgm.deleteByPrimaryKey(id);
	}

	public int modifyUserMsg(UserMsg uMsg) {
		return uMsgm.updateByPrimaryKeySelective(uMsg);
	}

	public List<UserMsg> getListUserMsg() {
		return uMsgm.selectAll();
	}

	public int addAccount(Account ac) {
		return am.insert(ac);
	}

	public int removeAccount(int id) {
		return am.deleteByPrimaryKey(id);
	}

	public int modifyAccount(Account ac) {
		return am.updateByPrimaryKeySelective(ac);
	}

	public List<Account> getListAccount() {
		return am.getAllAccount();
	}
}
