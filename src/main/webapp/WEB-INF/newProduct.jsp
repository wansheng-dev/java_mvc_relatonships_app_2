<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/products/create" method="post" modelAttribute="product">
    <span style="color: red"><form:errors path="*"/>
    </span>
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:input path="description"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:input path="price"/>
    </p>
    <p>
        <input type="submit" value="Submit"/>
    </p>
</form:form>
</body>
</html>