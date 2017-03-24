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
<li class="active"><a href="<%=path%>/ClassMember/list?pid=${parent.id }">${msg['label.ClassMember.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/ClassMember/add?pid=${parent.id }">${msg['label.ClassMember.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
	<div class="btn-group">
		<div class="btn-group" style="display: block;">
		<button class="btn dropdown-toggle" data-toggle="dropdown">${msg['operate.relation']}
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li><a href="<%=path%>/${tab }/add?pid=${parent.id }"><i class="icon-pencil"></i>${msg['operate.add']}</a></li>
			<li><a href="#" onclick="delIds('listForm','ids')">
			<i class="icon-remove"></i>${msg['operate.del']}</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="doCheck('listForm', 'ids');"><i class="icon-ok"></i>${msg['operate.check']}</a></li>
			<li class="divider"></li>
			<li><a href="<%=path%>/Class2/list?pid=${parent.id }" ><i class="icon-ok"></i>返回上一层</a></li>
		</ul>
		</div>
	<!-- /btn-group -->
	</div>

<div>
	<span class="label label-info">${parent.code }[${parent.name }]</span>
</div>

<form action="<%=path %>/ClassMember/list?pid=${parent.id }" method="post"  id="listForm" name="listForm">
<table class="table table-bordered">
	<thead>
		<tr>
		<th><input type="checkbox" name="all"  onclick="selectAll('ids')"/></th>
		<th>#</th>
		<th>${msg['label.ClassMember.CODE']}</th>
		<th>${msg['label.ClassMember.NAME']}</th>
		<th>${msg['label.ClassMember.TYPE']}</th>
		<th>${msg['label.ClassMember.STATUS']}</th>
		
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
			<td nowrap>${id.count}</td>
			<td nowrap>${tag.code}</td>
			<td nowrap title="${tag.remark }"><a href="<%=path %>/ClassMember/view?id=${tag.id}&pid=${parent.id }">${tag.name}</a></td>
			<td nowrap>${tag.type}</td>
			<td nowrap>${tag.status}</td>
		
			<td nowrap>
				<a href="<%=path %>/ClassMember/view?id=${tag.id}&pid=${parent.id }" title="查看"/><i class="icon-eye-open"></i></a>
					<c:if test="${tag.status =='0'}">
							<span class="divider">|</span>
							<a href="<%=path%>/ClassMember/edit?id=${tag.id}&pid=${parent.id }" title="编辑"/><i class="icon-edit"></i></a>
					</c:if>
			</td>
	</tr>
</c:forEach>
<tr class="tr_data">
	<td colspan="7" align="center">
		<jsp:include page="/include/pagination.jsp?pid=${parent.id }" flush="true" />
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
