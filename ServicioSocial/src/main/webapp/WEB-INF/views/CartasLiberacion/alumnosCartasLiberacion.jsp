<%-- 
    Document   : alumnosCartasLiberacion
    Created on : 7/10/2013, 10:23:20 AM
    Author     : ekt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />


        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <script type="text/javascript">
            $(document).ready(function() {
                $("#tabs").tabs();
                $('#Rev').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#NoRev').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#Correccion').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#Recha').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cartas de Liberacion</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%;">
                <div id="tabs">
                    <h1>Cartas de Liberación</h1>
                    <ul>
                        <li><a href="#Entregadas">Entregadas</a></li>
                        <li><a href="#noEntregadas">No Entregadas</a></li>
                        <li><a href="#enCorreccion">En Correcci&oacute;n</a></li>
                        <li><a href="#Rechazados">Rechazados</a></li>
                    </ul>
                    <div id="Entregadas">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Rev" width='100%'>
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
                                <core:forEach items="${reportes}" var="reporte">
                                    <tr class='gradeX'>
                                        <th><a href="detalleReporteBimestral.do?id=${reporte.id}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>
                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/></th>
                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                        <th>
                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                <core:choose>
                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                            <core:out value="${fu.periodoInicio}"/>
                                                        </core:forEach>
                                                    </core:when>
                                                </core:choose>
                                            </core:forEach>
                                        </th>
                                        <th><core:out value="${reporte.horas}"/></th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="noRevisados">
                    <div id="div-aceptar-reporte" style="display:none;">
                        <center>
                            <img src="imagenes/paloma.png" width="100"/>
                            <h2>Reporte validado correctamente</h2>
                        </center>
                    </div>
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="NoRev" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;n</th>
                                    <th>Ver detalle</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                    <th>Archivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <tr class='gradeX'>
                                        <th>
                                            <a href="#"><img class="aceptarReporte" ide="${reporte.id}" status="${1}" src="imagenes/paloma.png" width="30"/></a>
                                            <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${reporte.datosPersonalesId.nombre}" correo="${reporte.datosPersonalesId.correoElectronico}" status="${3}" idReporte="${reporte.id}"><img src="imagenes/editar.png" width="30"/></a>
                                            <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${reporte.datosPersonalesId.nombre}" correo="${reporte.datosPersonalesId.correoElectronico}" status="${2}" idReporte="${reporte.id}"><img src="imagenes/tache.png" width="30"></a>
                                        </th>
                                        <th><a href="detalleReporteBimestral.do?id=${reporte.id}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>
                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/></th>
                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                        <th>
                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                <core:choose>
                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                            <core:out value="${fu.periodoInicio}"/>
                                                        </core:forEach>
                                                    </core:when>
                                                </core:choose>
                                            </core:forEach>
                                        </th>
                                        <th><core:out value="${reporte.horas}"/></th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div> 
                    <div id="enCorreccion">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Correccion" width='100%'>
                            <thead>
                                <tr>
                                    <th>Documento</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <tr class='gradeX'>
                                        <th><a href="mostarPDF.do?id=${1}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/></th>
                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                        <th>
                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                <core:choose>
                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                            <core:out value="${fu.periodoInicio}"/>
                                                        </core:forEach>
                                                    </core:when>
                                                </core:choose>
                                            </core:forEach>
                                        </th>
                                        <th><core:out value="${reporte.horas}"/></th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="Rechazados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Recha" width='100%'>
                            <thead>
                                <tr>
                                    <th>Documento</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <tr class='gradeX'>
                                        <th><a href="mostarPDF.do?id=${1}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/></th>
                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                        <th>
                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                <core:choose>
                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                            <core:out value="${fu.periodoInicio}"/>
                                                        </core:forEach>
                                                    </core:when>
                                                </core:choose>
                                            </core:forEach>
                                        </th>
                                        <th><core:out value="${reporte.horas}"/></th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>  
            </div>
            <div style="clear:both;"></div>

            <%-- fin del contenido --%>
        </div>
        
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
