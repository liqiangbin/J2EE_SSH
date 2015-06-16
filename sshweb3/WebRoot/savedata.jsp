<%@ page language="java" import="shiep.daoImpl.*,shiep.action.*,shiep.bean.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page
	import="com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.excelreader.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	Workbook wb = new Workbook(request, response);
	Sheet sheet = wb.openSheet("Sheet1");
	Table table = sheet.openTable("A2:C12");
	List<Course> list=new ArrayList<Course>();
	//获取提交的数据
	while(!table.getEOF())
	{
	   Course course=new Course();
		String cid =  table.getDataFields().get(0).getValue();
		String cname = table.getDataFields().get(1).getValue();
		String cbook = table.getDataFields().get(2).getValue();
		course.setId(cid);
		course.setName(cname);
		course.setTextbook(cbook);
		list.add(course);
		table.nextRow();
	}
	
	session.setAttribute("importcourse", list);
	wb.showPage(578, 380);
	wb.close();
	//-----------  PageOffice 服务器端编程结束  -------------------//
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<title>SaveData</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5"
			name="vs_targetSchema">

	</HEAD>
	<body>
	 <form action="servlet/ImportServlet"  method="post">
		<div class="errTopArea" style="TEXT-ALIGN: left">
		
		<input type="text"  value="<%=list.get(0).getName()%>">
		<%session.setAttribute("s", "123"); %>
		</div>
		<div class="errMainArea" id="error163">
			<div class="errTxtArea" style="HEIGHT: 150px; TEXT-ALIGN: left">
				<b class="txt_title">
					<ul>
					</ul> </b>
			</div>
			<div class="errBtmArea">
				<input type="button" class="btnFn" value=" 关闭 "
					onclick="window.opener = null;window.open('', '_self');window.close();">
			</div>
		</div>
		<input type="submit" value="tijiao">
		</form> 
	</body>
</HTML>

