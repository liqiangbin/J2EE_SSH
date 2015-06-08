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

		</style>
	</head>

	<body>

		<form class="form-inline definewidth m20" action="index.html" method="get">
			公告名称：
			<input type="text" name="menuname" id="menuname" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; </form>

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
			<tr>
				<th width="15" align="center">2015-6-7</th>
				<th width="20%" align="center">ssh框架开始</th>
				<th width="40%" align="center">我们集体开始大作业</th>
				<th width="15" align="center">本系公告</th>
				<th width="10" align="center"><a href="#">删除</a></th>
			</tr>
		</table>
		<div>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">

				发布新公告
			</button>

			<!-- 模态框（Modal） -->
			<form action="deptnotice.html" method="#" class="definewidth m20">
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
										<td class="tableleft">公告名</td>
										<td>
											<input type="text" name="name" />
										</td>
									</tr>
									<tr>
										<td class="tableleft">公告内容</td>
										<td>
											<textarea name="notice" cols="100" rows="5"></textarea>
										</td>
									</tr>

									<tr>
										<td class="tableleft"></td>
									</tr>
								</table>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">返回
								</button>
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