<%-- 
    Document   : administrarOrganizaciones
    Created on : 4/06/2013, 02:17:52 PM
    Author     : roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" />         
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/cssTablaDetallesOrganizaciones.css" />

        <!--Estilos para tablas-->
        <link rel="stylesheet" type="text/css" href="css/demo_page.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.4.custom.css" />




        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>

        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

        <!--        Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf-8">
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
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="http://www.ittoluca.edu.mx/version10/index.php" onmouseout="MM_swapImgRestore();" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <h1>Administrar Organizaciones</h1>
                <p>A continuaci&oacute;n se muestran las organizaciones pendientes por validar.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Titular</th>
                            <th>RFC</th>
                            <th>Tipo de Organizaci&oacute;n</th>
                            <th>Detalle</th>
                            <th>Acci&oacute;n</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr class='gradeX'>
                            <th>Hector Guzman Nava</th>
                            <th>139103RLR</th>
                            <th>Cosas ilegales</th>
                            <th><a href="detalleOrganizacion.do" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png"</a></th>
                            <th><a href="detalleOrganizacion.do" rel="shadowbox"><img src="imagenes/paloma.png" width="30"/></a><a href="retroalimentacionOrganizacion.do" rel="shadowbox"><img src="imagenes/tache.png" width="30"></a></th>
                        </tr>
                        <tr class='gradeX'>
                            <th>Hector Guzman Nava</th>
                            <th>139103RLR</th>
                            <th>Cosas ilegales</th>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/lupa.png"</a></th>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/paloma.png" width="30"/></a><a href="algunLado.do" rel="shadowbox"><img src="imagenes/tache.png" width="30"></a></th>
                        </tr>

                    </tbody>
                </table>

                <%-- fin del contenido --%>
            </div>
            <div style="clear: both;"/>
        </div>
    </div>
    <div id="footer">
        <img  src="imagenes/foter.png"/>
    </div>

</body>


</html>
