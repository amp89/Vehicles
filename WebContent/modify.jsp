<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib
    uri="http://www.springframework.org/tags/form"
    prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">Back to Home</a><br>
modify.jsp
<%-- <form action="modifyVehicle.do" method="GET">
	
	id: ${vehicleToModify.vehicleID}<br>
	<input type="hidden" name="vehicleID" value="${vehicleToModify.vehicleID}">
	Year: <input type="text" name="year" value="${vehicleToModify.year}" ><br>
	Make: <input type="text" name="make" value="${vehicleToModify.make}"><br>
	Model: <input type="text" name="model" value="${vehicleToModify.model}"><br>
	MPG (highway): <input type="text" name="mpgHighway" value="${vehicleToModify.mpgHighway}"><br>
	MPG (city): <input type="text" name="mpgCity" value="${vehicleToModify.mpgCity}"><br>
	

	<br>
	C02 Emission: <input type="text" name="carbonEmission" value="${vehicleToModify.carbonEmission}"><br>
	Transmission: <input type="text" name="transmission" value="${vehicleToModify.transmission}"><br>
	Fuel Type: <input type="text" name="fuelType" value="${vehicleToModify.fuelType}"><br>
	Drive Wheels: <input type="text" name="driveWheels" value="${vehicleToModify.driveWheels}"><br>
	Cylinders: <input type="text" name="numberOfCylinders" value="${vehicleToModify.numberOfCylinders}"><br>
	Displacement: <input type="text" name="displacement" value="${vehicleToModify.displacement}"><br>
	GasTax: <input type="text" name="gasTaxRequired" value="${vehicleToModify.gasTaxRequired}"><br>
	<button type="submit">Change Vehicle ID# ${vehicleToModify.vehicleID}</button>


</form> --%>
<form:form action="modifyVehicle.do" modelAttribute="vehicle">
VEHICLE ID TO MODIFY: ${vehicle.vehicleID}<br>
<form:hidden path="vehicleID" /><br>
Year: <form:input path="year" /><br>
Make: <form:input path="make" /><br>
Model: <form:input path="model" /><br>
MPG (Highway) <form:input path="mpgHighway" /><br>
MPG (City)<form:input path="mpgCity" /><br>
Carbon Emission: <form:input path="carbonEmission" /><br>
Transmission<form:input path="transmission" /><br>
Fuel Type: <form:input path="fuelType" /><br>
Drive Wheels: <form:input path="driveWheels" /><br>
Number of Cylinders: <form:input path="numberOfCylinders" /><br>
Gas Tax Required: <form:input path="gasTaxRequired" /><br>

<input type="radio" name="choice" value="modify" checked>Modify<br>
<input type="radio" name="choice" value="delete">Delete<br>
<!-- <input type="radio" name="choice" value="add"> -->

<input type="submit" value="click this"><br>

</form:form>


</body>
</html>