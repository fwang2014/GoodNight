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
	<li><a href="<%=path%>/${tab }/list?" class="label label-info">IT培训登记</a> <span
		class="divider">/</span></li>
	<li class="active">登记列表</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/${tab }/list?">登记列表</a></li>
	<li><a href="<%=path%>/${tab }/add?">登记新增</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Register/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="Register.id" value="${Register.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.Register.ID']}</td>
		<td colspan="3"}>${Register.id }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CODE']}</td>
		<td colspan="3"}>${Register.code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.NAME']}</td>
		<td colspan="3"}>${Register.name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.TYPE']}</td>
		<td colspan="3"}>${Register.type }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.STATUS']}</td>
		<td colspan="3"}>${Register.status }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CREATE_DATE']}</td>
		<td colspan="3"}>${Register.create_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CREATE_BY']}</td>
		<td colspan="3"}>${Register.create_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.UPDATE_TIME']}</td>
		<td colspan="3"}>${Register.update_time }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.UPDATE_BY']}</td>
		<td colspan="3"}>${Register.update_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.REMARK']}</td>
		<td colspan="3"}>${Register.remark }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CONSULT_DATE']}</td>
		<td colspan="3"}>${Register.consult_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.RECORD_NO']}</td>
		<td colspan="3"}>${Register.record_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.STUDY_NO']}</td>
		<td colspan="3"}>${Register.study_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.STUDY_NAME']}</td>
		<td colspan="3"}>${Register.study_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.SEX']}</td>
		<td colspan="3"}>${Register.sex }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.BIRTHDAY']}</td>
		<td colspan="3"}>${Register.birthday }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.AGE']}</td>
		<td colspan="3"}>${Register.age }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.ID_NO']}</td>
		<td colspan="3"}>${Register.id_no }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.TEL']}</td>
		<td colspan="3"}>${Register.tel }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CITY_PROVINCE']}</td>
		<td colspan="3"}>${Register.city_province }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CITY_CITY']}</td>
		<td colspan="3"}>${Register.city_city }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CITY_COUTRY']}</td>
		<td colspan="3"}>${Register.city_coutry }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.CITY_DETAIL']}</td>
		<td colspan="3"}>${Register.city_detail }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.QQ']}</td>
		<td colspan="3"}>${Register.qq }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.EMAIL']}</td>
		<td colspan="3"}>${Register.email }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.OTHER_MODE']}</td>
		<td colspan="3"}>${Register.other_mode }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.FAMILY_TEL']}</td>
		<td colspan="3"}>${Register.family_tel }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.STUDY_LEVEL']}</td>
		<td colspan="3"}>${Register.study_level }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.STUDY_LEVEL_OTHER']}</td>
		<td colspan="3"}>${Register.study_level_other }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.RECORD_DATE']}</td>
		<td colspan="3"}>${Register.record_date }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.RECORD_BY']}</td>
		<td colspan="3"}>${Register.record_by }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.COURSE_CODE']}</td>
		<td colspan="3"}>${Register.course_code }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.COURSE_NAME']}</td>
		<td colspan="3"}>${Register.course_name }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.COURSE_ROUTE']}</td>
		<td colspan="3"}>${Register.course_route }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.COURSE_ROUT_OTHER']}</td>
		<td colspan="3"}>${Register.course_rout_other }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.STUDY_GOAL']}</td>
		<td colspan="3"}>${Register.study_goal }</td>
	</tr>
	<tr>
		<td width="25%">${msg['label.Register.PIC_ID']}</td>
		<td colspan="3"}>${Register.pic_id }</td>
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
