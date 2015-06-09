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
		<form action="#">
		<table class="table table-bordered table-hover definewidth m10" width="60%" >
			
			<tr align="center">
				<td align="right" width="10%">教师编号：</td>
				<td align="left">2500125</td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">姓&nbsp;&nbsp;名：</td>
				<td align="left">章国文</td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">院&nbsp;&nbsp;系：</td>
				<td align="left">计算机</td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">性&nbsp;&nbsp;别：</td>
				<td align="left">男</td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">电&nbsp;&nbsp;话：</td>
				<td align="left">12345678</td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">邮&nbsp;&nbsp;箱：</td>
				<td align="left">12345678@qq.com</td>
			</tr>
		
		<tr >
			<td width="10%">&nbsp;</td>
			<td  align="left" >
		<button class="btn btn-danger btn-lg" data-toggle="modal" 
   data-target="#myModal">
  编辑个人信息
</button>
</td>
</tr>
</table>
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
              请重置您的个人信息
            </h4>
         </div>
         <div class="modal-body">
     <form action="#" method="post">
		<table class="table table-bordered table-hover definewidth m10" width="60%" >
			
			<tr align="center">
				<td align="right" width="20%">教师编号：</td>
				<td align="left">2500010</td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">姓&nbsp;&nbsp;名：</td>
				<td align="left">张三</td>
		<tr align="center">
				<td align="right" width="10%">院&nbsp;&nbsp;系：</td>
				<td align="left">计算机学院</td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">性&nbsp;&nbsp;别：</td>
				<td align="left">男</td>
			</tr>
				<tr align="center">
				<td align="right" width="20%">密&nbsp;&nbsp;码：</td>
				<td align="left"><input type="text" value="12345678"></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">电&nbsp;&nbsp;话：</td>
				<td align="left"><input type="text" value="12345678"></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">邮&nbsp;&nbsp;箱：</td>
				<td align="left"><input type="text" value="12345678@qq.com"></td>
			</tr>
		</table>
		</form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="submit" class="btn btn-warning">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
		
		</form>
	</body>

</html>
