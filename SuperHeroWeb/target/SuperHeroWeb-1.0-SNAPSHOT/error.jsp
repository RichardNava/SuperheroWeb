<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : error
    Created on : 21 ene 2025, 9:30:42
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<%--<jsp:include page="header.jsp"/>--%>

<%-- Si en la barra de url pones /error.jsp al final te devuelve a index.jsp porque no hay ningun error--%>
<c:if test="${exception == null}">
    <c:redirect url="private/home.xhtml"/>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Error</title> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.3/superhero/bootstrap.rtl.min.css" integrity="sha512-Kghq6IhdiZiBhUVgmB2i5s3KfP6xP+Agc2Ez1AOR1yoOzDa5EAexQV94Qrv0zrbpeD8tbskZcjssvs2VzIWFvA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/styles.css"/>      
    </head>
    <body>
        <h1>Error <%=exception.getMessage()%></h1>
        <a href="index.jsp">Volver a Inicio</a>
    </body>
</html>
