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
	<form action="allmessageAction_showPage" method="post">
		<table class="table" width="60%">
			<tr>
				 <div class="form-group">
				<td>
					
      <label for="name">选择学期</label>
      <select class="form-control" name="term">
        <% List<Term> termlist=(List<Term>)session.getAttribute("termlist");
        for(int tl=0;tl<termlist.size();tl++) {%>
         <option value="<%=termlist.get(tl).getDesc()%>"><%=termlist.get(tl).getDesc()%></option>
         <%} %>
      </select>
				</td>
				<td>
					
      <label for="name">选择类型</label>
      <select class="form-control" name="type">
        
         <option value="教学进度表" >教学进度表</option>
         <option value="教学大纲">教学大纲</option>
         <option value="实验进度表">实验进度表</option>
      </select>
				</td>
				<td>
					 
      <label for="name" >选择状态</label>
      <select class="form-control"  name="status">
         <option value="1">通过审核</option>
         <option value="0">未通过审核</option>
  
      </select>
				</td>
				<td width="40%"> <button type="submit" class="btn btn-success">
     查看统计
            </button></div></td>
			</tr>
		</table>
	</form>
	
	
   <table class="table table-bordered table-hover definewidth m10">
	<caption align="absmiddle"><h2>信息统计如下</h2></caption>
    <thead>
    <tr>
    	<th width="10%">名称</th>
        <th width="15%">学期</th>
        <th width="15%">填写教师</th>
        <th width="15%">审核状态<br>
        </th>
        <th width="25%">审核信息</th>
        <th width="20%">操作</th>
    </tr>
    </thead>
   <% if(session.getAttribute("messagetype").equals("1")) {%>
    <s:iterator value="pageBean.list">
    
   <tr>
   	<td><s:property value="name" /></td>
   		<td><s:property value="term" /></td>
   			<td><s:property value="tname" /></td>
   			
   <td>
        <s:if test='status ==1'>
        
        通过审核
 </s:if> 
     <s:if test='status ==0'>
       未通过审核
 </s:if>
   		</td> 
   					<td><s:property value="message" /></td>
   					<td><a class="btn btn-default" role="button" href="readonly?address=<s:property value="address" />">预览</a>&nbsp;&nbsp;
   					<a class="btn btn-default" role="button" href="download.action?address=<s:property value="address" />">下载</a>
   					</td>
   </tr>
   </s:iterator>
   <table align="center">

   <tr>
   <td ><h5>
	  共<s:property value="pageBean.allRow"/> 条记录 &nbsp;
        共<s:property value="pageBean.totalPage"/> 页&nbsp;
        当前第<s:property value="pageBean.currentPage"/>页&nbsp;</h4>
        </td>
        <td ><h5>
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 &nbsp;上一页
        </s:if>
        <s:else>
            <a href="allmessageAction_showPage.action?page=1">第一页</a>&nbsp;
            <a href="allmessageAction_showPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>&nbsp;
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="allmessageAction_showPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>&nbsp;
            <a href="allmessageAction_showPage.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        </h5>
        </td>
        </tr>
      
        </table>
   <%} else if(session.getAttribute("messagetype").equals("2")) {%>
    <s:iterator value="pageBean.list">
    
   <tr>
   	<td><s:property value="name" /></td>
   		<td><s:property value="term" /></td>
   		<td><s:property value="tname" /></td>
   			<td>
        <s:if test='status ==1'>
        通过审核
 </s:if> 
     <s:if test='status ==0'>
       未通过审核
 </s:if>
   		</td> 
   			<td><s:property value="message" /></td>
   					<td><a class="btn btn-default" role="button" href="readonly?address=<s:property value="address" />">预览</a>&nbsp;&nbsp;
   					<a class="btn btn-default" role="button" href="download.action?address=<s:property value="address" />">下载</a>
   					</td>
   </tr>
   </s:iterator>
   <table align="center">

   <tr>
   <td ><h5>
	  共<s:property value="pageBean.allRow"/> 条记录 &nbsp;
        共<s:property value="pageBean.totalPage"/> 页&nbsp;
        当前第<s:property value="pageBean.currentPage"/>页&nbsp;</h4>
        </td>
        <td ><h5>
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 &nbsp;上一页
        </s:if>
        <s:else>
            <a href="allmessageAction_showPage.action?page=1">第一页</a>&nbsp;
            <a href="allmessageAction_showPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>&nbsp;
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="allmessageAction_showPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>&nbsp;
            <a href="allmessageAction_showPage.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        </h5>
        </td>
        </tr>
      
        </table>
        
   <%}else if(session.getAttribute("messagetype").equals("3")) {%>
       <s:iterator value="pageBean.list">
    
   <tr>
   	<td><s:property value="name" /></td>
   		<td><s:property value="term" /></td>
   		<td><s:property value="tname" /></td>
   			<td>
        <s:if test='status ==1'>
        
        通过审核
 </s:if> 
     <s:if test='status ==0'>
       未通过审核
 </s:if>
   		</td> 
   			<td><s:property value="message" /></td>
   					<td><a class="btn btn-default" role="button" href="readonly?address=<s:property value="address" />">预览</a>&nbsp;&nbsp;
   					<a class="btn btn-default" role="button" href="download.action?address=<s:property value="address" />">下载</a>
   					</td>
   </tr>
   </s:iterator>
   <table align="center">

   <tr>
   <td ><h5>
	  共<s:property value="pageBean.allRow"/> 条记录 &nbsp;
        共<s:property value="pageBean.totalPage"/> 页&nbsp;
        当前第<s:property value="pageBean.currentPage"/>页&nbsp;</h4>
        </td>
        <td ><h5>
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 &nbsp;上一页
        </s:if>
        <s:else>
            <a href="allmessageAction_showPage.action?page=1">第一页</a>&nbsp;
            <a href="allmessageAction_showPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>&nbsp;
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="allmessageAction_showPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>&nbsp;
            <a href="allmessageAction_showPage.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
        </h5>
        </td>
        </tr>
      
        </table>
   <%} else{%>
   <tr>
   	<td>暂无</td>
   		<td>暂无</td>
   			<td>暂无</td>
   				<td>暂无</td>
   					<td>暂无</td>
   					<td><button type="button" class="btn btn-success"><a href="readonly?address=<s:property value="address" />">预览</a></button>&nbsp;&nbsp;
   					<button type="button" class="btn btn-success"><a href="download.action?address=<s:property value="address" />">下载</a></button></td>
   </tr>
   <%} %> 
   
 
   
   
	     
</table>
</body>
</html>
