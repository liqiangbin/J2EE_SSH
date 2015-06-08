<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>注册页面</title>
	</head>
	<body>
	<table width="70%" height="100" border="1" align="center">

		<tr>
			<td width="20%" height="25" align="center">ID</td>
			<td width="30%" align="center">Name</td>
			<td width="30%" align="center">电话</td>
			<td width="10%" align="center">操作</td>
		</tr>
		<s:iterator value="#request.list" id="cus">
			<tr>
				<td><s:property value="#cus.customerId" />
				</td>
				<td><s:property value="#cus.name" />
				</td>
				<td><s:property value="#cus.phone" />
				</td>
					<td><a href="cusAction_delete.action?customer.customerId=<s:property value="#cus.customerId" />">Delete</a>
				</td>
			</tr>
		</s:iterator>

	</table>
</body>
</html>
