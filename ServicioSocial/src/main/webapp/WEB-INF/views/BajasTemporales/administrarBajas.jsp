<%-- 
    Document   : administrarBajas
    Created on : 12/06/2013, 09:47:42 AM
    Author     : roy
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Bajas Temporales</title>
        <style>.datepicker{z-index:1151;}</style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Bajas Temporales</h1></div>
                    <div class="tab-content">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#AsignarBaja" data-toggle="tab">Asignar Bajas</a></li>
                            <li><a href="#QuitarBaja" data-toggle="tab">Quitar Bajas</a></li>
                        </ul>
                        &nbsp;
                        <div class="tab-content">
                            <div id="AsignarBaja" class="tab-pane active col-md-12">
                                <div class="alert alert-warning col-md-10 ">
                                    <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;En esta secci&oacute;n usted podra asginar bajas temporales.</h5></div>
                                </div>
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Acci&oacute;n</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${alumnos}" var="current">
                                            <tr class='gradeX'>
                                                <td><a href="#bajaTemp"  data-toggle="modal" class="generarBaja" idP="${current.datosPersonalesId.alumnoId.id}" ><span class="glyphicon glyphicon-circle-arrow-down sizeIcon"></span></a></td>
                                                <td>${current.datosPersonalesId.nombre} ${current.datosPersonalesId.apellidoP}  ${current.datosPersonalesId.apellidoM}</td>
                                                <td>${current.datosPersonalesId.alumnoId.id}</td>
                                                <td>${current.periodoInicio}</td>
                                            </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>

                            </div>
                            <div id="QuitarBaja" class="tab-pane col-md-12">
                                <div class="alert alert-warning col-md-10 ">
                                    <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;En esta secci&oacute;n usted podra retirar las bajas temporales asigandas.</h5></div>
                                </div>
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Acci&oacute;n</th>
                                            <th>Nombre</th>
                                            <th>Fecha de Inicio de la Baja Temporal</th>
                                            <th>Fecha M&aacute;xima de Baja Temporal</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${alumnosBaja}" var="current">
                                            <tr class='gradeX'>
                                                <td><a href="#" class="quitaBaja" idPer="${current.datosPersonales.numeroControl}" ><span class="glyphicon glyphicon-circle-arrow-up sizeIcon"></span></a></td>
                                                <td>${current.datosPersonales.nombre} ${current.datosPersonales.apellidoP}  ${current.datosPersonales.apellidoM}</td>
                                                <td><fmt:formatDate value="${current.fechaBaja}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
                                                <td><fmt:formatDate value="${current.fechaLimiteBaja}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
                                                <td>${current.datosPersonales.alumnoId.id}</td>
                                                <td>${current.periodo}</td>
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
            <!-- Modal fechas baja temporal -->
            <div id="bajaTemp" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Bajas Temporales</h4>
                        </div>
                        <div class="modal-body">
                            <div class="panel panel-info">
                                <div class="panel-heading">Establecer Baja Temporal</div>
                                <div class="panel-body">
                                    <form action="#" onsubmit="return validarForm(this);" >
                                        <div class="form-group">
                                            <label for="fecha">*Fecha de Baja Temporal:</label>
                                            <div  class="input-group date dpAltaBaja" data-date="" data-date-format="yyyy-mm-dd">
                                                <input id="fechaBaja" name="fechaBaja" class="form-control" readonly="true" />
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar" id="dp2"></i></span>
                                                    <form:errors class="alert alert-danger" path="fechaBaja" />
                                            </div><br>
                                        </div>
                                        <div class="form-group">
                                            <label>*Fecha Limite de Baja:</label>
                                            <div  class="input-group date dpFinBaja" data-date="" data-date-format="yyyy-mm-dd">
                                                <input id="fechaLimiteBaja" name="fechaLimiteBaja" path="fechaLimiteBaja" readonly="true" class="form-control" />
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar" id="dp2"></i></span>
                                                    <form:errors class="alert alert-danger" path="fechaLimiteBaja" />
                                            </div><br>
                                        </div>
                                        <div class="row">
                                            <div class='error alert alert-danger col-md-7 col-md-offset-2' id="erroresFechas" style="display:none;"></div>
                                        </div>
                                        <div class="row col-md-offset-4"> 
                                            <input type="submit" value="Asignar Baja" class="btn btn-primary guardarBaja" /> 
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <%@include file="../General/js.jsp"%>
            <script type="text/javascript" language="javascript" src="js/bajaTemporal.js"></script>
    </body>
</html>

