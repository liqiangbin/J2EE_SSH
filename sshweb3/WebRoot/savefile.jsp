<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.zhuozhengsoft.pageoffice.*"%>
<%
FileSaver fs = (FileSaver)(request.getAttribute("FileSaver"));
fs.close();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SaveFile</title>
  </head>
  
  <body>
    <h2>
    保存成功！！
   </h2>
   <input type="button" onclick="window.close();" value="关闭本页面">
  </body>
</html>
