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
	
	public User search_stu(String username,String userid) throws UserException {
		try {
			//1.查询
			User user=userDao.findUserByUsernameAndid(username, userid);
		    
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
	
	
	
	public User login(String userid,String password) throws UserException {
		try {
			//1.查询
			User user=userDao.findUserByUseridAndPassword(userid, password);
		    
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
	
	public void borrow(String userid,String abookid) throws UserException {
		try {
			listDao.addList(userid, abookid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException("借阅失败!\n该书已被借阅\n或学号书号不正确");
		}
	}
	
	public void returnBook(String abookid) throws UserException {
		try {
			if(listDao.removeList(abookid) == 0)
			{
				throw new UserException("归还失败!\n该书在馆\n或书号不正确");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException("Unknown mistake");
		}
	}

	
}
