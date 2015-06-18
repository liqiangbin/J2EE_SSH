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
	<caption align="absmiddle"><h2>已分配进度表信息</h2></caption>
    <thead>
    <tr>
        <th width="15%">课程号</th>
        <th width="15%">课程名称</th>
      <th width="20%">学期</th>
        <th width="15%">填写状态</th>
         <th width="15%">填写教师</th>
          <th width="20%">进度表类型</th>
    </tr>
    </thead>
    <% List<Sortprogress> list =(List<Sortprogress>)session.getAttribute("sortmessage");
    for(int i=0;i<list.size();i++){
     %>
			<tr>
				<td width="15%" align="center"><%=list.get(i).getCid() %></td>
				<td width="15%" align="center">
				<%List<Course> course =(List<Course>)session.getAttribute("course");
				String name1=null;
				for(int x=0;x<course.size();x++){
				if(list.get(i).getCid().equals(course.get(x).getId()))
				name1=course.get(x).getName();
				}
				 %>
				 <%=name1 %>
				</td>
				<td width="15%" align="center"><%=list.get(i).getTerm() %>
				</td>
				<td width="15%" align="center">
				<% if(list.get(i).getStatus()==0){%>
				未填写
				<%} else{%>
				已填写
				<%} %>
				</td>
				<td width="15%" align="center">
			<%List<Teacher> t =(List<Teacher>)session.getAttribute("teacher");
				String name=null;
				for(int x=0;x<t.size();x++){
				if(list.get(i).getTid().equals(t.get(x).getId()))
				name=t.get(x).getName();
				}
				 %>
				 <%=name %>
				 </td>
				 <td><%=list.get(i).getType()%></td>
       	</tr>
	<%} %>
	<tr>
	<td colspan="7" align="right">
	<button class="btn btn-success btn-lg" data-toggle="modal" 
   data-target="#sort">
  分配进度表
</button>
	<form action="sortprogressAction_sort" method="post">
<!-- 模态框（Modal） -->
<div class="modal fade" id="sort" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               请选择进度表分配信息
            </h4>
         </div>
         <div class="modal-body">
  
         <div class="form-group">
         <% List<Departmenthead> person=(List<Departmenthead>)session.getAttribute("person"); %>
      <input type="hidden" name=sortprogress.did value="<%=person.get(0).getDid() %>">
      <input type="hidden" name=sortprogress.status value=0>
       <label for="name">选择学期：</label>
         <select class="form-control"  name=sortprogress.term>
      <% List<Term> term =(List<Term>)session.getAttribute("term");
      for(int j=0;j<term.size();j++)
       {%>
         <option value= <%=term.get(j).getDesc() %>>
        <%=term.get(j).getDesc() %></option>
         <%} %>
      </select><br>
        <label for="name">选择课程：</label>
         <select class="form-control"  name=sortprogress.cid>
      <% List<Course> course =(List<Course>)session.getAttribute("course");
      for(int j=0;j<course.size();j++)
       {%>
         <option value= <%=course.get(j).getId() %>>
        <%=course.get(j).getName() %></option>
         <%} %>
         
      </select><br>
      
      <label for="name">本系教师：</label>
      <select class="form-control"  name=sortprogress.tid>
      <% List<Teacher> teacherlist =(List<Teacher>)session.getAttribute("teacher");
      for(int j=0;j<teacherlist.size();j++)
       {%>
         <option value=<%=teacherlist.get(j).getId() %>>
        <%=teacherlist.get(j).getName() %></option>
         <%} %>
      </select>
        <br>
       <label for="name">进度表类型：</label>
         <select class="form-control"  name=sortprogress.type>
      <option value="教学进度表">教学进度表</option>
        <option value="实验进度表">实验进度表</option>
      </select>
       
      </div>
    
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">取消
            </button>
            <button type="submit" class="btn btn-success">
               确认分配
            </button>
         </div>
       
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
</form>
	</td>
	</tr>
</table>
</body>
</html>
