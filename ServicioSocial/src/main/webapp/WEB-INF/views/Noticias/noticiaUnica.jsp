<%-- 
    Created on : 10-jun-2013, 11:23:30
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <title>Departamento de Servicio Social</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="../NavegacionPrincipal/menuPrincipal.jsp" />
        <div id="contenido">
            <h1>${noticia.titulo}</h1>
            <h2>${noticia.detalle}</h2>
            <br>

        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>