<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Menu Panel Admin</title>

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
    </head>
    <body>
        <div id="smoothmenu1" class="ddsmoothmenu"></div>
        <h2>Panel de Administraci&oacute;n</h2>
        <div id="smoothmenu2" class="ddsmoothmenu-v">
            <ul>
                <li><a href="#">Platicas</a>
                    <ul>
                        <li><a href="altaPlatica.do">1.1 Altas</a></li>
                        <li><a href="consultasBajas.do">1.2 Bajas | Consultas</a></li>
                        <li><a href="capturarAsistencia.do">1.3 Capturar Asistencia</a></li>
                        <li><a href="asistenciaPosteriorEspecial.do">1.4 Alta Posterior</a></li>
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
                <li><a href="#">Organizaciones</a>
                    <ul>
                        <li><a href="administrarProyectos.do">8.1 Administrar Proyectos</a></li>
                        <li><a href="administrarOrganizaciones.do">8.2 Administrar Organizaciones</a></li>
                        <li><a href="#">8.3 Validar Proyectos</a></li>
                        <li><a href="#">8.4 Validar Organizaciones</a></li>
                    </ul>
                </li>
                <li><a href="#">Administraci&oacute;n</a>
                    <ul>
                        <li><a href="#">9.1 Administrar Observaciones</a></li>
                        <li><a href="#">9.2 Noticias | Convocatorias</a></li>
                    </ul>
                </li>
                <li><a href="#">Historial Servicio Social</a></li>
                <li><a href="#">Cartas de Liberaci&oacute;n</a></li>
                <li><a href="#">Reportes</a></li>
                <li><a href="#">Casos Especiales</a>
                    <ul>
                        <li><a href="#">13.1 Egresados</a></li>
                        <li><a href="#">13.2 Especiales</a></li>
                    </ul>
                </li>
                <li><a href="#">Acerca De</a>
                    <ul>
                        <li><a href="#">14.1 Ayuda</a></li>
                        <li><a href="#">14.2 Acerca De</a></li>
                    </ul>
                </li>
            </ul>
            <br style="clear: left" />
        </div>
    </body>
</html>

