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
                    <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-list"></span>&nbsp; Historial Servicio</h2></div>
                    <div class="alert alert-warning col-md-10 col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran todos los alumnos que mantienen un registro en el sistema de servicio social..</h4></div>
                    </div>
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
                                                    <td><a href="verProcesoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" target="_blank  title="Ver Proceso" alt="Ver Proceso"><i class="glyphicon glyphicon-eye-open"></i></a></td>
                                                    <td><a href="verInfoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" target="_blank" title="Ver Informacion del Alumno" alt="Ver Informacion del Alumno"><i class="glyphicon glyphicon-search"></i></a></td>
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
                                        <th>Ver Información</th>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Fecha de Inicio de la Baja Temporal</th>
                                        <th>Fecha Máxima de Baja Temporal</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${alumnos}" var="alumno">  
                                        <core:choose> 
                                            <core:when test="${alumno.statusServicio ==3}">
                                                <tr class="gradeX">
                                                    <td><a href="verInfoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" target="_blank" title="Ver Informacion del Alumno" alt="Ver Informacion del Alumno"><span class="glyphicon glyphicon-search"></span></a></td>
                                                    <td>${alumno.formatoUnico.periodoInicio}</td>
                                                    <td>${alumno.datosPersonales.alumnoId.id}</td>
                                                    <td>${alumno.datosPersonales.nombre} ${alumno.datosPersonales.apellidoP} ${alumno.datosPersonales.apellidoM}</td>
                                                    <td>${alumno.formatoUnico.horasAcumuladas}</td>
                                                    <core:forEach items="${bajasTemporales}" var="bajaActual">
                                                        <core:if test="${alumno.datosPersonales.id==bajaActual.datosPersonalesId.id}">
                                                            <td><fmt:formatDate value="${bajaActual.fechaBaja}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
                                                            <td><fmt:formatDate value="${bajaActual.fechaLimiteBaja}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
                                                        </core:if>                                                   
                                                    </core:forEach>
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
                                        <th>Ver Información</th>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Fecha Inicio del Servicio</th> 
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${alumnos}" var="alumno">  
                                        <core:choose> 
                                            <core:when test="${alumno.statusServicio ==2}">
                                                <tr class='gradeX'>
                                                    <td><a href="verInfoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" target="_blank title="Ver Informacion del Alumno" alt="Ver Informacion del Alumno"><span class="glyphicon glyphicon-search"></span></a></td>
                                                    <td>${alumno.formatoUnico.periodoInicio}</td>
                                                    <td>${alumno.datosPersonales.alumnoId.id}</td>
                                                    <td>${alumno.datosPersonales.nombre} ${alumno.datosPersonales.apellidoP} ${alumno.datosPersonales.apellidoM}</td>
                                                    <td>${alumno.formatoUnico.horasAcumuladas}</td>
                                                    <td>${alumno.formatoUnico.fechaInicio}</td>
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
                                        <th>Ver Información</th>
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
                                                    <td><a href="verInfoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" target="_blank title="Ver Informacion del Alumno" alt="Ver Informacion del Alumno"><span class="glyphicon glyphicon-search"></span></a></td>
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
