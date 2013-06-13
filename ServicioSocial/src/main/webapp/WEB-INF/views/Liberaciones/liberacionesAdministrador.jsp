<%-- 
    Document   : liberacionesAdministrador
    Created on : 12/06/2013, 12:02:37 PM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>

        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />
        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 
            <jsp:include page="../Template/headsJQueryUI.jsp" />
            <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $('#noRevisadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#aceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>
        <title>Administrador Liberaciones</title>

    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width:80%;">

                <h1>Liberaciones Pendientes</h1>




                <table cellpadding='0' cellspacing='0' border='0' class='display' id="noRevisadosDT" width='100%'>
                    <thead>
                        <tr>
                            <td>Periodo</td>
                            <th>n. Control</th>
                            <th>Nombre</th>
                            

                        </tr>
                    </thead>
                    <tbody>
                        <tr class='gradeX'>
                            <td>Ene-Feb</td>
                            <td>09271024</td>
                            <td>Hector Guzman Nava</td>
                          
                        </tr>
                        <tr class='gradeX'>
                            <td>Ene-Feb</td>
                            <td>09271024</td>
                            <td>Hector Guzman Nava</td>
                            
                        </tr>
                        <tr class='gradeX'>
                            <td>Ene-Feb</td>
                            <td>09271024</td>
                            <td>Hector Guzman Nava</td>
                            
                        </tr>
                    </tbody>
                </table>


            </div>
            <div style="clear:both;"></div>

        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
