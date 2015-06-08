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
  <script type="text/javascript" src="../Js/bootstrap.min.js"></script>
</head>
<body>
	<form action="" method="post">
		<table class="table" width="60%">
			<tr>
				 <div class="form-group">
				<td>
					
      <label for="name">选择学期</label>
      <select class="form-control">
        
         <option>2014--2015第一学期</option>
         <option>2014--2015第二学期</option>
      </select>
				</td>
				<td>
					
      <label for="name">选择类型</label>
      <select class="form-control">
        
         <option>教学进度表</option>
         <option>教学大纲</option>
         <option>实验进度表</option>
      </select>
				</td>
				<td>
					 
      <label for="name">选择状态</label>
      <select class="form-control">
         <option>通过审核</option>
         <option>未通过审核</option>
  
      </select>
				</td>
				<td width="40%"> <button type="submit" class="btn btn-success">
     查看统计
            </button></div></td>
			</tr>
		</table>
		
	</form>
	
	
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>信息统计如下</h2></caption>
    <thead>
    <tr>
    	<th>名称</th>
        <th>学期</th>
        <th>填写教师</th>
        <th>审核状态</th>
        <th width="20%">审核信息</th>
    </tr>
    </thead>
   <tr>
   	<td>暂无</td>
   		<td>暂无</td>
   			<td>暂无</td>
   				<td>暂无</td>
   					<td>暂无</td>
   </tr>
	     
</table>
</body>
</html>
