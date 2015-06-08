<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>注册页面</title>
	</head>
	<body>
		<s:form action="cusAction_save" method="post">
			<s:textfield name="customer.customerId" label="客户编号" />
			<s:textfield name="customer.name" label="客户姓名" />
			<s:textfield name="customer.phone" label="客户电话" />
			<s:submit value="submit" />
		</s:form>
	</body>
</html>
