<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*,java.text.SimpleDateFormat" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="s" uri="/struts-tags"%>
<html>

	<head>
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="Teacher/Css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="Teacher/Css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="Teacher/Css/style.css" />
		<script type="text/javascript" src="Teacher/Js/jquery.js"></script>
		<script type="text/javascript" src="Teacher/Js/jquery.sorted.js"></script>
		<script type="text/javascript" src="Teacher/Js/bootstrap.js"></script>
	<script type="text/javascript" src="Teacher/Js/bootstrap.min.js"></script>

		</style>
	</head>

	<body>
<% List<Teacher> teacher=(List<Teacher>)session.getAttribute("teacher");
String id=teacher.get(0).getDid(); %>
		<form class="form-inline definewidth m20" action="announceAction_teachersearchbydept?dept=<%=id %>" method="post">
			公告名称：
			<input type="text" name="announce.title"  class="abc input-default" placeholder="请输入关键字" >&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查&nbsp;&nbsp;询</button>
			&nbsp;&nbsp; </form>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="20%">公告发布时间</th>
					<th width="20%">公告名</th>
					<th width="40%">公告内容</th>
					<th width="20">公告类型</th>
				
				</tr>
			</thead>
			    <s:iterator value="#request.list" id="deptannounce">
			<tr>
				<td width="15" align="center"><s:property value="#deptannounce.time" />
				</td>
				<td width="20%" align="center"><s:property value="#deptannounce.title" />
				</td>
				<td width="50%" align="center"><s:property value="#deptannounce.content" />
				</td>
				<td width="15" align="center">本系公告</td>
					</tr>
	</s:iterator>
		</table>
			</body>

</html>