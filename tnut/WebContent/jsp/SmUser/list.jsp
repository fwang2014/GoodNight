<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
	<jsp:include page="/include/head.jsp"	flush="true" />
  </head>

  <body  data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp"	flush="true" />

    <div class="container-fluid">
      <div class="row-fluid">
        <jsp:include page="/include/menu_sys.jsp"	flush="true" />
        
        <div class="span9">
        
        <div>
        <ul class="breadcrumb">
			<li><a href="<%=path %>/welcome?" class="label label-info">Home</a> <span class="divider">/</span></li>
			<li><a href="<%=path %>/sys?"  class="label label-info">系统管理</a> <span class="divider">/</span></li>
			<li class="active">数据列表</li>
		</ul>  
		</div>  
	        
		<div class="bs-docs-example" style="margin-top:2px;">
            <div class="navbar">
              <div class="navbar-inner">
                <ul class="nav">
                  <li class="active"><a href="<%=path %>/sys?">用户管理</a></li>
                  <li ><a href="<%=path%>/role?">角色管理</a></li>
                  <li><a href="<%=path%>/function?">功能管理</a></li>
                  <li><a href="<%=path%>/right?">权限管理</a></li>
                  <li><a href="<%=path%>/log?">日志管理</a></li>
                   <li><a href="<%=path%>/datadic?">数据字典</a></li>
                </ul>
              </div>
            </div>
        </div>	
          
        <div class="bs-docs-example">
		<div class="btn-group">
		  <!--<span class="label label-info">数据结果</span> 
		  <span class="label label-important">${LIST_INFO }</span>

          --><div class="btn-group" style="display:block;">
		             <button class="btn dropdown-toggle" data-toggle="dropdown">相关操作 <span class="caret"></span></button>
		                <ul class="dropdown-menu">
		                  <li><a href="<%=path%>/SmUser/add?"><i class="icon-pencil"></i>新增</a></li>
		                  <li><a href="#" onclick="delIds('listForm')"><i class="icon-remove"></i>删除</a></li>
		                  <li><a href="<%=path%>/SmUser/passManage?"><i class="icon-remove"></i>密码管理</a></li>
		                  <li class="divider"></li>
		                  <li><a href="<%=path%>/SmUser/checkUser?"><i class="icon-ok"></i>审核</a></li>
		                </ul>
		   </div><!-- /btn-group -->
		</div>
		
		<form action="<%=path %>/SmUser/list?" method="post" id="listForm" name="listForm">
		<table class="table table-bordered">
			<thead>
				<tr>
				<th><input type="checkbox" name="all"  onclick="selectAll('ids')"/></th>
				<th>${msg['label.SmUser.CODE']}</th>
				<th>${msg['label.SmUser.USERNAME']}</th>
				<th>${msg['label.SmUser.NICKNAME']}</th>
				<th>${msg['label.SmUser.TYPE']}</th>
				<th>${msg['label.SmUser.STATUS']}</th>
				<th>${msg['label.SmUser.CREATEUSER']}</th>
				<th>${msg['label.SmUser.LASTUPDATETIME']}</th>
				<th>${msg['label.SmUser.LASTUPDATEUSER']}</th>
				</tr>
			</thead>
		<tbody>
		
		<c:forEach items="${list}" var="tag" varStatus="id">
			<tr class="tr_data">
					<td nowrap>
						<c:if test="${tag.status =='0'}">
							<input type="checkbox" name="ids" value="${tag.id}"/>
						</c:if>
					</td>
					<td nowrap>${tag.username}</td>
					<td nowrap><a href="<%=path %>/SmUser/view?id=${tag.id}">${tag.username}</a></td>
					<td nowrap>${tag.nickname}</td>
					<td nowrap>${tag.type}</td>
					<td nowrap>${tag.status}</td>
					<td nowrap>${tag.createuser}</td>
					<td nowrap>${tag.lastupdatetime}</td>
					<td nowrap>${tag.lastupdateuser}</td>
				
			</tr>
		</c:forEach>
		
		</tbody>
		</table>
		</form>
            
          </div>
        
          <div class="hero-unit" style="display:none;">
            <h1>家庭财务, 你好!</h1>
	        <p>金钱的问题困扰着许多家庭，大多数时候是金钱加重了家庭矛盾。许多家庭由于缺乏资金，或者确切地说，是由于失败地管理家庭资金而陷入困境。我们有一条摆脱家庭金融灾难的出路——长远规划和坚持到底，创造我们的第一桶金。</p>
	        <p><a href="#" class="btn btn-primary btn-large">了解更多 &raquo;</a></p>
          </div>
          
        </div><!--/span-->
      </div><!--/row-->

      <hr>

	 <jsp:include page="/include/foot.jsp"	flush="true" />

    </div><!--/.fluid-container-->

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
    
    
    
    <script language="javascript">
		<!--
			function delIds(id){
				var form = document.getElementById(id);
				var ids = document.getElementsByName("ids");
				//var len = ids.length;				
				
				var count = 0;
				//alert(ids+"||"+typeof(ids)+"||"+ids.length);
				var bool = false;
				if(ids){
					for(var i=0;i<ids.length;i++){
						var checkbox = ids[i];
						if(checkbox.checked){
							//alert(checkbox.value);
							bool =true;
							//break;
							count++;
						}
					}
				}

				if(!confirm("确认要删除这"+count+"条记录吗？")){
					//alert("确认要删除这"+count+"条记录吗？");
					return;
				}

				if(count > 0){
					form.action = "<%=path%>/SmUser/dels?";
					form.submit();
				}else{
					alert("请选择记录！");
				}
			}
		-->
    </script>

  </body>
</html>
