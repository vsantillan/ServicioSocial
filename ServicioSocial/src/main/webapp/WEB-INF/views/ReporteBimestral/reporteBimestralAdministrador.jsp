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
        <script type="text/javascript" language="javascript" src="js/reporteBimestalActualiza.js"></script> 


        <title>Administrar Reportes Bimestrales</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%;">
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
                                    <th>Horas del Reporte</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <core:choose>
                                        <core:when test="${reporte.status==1}">
                                            <tr class='gradeX'>
                                                <th>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==1 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </th>
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
                                        </core:when>
                                    </core:choose>
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
                                    <core:choose>
                                        <core:when test="${reporte.status==4}">
                                            <tr class='gradeX'>
                                                <th>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==4 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="#"><img class="aceptarReporte" ide="${reporte.id}" status="${1}" idDoc="${documentos.id}" src="imagenes/paloma.png" width="30"/></a>
                                                                            <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${reporte.datosPersonalesId.nombre}" correo="${reporte.datosPersonalesId.correoElectronico}" status="${3}" idReporte="${reporte.id}" idDoc="${documentos.id}"><img src="imagenes/editar.png" width="30"/></a>
                                                                            <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${reporte.datosPersonalesId.nombre}" correo="${reporte.datosPersonalesId.correoElectronico}" status="${2}" idReporte="${reporte.id}" idDoc="${documentos.id}"><img src="imagenes/tache.png" width="30"></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </th>
<!--                                                <th><a href="detalleReporteBimestral.do?id=${reporte.id}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>-->
                                                <th>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==4 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </th>
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
                                        </core:when>
                                    </core:choose>
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
                                    <th>Horas del Reporte</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <core:choose>
                                        <core:when test="${reporte.status==3}">
                                            <tr class='gradeX'>
                                                <th>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==3 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </th>
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
                                        </core:when>
                                    </core:choose>
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
                                    <th>Horas del Reporte</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${reportes}" var="reporte">
                                    <core:choose>
                                        <core:when test="${reporte.status==2}">
                                            <tr class='gradeX'>
                                                <!--<th><a href="mostarPDF.do?id=${2}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                                    <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>-->                                                
                                                <th>
                                                    <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                        <core:choose>
                                                            <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                    <core:choose>
                                                                        <core:when test="${documentos.status==2 && documentos.catalogoDocumentosId.id==2}">
                                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>
                                                                            </core:when>
                                                                        </core:choose>
                                                                    </core:forEach>
                                                                </core:when>
                                                            </core:choose>
                                                        </core:forEach>
                                                </th>
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
                                        </core:when>
                                    </core:choose>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>  
            </div>
            <div style="clear:both;"></div>

            <%-- fin del contenido --%>
        </div>
        <div id="a" style="display: none; font-size: 15px">
            <form:form commandName="retroalimentacionReporte"  id="MyForm" method="POST"  action="actualizarStatusReporte.do">
                <h1>Envio de Retroalimentaci&oacute;n</h1>
                <h2>Motivos de Rechazo</h2>
                <table >
                    <tr>
                        <td>Nombre de la Organizaci&oacute;n:
                            <form:hidden id="status" nombre="status" path="status" size="20"/><br/>
                            <form:hidden id="idReporte" path="idReporte" name="idReporte" size="20"/><br/>
                            <form:hidden id="idDoc" path="idDoc" name="idDoc" size="20"/>
                        </td>
                        <td><form:input type ="text"  id="nombre" path="nombre" name="nombre" disabled="true" /> </td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><form:input type ="text"  id="correo" path="correo" name="correo" disabled="true" /> </td>
                    </tr>
                    <tr>
                        <td>Descripci&oacute;n:</td>
                        <td><form:textarea  id="descripcion" path="descripcion" rows="10" cols="70" name="descripcion" cssClass="d"/><br/>
                            <label id="errorDescripcion" style="display: none" class="error">La descripción no debe ser vacía</label>
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td><input type ="submit" value="Enviar Retroalimentaci&oacute;n" class="enviarRetroalimentacion"> </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
