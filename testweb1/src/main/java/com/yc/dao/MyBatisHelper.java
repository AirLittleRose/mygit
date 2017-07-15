package com.yc.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {
	
	 private static SqlSessionFactory sessionFactory;
	 
	   static{
	    	try {
				//Reader reader;			
				//加载mybatis 的配置文件及其映射文件，返回一个流
				//reader = Resources.getResourceAsReader("mybatisConfiguration.xml");
				//构建SqlSession 的工厂  ：SqlSession  -》 相当于jdbc中的connection
	    		
	    		String resource = "mybatisConfiguration.xml";
	    		InputStream inputStream = Resources.getResourceAsStream(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
		    	
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	   
	   public static SqlSession getSession() throws Exception {
		 //创建能执行映射文件中的SQL 的SqlSession   由工厂来创建SqlSession
		   SqlSession session = sessionFactory.openSession();
		return session;
		   
	   }
}
