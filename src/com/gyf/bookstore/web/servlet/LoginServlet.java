package com.gyf.bookstore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyf.bookstore.exception.UserException;
import com.gyf.bookstore.model.Outlist;
import com.gyf.bookstore.model.User;
import com.gyf.bookstore.service.UserService;
import com.sun.javafx.binding.StringFormatter;

@WebServlet("/login")//action请求中指定的路径
public class LoginServlet extends HttpServlet {
      @Override
      //处理发出的post请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	 
    	  //获取请求参数 
    	String username=request.getParameter("username");
    	String userid=request.getParameter("userid");
    	//调用service
    	UserService us=new UserService();
   
    	try {
			User user=us.login(username, userid);
			
			ArrayList<Outlist>outlists=new ArrayList<Outlist>();
			outlists=us.getList(userid);
					
			//登录成功，根据角色选择跳转页面
			String path;
			if("管理员".equals(user.getRole())) {
				path="/admin/login/home.jsp";
			}else {
				path="/orderlist.jsp";
			}
			
			//把user保存到session（记录在服务端的用户信息）
			request.getSession().setAttribute("user", user);
            
			//把user的借阅信息保存到session
			request.getSession().setAttribute("outlists", outlists);
			//打印结果
			System.out.println(outlists.get(0).getBorrowdate());
			
			response.sendRedirect(request.getContextPath()+path);//重定向解决表单重复提交
    	} catch (UserException e) {
			// 登录失败，回到登录页面
			e.printStackTrace();
			request.setAttribute("login_msg", "姓名或学号错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
    	
      }
}


//WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.

