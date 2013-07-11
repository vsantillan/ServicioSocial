<%--
<link rel="stylesheet" type="text/css" href="javascript:void(0)" onclick="redirecciona('css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="javascript:void(0)" onclick="redirecciona('css/ddsmoothmenu-v.css" />
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
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Pláticas</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('altaPlatica.do')">1.1 Altas</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('consultasBajas.do')">1.2 Bajas | Consultas</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('capturarAsistencia.do')">1.3 Capturar Asistencia</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('asistenciaPosteriorEspecial.do')">1.4 Alta Posterior</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('altaLugares.do')">1.4 Catálogo lugares</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('formatoUnicoAdministrador.do')">Formato &Uacute;nico</a></li>
        <li><a href="javascript:void(0)" onclick="redirecciona('reporteBimestralAdministrador.do')">Formato Bimestral</a></li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Becados</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('administracionAlumnosBecados.do')">4.1 Alumnos Becados</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('reporteMensualAdministrador.do')">4.2 Formato Mensual</a>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Documentos Finales</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">5.1 Documentos Originales</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Sanciones</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('sancionesAlumno.do')">6.1 Administrar Sanciones</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('catalogoSanciones.do')">6.2 Cat&aacute;logo de Sanciones</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Bajas Temporales</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('administrarBajas.do')">7.1 Administrar</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">7.2 Cambio de Proyecto</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Organizaciones</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('altaAdminOrganizacion.do')">8.1 Alta Organizaciones</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('altaAdminProyectos.do')">8.2 Alta de Proyectos</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('administrarOrganizaciones.do')">8.3 Administrar Organizaciones</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('administrarProyectos.do')">8.4 Administrar Proyectos</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('validarOrganizaciones.do')">8.5 Validar Organizaciones</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('validarProyectos.do')">8.6 Validar Proyectos</a></li>                
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Administraci&oacute;n</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">9.1 Administrar Observaciones</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">9.2 Noticias | Convocatorias</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Historial Servicio Social</a></li>
        <li><a href="javascript:void(0)" onclick="redirecciona('liberaciones.do')">Cartas de Liberaci&oacute;n</a></li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Reportes</a></li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Casos Especiales</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">13.1 Egresados</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">13.2 Especiales</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('#')">Acerca De</a>
            <ul>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">14.1 Ayuda</a></li>
                <li><a href="javascript:void(0)" onclick="redirecciona('#')">14.2 Acerca De</a></li>
            </ul>
        </li>
        <li><a href="javascript:void(0)" onclick="redirecciona('index.do')">Cerrar Sesi&oacute;n</a></li>
    </ul>
    <br style="clear: left" />
</div>

