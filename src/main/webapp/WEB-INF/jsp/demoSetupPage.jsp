<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>DEMO PROMO</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/monitoring-console/css/bootstrap/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/monitoring-console/css/bootstrap/justified-nav.css" rel="stylesheet">

  </head>
  <body>
  <div class="container">

	  <div class="masthead">
   		<h3 class="text-muted"><img src="/monitoring-console/img/logo/no_payoff_mini.png" alt="SayService.it"/>&nbsp;DEMO PROMO</h3>
        <ul class="nav nav-justified">
          <li><a href="demoHome">Home</a></li>
          <li class="active"><a href="${demoSettings.demoSettingsDir}">RESET DEMO ENVIRONMENT</a></li>
          <li><a href="showsconsole">TEST</a></li>
          <li><a href="showChartsPanel">${demoSettings.demoLanguage.itViewsLabel}</a></li>
          <li><a href="bpViewsPage">${demoSettings.demoLanguage.bpViewsLabel}</a></li>
        </ul>
      </div>

      <div class="jumbotron">
        <p>
          <a class="btn btn-lg btn-primary" href="globalSetUp">${demoSettings.demoLanguage.globalSetUpLabel} &raquo;</a>
		  <c:if test="${globalSetUpDone==true}">
		      <div class="alert alert-success">
		        <strong>${demoSettings.demoLanguage.globalSetUpSuccess}</strong>
		      </div>
	      </c:if>
        </p>
        <p>
          <a class="btn btn-lg btn-primary" href="globalLoadTestData">${demoSettings.demoLanguage.globalLoadTestDataLabel} &raquo;</a>
		  <c:if test="${globalLoadTestDataDone==true}">
		      <div class="alert alert-success">
		        <strong>${demoSettings.demoLanguage.globalLoadTestDataSuccess}</strong>
		      </div>
	      </c:if>
        </p>
      </div>

	</div><!-- container -->
  </body>
</html>