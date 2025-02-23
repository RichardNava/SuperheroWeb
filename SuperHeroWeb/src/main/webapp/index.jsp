<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Código JSP --%>
<%-- <jsp:include page="header.jsp"/> --%>
<%-- Código con Servlet --%>
<%--<%@include file="header.jsp" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.3/superhero/bootstrap.rtl.min.css" integrity="sha512-Kghq6IhdiZiBhUVgmB2i5s3KfP6xP+Agc2Ez1AOR1yoOzDa5EAexQV94Qrv0zrbpeD8tbskZcjssvs2VzIWFvA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <div class="container mt-5 ">
            <div class="row justify-content-center">
                <div class="col-6 bg-secondary p-4 mb-5">
                    <form action="UserServlet" method="POST">
                        <fieldset>
                            <legend>Login</legend>
                            <input type="hidden" name="mode" value="login"/>
                            <div>
                                <label for="exampleInputEmail1" class="form-label mt-4">Email address</label>
                                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
                            </div>
                            <div>
                                <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
                                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password" autocomplete="off">
                            </div>
                            <c:if test="${not empty msg}">
                                <p class="text-danger">${msg}</p>
                            </c:if>
                            <button type="submit" class="btn col-3 btn-success mt-4">Send</button>
                            <a href="singup.jsp" class="btn col-4 btn-info mt-4">Create User</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
