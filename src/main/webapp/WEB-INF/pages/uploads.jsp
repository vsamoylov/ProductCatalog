<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="fragments/header.jsp" />

<div align="center">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome : ${pageContext.request.userPrincipal.name}
            | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
    </c:if>

    <form action="uploads" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="Upload"/>
    </form>
</div>

<jsp:include page="fragments/footer.jsp" />

</body>
</html>
