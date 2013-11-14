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
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>

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
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${documentosAlumno}" var="alumno">
                                    <tr class='gradeX'>
                                        <th><core:out value="${alumno.datosPersonalesId.id}" /></th>
                                        <th><core:out value="${alumno.datosPersonalesId.nombre}" /></th>
                                        <th><a href="mostarPDF.do?id=${1}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th>
                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                    <core:choose>
                                                        <core:when test="${documentos.status==3}">
                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>
                                                        </core:when>
                                                    </core:choose>
                                                </core:forEach>
                                            </core:forEach>
                                        </th>
                                        <th><a href="mostarPDF.do?id=${1}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th><a href="mostarPDF.do?id=${1}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                        <th><a href="mostarPDF.do?id=${1}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
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
    </div>
    <jsp:include page="../Template/footer.jsp" />
</body>
</html>
