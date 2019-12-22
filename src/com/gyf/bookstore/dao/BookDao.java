package com.gyf.bookstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.SqlDataResult;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gyf.bookstore.model.ABook;
import com.gyf.bookstore.model.Book;
import com.gyf.bookstore.model.Outlist;
import com.gyf.bookstore.model.User;
import com.gyf.bookstore.utils.C3P0Utils;
import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class BookDao
{

    /**
     * ���һ���û�
     *
     * @param
     * @return
     * @throws SQLException
     */

    //获取每个书类
    public ArrayList<Book> getAllBook()
        throws SQLException
    {
        //1.获取QueryRunner
        System.out.print("this is get all book");
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql
        String sql = "select * from books";
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList = (ArrayList<Book>)qr.query(sql, new BeanListHandler<Book>(Book.class));
        System.out.print(bookList.get(0).getBookName());
        return bookList;
    }

    //获取每一本书
    public ArrayList<ABook> getAllABook()
        throws SQLException
    {
        //1.获取QueryRunner
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql
        String sql = "select abookid,abook.bookid,bookname,location,status from abook join books on abook.bookid=books.bookid ";
        ArrayList<ABook> bookList = new ArrayList<ABook>();
        bookList = (ArrayList<ABook>)qr.query(sql, new BeanListHandler<ABook>(ABook.class));
        return bookList;
    }

    //添加一个书类
    public void addBooks(Book book)
        throws SQLException
    {
        //1.获取QueryRunner
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql

        String sql = "insert into books";
        sql += " (bookname,author,publisher,category,description,initlocation)";
        sql += " values(?,?,?,?,?,?)";

        //得到sql语句
        List<Object> list = new ArrayList<Object>();
        list.add(book.getBookName());
        list.add(book.getAuthor());
        list.add(book.getPublisher());
        list.add(book.getCategory());
        list.add(book.getDescription());
        list.add(book.getInitlocation());
        //ִ执行sql语句
        qr.update(sql, list.toArray());
        //得到刚插入书类的bookid
        String sql2 = "select * from books order by bookId DESC limit 1;";
        List<Book> all_book = qr.query(sql2, new BeanListHandler<Book>(Book.class));
        ABook abook = new ABook();
        abook.setBookId(all_book.get(0).getBookId());
        abook.setLocation(book.getInitlocation());
        abook.setStatus("0");

        for (int i = 0; i < book.getNum(); i++)
        {
            addABook(abook, 1);
        }

    }

    //添加一本书
    public void addABook(ABook abook, int num)
        throws SQLException
    {
        //1.获取QueryRunner
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql
        for (int i = 0; i < num; i++)
        {
            String sql = "insert into abook";
            sql += " (bookid,location)";
            sql += " values(?,?)";

            //得到sql语句
            List<Object> list = new ArrayList<Object>();
            list.add(abook.getBookId());
            list.add(abook.getLocation());

            //ִ执行sql语句
            qr.update(sql, list.toArray());
        }

    }

    public Book QueryBookById(String id)
        throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql
        String sql = "select * from books where bookid=?";

        Book book = (Book)qr.query(sql, new BeanHandler<Book>(Book.class), id);

        return book;
    }

    public ABook QueryABookById(String id)
        throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql
        String sql = "select abookid,abook.bookid,bookname,location,status from abook join books on abook.bookid=books.bookid where abookid=?";
        ABook book = (ABook)qr.query(sql, new BeanHandler<ABook>(ABook.class), id);
        System.out.println("this is dao querybookbyid" + book.getStatus());
        return book;
    }

    public void DeleteById(String id)
        throws SQLException
    {
        //1.获取QueryRunner
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql

        //删除所有这一类书
        String sql2 = "delete from abook where bookid=?";
        qr.update(sql2, id);

        String sql = "delete from books where bookid=?";
        //ִ删除书类
        qr.update(sql, id);

    }

    public void DeleteABookById(String abookId)
        throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //sql
        String sql = "delete from abook where abookid=?";
        qr.update(sql, abookId);
    }

    public void EditDone(Book book)
        throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "UPDATE Books SET bookName=?,author=?,publisher=?,category=?,description=? WHERE bookid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(book.getBookName());
        list.add(book.getAuthor());
        list.add(book.getPublisher());
        list.add(book.getCategory());
        list.add(book.getDescription());
        list.add(book.getBookId());
        qr.update(sql, list.toArray());

    }

    public void EditABookDone(ABook book)
        throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "UPDATE abook SET location=?,status=? WHERE abookid=?";
        List<Object> list = new ArrayList<Object>();
        list.add(book.getLocation());
        list.add(book.getStatus());
        list.add(book.getaBookId());
        qr.update(sql, list.toArray());

    }

    public ArrayList<Outlist> getoutlist()
        throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM OUTLIST";
        ArrayList<Outlist> outlist = (ArrayList<Outlist>)qr.query(sql, new BeanListHandler<>(Outlist.class));
        return outlist;
    }
}
