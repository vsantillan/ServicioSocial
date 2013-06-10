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
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/reporteBimestral.css" /> 
               <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Estilos para tablas-->
        <link rel="stylesheet" type="text/css" href="css/demo_page.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css" />


        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>


        <!-- Scripts -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>
        <script src="js/jqueryUI/jquery.ui.core.js"></script>
        <script src="js/jqueryUI/jquery.ui.widget.js"></script>
        <script src="js/jqueryUI/jquery.ui.tabs.js"></script>


        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

        <!--Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>

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

            });
        </script> 



        <title>Administrar Reportes Mensuales</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 700px;">
                    <div id="tabs">
                        <h1>Administraci&oacute;n de Reportes Mensuales</h1>
                        <ul>
                            <li><a href="#Revisados">Formatos Mensuales Revisados</a></li>
                            <li><a href="#noRevisados">Formatos Mensuales No Revisados</a></li>
                        </ul>
                        <div id="Revisados">
                            <table cellpadding='0' cellspacing='0' border='0' class='display' id="Rev" width='100%'>
                                <thead>
                                    <tr>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Estado</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Acci&oacute;n</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09280536</th>
                                        <th>José Antonio Villanueva Gonzalez</th>
                                        <th>En proceso</th>
                                        <th>360</th>
                                        <th><a href="algunlado.do" rel="shadowbox;"><img src="imagenes/lupa.png"/></a></th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09280545</th>
                                        <th>Alberto Martinez Behumea</th>
                                        <th>En proceso</th>
                                        <th>360</th>
                                        <th><a href="algunLado" rel="shadowbox"><img src="imagenes/lupa.png"/></a></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="noRevisados">
                            <table cellpadding='0' cellspacing='0' border='0' class='display' id="NoRev" width='100%'>
                                <thead>
                                    <tr>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Fecha Subida</th>
                                        <th>Archivo</th>
                                        <th>Acci&oacute;n</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09280539</th>
                                        <th>Marco Antonio Cuellar</th>
                                        <th>14 Abril 2014</th>
                                        <th>Rerpote1.docx</th>
                                        <th><a href="#" ><img class="imagenes" src="imagenes/paloma.png"/><img class="imagenes" src="imagenes/tache.png"/></a></th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09275643</th>
                                        <th>Jose Luis Albarran Martinez</th>
                                        <th>10 Abril 2014</th>
                                        <th>Rerporte348.docx</th>
                                        <th><a href="#"><img class="imagenes" src="imagenes/paloma.png"/><img class="imagenes" src="imagenes/tache.png"/></a></th>
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