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
                                    <td><a id="enviarcorreo1" href="#"  title="Enviar correo"><span class="glyphicon glyphicon-envelope sizeIcon"></span>&nbsp;&nbsp;&nbsp;</a></td>
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

                                    <td><a href="correo.do" title="Enviar Correo" ><span class="glyphicon glyphicon-envelope sizeIcon"></span>&nbsp;&nbsp;&nbsp;</a></td>
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
                <%@include file="../General/footer.jsp"%>    
                
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
        <%@include file="../Template/headsModal.jsp" %>
        <script type="text/javascript" language="javascript" src="js/becados.js"></script>
    </body>
</html>