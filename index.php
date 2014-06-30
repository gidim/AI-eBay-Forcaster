
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
		
	<?php include 'sqlConnect.php' ?>	
	
    <title>ebayForecaster</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <!--<link href="starter-template.css" rel="stylesheet">-->

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

	<div class="container" style="padding-top:5px;">
		
		 
		 <!-- cover image row -->
		 <div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<img src="images/logoTransparentPNG.png" class="img-rounded img-responsive" style="border:1px solid #428BCA;">
			</div>
			<div class="col-lg-1"></div>
		 </div>
		 <!-- end of cover image row -->
		 
		 <!-- content row -->
		 <div class="row">
			<!-- news column -->
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<div class="container-fluid">
					<div class="row" style="padding-bottom:20px;">
						<div class="col-lg-8">
							<h1>Get Product Forecast</h1> <!-- header -->
						</div>
						<div class="col-lg-4 text-right">
							<h1><small>ebayForecaster</small></h1>
						</div>
					</div>					
					<!-- content -->					
					<div class="row clearfix">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">Get Forecast</h3>
								</div>				  
								<div class="panel-body">														
									<form class="form" role="form" action="output.php" method="post">
										<div class="form-group">										
											<select class="form-control" name="productId">											
												<?php
													while($row = mysqli_fetch_array($result)) {																											
														echo getProductName($row['productId']);															
													}													
												?>
											</select>
										</div>
										<button type="submit" class="btn btn-default">Submit</button>
									</form>
								</div>
							</div>
						</div>							
						<div class="col-md-2"></div>
					</div>						
					<!-- end of content -->
				</div>
			</div>
			<div class="col-lg-1"></div>
			<!-- end of news column -->			
			
		 </div>		
		<!-- end of content row -->
	</div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
  </body>
</html>
