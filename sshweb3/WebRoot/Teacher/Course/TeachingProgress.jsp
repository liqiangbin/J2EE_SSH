<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>

</head>
<body>
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>管理教学进度表信息</h2></caption>
	<thead>
	<tr>
		<th colspan="3">
		选择学期：
	<select>
		<option>显示所有</option>
		<option>2012年第一学期</option>
		<option>2012年第二学期</option>
		<option>2013年第一学期</option>
		<option>2013年第二学期</option>
	</select></th>
	<th colspan="4" align="left">
		&nbsp;&nbsp;
	<button type="button" class="btn btn-success">
               查询
            </button></th>
	</tr>
	</thead>
    <thead>
    <tr>
    	<th>进度表名称</th>
        <th>课程名称</th>
        <th>学期</th>
        <th>填写教师</th>
        <th>审核状态</th>
        <th width="20%">审核信息</th>
        <th>操作</th>
    </tr>
    </thead>
    <tr>
    	<td>J2EE编程教学进度表</td>
    	<td>J2EE编程</td>
    	<td>2010-2011第一学期</td>
    	<td>章国文</td>
    	<td>未通过</td>
    	<td>教学进度表不详细</td>
    	<td align="center">
    		&nbsp;&nbsp;<a href="#">在线编辑</a>
    	&nbsp;&nbsp;<a href="#">在线预览</a>	&nbsp;&nbsp;
    		<a href="#">下载大纲</a>	
    	</td>
    	
    </tr>
	   <tr><td colspan="7" align="center">
	   	<center>
	   	<button><a href="">新增教学进度表</a></button></center>
	   </td></tr>  
</table>
</body>
</html>
