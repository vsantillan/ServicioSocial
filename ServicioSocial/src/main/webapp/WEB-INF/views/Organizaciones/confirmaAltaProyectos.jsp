<%-- 
    Document   : confirmaAltaProyectos
    Created on : 15-ago-2013, 17:55:18
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
        <%@ include file="../Template/headsOrganizaciones.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        
        <title>Alta de Proyectos</title>
        
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <jsp:include page="../PanelOrganizacion/menuPanelOrganizacion.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">
            <center>
                <br/>
                
                <h1>Proyecto registrado correctamente</h1>
                <img src="imagenes/paloma.png"/>
                <h3>Espere la confirmaci&oacute;n del administrador para validar su cuenta. Ser&aacute; notificado en la direcci&oacute;n de correo que nos ha proporcionado a la brevedad posible.</h3>
                
                <br/>

            </center>
        </div>
        <%-- fin del contenido --%>
        
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
