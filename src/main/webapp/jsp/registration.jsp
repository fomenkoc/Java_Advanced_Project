<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Create an account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

	<div class="container">

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="firstName" class="form-control" placeholder="First name" autofocus="true"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="lastName" class="form-control" placeholder="Last name" autofocus="true"></form:input>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>


			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="email" class="form-control" placeholder="Email" autofocus="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control" placeholder="Password" id="password" onchange="verifyPassword()"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>


			<div class="form-group ${status.error ? 'has-error' : ''}">
				<input type="password" class="form-control" id="rPassword" onchange="verifyPassword()" placeholder="Confirm your password"></input>

			</div>


			<button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">Submit</button>
		</form:form>

	</div>
	<script type="text/javascript">
	function verifyPassword() {
		let password = document.getElementById("password").value;
		let rPassword = document.getElementById("rPassword").value;
		if (password != rPassword) {
			document.getElementById("submit").setAttribute("disabled","disabled");;
		} else {
			document.getElementById("submit").removeAttribute("disabled");
		}
		}
		document.getElementById("password").addEventListener("change", verifyPassword);
		document.getElementById("rPassword").addEventListener("change", verifyPassword);
	</script>
</body>
</html>