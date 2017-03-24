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
<div class="row-fluid"><jsp:include page="/include/menu_cost.jsp"
	flush="true" />
<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/SmStatterm/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.SmStatterm.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/SmStatterm/list?">${msg['label.SmStatterm.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/SmStatterm/add?">${msg['label.SmStatterm.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/SmStatterm/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="SmStatterm.id" value="${SmStatterm.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.SmStatterm.ID']}</td>
		<td colspan="3"}>${SmStatterm.id }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.CODE']}</td>
		<td colspan="3"}>${SmStatterm.code }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.NAME']}</td>
		<td colspan="3"}>${SmStatterm.name }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.TYPE']}</td>
		<td colspan="3"}>${SmStatterm.type }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.STARTDATE']}</td>
		<td colspan="3"}>${SmStatterm.startdate }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.ENDDATE']}</td>
		<td colspan="3"}>${SmStatterm.enddate }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.REMARK']}</td>
		<td colspan="3"}>${SmStatterm.remark }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.STATUS']}</td>
		<td colspan="3"}>${SmStatterm.status }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.CREATE_BY']}</td>
		<td colspan="3"}>${SmStatterm.create_by }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.CREATE_DATE']}</td>
		<td colspan="3"}>${SmStatterm.create_date }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.UPDATE_BY']}</td>
		<td colspan="3"}>${SmStatterm.update_by }</td>
	</tr>
	<tr>
		<td>${msg['label.SmStatterm.UPDATE_TIME']}</td>
		<td colspan="3"}>${SmStatterm.update_time }</td>
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
