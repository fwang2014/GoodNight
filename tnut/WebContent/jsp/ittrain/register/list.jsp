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
	page="/include/menu_train.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/Register/list?" class="label label-info">IT${msg['label.Register.TABLE_CN']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.Register.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin: 0 none;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/Register/list?">${msg['label.Register.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/Register/add?">${msg['label.Register.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
<div class="btn-group">
<div class="btn-group" style="display: block;">
<button class="btn dropdown-toggle" data-toggle="dropdown">相关操作
<span class="caret"></span></button>
<ul class="dropdown-menu">
	<li><a href="<%=path%>/Register/add?"><i class="icon-pencil"></i>新增</a></li>
	<li><a href="#" onclick="delIds('listForm','ids')"><i
		class="icon-remove"></i>删除</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick="doCheck('listForm','ids')"><i
		class="icon-ok"></i>审核</a></li>
</ul>
</div>
<!-- /btn-group --></div>

<form action="<%=path %>/Register/list?" method="post"  id="listForm" name="listForm">
<table class="table table-bordered">
	<thead>
		<tr>
		<th><input type="checkbox" name="all"/></th>
		<th>${msg['label.Register.CODE']}</th>
		<th>${msg['label.Register.NAME']}</th>
		<th>${msg['label.Register.TYPE']}</th>
		<th>${msg['label.Register.STATUS']}</th>

		<th>${msg['label.Register.CONSULT_DATE']}</th>
		<th>${msg['label.Register.RECORD_NO']}</th>
		<th>${msg['label.Register.STUDY_NO']}</th>
		<th>${msg['label.Register.STUDY_NAME']}</th>
		<th>${msg['label.Register.SEX']}</th>

		<th>${msg['label.Register.AGE']}</th>

		<th>${msg['label.Register.TEL']}</th>

		<th>${msg['label.Register.CITY_DETAIL']}</th>

		<th>${msg['label.Register.STUDY_LEVEL']}</th>

		<th>${msg['label.Register.COURSE_NAME']}</th>

		<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
<tbody>

<c:forEach items="${page.list}" var="tag" varStatus="id">
	<tr class="tr_data">
<td nowrap>
<c:if test="${tag.status =='0'}">
<input type="checkbox" name="ids" value="${tag.id}"/>
</c:if>
</td>
			<td nowrap>${tag.code}</td>
			<td nowrap><a href="<%=path %>/Register/view?id=${tag.id}">${tag.name}</a></td>
			<td nowrap>${tag.type}</td>
			<td nowrap>${tag.status}</td>
			
			<td nowrap>${tag.consult_date}</td>
			<td nowrap>${tag.record_no}</td>
			<td nowrap>${tag.study_no}</td>
			<td nowrap>${tag.study_name}</td>
			<td nowrap>${tag.sex}</td>

			<td nowrap>${tag.age}</td>

			<td nowrap>${tag.tel}</td>

			<td nowrap>${tag.city_detail}</td>

			<td nowrap>${tag.study_level}</td>

			<td nowrap>${tag.course_name}</td>
		<td nowrap><a href="<%=path %>/Register/view?id=${tag.id}"/>${msg['label.OPERATION.VIEW']}</a>
<c:if test="${tag.status =='0'}">
		<span class="divider">|</span>
		<a href="<%=path%>/Register/edit?id=${tag.id}" /><i class="icon-edit"></i></a>
</c:if>
	</td>
	</tr>
</c:forEach>
<tr class="tr_data">
<td colspan="31" align="center">
<jsp:include page="/include/pagination.jsp" flush="true" />
</td>
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
