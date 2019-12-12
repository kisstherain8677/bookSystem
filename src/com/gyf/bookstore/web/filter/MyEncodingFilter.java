package com.gyf.bookstore.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


@WebFilter("/*")//�������е�����·��
public class MyEncodingFilter implements Filter{
	//����OverrideûӰ��
	public void destroy() {}
	public void init(FilterConfig config) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.����post����������������
		HttpServletRequest hsr=(HttpServletRequest)request;
		if(hsr.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		chain.doFilter(request, response);
	}
	

}