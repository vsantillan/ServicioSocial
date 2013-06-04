<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu2.css" />
        <link rel="stylesheet" type="text/css" href="css/screen.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 
        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>
        <!-- JSP -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>
	<script src="js/jqueryUI/jquery.ui.core.js"></script>
	<script src="js/jqueryUI/jquery.ui.widget.js"></script>
	<script src="js/jqueryUI/jquery.ui.tabs.js"></script>
        <script>
	$(function() {
		$( "#tabs" ).tabs();
	});
	</script>
        
        <title>Formato &Uacute;nico - Usuario</title>
    </head>
    <body>
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#"><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>
        
        <div id="tabs" style="margin-left:50px; margin-right:55px">
            <h1>Pagina del Formato Unico</h1>
            <ul>
                <li><a href="#datosPersonales">Datos Personales</a></li>
                <li><a href="#datosContacto">Datos de Contacto</a></li>
                <li><a href="#datosOrganizaciones">Datos de Organizaciones</a></li>
                <li><a href="#horarios">Horario</a></li>
            </ul>
            <div id="datosPersonales">
                <p>Esta es la pag de Personales.</p>
            </div>
            <div id="datosContacto">
                <p><p>Esta es la pag de Contacto.</p>
            </div>
            <div id="datosOrganizaciones">
                <p><p>Esta es la pag de Organizaciones.</p>
            </div>
            <div id="horarios">
                <p><p>Esta es la pag de Horarios.</p>
            </div>
        </div>

        <%-- fin del contenido --%>
        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>
    </body>
</html>
