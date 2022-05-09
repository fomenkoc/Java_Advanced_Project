<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bucket</title>
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

			<!-- Page Content -->
			<div id="admin-main-control" class="col-md-10 p-x-3 p-y-1">
				<div class="w3-container black-white">
					<h1><spring:message code="bucket.title"/></h1>
				</div>
				<div class="w3-container d-flex flex-wrap">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<form id="logoutForm" method="POST" action="${contextPath}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
						
					</c:if>




					<table class="table table-striped">
						<thead>
							<tr>
								<th>id</th>
								<th><spring:message code="bucket.name"/></th>
								<th><spring:message code="bucket.description"/></th>
								<th><spring:message code="bucket.price"/></th>
								<th><spring:message code="bucket.image"/></th>
								<th><spring:message code="bucket.date"/></th>
								<th><spring:message code="bucket.action"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bucket" items="${bucketItems}">
								<tr>
									<td>${bucket.id}</td>
									<td>${bucket.periodical.name}</td>
									<td>${bucket.periodical.description}</td>
									<td>${bucket.periodical.price}</td>
									<td><img
										src="data:image/jpg;base64,${bucket.periodical.encodedImage}"
										alt="image" style="width: 20%; max-height: 100px"></td>
									<td>${bucket.purchaseDate}</td>
									<td><a href="bucket?id= ${bucket.id}"><spring:message code="bucket.delete"/></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</div>


			</div>
		</div>
	</div>
</body>
</html>