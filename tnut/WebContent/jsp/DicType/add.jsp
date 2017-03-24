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
	<li class="active">数据字典<span class="divider">/</span></li>
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

<form action="<%=path%>/DicType/save?" method="post"><INPUT
	TYPE="hidden" NAME="DicType.id" value="${DicType.id }" />
<table class="table table-bordered">
	<tr>
		<td>${msg['label.DicType.VALUE_TYPE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicType.value_type"
			value="${DicType.value_type }" /></td>
		<td>${msg['label.DicType.TYPE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicType.type"
			value="${DicType.type }" readonly /></td>
	</tr>
	<tr>
		<td>${msg['label.DicType.STATUS']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicType.status"
			value="${DicType.status }" readonly />${msg['label.INFO.DATA.UNCHECKED']}</td>
		<td>${msg['label.DicType.CREATE_BY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicType.create_by"
			value="${DicType.create_by }" readonly /></td>
	</tr>
	<tr>
		<td>${msg['label.DicType.CREATE_DATE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicType.create_date"
			value="${DicType.create_date }" readonly /></td>
		<td>${msg['label.DicType.UPDATE_BY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="DicType.update_by"
			value="${DicType.update_by }" readonly /></td>
	</tr>
	<tr>

		<td>${msg['label.DicType.REMARK']}<font color="red">*</font></td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="DicType.remark"
			value="${DicType.remark }" style="width: 85%" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="保存"> <input
			type="reset" name="btn_reset" class="btn btn-info" value="重置">
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/DicType/list?'">
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
