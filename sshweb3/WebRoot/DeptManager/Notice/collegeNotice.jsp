<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
    <script type="text/javascript" src="../DeptManager/Js/ckform.js"></script>
    <script type="text/javascript" src="../DeptManager/Js/common.js"></script>

   
</head>
<body>
<form class="form-inline definewidth m20" action="announceAction_search" method="post">
    公告名称：
    <input type="text" name="announce.title" class="abc input-default" placeholder="输入关键字" >&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	 <th width="15">公告发布时间</th>
        <th width="20%">公告名</th>
        <th width="50%">公告内容</th>
        <th width="15">公告类型</th>
    </tr>
    </thead>
    <s:iterator value="#request.list" id="announce">
			<tr>
				<td width="15" align="center"><s:property value="#announce.time" />
				</td>
				<td width="20%" align="center"><s:property value="#announce.title" />
				</td>
				<td width="50%" align="center"><s:property value="#announce.content" />
				</td>
				<td width="15" align="center">学院公告</td>
				</tr>
	</s:iterator>
      </table>

</body>
</html>
