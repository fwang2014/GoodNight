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
	<li><a href="<%=path%>/RoleMenu/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.RoleMenu.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/RoleMenu/list?">${msg['label.RoleMenu.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/RoleMenu/add?">${msg['label.RoleMenu.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/RoleMenu/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="RoleMenu.id" value="${RoleMenu.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.RoleMenu.ID']}</td>
		<td colspan="3"}>${RoleMenu.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.CODE']}</td>
		<td colspan="3"}>${RoleMenu.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.NAME']}</td>
		<td colspan="3"}>${RoleMenu.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.TYPE']}</td>
		<td colspan="3"}>${RoleMenu.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.STATUS']}</td>
		<td colspan="3"}>${RoleMenu.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.CREATE_DATE']}</td>
		<td colspan="3"}>${RoleMenu.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.CREATE_BY']}</td>
		<td colspan="3"}>${RoleMenu.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.UPDATE_TIME']}</td>
		<td colspan="3"}>${RoleMenu.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.UPDATE_BY']}</td>
		<td colspan="3"}>${RoleMenu.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.REMARK']}</td>
		<td colspan="3"}>${RoleMenu.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.ROLE_ID']}</td>
		<td colspan="3"}>${RoleMenu.role_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.RoleMenu.MENU_ID']}</td>
		<td colspan="3"}>${RoleMenu.menu_id }</td>
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
