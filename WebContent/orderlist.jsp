<%@page import="com.gyf.bookstore.model.Outlist"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

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
									</tr>
									 <%ArrayList<Outlist> joutlist=(ArrayList<Outlist>)session.getAttribute("outlists"); %>
									<%int listLength=joutlist.size(); %>
                                    <%for(int i=0;i<listLength;i++){ %>                                  
									<tr>
										<td class="tableopentd02"><%=joutlist.get(i).getAbookid()%></td>
										<td class="tableopentd02"><%=joutlist.get(i).getBookname()%></td>
										<td class="tableopentd02"><%=joutlist.get(i).getBorrowdate()%></td>										
									</tr>
									<%} %>
									<tr></tr>
									<tr>
									    <td></td>
									    <td style="text-align:center;vertical-align:middle;"><a href="borrow.jsp">借阅</a></td>
									    <td style="text-align:center;vertical-align:middle;"><a href="return.jsp">归还</a></td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



</body>
</html>
