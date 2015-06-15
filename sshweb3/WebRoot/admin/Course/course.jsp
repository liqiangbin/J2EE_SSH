<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
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
		<form class="form-inline definewidth m20" action="couAction_search" method="post">  
   	<div align="left" style="float: left;">
   		  搜索课程：
    <input type="text" name="course.name" class="abc input-default" style="width: 150px;" placeholder="请输入关键字" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary" >查询</button>&nbsp;&nbsp; 
    </div>
</form>

    <div align="left" style="float: right;">
 <button class="btn btn-primary btn-lg" data-toggle="modal"   data-target="#myModal">添加

课程</button>
&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-success" id="addnew">批量导入</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>

				<div style="width: 100%">
					<table class="table table-bordered table-hover definewidth m10">
						<thead>
							<tr>
								<th>课程编号</th>

								<th>课程名</th>
								<th>所用教材</th>

								<th>管理操作</th>
							</tr>
						</thead>
						<s:iterator value="pageBean.list" >
							<tr>
								<td><s:property value="id" />
								</td>
								<td><s:property value="name" />
								</td>
								<td><s:property value="textbook" /></td>

								<td align="right">
							<a href="couAction_delete.action?course.id=<s:property value="id" />" class="btn btn-primary btn-lg" role="button">
                                                        删除
                                  </a>
     
								
								
								<button class="btn btn-default"> <a href="edit.jsp">编辑</a></button>
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
            <a href="couAction_showPage.action?page=1">第一页</a>
            <a href="couAction_showPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="couAction_showPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="couAction_showPage.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        </td>
        </tr>
        </table>
	</div>
					
					<div style="margin-left: 15px;margin-top: 10px">
					
			<!-- 模态框（Modal） -->
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog"    aria-

labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel" align="center">
              添加课程
            </h4>
         </div>
         <div class="modal-body">
           <form action="couAction_save.action" method="post">
           <table>
           		<tr>
				<td width="30%" class="tableleft">课程编号</td>
				<td><input type="text" name="course.id"  />	</td>
			</tr>
			<tr>
				<td width="30%" class="tableleft">课程名</td>
				<td><input type="text" name="course.name"  />
				</td>
			</tr>
			<tr>
				<td width="30%" class="tableleft">所用教材</td>
				<td>
				<input type="text" name="course.textbook"  />
				
				
				</td>
			</tr>
           </table>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="submit" class="btn btn-primary">
               开设课程
            </button>
           </form>
         </div>
         </div><!-- /.modal-content -->
        </div><!-- /.modal -->
		</div>	
		
		</div>			
</div>

</body>
</html>
