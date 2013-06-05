<%-- 
    Document   : retroalimentacionOrganizacion
    Created on : 4/06/2013, 02:24:00 PM
    Author     : Regules
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Css -->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/screen.css" />
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu.css" />
        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" />
        <!--JavaScrips -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/baner.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js" ></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        <script>
            $(function() {
                $("#tabs").tabs();
                $('#timepicker').timepicker();
            });
        </script>
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
        <title>Home Usuario</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="http://www.ittoluca.edu.mx/version10/index.php" onmouseout="MM_swapImgRestore();" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>
        <div id="menu">
            <div class="jquerycssmenu">
                <div id="smoothmenu1" class="ddsmoothmenu" >
                    <ul>
                        <li><a href="administrarOrganizaciones.do">Volver</a></li>
                    </ul>
                </div>  
                <br style="clear: left" />
            </div>
        </div>
        <div id="contenido">
            <div id="tabs">
                <ul>
                    <li><a href="#">Enviar Correo de Cancelado</a></li>
                </ul>
                <div>
                    <form>
                        <table>
                            <tr>
                                <td>Nombre de la Organizaci&oacute;n:</td>
                                <td><input type ="text" name ="nombre"> </td>
                            </tr>
                            <tr>
                                <td>E-Mail:</td>
                                <td><input type ="text" name ="email"> </td>
                            </tr>
                            <tr>
                                <td>Descripci&oacute;n:</td>
                                <td><textarea name="descripcion" rows="10" cols="70"></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Enviar Correo" > </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>

        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>
    </body>
</html>

