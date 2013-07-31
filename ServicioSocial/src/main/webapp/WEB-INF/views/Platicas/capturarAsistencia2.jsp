<%-- 
    Document   : capturarAsistencia
    Created on : 4/06/2013, 09:47:02 AM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <link rel="stylesheet" href="css/platicasEstiloFormularioformly.css" type="text/css" />


        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>

        <title>Capturar Asistencia a Plática</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido" >  
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center><h2>Capturar Asistencia a Plática</h2></center>  
                
             <img src="data:image/jpg;base64, ${foto}">
             <img src="<c:out value='${foto}'/>" />

            </div>
            <div style="clear:both;"></div>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
