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
        </th>
        <th>填写状态</th>
         <th>填写教师</th>
        <th>操作</th>
    </tr>
    </thead>
    <% List<Matchmessage> list =(List<Matchmessage>)session.getAttribute("outline");
    List<Teacher> tlist=(List<Teacher>)session.getAttribute("teacher");
    for(int i=0;i<list.size();i++){
     %>
	    
	     
			<tr>
				<td width="15%" align="center"><%=list.get(i).getCid() %></td>
				<td width="15%" align="center"><%=list.get(i).getCname()%>
				</td>
				<td width="15%" align="center">
				<% if(list.get(i).getDeptstatus()==0){%>
				未分配
				<%} else{%>
				已分配
				<%} %>
				</td>
				<td width="15%" align="center">
				<% if(list.get(i).getTstatus()==0){%>
				未填写
				<%} else{%>
				已填写
				<%} %>
				</td>
				<td width="15%" align="center">
					<% String k=list.get(i).getTid();%>
				<%String tname=null;
				for(int d=0;d<tlist.size();d++){
				if(tlist.get(d).getId().equals(k)){
				tname=tlist.get(d).getName();%>
				<%=tname %>
				<%
				}%>
				<%}%>
				 </td>
				<td width="20%"><button class="btn btn-success btn-lg" data-toggle="modal" 
   data-target="#<%=i%>">
   指定教师/重新分配
</button>
<form action="matchmessageAction_sort" method="post">
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
               请选择教师填写教学大纲
            </h4>
         </div>
         <div class="modal-body">
         <div class="form-group">
      <label for="name">本系教师：</label>
      <select class="form-control"  name=matchmessage.tid>
      <% List<Teacher> teacherlist =(List<Teacher>)session.getAttribute("teacher");
      for(int j=0;j<teacherlist.size();j++)
       {%>
         <option value=<%=teacherlist.get(j).getId() %>>
        <%=teacherlist.get(j).getName() %></option>
         <%} %>
      </select>
       <input type="hidden" name=matchmessage.id  value="<%=list.get(i).getId()%>" />
          <input type="hidden" name=matchmessage.cid  value="<%=list.get(i).getCid()%>"  />
          <input type="hidden" name=matchmessage.cname  value="<%=list.get(i).getCname()%>" />
    <input type="hidden" name=matchmessage.did  value="<%=list.get(i).getDid()%>" />
    <input type="hidden" name=matchmessage.deptstatus  value=<%=1%> />
   <input type="hidden" name=matchmessage.tstatus  value=<%=0%> />
      </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">取消
            </button>
            <button type="submit" class="btn btn-success">
               保存更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
</form>
        </td>
       	</tr>
	<%} %>
</table>
</body>
</html>
