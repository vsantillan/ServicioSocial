<%-- 
    Document   : reporteBimestralAdministrador
    Created on : 5/06/2013, 02:15:04 PM
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
        <!-- CSS  Shadowbox-->
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        
         <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

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
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
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
                                        <th>Estado</th>
                                        <th>Horas Acumuladas</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th><a href="retroalimentacionReportesBimestrales.do" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
                                        <th>José Antonio Villanueva Gonzalez</th>
                                        <th>09280536</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>En proceso</th>
                                        <th>360</th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th><a href="retroalimentacionReportesBimestrales.do" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
                                         <th>Alberto Martinez Behumea</th>
                                        <th>09280545</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>En proceso</th>
                                        <th>360</th>
                                    </tr>
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
                                    <tr class='gradeX'>
                                        <th><a href="#" ><img width="30" src="imagenes/paloma.png"/><img width="30" src="imagenes/tache.png"/></a></th>
                                        <th>Marco Antonio Cuellar</th>
                                        <th>09280539</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>14 Abril 2014</th>
                                        <th>Rerpote1.docx</th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th><a href="#"><img width="30" src="imagenes/paloma.png"/><img width="30" src="imagenes/tache.png"/></a></th>
                                        <th>Jose Luis Albarran Martinez</th>
                                        <th>09275643</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>10 Abril 2014</th>
                                        <th>Rerporte348.docx</th>
                                    </tr>
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
                                        <th>Estado</th>
                                        <th>Horas Acumuladas</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th>José Antonio Villanueva Gonzalez</th>
                                        <th>09280536</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>En Correcci&oacute;n</th>
                                        <th>360</th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th>Alberto Martinez Behumea</th>
                                        <th>09280545</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>En Correcci&oacute;n</th>
                                        <th>360</th>
                                    </tr>
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
                                        <th>Estado</th>
                                        <th>Horas Acumuladas</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th>José Antonio Villanueva Gonzalez</th>
                                        <th>09280536</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>Rechazado</th>
                                        <th>360</th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th>Alberto Martinez Behumea</th>
                                        <th>09280545</th>
                                        <th>Ago-Dic 2014</th>
                                        <th>Rechazado</th>
                                        <th>360</th>
                                    </tr>
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
