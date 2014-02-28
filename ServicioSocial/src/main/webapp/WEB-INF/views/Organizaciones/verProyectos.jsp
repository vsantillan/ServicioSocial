<%-- 
    Document   : verProyectos
    Created on : 16-ago-2013, 10:54:11
    Author     : bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Ver Proyectos</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuOrganizacion.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class="help-block col-md-12 text-center"><h1><span class="glyphicon glyphicon-folder-close"></span>&nbsp;Administrar Proyectos</h1></div>
                    <div class="alert alert-warning col-md-6 col-md-offset-3">
                        <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran los proyectos activos..</h5></div>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
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
                                    <td><a href="editarProyecto.do?id=${current.idProyecto}" ><span class="glyphicon glyphicon-edit"></span></a><a href="#" ><span  ide="${current.idProyecto}" class="glyphicon glyphicon-trash sizeIcon" title="Borrar Proyecto"></span></a></td>
                                    <td><a href="detalleProyecto.do?id=${current.idProyecto}" class="fancy"><span class="glyphicon glyphicon-search"></span></a></td>
                                    <td><a href="verAlumnosProyecto.do?id=${current.idProyecto}" class="fancyFU"><span class="glyphicon glyphicon-search"></span></a></td>
                                    <td><core:out value="${current.nombre}" /></td>
                                    <td><core:out value="${current.vacantes}" /></td>
                                    <td><core:out value="${current.nombreResponsable}" /></td>
                                    <td><core:out value="${current.responsablePuesto}" /></td>                                
                                    <td>
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
                                    </td>
                                </tr>
                            </core:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <jsp:include page="../Template/headsModal.jsp" />

    </body>
</html>

