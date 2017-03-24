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
<li><a href="<%=path%>/Role/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.Role.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/Role/list?">${msg['label.Role.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/Role/add?">${msg['label.Role.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Role/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Role.id" value="${Role.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Role.ID']}</td>
		<td colspan="3"}>${Role.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.CODE']}</td>
		<td colspan="3"}>${Role.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.NAME']}</td>
		<td colspan="3"}>${Role.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.TYPE']}</td>
		<td colspan="3"}>${Role.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.STATUS']}</td>
		<td colspan="3"}>${Role.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.CREATE_DATE']}</td>
		<td colspan="3"}>${Role.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.CREATE_BY']}</td>
		<td colspan="3"}>${Role.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.UPDATE_TIME']}</td>
		<td colspan="3"}>${Role.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.UPDATE_BY']}</td>
		<td colspan="3"}>${Role.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Role.REMARK']}</td>
		<td colspan="3"}>${Role.remark }</td>
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
