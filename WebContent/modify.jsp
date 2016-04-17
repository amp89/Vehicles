<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Vehicles | Add</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

<!-- Custom Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"
	type="text/css">

<!-- Plugin CSS -->
<link rel="stylesheet" href="css/animate.min.css" type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/creative.css" type="text/css">
<link rel="stylesheet" href="css/stylesheet.css" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="index.jsp">Vehicle Search WebApp</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="http://www.alexmpeterson.com">AlexMPeterson.com</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="http://www.alexmpeterson.com/projects.php">More of my Projects</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="http://www.alexmpeterson.com/projects.php">Project Description</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
	<header id="add-header">
	<div class="header-content">
		<div class="header-content-inner">
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-container">
							<form:form action="modifyVehicle.do" modelAttribute="vehicle">

								<form:hidden path="vehicleID" />
								<br>
Year: <form:input path="year" />
								<br>
Make: <form:input path="make" />
								<br>
Model: <form:input path="model" />
								<br>
MPG (Highway) <form:input path="mpgHighway" />
								<br>
MPG (City)<form:input path="mpgCity" />
								<br>
Carbon Emission: <form:input path="carbonEmission" />
								<br>
Transmission<form:input path="transmission" />
								<br>
Fuel Type: <form:input path="fuelType" />
								<br>
Drive Wheels: <form:input path="driveWheels" />
								<br>
Number of Cylinders: <form:input path="numberOfCylinders" />
								<br>
Gas Tax Required: <form:input path="gasTaxRequired" />
								<br>

								<input type="radio" name="choice" value="modify" checked>Modify&nbsp;&nbsp;&nbsp;
								<input type="radio" name="choice" value="delete">Delete<br><br>
								<!-- <input type="radio" name="choice" value="add"> -->


								<button type="submit" value="mod"
									class="btn btn-warning">Modify / Remove</button>
								<br><br><br>
							</form:form>

						</div>
					</div>
					<div class="col-sm-5">
					<div class="form-container">
						<object class="manufacturer-icon" data="images/large/${fn:toLowerCase(vehicle.make)}.png"
		type="image/png">
		<img class="manufacturer-icon" src="images/large/unknown.png" />
	</object><br><br>
						Currently Saved Vehicle Data: <br>
						Year: ${vehicle.year}<br>
						Make: ${vehicle.make}<br>
						Model: ${vehicle.model}<br>
						MPG (Highway): ${vehicle.mpgHighway}<br>
						MPG (City) ${vehicle.mpgCity}<br>
						Emissions (CO2): ${vehicle.carbonEmission}<br> 
						Transmission: ${vehicle.transmission}<br>
						Fuel Type: ${vehicle.fuelType}<br>
						Drive Wheels: ${vehicle.driveWheels}<br>
						Cylinders: ${vehicle.numberOfCylinders}<br>
						Gas Tax?: ${vehicle.gasTaxRequired}

					</div>


						<div class="form-container"></div>

					</div>
				</div>
			</div>
		</div>
	</header>



	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="js/jquery.easing.min.js"></script>
	<script src="js/jquery.fittext.js"></script>
	<script src="js/wow.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/creative.js"></script>

</body>

</html>
