<%-- 
    Document   : mensajeOrganizacion
    Created on : 11-jun-2013, 13:56:30
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
        <title>Mensajes Organizador</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="../PanelOrganizacion/menuPanelOrganizacion.jsp" />
        <div id="contenido">
            <h1>Mensajes Organizaci&oacute;n</h1>
            <h4>A continuaci&oacute;n se muestran mensajes que el administrador le ha enviado:</h4>




            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>