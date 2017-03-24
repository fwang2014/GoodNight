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
<div class="row-fluid"><jsp:include page="/include/menu_sys.jsp"
	flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/sys?" class="label label-info">系统管理</a> <span
		class="divider">/</span></li>
	<li class="active">数据字典</li>
	<li class="active">新增</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/sys?">用户管理</a></li>
	<li><a href="<%=path%>/role?">角色管理</a></li>
	<li><a href="<%=path%>/function?">功能管理</a></li>
	<li><a href="<%=path%>/right?">权限管理</a></li>
	<li><a href="<%=path%>/log?">日志管理</a></li>
	<li class="active"><a href="<%=path%>/datadic?">数据字典</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path%>/DicValue/save?" method="post" id="addForm"
	name="addForm"><INPUT TYPE="hidden" NAME="DicValue.id"
	value="${DicValue.id }" />
<table class="table table-bordered">
	
	<tr>
		<td>${msg['label.DicValue.VALUE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.value"
			value="${DicValue.value }" /></td>
				<td>${msg['label.DicValue.UPDATE_TIME']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.update_time"
			value="${DicValue.update_time }" readonly/></td>
	</tr>
	<tr>
		<td>${msg['label.DicValue.REMARK']}<font color="red">*</font></td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="DicValue.remark"
			value="${DicValue.remark }" style="width:85%"/></td>

	</tr>
	<tr>
		<td>${msg['label.DicValue.TYPE_ID']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.type_id"
			value="${DicValue.type_id }" readonly/></td>
		<td>${msg['label.DicValue.TYPE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.type"
			value="${DicValue.type }" readonly/></td>
	</tr>
	<tr>
		<td>${msg['label.DicValue.STATUS']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.status"
			value="${DicValue.status }" readonly/></td>
		<td>${msg['label.DicValue.CREATE_BY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.create_by"
			value="${DicValue.create_by }" readonly/></td>
	</tr>
	<tr>
		<td>${msg['label.DicValue.CREATE_DATE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.create_date"
			value="${DicValue.create_date }" readonly/></td>
		<td>${msg['label.DicValue.UPDATE_BY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicValue.update_by"
			value="${DicValue.update_by }" readonly/></td>
	</tr>

	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input	type="reset" name="btn_reset" class="btn btn-info" value="重置">
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/DicValue/list?'">
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
