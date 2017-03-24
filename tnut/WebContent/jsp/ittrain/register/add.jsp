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
<div class="row-fluid"><jsp:include page="/include/menu_train.jsp"
	flush="true" />

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
	<li><a href="<%=path%>/${tab }/add?">登记${(Register.id==null||Register.id==0)?'新增':'修改' }</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
<form action="<%=path %>/Register/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Register.id" value="${Register.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Register.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.code" ID="Register.code" value="${Register.code }" maxLength="20"   /></td>
		<td>${msg['label.Register.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.name" ID="Register.name" value="${Register.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.type" ID="Register.type" value="${Register.type }" maxLength="20"   /></td>
		<td>${msg['label.Register.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.status" ID="Register.status" value="${Register.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.remark" ID="Register.remark" value="${Register.remark }" maxLength="500"   /></td>
		<td>${msg['label.Register.CONSULT_DATE']}</td>
		<td>
		<div class="control-group">
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
			<input size="16" type="text"  NAME="Register.consult_date" ID="Register.consult_date" 
			value="${Register.consult_date}" readonly="readonly">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input1" value="" />
		</div>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.RECORD_NO']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.record_no" ID="Register.record_no" value="${Register.record_no }" maxLength="20"   /></td>
		<td>${msg['label.Register.STUDY_NO']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.study_no" ID="Register.study_no" value="${Register.study_no }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.STUDY_NAME']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.study_name" ID="Register.study_name" value="${Register.study_name }" maxLength="50"   /></td>
		<td>${msg['label.Register.SEX']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.sex" ID="Register.sex" value="${Register.sex }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.BIRTHDAY']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.birthday" ID="Register.birthday" value="${Register.birthday }"    /></td>
		<td>${msg['label.Register.AGE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.age" ID="Register.age" value="${Register.age }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.ID_NO']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.id_no" ID="Register.id_no" value="${Register.id_no }" maxLength="20"   /></td>
		<td>${msg['label.Register.TEL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.tel" ID="Register.tel" value="${Register.tel }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.CITY_PROVINCE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.city_province" ID="Register.city_province" value="${Register.city_province }" maxLength="20"   /></td>
		<td>${msg['label.Register.CITY_CITY']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.city_city" ID="Register.city_city" value="${Register.city_city }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.CITY_COUTRY']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.city_coutry" ID="Register.city_coutry" value="${Register.city_coutry }" maxLength="20"   /></td>
		<td>${msg['label.Register.CITY_DETAIL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.city_detail" ID="Register.city_detail" value="${Register.city_detail }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.QQ']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.qq" ID="Register.qq" value="${Register.qq }" maxLength="20"   /></td>
		<td>${msg['label.Register.EMAIL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.email" ID="Register.email" value="${Register.email }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.OTHER_MODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.other_mode" ID="Register.other_mode" value="${Register.other_mode }" maxLength="50"   /></td>
		<td>${msg['label.Register.FAMILY_TEL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.family_tel" ID="Register.family_tel" value="${Register.family_tel }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.STUDY_LEVEL']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.study_level" ID="Register.study_level" value="${Register.study_level }" maxLength="20"   /></td>
		<td>${msg['label.Register.STUDY_LEVEL_OTHER']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.study_level_other" ID="Register.study_level_other" value="${Register.study_level_other }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.RECORD_DATE']}</td>
		<td>
		<div class="control-group">
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
			<input size="16" type="text"  NAME="Register.record_date" ID="Register.record_date" 
			value="${Register.record_date}" readonly="readonly">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input1" value="" />
		</div>
		</td>
		<td>${msg['label.Register.RECORD_BY']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.record_by" ID="Register.record_by" value="${Register.record_by }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.COURSE_CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.course_code" ID="Register.course_code" value="${Register.course_code }" maxLength="20"   /></td>
		<td>${msg['label.Register.COURSE_NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.course_name" ID="Register.course_name" value="${Register.course_name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.COURSE_ROUTE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.course_route" ID="Register.course_route" value="${Register.course_route }" maxLength="50"   /></td>
		<td>${msg['label.Register.COURSE_ROUT_OTHER']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.course_rout_other" ID="Register.course_rout_other" value="${Register.course_rout_other }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Register.STUDY_GOAL']}</td>
		<td><INPUT TYPE="TEXT" NAME="Register.study_goal" ID="Register.study_goal" value="${Register.study_goal }" maxLength="200"   /></td>
		<td>${msg['label.Register.PIC_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Register.pic_id" ID="Register.pic_id" value="${Register.pic_id }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/Register/list?'">
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
