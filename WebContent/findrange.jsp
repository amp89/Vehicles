<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicles | Find Range</title>
</head>
<body>
<a href="index.jsp">Back to Home</a><br>
<!-- <form action="findrange.do" method="GET">
	Start Year: <input type="text" name="yearStart" ><br>
	End Year: <input type="text" name="yearEnd" ><br>
	Make: <input type="text" name="make" ><br>
	Model: <input type="text" name="model" ><br>
	MPG: <input type="text" name="mpg">
		<input type="radio" name="mpgBools" value="more">At least
		<input type="radio" name="mpgBools" value="less" checked>Less Than

	<br>
	Transmission: <input type="text" name="trans"><br>
	Fuel Type: <input type="text" name="fuel"><br>
	Drive Wheels: <input type="text" name="drive"><br>
	Cylinders: <input type="text" name="cylinders">
			<input type="radio" name="cylBools" value="more" checked>At least
		<input type="radio" name="cylBools" value="less">Less Than
	<br>
	Displacement: <input type="text" name="displacement">
				<input type="radio" name="dispBools" value="more" checked>At least
		<input type="radio" name="dispBools" value="less">Less Than
	<br>
	GasTax: <input type="text" name="gasTax"><br>
	<button type="submit">Find Matching Vehicles</button>
	
	

</form> -->

<form:form action="findrange.do" modelAttribute="vehicleParameters">
	Start year: <form:input path="yearStart" />
	End year: <form:input path="yearEnd" />
	Make: <form:input path="make" />
	Model: <form:input path="model" />
	Average MPG: <form:input path="mpg" />
	More<form:radiobutton path="mpgBool" value="more"/>Less<form:radiobutton path="mpgBool" value="less"/><br>
	Transmission: <form:input path="transmission" />
	Fuel Type: <form:input path="fuelType" />
	Drive Wheels: <form:input path="driveWheels" />
	Cly: <form:input path="numberOfCylinders" />
	More<form:radiobutton path="cylBool" value="more"/>Less<form:radiobutton path="cylBool" value="less"/><br>

	Displacement: <form:input path="displacement" />
	More<form:radiobutton path="dispBool" value="more"/>Less<form:radiobutton path="dispBool" value="less"/><br>


	
	Gas Tax: I don't care<form:radiobutton path="gasTax" value="" /><br>
	True<form:radiobutton path="gasTax" value="true"/><br>
	False<form:radiobutton path="gasTax" value="false"/><br>
	<input type="submit" value="Find Vehicles">
	<!-- <input type="reset" value="Reset Form"> -->
	
	

</form:form>

	<c:forEach var="v" items="${vehicleListRange}">
		V: ${v}<br> <form action="menuchoice.do">
		<input type="hidden" name="id" value="${v.vehicleID}">
		<!-- <input type="hidden" name="choice" value="modify"> -->
		<input type="hidden" name="selection" value="modify">
		<input type="submit" value="mod">
		</form>
	</c:forEach>

</body>
</html>