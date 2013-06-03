<%-- 
    Document   : panelUsuario
    Created on : 3/06/2013, 10:52:04 AM
    Author     : roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu2.css" />
        <link rel="stylesheet" type="text/css" href="css/screen.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 

        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquerycssmenu2.js"></script>
        <script type="text/javascript" src="js/baner.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js" ></script>

        <title>Home Usuario</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#" onmouseout="MM_swapImgRestore()" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>

        <%-- inicio del contenido --%>
        <div id="contenido">

            <h1 align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('wel', '', 'imagenes/welcome1_e.png', 1)"><img id="wel" src="imagenes/welcome1.png" /></a></h1>
            <h1 align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('t_wel', '', 'imagenes/texto_wel_e.png', 1)"><img id="t_wel" src="imagenes/texto_wel.png" /></a></h1>
            <p> </p>			

        </div>
        <%-- fin del contenido --%>
        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>

    </body>


</html>
