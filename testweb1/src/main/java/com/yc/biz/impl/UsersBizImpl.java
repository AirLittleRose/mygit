package com.yc.biz.impl;

import java.util.List;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.dao.UsersDao;
import com.yc.dao.impl.UsersDaoImpl;

public class UsersBizImpl implements UsersBiz {

	UsersDao ud = new UsersDaoImpl();
	
	@Override
	public Users login(Users u) {
		
		return ud.login(u);
	}

}
