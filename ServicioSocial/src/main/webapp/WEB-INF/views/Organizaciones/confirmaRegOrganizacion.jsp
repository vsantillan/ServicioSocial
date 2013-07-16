<%-- 
    Document   : confirmaRegOrganizacion
    Created on : 09-jul-2013, 10:52:07
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
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>       
<script>
            $(document).ready(function() {
                $(".MyForm").formly();
            })
        </script>

        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>
        <link rel="stylesheet" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>
        

        <title>Departamento de Servicio Social :: Organizaciones ::</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="../NavegacionPrincipal/menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                
                <h1>Organizaci&oacute;n registrada correctamente</h1>
                <img src="imagenes/paloma.png"/>
                <h3>Espere la confirmaci&oacute;n del administrador para validar su cuenta. Ser&aacute; notificado en la direcci&oacute;n de correo que nos ha proporcionado a la brevedad posible.</h3>
                
                <br/>

            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>