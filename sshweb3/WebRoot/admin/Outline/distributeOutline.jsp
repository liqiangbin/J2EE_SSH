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
	<caption align="absmiddle"><h2>已分配课程大纲信息</h2></caption>
    <thead>
    <tr>
        <th>课程号</th>
         <th>课程名称</th>
        <th>所属系</th>
        <th>填写状态</th>
         
       
    </tr>
    </thead>
    <% List<Matchmessage> list =(List<Matchmessage>)session.getAttribute("outline");
    	 List<Depart> depart =(List<Depart>)session.getAttribute("depart");
    for(int i=0;i<list.size();i++){
     %>
			<tr>
				<td width="15%" align="center"><%=list.get(i).getCid() %></td>
					<td width="15%" align="center"><%=list.get(i).getCname() %></td>
				<td width="15%" align="center">
				<% String k=list.get(i).getDid();%>
				<%String dname=null;
				for(int d=0;d<depart.size();d++){
				if(depart.get(d).getId().equals(k)){
				dname=depart.get(d).getName();%>
				<%=dname %>
				<%
				}%>
				<%}%>
				</td>
				<td width="15%" align="center">
				<%int m=list.get(i).getTstatus(); 
			if(m==0) {%>
			未填写
			<%} else{%>
			已填写
		<%} %>
				</td>
       	</tr>
	<%} %>
	<tr>
	<td colspan="7" align="right">
	<button class="btn btn-success btn-lg" data-toggle="modal" 
   data-target="#sort">
  分配课程大纲到系
</button>
	<form action="matchmessageAction_save" method="post">
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
               请选择课程大纲分配信息
            </h4>
         </div>
         <div class="modal-body">
  
         <div class="form-group">
       
      
        <label for="name">选择课程：</label>
         <select class="form-control"  name=matchmessage.cid>
      <% List<Course> course =(List<Course>)session.getAttribute("course");
      
      for(int j=0;j<course.size();j++)
       {%>
         <option value= <%=course.get(j).getId() %>>
        <%=course.get(j).getName() %></option>
         <%} %>
         
      </select><br>
      
      <label for="name">系别：</label>
      <select class="form-control"  name=matchmessage.did>
      <%
      for(int j=0;j<depart.size();j++)
       {%>
         <option value=<%=depart.get(j).getId() %>>
        <%=depart.get(j).getName() %>  </option>
         <%} %>
      </select>
       <input type="hidden" name="matchmessage.tstatus"  value="0"/>
       <input type="hidden" name="matchmessage.deptstatus" value="0" />
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
