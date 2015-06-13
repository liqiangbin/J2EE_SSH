<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="admin/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="admin/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="admin/Css/style.css" />
<script type="text/javascript" src="admin/js/jquery.js"></script>
<script type="text/javascript" src="admin/js/jquery.sorted.js"></script>
<script type="text/javascript" src="admin/js/bootstrap.js"></script>
<script type="text/javascript" src="admin/js/ckform.js"></script>
<script type="text/javascript" src="admin/js/common.js"></script>
</head>

<body>

	 <div style="height: 50px">
		<form class="form-inline definewidth m20" action="teaAction_search" method="post">  
   	<div align="left" style="float: left;">
   		  搜索教师：
    <input type="text" name="teacher.name" class="abc input-default" style="width: 150px;" placeholder="请输入关键字" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary" >查询</button>&nbsp;&nbsp; 
    </div>
</form>

    <div align="left" style="float: right;">
  <button class="btn btn-default"> <a href="<%=request.getContextPath()%>/admin/teacher/add.jsp"> 添加教师</a></button>
&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-success" id="addnew">数据导入</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>

<div>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>教工编号</th>
				<th>教师名</th>
				<th>性别</th>
				<th>所属院系</th>
				<th>电话</th>
				<th>邮箱</th>
				<th>密码管理</th>
				<th>管理操作</th>
			</tr>
		</thead>
		
		<s:iterator value="pageBean.list">
		
			<tr>
				<td><s:property value="id" />
				</td>
				<td><s:property value="name" />
				</td>
				<td><s:property value="sex" />
				</td>
				<td><s:property value="departname" />
				</td>
				<td><s:property value="phone" />
				</td>
				<td><s:property value="email" />
				</td>
			
				<td width="10%" align="center"><form action="teaAction_updatepwd" method="post">
				<input type="hidden" name="teacher.id" value="<s:property value="id" />">
				<input type="hidden" name="teacher.name" value="<s:property value="name" />">
				<input type="hidden" name="teacher.sex" value="<s:property value="sex" />">
				<input type="hidden" name="teacher.departname" value="<s:property value="departname" />">
				<input type="hidden" name="teacher.phone" value="<s:property value="phone" />">
				<input type="hidden" name="teacher.email" value="<s:property value="email" />">
				<input type="hidden" name="teacher.password" value="<s:property value="id" />">
				<button class="btn btn-danger"  type="submit">密码重置</button>
				</form></td>
		
				<td width="15%">							
				<button class="btn btn-default" >	<a href="teaAction_delete?teacher.id=<s:property value="id" />">删除</a></button>



<!-- 按钮触发模态框 -->
<button class="btn btn-warning btn-lg" data-toggle="modal" 
   data-target="#<s:property value="id" />">
   编辑
</button>

<!-- 模态框（Modal） -->
<div class="modal fade" id="<s:property value="id" />" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
            <center>编辑教师信息</center>  
            </h4>
         </div>
         <form action="" method="post">
         <div class="modal-body">
           
           
           <table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">教师工号</td>
				<td><input type="text" name="teacher.id" value="<s:property value="id" />" />
				</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">教师名</td>
				<td><input type="text" name="teacher.name"  value="<s:property value="name" />"/>
				</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">性别</td>
				<td>
				<input type="hidden"value="<s:property value="sex" />">
				
				</td>
			</tr>

			<tr>
				<td class="tableleft">电话</td>
				<td><input type="text" name="teacher.phone" value="<s:property value="phone" />"/>
				</td>
			</tr>
			<tr>
				<td class="tableleft">所属院系</td>
				<td><select name="teacher.departname">
						<option><s:property value="departname" /></option>
						<option>软件工程系</option>
						<option>信息安全系</option>
						<option>计算机科学与技术系</option>
						<option>计算机科学与技术（电力企业信息化）</option>
				</select></td>
			</tr>

			<tr>
				<td class="tableleft">邮箱</td>
				<td><input type="text" name="teacher.email" />
				</td>
			</tr>
		</table>
           
           
           
           
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
         </form>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->

			
						
				</td>
			</tr>
			
		</s:iterator>
	</table>


	<div class="inline pull-center page"  style="margin-left: 300px">
	<table>
	<tr>
	<td>
	  共<s:property value="pageBean.allRow"/> 条记录
        共<s:property value="pageBean.totalPage"/> 页
        当前第<s:property value="pageBean.currentPage"/>页<br/>
        </td>
        <td>
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="teaAction_showPage.action?page=1">第一页</a>
            <a href="teaAction_showPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="teaAction_showPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="teaAction_showPage.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        </td>
        </tr>
        </table>
	</div>
	</div>
	
			
</body>

</html>