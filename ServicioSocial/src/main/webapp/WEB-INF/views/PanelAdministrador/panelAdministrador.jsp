<%-- 
    Document   : panelAdministrador
    Created on : 3/06/2013, 01:01:53 PM
    Author     : Regules
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Css --%>
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/screen.css" />       
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 
        <%-- JavaScript --%>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquerycssmenu2.js"></script>
        <script type="text/javascript" src="js/baner.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js" ></script>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="http://www.ittoluca.edu.mx" onmouseout="MM_swapImgRestore()"><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>
        <div id="contenido">
            <jsp:include page="menuPanelAdministrador.jsp" />
        </div>

        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>
    </body>
</html>
