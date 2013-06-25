<%-- 
    Document   : AsistenciaPosteriorEspecial
    Created on : 4/06/2013, 12:19:34 PM
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

        <script>

            $(document).ready(function() {

                $('#casistenciaespecial').formly();
            });
        </script>
        <title>Capturar Asistencia Especial Posterior</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')">
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center><h2>Capturar Asistencia Especial Posterior</h2></center>  
                <center><form:form name="casistenciaespecial" id="casistenciaespecial" action="#">
                        <label for="alumno">Número de control</label>
                        <input type="text" name="no_control" id="no_control" size="15" />   
                        <button type="submit">Asistió</button>
                    </form:form>
                </center>
            </div>
            <div style="clear:both;"></div>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
