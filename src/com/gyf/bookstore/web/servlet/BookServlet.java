package com.gyf.bookstore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gyf.bookstore.dao.BookDao;
import com.gyf.bookstore.exception.UserException;
import com.gyf.bookstore.model.ABook;
import com.gyf.bookstore.model.Book;
import com.gyf.bookstore.model.Outlist;
import com.gyf.bookstore.model.User;
import com.gyf.bookstore.service.UserService;
import com.sun.javafx.binding.StringFormatter;


public class BookServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("getall"))
        {
            try
            {
                this.getAll(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (action.equals("addBooks"))
        {
            try
            {
                System.out.println("action:addbooks");
                this.addBooks(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (action.equals("getallbook"))
        {
            try
            {
                getAllBook(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if (action.equals("querybookbyid"))
        {
            try
            {
                QueryBookById(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if (action.equals("queryabookbyid"))
        {
            try
            {
                QueryABookById(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if (action.equals("deletebyid"))
        {
            try
            {
                DeleteById(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if (action.equals("editdone"))
        {
            try
            {
                EditDone(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (action.equals("editabookdone"))
        {
            try
            {
                EditABookDone(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if (action.equals("deleteabookbyid"))
        {
            try
            {
                DeleteABookById(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else if (action.equals("addabook"))
        {
            try
            {
                addABook(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (action.equals("getoutlist"))
        {
            try
            {
                System.out.println("action:outlist");
                this.getoutlist(request, response);
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void getoutlist(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        BookDao bdao = new BookDao();
        ArrayList<Outlist> outlist = bdao.getoutlist();
        request.getSession().setAttribute("outlist", outlist);
        request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        BookDao bdao = new BookDao();
        ArrayList<Book> bookArrayList = bdao.getAllBook();
        HttpSession session = request.getSession();
        session.setAttribute("allbooklist", bookArrayList);
        request.getRequestDispatcher("/booklist.jsp").forward(request, response);
    }

    //获取每本书的信息
    private void getAllBook(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        BookDao bdao = new BookDao();
        ArrayList<ABook> bookArrayList = bdao.getAllABook();
        HttpSession session = request.getSession();
        session.setAttribute("allabooklist", bookArrayList);
        request.getRequestDispatcher("/abooklist.jsp").forward(request, response);
    }

    private void addBooks(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        String next = request.getParameter("over");
        System.out.print(next);
        BookDao bdao = new BookDao();
        Book book = new Book();
        if (!request.getParameter("bookname").equals(""))
            book.setBookName(request.getParameter("bookname"));
        if (!request.getParameter("bookauthor").equals(""))
            book.setAuthor(request.getParameter("bookauthor"));
        if (!request.getParameter("bookpublisher").equals(""))
            book.setPublisher(request.getParameter("bookpublisher"));
        if (!request.getParameter("bookcategory").equals(""))
            book.setCategory(request.getParameter("bookcategory"));
        if (!request.getParameter("bookstore").trim().equals(""))
        {
            book.setNum(Integer.parseInt(request.getParameter("bookstore")));
            book.setRestNum(Integer.parseInt(request.getParameter("bookstore")));
        }
        if (!request.getParameter("booklocation").equals(""))
            book.setInitlocation(request.getParameter("booklocation"));

        if (!request.getParameter("bookdesc").equals(""))
            book.setDescription(request.getParameter("bookdesc"));
        if (next.equals("1"))
        {
            System.out.print("确认提交");
            System.out.print(book.getBookName());
            bdao.addBooks(book);
            response.sendRedirect(request.getContextPath() + "/BookServlet?action=getall");
        }

    }

    private void addABook(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        String next = request.getParameter("over");
        String addnumber = "0";
        System.out.print(next);
        BookDao bdao = new BookDao();
        ABook book = new ABook();
        if (!request.getParameter("bookid").equals(""))
            book.setBookId(request.getParameter("bookid"));
        if (!request.getParameter("location").equals(""))
            book.setLocation(request.getParameter("location"));

        if (!request.getParameter("addnumber").equals(""))
            addnumber = request.getParameter("addnumber");
        if (next.equals("1"))
        {
            int num = Integer.valueOf(addnumber).intValue();
            System.out.println("this is bookservlet addabook " + num);
            bdao.addABook(book, num);
            response.sendRedirect(request.getContextPath() + "/BookServlet?action=getallbook");
        }

    }

    private void QueryBookById(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        BookDao bdao = new BookDao();
        String id = request.getParameter("id");
        String next = request.getParameter("next");
        Book book = bdao.QueryBookById(id);
        HttpSession session = request.getSession();
        session.setAttribute("resultbook", book);
        PrintWriter out = response.getWriter();
        if (next.equals("check"))
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        else if (next.equals("edit"))
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        else if (next.equals("borrowcheck"))
        {
            out.write(
                book.getBookName() + "||" + book.getAuthor() + "||" + book.getPublisher() + "||" + book.getRestNum());
        }
        else if (next.equals("existcheck"))
        {
            out.write(book.getBookName());
        }
    }

    private void QueryABookById(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        BookDao bdao = new BookDao();
        String id = request.getParameter("id");
        String next = request.getParameter("next");
        ABook book = bdao.QueryABookById(id);
        HttpSession session = request.getSession();
        session.setAttribute("resultAbook", book);
        PrintWriter out = response.getWriter();
        if (next.equals("check"))
            request.getRequestDispatcher("/ABookdetail.jsp").forward(request, response);
        else if (next.equals("edit"))
            request.getRequestDispatcher("/editABook.jsp").forward(request, response);
        else if (next.equals("existcheck"))
        {
            out.write(book.getBookName());
        }
    }

    private void DeleteById(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {

        BookDao bdao = new BookDao();
        String id = request.getParameter("id");
        bdao.DeleteById(id);
        response.sendRedirect(request.getContextPath() + "/BookServlet?action=getall");
    }

    private void DeleteABookById(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {

        BookDao bdao = new BookDao();
        String id = request.getParameter("id");

        bdao.DeleteABookById(id);
        response.sendRedirect(request.getContextPath() + "/BookServlet?action=getallbook");

    }

    private void EditDone(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        String done = request.getParameter("over");
        BookDao bdao = new BookDao();
        String bookId = request.getParameter("id");
        Book book = bdao.QueryBookById(bookId);
        System.out.println(book);
        if (!request.getParameter("name").isEmpty())
            book.setBookName(request.getParameter("name"));

        if (!request.getParameter("author").isEmpty())
            book.setAuthor(request.getParameter("author"));

        if (!request.getParameter("publisher").isEmpty())
            book.setPublisher(request.getParameter("publisher"));

        if (!request.getParameter("category").isEmpty())
            book.setCategory(request.getParameter("category"));

        if (!request.getParameter("desc").isEmpty())
            book.setDescription(request.getParameter("desc"));

        if (done.equals("1"))
        {
            bdao.EditDone(book);
        }

        response.sendRedirect(request.getContextPath() + "/BookServlet?action=getall");
    }

    private void EditABookDone(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException
    {
        String done = request.getParameter("over");
        BookDao bdao = new BookDao();
        ABook book = new ABook();
        book.setaBookId(request.getParameter("id"));
        if (!request.getParameter("location").equals(""))
            book.setLocation(request.getParameter("location"));

        if (!request.getParameter("status").equals(""))
            book.setStatus(request.getParameter("status"));

        if (done.equals("1"))
        {
            bdao.EditABookDone(book);
        }

        response.sendRedirect(request.getContextPath() + "/BookServlet?action=getallbook");
    }

}

//WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.

