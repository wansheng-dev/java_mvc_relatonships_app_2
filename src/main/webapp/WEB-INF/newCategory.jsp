<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<form:form action="/categories/create" method="post" modelAttribute="category">
    <span style="color: red"><form:errors path="*"/>
    </span>
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    </p>
    <p>
        <input type="submit" value="Submit"/>
    </p>
</form:form>
</body>
</html>