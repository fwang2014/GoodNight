
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
    <title>Sign in &middot; Twitter Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->

	<link href="<%=path %>/assets/css/bootstrap.css" rel="stylesheet">




  </head>

  <body>
<BR>
    <div class="container">

		<div class="bs-docs-example" style="background-color: #f5f5f5;">
            <div class="modal" style="position: relative; top: auto; left: auto; right: auto; margin: 0 auto 20px; z-index: 1; max-width: 100%;">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3>${msg['error.title.modal.header']}</</h3>
              </div>
              <div class="modal-body">
                <p>${error }&hellip;</p>
              </div>
              <div class="modal-footer">
              	<a href="#" onclick="window.history.back(-1);;" class="btn">${msg['btn.back']}</a> 
				<a href="<%=path%>" class="btn btn-primary">${msg['btn.index.page']}</a>
                <a href="#" class="btn btn-warning" onclick="window.close();">${msg['btn.close']}</a>
                 <a href="#" class="btn btn-success" >Success</a>
                  <a href="#" class="btn btn-danger" >Danger</a>
                  <a href="#" class="btn btn-info" >Info</a>
                  <a href="#" class="btn btn-inverse" >Inverse</a>
              </div>
            </div>
          </div>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
 



  </body>
</html>
