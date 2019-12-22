<%--
  Created by IntelliJ IDEA.
  User: Creams
  Date: 2018/1/11
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addbook.css">
<script src="${pageContext.request.contextPath}/js/AddScript.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<head>
    <title>单本书添加</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="main_am.jpg" height="100%" width="100%"/>    
</div> 

<jsp:include page="nav.html"/>
<%
    request.setCharacterEncoding("utf-8");
    if(session.getAttribute("user") == null){
        response.sendRedirect("main.jsp");
    }
%>
<form action="BookServlet?action=addabook" onsubmit="return errorsubmit()" method="post">
    <div class="bookinfo" style="font-weight:bold">
        <div class="title">
            <span>请输入单本书信息</span>
        </div>
       
        <div>
            <span class="infotitle">书类id ： </span><input class="required" name="bookid"><span id="bookidcheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">书本位置：</span><input class="required" name="location"><span id="booklocationcheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">添加数目：</span><input class="required" name="addnumber"><span id="bookaddnumbercheck" class="error"></span>
        </div>
        <div class="button">
            <button type="submit" class="btn btn-default" name="over" value="1">完成添加</button>
        </div>
    </div>
</form>
</body>
</html>
    
