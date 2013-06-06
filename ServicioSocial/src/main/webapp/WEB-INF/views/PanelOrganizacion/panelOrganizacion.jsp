<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Bustedvillain
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
        <title>Panel Organizaci&oacute;n</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');" >
        
        <%@ include file="../Template/banner.jsp" %>
        
        <jsp:include page="menuPanelOrganizacion.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">

            <h1>Bienvenido</h1>


        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
