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
        <jsp:include page="../Template/metas.jsp" />
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

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


        <title>Administracion de Proyectos</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <jsp:include page="../Template/banner.jsp" />


        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width: 80%">
                <h1>Validar Proyectos</h1>

                <p>A continuaci&oacute;n se muestran los proyectos por validar.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Nombre del proyecto</th>
                            <th>Organizaci&oacute;n</th>
                            <th>Numero de vacantes</th>
                            <th>Ver proyecto</th>
                            <th>Acci&oacute;n</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr class='gradeX'>
                            <th>Cierto proyecto</th>
                            <th>el hexor</th>
                            <th>1000</th>
                            <th><a href="detalleProyecto.do" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="algunLado.do" rel="shadowbox"><img src="imagenes/paloma.png" width="30"/><a href="retroalimentacionProyecto.do" rel="shadowbox"><img src="imagenes/tache.png" width="30"/></a></th>
                        </tr>

                    </tbody>
                </table>
            </div>
            <div style="clear:both;"></div>
            <%-- fin del contenido --%>
        </div>
        <jsp:include page="../Template/footer.jsp" />

    </body>


</html>
