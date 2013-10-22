<%-- 
    Document   : historialServicio
    Created on : 16-oct-2013, 11:16:30
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />


        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <title>Administrador</title>

    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width:80%;">

                <h1>Historial del Servicio Social</h1>
                <h4>A continuaci&oacute;n se muestran todos los alumnos que mantienen un registro en el sistema de servicio social.</h4>
                <div id="tabs">

                    <ul>
                        <li><a href="#activo">Servicio Activo</a></li>
                        <li><a href="#bajaTemporal">Baja Temporal</a></li>
                        <li><a href="#rechazados">Cancelado</a></li>
                        <li><a href="#terminado">Servicio Terminado</a></li>
                    </ul>
                    <div id="activo">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noRevisadosDT" width='100%'>
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
                                        <core:when test="${alumno.statusServicio ==1}">
                                            <tr class='gradeX'>
                                                <td>
                                                    <a href="editarAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" ><img src="imagenes/editar.png" width="20" title="Editar Proyecto"/></a>
                                                    <a href="verProcesoAlumno.do?id=${alumno.datosPersonales.alumnoId.id}" class="fancyFU" title="Ver Proceso" alt="Ver Proceso"><img src="imagenes/lupa.png" width="20" title="Ver Proceso" alt="Ver Proceso"/></a>
                                                    <a href="verInfo.do?id=${alumno.datosPersonales.alumnoId.id}" class="fancyFU" title="Ver Informacion" alt="Ver Informacion"><img src="imagenes/lupa.png" width="20" title="Ver Informacion" alt="Ver Informacion"/></a>
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
                    <div id="bajaTemporal">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noAceptadosDT" width='100%'>
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
                    <div id="rechazados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="enCorreccionDT" width='100%'>
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
                    <div id="terminado">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="aceptadosDT" width='100%'>
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

            </div>
            <h4>*No se muestran los asistentes a las pl&aacute;ticas de inducci&oacute;n, solo los que ya comenzaron su proces de servicio social.</h4>


            <div style="clear:both;"></div>

        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />


        <div id="motivos" style="display: none; ">
            <form id="observacionesCat" action="#"  onsubmit="return  false;">
                <div style="height: 350px; overflow: scroll" >
                    <h1>Motivos de Rechazo</h1>
                    <table>
                        <core:forEach items="${listadoObservaciones}" var="observacion">
                            <tr>
                                <td style="width: 450px;font-size: 20px"><label><input name="id[]" value="${observacion.id}" type="checkbox"/>&nbsp;&nbsp;&nbsp;
                                        <core:out value="${observacion.detalle}" /></label>
                                </td>
                            </tr> 
                        </core:forEach>
                    </table>
                </div>
                <div>
                    <button id="guardarObservaciones">Guardar</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="redirecciona('catalogoObservaciones.do')"   style="font-size: 20px"> Agregar Observación</a>
                </div>
            </form>  

        </div>

        <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
    </body>
</html>


