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
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>管理教学大纲信息</h2></caption>
    <thead>
    <tr>
        <th>教学大纲号</th>
        <th>课程名称</th>
        <th>学期</th>
        <th>填写教师</th>
        <th>审核状态</th>
        <th width="20%">审核信息</th>
        <th>操作</th>
    </tr>
    </thead>
    <tr>
    	<td>123456</td>
    	<td>J2EE编程</td>
    	<td>2010-2011第一学期</td>
    	<td>李强斌</td>
    	<td>未通过</td>
    	<td>大纲内容太简单大纲内容太简单大纲内容太简单大纲内容太简单大纲内容太简单大纲内容太简单大纲内容太简单</td>
    	<td align="center"><button type="button" class="btn btn-success"><a href="#">通过审核</a></button>
    		
    		
    		          	<button class="btn btn-warning btn-lg" data-toggle="modal" 
   data-target="#myModal">
   审核意见
</button>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               请填写教学大纲审核信息
            </h4>
         </div>
         <div class="modal-body">
         	<textarea name="notice" cols="100" rows="5"></textarea>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">取消
            </button>
            <button type="button" class="btn btn-success">
               提交审核信息
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
    	&nbsp;&nbsp;<a href="#">在线预览</a>	&nbsp;&nbsp;
    		<a href="#">下载大纲</a>	
    	</td>
    	
    </tr>
	     
</table>
</body>
</html>
