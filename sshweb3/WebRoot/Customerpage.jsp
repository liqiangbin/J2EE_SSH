<%@ page language="java" contentType="text/html; charset=utf-8""
    pageEncoding="utf-8""%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<s:iterator value="#request.pageBean" id="page">
				<s:property value="#page.list.name" />
            <s:property value="name"/>
            </s:iterator>
        共<s:property value="#request.pageBean.allRow"/> 条记录
        共<s:property value="#request.pageBean.totalPage"/> 页
        当前第<s:property value="#request.pageBean.currentPage"/>页<br/>
        
        <s:if test="%{#request.pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="listMyArticle.action?page=1">第一页</a>
            <a href="listMyArticle.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
            <a href="listMyArticle.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="listMyArticle.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>
</body>
</html>