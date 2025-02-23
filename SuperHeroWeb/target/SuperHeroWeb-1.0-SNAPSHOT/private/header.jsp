<%-- 
    Document   : header
    Created on : 20 ene 2025, 11:25:06
    Author     : RaúlGalán
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Navbar</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.3/superhero/bootstrap.rtl.min.css" integrity="sha512-Kghq6IhdiZiBhUVgmB2i5s3KfP6xP+Agc2Ez1AOR1yoOzDa5EAexQV94Qrv0zrbpeD8tbskZcjssvs2VzIWFvA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-primary nav-anchor" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Superheroes App</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <c:if test="${sessionScope.user.username!=null}">
                    <div class="collapse navbar-collapse" id="navbarColor01">
                        <ul class="navbar-nav me-auto">
                            <li class="nav-item">
                                <a class="nav-link active" href="private/home.jsp">Home
                                    <span class="visually-hidden">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="private/find.xhtml">Buscar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="private/viewsuperhero.xhtml?source=team">Crear Equipo</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="private/game.xhtml">Jugar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="private/viewsuperhero.xhtml?source=view">Ver Superheroes</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <img width="32" height="32" src="https://img.icons8.com/windows/32/user.png" alt="user"/>
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Name: ${sessionScope.user.username}</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="private/profile.xhtml">Ver/Editar Perfíl</a>
                                    <div class="dropdown-divider"></div>
                                    <form action="UserServlet" method="POST">
                                        <a class="dropdown-item">Cerrar Sesión</a>
                                        <input type="hidden" name="mode" value="logout"/>
                                    </form>
                                </div>
                            </li>
                        </ul>
                        <!--<form class="d-flex">
                            <input class="form-control me-sm-2" type="search" placeholder="Search">
                            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                        </form>-->
                    </div>
                </c:if>
            </div>
        </nav>
    </body>
</html>
