<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mytag" uri="http://java.sun.com/jsp/mytag"%>
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
	page="/include/menu_customer.jsp" flush="true" />
<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Customer/list?" class="label label-info">${msg['label.Customer.TABLE_CN']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Customer.TABLE_CN']}${msg['display.label.view']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Customer/list?">${msg['label.Customer.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Customer/add?">${msg['label.Customer.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Customer/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Customer.id" value="${Customer.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Customer.ID']}</td>
		<td colspan="3"}>${Customer.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.CODE']}</td>
		<td colspan="3"}>${Customer.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.NAME']}</td>
		<td colspan="3"}>${Customer.name }</td>
	</tr>
	
	<tr>
		<td width="25%">${msg['label.Customer.SEX']}</td>
		<td colspan="3"}>
			<mytag:out dictCode="SEX" id="Customer.sex " value="${Customer.sex }"></mytag:out>
		</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.BIRTHDAY_DATE']}</td>
		<td colspan="3"}>${Customer.birthday_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.AGE']}</td>
		<td colspan="3"}>${Customer.age }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.EDU_LEVEL']}</td>
		<td colspan="3"}>${Customer.edu_level }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.WORK_STATUS']}</td>
		<td colspan="3"}>
			<mytag:out dictCode="WORK_STATUS" id="Customer.work_status" value="${Customer.work_status }"></mytag:out>
		</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.MOBILE']}</td>
		<td colspan="3"}>${Customer.mobile }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.TEL']}</td>
		<td colspan="3"}>${Customer.tel }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.PHONE']}</td>
		<td colspan="3"}>${Customer.phone }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.HOUSE']}</td>
		<td colspan="3"}>${Customer.house }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.EMAIL']}</td>
		<td colspan="3"}>${Customer.email }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.QQ']}</td>
		<td colspan="3"}>${Customer.qq }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.MSN']}</td>
		<td colspan="3"}>${Customer.msn }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.ALIWW']}</td>
		<td colspan="3"}>${Customer.aliww }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.WEBSITE']}</td>
		<td colspan="3"}>${Customer.website }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.ID_NO']}</td>
		<td colspan="3"}>${Customer.id_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.BANK_CARD']}</td>
		<td colspan="3"}>${Customer.bank_card }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.DUTIES']}</td>
		<td colspan="3"}>${Customer.duties }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.TITLE']}</td>
		<td colspan="3"}>${Customer.title }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.TYPE']}</td>
		<td colspan="3"}>
			<mytag:out dictCode="DATA_TYPE" id="Customer.type" value="${Customer.type }"></mytag:out>
		</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.STATUS']}</td>
		<td colspan="3"}>
			<mytag:out dictCode="DATA_STATUS" id="Customer.status" value="${Customer.status }"></mytag:out>
		</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.CREATE_DATE']}</td>
		<td colspan="3"}>${Customer.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.CREATE_BY']}</td>
		<td colspan="3"}>${Customer.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.UPDATE_TIME']}</td>
		<td colspan="3"}>${Customer.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.UPDATE_BY']}</td>
		<td colspan="3"}>${Customer.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Customer.REMARK']}</td>
		<td colspan="3"}>${Customer.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['display.label.affix.info']}</td>
		<td colspan="3"}>
			<c:forEach items="${fileList}" var="tag" varStatus="id">
				<span class="badge">${id.count }</span>
				&nbsp;
				<a href="#" target="_blank">${tag.file_old_name }</a>
				&nbsp;&nbsp;<a href="#" title="${msg['operate.del'] }"><i class="icon-remove"></i></a>
				|&nbsp;<a href="<%=path %>/Download?id=${tag.id }" title="${msg['operate.download'] }" target="_blank"><i class="icon-download-alt"></i></a>
				<c:if test="${tag.file_type=='image/jpeg' ||tag.file_type=='image/gif' ||tag.file_type=='image/bmp' ||tag.file_type=='image/jpg'}">
				|&nbsp;<a href="<%=path %>/displayImage?id=${tag.id }" title="${msg['operate.picture.preview'] }" target="_blank"><i class="icon-picture"></i></a>
				</c:if>
				<br>
			</c:forEach>
		</td>
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
