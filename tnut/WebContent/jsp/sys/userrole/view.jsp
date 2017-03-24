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
<li><a href="<%=path%>/UserRole/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.UserRole.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/UserRole/list?">${msg['label.UserRole.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/UserRole/add?">${msg['label.UserRole.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/UserRole/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="UserRole.id" value="${UserRole.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.UserRole.ID']}</td>
		<td colspan="3"}>${UserRole.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.CODE']}</td>
		<td colspan="3"}>${UserRole.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.NAME']}</td>
		<td colspan="3"}>${UserRole.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.TYPE']}</td>
		<td colspan="3"}>${UserRole.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.STATUS']}</td>
		<td colspan="3"}>${UserRole.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.CREATE_DATE']}</td>
		<td colspan="3"}>${UserRole.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.CREATE_BY']}</td>
		<td colspan="3"}>${UserRole.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.UPDATE_TIME']}</td>
		<td colspan="3"}>${UserRole.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.UPDATE_BY']}</td>
		<td colspan="3"}>${UserRole.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.REMARK']}</td>
		<td colspan="3"}>${UserRole.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.USER_ID']}</td>
		<td colspan="3"}>${UserRole.user_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.UserRole.ROLE_ID']}</td>
		<td colspan="3"}>${UserRole.role_id }</td>
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
