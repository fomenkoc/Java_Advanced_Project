<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="/css/login.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script type="text/javascript" src="/js/login.js"></script>
	
</head>

<body>

<div class="container">

    <div class="row mgTp">
        <form method="POST" action="${contextPath}/login" class="form-signin col-md-6 offset-md-3">
            <h3 class="title"><spring:message code="login.title"/></h3>
            <hr class="divisor">
            <div class="form-group">
                <label for="exampleInputEmail1"><spring:message code="login.email"/></label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="<spring:message code="login.email"/>" name="email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1"><spring:message code="login.password"/></label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="<spring:message code="login.password"/>" name="password">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary topBtn"><i class="fa fa-sign-in"></i> <spring:message code="login.singIn"/></button>
            <h4 class="text-center">
            	<a href="${contextPath}/registration"><spring:message code="login.createAccount"/></a>
            </h4>
        <div>
			<fieldset style="text-align: center;">
				<label><spring:message code="login.choose_lang" /></label>
				<select id="locales">
					<option value="en"><spring:message code="login.english"/></option>
					<option value="ua"><spring:message code="login.ukrainian"/></option>
				</select>
			</fieldset>
		</div>            
        </form>

    </div>

</div>
</body>
</html>