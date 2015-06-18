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
  
    <script type="text/javascript" src="Teacher/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Teacher/Js/bootstrap.js"></script>
    
</head>
<body>
<% List<Teacher> teacher=(List<Teacher>)session.getAttribute("teacher"); %>
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>管理实验进度表信息</h2></caption>
	<thead>
	<form action="testprogressAction_findByTerm?testprogress.tid=<%=teacher.get(0).getId()%>" method="post">
	<tr>
		<th colspan="3">
		选择学期：
	<select name="testprogress.term">
	<option>显示所有</option>
	<% List<Term> term=(List<Term>)session.getAttribute("term"); %>
		<%
	for(int i=0;i<term.size();i++) {%>
		<option value="<%=term.get(i).getDesc() %>"><%=term.get(i).getDesc() %></option>
		<%} %>
	</select></th>
	<th colspan="4" align="left">
		&nbsp;&nbsp;
	<button type="submit" class="btn btn-success">
               查询
            </button></th>
	</tr>
	</form>
	</thead>
    <thead>
    <tr>
    	<th>进度表名称</th>
        <th>学期</th>
        <th>审核状态</th>
        <th width="20%">审核信息</th>
        <th>操作</th>
    </tr>
    </thead>
     <% List<Testprogress> outline=(List<Testprogress>)session.getAttribute("oneTestTeaching"); 
    %>
   <%for(int i=0;i<outline.size();i++) {%>
    <%int status=outline.get(i).getStatus();
    	if(status==0) {%>
     <tr>
    	
    	<td><%=outline.get(i).getName() %></td>
    	<td><%=outline.get(i).getTerm() %></td>
    	<td>审核未通过
    	</td>
    	<td><%=outline.get(i).getMessage()%></td>
    	<td align="center">
    		<%String address=outline.get(i).getAddress(); %>
    		&nbsp;&nbsp;<a href="editword?address=<%=address%>">在线编辑</a>
    	&nbsp;&nbsp;<a href="readonly?address=<%=address%>">在线预览</a>	&nbsp;&nbsp;
    		<a href="download.action?address=<%=address%>">下载大纲</a>	
    	</td>
    </tr>
    	<%} else{%>
    	  <tr>
    	<td><%=outline.get(i).getName() %></td>
    	<td><%=outline.get(i).getTerm() %></td>
    	<td>审核已通过
    	</td>
    	<td><%=outline.get(i).getMessage()%></td>
    	<td align="center">
    	<%String address=outline.get(i).getAddress(); %>
    	&nbsp;&nbsp;<a href="readonly?address=<%=address%>">在线预览</a>&nbsp;&nbsp;
    		<a href="download.action?address=<%=address%>">下载大纲</a>	
    	</td>
    </tr>
    	
    	<%} %>
    	<%} %>
</body>
</html>
