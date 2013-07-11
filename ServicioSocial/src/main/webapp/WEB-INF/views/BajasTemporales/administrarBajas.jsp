<%-- 
    Document   : administrarBajas
    Created on : 12/06/2013, 09:47:42 AM
    Author     : roy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <script type="text/javascript">
            $(document).ready(function() {
                $("#tabs").tabs();
                
                $('#Asignar').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#Quitar').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script> 
        <title>Administrar Bajas Temporales</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">
                <div id="tabs">
                    <h1>Asignar Bajas Temporales</h1>
                    <p>En esta secci&oacute;n usted podra asginar bajas temporales</p>
                    <ul>
                        <li><a href="javascript:void(0)" onclick="redirecciona('#AsignarBaja')">Asignar Bajas</a></li>
                        <li><a href="javascript:void(0)" onclick="redirecciona('#QuitarBaja')">Quitar Bajas</a></li>
                    </ul>
                    <div id="AsignarBaja">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Asignar" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;n</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <th><a href="javascript:void(0)" onclick="redirecciona('retroalimentacionReportesBimestrales.do')" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/baja.png" width="30"/></a></th>
                                    <th>José Antonio Villanueva Gonzalez</th>
                                    <th>09280536</th>
                                    <th>Ago-Dic 2014</th>
                                </tr>
                                <tr class='gradeC'>
                                    <th><a href="javascript:void(0)" onclick="redirecciona('retroalimentacionReportesBimestrales.do')" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/baja.png" width="30"/></a></th>
                                    <th>Alberto Martinez Behumea</th>
                                    <th>09280545</th>
                                    <th>Ago-Dic 2014</th>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                    <div id="QuitarBaja">
                         <table cellpadding='0' cellspacing='0' border='0' class='display' id="Quitar" width='100%'>
                                <thead>
                                    <tr>
                                        <th>Acci&oacute;n</th>
                                        <th>Nombre</th>
                                        <th>N. Control</th>
                                        <th>Periodo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th><a href="javascript:void(0)" onclick="redirecciona('retroalimentacionReportesBimestrales.do')" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/alta.png" width="30"/></a></th>
                                        <th>José Antonio Villanueva Gonzalez</th>
                                        <th>09280536</th>
                                        <th>Ago-Dic 2014</th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th><a href="javascript:void(0)" onclick="redirecciona('retroalimentacionReportesBimestrales.do')" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/alta.png" width="30"/></a></th>
                                         <th>Alberto Martinez Behumea</th>
                                        <th>09280545</th>
                                        <th>Ago-Dic 2014</th>
                                    </tr>
                                </tbody>
                            </table>

                    </div>
                </div>


                <div style="clear:both;"></div>
            </div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>

