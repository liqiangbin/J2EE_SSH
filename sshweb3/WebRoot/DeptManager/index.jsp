<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>教学进度管理系统（系主任）</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="DeptManager/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="DeptManager/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="DeptManager/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<% List<Departmenthead> person=(List<Departmenthead>)session.getAttribute("person");
String s="0";
session.setAttribute("messagetype",s);
 %>
<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
        <h1>教学进度管理系统(系主任端)</h1>
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">[<%=person.get(0).getName() %>]&nbsp;主任&nbsp;&nbsp;</span><a href="login.jsp" title="退出系统" class="dl-log-quit">[退出]</a>
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
         {id:'9',text:'进度表分配',href:'sortprogressAction_findbydept?sortprogress.did=<%=person.get(0).getDid()%>'},
        {id:'3',text:'课程大纲审核',href:'courseoutlineAction_findByStatus?courseoutline.did=<%=person.get(0).getDid()%>'},
         {id:'4',text:'教学进度表审核',href:'teachingprogressAction_findByStatus?teachingprogress.did=<%=person.get(0).getDid()%>'},
          {id:'6',text:'实验进度表审核',href:'testprogressAction_findByStatus?testprogress.did=<%=person.get(0).getDid()%>'},
           {id:'8',text:'信息统计',href:'allmessageAction_top'}
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