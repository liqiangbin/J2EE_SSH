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
				<td width="10%" class="tableleft">课程名</td>
				
				<td>
				<select name="course.name">
			<s:iterator value="#request.coulist" id="course">
						<option><s:property value="#course.name" /> </option>
			</s:iterator>
				</select>
				</td>
			</tr>

			
				<td class="tableleft">分配院系</td>
				<td><select name="teacher.departname">
						<option>软件工程系</option>
						<option>信息安全系</option>
						<option>计算机科学与技术系</option>
						<option>计算机科学与技术（电力企业信息化）</option>
				</select></td>
			</tr>

		
			<tr>
				<td class="tableleft"><button type="button" class="btn btn-success" name="backid"
						id="backid" onclick="back()">返回列表</button></td>
				<td>
					
					<button type="submit" class="btn btn-primary" type="button">分配到系</button>
					&nbsp;&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
		
<script>
	function back(){
	window.location.href="<%=request.getContextPath()%>/admin/Outline/distributeOutline.jsp";
	}
</script>
</html>
