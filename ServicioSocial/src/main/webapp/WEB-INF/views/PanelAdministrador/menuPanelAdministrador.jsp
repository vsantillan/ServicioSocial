<%--
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
--%>
<!--<div id="smoothmenu1" class="ddsmoothmenu"></div>-->
<div id="smoothmenu2" class="ddsmoothmenu-v">
    <ul>
        <li><a href="#">Pláticas</a>
            <ul>
                <li><a href="altaPlatica.do">1.1 Altas</a></li>
                <li><a href="consultasBajas.do">1.2 Bajas | Consultas</a></li>
                <li><a href="capturarAsistencia.do">1.3 Capturar Asistencia</a></li>
                <li><a href="asistenciaPosteriorEspecial.do">1.4 Alta Posterior</a></li>
                <li><a href="altaLugares.do">1.4 Catálogo lugares</a></li>
            </ul>
        </li>
        <li><a href="formatoUnicoAdministrador.do">Formato &Uacute;nico</a></li>
        <li><a href="reporteBimestralAdministrador.do">Formato Bimestral</a></li>
        <li><a href="#">Becados</a>
            <ul>
                <li><a href="administracionAlumnosBecados.do">4.1 Alumnos Becados</a></li>
                <li><a href="reporteMensualAdministrador.do">4.2 Formato Mensual</a>
            </ul>
        </li>
        <li><a href="#">Documentos Finales</a>
            <ul>
                <li><a href="#">5.1 Documentos Originales</a></li>
            </ul>
        </li>
        <li><a href="#">Sanciones</a>
            <ul>
                <li><a href="sancionesAlumno.do">6.1 Administrar Sanciones</a></li>
                <li><a href="catalogoSanciones.do">6.2 Cat&aacute;logo de Sanciones</a></li>
            </ul>
        </li>
        <li><a href="#">Bajas Temporales</a>
            <ul>
                <li><a href="administrarBajas.do">7.1 Administrar</a></li>
                <li><a href="#">7.2 Cambio de Proyecto</a></li>
            </ul>
        </li>
        <li><a href="#">Organizaciones</a>
            <ul>
                <li><a href="altaAdminOrganizacion.do">8.1 Alta Organizaciones</a></li>
                <li><a href="altaAdminProyectos.do">8.2 Alta de Proyectos</a></li>
                <li><a href="administrarOrganizaciones.do">8.3 Administrar Organizaciones</a></li>
                <li><a href="administrarProyectos.do">8.4 Administrar Proyectos</a></li>
                <li><a href="validarOrganizaciones.do">8.5 Validar Organizaciones</a></li>
                <li><a href="validarProyectos.do">8.6 Validar Proyectos</a></li>                
            </ul>
        </li>
        <li><a href="#">Administraci&oacute;n</a>
            <ul>
                <li><a href="#">9.1 Administrar Observaciones</a></li>
                <li><a href="#">9.2 Noticias | Convocatorias</a></li>
            </ul>
        </li>
        <li><a href="#">Historial Servicio Social</a></li>
        <li><a href="liberaciones.do">Cartas de Liberaci&oacute;n</a></li>
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
        <li><a href="index.do">Cerrar Sesi&oacute;n</a></li>
    </ul>
    <br style="clear: left" />
</div>

