<%-- 
    Document   : verAlumnosProyecto
    Created on : 06-sep-2013, 16:21:51
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
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "bScrollCollapse": true

                });

            });
        </script>   

        <script src="js/jquery.codigos.postales.js"></script>       
        <script src="js/jquery.manolo.js"></script>

        <title>Alumnos en Proyecto</title>
    </head>
    <body class="background">
    <center>
        <h1>Alumnos en el proyecto ${proyecto}</h1>        
        <!--<a onclick="$.fancybox.close();">Redireccion</a>-->
        <div style="width:95%;">
            <p>A continuaci&oacute;n se muestran los alumnos que se encuentran en el proyecto.</p>
            <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                <thead>
                    <tr>
                        <th>No. Control</th>
                        <th>Nombre</th>
                        <th>Carrera</th>
                        <th>E-mail</th> 
                        <th>Tel&eacute;fono</th> 
                    </tr>
                </thead>
                <tbody>
                    <core:forEach items="${alumnos}" var="current">
                        <tr class='gradeX' id="${current.id}">
                            <th><core:out value="${current.datosPersonalesId.alumnoId.id}" /></th>
                            <th><core:out value="${current.datosPersonalesId.nombre} ${current.datosPersonalesId.apellidoP} ${current.datosPersonalesId.apellidoM}" /></th>
                            <th><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></th>  
                            <th><core:out value="${current.datosPersonalesId.correoElectronico}" /></th>
                            <th><core:out value="${current.datosPersonalesId.telefonoCel}" /></th>                  
                        </tr>
                    </core:forEach>
                </tbody>
            </table>
        </div>

        <br/>
    </center>
    <script>
            $('a#btn-add').click(function() {
                $('#select-from option:selected').each(function() {
                    $('#select-to').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
            $('a#btn-remove').click(function() {
                $('#select-to option:selected').each(function() {
                    $('#select-from').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
    </script>  
</body>
</html>
