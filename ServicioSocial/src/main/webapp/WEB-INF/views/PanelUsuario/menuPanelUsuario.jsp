<%-- 
    Document   : menuPanelUsuario
    Created on : 5/06/2013, 10:50:33 AM
    Author     : roy
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Css --%>

        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
        <%-- JavaScript --%>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "smoothmenu1", //Menu DIV id
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                method: 'hover', // set to 'hover' (default) or 'toggle'
                arrowswap: true, // enable rollover effect on menu arrow images?
                //customtheme: ["#804000", "#482400"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })

        </script>

    </head>
    <body>
         <div id="menu">
            <div class="jquerycssmenu">
                <div id="smoothmenu1" class="ddsmoothmenu" >
                    <ul>
                        <li><a href="panelUsuario.do">Inicio</a></li>
                        <li><a href="#">Noticias</a></li>
                        <li><a href="#">Ayuda</a></li>
                        <li><a href="#">Cerrar Seci&oacute;n</a></li>
                    </ul>
                </div>  
                <br style="clear: left" />
            </div>
        </div>
    </body>
</html>