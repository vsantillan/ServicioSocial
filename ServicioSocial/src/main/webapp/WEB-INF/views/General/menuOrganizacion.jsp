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
                        <li><a href="altaProyecto.do">Alta Proyecto</a></li>
                        <li><a href="verProyectos.do">Ver Proyectos</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="panelOrganizacion.do" class="dropdown-toggle" data-toggle="dropdown">Organizacion <%=nombre%> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="panelOrganizacion.do">Ver Perfil</a></li>
                        <li><a href="mensajeOrganizacion.do">Mensajes</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="cerrarSesion.do">Cerrar Sesión</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse  navbar-right -->
    </div>
</div>