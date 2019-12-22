<%@ page import="java.util.ArrayList" %>
<%@page import="com.gyf.bookstore.model.Outlist" %><%--
  Created by IntelliJ IDEA.
  User: Creams
  Date: 2018/1/18
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<html>
<head>
    <title>待还图书列表</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
    if(session.getAttribute("user") == null){
        response.sendRedirect("index.jsp");
    }
%>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="main_am.jpg" height="100%" width="100%"/>    
</div> 
<jsp:include page="nav.html"/>
<table class="table" style="font-weight:bold">
    <thead>
    <tr>
    <tr>
        <th>书本编号</th>
        <th>读者学号</th>
        <th>借阅时间</th>
    </tr>
    </tr>
    </thead>
    <tbody>
        <%
        ArrayList<Outlist> loglist = (ArrayList<Outlist>)session.getAttribute("outlist");
        if(loglist!=null && loglist.size() > 0)
        {
            for(int i = loglist.size() - 1; i >= 0 ; i--)
            {
                Outlist log = loglist.get(i);
    %>
    <tr>
        <td><%=log.getAbookId()%></td>
        <td><%=log.getUserId()%></td>
        <td><%=log.getBorrowDate()%></td>
    </tr>
        <%
            }
        }
    %>
</body>
</html>
