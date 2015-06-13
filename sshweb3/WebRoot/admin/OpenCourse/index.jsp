<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="admin/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="admin/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="admin/Css/style.css" />
    <script type="text/javascript" src="admin/Js/jquery.js"></script>
    <script type="text/javascript" src="admin/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="admin/Js/bootstrap.js"></script>
    <script type="text/javascript" src="admin/Js/ckform.js"></script>
    <script type="text/javascript" src="admin/Js/common.js"></script>

   
</head>
<body>
 <div style="height: 50px">
		<form class="form-inline definewidth m20" action="copenAction_search" method="post">  
   	<div align="left" style="float: left;">
   		  开课搜索：
    <input type="text" name="courseopen.cname" class="abc input-default" style="width: 150px;" placeholder="请输入关键字" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary" >查询</button>&nbsp;&nbsp; 
    </div>
</form>

    <div align="left" style="float: right;">
    <!-- 
  <button class="btn btn-default"> <a href="<%=request.getContextPath()%>/admin/teacher/add.jsp"> 添加教师</a></button>
&nbsp;&nbsp;&nbsp;&nbsp;
	 -->
<button type="button" class="btn btn-success" id="addnew">数据导入</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>

<table class="table table-bordered table-hover definewidth m10" >
   
    <tr align="center">
        <th align="center">开课号</th>
        <th>开课单位</th>
        <th>课程号</th>
        <th>课程名</th>
        <th>学分</th>
        <th>讲课学时</th>
        <th>实验学时</th>
        <th>学届</th>
        <th>操作</th>
    </tr>
    <s:iterator value="pageBean.list">
	     <tr>
            <td><s:property value="id"/> </td>
            <td><s:property value="unit"/></td>
            <td><s:property value="cid"/></td>
            <td><s:property value="cname"/></td>
            
            <td><s:property value="credit"/></td>
            <td><s:property value="teachingtime"/></td>
            <td><s:property value="testtime"/></td>
            <td><s:property value="year"/></td>
            <td>            	
            	<a href="copenAction_delete?courseopen.id=<s:property value="id" /> ">删除</a>
            	<a href="edit.html">编辑</a>
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
            <a href="copenAction_showPage.action?page=1">第一页</a>
            <a href="copenAction_showPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="copenAction_showPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="copenAction_showPage.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        </td>
        </tr>
        </table>
	</div>
        
		</body>
		</html>

