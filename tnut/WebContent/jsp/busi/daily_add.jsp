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
    <meta charset="utf-8">
    <title>家庭财务管理系统[Family Finance Manage System],J2EE实现 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="<%=path%>/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
    <link href="<%=path%>/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path%>/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path%>/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path%>/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="<%=path%>/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="<%=path%>/assets/ico/favicon.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">家庭财务管理系统[FFMS]</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              	当前用户： <a href="#" class="navbar-link">pip</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="<%=path %>/fm/daily/index?">首页</a></li>
              <li><a href="#about">关于</a></li>
              <li><a href="#contact">联系我们</a></li>
              <li><a href="<%=path %>/sas/logoff2?">安全退出</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">我的业务</li>
              <li ><a href="<%=path %>/fm/daily/index?"><i class="icon-home"></i>首页</a></li>
              <li class="active"><a href="<%=path %>/fm/daily/daily?"><i class="icon-eye-open"></i>每日收支</a></li>
              <li><a href="#"><i class="icon-plane"></i>统计查询</a></li>
              <li><a href="#"><i class="icon-comment"></i>账户管理</a></li>
              <li class="nav-header"><a href="#"  class="btn btn-small"><i class="icon-plus"></i>系统管理</a></li>
              <li><a href="#"><i class="icon-folder-close"></i>数据字典</a></li>
              <li><a href="#"><i class="icon-thumbs-up"></i>用户管理</a></li>
              <li><a href="#"><i class="icon-shopping-cart"></i>角色管理</a></li>
              <li><a href="#"><i class="icon-question-sign"></i>日志管理</a></li>
              <li><a href="#"><i class="icon-picture"></i>新闻管理</a></li>
              <li><a href="#"><i class="icon-tint"></i>接口管理</a></li>
              <li class="nav-header"><a href="#"  class="btn btn-small"><i class="icon-plus"></i>数据管理</a></li>
              <li><a href="#"><i class="icon-headphones"></i>表管理</a></li>
              <li><a href="#"><i class="icon-music"></i>表维护</a></li>
              <li><a href="#"><i class="icon-envelope"></i>性能优化</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        
        
        <div class="span9">
        
    
	<ul class="breadcrumb">
		<li><a href="<%=path %>/fm/daily/index?" class="label label-info">Home</a> <span class="divider">/</span></li>
		<li><a href="<%=path %>/fm/daily/daily?"  class="label label-info">每日收支</a> <span class="divider">/</span></li>
		<li class="active">数据新增</li>
	</ul>        
        
    <ul class="nav nav-tabs" style="display:none;">
			  <li class="active">
			    <a href="#" class="badge2">每日收支</a>
			  </li>
			  <li><a href="#" class="badge2">新支出</a></li>
			  <li><a href="#" class="badge2">新收入</a></li>
			  <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Dropdown <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li><a href="#">Separated link</a></li>
                </ul>
              </li>			  
	</ul>
	
		
		 
            <div class="input-append"  style="display:none;">
              <input class="span9" id="appendedDropdownButton" type="text" placeholder="请输入查询条件" width="100" value="">
              <div class="btn-group">
                <button class="btn dropdown-toggle" data-toggle="dropdown">操作 <span class="caret"></span></button>
                <ul class="dropdown-menu">
                  <li><a href="#"><i class="icon-search"></i>查询</a></li>
                  <li><a href="#"><i class="icon-pencil"></i>新增</a></li>
                  <li><a href="#"><i class="icon-remove"></i>删除</a></li>
                  <li class="divider"></li>
                  <li><a href="#"><i class="icon-ok"></i>审核</a></li>
                </ul>
              </div><!-- /btn-group -->
            </div><!-- /input-append -->
         
        <p/>
		


		<div class="alert">  
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>Warning!</strong> Best check yo self, you're not looking too good.
		</div>

		<div class="btn-group">
		  <span class="label label-info">数据详细</span> 
		</div>
        
		<div class="bs-docs-example">
            <table class="table table-bordered">
              <thead style="display:none;">
                <tr>
                  <th>#</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Username</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td width="20%">编码</td>
                  <td width="30%">@mdo</td>
                  <td width="20%">名称</td>
                  <td width="30%">@mdo</td>
                </tr>
				 <tr>
                  <td>类型</td>
                  <td>@mdo</td>
                  <td>状态</td>
                  <td>@mdo</td>
                </tr>
				<tr>                 
                  <td>图片</td>
                 <td colspan="3">
					<div class="bs-docs-example bs-docs-example-images">
						<img data-src="holder.js/140x140" class="img-rounded" src="..">
						<img data-src="holder.js/140x140" class="img-circle" src="..">
						<img data-src="holder.js/140x140" class="img-polaroid" src="..">
					  </div>
				 </td>
                </tr>
				<tr>
                  <td colspan="4">
					 <button class="btn btn-small btn-primary" type="button">保存</button>
					 <button class="btn btn-small btn-info" type="button">取消</button>
					 <button class="btn btn-small btn-success" type="button">成功</button>
					 <button class="btn btn-small btn-warning" type="button">警告</button>
				  </td>
                </tr>

              </tbody>
            </table>
            
						<div class="pagination" style="display:none;">
						  <ul>						    
						    <li title="首页"><a href="#"><i class="icon-step-backward"></i></a></li>
						    <li title="上一页"><a href="#"><i class="icon-backward"></i></a></li>
						    <li title="下一页"><a href="#"><i class="icon-forward"></i></a></li>
						    <li title="尾页"><a href="#"><i class="icon-step-forward"></i></a></li>
						  </ul>
						</div>            

            
          </div>
          
          	<div class="bs-docs-example tooltip-demo">
          <ul class="bs-docs-tooltip-examples">
            <li><a href="#" class="btn" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="Popover on top">Popover on top</a></li>
            <li><a href="#" class="btn" data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="Popover on right">Popover on right</a></li>
            <li><a href="#" class="btn" data-toggle="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="Popover on bottom">Popover on bottom</a></li>
            <li><a href="#" class="btn" data-toggle="popover" data-placement="left" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="Popover on left">Popover on left</a></li>
          </ul>
        </div>
   	


      <hr>

      <footer>
        <p>&copy; Company 2013</p>
      </footer>

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
