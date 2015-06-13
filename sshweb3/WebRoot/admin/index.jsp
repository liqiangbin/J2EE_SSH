<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="admin/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="admin/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="admin/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=request.getSession().getAttribute("username") %></span>
    <a href="login.jsp" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">课程信息</div></li>		
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">系统管理</div></li>
            <!--<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">基本数据维护</div></li>-->

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="admin/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="admin/assets/js/bui-min.js"></script>
<script type="text/javascript" src="admin/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="admin/assets/js/config-min.js"></script>
<script>
    BUI.use('admin/common/main',function(){
        var config = [{id:'1',menu:[{text:'课程信息',items:[
        {id:'12',text:'课程信息管理',href:'couAction_showAllCourse.action'},
        {id:'3',text:'开课信息管理',href:'admin/OpenCourse/index.jsp'},
        {id:'4',text:'课程大纲管理',href:'admin/Outline/index.jsp'},
        {id:'5',text:'分配课程大纲',href:'admin/Outline/distributeOutline.jsp'},
        
        {id:'6',text:'教学进度管理',href:'admin/Progress/index.jsp'},
        {id:'7',text:'实验进度管理',href:'admin/Progress/index.jsp'},
        
        ]}]},
        
        {id:'8',homePage : '9',menu:[{text:'教工信息',items:[
        {id:'9',text:'教工信息',href:'teaAction_showAllTeacher.action'},
        {id:'10',text:'修改密码',href:'admin/Person/index.jsp'},
        {id:'11',text:'学期设置',href:'admin/term/term.jsp'},
        
        ]}]},
//      {id:'11',menu:[{text:'基本信息',items:[
//      {id:'8',text:'个人信息',href:'Person/index.html'},
//     
//      
//      ]}]},
        
        
        ];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
<div style="text-align:center;">

</div>
</body>
</html>
