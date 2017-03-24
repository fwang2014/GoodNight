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
<li><a href="<%=path%>/LoginInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.view']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/LoginInfo/list?">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/LoginInfo/add?">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/LoginInfo/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="LoginInfo.id" value="${LoginInfo.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.LoginInfo.ID']}</td>
		<td colspan="3"}>${LoginInfo.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.CODE']}</td>
		<td colspan="3"}>${LoginInfo.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.NAME']}</td>
		<td colspan="3"}>${LoginInfo.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.TYPE']}</td>
		<td colspan="3"}>${LoginInfo.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.STATUS']}</td>
		<td colspan="3"}>${LoginInfo.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.CREATE_DATE']}</td>
		<td colspan="3"}>${LoginInfo.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.CREATE_BY']}</td>
		<td colspan="3"}>${LoginInfo.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.UPDATE_TIME']}</td>
		<td colspan="3"}>${LoginInfo.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.UPDATE_BY']}</td>
		<td colspan="3"}>${LoginInfo.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.REMARK']}</td>
		<td colspan="3"}>${LoginInfo.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.REQ_ID']}</td>
		<td colspan="3"}>${LoginInfo.req_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.REQ_ADDR']}</td>
		<td colspan="3"}>${LoginInfo.req_addr }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.REQ_PORT']}</td>
		<td colspan="3"}>${LoginInfo.req_port }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.REQ_URI']}</td>
		<td colspan="3"}>${LoginInfo.req_uri }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.LoginInfo.REQ_USER']}</td>
		<td colspan="3"}>${LoginInfo.req_user }</td>
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
