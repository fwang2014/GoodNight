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
<jsp:include page="/include/menu_train.jsp"	flush="true" />
<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/${tab }/list?" class="label label-info">IT培训登记</a> <span
		class="divider">/</span></li>
	<li class="active">登记列表</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/${tab }/list?">登记列表</a></li>
	<li><a href="<%=path%>/${tab }/add?">登记新增</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">


<form action="<%=path %>/Class2/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Class2.id" value="${Class2.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Class2.CODE']}</td>
		<td colspan="3"}>${Class2.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.NAME']}</td>
		<td colspan="3"}>${Class2.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.TYPE']}</td>
		<td colspan="3"}>${Class2.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.STATUS']}</td>
		<td colspan="3"}>${Class2.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.CREATE_DATE']}</td>
		<td colspan="3"}>${Class2.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.CREATE_BY']}</td>
		<td colspan="3"}>${Class2.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.UPDATE_TIME']}</td>
		<td colspan="3"}>${Class2.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.UPDATE_BY']}</td>
		<td colspan="3"}>${Class2.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.START_DATE']}</td>
		<td colspan="3"}>${Class2.start_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.END_DATE']}</td>
		<td colspan="3"}>${Class2.end_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.CLASS_MEMBER_NUM']}</td>
		<td colspan="3"}>${Class2.class_member_num }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.COURCE_CODE']}</td>
		<td colspan="3"}>${Class2.cource_code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Class2.COURCE_NAME']}</td>
		<td colspan="3"}>${Class2.cource_name }</td>
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
