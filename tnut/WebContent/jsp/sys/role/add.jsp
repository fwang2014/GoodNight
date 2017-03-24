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
<li><a href="<%=path%>/Role/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.Role.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li><a href="<%=path%>/Role/list?">${msg['label.Role.TABLE_CN']}${msg['display.label.list']}</a></li>
<li class="active"><a href="<%=path%>/Role/add?">${msg['label.Role.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Role/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Role.id" value="${Role.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Role.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Role.code" ID="Role.code" value="${Role.code }" maxLength="20"   /></td>
		<td>${msg['label.Role.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Role.name" ID="Role.name" value="${Role.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Role.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Role.type" ID="Role.type" value="${Role.type }" maxLength="20" readonly="readonly"  /></td>
		<td>${msg['label.Role.STATUS']}</td>
		<td>
			<INPUT TYPE="TEXT" NAME="Role.status" ID="Role.status" value="${Role.status }"  readonly="readonly"  onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Role.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Role.remark" ID="Role.remark" >${Role.remark }</textarea>
		</td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/Role/list?'">
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
