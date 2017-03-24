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
	page="/include/menu_train.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Course/list?" class="label label-info">IT${msg['label.Class2.TABLE_CN']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Class2.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Course/list?">${msg['label.Class2.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Course/add?">${msg['label.Class2.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path%>/Course/save?" method="post" id="addForm"
	name="addForm"><INPUT TYPE="hidden" NAME="Course.id"
	value="${Course.id }" />
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Course.CODE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Course.code" ID="Course.code"
			value="${Course.code }" /></td>
		<td>${msg['label.Course.NAME']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Course.name" ID="Course.name"
			value="${Course.name }" /></td>
	</tr>
	<tr>
		<td>${msg['label.Course.TYPE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Course.type" ID="Course.type" readonly="readonly"
			value="${Course.type }" /></td>
		<td>${msg['label.Course.STATUS']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Course.status" ID="Course.status" readonly="readonly"
			value="${Course.status }" /></td>
	</tr>
	<tr>
		<td>${msg['label.Course.STUDY_CONDITION']}<font color="red">*</font></td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Course.study_condition" ID="Course.study_condition" >${Course.study_condition }</textarea>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Course.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Course.remark" ID="Course.remark">${Course.remark}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="保存"> <input
			type="reset" name="btn_reset" class="btn btn-info" value="重置">
		<input type="button" name="btn_back" class="btn btn-info" value="取消"
			onclick="window.location='<%=path%>/Course/list?'"></td>
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
