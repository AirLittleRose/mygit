package com.yc.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 在web.xml中配置
 * <filter>
 * 		<filter-name> xxx </filter-name>
 * 		<filter-class> xxx.xxx.xxx </filter-class>
 * </filter>
 * <filter-mapping>
 * 		<filter-name> xxx </filter-name>
 * 		<url-pattern> *.action </url-pattern>
 * </filter-mapping>
 * 
 * 注解是 Tomcat  7 以后才支持的版本
 * @author Administrator
 *
 */
@WebFilter("*.action")
public class CharacterEncodingFilter implements Filter {
	private String encoding="utf-8";
   
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String temp = fConfig.getInitParameter("encoding");
		if(temp!=null){
			encoding=temp;
		}
	}

}
