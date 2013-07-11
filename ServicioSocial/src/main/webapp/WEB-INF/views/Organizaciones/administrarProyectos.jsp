<%-- 
    Document   : administrarProyectos
    Created on : 4/06/2013, 02:17:29 PM
    Author     : roy
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <!--Scripts para shadowbox-->
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

        <!--        Scripts para tablas-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>   


        <title>Administracion de Proyectos</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width: 80%">
                <h1>Administrar Proyectos</h1>
                <p>A continuaci&oacute;n se muestran los proyectos activos.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Ver proyecto</th>
                            <th>Organizaci&oacute;n</th>
                            <th>Nombre del proyecto</th>
                            <th>Titular</th>
                            <th>Numero de vacantes</th>           
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${proyectos}" var="current">
                            <tr class='gradeX' id="${current.idProyecto}">
                                <th><a href="editarProyecto.do?id=${current.idProyecto}" rel="shadowbox"><img src="imagenes/editar.png" width="30" title="Editar Proyecto"/></a><a href="retroalimentacionProyecto.do?id=${current.idProyecto}" rel="shadowbox"><img src="imagenes/trash.png" width="30" title="Borrar Proyecto"></a></th>
                                <th><a href="detalleProyecto.do?id=${current.idProyecto}" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
                                <th><core:out value="${current.idInstancia.nombre}" /></th>
                                <th><core:out value="${current.nombre}" /></th>
                                <th><core:out value="${current.idInstancia.titular}" /></th>
                                <th><core:out value="${current.vacantes}" /></th>
                            </tr>
                        </core:forEach>
                    </tbody>
                </table>
                <%-- fin del contenido --%>
            </div>
            <div style="clear: both;"/>
        </div>
    </div>
    <jsp:include page="../Template/footer.jsp" />
</body>


</html>
