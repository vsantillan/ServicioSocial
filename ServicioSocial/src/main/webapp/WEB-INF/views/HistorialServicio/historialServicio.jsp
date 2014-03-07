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
                    <center><h2>Historial del Servicio Social</h2></center>
                    <h4>A continuaci&oacute;n se muestran todos los alumnos que mantienen un registro en el sistema de servicio social.</h4>
                    <div class="tab-content">

                        <ul class="nav nav-tabs" id="formatoUnico-tabla">
                            <li class="active"><a href="#activo"  data-toggle="tab">Servicio Activo</a></li>
                            <li><a href="#bajaTemporal"  data-toggle="tab">Baja Temporal</a></li>
                            <li><a href="#rechazados"  data-toggle="tab">Cancelado</a></li>
                            <li><a href="#terminado"  data-toggle="tab">Servicio Terminado</a></li>
                        </ul>&nbsp;
                        <div id="activo" class="tab-pane active" >
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                                <thead>
                                    <tr>
                                        <th>Ver Proceso</th>
                                        <th>Ver Info</th>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Fecha Inicio</th>
                                        <th>Fecha Fin</th>                                    
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${alumnos}" var="alumno">  
                                        <core:choose> 
                                            <core:when test="${alumno.statusServicio ==1}">
                                                <tr class='gradeX'>
                                                    <td><a href="verProcesoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" class="fancy" title="Ver Proceso" alt="Ver Proceso"><i class="glyphicon glyphicon-eye-open"></i></a></td>
                                                    <td><a href="verInfoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" class="fancy" title="Ver Informacion del Alumno" alt="Ver Informacion del Alumno"><i class="glyphicon glyphicon-search"></i></a></td>
                                                    <td>${alumno.formatoUnico.periodoInicio}</td>
                                                    <td>${alumno.datosPersonales.alumnoId.id}</td>
                                                    <td>${alumno.datosPersonales.nombre} ${alumno.datosPersonales.apellidoP} ${alumno.datosPersonales.apellidoM}</td>
                                                    <td>${alumno.formatoUnico.horasAcumuladas}</td>
                                                    <td>${alumno.formatoUnico.fechaInicio}</td>
                                                    <td>${alumno.formatoUnico.fechaFin}</td>
                                                </tr> 

                                            </core:when>
                                        </core:choose>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div id="bajaTemporal"  class="tab-pane">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
                                <thead>
                                    <tr>
                                        <th>Acci&oacute;nes</th>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Fecha Inicio</th>
                                        <th>Fecha Fin</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${alumnos}" var="alumno">  
                                        <core:choose> 
                                            <core:when test="${alumno.statusServicio ==3}">
                                                <tr class='gradeX'>
                                                    <td>
                                                        <a href="#"> Editar</a>
                                                        <a href="#"> Ver Proceso</a>
                                                        <a href="#"> Ver Info</a>
                                                    </td>

                                                    <td>${alumno.formatoUnico.periodoInicio}</td>
                                                    <td>${alumno.datosPersonales.alumnoId.id}</td>
                                                    <td>${alumno.datosPersonales.nombre} ${alumno.datosPersonales.apellidoP} ${alumno.datosPersonales.apellidoM}</td>
                                                    <td>${alumno.formatoUnico.horasAcumuladas}</td>
                                                    <td>${alumno.formatoUnico.fechaInicio}</td>
                                                    <td>${alumno.formatoUnico.fechaFin}</td>
                                                </tr> 

                                            </core:when>
                                        </core:choose>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>    
                        <div id="rechazados"  class="tab-pane">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
                                <thead>
                                    <tr>
                                        <th>Acci&oacute;nes</th>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Fecha Inicio</th>
                                        <th>Fecha Fin</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${alumnos}" var="alumno">  
                                        <core:choose> 
                                            <core:when test="${alumno.statusServicio ==2}">
                                                <tr class='gradeX'>
                                                    <td>
                                                        <a href="#"> Editar</a>
                                                        <a href="#"> Ver Proceso</a>
                                                        <a href="#"> Ver Info</a>
                                                    </td>

                                                    <td>${alumno.formatoUnico.periodoInicio}</td>
                                                    <td>${alumno.datosPersonales.alumnoId.id}</td>
                                                    <td>${alumno.datosPersonales.nombre} ${alumno.datosPersonales.apellidoP} ${alumno.datosPersonales.apellidoM}</td>
                                                    <td>${alumno.formatoUnico.horasAcumuladas}</td>
                                                    <td>${alumno.formatoUnico.fechaInicio}</td>
                                                    <td>${alumno.formatoUnico.fechaFin}</td>
                                                </tr> 

                                            </core:when>
                                        </core:choose>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>    
                        <div id="terminado"  class="tab-pane">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'  width='100%'>
                                <thead>
                                    <tr>
                                        <th>Acci&oacute;nes</th>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Fecha Inicio</th>
                                        <th>Fecha Fin</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${alumnos}" var="alumno">  
                                        <core:choose> 
                                            <core:when test="${alumno.statusServicio ==4}">
                                                <tr class='gradeX'>
                                                    <td>
                                                        <a href="#"> Editar</a>
                                                        <a href="#"> Ver Proceso</a>
                                                        <a href="#"> Ver Info</a>
                                                    </td>

                                                    <td>${alumno.formatoUnico.periodoInicio}</td>
                                                    <td>${alumno.datosPersonales.alumnoId.id}</td>
                                                    <td>${alumno.datosPersonales.nombre} ${alumno.datosPersonales.apellidoP} ${alumno.datosPersonales.apellidoM}</td>
                                                    <td>${alumno.formatoUnico.horasAcumuladas}</td>
                                                    <td>${alumno.formatoUnico.fechaInicio}</td>
                                                    <td>${alumno.formatoUnico.fechaFin}</td>
                                                </tr> 

                                            </core:when>
                                        </core:choose>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>    
                    </div>

                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
