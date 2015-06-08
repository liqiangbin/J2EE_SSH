<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>上传成功</title>   
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    上传成功！
   <table width="70%" height="100" border="1" align="center">

		<tr>
			<td width="20%" height="25" align="center">文件名</td>
			
			<td width="10%" align="center">操作</td>
		</tr>
		<s:iterator value="#request.filenames" id="fname">
			<tr>
				<td><s:property value="#fname" />
				</td>
					<td><a href="">导入</a>
				</td>
			</tr>
		</s:iterator>

	</table>
  </body>
</html>