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

<link href="<%=path%>/assets/css/datetimepicker.css" rel="stylesheet">

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
	<li><a href="<%=path%>/Consult/list?" class="label label-info">IT${msg['label.Consult.TABLE_CN']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Consult.TABLE_CN']}${msg['display.label.upload']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/Consult/list?">${msg['label.Consult.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Consult/add?">${msg['label.Consult.TABLE_CN']}${msg['display.label.add']}</a></li>
	<li class="active"><a href="<%=path%>/Consult/upload?">${msg['display.label.upload']}</a></li>
	<li><a href="<%=path%>/Consult/upload?">${msg['display.label.uploadManage']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path%>/uploadPhotos?" method="post" id="uploadForm"
	name="uploadForm" onsubmit="" enctype="multipart/form-data">
	<INPUT	TYPE="hidden" NAME="Consult.id" ID="Consult.id" value="${Consult.id }" />
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Consult.CODE']}<font color="red">*</font></td>
		</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.code" ID="Consult.code"
			value="${Consult.code }" maxLength="20" readonly="readonly" /> 
			
			 <a href="#myModal" role="button" class="btn" data-toggle="modal">
			 <i	class="icon-user"></i></a></td>
		<td>${msg['label.Consult.NAME']}<font color="red">*</font></td>
		</td>
		<td><INPUT TYPE="TEXT" NAME="Consult.name" ID="Consult.name"
			value="${Consult.name }" maxLength="50" readonly="readonly" /></td>
	</tr>
	<tr>
		<td>上载文件1(图片格式)</td>
		<td colspan="3"><input type="file" name="photo" id="photo" /></td>
	</tr>
	<tr>
		<td>上载文件2(图片格式)</td>
		<td colspan="3"><input type="file" name="photo" id="photo" /></td>
	</tr>
	<tr>
		<td>上载文件3(图片格式)</td>
		<td colspan="3"><input type="file" name="photo" id="photo" /></td>
	</tr>
	<tr>
		<td>上载文件4(图片格式)</td>
		<td colspan="3"><input type="file" name="photo" id="photo" /></td>
	</tr>
	<tr>
		<td>上载文件5(图片格式)</td>
		<td colspan="3"><input type="file" name="photo" id="photo" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="保存"> <input
			type="button" name="btn_back" class="btn btn-info" value="取消"
			onclick="window.location='<%=path%>/Consult/list?'"></td>
	</tr>
</table>
</form>

<div>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"	aria-hidden="true">×</button>
<h3 id="myModalLabel">咨询选择列表</h3>
</div>
<div class="modal-body">
<p>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>单选</th>
			<th>${msg['label.Consult.CODE']}</th>
			<th>${msg['label.Consult.NAME']}</th>
			<th>${msg['label.Consult.STUDY_NAME']}</th>
			<th>${msg['label.Consult.COURSE_NAME']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${page.list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap>
					<c:if test="${tag.status =='0'}">
						<input type="radio" name="list.ids" id="list.ids" value="${tag.id}" 
						onclick="setValues('list.ids','Consult.id','list.code','Consult.code','list.name','Consult.name')"/>
						<input type="hidden" name="list.code" id="list.code" value="${tag.code}" />
						<input type="hidden" name="list.name" id="list.name" value="${tag.name}" />
					</c:if>
				</td>
				<td nowrap>${tag.code}</td>
				<td nowrap title="${tag.remark}"><a
					href="<%=path%>/Consult/view?id=${tag.id}">${tag.name}</a></td>
				<td nowrap>${tag.study_name}</td>
				<td nowrap>${tag.course_name}</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
</p>
</div>
<div class="modal-footer">
<button class="btn btn-primary">更多数据请点击这里查询</button>
<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">关闭</button>
<button class="btn btn-primary" onclick="setValues('list.ids','Consult.id','list.code','Consult.code','list.name','Consult.name')">保存选择</button>
</div>
</div>
</div>
<!-- end modal -->

</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" /> <jsp:include
	page="/include/js.jsp" flush="true" />
	
<script type="text/javascript">
	
	function setValues(id,tid,code,tcode,name,tname){
		//alert("setValues");
		var ids = document.getElementsByName(id);
		var index;
		for(var i=0;i<ids.length;i++){
			var el = ids[i];
			if(el.checked){
				index = i;
			}
		}

		var idV = document.getElementsByName(id)[index].value;
		var codeV = document.getElementsByName(code)[index].value;
		var nameV = document.getElementsByName(name)[index].value;
		//alert(codeV.value+"|"+nameV.value);
		document.getElementById(tid).value=idV;
		document.getElementById(tcode).value=codeV;
		document.getElementById(tname).value=nameV;
	}

	function setValues2(obj,code,tcode,name,tname){
		alert("setValues");
		var ids = document.getElementsByName(obj.id);
		alert("setValues 222");
		var index;
		for(var i=0;i<ids.length;i++){
			var el = ids[i];
			if(el.checked){
				index = i;
			}
		}
		var idV = document.getElementsByName(id)[index].value;
		var codeV = document.getElementsByName(code)[index].value;
		var nameV = document.getElementsByName(name)[index].value;
		//alert(codeV.value+"|"+nameV.value);
		document.getElementById(tid).value=idV;
		document.getElementById(tcode).value=codeV;
		document.getElementById(tname).value=nameV;
	}
	
</script>
	
</body>
</html>
