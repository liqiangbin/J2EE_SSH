<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
   
</head>
<body>
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>待填写教学进度表信息</h2></caption>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
     <% List<Sortprogress> list=(List<Sortprogress>)session.getAttribute("nofillteaching"); %>
	     <%for(int i=0;i<list.size();i++){ %>
    <tr>
    	<td><%=list.get(i).getCid() %></td>
    	<td width="15%" align="center">
				<%List<Course> course =(List<Course>)session.getAttribute("courselist");
				String name=null;
				String id=list.get(i).getCid();
				for(int m=0;m<course.size();m++){
				if(id.equals(course.get(m).getId())){
				
				name=course.get(m).getName();
				break;
				}}
				%>
				<%=name %>
				</td>
    	<td>未填写</td>
    	<td>
            	<a href="#">填写教学进度表</a>
            </td>
        </tr>	
        <%} %>
</table>
</body>
</html>
