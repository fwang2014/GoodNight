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
<div class="row-fluid"><jsp:include
	page="/include/menu_sys.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/User2/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.User.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li ><a href="<%=path%>/User2/list?">${msg['label.User.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li class="active"><a href="<%=path%>/User2/add?">${msg['label.User.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path%>/User2/save?" method="post" id="addForm"
	name="addForm" onsubmit="return valForm(this);"><INPUT
	TYPE="hidden" NAME="User.id" value="${User.id }" />
<table class="table table-bordered">
	<tr>
		<td>${msg['label.User.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.code" ID="User.code" valNullable="N"
			value="${User.code }" maxLength="20" /></td>
		<td>${msg['label.User.NAME']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.name" ID="User.name" valNullable="N"
			value="${User.name }" maxLength="50" /></td>
	</tr>
	<tr>
		<td>${msg['label.User.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.type" ID="User.type"
			value="${User.type }" maxLength="20" /></td>
		<td>${msg['label.User.STATUS']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.status" ID="User.status"
			value="${User.status }" onblur="valNumber(this)" /></td>
	</tr>
	<tr>
		<td>${msg['label.User.ACCOUNT_NAME']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.account_name"
			ID="User.account_name" value="${User.account_name }" maxLength="50" valNullable="N"/></td>
		<td>${msg['label.User.PASSWORD']}</td>
		<td><INPUT TYPE="password" NAME="User.password" ID="User.password"
			value="${User.password }" maxLength="50" />
			<span class="label label-warning">默认为111</span>
		</td>
	</tr>
	<tr>
		<td>${msg['label.User.DEFAULT_ROLE']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.default_role"
			ID="User.default_role" value="${User.default_role }"
			onblur="valNumber(this)" /></td>
		<td>${msg['label.User.NICK_NAME']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.nick_name" ID="User.nick_name"
			value="${User.nick_name }" maxLength="50" /></td>
	</tr>
	<tr>
		<td>${msg['label.User.LAST_LOGIN_TIME']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.last_login_time"
			ID="User.last_login_time" value="${User.last_login_time }" /></td>
		<td>${msg['label.User.LOGIN_TIME']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.login_time"
			ID="User.login_time" value="${User.login_time }" /></td>
	</tr>
	<tr>
		<td>${msg['label.User.LOGIN_TIMES']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.login_times"
			ID="User.login_times" value="${User.login_times }"
			onblur="valNumber(this)" /></td>
		<td>${msg['label.User.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="User.remark" ID="User.remark"
			value="${User.remark }" maxLength="500" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="保存"> <input
			type="reset" name="btn_reset" class="btn btn-info" value="重置">
		<input type="button" name="btn_back" class="btn btn-info" value="取消"
			onclick="window.location='<%=path%>/User2/list?'"></td>
	</tr>
</table>
</form>



</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" />
</div>
<!--/.fluid-container-->

<jsp:include page="/include/js.jsp" flush="true" />

<script language="javascript">

$(document).ready(function(){
	  // 在这里写你的代码...
	$("input[type='text']").change(function(){
		//alert(this.id)
		var id = this.id;
		if("User.account_name" == id){
			//alert(id);
			var url = "<%=path%>/User/checkAccountName?";
			var value = this.value;
			var obj = this;
			jQuery.post(url,{accountName:value},function(data){				
				if(data){
					var json = eval('(' + data + ')');
					var account_name = json.account_name;
					var name = json.name;
					alert(name+"["+account_name+"]已经存在，请使用其他账户名？");
					obj.value = account_name+"1";
				}					
			});

		}

	});
}); 

</script>

</body>
</html>
