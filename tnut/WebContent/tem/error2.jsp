
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'error.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<%=path%>/js/nutz.js"></script>
<Script language="Javascript"
	src="<%=request.getContextPath()%>/js/DD_roundies_min.js"></Script>
<SCRIPT LANGUAGE="JavaScript">
<!-- 
DD_roundies.addRule('#div_main_in', '10px 15px 20px 25px', true);
//-->
</SCRIPT>	
<link rel="stylesheet" type="text/css" href="<%=path%>/css/styles.css">

</head>

<body>

<div id="div_main" class="div_main">
<div id="div_main_in" class="div_main_in">
<table width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top:50px;font-size:14px"	class="mytab">
	<tr class="tr_data">
		<td align="center">		
		<h3><IMG src="images/noauth.jpg"/>出错了！请与系统管理员联系</h3>
		</td>
	</tr>
	<tr class="tr_data">
		<td style="color:red;">提示：${error}</td>
	</tr>
	<tr class="tr_data">
		<td align="center">
			<a href="#" onclick="doHistoryBack()">返回</a> &nbsp;|&nbsp;
			<a href="<%=path%>">首页</a>
		</td>
	</tr>
</table>
</div>
</div>
</body>
</html>
