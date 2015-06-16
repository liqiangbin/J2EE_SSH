<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="gb2312"%>
<%@ page
	import="com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.excelwriter.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
	poCtrl.addCustomToolButton("导入文件", "importData()", 5);
	poCtrl.addCustomToolButton("提交数据", "submitData()", 1);
	
	Workbook wb=new Workbook();
	Sheet sheet = wb.openSheet("Sheet1");

	poCtrl.setWriter(wb);
	
	poCtrl.setServerPage("poserver.do");
	poCtrl.setSaveDataPage("savedata.jsp");
	//若要导入的文件是只读的且有密码保护，则设置属性“setProtectPassword”，其值就是Excel文件中设置的密码
	poCtrl.setProtectPassword("123456");
	poCtrl.setTagId("PageOfficeCtrl1");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>导入文件并提交数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <body>
		<!-- ***************************************PageOffice组件的使用****************************************** -->
		<script type="text/javascript">
        function importData() {
            document.getElementById("PageOfficeCtrl1").ExcelImportDialog();
        }

        function submitData() {
            document.getElementById("PageOfficeCtrl1").WebSave();
            
            //if (document.getElementById("PageOfficeCtrl1").CustomSaveResult == "ok")//返回的保存结果
            //    alert("数据提交成功！");
            //else
            //    alert("数据提交失败！");
        }
    </script>
		<div style="width: auto; height: 600px;">
			<po:PageOfficeCtrl id="PageOfficeCtrl1"></po:PageOfficeCtrl>
		</div>
		<!-- ***************************************PageOffice组件的使用****************************************** -->
	</body>
</html>
