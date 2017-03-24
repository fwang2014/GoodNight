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
    <link href="<%=path %>/assets/css/bootstrap.css" rel="stylesheet">
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

  <body  data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp"	flush="true" />

    <div class="container-fluid">
      <div class="row-fluid">
        <jsp:include page="/include/menu_train.jsp"	flush="true" /> 
        <div class="span9">
        
          <div class="row-fluid">
          	
          		<form action="<%=path %>/Words/save?" method="post" id="form_myword" name="form_myword" style="border:1px dashed green">
          		<span class="label label-info">今天怎么样？有什么想说的可以在这里一吐为快。。。</span><br>
          			<textarea rows="3" cols="50" style="width:85%" name="Words.remark" id="myword"></textarea> 
          			<input type="hidden" name="Words.code" value="${code }">
          			<input type="hidden" name="Words.name" value="今天怎么样?">
          			<input type="hidden" name="Words.type" value="0">
          			<input type="hidden" name="TOKEN" value="${TOKEN }">
          		<br>
          		<input type="submit" name="btn_myword" value="保存" class="btn label-info">
          		</form>
          	
          </div>
        
          <div class="hero-unit">
            <h3>秋风IT工作室</h3>
       		<p>学完全部课程，你将发生蜕变。从“这个可以做”，“这个怎么样”，“你要做什么”不断提升自己价值，让人生更加丰富多彩！<br>
				教学特色：以项目实战推动教学，设计课程将由浅入深，逐步将学员带入一个高深莫测的软件世界</p>
        	<p style="display:none"><a href="#" class="btn btn-primary btn-large">了解更多 &raquo;</a></p>
          </div>
          
          <div class="row-fluid">
            <div class="span4">
              <h4>网站初级</h4>
              <p>HTML,CSS,JAVASRIPT,网站应用</p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h4>WEB2.0--网站中级</h4>
              <p>服务器语言ASP,jQuery,web高级组件，安全，UCD</p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h4>项目设计</h4>
              <p>独立设计开发完成</p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
          <div class="row-fluid">
            <div class="span4">
              <h4>JAVA</h4>   
              <p>语法基础，对象，接口，常用对象介绍，WEB架构，STRUTS架构，数据库基础等</p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h4>J2EE</h4>
              <p>高级组件，WEB开发框架，敏捷开发，服务器，JAVA高级知识，大型系统案例，业务分析和设计知识，项目文档等</p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h4>Android</h4>    
              <p>开发环境，资源，布局，界面，常用API，使用通知和服务，开发过程，SQLite,测试等</p>
              <p><a class="btn" href="#">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
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
