<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : verProcesoAlumno
    Created on : 17-oct-2013, 10:31:52
    Author     : bustedvillain
--%>

<%-- 
    Document   : propAlInstancia
    Created on : 13-ago-2013, 8:47:17
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
         <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />
        
        <script src="js/jquery.manolo.js"></script>       
        <title>Ver Proceso del Alumno</title>
    </head>
    <body class="background">
    <center>
        <h1>Proceso del Servicio Social</h1>        
        <!--<a onclick="$.fancybox.close();">Redireccion</a>-->
        <center>
            <table>
                <thead>
                    <th>Proceso</th>
                    <th>Estatus</th>
                </thead>
                <tbody>
                    <tr>
                        <td>Servicio Social</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Pl&aacute;tica de Inducci&oacute;n</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Formato &Uacute;nico</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Reportes Bimestrales</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Documentos Finales</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Sanciones</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Observaciones</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </center>
        <br/>
    </center>
    
</body>
</html>
