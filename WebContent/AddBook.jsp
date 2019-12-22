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
    <title>书类添加</title>
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
<form action="BookServlet?action=addBooks" onsubmit="return errorsubmit()" method="post">
    <div class="bookinfo" style="font-weight:bold">
        <div class="title">
            <span>请输入书本信息</span>
        </div>
       
        <div>
            <span class="infotitle">书本名称：</span><input class="required" name="bookname"><span id="booknamecheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">书本作者：</span><input class="required" name="bookauthor"><span id="bookauthorcheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">出版单位：</span><input class="required" name="bookpublisher"><span id="bookpublishercheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">书本类目：</span><input class="required" name="bookcategory"><span id="bookcategorycheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">书本库存：</span><input class="required" name="bookstore" ><span id="bookstorecheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">所在位置：</span><input class="required" name="booklocation" ><span id="booklocationcheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">书本详情：</span><textarea name="bookdesc"></textarea><span id="bookdesccheck" class="error"></span>
        </div>
        <div class="button">
            <button type="submit" class="btn btn-default" name="over" value="1">完成添加</button>
        </div>
    </div>
</form>
</body>
</html>
    
