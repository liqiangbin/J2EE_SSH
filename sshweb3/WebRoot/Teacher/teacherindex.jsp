<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="Teacher/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="Teacher/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="Teacher/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<% List<Teacher> teacher=(List<Teacher>)session.getAttribute("teacher"); %>
<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">root教师</span><a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
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
<script type="text/javascript" src="Teacher/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="Teacher/assets/js/bui-min.js"></script>
<script type="text/javascript" src="Teacher/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="Teacher/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[
        {id:'12',text:'个人信息管理',href:'Teacher/myself/index.jsp'},
        {id:'2',text:'学院公告',href:'announceAction_findByStatus'},
       {id:'5',text:'本系公告',href:'announceAction_teacherfindbydept?dept=<%=teacher.get(0).getDid()%>'}]}]},
        {id:'7',homePage: '9',menu:[{text:'课程信息维护',items:[
        {id:'9',text:'填写教学大纲',href:'Teacher/Course/EditOutline.jsp'},
        {id:'3',text:'查阅教学大纲',href:'Teacher/Course/LookOutline.jsp'},
         {id:'4',text:'教学进度表管理',href:'Teacher/Course/TeachingProgress.jsp'},
          {id:'6',text:'实验进度表管理',href:'Teacher/Course/TestProgress.jsp'},
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