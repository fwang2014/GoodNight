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
	<li><a href="<%=path%>/Dothing/list?" class="label label-info">${msg['display.label.nav.customer']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Dothing.TABLE_CN']}${msg['display.label.view']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Dothing/list?">${msg['label.Dothing.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Dothing/add?">${msg['label.Dothing.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Dothing/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Dothing.id" value="${Dothing.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Dothing.ID']}</td>
		<td colspan="3"}>${Dothing.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.CODE']}</td>
		<td colspan="3"}>${Dothing.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.NAME']}</td>
		<td colspan="3"}>${Dothing.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.TYPE']}</td>
		<td colspan="3"}>${Dothing.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.STATUS']}</td>
		<td colspan="3"}>${Dothing.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.CREATE_DATE']}</td>
		<td colspan="3"}>${Dothing.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.CREATE_BY']}</td>
		<td colspan="3"}>${Dothing.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.UPDATE_TIME']}</td>
		<td colspan="3"}>${Dothing.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.UPDATE_BY']}</td>
		<td colspan="3"}>${Dothing.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.REMARK']}</td>
		<td colspan="3"}>${Dothing.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.START_TIME']}</td>
		<td colspan="3"}>${Dothing.start_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.END_TIME']}</td>
		<td colspan="3"}>${Dothing.end_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.DO_TYPE']}</td>
		<td colspan="3"}>${Dothing.do_type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.DO_STATUS']}</td>
		<td colspan="3"}>${Dothing.do_status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.RE_PERSONS']}</td>
		<td colspan="3"}>${Dothing.re_persons }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.CUSTOMER_ID']}</td>
		<td colspan="3"}>${Dothing.customer_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Dothing.CUSTOMER_NAME']}</td>
		<td colspan="3"}>${Dothing.customer_name }</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_back" class="btn btn-info" value="${msg['operate.back']}"> 
			<input type="buttom" name="btn_edit" class="btn btn-info" value="${msg['operate.edit']}" onclick="window.location='<%=path %>/Dothing/edit?id=${Dothing.id }'"> 
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
