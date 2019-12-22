<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>图书归还</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/returnpage.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/return.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="main_am.jpg" height="100%" width="100%"/>    
</div> 
<jsp:include page="nav.html"/>
<div class="returninfo">
    <div class="title">
        请输入书本编号
    </div>
    <div>
        <span class="infotitle">书本编号：</span>
        <input type="text" id="abookid" onkeyup="bookcheck()">
    </div>
    <div class="button">
        <button type="button" class="btn btn-success" onclick="submit()">提交</button>
        <button type="reset" class="btn btn-default">重填</button>
    </div>
</div>
<script>
    function submit() {
        $.post("${pageContext.request.contextPath}/return", {abookid: $("#abookid").val()},
            function (message) {
                alert(message);
            });
    }
</script>
</body>
</html>
