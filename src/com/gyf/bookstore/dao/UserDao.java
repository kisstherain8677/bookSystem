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
	    //����sql
		String sql="insert into user";
		sql+=" (username,PASSWORD,gender,email,telephone,introduce,activeCode,state,role,registTime)";
	    sql+=" values(?,?,?,?,?,?,?,?,?,?)";
	    
	    //得到sql语句
	    List<Object> list= new ArrayList<Object>();
	    list.add(user.getUsername());
	    list.add(user.getPassword());
	    list.add(user.getGender());
	    list.add(user.getEmail());
	    list.add(user.getTelephone());
	    list.add(user.getIntroduce());
	    list.add(user.getActiveCode());
	    list.add(user.getState());
	    list.add(user.getRole());
	    list.add(user.getRegisterTime());
	    
	    //ִ执行sql语句
	    qr.update(sql,list.toArray());
	}
	
	//根据用户名和密码查找用户
	public User findUserByUsernameAndPassword(String username,String password) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		
		String sql="select * from user where username=? and password=?";
		return qr.query(sql, new BeanHandler<User>(User.class),username,password);
		
	}

}
