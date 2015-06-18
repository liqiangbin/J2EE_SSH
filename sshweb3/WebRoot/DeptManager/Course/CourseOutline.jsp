<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<caption align="absmiddle"><h2>待审核教学大纲信息</h2></caption>
    <thead>
    <tr>
        <th>课程大纲号</th>
        <th>名称</th>
        <th>学期</th>
        <th>填写教师</th>
        <th>审核状态</th>
        <th width="20%">审核信息</th>
        <th>操作</th>
    </tr>
    </thead>
   
    <% List<Courseoutline> list=(List<Courseoutline>)session.getAttribute("NoStatusOutline"); %>
    <%for(int i=0;i<list.size();i++){ %>
    <tr>
    	<td><%=list.get(i).getId() %></td>
    	<td><%=list.get(i).getName() %></td>
    	<td><%=list.get(i).getTerm() %></td>
    	<td><%=list.get(i).getTname()%></td>
    	<td>未通过</td>
    		<td><%=list.get(i).getMessage()%></td>
    		<form action="courseoutlineAction_checked" method="post">
    		<input type="hidden" name="courseoutline.id" value="<%=list.get(i).getId()%>">
    		<input type="hidden" name="courseoutline.cid" value="<%=list.get(i).getCid()%>">
    		<input type="hidden" name="courseoutline.tid" value="<%=list.get(i).getTid()%>">
<input type="hidden" name="courseoutline.tname" value="<%=list.get(i).getTname()%>">
<input type="hidden" name="courseoutline.did" value="<%=list.get(i).getDid()%>">
<input type="hidden" name="courseoutline.address" value="<%=list.get(i).getAddress()%>">
<input type="hidden" name="courseoutline.term" value="<%=list.get(i).getTerm()%>">
<input type="hidden" name="courseoutline.status" value="<%=1%>">
<input type="hidden" name="courseoutline.message" value="<%=list.get(i).getMessage()%>">
    	<td align="center"><button type="submit" class="btn btn-success">通过审核</button>
    		</form>
    		
    		          	<button class="btn btn-warning btn-lg" data-toggle="modal" 
   data-target="#<%=i%>">
   审核意见
</button>

<!-- 模态框（Modal） -->
<div class="modal fade" id="<%=i%>" tabindex="-1" role="dialog" 
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
         <form action="courseoutlineAction_checked" method="post">
         <input type="hidden" name="courseoutline.id" value="<%=list.get(i).getId()%>">
    		<input type="hidden" name="courseoutline.cid" value="<%=list.get(i).getCid()%>">
    		<input type="hidden" name="courseoutline.tid" value="<%=list.get(i).getTid()%>">
<input type="hidden" name="courseoutline.tname" value="<%=list.get(i).getTname()%>">
<input type="hidden" name="courseoutline.did" value="<%=list.get(i).getDid()%>">
<input type="hidden" name="courseoutline.address" value="<%=list.get(i).getAddress()%>">
<input type="hidden" name="courseoutline.term" value="<%=list.get(i).getTerm()%>">
<input type="hidden" name="courseoutline.status" value="<%=list.get(i).getStatus()%>">
         
         <div class="modal-body">
         	<textarea name="courseoutline.message" cols="100" rows="5"></textarea>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">取消
            </button>
            <button type="submit" class="btn btn-success">
               提交审核信息
            </button>
         </div>
         </form>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<%String address=list.get(i).getAddress(); %>
    	&nbsp;&nbsp;<a href="readonly?address=<%=address%>">在线预览</a>	&nbsp;&nbsp;
    		<a href="download.action?address=<%=address%>">下载大纲</a>	
    	</td>
    </tr>
	<%} %>
</table>
</body>
