package com.gyf.bookstore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.gyf.bookstore.exception.UserException;
import com.gyf.bookstore.model.User;
import com.gyf.bookstore.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	  //检验验证码
    	  //获取表单中的验证码
    	  String checkcode_client=request.getParameter("checkcode");
    	  String checkcode_session=(String)request.getSession().getAttribute("checkcode_session");
    	  if(!checkcode_client.equals(checkcode_session)) {
    		  //验证码不一致,跳回注册页面
    		  request.setAttribute("checkcode_err", "验证码错误");
    		  request.getRequestDispatcher("/register.jsp").forward(request, response);
    		  return;
    	  }
    	  
    	 //1.把参数转为Bean和model
    	  User user = new User();
    	  try {
			BeanUtils.populate(user, request.getParameterMap());//生成usermodel
			System.out.println(user.toString());
			
			//设置默认信息ֵ
			user.setActiveCode(UUID.randomUUID().toString());
			user.setRole("普通用户");
			user.setRegisterTime(new Date());
			
			System.out.println(user.toString());
			
			//2.添加数据项
	    	  UserService userService = new UserService();
	    	  userService.register(user);
	    	  
	    	 //3.结果显示
	    	 //3.1注册成功
    	     request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
    	  
    	  } catch (UserException e) {
			  e.printStackTrace();
			//3.2注册失败
			  request.setAttribute("register_err", e.getMessage());
			  request.getRequestDispatcher("/register.jsp").forward(request, response);
		    }
    	  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("����ת��ģ��ʧ��");
			e.printStackTrace();
		} 
    	 
    }
}


//WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.

