package com.courage.ccu_monitor.controller;

import com.courage.ccu_monitor.model.Account;
import com.courage.ccu_monitor.model.UserMsg;
import com.courage.ccu_monitor.service.UserMsgManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by courage on 2016/7/13.
 */
@RestController
@RequestMapping("/auth/useranage")
public class UserManageCtr {

	@Autowired
	UserMsgManage um;

	@RequestMapping(value = "/addusermsg.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int addUserMsg(UserMsg umsg) {
		return um.addUserMsg(umsg);
	}

	@RequestMapping(value = "/removeusermsg.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int removeUserMsg(int id) {
		return um.removeUseMsg(id);
	}

	@RequestMapping(value = "/modifyusermsg.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int modifyUserMsg(UserMsg umsg) {
		return um.modifyUserMsg(umsg);
	}

	@RequestMapping(value = "/getuserlist.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public List<UserMsg> getUserList() {
		return um.getListUserMsg();
	}

	// todo 根据account 获取用户的相关信息

	@RequestMapping(value = "/addaccount.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int addAccount(Account ac) {
		return um.addAccount(ac);
	}

	@RequestMapping(value = "/removeaccount.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int removeAccount(int id) {
		return um.removeAccount(id);
	}

	@RequestMapping(value = "/modifyaccount.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
	public int modifyAccount(Account ac) {
		return um.addAccount(ac);
	}

	// todo 获取账户相关信息列表

	// todo 根据account 获取账户的相关信息

}
