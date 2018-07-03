<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>DEMO PROMO</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <!-- Bootstrap -->
	    <link href="/monitoring-console/css/bootstrap/bootstrap.css" rel="stylesheet">
	    <!-- Custom styles for this template -->
	    <link href="/monitoring-console/css/bootstrap/justified-nav.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>

	 <div class="container">

	  <div class="masthead">
   		<h3 class="text-muted"><img src="/monitoring-console/img/logo/no_payoff_mini.png" alt="SayService.it"/>&nbsp;DEMO PROMO</h3>
        <ul class="nav nav-justified">
          <li><a href="demoHome">Home</a></li>
          <li><a href="${demoSettings.demoSettingsDir}">RESET DEMO ENVIRONMENT</a></li>
          <li><a href="atlanteconsole">ATLANTE DATA</a></li>
          <li class="active"><a href="showsconsole">TEST</a></li>
          <li><a href="showChartsPanel">IT VIEWS</a></li>
          <li><a href="bpViewsPage">BP VIEWS</a></li>
        </ul>
      </div>

			<p></p>
			
			<div class="thumbnail">
				<h4><strong>${demoSettings.demoLanguage.uploadSpecificTraceLabel}</strong></h4>
				<form:form action="showsconsole" modelAttribute="inputTypeModel" method="post" enctype="multipart/form-data">
					<input type="file" name="file" /><input type="submit" name="upload" value="${demoSettings.demoLanguage.uploadLabel}"/>
				</form:form>
			</div>
			
      <div class="jumbotron">

<%-- 		<c:choose> --%>
<%-- 	      <c:when test="${engineStarted==true}"> --%>
			
			<form:form action="showsconsole" modelAttribute="inputTypeModel" method="get">
				<table bgcolor="#EEEEEE">
					<tr>
						<td><label>${demoSettings.demoLanguage.chooseTestSequenceLabel}</label></td>
						<td colspan="2">
							<form:select path="testName">
								<form:option value="test1" label="${demoSettings.demoLanguage.standardXHealthServices}"/>
								<form:option value="test2" label="${demoSettings.demoLanguage.standardXSocialServices}"/>
								<form:option value="test3" label="${demoSettings.demoLanguage.standardXPresidium}"/>
								<form:option value="test4" label="${demoSettings.demoLanguage.standardXUVM}"/>
								<form:option value="test5" label="${demoSettings.demoLanguage.missingReceipt}"/>
								<form:option value="test6" label="${demoSettings.demoLanguage.doubleServiceActivation}"/>
								<form:option value="test7" label="${demoSettings.demoLanguage.socialServicesAndThenUVMActivation}"/>
								<form:option value="test8" label="${demoSettings.demoLanguage.uVMAndThenSocialServicesActivation}"/>
								<form:option value="test9" label="${demoSettings.demoLanguage.immediateClosing}"/>
							</form:select>
						</td>
						<td><form:button type="submit" name="SelectTest" onclick="this.form.input.value='select'">${demoSettings.demoLanguage.selectLabel}</form:button></td>
					</tr>
					<tr>
						<td><label>${inputTypeModel.label} (${inputTypeModel.statePosix} of ${inputTypeModel.maxSteps})</label></td>
						<td><form:button type="submit" name="NextStep" onclick="this.form.input.value='next'">${demoSettings.demoLanguage.nextStep} >> </form:button></td>
						<td><form:button type="submit" name="PerformAllSteps" onclick="this.form.input.value='all'">${demoSettings.demoLanguage.performAllSteps} >> </form:button></td>
						<td>${demoSettings.demoLanguage.lastStep}: ${inputTypeModel.stato}</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td><label>Compliant Test</label></td> -->
<%-- 						<td><form:button type="submit" name="NextStepTest1" onclick="this.form.input.value='test1'">Next Step >> </form:button></td> --%>
<%-- 						<td><form:button type="submit" name="PerformAllStepsTest1" onclick="this.form.input.value='alltest1'">Perform All Steps >> </form:button></td> --%>
<%-- 						<td>Last Step: ${inputTypeModel.test1.stato}</td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td><label>Comune and Apss technically out of order Test</label></td> -->
<%-- 						<td><form:button type="submit" name="NextStepTest3 " onclick="this.form.input.value='test3'">Next Step >> </form:button></td> --%>
<%-- 						<td><form:button type="submit" name="PerformAllStepsTest3" onclick="this.form.input.value='alltest3'">Perform All Steps >> </form:button></td> --%>
<%-- 						<td>Last Step: ${inputTypeModel.test3.stato}</td> --%>
<!-- 					</tr> -->
					<!-- tr>
						<td><label>Reset All</label></td>
						<td><form:button type="submit" name="ResetAll" onclick="this.form.input.value='reset'">Reset</form:button></td>
					</tr -->
					<form:hidden path="input" value=""/>
				</table>
		     <c:if test="${inputTypeModel.errorMessage!=null}">
			     <div class="alert alert-info">
			       <strong>${inputTypeModel.errorMessage}</strong>
			     </div>
		     </c:if>
			</form:form>
<%-- 	      </c:when> --%>
	
<%-- 	      <c:otherwise> --%>
<!-- 		     <div class="alert alert-success"> -->
<!-- 		       <strong>Engine Not started!</strong> -->
<!-- 		     </div> -->
<%-- 	      </c:otherwise> --%>
<%-- 		</c:choose> --%>


      </div>
    </div>
  </body>
</html>
