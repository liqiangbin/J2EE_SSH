<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="70%" height="100" border="1" align="center">

		<tr>
			<td width="20%" height="25" align="center">ID</td>
			<td width="30%" align="center">Name</td>
			<td width="30%" align="center">电话</td>
			<td width="10%" align="center">操作</td>
		</tr>
		<% List<Departmenthead> list =(List<Departmenthead>)session.getAttribute("list"); %>
		<tr>
		<td><%=list.get(0).getPhone() %></td>
		<td><%=list.get(0).getName() %></td>
		<td><%=list.get(0).getSex()%></td></tr>

	</table>
</body>
</html>