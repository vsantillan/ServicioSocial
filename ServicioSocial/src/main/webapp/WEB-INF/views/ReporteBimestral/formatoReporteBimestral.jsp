<%-- 
    Document   : formatoReporteBimestral
    Created on : 5/06/2013, 02:14:42 PM
    Author     : roy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/sinJavascript.jsp" %>
        <%@include file="../General/head.jsp"%>
        <title>Reportes Bimestrales</title>
    </head>
    <body>
        <div class="container">
            ${alertCorrecto}
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuUsuario.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp; Reportes Bimestrales</h1></div>
                    <p>&nbsp;</p>
                    <div class="tabbable">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#Guardar" onclick="ocultaDiv();">Guardar Informaci&oacute;n del Reporte</a></li>
                            <li><a data-toggle="tab" href="#Generar" onclick="ocultaDiv();">Generar Reportes</a></li>
                            <li><a data-toggle="tab" href="#Subir" onclick="ocultaDiv();">Anexar Reporte</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="Guardar" class="tab-pane active col-md-12">
                                <p>&nbsp;</p>
                                <div class="panel panel-info">
                                    <div class="panel-heading">Guardar Informaci&oacute;n del Reporte</div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="alert alert-warning col-md-9 col-md-offset-1">
                                                <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;Introduzca el n&uacute;mero de horas del reporte y la calificaci&oacute;n en caso de ser requerida.<br>
                                                        Una vez que que guarde la informaci&oacute;n de su reporte pase a la pestaña de Generar Reportes.</h4></div>
                                            </div>
                                        </div>
                                        <div class="col-md-10 col-md-offset-2">
                                            <form:form commandName="Reportes" name="reportesBimestrales" id="reportesBimestrales"  action="insertaReporte.do" method="POST">
                                                <div class="row">
                                                    <div class="text-info col-md-6" ><h4>&nbsp;N&uacute;mero de Revisiones del Reporte: ${noReviciones}</h4></div>
                                                </div>
                                                <p>&nbsp;</p>
                                                <div class="row">
                                                    <div class="form-group col-md-2">
                                                        <label for="noReporte">No de Reporte:</label>
                                                        <form:input path="numeroReporte" type="text" name=" numeroReporte" id=" numeroReporte"  value="${numeroReporte}" readonly="true" class="form-control" />
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group col-md-4">
                                                        <label for="fecha">Fecha de Inicio del Reporte:</label>
                                                        <core:choose>
                                                            <core:when test="${empty fechaInicio}">
                                                                <form:input path="fechaInicio" type="text"  name="fechaInicio" readonly="true"  onchange="actualizaFecha(this)" class="form-control" />
                                                                <form:errors path="fechaInicio" class="alert alert-danger"/>                              
                                                            </core:when>
                                                            <core:otherwise>
                                                                <form:input path="fechaInicio" type="text"  name="fechaInicio" readonly="true"  onchange="actualizaFecha(this)" class="form-control" />
                                                                <form:errors path="fechaInicio" class="alert alert-danger"/> 

                                                            </core:otherwise>
                                                        </core:choose>  
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label for="fecha">Fecha Limite del  Reporte:</label>
                                                        <form:input path="fechaFin" type="text" name="fechaFin" id="fechaFin" readonly="true" class="form-control"  />
                                                        <form:errors path="fechaFin" class="alert alert-danger"/> 

                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="form-group col-md-4">
                                                        <label for="horasA">Horas del Reporte:</label>                              
                                                        <form:input path="horas" type="text" name="horasReporte" class="form-control" />
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label for="horasAcumuluadas">Horas Acumuladas:</label></td>
                                                        <form:input path="horasAcumuladas" type="text" name="horasAcumuladas" id="horasAcumuladas" readonly="true" value="${horasAcumuladas}" class="form-control"  />  
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row col-md-6">
                                                    <core:choose>
                                                        <core:when test="${errorHoras==''}" >
                                                            <form:errors path="horas" class="alert alert-danger"/>
                                                        </core:when>
                                                        <core:otherwise>
                                                            ${errorHoras}
                                                        </core:otherwise>
                                                    </core:choose>
                                                    <div class="row">&nbsp;</div>
                                                </div>
                                                <div class="row col-md-12">
                                                    <div class="form-group col-md-10">
                                                        <label for="actividad">Actividades:</label>
                                                        <fieldset>
                                                            <select name="selectfrom" id="select-from" multiple size="5" class="form-control" >
                                                                <core:forEach items="${datosPersonales}" var="current">
                                                                    <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                                                        <core:forEach items="${formato.idproyecto.actividadesCollection}" var="actividades" >
                                                                            <option value="${actividades.idActividad}">${actividades.detalle}</option>
                                                                        </core:forEach>
                                                                    </core:forEach>
                                                                </core:forEach>
                                                            </select>
                                                    </div>
                                                    <div class="alert alert-warning col-md-10 ">
                                                        <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;En este cuadro aparecen las actividades que se mostraran en su reporte.Seleccione la actividad y pulse quitar para eliminarla de su reporte.</h5></div>
                                                    </div>
                                                    <div class="row col-md-10">
                                                        <a href="JavaScript:void(0);" id="btn-add" class="btn btn-primary">&laquo; Quitar</a>
                                                        <a href="JavaScript:void(0);" id="btn-remove" class="btn btn-primary">Agregar &raquo;</a>
                                                    </div>
                                                    <div class="form-group col-md-10"> 
                                                        <label>&nbsp;</label>
                                                        <select name="selectto" id="select-to" multiple size="5" class="form-control"></select>
                                                    </div>
                                                    <div class="alert alert-warning col-md-10 ">
                                                        <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;En este cuadro aparecen las actividades que NO se mostraran en su reporte.Seleccione la actividad y pulse agregar para anexarla a su reporte.Recuerde que minimo son 3 actividades por reporte</h5></div>
                                                    </div>
                                                    </fieldset>

                                                    <div class="row col-md-6">
                                                        ${errorActividades}
                                                    </div>
                                                </div>
                                                <core:forEach items="${datosPersonales}" var="current">
                                                    <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                                        <core:choose>
                                                            <core:when test="${formato.catalogoPlanId.detalle=='S'}" >
                                                                <div class="form-group col-md-6">
                                                                    <label for="calificacion">Calificaci&oacute;n</label>
                                                                    <form:input path="calificacion" type="text" name="actividad" class="form-control"/>
                                                                </div>                                                                
                                                                <div class="form-group col-md-7">
                                                                    <div>&nbsp;</div>
                                                                    <label for="calificacion">&nbsp;</label>                                                                    
                                                                    <core:choose>
                                                                        <core:when test="${errorCalificacion==''}" >
                                                                            <form:errors path="calificacion" class="alert alert-danger"/>
                                                                        </core:when>
                                                                        <core:otherwise>
                                                                            ${errorCalificacion}
                                                                        </core:otherwise>
                                                                    </core:choose>
                                                                    <br>
                                                                </div> 
                                                            </core:when> 
                                                            <core:otherwise>
                                                                <div class="row">
                                                                    <div class="form-group col-md-3">
                                                                        <form:hidden path="calificacion" name="actividad" value="0" class="form-control"  />                                         
                                                                    </div>
                                                                </div>
                                                            </core:otherwise>
                                                        </core:choose>
                                                    </core:forEach>
                                                </core:forEach>  
                                                <form:input path="actividades" hidden="hidden" name="nActividades" id="nActividades" value="0" />
                                                <div class="form-group col-md-9 col-md-offset-3"> 
                                                    <input type ="submit" value = "Guardar Informaci&oacute;n" id="envia" class="btn btn-primary" />
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>                              
                            </div>
                            <div id="Generar" class="tab-pane col-md-12">
                                <p>&nbsp;</p>
                                <div class="panel panel-info">
                                    <div class="panel-heading">Generar Reporte Bimestral</div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="alert alert-warning col-md-9 col-md-offset-1">
                                                <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;En esta secci&oacute;n podra generar su reporte para poderlo imprimir, y posteriormente llevarlo a sellar por su instancia.</h4></div>
                                            </div>
                                        </div>
                                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'>
                                            <thead>
                                                <tr>
                                                    <th>N&uacute;mero de Reporte</th>
                                                    <th>Horas del Reporte</th>
                                                    <th>Fecha de Entrega M&aacute;xima</th>
                                                    <th>N&uacute;mero de Revisiones</th>
                                                    <th>Estatus del reporte</th>
                                                    <th>Calificaci&oacute;n</th>
                                                    <th>Ver Reporte</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <core:forEach items="${listaReportes}" var="reportes">
                                                    <tr class='gradeX'>
                                                        <th><core:out value="${reportes.numeroReporte}"/></th>
                                                        <th><core:out value="${reportes.horas}"/></th>
                                                        <th><fmt:formatDate value="${reportes.fechaEntregaMax}" pattern="dd-MM-yyyy"></fmt:formatDate></th>
                                                        <th><core:out value="${reportes.numeroRevisiones}"/></th>
                                                            <core:choose>    
                                                                <core:when test="${reportes.status==0}">
                                                                <th>No has subido tu reporte</th>
                                                                </core:when>
                                                                <core:when test="${reportes.status==1}">
                                                                <th>Aceptado</th>
                                                                </core:when>
                                                                <core:when test="${reportes.status==2}">
                                                                <th>Rechazado</th>
                                                                </core:when>
                                                                <core:when test="${reportes.status==3}">
                                                                <th>En correci&oacute;n</th>
                                                                </core:when>
                                                                <core:when test="${reportes.status==4}">
                                                                <th>En revisi&oacute;n</th>
                                                                </core:when>
                                                            </core:choose>
                                                            <core:forEach items="${datosPersonales}" var="current">
                                                                <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                                                    <core:choose>
                                                                        <core:when test="${formato.catalogoPlanId.detalle=='S'}" >
                                                                        <th>${reportes.calificacion}</th>
                                                                        </core:when> 
                                                                        <core:otherwise>
                                                                        <th>No requerida</th>
                                                                        </core:otherwise>
                                                                    </core:choose>
                                                                </core:forEach>
                                                            </core:forEach>
                                                        <th><a href="muestraReporteBimestral.pdf?idReporte=${reportes.id}&noReporte=${reportes.numeroReporte}" target="_blank"><span class="glyphicon glyphicon-search sizeIcon"></span></a></th>
                                                    </tr>
                                                </core:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>                             
                            </div>
                            <div id="Subir" class="tab-pane col-md-12">
                                <p>&nbsp;</p>
                                <div class="panel panel-info">
                                    <div class="panel-heading">Subir Reporte Bimestral</div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="alert alert-warning col-md-9  col-md-offset-q">
                                                <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;En esta secci&oacute;n usted podra anexar su reporte para que sea revisado por el administrador, recuerde subir un archivo con extensi&oacute;n permitida (.jpg,.png,.pdf,.jpeg).</h4></div>
                                            </div>
                                        </div>
                                        <form:form name="subirReporte" id="subirArchivo" action="guardarReporteBimestral.do" method="POST" enctype="multipart/form-data">
                                            <div class='form-group'><label>Seleccione su Reporte Bimestral</label><br><input type='file'id="archivo" name ='file' class='btn btn-primary' title='Buscar Reporte'></input></div>
                                            <div class='form-group'><label>&nbsp;</label><input type='button' id="enviarArchivo" value='Subir' class='btn btn-primary' /></div>
                                            <div class='error alert alert-danger col-md-4' style=display:none;></div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" language="javascript" src="js/reportesBimestrales.js"></script>
        <script type="text/javascript" language="javascript" src="js/validaFiles.js"></script>
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

                                $('input#envia').click(function() {
                                    $('#select-from option').each(function()
                                    {
                                        $(this).attr("selected", "selected");
                                    });
                                });



        </script>
        <script src="js/bootstrap.fileInput.js"></script> 
        <script>
                                $(document).ready(function() {
                                    $('input[type=file]').bootstrapFileInput();
                                });
        </script>
    </body>
</html>
<!--Id 1 Id2 ---!>