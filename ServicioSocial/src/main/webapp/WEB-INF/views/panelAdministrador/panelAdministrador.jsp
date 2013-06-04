<%-- 
    Document   : panelAdministrador
    Created on : 3/06/2013, 01:01:53 PM
    Author     : ekt
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu2.css" />
        <link rel="stylesheet" type="text/css" href="css/screen.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu.css" />

        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquerycssmenu2.js"></script>
        <script type="text/javascript" src="js/baner.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js" ></script>

        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu-v.css" />

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "smoothmenu2", //Menu DIV id
                orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
                method: 'hover', // set to 'hover' (default) or 'toggle'
                arrowswap: true, // enable rollover effect on menu arrow images?
                //customtheme: ["#804000", "#482400"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })

        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#" onmouseout="MM_swapImgRestore()"><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>
        <div id="contenido">
            <div id="smoothmenu1" class="ddsmoothmenu"></div>
            <h2>Panel de Administraci&oacute;n</h2>
            <div id="smoothmenu2" class="ddsmoothmenu-v">
                <ul>
                    <li><a href="#">Platicas</a>
                        <ul>
                            <li><a href="#">1.1 Altas</a></li>
                            <li><a href="#">1.2 Bajas | Consultas</a></li>
                            <li><a href="#">1.3 Capturar Asistencia</a></li>
                            <li><a href="#">1.4 Alta Posterior</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Formato &Uacute;nico</a>
                        <ul>
                            <li><a href="#">2.1 Revisados</a></li>
                            <li><a href="#">2.2 No revisados</a></li>
                            <li><a href="#">2.3 En correcci&oacute;n</a></li>
                            <li><a href="#">2.4 Rechazados</a></li>
                            <li><a href="#">2.5 Alta Posterior</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Formato Bimestral</a>
                        <ul>
                            <li><a href="#">3.1 Revisados</a></li>
                            <li><a href="#">3.2 No revisados</a></li>
                            <li><a href="#">3.3 En correcci&oacute;n</a></li>
                            <li><a href="#">3.4 Rechazados</a></li>
                            <li><a href="#">3.5 Alta Posterior</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Becados</a>
                        <ul>
                            <li><a href="#">4.1 Alta</a></li>
                            <li><a href="#">4.2 Bajas | Consultas</a></li>
                            <li><a href="#">4.3 Formato Mensual</a>
                                <ul>
                                    <li><a href="#">4.3.1 Revisados</a></li>
                                    <li><a href="#">4.3.2 No revisados</a></li>
                                    <li><a href="#">4.3.3 En correcci&oacute;n</a></li>
                                    <li><a href="#">4.3.4 Rechazados</a></li>
                                    <li><a href="#">4.3.5 Alta Posterior</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="#">Documentos Finales</a>
                        <ul>
                            <li><a href="#">5.1 Documentos Originales</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Sanciones</a>
                        <ul>
                            <li><a href="#">6.1 Administrar Sanciones</a></li>
                            <li><a href="#">6.2 Cat&aacute;logo de Sanciones</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Bajas Temporales</a>
                        <ul>
                            <li><a href="#">7.1 Administrar</a></li>
                            <li><a href="#">7.2 Cambio de Proyecto</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Organizaciones</a></li>
                    <li><a href="#">Administraci&oacute;n</a>
                        <ul>
                            <li><a href="#">8.1 Administrar Observaciones</a></li>
                            <li><a href="#">8.2 Noticias | Convocatorias</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Historial Servicio Social</a></li>
                    <li><a href="#">Cartas de Liberaci&oacute;n</a></li>
                    <li><a href="#">Reportes</a></li>
                    <li><a href="#">Casos Especiales</a>
                        <ul>
                            <li><a href="#">12.1 Egresados</a></li>
                            <li><a href="#">12.2 Especiales</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Acerca De</a>
                        <ul>
                            <li><a href="#">13.1 Ayuda</a></li>
                            <li><a href="#">13.2 Acerca De</a></li>
                        </ul>
                    </li>
                </ul>
                <br style="clear: left" />
            </div>
        </div>

        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>
    </body>
</html>
