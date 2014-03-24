<%-- 
    Document   : menuOrganizacion
    Created on : 27/02/2014, 04:16:33 PM
    Author     : rodrigo
--%>
<%
    HttpSession sesionOk = request.getSession();
    String nombre = sesionOk.getAttribute("NOMBRE").toString();
%>
<div class="nav navbar-inverse " role="navigation">
    <div class="container">
        <div class="navbar-inner">
            <ul class="nav navbar-nav" role="navigation">                                
                <li><a href="#">Inicio</a></li>
                <li><a href="#">Manual de Procedimiento</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Organizaciones<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="ayuda.do">Registro</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Ayuda<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="ayuda.do">Ayuda</a></li>
                        <li><a href="acercaDe.do">Acerca De</a></li>
                    </ul>
                </li>
                <li><a href="contacto.do">Contacto</a></li>
                <li class="dropdown">
                    <a href="panelOrganizacion.do" class="dropdown-toggle" data-toggle="dropdown">Organizacion <%=nombre%> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="panelOrganizacion.do">Ver Perfil</a></li>
                        <li><a href="mensajeOrganizacion.do">Mensajes</a></li>
                        <li role="presentation" class="divider"></li>
                        <li role="presentation" class="dropdown-header">Proyectos</li>
                                <li><a href="altaProyecto.do">Alta Proyecto</a></li>
                                <li><a href="verProyectos.do">Ver Proyectos</a></li>
                                                 
                    </ul>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="cerrarSesion.do">Cerrar Sesión</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>