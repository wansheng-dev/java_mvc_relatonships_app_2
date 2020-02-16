<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${currentProduct.name}"/></h1>
	<h3>Categories:</h3>
	<ul>
		<c:forEach items="${currentProduct.categories}" var="currentCategory">
			<li><c:out value="${currentCategory.name}"/></li>
		</c:forEach>
	</ul>
		<form:form action="/products/addcategory/${currentProduct.id}" method="post" modelAttribute="category">
			<p>
				<form:label path="id">Add Category:</form:label>
		    	<form:select path="id">
		        <c:forEach items="${categories}" var="newCategory">
					<form:option value="${newCategory.id}">
						<c:out value="${newCategory.name}"/>
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