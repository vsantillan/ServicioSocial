<%-- 
    Document   : administrarProyectos
    Created on : 4/06/2013, 02:17:29 PM
    Author     : roy
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-edit"></span>&nbsp; Administrar Proyectos</h1></div>
                    <div class="alert alert-warning col-md-9  col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran los proyectos activos.</h4></div>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'>
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Ver proyecto</th>
                                <th>Ver Alumnos en Proyecto</th>
                                <th>Organizaci&oacute;n</th>
                                <th>Nombre del proyecto</th>
                                <th>Titular</th>
                                <th>Numero de vacantes</th>           
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${proyectos}" var="current">
                                <tr class='gradeX' id="${current.idProyecto}">
                                    <td><a href="editarProyecto.do?id=${current.idProyecto}" ><span class="glyphicon glyphicon-edit sizeIcon" title="Editar Proyecto"></span></a>&nbsp;&nbsp;
                                        <a href="#" class="btn-validar-proyecto"><span class=" cambiaStatusProyecto glyphicon glyphicon-remove sizeIcon" ide="${current.idProyecto}" title="Borrar Proyecto"></span></a></td>
                                    <td><a href="detalleProyecto.do?id=${current.idProyecto}" class="fancy"><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>
                                    <td><a href="verAlumnosProyecto.do?id=${current.idProyecto}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>
                                    <td><core:out value="${current.idInstancia.nombre}" /></td>
                                    <td><core:out value="${current.nombre}" /></td>
                                    <td><core:out value="${current.idInstancia.titular}" /></td>
                                    <td><core:out value="${current.vacantes}" /></td>
                                </tr>
                            </core:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>

        <div class="modal-dialog" id="motivos" style="display: none;">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title titulos-naranja">Motivos de Rechazo del Proyecto</h3>
                </div>
                <form id="observacionesCat" action="#"  onsubmit="return  false;">
                    <div class="modal-body">
                        <div class="list-group">
                            <core:forEach items="${listadoObservaciones}" var="observacion">
                                <a href="#" class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input name="id[]" value="${observacion.id}" type="checkbox"/>
                                            <h4 class="list-group-item-heading">${observacion.detalle}</h4>
                                        </label>
                                    </div>
                                </a>
                            </core:forEach>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" onClick="$.fancybox.close();">Cancelar</button>
                        <a href="catalogoObservaciones.do" onclick="redirecciona('catalogoObservaciones.do');" class="btn btn-danger" role="button">Agregar Observación</a>
                        <button id="guardarObservacionesProyecto" type="button" class="btn btn-primary">Eliminar y guardar las observaciones del Proyecto</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" src="js/actualizaOrganizaciones.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
