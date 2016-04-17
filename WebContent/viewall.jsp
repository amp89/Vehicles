<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
                        <a class="page-scroll"  target="_blank" href="http://www.alexmpeterson.com">AlexMPeterson.com</a>
                    </li>
                    <li>
                        <a class="page-scroll"  href="http://www.alexmpeterson.com/projects.php">More of my Projects</a>
                    </li>
                    <li>
                        <a class="page-scroll"  href="http://www.alexmpeterson.com/projects.php">Project Description</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
	<!-- <header id="findrange-header">
        <div class="header-content">
            <div class="header-content-inner">
<div class="container">
  <div class="row">
      <div class="col-sm-6">
        <div class="form-container">FORMS
      thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs</div>

            </div>
            <div class="col-sm-5">
            <div class="form-container">
              DATA
              thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs        thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs        thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs thingsds asfs</div>

                    </div>
        </div>
      </div>
    </div>
      </div>
    </header> -->


	<section id="listall"> <!-- <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">At Your Service</h2>
                    <hr class="primary">
                </div>
            </div>
        </div> -->
	<div class="container">

		<c:forEach var="v" items="${vehicleListFull}">

		<div class="row">
			<div class="col-md-12 text-center">
				<h3>${v.year}${v.make} ${v.model}</h3>
				<div class="row text-muted">
					<div class="col-xs-12 col-sm-3">MPG (Highway):
						${v.mpgHighway}</div>
					<div class="col-xs-12 col-sm-3">MPG (City): ${v.mpgCity}</div>
					<div class="col-xs-12 col-sm-3">MPG (Average):
						${v.mpgAverage}</div>
					<div class="col-xs-12 col-sm-3">Carbon Emission:
						${v.carbonEmission}</div>
					<div class="col-xs-12 col-sm-3">Transmission:
						${v.transmission}</div>
					<div class="col-xs-12 col-sm-3">Fuel Type: ${v.fuelType}</div>
					<div class="col-xs-12 col-sm-3">Cylinders:
						${v.numberOfCylinders}</div>
					<div class="col-xs-12 col-sm-3">Displacement:
						${v.displacement}</div>
					<div class="col-xs-12 col-sm-3">Gas Guzzler Tax:
						${v.gasTaxRequired}</div>
				</div>
			</div>
			<div class"col-md-12 "> 
			<form action="menuchoice.do">
		<input type="hidden" name="id" value="${v.vehicleID}">
		<input type="hidden" name="selection" value="modify">
			<button
					 type="submit" value="mod" class="btn btn-danger mod-button">Modify / Remove</button>
					 </form>
		</div>
		</div> <!-- end row -->
		</c:forEach>



            </div><!-- container  --> </section>


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
