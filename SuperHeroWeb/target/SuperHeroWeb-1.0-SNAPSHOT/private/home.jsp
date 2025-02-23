<%-- 
    Document   : home
    Created on : 20 ene 2025, 12:29:37
    Author     : RaúlGalán
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
<!--        <link rel="stylesheet" href="css/styles.css"/>-->
    </head>
    <body>
        <h1>${param.ov}</h1>
        <div class="container-grid m-4">
            <div class="item">
                <button type="button" onclick="window.location.href = 'private/viewsuperhero.xhtml'" style="border: none; background: transparent; padding: 0; cursor: pointer; width: 100%; height: 100%; position: relative;">
                    <img src="img/b_equipo.jpg" alt="Button Image" style="object-fit: cover; width: 100%; height: 100%;">
                    <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); color: white; font-size: 50px; font-weight: bold;">
                        Crear Equipo
                    </div>
                </button>
            </div>
            <div class="item">
                <button type="button" onclick="window.location.href = 'private/find.xhtml'" style="border: none; background: transparent; padding: 0; cursor: pointer; width: 100%; height: 100%; position: relative;">
                    <img src="img/b_buscar.jpg" alt="Button Image" style="object-fit: cover; width: 100%; height: 100%;">
                    <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); color: white; font-size: 50px; font-weight: bold;">
                        Busqueda Avanzada
                    </div>
                </button>
            </div>
            <div class="item">
                <button type="button" onclick="window.location.href = 'private/game.xhtml'" style="border: none; background: transparent; padding: 0; cursor: pointer; width: 100%; height: 100%; position: relative;">
                    <img src="img/b_jugar.jpg" alt="Button Image" style="object-fit: cover; width: 100%; height: 100%;">               
                    <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); color: white; font-size: 50px; font-weight: bold;">
                        Jugar
                    </div>
                </button>
            </div>
            <div class="item">
                <button type="button" onclick="window.location.href = 'private/viewsuperhero.xhtml'" style="border: none; background: transparent; padding: 0; cursor: pointer; width: 100%; height: 100%; position: relative;">
                    <img src="img/b_superheroes.jpg" alt="Button Image" style="object-fit: cover; width: 100%; height: 100%;">
                    <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); color: white; font-size: 50px; font-weight: bold;">
                        Ver SuperHeroes
                    </div>
                </button>
            </div>
        </div>
    </body>
</html>
