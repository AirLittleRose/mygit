package com.yc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 494757538394312548L;
	protected String op;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		op =req.getParameter("op");
		super.service(req, resp);
	}

	@Override//这是get
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * 只能用于gson解析非泛型数据
	 * @param obj
	 * @param resp
	 * @throws IOException
	 */
	protected void outJson(Object obj, HttpServletResponse resp) throws IOException{
		Gson gson = new Gson();
		String jsonstr = gson.toJson(  obj);	//gson读取不出泛型数据
		outJsonStr(jsonstr, resp);
	}

	public void outJsonStr(String jsonstr, HttpServletResponse resp) throws IOException {

		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(jsonstr);
		out.flush();
		out.close();
	}
	
	
}
