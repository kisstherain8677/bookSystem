<%--
  Created by IntelliJ IDEA.
  User: Creams
  Date: 2018/1/15
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/borrow.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/InfoScript.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<html>
<head>
    <title>书本借出记录登记表</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
    if (session.getAttribute("user") == null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="main_am.jpg" height="100%" width="100%"/>    
</div> 
<jsp:include page="nav.html"/>
<div class="borrowinfo" style="font-weight:bold">
    <div class="title">
        书本借出记录登记表
    </div>
<%--    <form action="/borrow" onsubmit="return errorsubmit()" method="post">--%>
        <div>
            <span class="infotitle">读者学号：</span><input type="text" onkeyup="readercheck()" name="userid"
                                                       id="userid"><span id="readeridcheck" class="error"></span>
        </div>
        <div>
            <span class="infotitle">书本编号：</span><input type="text" name="abookid" onkeyup="bookcheck()"
                                                       id="abookid"><span id="bookidcheck" class="error"></span>
        </div>
        <div class="button">
            <button type="button" class="btn btn-success" onclick="submit()">提交</button>
            <button type="reset" class="btn btn-default">重填</button>
        </div>
<%--    </form>--%>
</div>
<script>
    function submit() {
        $.post("${pageContext.request.contextPath}/borrow", {userid:$("#userid").val(), abookid:$("#abookid").val()},
            function (message) {
                alert(message);
            });
    }

</script>
</body>
</html> 
