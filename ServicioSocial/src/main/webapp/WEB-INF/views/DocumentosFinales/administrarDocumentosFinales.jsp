<%-- 
    Document   : administrarDocumentosOriginales
    Created on : 12/06/2013, 09:44:29 AM
    Author     : Regules
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Administraci&oacute;n Documentos Finales</h1></div>
                    <div class="alert alert-warning col-md-9 col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestra una vista de los documentos originales de cada alumno.</h4></div>
                    </div>
                    <div id="div-validar-organizacion" style="display:none;">
                        <center>
                            <span class="glyphicon glyphicon-ok-circle sizeIconValid"></span>
                            <h2>Reporte validada correctamente</h2>
                        </center>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="example" width='100%'>
                        <thead>
                            <tr>
                                <th>No. Control</th>
                                <th>Nombre</th>
                                <th>Formato &Uacute;nico</th>
                                <th>Reporte Final</th>
                                <th>Constancia de Pago</th>
                                <th>Reporte de Evaluaci&oacute;n</th>
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${documentosAlumno}" var="alumno">
                                <tr class='gradeX'>
                                    <td><core:out value="${alumno.noControl}" /></td>
                                    <td><core:out value="${alumno.nombreCompleto}" /></td>
                                    <td>
                                        <core:choose>
                                            <core:when test="${alumno.statusFUF==4}">
                                                <a href="mostarPDF.do?id=${alumno.idFormatoUnicoFinal}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                <a href="#"><span class="aceptarDocumentos glyphicon glyphicon-ok sizeIcon" ide="${alumno.idFormatoUnicoFinal}" status="${1}"></span></a>
                                                <a href="#" class="mandaRetro"><span class="glyphicon glyphicon-remove sizeIcon" ide="${alumno.idFormatoUnicoFinal}" no_control="${alumno.noControl}"></span></a>
                                                </core:when>
                                                <core:when test="${alumno.statusFUF==1}">
                                                <a href="mostarPDF.do?id=${alumno.idFormatoUnicoFinal}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                </core:when>
                                                <core:when test="${alumno.statusFUF==2}">
                                                    <core:out value="Se encuentra en corrección por parte del alumno"/>
                                                </core:when>
                                                <core:otherwise>
                                                    <core:out value="Sin documento"/>
                                                </core:otherwise>
                                            </core:choose>
                                    </td>
                                    <td>
                                        <core:choose>
                                            <core:when test="${alumno.statusRF==4}">
                                                <a href="mostarPDF.do?id=${alumno.idReporteFinal}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                <a href="#"><span class="aceptarDocumentos glyphicon glyphicon-ok sizeIcon" ide="${alumno.idReporteFinal}" status="${1}" ></span></a>
                                                <a href="#" class="mandaRetro"><span class="glyphicon glyphicon-remove sizeIcon" ide="${alumno.idReporteFinal}" no_control="${alumno.noControl}"></span></a>
                                                </core:when>
                                                <core:when test="${alumno.statusRF==1}">
                                                <a href="mostarPDF.do?id=${alumno.idReporteFinal}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                </core:when>
                                                <core:when test="${alumno.statusRF==2}">
                                                    <core:out value="Se encuentra en corrección por parte del alumno"/>
                                                </core:when>
                                                <core:otherwise>
                                                    <core:out value="Sin documento"/>
                                                </core:otherwise>
                                            </core:choose>
                                    </td>
                                    <td>
                                        <core:choose>
                                            <core:when test="${alumno.statusCP==4}">
                                                <a href="mostarPDF.do?id=${alumno.idConstanciaPago}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                <a href="#"><span class="aceptarDocumentos glyphicon glyphicon-ok sizeIcon" ide="${alumno.idConstanciaPago}" status="${1}"></span></a>
                                                <a href="#" class="mandaRetro"><span class="glyphicon glyphicon-remove sizeIcon" ide="${alumno.idReporteFinal}" no_control="${alumno.noControl}"></span></a>
                                                </core:when>
                                                <core:when test="${alumno.statusCP==1}">
                                                <a href="mostarPDF.do?id=${alumno.idConstanciaPago}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                </core:when>
                                                <core:when test="${alumno.statusCP==2}">
                                                    <core:out value="Se encuentra en corrección por parte del alumno"/>
                                                </core:when>
                                                <core:otherwise>
                                                    <core:out value="Sin documento"/>
                                                </core:otherwise>
                                            </core:choose>
                                    </td>
                                    <td>
                                        <core:choose>
                                            <core:when test="${alumno.idReporteCalificacion==0}">
                                                <core:out value="Alumno con Retícula 2004"/>
                                            </core:when>
                                            <core:otherwise>
                                                <core:choose>
                                                    <core:when test="${alumno.statusRC==4}">
                                                        <a href="mostarPDF.do?id=${alumno.idReporteCalificacion}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                        <a href="#"><span class="aceptarDocumentos glyphicon glyphicon-ok sizeIcon" ide="${alumno.idReporteCalificacion}" status="${1}"></span></a>
                                                        <a href="#" class="mandaRetro"><span class="glyphicon glyphicon-remove sizeIcon" ide="${alumno.idReporteFinal}" no_control="${alumno.noControl}"></span></a>
                                                        </core:when>
                                                        <core:when test="${alumno.statusRC==1}">
                                                        <a href="mostarPDF.do?id=${alumno.idReporteCalificacion}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                        </core:when>
                                                        <core:when test="${alumno.statusRC==2}">
                                                            <core:out value="Se encuentra en corrección por parte del alumno"/>
                                                        </core:when>
                                                        <core:otherwise>
                                                            <core:out value="Sin documento"/>
                                                        </core:otherwise>
                                                    </core:choose>
                                                </core:otherwise>
                                            </core:choose>
                                    </td>
                                </tr>
                            </core:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="modal-dialog" id="motivos" style="display: none;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title titulos-naranja">Motivos de Rechazo del Reporte</h3>
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
                                <a href="javascript:void(0)" onclick="redirecciona('catalogoObservaciones.do');" class="btn btn-danger" role="button">Agregar Observación</a>
                                <button id="guardarObservacionesDocumentos" type="button" class="btn btn-primary">Guardar las observaciones del Reporte</button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->


                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" language="javascript" src="js/documentosFinalesActualiza.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
