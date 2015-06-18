<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
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
	<caption align="absmiddle"><h2>待填写课程大纲信息</h2></caption>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>状态</th>
        <th width="15%" align="right">操作</th>
    </tr>
   
    </thead>
     <% List<Matchmessage> list =(List<Matchmessage>)session.getAttribute("teacheroutline");
    for(int i=0;i<list.size();i++){
     %>
	   
	     <tr>
			<td><%=list.get(i).getCid() %></td>	
				<td><%=list.get(i).getCname() %></td>	
					<td>未填写</td>	
           <td>
  <button class="btn btn-default btn-lg" data-toggle="modal" 
   data-target="#<%=i%>">
  在线填写
</button>
<%
String name=null;
 %>
<form action="openword.action" method="post">
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
               填写教学大纲表头基本信息
            </h4>
         </div>
         <div class="modal-body">
         <table class="table table-bordered table-hover definewidth m10">
         
         
        <input type="hidden" name="matchmessage.id" value="<%=list.get(i).getId()%>">
         <input type="hidden" name="matchmessage.cid" value="<%=list.get(i).getCid()%>">
         <input type="hidden" name="matchmessage.cname" value="<%=list.get(i).getCname()%>">
         <input type="hidden" name="matchmessage.did" value="<%=list.get(i).getDid()%>">
          <input type="hidden" name="matchmessage.deptstatus" value="<%=list.get(i).getDeptstatus()%>">
	    <input type="hidden" name="matchmessage.tid" value="<%=list.get(i).getTid()%>">
	     <input type="hidden" name="matchmessage.tstatus" value="1">
	     
         <%
         List<Courseopen> courseopen =(List<Courseopen>)session.getAttribute("courseopen");
         String cid=list.get(i).getCid(); 
         name=list.get(i).getCname();
         String unit=null;
         int credit=0;
         int teachingtime=0;
         int testtime=0;
         for(int j=0;j<courseopen.size(); j++){
         if(cid.equals(courseopen.get(j).getCid())){
         unit=courseopen.get(j).getUnit();
         credit=courseopen.get(j).getCredit();
         teachingtime=courseopen.get(j).getTeachingtime();
         testtime=courseopen.get(j).getTesttime();
         break;
         }
         }
         %>
         <tr> <td width="20%">课程名:</td>
         <td><%=list.get(i).getCname()%></td></tr>
         <tr><td align="right">学分:</td>
         <td><%=credit%>学分</td></tr>
         <tr><td align="right">讲课学时:</td>
         <td><%=teachingtime%>学时</td></tr>
         <tr> <td align="right">实验学时:</td>
         <td><%=testtime%>学时</td>
         </tr> 
         <% List<Teacher> teacher=(List<Teacher>)session.getAttribute("teacher"); %> 
         <input type="hidden" name="courseoutline.name" value="<%=list.get(i).getCname()%>大纲">
         <input type="hidden" name="courseoutline.cid" value="<%=list.get(i).getCid()%>">
         <input type="hidden" name="courseoutline.tid" value="<%=list.get(i).getTid()%>">
         <input type="hidden" name="courseoutline.tname" value="<%=teacher.get(0).getName()%>">
         <input type="hidden" name="courseoutline.did" value="<%=teacher.get(0).getDid()%>">
         <input type="hidden" name="courseoutline.status" value="1">
         <%String address="F:/myeclipse/myclipseworkspace/sshweb3/WebRoot/alloutline" + "/" +list.get(i).getCid()+list.get(i).getTid()+".docx";  %>
         <input type="hidden" name="courseoutline.address" value="<%=address%>">
          <tr>
         <td>选择学期：</td>
         <td>
         <select name="courseoutline.term" class="form-control">
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
