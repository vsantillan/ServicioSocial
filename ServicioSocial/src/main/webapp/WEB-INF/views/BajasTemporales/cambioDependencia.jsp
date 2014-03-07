<%-- 
    Document   : cambioDependencia
    Created on : 7/03/2014, 12:45:48 PM
    Author     : rodrigo
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Cambio de Dependencia</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Cambio de Dependencia</h1></div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                        <thead>
                        <div class="form-group">
                            <th>Cambiar Dependencia</th>
                            <th>Nombre</th>
                            <th>Proyecto Actual</th>
                            <th>Dependencia Actual</th>
                            <th>N. Control</th>
                            <th>Periodo</th>
                        </div>
                        </thead>
                        <tbody>
                            <core:forEach items="${alumnos}" var="current">
                                <tr class='gradeX'>
                                    <td><a href="#cambioDependencia"  data-toggle="modal" idP="${current.id}" ><span class="glyphicon glyphicon-retweet sizeIcon"></span></a></td>
                                    <td>${current.datosPersonalesId.nombre} ${current.datosPersonalesId.apellidoP}  ${current.datosPersonalesId.apellidoM}</td>
                                    <td>${current.idproyecto.nombre}</td>
                                    <td>${current.idproyecto.idInstancia.nombre}</td>
                                    <td>${current.datosPersonalesId.alumnoId.id}</td>
                                    <td>${current.periodoInicio}</td>
                                    </div>
                                </core:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
                    <!-- Modal Cambio de Dependencia-->
            <div id="cambioDependencia" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Cambio de Dependencia</h4>
                        </div>
                        <div class="modal-body">
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
