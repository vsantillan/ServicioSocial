<%-- 
    Document   : reporteBimestralAdministrador
    Created on : 5/06/2013, 02:15:04 PM
    Author     : roy
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



        <title>Administrar Reportes Bimestrales</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%;">
                <%--<select>
                    <core:forEach items="${reportes}" var="reporte">
                        <core:forEach items="${datosPersonales}" var="datoPersonal">
                            <core:choose>
                                <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                    <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                        <option value="${fu.periodoInicio}">${fu.periodoInicio}</option>
                                    </core:forEach>
                                </core:when>
                            </core:choose>
                        </core:forEach>
                    </core:forEach>
                </select>--%>
                <div id="tabs">
                    <h1>Administraci&oacute;n de Reportes Bimestrales</h1>
                    <ul>
                        <li><a href="#Revisados">Revisados</a></li>
                        <li><a href="#noRevisados">No Revisados</a></li>
                        <li><a href="#enCorreccion">En Correcci&oacute;n</a></li>
                        <li><a href="#Rechazados">Rechazados</a></li>
                    </ul>
                    <div id="Revisados">
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
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="NoRev" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;n</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                    <th>Fecha Subida</th>
                                    <th>Archivo</th>
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
                                        <th><core:out value="${reporte.status}"/></th>
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
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <tr class='gradeX'>
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
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <tr class='gradeX'>
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
