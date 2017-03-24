<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String tab = (String)request.getAttribute("tab");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/include/head.jsp" flush="true" />
</head>

<body data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp" flush="true" />

<div class="container-fluid">
<div class="row-fluid"><jsp:include page="/include/menu_game.jsp"
	flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Game/poker/index?" class="label label-info">${msg['label.GAME'] }</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.GAME.POKER'] }</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Game/Poker/index?">${msg['label.GAME.POKER'] }</a></li>
	<li><a href="<%=path%>/Game/Poker/landor?">${msg['label.GAME.POKER.LANDLORDS'] }</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
	<table class="table table-bordered">
		<thead style="display:none">
			<th>Game.Poker</th>
		</thead>
		<tbody>
			<tr>
				<td>
					<jsp:include page="poker.jsp" flush="true" />
				</td>
			</tr>
		</tbody>
	</table>
	

</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" />
</div>

<jsp:include page="/include/js.jsp" flush="true" />

</body>
</html>
