<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Vehicles | Find - Modify - Replace</title>

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
	<header id="add-header">
	<div class="header-content">
		<div class="header-content-inner">
			<div class="container">
				<div class="row">
					<div class="col-sm-8">
						<div class="form-container">
							<table>

								<form:form action="addVehicle.do" modelAttribute="vehicle">
									<form:hidden path="vehicleID" value="${nextID}" />
									<tr>
										<td>Year: </td><td><form:input path="year" /></td>

									</tr>
									<tr>
										<td>Make: </td><td><form:input path="make" /></td>

									</tr>
									<tr>
										<td>Model: </td><td><form:input path="model" /></td>

									</tr>
									<tr>
										<td>MPG (Highway) </td><td><form:input path="mpgHighway" /></td>

									</tr>
									<tr>
										<td>MPG (City)</td><td><form:input path="mpgCity" /></td>

									</tr>
									<tr>
										<td>Carbon Emission: </td><td><form:input path="carbonEmission" /></td>

									</tr>
									<tr>
										<td>Transmission</td><td><form:select path="transmission">
												<option value="">Transmission Type</option>
												<option value="manual">Manual</option>
												<option value="automatic">Automatic</option>
											</form:select></td></td>

									</tr>
									<tr>
										<td>Fuel Type: </td><td><form:select path="fuelType">
												<option value="">FuelType</option>
												<option value="Diesel">Diesel</option>
												<option value="Gasoline">Gasoline</option>
												<option value="Midgrade">Midgrade</option>
												<option value="Premium">Premium</option>
												<option value="Electric">Electricity</option>
												
											</form:select></td>

									</tr>
									<tr>
										<td>Drive Wheels: </td><td><form:select path="driveWheels">
												<option value="">Drive Type</option>
												<option value="rear">Rear Wheel Drive</option>
												<option value="front">Front Wheel Drive</option>
												<option value="all">All or Four Wheel Drive</option>
											</form:select></td>

									</tr>
									<tr>
										<td>Number of Cylinders: </td><td><form:input
												path="numberOfCylinders" /></td>

									</tr>
									<tr>
										<td>Displacement: </td><td><form:input
												path="displacement" /></td>

									</tr>
									<tr>
										<td>Gas Tax Required: </td><td><form:select path="gasTaxRequired">
												<option value="true">Yes</option>
												<option value="false" selected>No</option>
											</form:select></td>

									</tr>
							</table>

						</div>

						<button type="submit" class="btn btn-success btn-xl">Add
							Vehicle</button>

						</form:form>
						<div class="col-sm-4">
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