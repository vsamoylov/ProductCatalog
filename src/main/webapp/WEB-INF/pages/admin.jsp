<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/5/2015
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>

<jsp:include page="fragments/header.jsp" />

<!-- Memu Start-->
<div align="center">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome : ${pageContext.request.userPrincipal.name}
            | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
    </c:if>
</div>

<!-- Memu End-->
<div align="center">
    <h1>${message1}</h1>

    <form action="/admin/add-category" method="post">
        <p><input type="text" name="category_name" placeholder="Category title"/></p>
        <p><input type="text" name="category_description" placeholder="Description"/></p>
        <p><input type="submit" value="Add Category"/></p>
    </form>
</div>
<br>
<br>
<div align="center">
    <h1>${message2}</h1>
    <form action="/admin/add-product" method="post">
        <p><input type="text" name="product_name" placeholder="Product title"/></p>
        <p><input type="text" name="product_stock" placeholder="Product Stock"/></p>
        <p><input type="text" name="product_price" placeholder="Product Price"/></p>
        <p><input type="text" name="product_description" placeholder="Description"/></p>
        <p><input type="submit" value="Add Product"/></p>
    </form>
</div>

<jsp:include page="fragments/footer.jsp" />

</body>
</html>
