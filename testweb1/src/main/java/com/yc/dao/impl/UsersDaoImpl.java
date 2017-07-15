package com.yc.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Users;
import com.yc.dao.MyBatisHelper;
import com.yc.dao.UsersDao;

public class UsersDaoImpl implements UsersDao {

	
	public Users login(Users u) {
		SqlSession session = null;
		Users user = null;
		try {
			session = MyBatisHelper.getSession();
			user = session.selectOne(Users.class.getName()+".login",u);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}			
		}
		return user;
	}

}
