<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>登录界面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />

</head>

<body>
<%
request.removeAttribute("username");
 %>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>在线教学大纲与进度表管理系统</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="loginAction_login" method="post" name="form" id="form">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="username" class="form-control" placeholder="用户名">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="password" name="password" class="form-control" placeholder="密码">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock">身份：</span></span>
							<select  class="form-control" name="enter"  id="select" onclick="javascript:formSubmit();">
								<option id="teacher" value="教师登录">教师登录</option>
								<option id="admin" value="管理员登录">管理员登录</option>
								<option id="dept" value="系主任登录">系主任登录</option>
							</select>
							
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 row-xs-offset-4 " style="margin-left: 40px">
						<button type="submit"  class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</button>
					</div>
					<div class="col-xs-4 row-xs-offset-4" style="margin-left: 120px">
						<button type="reset" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 重置</button>
					</div>
						
				</div>
				<div class="form-group">
					<div class="col-xs-6 link">
						<p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a>
						</p>
					</div>
					
				</div>
			</form>
			</div>
		</div>
	</div>
</div>

</body>
<script type="text/javascript" src="admin/js/jquery.js"></script>
<script type="text/javascript">
 		function formSubmit(){
 		
}

</script>

</html>