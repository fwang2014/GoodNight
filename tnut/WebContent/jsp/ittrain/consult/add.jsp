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

<link href="<%=path%>/assets/css/datetimepicker.css" rel="stylesheet">


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
	<li><a href="<%=path%>/Consult/list?">${msg['label.Consult.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li class="active"><a href="<%=path%>/Consult/add?">${msg['label.Consult.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">


<form action="<%=path %>/Consult/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Consult.id" value="${Consult.id }"/>
<table class="table table-bordered">
	<tr>
		<td >${msg['label.Consult.CODE']}<font color="red">*</font></td></td>
		<td >
		<INPUT TYPE="TEXT" NAME="Consult.code" ID="Consult.code" value="${Consult.code }" maxLength="20"
		   valNullable="N" valMsg="Input Something here,please" style="margin: 0 auto;"/></td> 
		<td>${msg['label.Consult.NAME']}<font color="red">*</font></td></td>
		<td >
				<INPUT TYPE="TEXT" NAME="Consult.name" ID="Consult.name" value="${Consult.name }" 
				 maxLength="50"   valNullable="N" valMsg="Input Something here,please"  style="margin: 0 auto;"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.TYPE']}</td>
		<td>
			<mytag:mytag elementType="select" dictCode="DATE_TYPE" value="0" id="Consult.type" read="true"></mytag:mytag>
			<!--
			<INPUT TYPE="TEXT" NAME="Consult.type" ID="Consult.type" value="${Consult.type }" maxLength="20"   />
			-->
		</td>
		<td>${msg['label.Consult.STATUS']}</td>
		<td>
			<mytag:mytag elementType="select" dictCode="DATE_STATUS" value="0" id="Consult.status"  read="true"></mytag:mytag>
			<!--
			<INPUT TYPE="TEXT" NAME="Consult.status" ID="Consult.status" value="${Consult.status }"    onblur="valNumber(this)" />
			-->
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.remark" ID="Consult.remark" value="${Consult.remark }" maxLength="500"   /></td>
		<td>${msg['label.Consult.CONSULT_DATE']}</td>
		<td>
		<div class="control-group">
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
				<input size="16" type="text"  NAME="Consult.consult_date" ID="Consult.consult_date" 
				value="${Consult.consult_date}" readonly="readonly">
				<span class="add-on"><i class="icon-remove"></i></span>
				<span class="add-on"><i class="icon-th"></i></span>
				</div>
				<input type="hidden" id="dtp_input1" value="" />
		</div>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.RECORD_NO']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.record_no" ID="Consult.record_no" value="${Consult.record_no }" maxLength="20"   /></td>
		<td>${msg['label.Consult.STUDY_NO']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.study_no" ID="Consult.study_no" value="${Consult.study_no }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.STUDY_NAME']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.study_name" ID="Consult.study_name" value="${Consult.study_name }" maxLength="50"   /></td>
		<td>${msg['label.Consult.SEX']}<font color="red">*</font></td></td>
		<td>
			<mytag:mytag elementType="select" dictCode="SEX" value="${Consult.sex }" id="Consult.sex" read="false"></mytag:mytag>
			<!--<INPUT TYPE="TEXT" NAME="Consult.sex" ID="Consult.sex" value="${Consult.sex }"  maxLength="20" 
			  valNullable="N" valMsg="Input Something here,please"/>
		--></td>
	</tr>
	<tr>
		<td>${msg['label.Consult.BIRTHDAY']}<font color="red">*</font></td></td>
		<td>
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2">
			<input size="16" type="text"  NAME="Consult.birthday" ID="Consult.birthday" 
			value="${Consult.birthday}" readonly="readonly">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input2" value="" />
		<!--<INPUT TYPE="TEXT" NAME="Consult.birthday" ID="Consult.birthday" value="${Consult.birthday }"  
		  valNullable="N" valMsg="Input Something here,please"/>
		 --></td>
		<td>${msg['label.Consult.AGE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.age" ID="Consult.age" value="${Consult.age }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.ID_NO']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="Consult.id_no" ID="Consult.id_no" value="${Consult.id_no }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.Consult.TEL']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.tel" ID="Consult.tel" value="${Consult.tel }"  maxLength="20"   valNullable="N" valMsg="Input Something here,please"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.CITY_PROVINCE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.city_province" ID="Consult.city_province" value="${Consult.city_province }" maxLength="20"   /></td>
		<td>${msg['label.Consult.CITY_CITY']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.city_city" ID="Consult.city_city" value="${Consult.city_city }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.CITY_COUTRY']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.city_coutry" ID="Consult.city_coutry" value="${Consult.city_coutry }" maxLength="20"   /></td>
		<td>${msg['label.Consult.CITY_DETAIL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.city_detail" ID="Consult.city_detail" value="${Consult.city_detail }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.QQ']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.qq" ID="Consult.qq" value="${Consult.qq }" maxLength="20"   /></td>
		<td>${msg['label.Consult.EMAIL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.email" ID="Consult.email" value="${Consult.email }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.OTHER_MODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.other_mode" ID="Consult.other_mode" value="${Consult.other_mode }" maxLength="50"   /></td>
		<td>${msg['label.Consult.FAMILY_TEL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.family_tel" ID="Consult.family_tel" value="${Consult.family_tel }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.STUDY_LEVEL']}<font color="red">*</font></td></td>
		<td>
			<mytag:mytag elementType="select" dictCode="STUDY_LEVEL" value="${Consult.study_level }" id="Consult.study_level" read="false"></mytag:mytag>
		<!--<INPUT TYPE="TEXT" NAME="Consult.study_level" ID="Consult.study_level" value="${Consult.study_level }" 
		maxLength="20"   valNullable="N" valMsg="Input Something here,please"/>
		--></td>
		<td>${msg['label.Consult.STUDY_LEVEL_OTHER']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.study_level_other" ID="Consult.study_level_other" value="${Consult.study_level_other }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.RECORD_DATE']}</td>
		<td>
		<div class="control-group">
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
			<input size="16" type="text"  NAME="Consult.record_date" ID="Consult.record_date" 
			value="${Consult.record_date}" readonly="readonly">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input1" value="" />
		</div>
		</td>
		<td>${msg['label.Consult.RECORD_BY']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.record_by" ID="Consult.record_by" value="${Consult.record_by }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.COURSE_CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.course_code" ID="Consult.course_code" value="${Consult.course_code }" maxLength="20"   /></td>
		<td>${msg['label.Consult.COURSE_NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.course_name" ID="Consult.course_name" value="${Consult.course_name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.COURSE_ROUTE']}</td>
		<td>
			<mytag:mytag elementType="select" dictCode="COURSE_ROUTE" value="${Consult.course_route }" id="Consult.course_route"></mytag:mytag>
			<!--
			<INPUT TYPE="TEXT" NAME="Consult.course_route" ID="Consult.course_route" value="${Consult.course_route }" maxLength="50"   />
			-->
		</td>
		<td>${msg['label.Consult.COURSE_ROUT_OTHER']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Consult.course_rout_other" ID="Consult.course_rout_other" value="${Consult.course_rout_other }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Consult.STUDY_GOAL']}</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.study_goal" ID="Consult.study_goal" value="${Consult.study_goal }" maxLength="200"   /></td>
		<td>${msg['label.Consult.PIC_ID']}</td>
		<td>
			
			<INPUT TYPE="TEXT" NAME="Consult.pic_id" ID="Consult.pic_id" value="${Consult.pic_id }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/Consult/list?'">
		</td>
	</tr>
</table>
</form>


</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" />
<jsp:include page="/include/js.jsp" flush="true" />

<script type="text/javascript">
	$('.form_date').datetimepicker({
	    language:  'cs',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});	
</script>

</body>
</html>
