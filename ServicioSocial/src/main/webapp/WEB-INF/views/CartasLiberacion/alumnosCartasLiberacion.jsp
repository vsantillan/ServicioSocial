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
        <script type="text/javascript" language="javascript" src="js/reporteBimestalActualiza.js"></script> 


        <title>Cartas de Liberación</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%;">
                <div id="tabs">
                    <h1>Cartas de Liberación</h1>
                    <ul>
                        <li><a href="#cartasLiberacion">Cartas de Liberación</a></li>
                    </ul>
                    <div id="cartasLiberacion">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Rev" width='100%'>
                            <thead>
                                <tr>
                                    <th>Generar</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>¿Se entrego anteriormente?</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${cartaDocumento}" var="carta">
                                    <tr class='gradeX'>
                                        <th><a href="detalleReporteBimestral.do?id=${1}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>
                                        <th><core:out value="${carta.datosPersonalesId.nombre}"/></th>
                                        <th><core:out value="${carta.datosPersonalesId.alumnoId.id}"/></th>
                                        <th><core:out value="${2}"/></th>
                                        <th><core:out value="${1}"/></th>
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
