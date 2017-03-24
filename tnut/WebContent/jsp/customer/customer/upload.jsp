<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mytag" uri="http://java.sun.com/jsp/mytag"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript">
<!--
	function addUploadRow(tabId){
		var tab = document.getElementById(tabId);
		var rows = tab.rows.length;

		if(rows <= 10){
			var newTr = tab.insertRow();
			var trHTML = "<td width=\"30%\">上载文件</td>";	
			newTr.insertCell().innerHTML = trHTML;
			trHTML = "<td colspan='3'><input type=\"file\" name=\"file\" id=\"file\" /></td>";
			newTr.insertCell().innerHTML = trHTML;
		}		
		
	}

	function delUploadRow(tabId){
		var tab = document.getElementById(tabId);
		var rows = tab.rows.length;
		if(rows>1){//最后一行不能删除
			var tb = tab.children[0];
			var delRow = tb.lastChild;
			tb.removeChild(delRow);
		}
	}
-->
</script>

<c:if test="${fileList!=null}">
<table class="table table-bordered" id="tab_uplaoded">
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
</table>
</c:if>

<table class="table table-bordered" id="tab_uplaod">
	<tr>
		<td colspan="4">
			<span class="label label-warning">注意：文件格式包括：gif | jpg | png | bmp | doc | xls | ppt | zip | rar | cvs | txt | docx;文件大小必须小于5M.</span>
		</td>
	</tr>
	<tr>
		<td width="25%">${msg['display.label.affix.info']}</td>
		<td colspan="3"><input type="file" name="theFile" id="theFile" />
			<input type="button" class="btn btn-info" name="btn_add" value="${msg['operate.add'] }" 
			onclick="addUploadRow('tab_uplaod')" title="最多增加10行">
			<input type="button" class="btn btn-info" name="btn_del" value="${msg['operate.del'] }" 
			onclick="delUploadRow('tab_uplaod')" title="删除至少保留1行">
		</td>
	</tr>
	<tr>
		<td>上载文件</td>
		<td colspan="3"><input type="file" name="theFile" id="theFile" /></td>
	</tr>
	<tr>
		<td>上载文件</td>
		<td colspan="3"><input type="file" name="theFile" id="theFile" /></td>
	</tr>
</table>




