package com.gyf.bookstore.service;

import java.sql.SQLException;

import com.gyf.bookstore.dao.UserDao;
import com.gyf.bookstore.exception.UserException;
import com.gyf.bookstore.model.User;
import com.sun.javafx.binding.StringFormatter;
import com.sun.mail.imap.protocol.ID;

public class UserService {

	UserDao userDao=new UserDao();
	public void register(User user)throws UserException {
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("注册失败，用户名重复");
		}
	}
	
	public User login(String username,String password) throws UserException {
		try {
			//1.查询
			User user=userDao.findUserByUsernameAndPassword(username, password);
		    
			//2.判断
			if(user==null) {
				throw new UserException("用户名或密码错误");
			}
			//激活判断
			
			//无问题返回
			return user;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("登录失败");
		}
	}
	
}
