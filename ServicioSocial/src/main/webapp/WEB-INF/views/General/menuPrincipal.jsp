<%-- 
    Document   : menuPrincipal
    Created on : 22/01/2014, 03:51:26 PM
    Author     : Jonny
--%>
<%@page import="edu.servicio.toluca.beans.ValidaSesion"%>
<%
    HttpSession sesionOk = request.getSession();
    ValidaSesion sesion = new ValidaSesion(sesionOk, request);
    String nombre = "";
    String rol = "";
    if (sesion.haySesion()) {
        nombre = sesionOk.getAttribute("NOMBRE").toString();
        rol = sesionOk.getAttribute("ROL").toString();
    }
%>
<div class="nav navbar-inverse " role="navigation">
    <div class="container">
        <div class="navbar-inner">
            <ul class="nav navbar-nav " role="navigation">
                <li class="active"><a href="index.do" >Inicio</a></li>
                <li><a href="manualProcedimiento.do">Manual de Procedimiento</a></li>
<!--                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Organizaciones <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="registroOrganizaciones.do">Registro</a></li>
                    </ul>
                </li>-->
<!--                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Ayuda <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="ayuda.do">Ayuda</a></li>
                        
                    </ul>
                </li>-->

                <li><a href="contacto.do">Contacto</a></li>
                    <% if (sesion.haySesion()) {
                            if (sesion.validaAlumno()) {
                    %>
                <li><a href="panelUsuario.do">Mi Perfil</a></li>
                    <%}%>
                    <% if (sesion.validaOrganizacion()) {%>
<!--                <li><a href="panelOrganizacion.do">Organizacion <%=nombre%></a>
                    <ul>
                        <li><a href="panelOrganizacion.do">Ver Perfil</a></li>
                        <li><a href="mensajeOrganizacion.do">Mensajes</a></li>
                        <li><a href="javascript:void(0);">Proyectos</a>
                            <ul>
                                <li><a href="altaProyecto.do">Alta Proyecto</a></li>
                                <li><a href="verProyectos.do">Ver Proyectos</a></li>
                            </ul>
                        </li>                        
                    </ul>
                </li>-->
                <%}%>
                <% if (sesion.accesaPanelAdministrador()) {%>
                <li><a href="panelAdministrador.do">Panel Administrador</a></li>
            
            <%}%>
                <li><a href="cerrarSesion.do">Cerrar Sesi&oacute;n</a></li>

                <%} else {%>

                <li ><a href="login.do">Iniciar Sesión</a></li>
            </ul>
            <%}%> 
            
        </div><!--/.nav-collapse -->
    </div>
</div>
