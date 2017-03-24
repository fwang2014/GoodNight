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
<li><a href="<%=path%>/DataimportCol/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportCol.TABLE_CN']}${msg['display.label.view']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/DataimportCol/list?">${msg['label.DataimportCol.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/DataimportCol/add?">${msg['label.DataimportCol.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportCol/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="DataimportCol.id" value="${DataimportCol.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.DataimportCol.ID']}</td>
		<td colspan="3"}>${DataimportCol.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.CODE']}</td>
		<td colspan="3"}>${DataimportCol.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.NAME']}</td>
		<td colspan="3"}>${DataimportCol.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.TYPE']}</td>
		<td colspan="3"}>${DataimportCol.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.STATUS']}</td>
		<td colspan="3"}>${DataimportCol.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.CREATE_DATE']}</td>
		<td colspan="3"}>${DataimportCol.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.CREATE_BY']}</td>
		<td colspan="3"}>${DataimportCol.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.UPDATE_TIME']}</td>
		<td colspan="3"}>${DataimportCol.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.UPDATE_BY']}</td>
		<td colspan="3"}>${DataimportCol.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.REMARK']}</td>
		<td colspan="3"}>${DataimportCol.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportCol.IMPORT_PART_ID']}</td>
		<td colspan="3"}>${DataimportCol.import_part_id }</td>
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
