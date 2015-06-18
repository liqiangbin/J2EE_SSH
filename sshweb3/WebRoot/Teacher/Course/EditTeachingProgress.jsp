<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*,java.text.SimpleDateFormat" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Teacher/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Teacher/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Teacher/Css/style.css" />
    <script type="text/javascript" src="Teacher/Js/jquery.js"></script>
    <script type="text/javascript" src="Teacher/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Teacher/Js/bootstrap.js"></script>
      <script type="text/javascript" src="Teacher/Js/bootstrap.min.js"></script>
   
</head>
<body>
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>待填写教学进度表信息</h2></caption>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>状态</th>
        <th width="15%" align="right">操作</th>
    </tr>
    </thead>
     <% List<Sortprogress> list=(List<Sortprogress>)session.getAttribute("nofillteaching"); %>
	     <%for(int i=0;i<list.size();i++){ %>
    <tr>
    	<td><%=list.get(i).getCid() %></td>
    	<td width="15%" align="center">
				<%List<Course> course =(List<Course>)session.getAttribute("courselist");
				String name=null;
				String id=list.get(i).getCid();
				for(int m=0;m<course.size();m++){
				if(id.equals(course.get(m).getId())){
				
				name=course.get(m).getName();
				break;
				}}
				%>
				<%=name %>
				</td>
    	<td>未填写</td>
    	 <td>
  <button class="btn btn-default btn-lg" data-toggle="modal" 
   data-target="#<%=i%>">
  在线填写
</button>
<form action="openteachingword" method="post">
<!-- 模态框（Modal） -->
<div class="modal fade" id="<%=i %>" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               填写教学进度表基本信息
            </h4>
         </div>
         <div class="modal-body">
         <table class="table table-bordered table-hover definewidth m10">
           <% List<Teacher> teacher=(List<Teacher>)session.getAttribute("teacher"); 
           Date time1=new Date();
		                           SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		                             String time=sdf.format(time1);
	String address="F:/myeclipse/myclipseworkspace/sshweb3/WebRoot/allteachingprogress" + "/" +list.get(i).getCid()+list.get(i).getTid()+time+".docx";  %>
       
         
          <input type="hidden" name="sortprogress.id" value="<%=list.get(i).getId()%>">
           <input type="hidden" name="sortprogress.did" value="<%=list.get(i).getDid()%>">
            <input type="hidden" name="sortprogress.cid" value="<%=list.get(i).getCid()%>">
             <input type="hidden" name="sortprogress.tid" value="<%=list.get(i).getTid()%>">
              <input type="hidden" name="sortprogress.status" value="1">
               <input type="hidden" name="sortprogress.type" value="<%=list.get(i).getType()%>">
        <tr> <td width="20%">名称:</td>
         <td><input type="text" value="<%=name%>教学进度表"  name="teachingprogress.name"></td></tr>
         <tr>
          <tr> <td width="20%">教师名称:</td>
         <td><%=teacher.get(0).getName()%></td></tr>
         <input type="hidden" name="teachingprogress.tname" value="<%=teacher.get(0).getName()%>">
         <input type="hidden" name="teachingprogress.cid" value="<%=list.get(i).getCid()%>">
         <input type="hidden" name="teachingprogress.did" value="<%=teacher.get(0).getDid()%>">
         <input type="hidden" name="teachingprogress.tid" value="<%=teacher.get(0).getId()%>">
          <input type="hidden" name="teachingprogress.status" value="0">
          <input type="hidden" name="teachingprogress.address" value="<%=address%>">
         
         <tr>
         <td>选择学期：</td>
         <td>
         <select name="teachingprogress.term" class="form-control">
         <%List<Term> term =(List<Term>)session.getAttribute("term");
         for(int m=0;m<term.size();m++){%>
         <option value="<%=term.get(m).getDesc()%>"><%=term.get(m).getDesc()%></option>
        <% }
         %>
         </select>
         </td>
         </tr>
         </table>
         </div>
       
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="submit" class="btn btn-success">
               确认并填写
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
