<%-- 
    Document   : administracionAlumnosBecados
    Created on : 7/06/2013, 02:29:54 PM
    Author     : Jonny
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
                <!---------------------------------------------Contenido-------------------------------------------> 
                <div class="row col-md-12 center-block">
                    <center><h1>Administraci&oacute;n de Alumnos Becados</h1></center>
                    <div class="tab-content">
                        <ul class="nav nav-tabs" id="administracionBecados-tabla">
                            <li class="active"><a href="#preseleccion" data-toggle="tab">Alumnos Preseleccionados</a></li>
                            <li><a href="#aceptados" data-toggle="tab">Alumnos Becados</a></li>
                        </ul>&nbsp;
                        <div id="preseleccion" class="tab-pane active">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;Nombre&nbsp;</th>
                                        <th>&nbsp;Carrera&nbsp;</th>
                                        <th>&nbsp;Correo Electrónico&nbsp;</th>
                                        <th>&nbsp;Telefono celular&nbsp;</th>
                                        <th>&nbsp;Telefono de Casa&nbsp;</th>
                                        <th>&nbsp;Facebook&nbsp;</th>
                                        <th>&nbsp;Twitter&nbsp;</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${preseleccionado}" var="current">
                                        <tr class='gradeX'>
                                            <td><input type="checkbox" name="checkbox" value="${current.id}"></td> 
                                            <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.correoElectronico}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.telefonoCel}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.telefonoCasa}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.facebook}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.twitter}" /></td>

                                        </tr>
                                    </core:forEach>
                                </tbody>
                            </table>
                            <table>
                                <tr>
                                    <td><a href="preseleccionAlumnos.do" title="Agregar alumno" class="fancyFUI"><span class=" glyphicon glyphicon-plus sizeIcon"></span>&nbsp;&nbsp;&nbsp;</a></td>
                                    <td><a id="quitarAlumno" href="#" title="Quitar alumno" ><span class="glyphicon glyphicon-minus sizeIcon"></span>&nbsp;&nbsp;&nbsp;</a></td>
                                    <td><a  href="#correo"  data-toggle="modal"  title="Enviar correo"><span class="glyphicon glyphicon-envelope sizeIcon"></span>&nbsp;&nbsp;&nbsp;</a></td>
                                    <td><a id="aceptarAlumno" href="#" title="Aceptar alumno" ><span class="glyphicon glyphicon-ok sizeIcon"></a>&nbsp;&nbsp;&nbsp;</td>
                                    <td><a href="dbPreseleccionados.xls"  title="Descargar Excel" target="_blank"><span class="glyphicon glyphicon-download sizeIcon "></a></td>

                                </tr>
                            </table>
                            <br> <br>
                        </div>
                        <div id="aceptados" class="tab-pane">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Aceptados" width='100%'>
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;Nombre&nbsp;</th>
                                        <th>&nbsp;Carrera&nbsp;</th>
                                        <th>&nbsp;Correo Electrónico&nbsp;</th>
                                        <th>&nbsp;Telefono celular&nbsp;</th>
                                        <th>&nbsp;Telefono de Casa&nbsp;</th>
                                        <th>&nbsp;Facebook&nbsp;</th>
                                        <th>&nbsp;Twitter&nbsp;</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${becado}" var="current">
                                        <tr class='gradeX'>
                                            <td><input type="checkbox" name="checkbox" value="${current.id}"></td>                                
                                            <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.correoElectronico}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.telefonoCel}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.telefonoCasa}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.facebook}" /></td>
                                            <td><core:out value="${current.datosPersonalesId.twitter}" /></td>

                                        </tr>
                                    </core:forEach>
                                </tbody>
                            </table>
                            <table>
                                <tr>

                                    <td><a  href="#correo"  data-toggle="modal" title="Enviar Correo" ><span class="glyphicon glyphicon-envelope sizeIcon"></span>&nbsp;&nbsp;&nbsp;</a></td>
                                    <td><a href="becados.pdf" title="Imprimir" target="_blank" ><span class="glyphicon glyphicon-print sizeIcon "></span>&nbsp;&nbsp;&nbsp;</a></td>
                                    <td><a href="becadosExcel.xls"  title="Descargar" target="_blank"><span class="glyphicon glyphicon-download sizeIcon "></span>&nbsp;&nbsp;&nbsp;</a></td>

                                </tr>
                            </table>
                            <br> <br>
                        </div>       
                    </div>

                    <%-- fin del contenido --%>


                    <!---------------------------------------------Fin Contenido-------------------------------------------> 
                </div><!--/row--> 
                <!-- Modal fechas baja temporal -->
                <div id="correo" class="modal fade" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Envio de correo</h4>
                            </div>
                            <div class="modal-body">
                                <form role="form">
                                    <div class="form-group">
                                        <label >Asunto:</label>
                                        <input id="asunto" type="email" class="form-control" id="exampleInputEmail1" placeholder="Asunto">
                                    </div>
                                    <div class="form-group">
                                        <label >Descripci&oacute;n:</label>
                                       <textarea id="descripcion" class="form-control" rows="3"></textarea>

                                    </div>
                                    <button type="button"  id="enviarcorreo1" class="btn btn-primary">Enviar</button>
                                </form>
                                <br>
                                <span id="respuesta"></span>
                            </div>
                            <div class="modal-footer">

                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <%@include file="../General/footer.jsp"%>    

            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
        <%@include file="../Template/headsModal.jsp" %>
        <script type="text/javascript" language="javascript" src="js/becados.js"></script>
    </body>
</html>