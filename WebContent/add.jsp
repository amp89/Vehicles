<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib
    uri="http://www.springframework.org/tags/form"
    prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicles | Add Vehicle</title>
</head>
<body>
<a href="index.jsp">Back to Home</a><br>

<form:form action="addVehicle.do" modelAttribute="vehicle">
Vehicle to add: #${nextID}<br>
<form:hidden path="vehicleID" value="${nextID}" /><br>
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

<input type="submit" value="Add Vehicle"><br>

</form:form>


</body>
</html>