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
<li><a href="<%=path%>/DataimportPic/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportPic.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/DataimportPic/list?">${msg['label.DataimportPic.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/DataimportPic/add?">${msg['label.DataimportPic.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportPic/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="DataimportPic.id" value="${DataimportPic.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.DataimportPic.ID']}</td>
		<td colspan="3"}>${DataimportPic.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.CODE']}</td>
		<td colspan="3"}>${DataimportPic.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.NAME']}</td>
		<td colspan="3"}>${DataimportPic.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.TYPE']}</td>
		<td colspan="3"}>${DataimportPic.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.STATUS']}</td>
		<td colspan="3"}>${DataimportPic.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.CREATE_DATE']}</td>
		<td colspan="3"}>${DataimportPic.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.CREATE_BY']}</td>
		<td colspan="3"}>${DataimportPic.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.UPDATE_TIME']}</td>
		<td colspan="3"}>${DataimportPic.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.UPDATE_BY']}</td>
		<td colspan="3"}>${DataimportPic.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.REMARK']}</td>
		<td colspan="3"}>${DataimportPic.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.IMPORT_PART_ID']}</td>
		<td colspan="3"}>${DataimportPic.import_part_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.PIC_NAME']}</td>
		<td colspan="3"}>${DataimportPic.pic_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.PIC_TYPE']}</td>
		<td colspan="3"}>${DataimportPic.pic_type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.PIC_SIZE']}</td>
		<td colspan="3"}>${DataimportPic.pic_size }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.PIC_TEM_PATH']}</td>
		<td colspan="3"}>${DataimportPic.pic_tem_path }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DataimportPic.PIC_SAVE_PATH']}</td>
		<td colspan="3"}>${DataimportPic.pic_save_path }</td>
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
