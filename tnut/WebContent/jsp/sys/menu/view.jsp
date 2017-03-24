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
<li><a href="<%=path%>/Menu/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.Menu.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/Menu/list?">${msg['label.Menu.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/Menu/add?">${msg['label.Menu.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Menu/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Menu.id" value="${Menu.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Menu.ID']}</td>
		<td colspan="3"}>${Menu.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.CODE']}</td>
		<td colspan="3"}>${Menu.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.NAME']}</td>
		<td colspan="3"}>${Menu.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.TYPE']}</td>
		<td colspan="3"}>${Menu.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.STATUS']}</td>
		<td colspan="3"}>${Menu.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.CREATE_DATE']}</td>
		<td colspan="3"}>${Menu.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.CREATE_BY']}</td>
		<td colspan="3"}>${Menu.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.UPDATE_TIME']}</td>
		<td colspan="3"}>${Menu.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.UPDATE_BY']}</td>
		<td colspan="3"}>${Menu.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.REMARK']}</td>
		<td colspan="3"}>${Menu.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.PARENT_ID']}</td>
		<td colspan="3"}>${Menu.parent_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.URL']}</td>
		<td colspan="3"}>${Menu.url }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.MENU_ICON']}</td>
		<td colspan="3"}>${Menu.menu_icon }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.IS_ROOT']}</td>
		<td colspan="3"}>${Menu.is_root }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Menu.ORDER_INDEX']}</td>
		<td colspan="3"}>${Menu.order_index }</td>
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
