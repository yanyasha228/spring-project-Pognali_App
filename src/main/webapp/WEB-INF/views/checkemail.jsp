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
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Check email address</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" action="${contextPath}/checkemail" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Please enter the code from you mail</h2>
        <spring:bind path="checkcode">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="checkcode" class="form-control" placeholder="Checkcode"
                            autofocus="true"></form:input>
                <form:errors path="checkcode"></form:errors>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <h4 class="text-center"><a href="${contextPath}/checkemail">Send message again</a></h4>
    </form:form>

</div>


<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>