<%-- 
    Document   : index
    Created on : 10-jun-2013, 11:23:30
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
        <title>Departamento de Servicio Social</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>&iexcl;Bienvenidos al Departamento de Servicio Social!</h1>

                <br/><br/><br/><br/><br/><br/><br/>
                <h1>Noticias</h1>
                <br/><br/><br/><br/><br/><br/><br/>
            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>