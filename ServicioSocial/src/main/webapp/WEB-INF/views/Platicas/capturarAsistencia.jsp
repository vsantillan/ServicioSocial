<%-- 
    Document   : capturarAsistencia
    Created on : 4/06/2013, 09:47:02 AM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="tags"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
    <head>
         <%@ include file="metas.jsp" %>

        <link rel="stylesheet" href="css/platicasEstiloFormularioformly.css" type="text/css" />
       

        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>

        <script>

            $(document).ready(function() {

                $('#casistencia').formly();
            });
        </script>
        <title>Capturar Asistencia a Plática</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')">
        <%@ include file="banner.jsp" %>
        <div id="contenido"    
            <center><h2>Capturar Asistencia a Plática</h2></center>  
            <center><form:form name="casistencia" id="casistencia" action="#" method="post">
                <label for="alumno">Número de control</label>
                <input type="text" name="no_control" id="no_control" size="15"require="true" />   
                <button type="submit">Asistió</button>
            </form:form>
            </center>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>