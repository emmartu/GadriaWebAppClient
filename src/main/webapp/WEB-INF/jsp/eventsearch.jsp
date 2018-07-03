<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Monitoring Console</title>
	    
		<link rel="stylesheet" href="/monitoring-console/css/dynamic_tab.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script>!window.jQuery && document.write('<script src="js/jquery-1.7.2.min.js"><\/script>')</script>
 		<script src="/monitoring-console/js/DateTimePicker.js" type="text/javascript"></script>

		
		<!-- style type="text/css">
			a:link { color: #3366CC; text-decoration: none}
			a:visited { color: #3366CC; text-decoration: none}
			a:hover { color: #3366CC; text-decoration: underline}
			a:active { color: #3366CC; text-decoration: none}
		</style -->		
		
	</head>
	<body> 
	<div id="container">
		<form:form action="showsevents" modelAttribute="searchEventsModel" method="get">
	  		<fieldset>
				<table bgcolor="#EEEEEE">
					<tr>
						<td>Event Type</td>
						<td><form:select path="eventType">
								<form:option value="All"/>
								<form:option value="Event"/>
								<form:option  value="Sensor"/>
							</form:select>
						</td>
					</tr>								
					<tr><td>Event Name</td><td colspan="3"><form:input path="eventName" size="60"/></td></tr>
					<tr><td>Event Data Range</td></tr>
					<tr><td>From:</td>
					</tr>
					<tr>
						<td>Date</td>
						<td>
							<form:input type="text" id="fromDateTime" path="fromDateTime" readonly="readonly"/>
                       		<img src="/monitoring-console/img/cal.gif" style="cursor: pointer;" onclick="javascript:NewCssCal('fromDateTime','ddMMyyyy','dropdown',true,'24',true)" />
						</td>
					</tr>
					<tr><td>To:</td>
					</tr>
					<tr>
						<td>Date</td>
						<td>
							<form:input type="text" id="toDateTime" path="toDateTime" readonly="readonly"/>
                       		<img src="/monitoring-console/img/cal.gif" style="cursor: pointer;" onclick="javascript:NewCssCal('toDateTime','ddMMyyyy','dropdown',true,'24',true)" />
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				
				<hr>
				<p align="left"> 
					Correlators <span id="addCorrelator" style="cursor: pointer;">Add Correlator</span>
				</p>
				<hr>
				<p align="left"> 
					Payloads <span id="addPayload" style="cursor: pointer;">Add Payload</span>
				</p>
				<input type="submit" value="Search" name="search"/>
				<br/>
				<p align="left"><font color="#FF0000">${error}</font></p>
				<p align="left"><font color="#00AA00">${message}</font></p>
			</fieldset>
		</form:form>

		<script>
			//correlator
			var startingCorrNo = 0;
			var $corrNode = "";
			for(varCorrCount=0;varCorrCount<startingCorrNo;varCorrCount++){
				var displayCount = varCorrCount+1;
				$corrNode += '<p align="left"><label for="corrKey">Correlator Key: <input type="text" path="corrKey" name="corrKey" id="corrKey"/></label><label for="corrValue">Correlator Value: <input type="text" path="corrValue" name="corrValue" id="corrValue"/></label><span class="removeCorrelator" style="cursor: pointer;">Remove Correlator</span></p>';
			}
			$('form').append($corrNode);
			
			$('form').on('click', '.removeCorrelator', function(){
				$(this).parent().remove();
				//varCorrCount--;
			});

			$('#addCorrelator').on('click', function(){
				//new node
				varCorrCount++;
				$corrNode = '<p align="left"><label for="corrKey">Correlator Key: <input type="text" path="corrKey" name="corrKey" id="corrKey"/></label><label for="corrValue">Correlator Value: <input type="text" path="corrValue" name="corrValue" id="corrValue"/></label><span class="removeCorrelator" style="cursor: pointer;">Remove Correlator</span></p>';
				$(this).parent().after($corrNode);
			});

			//payload
			var startingPaylNo = 0;
			var $payloadNode = "";
			for(varPaylCount=0;varPaylCount<startingPaylNo;varPaylCount++){
				var displayCount = varPaylCount+1;
				$payloadNode += '<p align="left"><label for="paylKey">Payload Key: <input type="text" path="paylKey" name="paylKey" id="paylKey"/></label><label for="paylValue">Payload Value: <input type="text" path="paylValue" name="paylValue" id="paylValue"/></label><span class="removePayload" style="cursor: pointer;">Remove Variable</span></p>';
			}
			$('form').append($payloadNode);
			
			$('form').on('click', '.removePayload', function(){
				$(this).parent().remove();
				//varPaylCount--;
			});

			$('#addPayload').on('click', function(){
				//new node
				varPaylCount++;
				$payloadNode = '<p align="left"><label for="paylKey">Payload Key: <input type="text" path="paylKey" name="paylKey" id="paylKey"/></label><label for="paylValue">Payload Value: <input type="text" path="paylValue" name="paylValue" id="paylValue"/></label><span class="removePayload" style="cursor: pointer;">Remove Variable</span></p>';
				$(this).parent().after($payloadNode);
			});
		</script>

		</div>
		<font face="verdana" size="4">
			<p><a href="./console.html">Home</a></p>
		</font>
	</body>
</html>
