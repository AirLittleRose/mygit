package com.yc.web.servlets;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil <T> {
	
	public static <T> T getParameter( Map<String,Object> maprequest,Class<T> c) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//根据c来创建一个对象   这个对象用于存 request中所有的值
				T obj = c.newInstance();
				
				//取出c中的所有方法
				List<Method> setMethods = getAllSetMethods(c);
				//将setMethods中的每个方法的set 去掉，并将首字母转小写，存到一个集合中  setUname  -->  uname
				List<String> params = getAllParameters(setMethods);
				for(	String p : params){
					if( maprequest.get(  p)==null){
						continue;
					}
					String value = maprequest.get(  p ).toString();
					if(value!=null && !"".equals(value)){
						for(	Method m:setMethods){
							
							if(	m.getName().equalsIgnoreCase("set"+p)	){
								//还需判断  m 这个setXXX(参数类型)
								//判断参数的类型
								@SuppressWarnings("rawtypes")
								Class typeClass = m.getParameterTypes()[0];//因为set方法是标准的 javabean方法，他的参数有且只有一个
								String typeClassName = typeClass.getName();
								if("int".equals(typeClassName) || "java.lang.Integer".equals(typeClassName) ){
									int v = Integer.parseInt(value);
									m.invoke(obj, v);
								}else if("Float".equals(typeClassName) || "java.lang.Float".equals(typeClassName) ){
									float v = Float.parseFloat(value);
									m.invoke(obj, v);
								}else if("Double".equals(typeClassName) || "java.lang.Double".equals(typeClassName) ){
									double v = Double.parseDouble(value);
									m.invoke(obj, v);
								}else{
								m.invoke(obj, value);//u.setUname(  xxx );
								}
							}
							}
						}
				}
		return obj;
		
	}
	/**
	 * 从request中取出所有参数，将参数 值存到一个object对象中
	 * @param request
	 * @param c
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static <T> T getParameter( HttpServletRequest request,Class<T> c) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//根据c来创建一个对象   这个对象用于存 request中所有的值
		T obj = c.newInstance();
		
		//取出c中的所有方法
		List<Method> setMethods = getAllSetMethods(c);
		//将setMethods中的每个方法的set 去掉，并将首字母转小写，存到一个集合中  setUname  -->  Uname
		List<String> params = getAllParameters(setMethods);
		
		//从request中取出所有的参数
		//request.getParameterMap();
		for(	String p : params){
			String value = request.getParameter(p);
			if(value!=null && !"".equals(value)){
				for(	Method m:setMethods){
					//判断是哪一个set方法要运行起来
					if(	m.getName().equalsIgnoreCase("set"+p)	){
						//还需判断  m 这个setXXX(参数类型)
						//判断参数的类型
						@SuppressWarnings("rawtypes")
						Class typeClass = m.getParameterTypes()[0];//因为set方法是标准的 javabean方法，他的参数有且只有一个
						String typeClassName = typeClass.getName();
						if("int".equals(typeClassName) || "java.lang.Integer".equals(typeClassName) ){
							int v = Integer.parseInt(value);
							m.invoke(obj, v);
						}else if("Float".equals(typeClassName) || "java.lang.Float".equals(typeClassName) ){
							float v = Float.parseFloat(value);
							m.invoke(obj, v);
						}else if("Double".equals(typeClassName) || "java.lang.Double".equals(typeClassName) ){
							double v = Double.parseDouble(value);
							m.invoke(obj, v);
						}else{
						m.invoke(obj, value);//u.setUname(  xxx );
						}
					}
				}
			}
		}
		return obj;
		
	}
	
	private static List<String> getAllParameters(List<Method> setMethods) {
		List<String> list = new ArrayList<String>();
		for( Method m: setMethods){
			String pname = m.getName().substring(3, m.getName().length());
			pname = pname.substring(0, 1).toLowerCase()+pname.substring(1);
			list.add(pname);
		}
		return list;
	}

	/**
	 * 取出一个类里面的所有的set方法
	 * @param c
	 * @return
	 */
	private static <T> List<Method> getAllSetMethods(Class<T> c){
		List<Method> setMethods = new ArrayList<Method>();
		if(	c!=null){
			Method [] ms = c.getMethods();//取出user类中所有的方法,但是只需要set
			for( Method m :ms){
				if(  m.getName().startsWith("set")  ){//如果方法名以set开头，则保存到 setMethods中
					setMethods.add(  m);
				}
			}
		}
		
		return setMethods;
		
	}

	/**
	 * 取出一个类里面的所有的get方法
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unused")
	private static <T> List<Method> getAllGetMethods(Class<T> c){
		List<Method> getMethods = new ArrayList<Method>();
		if(	c!=null){
			Method [] ms = c.getMethods();//取出user类中所有的方法,但是只需要set
			for( Method m :ms){
				if(  m.getName().startsWith("get")  ){//如果方法名以set开头，则保存到 setMethods中
					getMethods.add( m );
				}
			}
		}
		
		return getMethods;
		
	}
}
