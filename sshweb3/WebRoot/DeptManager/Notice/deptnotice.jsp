<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*,java.text.SimpleDateFormat" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="s" uri="/struts-tags"%>
<html>

	<head>
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../DeptManager/Css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../DeptManager/Css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../DeptManager/Css/style.css" />
		<script type="text/javascript" src="../DeptManager/Js/jquery.js"></script>
		<script type="text/javascript" src="../DeptManager/Js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../DeptManager/Js/bootstrap.js"></script>
	<script type="text/javascript" src="../DeptManager/Js/bootstrap.min.js"></script>

		</style>
	</head>

	<body>
<% String id="2500010"; %>
		<form class="form-inline definewidth m20" action="announceAction_searchdept?departmenthead.id=<%=id %>" method="post">
			公告名称：
			<input type="text" name="announce.title"  class="abc input-default" placeholder="请输入关键字" >&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查&nbsp;&nbsp;询</button>
			&nbsp;&nbsp; </form>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="15">公告发布时间</th>
					<th width="20%">公告名</th>
					<th width="40%">公告内容</th>
					<th width="15">公告类型</th>
					<th width="10">操作</th>
				</tr>
			</thead>
			    <s:iterator value="#request.list" id="deptannounce">
			<tr>
				<td width="15" align="center"><s:property value="#deptannounce.time" />
				</td>
				<td width="20%" align="center"><s:property value="#deptannounce.title" />
				</td>
				<td width="50%" align="center"><s:property value="#deptannounce.content" />
				</td>
				<td width="15" align="center">本系公告</td>
				<td width="15" align="center"><a href="announceAction_delete?announce.id=<s:property value="#deptannounce.id" />">删除</a></td>
				</tr>
	</s:iterator>
		</table>
		<div>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">
				发布新公告
			</button>
			<!-- 模态框（Modal） -->
			<form action="announceAction_add" method="post" class="definewidth m20">
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
               填写公告信息
            </h4>
							</div>
							<div class="modal-body">
								<table class="table table-bordered table-hover m10" width="80%">
									<tr>
									<td>
									<%
									Date time1=new Date();
		                           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		                             String time=sdf.format(time1);%>
										<input type="hidden" name="announce.time" value="<%=time%>"/>
										</td>
									</tr>
									<tr>
										<td class="tableleft">公告名</td>
										<td>
											<input type="text" name="announce.title" />
										</td>
									</tr>
									<tr>
										<td class="tableleft">公告内容</td>
										<td>
											<textarea name="announce.content" cols="100" rows="5"></textarea>
										</td>
									</tr>
									<tr>
										<td class="tableleft"></td>
									</tr>
								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
								<button type="submint" class="btn btn-success">
									提交公告
								</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
			</form>
		</div>
	</body>

</html>