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
	<caption align="absmiddle"><h2>待分配课程大纲信息</h2></caption>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
	     <tr>
            <td>6253591</td>
            <td>计算机组成原理</td>
            <td>未分配</td>
            <td>
            	
            	<button class="btn btn-success btn-lg" data-toggle="modal" 
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
         <option>周平</option>
         <option>刘小洛</option>
         <option>章国文</option>
         <option>李强斌</option>
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
</table>
</body>
</html>
