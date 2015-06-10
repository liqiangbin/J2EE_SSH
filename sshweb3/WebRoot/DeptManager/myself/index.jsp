<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		<script type="text/javascript" src="../DeptManager/Js/bootstrap.min.js"></script>
	</head>
	<body>
		
		<table class="table table-bordered table-hover definewidth m10" width="60%" >
			<% List<Departmenthead> list =(List<Departmenthead>)session.getAttribute("self"); %>
		
			<tr align="center">
				<td align="right" width="10%">教师编号：</td>
				<td align="left"><%=list.get(0).getId() %></td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">姓&nbsp;&nbsp;名：</td>
				<td align="left"><%=list.get(0).getName()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">所属系别：</td>
				<td align="left"><%=list.get(0).getDname()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">性&nbsp;&nbsp;别：</td>
				<td align="left"><%=list.get(0).getSex()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">电&nbsp;&nbsp;话：</td>
				<td align="left"><%=list.get(0).getPhone()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="10%">邮&nbsp;&nbsp;箱：</td>
				<td align="left"><%=list.get(0).getEmail()%></td>
			</tr>
		
		<tr >
			<td width="10%">&nbsp;</td>
			<td  align="left" >
		<button class="btn btn-danger btn-lg" data-toggle="modal" 
   data-target="#myModal">
  编辑个人信息
</button>
</td>
</tr>
</table>
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
              请重置您的个人信息
            </h4>
         </div>
         <div class="modal-body">
        
     <form action="deptheadAction_updatemyself" method="post">
		<table class="table table-bordered table-hover definewidth m10" width="60%" >
		 <%Departmenthead depthead=new Departmenthead();
		 depthead.setName(list.get(0).getName());
		 depthead.setSex(list.get(0).getSex());
		 depthead.setDid(list.get(0).getDid());
		 
		  %>
			<tr align="center">
				<td align="right" width="20%">教师编号：</td>
				<td align="left"><%=list.get(0).getId()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">姓&nbsp;&nbsp;名：</td>
				<td align="left"><input type="hidden" name="departmenthead.name" value="<%=list.get(0).getName()%>"><%=list.get(0).getName()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">所属系号：</td>
				<td align="left"><input type="hidden" name="departmenthead.did" value="<%=list.get(0).getDid()%>"><%=list.get(0).getDid()%></td>
			</tr>
				<tr align="center">
				<td align="right" width="20%">所属系名：</td>
				<td align="left"><input type="hidden" name="departmenthead.dname" value="<%=list.get(0).getDname()%>"><%=list.get(0).getDname()%></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">性&nbsp;&nbsp;别：</td>
				<td align="left"><input type="hidden" name="departmenthead.sex" value="<%=list.get(0).getSex()%>"><%=list.get(0).getSex()%></td>
			
			</tr>
				<tr align="center">
				<td align="right" width="20%">密&nbsp;&nbsp;码：</td>
				<td align="left"><input type="text" name="departmenthead.password" value="<%=list.get(0).getPassword()%>"></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">电&nbsp;&nbsp;话：</td>
				<td align="left"><input type="text" name="departmenthead.phone" value="<%=list.get(0).getPhone()%>"></td>
			</tr>
			<tr align="center">
				<td align="right" width="20%">邮&nbsp;&nbsp;箱：</td>
				<td align="left"><input type="text" name="departmenthead.email" value="<%=list.get(0).getEmail()%>"></td>
			</tr>
		
         </div>
         <tr>
         <td colspan="2">
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="submit" class="btn btn-warning"  >
               提交更改
            </button>
         </div>
         </td>
         </tr>
          </table>
		  </form>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
		
		
	</body>

</html>
