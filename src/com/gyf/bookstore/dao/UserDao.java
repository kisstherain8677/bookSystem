package com.gyf.bookstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gyf.bookstore.model.User;
import com.gyf.bookstore.utils.C3P0Utils;
import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDao {
	
	/**
	 * ���һ���û�
	 * @param user
	 * @throws SQLException 
	 */
	public void addUser(User user) throws SQLException {
		//1.获取QueryRunner
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
	    //sql
		String sql="insert into user";
		sql+=" (userid,username,major,role,password)";
	    sql+=" values(?,?,?,?,?)";
	    
	    //得到sql语句
	    List<Object> list= new ArrayList<Object>();
	    list.add(user.getUserid());
	    list.add(user.getUsername());
	    list.add(user.getRole());
	    list.add(user.getPassword());
	    
	    //ִ执行sql语句
	    qr.update(sql,list.toArray());
	}
	
	//根据用户名和密码查找用户
	public User findUserByUsernameAndid(String username,String userid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		
		String sql="select * from user where username=? and userid=?";
		return qr.query(sql, new BeanHandler<User>(User.class),username,userid);
		
	}
	
	
	public User findUserByUseridAndPassword(String userid,String password) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		
		String sql="select * from user where userid=? and password=?";
		return qr.query(sql, new BeanHandler<User>(User.class),userid,password);
		
	}

}
