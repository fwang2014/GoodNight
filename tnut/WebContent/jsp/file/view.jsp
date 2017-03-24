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
<div class="row-fluid">
	<jsp:include	page="/include/menu_data.jsp" flush="true" />
<div class="span9">

<div>

<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/FileUpload/list?" class="label label-info">IT${msg['label.FileUpload.TABLE_CN']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.FileUpload.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/FileUpload/list?">${msg['label.FileUpload.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/FileUpload/add?">${msg['label.FileUpload.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
<form action="<%=path %>/FileUpload/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="FileUpload.id" value="${FileUpload.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.FileUpload.ID']}</td>
		<td colspan="3"}>${FileUpload.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.CODE']}</td>
		<td colspan="3"}>${FileUpload.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.NAME']}</td>
		<td colspan="3"}>${FileUpload.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.TYPE']}</td>
		<td colspan="3"}>${FileUpload.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.STATUS']}</td>
		<td colspan="3"}>${FileUpload.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.CREATE_DATE']}</td>
		<td colspan="3"}>${FileUpload.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.CREATE_BY']}</td>
		<td colspan="3"}>${FileUpload.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.UPDATE_TIME']}</td>
		<td colspan="3"}>${FileUpload.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.UPDATE_BY']}</td>
		<td colspan="3"}>${FileUpload.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.REMARK']}</td>
		<td colspan="3"}>${FileUpload.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.FILE_TYPE']}</td>
		<td colspan="3"}>${FileUpload.file_type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.FILE_SIZE']}</td>
		<td colspan="3"}>${FileUpload.file_size }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.FILE_OLD_NAME']}</td>
		<td colspan="3"}>${FileUpload.file_old_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.FILE_NEW_NAME']}</td>
		<td colspan="3"}>${FileUpload.file_new_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.SAVE_PATH']}</td>
		<td colspan="3"}>${FileUpload.save_path }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.SAVE_TEM_PATH']}</td>
		<td colspan="3"}>${FileUpload.save_tem_path }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.REF_ID']}</td>
		<td colspan="3"}>${FileUpload.ref_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.FileUpload.REF_TYPE']}</td>
		<td colspan="3"}>${FileUpload.ref_type }</td>
	</tr>
	<tr>
		<td width="25%">Brown Picture</td>
		<td colspan="3"}>
			<img alt="${FileUpload.file_new_name }" src="<%=path %>/displayImage?id=${FileUpload.id }" width="180" height="150">
		</td>
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

<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=path%>/assets/js/jquery.js"></script>
<script src="<%=path%>/assets/js/bootstrap-transition.js"></script>
<script src="<%=path%>/assets/js/bootstrap-alert.js"></script>
<script src="<%=path%>/assets/js/bootstrap-modal.js"></script>
<script src="<%=path%>/assets/js/bootstrap-dropdown.js"></script>
<script src="<%=path%>/assets/js/bootstrap-scrollspy.js"></script>
<script src="<%=path%>/assets/js/bootstrap-tab.js"></script>
<script src="<%=path%>/assets/js/bootstrap-tooltip.js"></script>
<script src="<%=path%>/assets/js/bootstrap-popover.js"></script>
<script src="<%=path%>/assets/js/bootstrap-button.js"></script>
<script src="<%=path%>/assets/js/bootstrap-collapse.js"></script>
<script src="<%=path%>/assets/js/bootstrap-carousel.js"></script>
<script src="<%=path%>/assets/js/bootstrap-typeahead.js"></script>

</body>
</html>
