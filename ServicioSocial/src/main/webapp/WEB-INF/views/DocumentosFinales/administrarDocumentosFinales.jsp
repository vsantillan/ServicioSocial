<%-- 
    Document   : administrarDocumentosOriginales
    Created on : 12/06/2013, 09:44:29 AM
    Author     : Regules
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />       
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript" language="javascript" src="js/documentosFinalesActualiza.js"></script>

        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>
        <title>Administraci&oacute;n Documentos Originales</title>
    </head>
    <body class="background" onmousedown="elemento(event);">
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Administraci&oacute;n Documentos Finales</h1>
                <p>A continuaci&oacute;n se muestra una vista de los documentos originales de cada alumno.</p>
                <div id="tabs">
                    <ul>
                        <li><a href="#completos">Documentos Finales</a></li>
                    </ul>
                    <div id="completos">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                            <thead>
                                <tr>
                                    <th>No. Control</th>
                                    <th>Nombre</th>
                                    <th>Formato &Uacute;nico</th>
                                    <th>Reporte Final</th>
                                    <th>Constancia de Pago</th>
                                    <th>Reporte de Evaluaci&oacute;n</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${documentosAlumno}" var="alumno">
                                    <tr class='gradeX'>
                                        <th><core:out value="${alumno.noControl}" /></th>
                                        <th><core:out value="${alumno.nombreCompleto}" /></th>
                                        <th><a href="mostarPDF.do?id=${alumno.idFormatoUnicoFinal}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th><a href="mostarPDF.do?id=${alumno.idReporteFinal}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th><a href="mostarPDF.do?id=${alumno.idConstanciaPago}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th>
                                            <core:choose>
                                                <core:when test="${alumno.idReporteCalificacion==0}">
                                                    <core:out value="Alumno con Retícula 2004"/>
                                                </core:when>
                                                <core:otherwise>
                                                    <a href="mostarPDF.do?id=${alumno.idReporteCalificacion}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                                </core:otherwise>
                                            </core:choose>
                                        <th>
                                            <a href="#"><img class="aceptarDocumentos" ide="${alumno.noControl}" status="${1}" src="imagenes/paloma.png" width="30"/></a>
                                            <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${alumno.nombreCompleto}" correo="${alumno.correo}" status="${0}" idAlumno="${alumno.noControl}"><img src="imagenes/tache.png" width="30"></a>
                                        </th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>

                <%-- fin del contenido --%>
            </div>
            <div style="clear: both;"/>
        </div>
        <div id="a" style="display: none; font-size: 15px">
            <form:form commandName="retroalimentacionDocumentosFinales"  id="MyForm" method="POST" >
                <h1>Envio de Retroalimentaci&oacute;n</h1>
                <h2>Motivos de Rechazo</h2>
                <table >
                    <tr>
                        <td>Nombre de la Organizaci&oacute;n:
                            <form:hidden id="status" nombre="status" path="status" size="20"/><br/>
                            <form:hidden id="idAlumno" path="idAlumno" name="idAlumno" size="20"/>
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
    </div>
    <jsp:include page="../Template/footer.jsp" />
</body>
</html>
