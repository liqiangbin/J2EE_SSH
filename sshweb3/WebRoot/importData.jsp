<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="gb2312"%>
<%@ page
	import="com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.excelwriter.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
	poCtrl.addCustomToolButton("�����ļ�", "importData()", 5);
	poCtrl.addCustomToolButton("�ύ����", "submitData()", 1);
	
	Workbook wb=new Workbook();
	Sheet sheet = wb.openSheet("Sheet1");

	poCtrl.setWriter(wb);
	
	poCtrl.setServerPage("poserver.do");
	poCtrl.setSaveDataPage("savedata.jsp");
	//��Ҫ������ļ���ֻ�����������뱣�������������ԡ�setProtectPassword������ֵ����Excel�ļ������õ�����
	poCtrl.setProtectPassword("123456");
	poCtrl.setTagId("PageOfficeCtrl1");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>�����ļ����ύ����</title>
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
		<!-- ***************************************PageOffice�����ʹ��****************************************** -->
		<script type="text/javascript">
        function importData() {
            document.getElementById("PageOfficeCtrl1").ExcelImportDialog();
        }

        function submitData() {
            document.getElementById("PageOfficeCtrl1").WebSave();
            
            //if (document.getElementById("PageOfficeCtrl1").CustomSaveResult == "ok")//���صı�����
            //    alert("�����ύ�ɹ���");
            //else
            //    alert("�����ύʧ�ܣ�");
        }
    </script>
		<div style="width: auto; height: 600px;">
			<po:PageOfficeCtrl id="PageOfficeCtrl1"></po:PageOfficeCtrl>
		</div>
		<!-- ***************************************PageOffice�����ʹ��****************************************** -->
	</body>
</html>
