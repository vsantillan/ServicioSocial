<%-- 
    Document   : menuAdministrador
    Created on : 22/01/2014, 03:44:04 PM
    Author     : Jonny
--%>

<div class="nav navbar-inverse  " role="navigation">
    <div class="container">
        <div class="navbar-inner">
            <ul class="nav navbar-nav" role="navigation">                                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pl&aacute;ticas<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="altaPlatica.do" onclick="redirecciona('altaPlatica.do');">1.1 Nueva Pl&aacute;tica</a></li>
                        <li><a href="consultasBajas.do" onclick="redirecciona('consultasBajas.do');">1.2 Bajas | Consultas</a></li>
                        <li><a href="capturarAsistencia.do" onclick="redirecciona('capturarAsistencia.do');">1.3 Capturar Asistencia</a></li>
                        <li><a href="asistenciaPosteriorEspecial.do" onclick="redirecciona('asistenciaPosteriorEspecial.do');">1.4 Alta Posterior</a></li>
                        <li><a href="altaLugares.do" onclick="redirecciona('altaLugares.do');">1.4 Catálogo lugares</a></li>
                    </ul>
                </li>
                <li><a href="formatoUnicoAdministrador.do" onclick="redirecciona('formatoUnicoAdministrador.do');">Formato &Uacute;nico</a></li>
                <li><a href="reporteBimestralAdministrador.do" onclick="redirecciona('reporteBimestralAdministrador.do');">Formato Bimestral</a></li>
                <li><a href="administracionAlumnosBecados.do" onclick="redirecciona('administracionAlumnosBecados.do');">Alumnos Becados</a></li>  
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Documentos Finales<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">5.1 Documentos Originales</a></li>
                        <li><a href="liberaciones.do" onclick="redirecciona('liberaciones.do');">Cartas de Liberaci&oacute;n</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sanciones<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="sancionesAlumno.do" onclick="redirecciona('sancionesAlumno.do');">6.1 Administrar Sanciones</a></li>
                        <li><a href="catalogoSanciones.do" onclick="redirecciona('catalogoSanciones.do');">6.2 Cat&aacute;logo de Sanciones</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Bajas Temporales<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="administrarBajas.do" onclick="redirecciona('administrarBajas.do');">7.1 Administrar</a></li>
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">7.2 Cambio de Proyecto</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Organizaciones<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="altaAdminOrganizacion.do" onclick="redirecciona('altaAdminOrganizacion.do');">8.1 Alta Organizaciones</a></li>
                        <li><a href="altaAdminProyectos.do" onclick="redirecciona('altaAdminProyectos.do');">8.2 Alta de Proyectos</a></li>
                        <li><a href="administrarOrganizaciones.do" onclick="redirecciona('administrarOrganizaciones.do');">8.3 Administrar Organizaciones</a></li>
                        <li><a href="administrarProyectos.do" onclick="redirecciona('administrarProyectos.do');">8.4 Administrar Proyectos</a></li>
                        <li><a href="validarOrganizaciones.do" onclick="redirecciona('validarOrganizaciones.do');">8.5 Validar Organizaciones</a></li>
                        <li><a href="validarProyectos.do" onclick="redirecciona('validarProyectos.do');">8.6 Validar Proyectos</a></li>  
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administraci&oacute;n<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">9.1 Administrar Observaciones</a></li>
                        <li><a href="catalogoNoticias.do" onclick="redirecciona('#');">9.2 Noticias</a></li>
                        <li><a href="catalogoConvocatorias.do" onclick="redirecciona('#');">9.3 Convocatorias</a></li>
                    </ul>
                </li>
                <li><a href="historialServicio.do" onclick="redirecciona('#');">Historial Servicio Social</a></li>
                <li><a href="liberaciones.do" onclick="redirecciona('#');">Estadisticas</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Casos Especiales<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">13.1 Egresados</a></li>
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">13.2 Especiales</a></li>
                    </ul>
                </li>
                <li><a href="catalogoObservaciones.do" onclick="redirecciona('catalogoObservaciones.do');">Observaciones</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Noticias<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="altaNoticia.do">Alta Noticias</a></li>
                        <li><a href="consultaNoticias.do">Bajas | Consultas</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Acerca De<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">15.1 Ayuda</a></li>
                        <li><a href="javascript:void(0)" onclick="redirecciona('#');">15.2 Acerca De</a></li>
                    </ul>
                </li>
                <li><a href="cerrarSesion.do" onclick="redirecciona('cerrarSesion.do');">Cerrar Sesi&oacute;n</a></li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>
</div>
</div>


