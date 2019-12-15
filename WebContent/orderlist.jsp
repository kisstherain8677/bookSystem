<%@page import="com.gyf.bookstore.model.Outlist"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				
				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单查询
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td style="padding:20px"><p>以下为${user.username}同学的借书记录</p>
								<table width="100%" border="0" cellspacing="0" class="tableopen">
									<tr>
										<td bgcolor="#A3E6DF" class="tableopentd01">图书号码</td>
										<td bgcolor="#A3D7E6" class="tableopentd01">书名</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">借阅时间</td>
										<td bgcolor="#A3E2E6" class="tableopentd01">操作</td>
									</tr>

                                    <%for(int i=0;i<2;i++){ %>
                                    <%ArrayList<Outlist> joutlist=(ArrayList<Outlist>)session.getAttribute("outlists"); %>
									<tr>
										<td class="tableopentd02"><%=joutlist.get(i).getAbookid()%></td>
										<td class="tableopentd02"><%=joutlist.get(i).getBookname()%></td>
										<td class="tableopentd02"><%=joutlist.get(i).getBorrowdate()%></td>
										<td class="tableopentd03"><a href="orderInfo.jsp">查看</a>&nbsp;&nbsp;
											<a href="#">刪除</a>
										</td>
									</tr>
									<%} %>
									
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" />
				</td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a>
				</td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>
