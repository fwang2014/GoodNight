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
	<li class="active">查看</li>
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

<form action="<%=path%>/DicType/list?" method="post"><INPUT
	TYPE="hidden" NAME="DicType.id" value="${DicType.id }" />
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.DicType.VALUE_TYPE']}</td>
		<td colspan="3"}>${DicType.value_type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.TYPE']}</td>
		<td colspan="3"}>${DicType.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.STATUS']}</td>
		<td colspan="3"}>
				<c:if test="${DicType.status =='0'}">
						${msg['label.INFO.DATA.UNCHECKED']}
				</c:if> 
				<c:if test="${DicType.status =='1'}">
						${msg['label.INFO.DATA.CHECKED']}
				</c:if>
		</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.CREATE_BY']}</td>
		<td colspan="3"}>${DicType.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.CREATE_DATE']}</td>
		<td colspan="3"}>${DicType.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.UPDATE_BY']}</td>
		<td colspan="3"}>${DicType.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.UPDATE_TIME']}</td>
		<td colspan="3"}>${DicType.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.PARENT_ID']}</td>
		<td colspan="3"}>${DicType.parent_id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.DicType.REMARK']}</td>
		<td colspan="3"}>${DicType.remark }</td>
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
