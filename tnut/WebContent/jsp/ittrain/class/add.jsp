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
 
 <form action="<%=path %>/Class2/save?" method="post"  id="addForm" name="addForm">
<INPUT TYPE="hidden" NAME="Class2.id" value="${Class2.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Class2.CODE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Class2.code" ID="Class2.code" value="${Class2.code }" style="margin:0;"/></td>
		<td>${msg['label.Class2.NAME']}<font color="red">*</font></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Class2.name" ID="Class2.name" value="${Class2.name }" style="margin:0;"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Class2.TYPE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Class2.type" ID="Class2.type" value="${Class2.type }" style="margin:0;"/></td>
		<td>${msg['label.Class2.STATUS']}<font color="red">*</font></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Class2.status" ID="Class2.status" value="${Class2.status }" readonly="readonly" style="margin:0;"/>
		</td>
	</tr>
	<tr style="display:none;">
		<td>${msg['label.Class2.CREATE_DATE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Class2.create_date" ID="Class2.create_date" value="${Class2.create_date }"/></td>
		<td>${msg['label.Class2.CREATE_BY']}<font color="red">*</font></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Class2.create_by" ID="Class2.create_by" value="${Class2.create_by }"/>
		</td> 
	</tr>
	<tr  style="display:none;">
		<td>${msg['label.Class2.UPDATE_TIME']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Class2.update_time" ID="Class2.update_time" value="${Class2.update_time }"/></td>
		<td>${msg['label.Class2.UPDATE_BY']}<font color="red">*</font></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Class2.update_by" ID="Class2.update_by" value="${Class2.update_by }"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Class2.START_DATE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Class2.start_date" ID="Class2.start_date" value="${Class2.start_date }" style="margin:0;"/></td>
		<td>${msg['label.Class2.END_DATE']}<font color="red">*</font></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Class2.end_date" ID="Class2.end_date" value="${Class2.end_date }" style="margin:0;"/>
		</td>
	</tr>

	<tr>
		<td>${msg['label.Class2.COURCE_CODE']}<font color="red">*</font></td>
		<td>
			<INPUT TYPE="TEXT" NAME="Class2.cource_code" ID="Class2.cource_code" value="${Class2.cource_code }" style="margin:0;"/>
			<a href="#myModal" role="button" class="btn" data-toggle="modal"><i class="icon-list-alt"></i></a>
		</td>
		<td>${msg['label.Class2.COURCE_NAME']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="Class2.cource_name" ID="Class2.cource_name" value="${Class2.cource_name }" style="margin:0;"/></td>
	</tr>
	<tr>
		<td>${msg['label.Class2.CLASS_MEMBER_NUM']}<font color="red">*</font></td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="Class2.class_member_num" ID="Class2.class_member_num" style="margin:0;" value="${Class2.class_member_num }" readonly="readonly"/></td>	
	</tr>
	<tr>
		<td>${msg['label.Class2.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Class2.remark" ID="Class2.remark">${Class2.remark}</textarea>
		</td>
	
	</tr>
	<tr>
	
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/Class2/list?'">
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
