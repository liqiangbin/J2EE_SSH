<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib prefix="s" uri="/struts-tags"%>
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
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

</head>
<body>
<!-- <form class="form-inline definewidth m20" action="" method="post">    
   
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form> -->
<table class="table table-bordered table-hover definewidth m10">
<caption align="absmiddle"><h2>教学大纲信息</h2></caption>
    <thead>
    <tr>
        <th>课程大纲号</th>
        <th>大纲名称</th>
        <th>学期</th>
        <th>教师</th>
        <th>审核状态</th>
        <th width="20%">审核信息</th>
        <th>操作</th>
    </tr>
    </thead>
	    <s:iterator value="#rquest.outlinelist" id="outline">
    
   <tr>
   	<td><s:property value="#outline.id" /></td>
   		<td><s:property value="#outline.name" /></td>
   			<td><s:property value="#outline.term" /></td>
   			<td><s:property value="#outline.tname" /></td>
   			
   <td>
  
      <s:if test='#outline.status ==1'>
        
        通过审核
 </s:if> 
     <s:if test='#outline.status ==0'>
       未通过审核
 </s:if> 
   		</td> 
   					<td><s:property value="message" /></td>
   					<td><button type="button" class="btn btn-success"><a href="">预览</a></button>&nbsp;&nbsp;
   					<button type="button" class="btn btn-success"><a href="">下载</a></button>
   					</td>
   </tr>
   </s:iterator>
   
  
</table>
</body>
</html>
