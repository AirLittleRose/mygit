package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.biz.impl.UsersBizImpl;
import com.yc.web.model.JsonModel;


@WebServlet("/login.action")
public class UsersAction extends BaseServlet{
	private static final long serialVersionUID = -7894226353670186739L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if(op.equals("login")){
				login(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		JsonModel jsonbean = new JsonModel();
		try {
			Users u = RequestUtil.getParameter(req, Users.class);
			
			UsersBiz ub = new UsersBizImpl();
			Users user = ub.login(u);
			jsonbean.setCode(1);
			jsonbean.setObj(user);
			HttpSession session = req.getSession();
			if(user!=null){
				session.setAttribute("user", user);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			jsonbean.setCode(0);
			jsonbean.setObj("服务器错误："+e.getMessage());
		}
		super.outJson(jsonbean, resp);
		
//		FavoriteBiz fb = new FavoriteBizImpl();
//		List<Favorite> list = fb.findFavorite(tname);
//		JsonModel jm = new JsonModel();
//		jm.setCode(1);
//		jm.setObj(list);
//		super.outJson(jm, resp);	
	}
}
