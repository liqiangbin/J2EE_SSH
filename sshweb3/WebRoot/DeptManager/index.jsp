<%@page import="shiep.dao.DepartmentheadDao"%>
<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="DeptManager/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="DeptManager/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="DeptManager/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<% List<Departmenthead> person=(List<Departmenthead>)session.getAttribute("person");
 %>
<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>
    <div class="dl-log">欢迎您<span class="dl-log-user"><%=person.get(0).getId()%></span><a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">课程管理</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
<script type="text/javascript" src="DeptManager/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="DeptManager/assets/js/bui-min.js"></script>
<script type="text/javascript" src="DeptManager/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="DeptManager/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[
        {id:'12',text:'个人信息管理',href:'deptheadAction_findbyId?departmenthead.id=<%=person.get(0).getId()%>'},
        {id:'2',text:'学院公告',href:'announceAction_findByStatus'},
       {id:'5',text:'本系公告',href:'announceAction_findBydept?departmenthead.id=<%=person.get(0).getId()%>'}]}]},
        {id:'7',homePage: '9',menu:[{text:'课程信息维护',items:[
        {id:'9',text:'课程大纲分配',href:'matchmessageAction_findbydept?matchmessage.did=<%=person.get(0).getDid()%>'},
        {id:'3',text:'课程大纲管理',href:'DeptManager/Course/CourseOutline.jsp'},
         {id:'4',text:'教学进度表',href:'DeptManager/Course/TeachingProgress.jsp'},
          {id:'6',text:'实验进度表',href:'DeptManager/Course/TestProgress.jsp'},
           {id:'8',text:'信息统计',href:'DeptManager/Course/MessageCount.jsp'}
        ]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
<div style="text-align:center;">

</div>
</body>
</html>