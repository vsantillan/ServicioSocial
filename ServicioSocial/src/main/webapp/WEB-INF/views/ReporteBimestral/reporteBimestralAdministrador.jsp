<%-- 
    Document   : reporteBimestralAdministrador
    Created on : 5/06/2013, 02:15:04 PM
    Author     : roy
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%> 
        <title>Administrar Reportes Bimestrales</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Administraci&oacute;n de Reportes Bimestrales</h1></div>
                    <div class="tab-content">
                        <ul class="nav nav-tabs" id="formatoUnico-tabla">
                            <li class="active"><a href="#noRevisados" data-toggle="tab">No Revisados</a></li>
                            <li><a href="#enCorreccion" data-toggle="tab">En Correcci&oacute;n</a></li>
                            <li><a href="#Rechazados" data-toggle="tab">Rechazados</a></li>
                            <li><a href="#Revisados" data-toggle="tab">Revisados</a></li>
                        </ul>
                        &nbsp;
                        <div class="tab-content">
                            <div id="Revisados" class="tab-pane col-md-12">
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Rev" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Acci&oacute;n</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas Acumuladas</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesRevisados}" var="reporte">
                                            <tr class='gradeX'>
                                                <th>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==1 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon" target="_blank"></span></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </th>
                                                <th><core:out value="${reporte.datosPersonalesId.nombre}"/> <core:out value="${reporte.datosPersonalesId.apellidoP}"/> <core:out value="${reporte.datosPersonalesId.apellidoM}"/></th>
                                                <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>                                                       
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                <th><core:out value="${fu.periodoInicio}"/></th>
                                                                <th><core:out value="${fu.horasAcumuladas}"/></th>
                                                                </core:forEach>
                                                            </core:when>
                                                        </core:choose>
                                                    </core:forEach>
                                            </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div id="noRevisados" class="tab-pane active col-md-12">
                                <div id="div-aceptar-reporte" style="display:none;">
                                    <center>
                                        <span class="glyphicon glyphicon-ok-circle sizeIconValid"><span/>
                                            <h2>Reporte validado correctamente</h2>
                                    </center>
                                </div>
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="NoRev" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Acci&oacute;n</th>
                                            <th>Ver detalle</th>
                                            <th>Nombre</td>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesNoRevisados}" var="reporte">
                                            <tr class='gradeX'>
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==4 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="#" ><span class="glyphicon glyphicon-ok  sizeIcon aceptarReporte" ide="${reporte.id}" status="${1}" idDoc="${documentos.id}"> </span></a>
                                                                            <a href="#" class="correccion" idDP="${reporte.datosPersonalesId.id}"  status="${3}" idReporte="${reporte.id}" idDoc="${documentos.id}"><span class="glyphicon glyphicon-edit sizeIcon"></span></a>
                                                                            <a href="#" class="correccion" idDP="${reporte.datosPersonalesId.id}"  status="${2}" idReporte="${reporte.id}" idDoc="${documentos.id}"><span class="glyphicon glyphicon-remove sizeIcon"></span></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </td>
        <!--                                                <th><a href="detalleReporteBimestral.do?id=${reporte.id}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>-->
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==4 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU" target="_blank"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </td>
                                                <td><core:out value="${reporte.datosPersonalesId.nombre}"/> <core:out value="${reporte.datosPersonalesId.apellidoP}"/> <core:out value="${reporte.datosPersonalesId.apellidoM}"/></td>
                                                <td><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></td>
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                    <core:out value="${fu.periodoInicio}"/>
                                                                </core:forEach>
                                                            </core:when>
                                                        </core:choose>
                                                    </core:forEach>
                                                </td>
                                                <td><core:out value="${reporte.horas}"/></td>
                                            </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div> 
                            <div id="enCorreccion" class="tab-pane col-md-12">
                                <table ccellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Correccion" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Documento</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas del Reporte</th>
                                            <th>Ver Observaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesEnCorreccion}" var="reporte">
                                            <tr class='gradeX'>
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==3 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </td>
                                                <td><core:out value="${reporte.datosPersonalesId.nombre}"/></td>
                                                <td><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></td>
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                    <core:out value="${fu.periodoInicio}"/>
                                                                </core:forEach>
                                                            </core:when>
                                                        </core:choose>
                                                    </core:forEach>
                                                </td>
                                                <td><core:out value="${reporte.horas}"/></td>
                                                <td><a data-toggle="modal" href="#modalObservaciones" class="pideObservaciones" datosPersonales="${reporte.datosPersonalesId.id}"><span class="glyphicon glyphicon-search"></span></a></td>
                                            </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div id="Rechazados" class="tab-pane col-md-12">
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Recha" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Documento</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas del Reporte</th>
                                            <th>Ver Observaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesRechazados}" var="reporte">
                                            <tr class='gradeX'>
                                                <!--<th><a href="mostarPDF.do?id=${2}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                                    <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>-->                                                
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==2 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><span class="glyphicon glyphicon-search"></span></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </td>
                                                <td><core:out value="${reporte.datosPersonalesId.nombre}"/></td>
                                                <td><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></td>
                                                <td>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                    <core:out value="${fu.periodoInicio}"/>
                                                                </core:forEach>
                                                            </core:when>
                                                        </core:choose>
                                                    </core:forEach>
                                                </td>
                                                <td><core:out value="${reporte.horas}"/></td>
                                                <td><a data-toggle="modal" href="#modalObservaciones" class="pideObservaciones" datosPersonales="${reporte.datosPersonalesId.id}"><span class="glyphicon glyphicon-search"></span></a></td>
                                            </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>

        <div class="modal-dialog" id="motivos" style="display: none;">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title titulos-naranja">Motivos de Rechazo del Reporte Bimestral</h3>
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
                        <button id="guardarObservaciones" type="button" class="btn btn-primary">Guardar las observaciones de el Formato Bimestral</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->


        <!-- Modal -->
        <div class="modal fade" id="modalObservaciones">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Observaciones del Reporte</h4>
                    </div>
                    <div  id="contenidoObservaciones" class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" language="javascript" src="js/reporteBimestalActualiza.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
