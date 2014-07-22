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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administraci&oacute;n<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pl&aacute;ticas</a>
                            <ul class="dropdown-menu">
                                <li><a href="altaPlatica.do" onclick="redirecciona('altaPlatica.do');">Nueva Pl&aacute;tica</a></li>
                                <li><a href="consultasBajas.do" onclick="redirecciona('consultasBajas.do');">Eliminar y Consultar Pl&aacute;tica</a></li>
                                <li><a href="capturarAsistencia.do" onclick="redirecciona('capturarAsistencia.do');">Capturar Asistencia</a></li>
                                <li><a href="asistenciaPosteriorEspecial.do" onclick="redirecciona('asistenciaPosteriorEspecial.do');">Alta Posterior</a></li>
                                <li><a href="altaLugares.do" onclick="redirecciona('altaLugares.do');">Catálogo lugares</a></li>
                            </ul>
                        </li>
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Noticias</a>
                            <ul class="dropdown-menu">
                                <li><a href="altaNoticia.do">Alta Noticias</a></li>
                                <li><a href="consultaNoticias.do">Bajas | Consultas</a></li>
                            </ul>
                        </li>
                        <li><a href="catalogoObservaciones.do" onclick="redirecciona('catalogoObservaciones.do');">Observaciones</a></li>
                        <li class="dropdown-submenu"></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Alumnos<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="administracionAlumnosBecados.do" onclick="redirecciona('administracionAlumnosBecados.do');">Alumnos Becados</a></li>
                        <li><a href="formatoUnicoAdministrador.do" onclick="redirecciona('formatoUnicoAdministrador.do');">Formato &Uacute;nico</a></li>
                        <li><a href="reporteBimestralAdministrador.do" onclick="redirecciona('reporteBimestralAdministrador.do');">Formato Bimestral</a></li>
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Documentos Finales</a>
                            <ul class="dropdown-menu">
                                <li><a href="documentosFinales.do" onclick="redirecciona('documentosFinales.do');">Documentos Finales</a></li>
                                <li><a href="alumnosCartasLiberacion.do" onclick="redirecciona('alumnosCartasLiberacion.do');">Cartas de Liberaci&oacute;n</a></li>
                            </ul>
                        </li>
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Bajas Temporales</a>
                            <ul class="dropdown-menu">
                                <li><a href="administrarBajas.do" onclick="redirecciona('administrarBajas.do');">Administrar</a></li>
                                <li><a href="cambioDependencia.do" onclick="redirecciona('cambioDependencia.do');">Cambio de Instancia</a></li>
                            </ul>
                        </li>
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Casos Especiales</a>
                            <ul class="dropdown-menu">
                                <li><a href="egresadoAdministrador.do">Egresados</a></li>
                            </ul>
                        </li>
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sanciones</a>
                            <ul class="dropdown-menu">
                                <li><a href="asignarSancion.do">Asignar Sanciones</a></li>
                                <li><a href="sancionesAlumno.do" onclick="redirecciona('sancionesAlumno.do');">Administrar Sanciones</a></li>
                                <li><a href="catalogoSanciones.do">Cat&aacute;logo de Sanciones</a></li>
                            </ul>
                        </li>
                        <li class="dropdown-submenu"></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Instancias<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Organizaciones</a>
                            <ul class="dropdown-menu">
                                <li><a href="altaAdminOrganizacion.do">Alta Organizaciones</a></li>
                                <li><a href="administrarOrganizaciones.do">Administrar Organizaciones</a></li>
                                <li><a href="validarOrganizaciones.do">Validar Organizaciones</a></li>
                            </ul>
                        </li>
                        <li class="dropdown-submenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Proyectos</a>
                            <ul class="dropdown-menu">
                                <li><a href="altaAdminProyectos.do">Alta de Proyectos</a></li>
                                <li><a href="administrarProyectos.do">Administrar Proyectos</a></li>
                                <li><a href="validarProyectos.do">Validar Proyectos</a></li>  
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="historialServicio.do" >Historial Servicio Social</a></li>
                        <li><a href="estadisticas.do">Estadisticas</a></li>
                    </ul>
                </li>
                </li>
                <li><a href="cerrarSesion.do" onclick="redirecciona('cerrarSesion.do');">Cerrar Sesi&oacute;n</a></li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>
</div>
</div>


