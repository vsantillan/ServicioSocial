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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Proyectos<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="registrarproyecto.do">Alta Proyecto</a></li>
                        <li><a href="instanciaproyectos.do">Administrar Proyectos</a></li>
                    </ul>
                </li>
                <li><a href="preregistrarinstancia.do">Registrar instancia</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="panelOrganizacion.do" class="dropdown-toggle" data-toggle="dropdown">Organizacion <%=nombre%> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="perfilOrganizacion.do"><span class="glyphicon glyphicon-user"></span> Ver Perfil</a></li>
                        <li><a href="mensajeOrganizacion.do"><span class="glyphicon glyphicon-envelope"></span> Mensajes</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="cerrarSesion.do"><span class="glyphicon glyphicon-log-out"></span> Cerrar Sesión</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse  navbar-right -->
    </div>
</div>