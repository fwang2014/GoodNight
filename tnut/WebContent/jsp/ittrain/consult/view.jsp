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
<div class="row-fluid">
<jsp:include page="/include/menu_train.jsp"	flush="true" />
<div class="span9">

<div>

<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Consult/list?" class="label label-info">IT${msg['label.Consult.TABLE_CN']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Consult.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Consult/list?">${msg['label.Consult.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Consult/add?">${msg['label.Consult.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Consult/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Consult.id" value="${Consult.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Consult.ID']}</td>
		<td colspan="3"}>${Consult.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CODE']}</td>
		<td colspan="3"}>${Consult.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.NAME']}</td>
		<td colspan="3"}>${Consult.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.TYPE']}</td>
		<td colspan="3"}>${Consult.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.STATUS']}</td>
		<td colspan="3"}>${Consult.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CREATE_DATE']}</td>
		<td colspan="3"}>${Consult.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CREATE_BY']}</td>
		<td colspan="3"}>${Consult.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.UPDATE_TIME']}</td>
		<td colspan="3"}>${Consult.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.UPDATE_BY']}</td>
		<td colspan="3"}>${Consult.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.REMARK']}</td>
		<td colspan="3"}>${Consult.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CONSULT_DATE']}</td>
		<td colspan="3"}>${Consult.consult_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.RECORD_NO']}</td>
		<td colspan="3"}>${Consult.record_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.STUDY_NO']}</td>
		<td colspan="3"}>${Consult.study_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.STUDY_NAME']}</td>
		<td colspan="3"}>${Consult.study_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.SEX']}</td>
		<td colspan="3"}>${Consult.sex }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.BIRTHDAY']}</td>
		<td colspan="3"}>${Consult.birthday }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.AGE']}</td>
		<td colspan="3"}>${Consult.age }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.ID_NO']}</td>
		<td colspan="3"}>${Consult.id_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.TEL']}</td>
		<td colspan="3"}>${Consult.tel }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CITY_PROVINCE']}</td>
		<td colspan="3"}>${Consult.city_province }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CITY_CITY']}</td>
		<td colspan="3"}>${Consult.city_city }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CITY_COUTRY']}</td>
		<td colspan="3"}>${Consult.city_coutry }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.CITY_DETAIL']}</td>
		<td colspan="3"}>${Consult.city_detail }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.QQ']}</td>
		<td colspan="3"}>${Consult.qq }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.EMAIL']}</td>
		<td colspan="3"}>${Consult.email }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.OTHER_MODE']}</td>
		<td colspan="3"}>${Consult.other_mode }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.FAMILY_TEL']}</td>
		<td colspan="3"}>${Consult.family_tel }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.STUDY_LEVEL']}</td>
		<td colspan="3"}>${Consult.study_level }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.STUDY_LEVEL_OTHER']}</td>
		<td colspan="3"}>${Consult.study_level_other }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.RECORD_DATE']}</td>
		<td colspan="3"}>${Consult.record_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.RECORD_BY']}</td>
		<td colspan="3"}>${Consult.record_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.COURSE_CODE']}</td>
		<td colspan="3"}>${Consult.course_code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.COURSE_NAME']}</td>
		<td colspan="3"}>${Consult.course_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.COURSE_ROUTE']}</td>
		<td colspan="3"}>${Consult.course_route }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.COURSE_ROUT_OTHER']}</td>
		<td colspan="3"}>${Consult.course_rout_other }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.STUDY_GOAL']}</td>
		<td colspan="3"}>${Consult.study_goal }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Consult.PIC_ID']}</td>
		<td colspan="3"}>${Consult.pic_id }</td>
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
