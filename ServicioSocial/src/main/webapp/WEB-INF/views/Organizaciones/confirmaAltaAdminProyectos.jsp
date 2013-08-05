<%-- 
    Document   : confirmaAdminRegOrganizacion
    Created on : 09-jul-2013, 10:56:56
    Author     : bustedvillain
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>
        
        <title>Administrador</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">

                <%-- Formulario Nueva Organizacion --%>
                <center>
                    <h1>Proyecto registrado correctamente</h1>
                    <img src="imagenes/paloma.png"/>

                    <br/>
                </center>
            </div>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
