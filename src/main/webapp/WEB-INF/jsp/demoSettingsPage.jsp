<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>DEMO PROMO</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/GadriaWebAppClient/css/bootstrap/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/GadriaWebAppClient/css/bootstrap/justified-nav.css" rel="stylesheet">

  </head>
  <body>
 <div class="container">

	  <div class="masthead">
   		<h3 class="text-muted"><img src="/GadriaWebAppClient/img/logo/no_payoff_mini.png" alt="SayService.it"/>&nbsp;DEMO PROMO</h3>
        <ul class="nav nav-justified">
          <li>Home</li>
        </ul>
      </div>

      <div class="jumbotron">
      	<h3 class="text-muted">DEMO SETTINGS</h3>
	     <form:form id="demoSettings" action="demoSettings" modelAttribute="demoSettingsModel">
	  		<fieldset>

				<p>
					<label>Language</label>
					<form:select path="language">
						<form:option value="IT" label="IT"/>
						<form:option value="EN" label="EN"/>
					</form:select>
				</p>
				<p>
					<label>Demo Type</label>
					<form:select path="demo_type">
						<form:option value="apss" label="APSS"/>
						<!-- form:option value="icsoc" label="ICSOC"/>  -->
					</form:select>
				</p>

				<p>
					<label>User Mode</label>
					<form:select path="user_type">
						<form:option value="viewer" label="VIEWER"/>
						<form:option value="demo" label="DEMO"/>
						<form:option value="developer" label="DEVELOPER"/>
					</form:select>
				</p>

				<input type="submit" value="Submit" name="Submit"/>

	  		</fieldset>
      	 </form:form>
      </div>

 </div><!-- container -->

  </body>
</html>