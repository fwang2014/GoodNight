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
<li><a href="<%=path%>/ClassMember/list?" class="label label-info">IT${msg['label.ClassMember.TABLE_CN']}</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/ClassMember/list?" class="label label-info">${msg['label.Class2.TABLE_CN']}${msg['display.label.list']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.ClassMember.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li><a href="<%=path%>/ClassMember/list?pid=${parent.id }">${msg['label.ClassMember.TABLE_CN']}${msg['display.label.list']}</a></li>
<li  class="active"><a href="<%=path%>/ClassMember/add?pid=${parent.id }">${msg['label.ClassMember.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/ClassMember/list?pid=${pid }" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="ClassMember.id" value="${ClassMember.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.ClassMember.ID']}</td>
		<td colspan="3"}>${ClassMember.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.CODE']}</td>
		<td colspan="3"}>${ClassMember.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.NAME']}</td>
		<td colspan="3"}>${ClassMember.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.TYPE']}</td>
		<td colspan="3"}>${ClassMember.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.STATUS']}</td>
		<td colspan="3"}>${ClassMember.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.CREATE_DATE']}</td>
		<td colspan="3"}>${ClassMember.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.CREATE_BY']}</td>
		<td colspan="3"}>${ClassMember.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.UPDATE_TIME']}</td>
		<td colspan="3"}>${ClassMember.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.UPDATE_BY']}</td>
		<td colspan="3"}>${ClassMember.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.REMARK']}</td>
		<td colspan="3"}>${ClassMember.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.ClassMember.CLASS_ID']}</td>
		<td colspan="3"}>${ClassMember.class_id }</td>
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
