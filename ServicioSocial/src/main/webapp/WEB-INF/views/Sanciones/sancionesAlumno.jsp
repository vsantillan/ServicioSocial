<%-- 
    Document   : sancionesAlumno
    Created on : 10/06/2013, 09:27:13 AM
    Author     : ekt
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

        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 
        
        <!--        Scripts para tablas-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
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
            <div style="float:left;width:80%">
                <h1>Sanciones</h1>
                <p>A continuaci&oacute;n se muestran los alumnos con sanciones, de click en "Detalles" para ver sus reportes o click en "Pagar" para agregar reportes de pago de servicio.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Periodo</th>
                            <th>No control</th>
                            <th>Nombre</th>
                            <th>Status</th>
                            <th>Horas de sanci&oacute;n</th>
                            <th>Horas restantes</th>
                            <th>Lugar</th>
                            <th>Acci&oacute;n</th>
                            <th>Detalle</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class='gradeX'>
                            <th>Ago-Dic 2014</th>
                            <th>09280525</th>
                            <th>Hector Guzman Nava</th>
                            <th>Liberado</th>
                            <th>360</th>
                            <th>360</th>
                            <th>Biblioteca</th>
                            <th><a href="algunLado.do" rel="shadowbox">Pagar</a></th>
                            <th><a href="pagoSancionAlumno.do" rel="shadowbox"><img src="imagenes/lupa.png" width="30"/></a></th>
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
