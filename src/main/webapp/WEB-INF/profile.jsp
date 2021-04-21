<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Driver's License</title>
</head>
<body>
	<div class="container mt-5">
		<h6><c:out value="${person.firstName} ${person.lastName}"/></h6>
		<p class="mt-5">License Number: <c:out value="${person.license.number}"/></p>
		<p class="mt-5">State: <c:out value="${person.license.state}"/></p>
		<p class="mt-5">Expiration Date: <c:out value="${person.license.expirationDate}"/></p>
	</div>
</body>
</html>