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
	<li><a href="<%=path%>/Log/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Log.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Log/list?">${msg['label.Log.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Log/add?">${msg['label.Log.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Log/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Log.id" value="${Log.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Log.ID']}</td>
		<td colspan="3"}>${Log.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.CODE']}</td>
		<td colspan="3"}>${Log.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.NAME']}</td>
		<td colspan="3"}>${Log.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.TYPE']}</td>
		<td colspan="3"}>${Log.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.STATUS']}</td>
		<td colspan="3"}>${Log.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.CREATE_DATE']}</td>
		<td colspan="3"}>${Log.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.CREATE_BY']}</td>
		<td colspan="3"}>${Log.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.UPDATE_TIME']}</td>
		<td colspan="3"}>${Log.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.UPDATE_BY']}</td>
		<td colspan="3"}>${Log.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.REMARK']}</td>
		<td colspan="3"}>${Log.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Log.REQ_IP']}</td>
		<td colspan="3"}>${Log.req_ip }</td>
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
