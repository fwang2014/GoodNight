<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mytag" uri="http://java.sun.com/jsp/mytag"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- Modal -->
<form action="<%=path %>/${tab }/search?" method="post" name="seachForm" id="searchForm" 
onsubmit="return checkSearch(this,'search.code,search.name,search.type,search.status,search.startDate,search.endDate')">
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"	aria-hidden="true">×</button>
<h5 id="myModalLabel">${msg['display.label.search']}</h5>
</div>
<div class="modal-body">
<p>
	<table width="100%">
		<tr>
			<td width="30%">${msg['display.label.code']}</td><td  width="70%"><input type="text" name="search.code" id="search.code"></td>
		</tr>
		<tr>
			<td>${msg['display.label.name']}</td><td><input type="text" name="search.name" id="search.name">
				
			</td>
		</tr>
		
		<!-- type 参数控制  -->
		<c:choose>
			<c:when test="${search.dictCode!='input'}">
				<tr>
					<td>${msg['display.label.type']}</td>
					<td>
						<mytag:select dictCode="${search.dictCode}" id="search.type"></mytag:select>
					</td>
				</tr>
			</c:when>
			<c:when test="${search.dictCode=='input'}">
				<tr>
					<td>${msg['display.label.type']}</td>
					<td>
						<input type="text" name="search.type" id="search.type"/>
					</td>
				</tr>
			</c:when>
			
		</c:choose>
		
		<tr>
			<td>${msg['display.label.status']}</td>
			<td>
				<mytag:select dictCode="DATA_STATUS" id="search.status"></mytag:select>
			</td>
		</tr>
		<tr>
			<td>${msg['display.label.time']}</td>
			<td>
				
				
				<div class="control-group">
				${msg['display.label.from']}
					<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
						
						<input size="16" type="text"  NAME="search.startDate" ID="search.startDate" class="span2"
						value="${search.startDate}" readonly="readonly">
						<span class="add-on"><i class="icon-remove"></i></span>
						<span class="add-on"><i class="icon-th"></i></span>
						</div>
						<input type="hidden" id="dtp_input1" value="" />
				</div>
				

				<div class="control-group">
				${msg['display.label.to']}
					<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2">
						
						<input size="16" type="text"  NAME="search.endDate" ID="search.endDate" class="span2"
						value="${search.endDate}" readonly="readonly">
						<span class="add-on"><i class="icon-remove"></i></span>
						<span class="add-on"><i class="icon-th"></i></span>
						</div>
						<input type="hidden" id="dtp_input2" value="" />
				</div>
			</td>
		</tr>
	</table>
</p>
</div>
<div class="modal-footer">
<button class="btn btn-primary" type="submit">${msg['operate.search']}</button>
<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">${msg['operate.close']}</button>
</div>
</div>
</div>
</form>
<!-- end modal -->

<script language="javascript">
<!--
	function checkSearch(form,ids){
		var result = false;	
		var aids = ids.split(",");
		for ( var i = 0; i < aids.length; i++) {
			var id = aids[i];
			var li = document.getElementById(id);
			if(li){
				if(li.value !="" && li.value.length>0){
					result = true;
					break;
				}else{
				}
			}else{
				alert("param value error!");
			}			
		}

		//var action = form.action;
		if(result){		
			form.submit();
		}else{
			alert("请输入条件后再查询");
			return false;
		}
	}
-->
</script>
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
