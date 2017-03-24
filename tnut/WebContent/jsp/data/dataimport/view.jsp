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
	page="/include/menu_customer.jsp" flush="true" />
<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/DataimportInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportInfo.TABLE_CN']}${msg['display.label.view']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/DataimportInfo/list?">${msg['label.DataimportInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li ><a href="<%=path%>/DataimportInfo/add?">${msg['label.DataimportInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
<li><a href="<%=path%>/DataimportInfo/import?">${msg['label.DataimportInfo.IMPORT']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportInfo/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="DataimportInfo.id" value="${DataimportInfo.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.DataimportInfo.ID']}</td>
		<td colspan="3"}>${DataimportInfo.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.CODE']}</td>
		<td colspan="3"}>${DataimportInfo.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.NAME']}</td>
		<td colspan="3"}>${DataimportInfo.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.TYPE']}</td>
		<td colspan="3"}>${DataimportInfo.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.STATUS']}</td>
		<td colspan="3"}>${DataimportInfo.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.CREATE_DATE']}</td>
		<td colspan="3"}>${DataimportInfo.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.CREATE_BY']}</td>
		<td colspan="3"}>${DataimportInfo.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.UPDATE_TIME']}</td>
		<td colspan="3"}>${DataimportInfo.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.UPDATE_BY']}</td>
		<td colspan="3"}>${DataimportInfo.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.REMARK']}</td>
		<td colspan="3"}>${DataimportInfo.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportInfo.IS_READ']}</td>
		<td colspan="3"}>${DataimportInfo.is_read }</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.back']}"> 
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
