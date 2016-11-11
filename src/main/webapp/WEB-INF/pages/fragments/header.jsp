<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users" var="users" />
<spring:url value="/products" var="products" />
<spring:url value="/category" var="categories" />
<spring:url value="/uploads" var="uploads" />
<spring:url value="/admin" var="admin" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Product Catalog</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${users}">Users</a></li>
				<li class="active"><a href="${products}">Products</a></li>
				<li class="active"><a href="${categories}">Categories</a></li>
				<li class="active"><a href="${uploads}">Uploads</a></li>
				<li class="active"><a href="${admin}">Admin Page</a></li>
			</ul>
		</div>
	</div>
</nav>