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
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">家庭财务管理系统[FFMS]</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">首页</a></li>
              <li><a href="#about">关于</a></li>
              <li><a href="#contact">联系我们</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">快捷通道 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="fm/daily/index?">每日收支</a></li>
                  <li><a href="#">统计查询</a></li>
                  <li><a href="#">账户管理</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">系统管理</li>
                  <li><a href="#">辅助工具</a></li>
                  <li><a href="#">其他</a></li>
                </ul>
              </li>
            </ul>
            <form class="navbar-form pull-right" action="default.html">
              <input class="span2" type="text" placeholder="用户名">
              <input class="span2" type="password" placeholder="密码">
              <button type="submit" class="btn">登陆</button>
            </form>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h1>家庭财务, 你好!</h1>
        <p>金钱的问题困扰着许多家庭，大多数时候是金钱加重了家庭矛盾。许多家庭由于缺乏资金，或者确切地说，是由于失败地管理家庭资金而陷入困境。我们有一条摆脱家庭金融灾难的出路——长远规划和坚持到底，创造我们的第一桶金。</p>
        <p><a href="#" class="btn btn-primary btn-large">了解更多 &raquo;</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="span4">
          <h2>我的收支</h2>
          <p>企业家只有两只眼睛不行，必须要有笫三只眼睛。要用一只眼睛盯住内部管理，最大限度地调动员工积极性；另一只眼睛盯住市场变化，策划创新行为；第三只眼睛用来盯住国家宏观调控政策，以便抓住机遇，超前发展。 </p>
          <p><a class="btn" href="#">查看详细 &raquo;</a></p>
        </div>
        <div class="span4">
          <h2>查询统计</h2>
          <p>“日事日毕，日清日高”的OEC管理模式，其含义是全方位地对每个人、每一天所做的每件事进行控制和清理，做到“日清日毕，日清日高”，每天的工作每天完成，而且每天的工作质量都有一点儿（1%）的提高。（日事日毕，解决基础管理问题；日清日高，解决速度问题）。</p>
          <p><a class="btn" href="#">查看详细 &raquo;</a></p>
       </div>
        <div class="span4">
          <h2>我的账户</h2>
          <p>你必须决定一年的收入里多少用于当前消费，多少用于储蓄。与此计划有关的任务是编制资产负债表、年度收支表和预算表。</p>
          <p><a class="btn" href="#">查看详细 &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Company 20130718</p>
      </footer>

    </div> <!-- /container -->

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
