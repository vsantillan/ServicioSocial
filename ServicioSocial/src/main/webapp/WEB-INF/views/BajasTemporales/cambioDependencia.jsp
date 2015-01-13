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
                    <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Cambio de Dependencia</h2></div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                        <thead>
                        <div class="form-group">
                            <th>Cambiar Dependencia</th>
                            <th>Nombre</th>
                            <th>Proyecto Actual</th>
                            <th>Instancia Actual</th>
                            <th>N. Control</th>
                            <th>Periodo</th>
                        </div>
                        </thead>
                        <tbody>
                            <core:forEach items="${alumnos}" var="current">
                                <tr class='gradeX'>
                                    <td><a href="#cambioDependencia"  data-toggle="modal" idP="${current.id}" class="actualizaInput" ><span class="glyphicon glyphicon-retweet sizeIcon"></span></a></td>
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
                        <h4 class="modal-title">Cambio de Instancia</h4>
                    </div>
                    <div class="modal-body">
                        <form:form commandName="cambioDependencia" id="actulizaInstancia" method="POST" action="actualizaInstancia.do">
                            <form:hidden id="idFormatoUnico" path="idFormatoUnico" value="" />
                            <div class="form-group">
                                <label>Instancias:</label>
                                <select id="nuevaInstancia" name="nuevaInstancia" class="form-control" onchange="dameProyectos();">
                                    <option value="NA">Seleccione Instancia</option>
                                    <core:forEach items="${instancias}" var="instanciaActual">
                                        <option value="${instanciaActual.idInstancia}">${instanciaActual.nombre}</option>                                  
                                    </core:forEach>                               
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Proyectos de la Dependencia:</label>
                                <select id="proyectosInstancia" name="proyectosInstancia" class="form-control">                              
                                </select>
                            </div>
                            <div class="row error alert alert-danger col-md-8 col-md-offset-2" style="display: none;"></div>
                            <br>
                            <br>
                            <div class="form-group col-md-4 col-md-offset-4">
                                <label></label>
                                <button type ="button" class="actualizaInstancia form-control btn btn-primary" >Actualizar informacion</button>
                            </div>
                        </form:form>
                    </div>
                    <br>
                    <br>
                    <br>
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
