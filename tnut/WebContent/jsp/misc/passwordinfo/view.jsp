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
<li><a href="<%=path%>/PasswordInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class=""><a href="<%=path%>/PasswordInfo/list?">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/PasswordInfo/add?">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
<li class="active"><a href="<%=path%>/PasswordInfo/userlist?">${msg['label.User.TABLE_CN']}${msg['display.label.list']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/PasswordInfo/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="PasswordInfo.id" value="${PasswordInfo.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.PasswordInfo.ID']}</td>
		<td colspan="3"}>${PasswordInfo.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.CODE']}</td>
		<td colspan="3"}>${PasswordInfo.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.NAME']}</td>
		<td colspan="3"}>${PasswordInfo.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.TYPE']}</td>
		<td colspan="3"}>${PasswordInfo.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.STATUS']}</td>
		<td colspan="3"}>${PasswordInfo.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.CREATE_DATE']}</td>
		<td colspan="3"}>${PasswordInfo.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.CREATE_BY']}</td>
		<td colspan="3"}>${PasswordInfo.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.UPDATE_TIME']}</td>
		<td colspan="3"}>${PasswordInfo.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.UPDATE_BY']}</td>
		<td colspan="3"}>${PasswordInfo.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.REMARK']}</td>
		<td colspan="3"}>${PasswordInfo.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.PasswordInfo.USER_ID']}</td>
		<td colspan="3"}>${PasswordInfo.user_id }</td>
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
