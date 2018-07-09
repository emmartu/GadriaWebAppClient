<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    
    <title>Gadria Monitoring</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <script src="/GadriaWebAppClient/js/jquery.min.js"></script>
    <script src="/GadriaWebAppClient/js/bootstrap/bootstrap.min.js"></script>
    <link href="/GadriaWebAppClient/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/GadriaWebAppClient/css/bootstrap/justified-nav.css" rel="stylesheet">

  </head>

  <body>
 
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#"><img src="/GadriaWebAppClient/img/logo/Logo-PCBZ.png" height="15" width="15" alt="http://appc.provincia.bz.it/"/></a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">Link</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	          	<c:forEach items="${webcamModel.webcamIdList}" var="webcamId" varStatus="index">
		            <li><a href="/latest/${webcamId}/viewImage.html">${webcamId}</a></li>
				</c:forEach>
	          </ul>
	        </li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
            <li><a href="/areaRiservata">Area Riservata</a></li>
          </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>

	<div class="container">
      <div class="jumbotron">
		<img src="/GadriaWebAppClient/img/LAVORI-IN-CORSO-omini.jpg" height="50%" width="50%" alt="coming soon"/>
	  </div>
    </div>

  </body>
</html>