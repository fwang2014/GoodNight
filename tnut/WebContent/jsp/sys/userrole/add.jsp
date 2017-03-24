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
<li><a href="<%=path%>/UserRole/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.UserRole.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li ><a href="<%=path%>/UserRole/list?">${msg['label.UserRole.TABLE_CN']}${msg['display.label.list']}</a></li>
<li class="active"><a href="<%=path%>/UserRole/add?">${msg['label.UserRole.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/UserRole/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="UserRole.id" value="${UserRole.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.UserRole.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="UserRole.code" ID="UserRole.code" value="${UserRole.code }" maxLength="20"   /></td>
		<td>${msg['label.UserRole.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="UserRole.name" ID="UserRole.name" value="${UserRole.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.UserRole.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="UserRole.type" ID="UserRole.type" value="${UserRole.type }" maxLength="20"   /></td>
		<td>${msg['label.UserRole.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="UserRole.status" ID="UserRole.status" value="${UserRole.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.UserRole.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="UserRole.remark" ID="UserRole.remark" value="${UserRole.remark }" maxLength="500"   /></td>
		<td>${msg['label.UserRole.USER_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="UserRole.user_id" ID="UserRole.user_id" value="${UserRole.user_id }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.UserRole.ROLE_ID']}</td>
		<td><INPUT TYPE="TEXT" NAME="UserRole.role_id" ID="UserRole.role_id" value="${UserRole.role_id }"   onblur="valNumber(this)" /></td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/UserRole/list?'">
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
