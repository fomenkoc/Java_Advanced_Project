<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

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

<title>Periodicals</title>

<link rel="stylesheet" href="/css/home.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div id="admin-sidebar" class="col-md-2 p-x-0 p-y-3">
				<ul class="sidenav admin-sidenav list-unstyled">
					<li><a href="/home"><spring:message code="menu.home"/></a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/create-periodical"><spring:message code="menu.createPeriodical"/></a></li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_USER')">
						<li><a href="/buckets"><spring:message code="menu.bucket"/></a></li>
					</security:authorize>
					<li><a href="#"
						onclick="document.forms['logoutForm'].submit()"><spring:message code="menu.logout"/></a></li>
				</ul>
				<p>${pageContext.request.userPrincipal.name}
			</div>
			<!-- /#admin-sidebar -->
			<div id="admin-main-control" class="col-md-10 p-x-3 p-y-1">
				<!-- Page Content -->
				<div class="w3-container black-white">
					<h1><spring:message code="home.title"/></h1>
				</div>

				<div class="w3-container d-flex flex-wrap">

					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<form id="logoutForm" method="POST" action="${contextPath}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
						
					</c:if>
					<c:if test="${not empty periodicals}">
						<c:forEach items="${periodicals}" var="currentPeriodical">
							<div class="w3-card-4" style="width: 20%; margin: 2%; min-width: 300px">
								<img
									src="data:image/jpg;base64, ${currentPeriodical.encodedImage}"
									alt="Norway" style="width: 100%">
								<div class="w3-container w3-center">
									<h3>${currentPeriodical.name}</h3>
									<p>${currentPeriodical.description}</p>
									<p>${currentPeriodical.price}</p>
								</div>
								<security:authorize access="hasRole('ROLE_USER')">
									<form:form action="${contextPath}/bucket" method="POST"
										enctype="multipart/form-data">
										<input type="hidden" value="${currentPeriodical.id}"
											class="form-control" name="periodicalId">
										<input type="submit" class="w3-button w3-block w3-dark-grey"
											value="<spring:message code="home.addToBucket"/>">
									</form:form>
								</security:authorize>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>