<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>新卡注册</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>
</head>


<body class="main">

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/register"
			method="post">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>注册新卡</h1>
						
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr align="center">
							<td></td>
							<td><font color="red">${register_err}</font></td>
							<td></tr>
							
							<tr>
								<td style="text-align:right; width:20%">学号：</td>
								<td style="width:40%">
								<input type="text" class="textinput"
									name="userid" /></td>
							</tr>
							<tr>
								<td style="text-align:right">姓名：</td>
								<td>
									<input type="text" class="textinput" name="username" />
								</td>
							</tr>
							<tr>
								<td style="text-align:right">专业：</td>
								<td><input type="text" class="textinput"
									name="major" /></td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" src="images/signup.gif" name="submit" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>
