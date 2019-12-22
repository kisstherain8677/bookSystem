<%@ page import="com.gyf.bookstore.dao.BookDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gyf.bookstore.model.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: Creams
  Date: 2017/12/2
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<%
    request.setCharacterEncoding("utf-8");
    if(session.getAttribute("user") == null){
        response.sendRedirect("main.jsp");
    }
    ArrayList<Book> booklist = (ArrayList<Book>)session.getAttribute("allbooklist");
%>
<head>
    <title>图书管理</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="main_am.jpg" height="100%" width="100%"/>    
</div> 
<jsp:include page="nav.html"/>
<table class="table" style="font-weight:bold">
    <thead>
    <tr>
        <th>书本编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>类目</th>
        <th>库存总量</th>
        <th>借出数量</th>
        <th>剩余数量</th>
        <th>所在位置(柜号)</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(booklist!=null && booklist.size() > 0)
        {
            for(int i = 0; i < booklist.size(); i++)
            {
                Book b = booklist.get(i);
    %>
    <tr>
        <td><%=b.getBookId()%></td>
        <td><a href="BookServlet?action=querybookbyid&id=<%=b.getBookId()%>&next=edit"><%=b.getBookName()%></a> </td>
        <td><%=b.getAuthor()%></td>
        <td><%=b.getPublisher()%></td>
        <td><%=b.getCategory()%></td>
        <td><%=b.getNum()%></td>
        <td><%=b.getNum()-b.getRestNum()%></td>
        <td><%=b.getRestNum()%></td>
        <td><%=b.getInitlocation()%></td>
        <td><a href="BookServlet?action=querybookbyid&id=<%=b.getBookId()%>&next=edit">编辑或删除</a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

</body>
</html>
