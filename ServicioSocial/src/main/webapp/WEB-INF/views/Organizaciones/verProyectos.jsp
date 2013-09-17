<%-- 
    Document   : verProyectos
    Created on : 16-ago-2013, 10:54:11
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
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "120%",
                    "bScrollCollapse": true

                });

            });
        </script>   

        <title>Ver Proyectos</title>

    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <jsp:include page="../PanelOrganizacion/menuPanelOrganizacion.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">
            <center>
                <h1>Administrar Proyectos</h1>
                <p>A continuaci&oacute;n se muestran los proyectos activos.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Ver proyecto</th>
                            <th>Alumnos en Proyecto</th>
                            <th>Nombre del proyecto</th>
                            <th>Numero de vacantes</th> 
                            <th>Responsable del Programa</th> 
                            <th>Puesto del Responsable</th>  
                            <th>Estatus</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${proyectos}" var="current">
                            <tr class='gradeX' id="${current.idProyecto}">
                                <th><a href="editarProyecto.do?id=${current.idProyecto}" ><img src="imagenes/editar.png" width="30" title="Editar Proyecto"/></a><a href="#" ><img  ide="${current.idProyecto}" src="imagenes/trash.png" width="30" title="Borrar Proyecto"></a></th>
                                <th><a href="detalleProyecto.do?id=${current.idProyecto}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>
                                <th><a href="verAlumnosProyecto.do?id=${current.idProyecto}" class="fancyFU"><img src="imagenes/lupa.png" width="30"/></a></th>
                                <th><core:out value="${current.nombre}" /></th>
                                <th><core:out value="${current.vacantes}" /></th>
                                <th><core:out value="${current.nombreResponsable}" /></th>
                                <th><core:out value="${current.responsablePuesto}" /></th>                                
                                <th>
                                    <core:choose>
                                        <core:when test="${current.validacionAdmin == 0}">
                                            No Validado
                                        </core:when>
                                        <core:when test="${current.validacionAdmin == 1}">
                                            Validado
                                        </core:when>
                                        <core:when test="${current.validacionAdmin == 2}">
                                            Rechazado
                                        </core:when>
                                    </core:choose>
                                </th>
                            </tr>
                        </core:forEach>
                    </tbody>
                </table>
            </center>
            <br/><br/><br/>
        </div>
        <%-- fin del contenido --%>

        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>

