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
	<li><a href="<%=path%>/CostFill/list?" class="label label-info">成本管理</a> <span
		class="divider">/</span></li>
	<li class="active">成本查询</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/CostFill/list?">成本查询</a></li>
	<li><a href="<%=path%>/CostFill/add?">成本填报</a></li>
	<li><a href="<%=path%>/CostFill/batch_add?">批量填报</a></li>
	<li><a href="<%=path%>/CostFill/rent_add?">房租填报</a></li>
	<li><a href="<%=path%>/CostFill/stat?">成本统计</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">


<form action="<%=path%>/CostFill/list?" method="post" id="viewForm"
	name="viewForm"><INPUT TYPE="hidden" NAME="CostFill.id"
	value="${CostFill.id }" />
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.CostFill.CODE']}</td>
		<td colspan="3"}>${CostFill.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.NAME']}</td>
		<td colspan="3"}>${CostFill.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.FILL_DATE']}</td>
		<td colspan="3"}>${CostFill.fill_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.START_VALUE']}</td>
		<td colspan="3"}>${CostFill.start_value }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.END_VALUE']}</td>
		<td colspan="3"}>${CostFill.end_value }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.PRICE']}</td>
		<td colspan="3"}>${CostFill.price }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.QTY']}</td>
		<td colspan="3"}>${CostFill.qty }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.AMT']}</td>
		<td colspan="3"}>${CostFill.amt }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.UNIT']}</td>
		<td colspan="3"}>${CostFill.unit_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.TYPE']}</td>
		<td colspan="3"}>${CostFill.type_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.VALUE_TYPE']}</td>
		<td colspan="3"}>${CostFill.value_type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.STATUS']}</td>
		<td colspan="3"}>${CostFill.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.CREATE_BY']}</td>
		<td colspan="3"}>${CostFill.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.CREATE_DATE']}</td>
		<td colspan="3"}>${CostFill.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.UPDATE_BY']}</td>
		<td colspan="3"}>${CostFill.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.CostFill.UPDATE_TIME']}</td>
		<td colspan="3"}>${CostFill.update_time }</td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="返回"></td>
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
