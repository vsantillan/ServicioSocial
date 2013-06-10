<%-- 
    Document   : administrarProyectos
    Created on : 4/06/2013, 02:17:29 PM
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


        <title>Administracion de Proyectos</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="http://www.ittoluca.edu.mx/version10/index.php" onmouseout="MM_swapImgRestore();" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width: 80%">
                <h1>Administrar Proyectos</h1>
                <p>A continuaci&oacute;n se muestran los proyectos activos.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Ver proyecto</th>
                            <th>Organizaci&oacute;n</th>
                            <th>Nombre del proyecto</th>
                            <th>Titular</th>
                            <th>Numero de vacantes</th>           
                        </tr>
                    </thead>
                    <tbody>
                        <tr class='gradeX'>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/editar.png" width="30" title="Editar Proyecto"/></a><a href="retroalimentacionProyecto.do" rel="shadowbox"><img src="imagenes/trash.png" width="30" title="Borrar Proyecto"></a></th>
                            <th><a href="detalleProyecto.do" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th>Cierta Organizaci&oacute;n</th>
                            <th>Cierto proyecto</th>
                            <th>el hexor</th>
                            <th>1000</th>
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
