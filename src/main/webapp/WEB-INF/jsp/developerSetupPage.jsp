<!DOCTYPE html>
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
    <script src="/monitoring-console/js/DateTimePicker.js" type="text/javascript"></script>

  </head>
  <body>
  <div class="container">

	  <div class="masthead">
        <p>
   		<h3 class="text-muted"><img src="/monitoring-console/img/logo/no_payoff_mini.png" alt="SayService.it"/>&nbsp;DEMO PROMO</h3>
      	</p>
        <ul class="nav nav-justified">
          <li><a href="demoHome">Home</a></li>
          <li class="active"><a href="${demoSettings.demoSettingsDir}">RESET DEMO ENVIRONMENT</a></li>
          <li><a href="atlanteconsole">ATLANTE DATA</a></li>
          <li><a href="showsconsole">TEST</a></li>
          <li><a href="showChartsPanel">IT VIEWS</a></li>
          <li><a href="bpViewsPage">BP VIEWS</a></li>
        </ul>
      </div>

      <div class="jumbotron">

      <div class="row">
        <div class="col-sm-7 col-md-8">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Triple Store SetUp</h3>
            </div>
            <div class="panel-body">
		          <p>
		          <a class="btn btn-lg btn-primary" href="resetTripleStore">Reset TripleStore &raquo;</a>
		          <a class="btn btn-lg btn-primary" href="getTripleStore">Get TripleStore &raquo;</a>
				  <c:if test="${resetTripleStoreDone==true}">
				      <div class="alert alert-success">
				        <strong>TripleStore successfully Setup!</strong>
				      </div>
			      </c:if>
			      </p>
		          <p>
		          <a class="btn btn-lg btn-primary" href="stopPipeline">Stop Pipeline &raquo;</a>
				  <c:if test="${stopPipelineDone==true}">
				      <div class="alert alert-success">
				        <strong>Pipeline successfully Sopped!</strong>
				      </div>
			      </c:if>
			      </p>
			      <p>
				     <form:form id="rdfDataInputFileForm" action="loadRdfTestFileData" method="post" modelAttribute="rdfUploadFileModel"  enctype="multipart/form-data">
					    <div class="form-group">
						    	<form:input path="fileData" name="fileData" type="file"/>
						  		<form:button class="btn btn-lg btn-primary" type="submit">Load Rdf File &raquo;</form:button>
			           </div>
					   <c:if test="${loadRdfTestFileDataDone==true}">
					     <div class="alert alert-success">
					       <strong>RDF File successfully loaded!</strong>
					     </div>
				       </c:if>
			      	 </form:form>
			     </p>
            </div>
          </div>
       </div>
       <div class="col-sm-7  col-md-8">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Mongo DB SetUp</h3>
            </div>
            <div class="panel-body">
		      <p>
	          <a class="btn btn-lg btn-primary" href="resetMongoDb">SetUp Mongo DB &raquo;</a>
			  <c:if test="${resetMongoDbDone==true}">
			      <div class="alert alert-success">
			        <strong>Mongo DB successfully Setup!</strong>
			      </div>
		      </c:if>
		      </p>
		      <p>
	          <a class="btn btn-lg btn-primary" href="loadMongoDbTestData">Load Mongo Test Data &raquo;</a>
			  <c:if test="${loadMongoDbTestDataDone==true}">
			      <div class="alert alert-success">
			        <strong>Test Data successfully Loaded!</strong>
			      </div>
		      </c:if>
		      </p>
            </div>
          </div>
       </div>
      </div>

      <div class="row">
        <div class="col-sm-10  col-md-15">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Monitor Engine Setup</h3>
            </div>
            <div class="panel-body">
		      <p>
			    <form:form id="ruleDataInputFileForm" action="loadRuleFile" method="post" modelAttribute="ruleUploadFileModel"  enctype="multipart/form-data">
				    <div class="form-group">
					    	<form:input path="fileData" name="fileData" type="file"/>
					  		<form:button class="btn btn-lg btn-primary" type="submit">Start Engine with Rule file &raquo;</form:button>
		           </div>
				   <c:if test="${loadRuleFileDone==true}">
				     <div class="alert alert-success">
				       <strong>Engine Started with rule File successfully!</strong>
				     </div>
			       </c:if>
		      	</form:form>
		      </p>
            </div>
          </div>
       </div>
      </div>

	 </div><!-- container -->
	 </div><!-- container -->

  </body>
</html>