<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.nutz.utils.DateConvertUtil"%>
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
	<li><a href="<%=path%>/Consult/list?">${msg['label.Consult.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Consult/add?">${msg['label.Consult.TABLE_CN']}${msg['display.label.add']}</a></li>
	<li><a href="<%=path%>/Consult/upload?">${msg['display.label.upload']}</a></li>
	<li><a href="<%=path%>/Consult/upload?">${msg['display.label.uploadManage']}</a></li>
	<li class="active"><a href="<%=path%>/Consult/search?">查询</a></li>
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
	<li><a href="<%=path%>/${tab }/add?"><i class="icon-pencil"></i>${msg['operate.add']}</a></li>
	<li><a href="#" onclick="delIds('listForm','ids')"><i
		class="icon-remove"></i>${msg['operate.del']}</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick="doCheck('listForm', 'ids')"><i
		class="icon-ok"></i>${msg['operate.check']}</a></li>
</ul>
</div>
<!-- /btn-group --></div>

<form action="<%=path %>/Consult/search?" method="post"  id="listForm" name="listForm">
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Consult.CODE']}
		<input type="text" name="Consult.code" id="ConsultCode" data-provide='typeahead'
		 data-source='["abc"]' class="span3" style="margin: 0 auto;">后台数据提示输入框例子
		<input type="submit" name="btnsearch" value="Search"></td>
	</tr>
	<tr>
		<td>${msg['label.Consult.NAME']}
		<input type="text" name="key" id="key">默认显示文字框例子
		</td>
	</tr>
	<tr>
		<td>
			typeahead组件例子
			<input type="text" class="span3" style="margin: 0 auto;" data-provide="typeahead" data-items="4" 
			data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
		</td>
	</tr>
</table>
<table class="table table-bordered">
	<thead>
		<tr >
		<th><input type="checkbox" name="all" onclick="selectAll('ids')"/></th>
		<th>${msg['label.Consult.CODE']}</th>
		<th>${msg['label.Consult.NAME']}</th>
		<th>${msg['label.Consult.TYPE']}</th>
		<th>${msg['label.Consult.STATUS']}</th>

		<th>${msg['label.Consult.RECORD_NO']}</th>

		<th>${msg['label.Consult.STUDY_NAME']}</th>
		<th>${msg['label.Consult.SEX']}</th>

		<th>${msg['label.Consult.AGE']}</th>

		<th>${msg['label.Consult.CITY_DETAIL']}</th>
		<th>${msg['label.Consult.STUDY_LEVEL']}</th>
		<th>${msg['label.Consult.RECORD_DATE']}</th>

		<th>${msg['label.Consult.COURSE_NAME']}</th>
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
			<td nowrap title="${tag.remark}"><a href="<%=path %>/Consult/view?id=${tag.id}">${tag.name}</a></td>
			<td nowrap>${tag.type}</td>
			<td nowrap>${tag.status}</td>
			<td nowrap>${tag.record_no}</td>

			<td nowrap>${tag.study_name}</td>
			<td nowrap>${tag.sex}</td>

			<td nowrap>${tag.age}</td>

			<td nowrap>${tag.city_detail}</td>
			<td nowrap>${tag.study_level}</td>
			<td nowrap>${tag.record_date}</td>


			<td nowrap>${tag.course_name}</td>
		<td nowrap><a href="<%=path %>/Consult/view?id=${tag.id}"/>${msg['label.OPERATION.VIEW']}</a>
		<c:if test="${tag.status =='0'}">
				<span class="divider">|</span>
				<a href="<%=path%>/Consult/edit?id=${tag.id}" /><i class="icon-edit"></i></a>
		</c:if>
	</td>
	</tr>
</c:forEach>
	<tr class="tr_data">
			<td colspan="12" align="center">
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

<style type="text/css">

	.c98{
		color:green;
		 border: 1px solid #e5e5e5;
	}
	.c99{
		color:gray;
		border:1px solid red;
	}
</style>

<script type="text/javascript">
<!--

//$(document).ready(function(){
jQuery(function($) {
	  // 你可以在这里继续使用$作为别名...
	  var __yijuhua = "请输入咨询名称";
	  if($("#key").val() == "" || $("#key").val() == __yijuhua){
	      $("#key").val(__yijuhua);
	      //$("#key").addClass("c98");
	      $("#key").css("color","red");
	  }
	  $("#key").focus(function(){
	  	if($(this).val() == __yijuhua){
	  		$(this).val("");
	  		//$("#key").removeClass("c98");
	  		$("#key").css("color","blue");
	  	}
	  });
	  $("#key").blur(function(){
	  	if($(this).val() == ""){
	  		$(this).val(__yijuhua);
	  		//$("#key").addClass("c98");
	  		$("#key").css("color","green");
	  	}
	  });

	 // $.get("<%=path %>/typeahead?key=DATE_TYPE", function(data){
		 // alert("Data Loaded: " + data);
	 // }); 

	  $.ajax({
		  url: "<%=path %>/typeahead?key=DATE_STATUS",
		  cache: false,
		  success: function(html){
		   // $("#results").append(html);
		   alert("Data Loaded: " + html);
		   //$("#ConsultCode").val(html);
		   $("#ConsultCode").attr("data-source",html);
		  }
		}); 
}); 
-->
</script>



</body>
</html>
