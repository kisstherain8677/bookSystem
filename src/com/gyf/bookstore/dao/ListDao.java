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
	//借书，增加一条借阅记录
	public void addList(String userid,String abookid) throws SQLException {
		//1.获取QueryRunner
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
	    //sql
		String sql="insert into outlist";
		sql+=" (userid,abookid,borrowDate)";
	    sql+=" values(?,?,curdate())";
	    
	    //得到sql语句	
	    List<Object> list= new ArrayList<Object>();
	    list.add(userid);
	    list.add(abookid);	    
	    //ִ执行sql语句
	    qr.update(sql,list.toArray());
	}
	
	//还书，删除一条借阅记录
	public int removeList(String abookid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());		
		String sql="delete from outlist where abookid=?";
	    //ִ执行sql语句
	    return qr.update(sql,abookid);
	}
	
	//根据学号查找借书记录,以ArrayList的形式返回
	public ArrayList<Outlist> findListByUserid(String userid) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		
		String sql="select outlist.abookid,bookname,borrowdate from outlist "
				+ "join abook on outlist.abookid=abook.abookid join books on "
				+ "abook.bookid=books.bookid where userid=?;";
	    ArrayList<Outlist> outlists=new ArrayList<Outlist>();
	    outlists=(ArrayList<Outlist>) qr.query(sql, new BeanListHandler<Outlist>(Outlist.class),userid);
	    return outlists;
		//return qr.query(sql, new BeanHandler<Outlist>(User.class),userid);
	}

}
