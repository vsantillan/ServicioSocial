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
        <jsp:include page="../Template/metas.jsp" />
        
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

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
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <h1>Validar Organizaciones</h1>


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
                            <th><a href="#detalle" rel="shadowbox"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/paloma.png" width="30"/></a><a href="retroalimentacionOrganizacion.do" rel="shadowbox"><img src="imagenes/tache.png" width="30"></a></th>
                        </tr>
                        <tr class='gradeX'>
                            <th>Hector Guzman Nava</th>
                            <th>139103RLR</th>
                            <th>Cosas ilegales</th>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/paloma.png" width="30"/></a><a href="algunLado.do" rel="shadowbox"><img src="imagenes/tache.png" width="30"></a></th>
                        </tr>

                    </tbody>
                </table>
            </div>
            <div style="clear:both;"></div>
            <%-- fin del contenido --%>
        </div>
    </div>
    <jsp:include page="../Template/footer.jsp" />

</body>

</html>
