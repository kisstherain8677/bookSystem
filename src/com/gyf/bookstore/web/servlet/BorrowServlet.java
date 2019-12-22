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
import com.gyf.bookstore.model.Outlist;
import com.gyf.bookstore.model.User;
import com.gyf.bookstore.service.UserService;


@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        // TODO Auto-generated method stub

        response.setContentType("text/html;charset=utf-8");
        //获取请求参数
        String userid = (String)request.getParameter("userid");
        String abookid = (String)request.getParameter("abookid");
        System.out.println("servlet " + userid + abookid);
        try
        {
            //BeanUtils.populate(outlist, request.getParameterMap());//生成usermodel

            System.out.println(userid + " " + abookid);

            //2.添加数据项
            UserService userService = new UserService();
            userService.borrow(userid, abookid);
            //3.结果显示
            //3.1成功

            response.getWriter().print(new String("借阅成功!"));
        }
        catch (UserException e)
        {
            //3.2失败
            response.getWriter().print(new String(e.getMessage()));
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.getWriter().write("Unknown mistake!");
        }

    }
}

//WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.

