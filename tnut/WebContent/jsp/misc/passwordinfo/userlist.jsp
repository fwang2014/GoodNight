<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.nutz.utils.DateConvertUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String tab = (String)request.getAttribute("tab");
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
<li><a href="<%=path%>/PasswordInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li ><a href="<%=path%>/PasswordInfo/list?">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/PasswordInfo/add?">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
<li class="active"><a href="<%=path%>/PasswordInfo/userlist?">${msg['label.User.TABLE_CN']}${msg['display.label.list']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">


<form action="<%=path%>/User/list?" method="post" id="listForm"
	name="listForm">
<table class="table table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" name="all" onclick="selectAll('ids')"/></th>
			<th>${msg['label.User.CODE']}</th>
			<th>${msg['label.User.NAME']}</th>
			<th>${msg['label.User.TYPE']}</th>
			<th>${msg['label.User.STATUS']}</th>
			<th>${msg['label.User.ACCOUNT_NAME']}</th>
			<th>${msg['label.User.NICK_NAME']}</th>
			<th>${msg['label.User.LAST_LOGIN_TIME']}</th>
			<th>${msg['label.User.LOGIN_TIME']}</th>
			<th>${msg['label.User.LOGIN_TIMES']}</th>
			<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${page.list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap><c:if test="${tag.status =='0'}">
					<input type="checkbox" name="ids" value="${tag.id}" />
				</c:if></td>
				<td nowrap>${tag.code}</td>
				<td nowrap>${tag.name}</td>
				<td nowrap>${tag.type}</td>
				<td nowrap>${tag.status}</td>
				<td nowrap>${tag.account_name}</td>
				<td nowrap>${tag.nick_name}</td>
				<td nowrap>${tag.last_login_time}</td>
				<td nowrap>${tag.login_time}</td>
				<td nowrap>${tag.login_times}</td>
				<td nowrap>
				<c:if test="${tag.status =='0'}">
					
					<a href="<%=path%>/PasswordInfo/edit?uid=${tag.id}" /><i class="icon-edit"></i></a>
				</c:if></td>
			</tr>
		</c:forEach>
		<tr class="tr_data">
			<td colspan="11" align="center"><jsp:include
				page="/include/pagination.jsp" flush="true" /></td>
		</tr>

	</tbody>
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

<script src="<%=path%>/assets/js/application.js"></script>

<jsp:include page="/include/list_js.jsp" flush="true" />

</body>
</html>
