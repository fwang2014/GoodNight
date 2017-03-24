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
			<li class="active">新增</li>
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
                </ul>
              </div>
            </div>
        </div>	
          
        <div class="bs-docs-example">
		
		<form action="<%=path %>/SmUser/save?" method="post">
		<INPUT TYPE="hidden" NAME="SmUser.id" value="${SmUser.id }"/>
		<table class="table table-bordered">
					<tr>
						<td>${msg['label.SmUser.CODE']}<font color="red">*</font></td>
						<td><INPUT TYPE="TEXT" NAME="SmUser.code" value="${SmUser.code }"/></td>
						<td>${msg['label.SmUser.USERNAME']}<font color="red">*</font></td>
						<td>
								<INPUT TYPE="TEXT" NAME="SmUser.username" value="${SmUser.username }"/>
						</td>
					</tr>
					<tr>
						<td>${msg['label.SmUser.NICKNAME']}<font color="red">*</font></td>
						<td><INPUT TYPE="TEXT" NAME="SmUser.nickname" value="${SmUser.nickname }"/></td>
						<td>${msg['label.SmUser.PASSWORD']}<font color="red">*</font></td>
						<td>
								<INPUT TYPE="password" NAME="SmUser.password" 
								value="${SmUser.password==null||SmUser.password==''?'123456':SmUser.password }"/>
								默认：123456
						</td>
					</tr>
					<tr>
						<td>${msg['label.SmUser.TYPE']}<font color="red">*</font></td>
						<td><INPUT TYPE="TEXT" NAME="SmUser.type" value="${SmUser.type }"/></td>
						<td>${msg['label.SmUser.STATUS']}<font color="red">*</font></td>
						<td>
								<INPUT TYPE="TEXT" NAME="SmUser.status" value="${SmUser.status }" readonly/>
						</td>
					</tr>
					<tr>
						<td>${msg['label.SmUser.CREATEUSER']}</td>
						<td><INPUT TYPE="TEXT" NAME="SmUser.createuser" value="${SmUser.createuser }" readonly/></td>
						<td>${msg['label.SmUser.LASTUPDATETIME']}</td>
						<td>
								<INPUT TYPE="TEXT" NAME="SmUser.lastupdatetime" value="${SmUser.lastupdatetime }" readonly/>
						</td>
					</tr>
					<tr>
						<td>${msg['label.SmUser.LASTUPDATEUSER']}</td>
						<td colspan="3"><INPUT TYPE="TEXT" NAME="SmUser.lastupdateuser" value="${SmUser.lastupdateuser }" readonly/></td>
					<tr>
						<td colspan="4" align="center">
							<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
							<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
						</td>
					</tr>
		</table>
		</form>
            
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

  </body>
</html>
