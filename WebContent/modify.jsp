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
                        <a class="page-scroll"  href="index.jsp">App Home</a>
                    </li>
               
                    <li>
                        <a class="page-scroll"  target="_blank" href="http://www.alexmpeterson.com">AlexMPeterson.com</a>
                    </li>
                    <li>
                        <a class="page-scroll" target="_blank"  href="http://www.alexmpeterson.com/projects.php">More of my Projects</a>
                    </li>
                    <li>
                        <a class="page-scroll"  target="_blank" href="http://www.alexmpeterson.com/vehicle-project.php">Project Description</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
	<header id="modify-header">
	<div class="header-content">
		<div class="header-content-inner">
			<div class="container">
				<div class="spacer">
					<br> <br>

				</div>
				<div class="row">
					<div class="col-sm-4">
						<div class="form-container">
							<form:form action="modifyVehicle.do" modelAttribute="vehicle">

								<form:hidden path="vehicleID" />
								<table>
									<tr>
										<td>Year:</td>
										<td><form:input path="year" size="4" /></td>
									</tr>
									<tr>
										<td>Make:</td>
										<td><form:input path="make" size="15" /></td>
									</tr>
									<tr>
										<td>Model:</td>
										<td><form:input path="model" size="15" /></td>
									</tr>

									<tr>
										<td>MPG (Highway)</td>
										<td><form:input path="mpgHighway" size="4" /></td>
									</tr>
									<tr>
										<td>MPG (City)</td>
										<td><form:input path="mpgCity" size="4" /></td>
									</tr>

									<tr>
										<td>Carbon Emission:</td>
										<td><form:input path="carbonEmission" size="15" /></td>
									</tr>

									<tr>
										<td>Transmission</td>
										<td><form:input path="transmission" size="15" /></td>
									</tr>

									<tr>
										<td>Fuel Type:</td>
										<td><form:input path="fuelType" size="15" /></td>
									</tr>

									<tr>
										<td>Drive Wheels:</td>
										<td><form:input path="driveWheels" size="15" /></td>
									</tr>

									<tr>
										<td>Number of Cylinders:</td>
										<td><form:input path="numberOfCylinders" size="4" /></td>
									</tr>
									<tr>
										<td>Displacement:</td>
										<td><form:input path="displacement" size="4" /></td>
									</tr>

									<tr>
										<td>Gas Tax Required:</td>
										<td><form:input path="gasTaxRequired" size="6" /></td>
									</tr>

								</table>



								<input type="radio" name="choice" value="modify" checked>Modify&nbsp;&nbsp;&nbsp;
									<input type="radio" name="choice" value="delete">Delete


								<button type="submit" value="mod" class="btn btn-warning">Modify
									/ Remove</button>
								<br>
								<br>
								<br>

							</form:form>

						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-container">
							<br> <br> <br>


							<object class="manufacturer-icon"
								data="images/large/${fn:toLowerCase(vehicle.make)}.png"
								type="image/png">
								<img class="manufacturer-icon" src="images/large/unknown.png" />
							</object>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="spacer">
							<br> <br> <br> <br> <br>

						</div>
						<div id="site-description">
							<table>
								<tr colspan="2">
									Currently Saved Vehicle Data
								</tr>
								<tr>
									<td>Year:</td>
									<td>${vehicle.year}</td>
								</tr>
								<tr>
									<td>Make:</td>
									<td>${vehicle.make}</td>
								</tr>
								<tr>
									<td>Model:</td>
									<td>${vehicle.model}</td>
								</tr>
								<tr>
									<td>MPG (Highway):</td>
									<td>${vehicle.mpgHighway}</td>
								</tr>
								<tr>
									<td>MPG (City)</td>
									<td>${vehicle.mpgCity}</td>
								</tr>
								<tr>
									<td>Emissions (CO2):</td>
									<td>${vehicle.carbonEmission}</td>
								</tr>
								<tr>
									<td>Transmission:  ∂</td>
									<td>${vehicle.transmission}</td>
								</tr>
								<tr>
									<td>Fuel Type:</td>
									<td>${vehicle.fuelType}</td>
								</tr>
								<tr>
									<td>Drive Wheels:</td>
									<td>${vehicle.driveWheels}</td>
								</tr>
								<tr>
									<td>Cylinders:</td>
									<td>${vehicle.numberOfCylinders}</td>
								</tr>
								<tr>
									<td>Displacement:</td>
									<td>${vehicle.displacement}</td>
								</tr>
								<tr>
									<td>Gas Tax?:</td>
									<td>${vehicle.gasTaxRequired}</td>
								</tr>
							</table>
						</div>
					</div>


					<div class="form-container"></div>

				</div>
			</div>
			<form action="changeVehicle.do" method="GET">
				<input type="hidden" name="choice" value="modify" /> <input
					type="hidden" name="currentId" value="${vehicle.vehicleID}" />
				<button class="btn btn-success" type="submit" name="nav"
					value="prev">previous</button>
				<button class="btn btn-success" type="submit" name="nav"
					value="next">next</button>
			</form>
		</div>
		<!-- inner -->
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
