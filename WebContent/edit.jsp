<%@ page import="com.gyf.bookstore.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Creams
  Date: 2018/1/14
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<%
    request.setCharacterEncoding("utf-8");
    if(session.getAttribute("user") == null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
<head>
    <title>图书编辑</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="main_am.jpg" height="100%" width="100%"/>    
</div> 
<jsp:include page="nav.html"/>
<%
    Book book = (Book)session.getAttribute("resultbook");
%>
<form action="BookServlet?action=editdone" method="post">
    <div class="detail">
        <div class="title">
            <span>编辑图书详情信息</span>
        </div>
        <div>
            <span class="infotitle">书本编号：</span><input  value="<%=book.getBookId()%>" readonly="readonly" disabled>
            <input type="hidden" name="id" value="<%=book.getBookId()%>" >
        </div>
        <div>
            <span class="infotitle">书本名称：</span><input name="name" value="<%=book.getBookName()%>">
        </div>
        <div>
            <span class="infotitle">书本作者：</span><input name="author" value="<%=book.getAuthor()%>">
        </div>
        <div>
            <span class="infotitle">出版单位：</span><input name="publisher" value="<%=book.getPublisher()%>">
        </div>
        <div>
            <span class="infotitle">书本类目：</span><input name="category" value="<%=book.getCategory()%>">
        </div>
        <div>
            <span class="infotitle">书本库存：</span><input name="store" value="<%=book.getRestNum()%>" readonly="readonly"disabled>
        </div>
        <div>
            <span class="infotitle">书本详情：</span><textarea name="desc"><%=book.getDescription()%></textarea>
        </div>
        <div class="button">
            <button type="submit" class="btn btn-success" name="over" value="1">编辑完成</button>
            <a href="BookServlet?action=deletebyid&id=<%=book.getBookId()%>"><button type="button" class="btn btn-danger">删除书本</button></a>
            <a href="BookServlet?action=getall"><button type="button" class="btn btn-info">返回总表</button></a>
        </div>
    </div>
</form>
</body>
</html>
