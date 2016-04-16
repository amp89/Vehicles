<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib
    uri="http://www.springframework.org/tags/form"
    prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicles</title>
</head>
<body>
<form action="menuchoice.do" method="POST">
	<button type="submit" name="selection" value="range">Find Vehicles</button>
	<button type="submit" name="selection" value="add">Add</button>
	take out: <button type="submit" name="selection" value="remove">Remove</button>
	<button type="submit" name="selection" value="all">View All</button>
 	take out: <button id="mod"  name="selection" value="modify">Modify</button>

 




	
	<input id="vidInput" type="text" name="id">

</form>
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>



<%-- 
<c:forEach var="vehicle" items="${vehicleListFull}">
   <script>values.push($vehicle.vehicleID)</script>
</c:forEach> --%>


</body>
</html>