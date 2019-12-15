package com.gyf.bookstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gyf.bookstore.model.Outlist;
import com.gyf.bookstore.model.User;
import com.gyf.bookstore.utils.C3P0Utils;
import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ListDao {
	
	/**
	 * ���һ���û�
	 * @param user
	 * @throws SQLException 
	 */
	public void addList(User user) throws SQLException {
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
	    list.add(user.getMajor());
	    list.add(user.getRole());
	    list.add(user.getPassword());
	    
	    //ִ执行sql语句
	    qr.update(sql,list.toArray());
	}
	
	//根据学号查找借书记录,以ArrayList的形式返回
	public ArrayList<Outlist> findListByUserid(String userid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		
		String sql="select outlist.abookid,bookname,borrow_date\r\n" + 
				"from outlist join book on outlist.abookid=book.abookid join books on book.bookid=books.bookid\r\n" + 
				"where userid=?;";
	    ArrayList<Outlist> outlists=new ArrayList<Outlist>();
	    outlists=(ArrayList<Outlist>) qr.query(sql, new BeanListHandler<Outlist>(Outlist.class),userid);
	    return outlists;
		//return qr.query(sql, new BeanHandler<Outlist>(User.class),userid);
		
	}

}