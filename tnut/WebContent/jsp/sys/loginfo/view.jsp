<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/include/head.jsp" flush="true" />
</head>

<body data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp" flush="true" />

<div class="container-fluid">
<div class="row-fluid"><jsp:include
	page="/include/menu_sys.jsp" flush="true" />
<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/LogInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.LogInfo.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/LogInfo/list?">${msg['label.LogInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/LogInfo/add?">${msg['label.LogInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/LogInfo/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="LogInfo.id" value="${LogInfo.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.LogInfo.ID']}</td>
		<td colspan="3"}>${LogInfo.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.CODE']}</td>
		<td colspan="3"}>${LogInfo.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.NAME']}</td>
		<td colspan="3"}>${LogInfo.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.TYPE']}</td>
		<td colspan="3"}>${LogInfo.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.STATUS']}</td>
		<td colspan="3"}>${LogInfo.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.CREATE_DATE']}</td>
		<td colspan="3"}>${LogInfo.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.CREATE_BY']}</td>
		<td colspan="3"}>${LogInfo.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.UPDATE_TIME']}</td>
		<td colspan="3"}>${LogInfo.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.UPDATE_BY']}</td>
		<td colspan="3"}>${LogInfo.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LogInfo.REMARK']}</td>
		<td colspan="3"}>${LogInfo.remark }</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="返回"> 
		</td>
	</tr>
</table>
</form>



</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" /></div>
<!--/.fluid-container-->

<jsp:include page="/include/js.jsp" flush="true" />

</body>
</html>
