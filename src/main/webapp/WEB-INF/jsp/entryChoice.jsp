<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
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
   		<h3 class="text-muted"><img src="/monitoring-console/img/logo/no_payoff_mini.png" alt="SayService.it"/>&nbsp;MONITORING CONSOLE</h3>
        <ul class="nav nav-justified">
          <li>Home</li>
        </ul>
      </div>

      <div class="jumbotron">
      	<h3 class="text-muted">USER CHOICE</h3>
	     <form:form id="userChoice" action="userChoice" modelAttribute="userChoiceModel">
	  		<fieldset>

				<p>
					<label>Language</label>
					<form:select path="userEntryType">
						<form:option value="USER" label="USER"/>
						<form:option value="ADMIN" label="ADMINISTRATOR"/>
					</form:select>
				</p>

				<input type="submit" value="Submit" name="Submit"/>

	  		</fieldset>
      	 </form:form>
      </div>

 </div><!-- container -->

  </body>
</html>