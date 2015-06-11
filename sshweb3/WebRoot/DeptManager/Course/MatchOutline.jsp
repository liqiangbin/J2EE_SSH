<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="DeptManager/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="DeptManager/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="DeptManager/Css/style.css" />
    <script type="text/javascript" src="DeptManager/Js/jquery.js"></script>
    <script type="text/javascript" src="DeptManager/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="DeptManager/Js/bootstrap.js"></script>
   <script type="text/javascript" src="DeptManager/Js/bootstrap.min.js"></script>
</head>
<body>
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>待分配课程大纲信息</h2></caption>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>分配状态
        <br>(0表示未分配，1表示已分配)
        </th>
        <th>填写状态
         <br>(0表示未填写，1表示已填写)</th>
        <th>操作</th>
    </tr>
    </thead>
	     <s:iterator value="#request.outline" id="outline">
			<tr>
				<td width="20%" align="center"><s:property value="#outline.cid" />
				</td>
				<td width="20%" align="center"><s:property value="#outline.cname" />
				</td>
				<td width="20%" align="center"><s:property value="#outline.deptstatus" />
				</td>
				<td width="20%" align="center"><s:property value="#outline.tstatus"/></td>
            	<td width="20%"><button class="btn btn-success btn-lg" data-toggle="modal" 
   data-target="#myModal">
   分配教学大纲到教师
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
               请选择教师填写教学大纲
            </h4>
         </div>
         <div class="modal-body">
         	
         <div class="form-group">
      <label for="name">本系教师：</label>
      <select class="form-control">
       <s:iterator value="#request.teacher" id="teacher">
         <option value=<s:property value="#teacher.id" />><s:property value="#teacher.name" /></option>
         </s:iterator>
      </select>
      </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">取消
            </button>
            <button type="button" class="btn btn-success">
               保存更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
            </td>
       			</tr>
	</s:iterator>
</table>
</body>
</html>
