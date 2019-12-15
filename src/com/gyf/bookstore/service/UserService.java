package com.gyf.bookstore.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gyf.bookstore.dao.ListDao;
import com.gyf.bookstore.dao.UserDao;
import com.gyf.bookstore.exception.UserException;
import com.gyf.bookstore.model.Outlist;
import com.gyf.bookstore.model.User;
import com.sun.javafx.binding.StringFormatter;
import com.sun.mail.imap.protocol.ID;

public class UserService {

	UserDao userDao=new UserDao();
	ListDao listDao=new ListDao();
	public void register(User user)throws UserException {
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("注册失败，用户名重复");
		}
	}
	
	public User login(String username,String userid) throws UserException {
		try {
			//1.查询
			User user=userDao.findUserByUsernameAndPassword(username, userid);
		    
			//2.判断
			if(user==null) {
				throw new UserException("找不到相关信息");
			}
			//激活判断
			
			//无问题返回
			return user;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("查询用户信息失败");
		}
	}
	
	//查找借阅信息
	

	public ArrayList<Outlist> getList(String userid) throws UserException {
		try {
			ArrayList<Outlist> list=listDao.findListByUserid(userid);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("查询借阅信息失败");
		}
	}

	
}
