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

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="" method="get">  
    开课信息：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
   
</form>
<table class="table table-bordered table-hover definewidth m10" >
   
    <tr align="center">
        <th align="center">开课号</th>
        <th>开课单位</th>
        <th>课程号</th>
        <th>学分</th>
        <th>讲课学时</th>
        <th>实验学时</th>
        <th>学届</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.copen" id="colist">
	     <tr>
            <td><s:property value="#colist.id"/> </td>
            <td><s:property value="#colist.unit"/></td>
            <td><s:property value="#colist.cid"/></td>
            <td><s:property value="#colist.credit"/></td>
            <td><s:property value="#colist.teachingtime"/></td>
            <td><s:property value="#colist. testtime"/></td>
            <td><s:property value="#colist. year"/></td>
            <td>            	
            	<a href="copenAction_showCourseOpen?courseopen.id=<s:property value="#colist.id" /> ">删除</a>
            	<a href="add.html">增加</a>
            	<a href="edit.html">编辑</a>
            </td>
        </tr>
        </s:iterator>
        </table>
		</body>
		</html>

<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="add.html";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>