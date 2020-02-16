<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1><c:out value="${currentCategory.name}"/></h1>
	<h3>Categories:</h3>
	<ul>
		<c:forEach items="${currentCategory.products}" var="currentProduct">
			<li><c:out value="${currentProduct.name}"/></li>
		</c:forEach>
	</ul>
		<form:form action="/categories/addproduct/${currentCategory.id}" method="post" modelAttribute="product">
			<p>
				<form:label path="id">Add Product:</form:label>
		    	<form:select path="id">
		        <c:forEach items="${products}" var="newProduct">
					<form:option value="${newProduct.id}">
						<c:out value="${newProduct.name}"/>
		            </form:option>
				</c:forEach>
		    	</form:select>
			</p>
			<p>
				<input type="submit" value="Submit"/>
			</p>
		</form:form>
</body>
</html>