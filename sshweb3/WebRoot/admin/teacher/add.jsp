<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../Css/style.css" />
<script type="text/javascript" src="../Js/jquery-1.5.1.js"></script>
<script type="text/javascript" src="../Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../Js/bootstrap.js"></script>
<script type="text/javascript" src="../Js/ckform.js"></script>
<script type="text/javascript" src="../Js/common.js"></script>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form action="teaAction_save.action" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">教师工号</td>
				<td><input type="text" name="teacher.id" />
				</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">教师名</td>
				<td><input type="text" name="teacher.name" />
				</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">性别</td>
				<td>
				<input type="radio" name="teacher.sex" value="男">男
				<input type="radio" name="teacher.sex" value="女">女
				
				</td>
			</tr>

			<tr>
				<td class="tableleft">电话</td>
				<td><input type="text" name="teacher.phone" />
				</td>
			</tr>
			<tr>
				<td class="tableleft">所属院系</td>
				<td><select name="teacher.departname">
						<option>软件工程系</option>
						<option>信息安全系</option>
						<option>计算机科学与技术系</option>
						<option>计算机科学与技术（电力企业信息化）</option>
				</select></td>
			</tr>

			<tr>
				<td class="tableleft">邮箱</td>
				<td><input type="text" name="teacher.email" />
				</td>
			</tr>

			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
					<button type="submit" class="btn btn-primary" type="button">添加教师</button>
					&nbsp;&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
