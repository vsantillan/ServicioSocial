<%-- 
    Document   : menuPreregistroInstancia
    Created on : 21/07/2014, 03:18:07 PM
    Author     : giovanni
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
                <li><a href="index.do" >Inicio</a></li>
                <li class="active"><a href="verificarinstancia.do">Preregistro de instancias</a></li>
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
                <li><a href="cerrarSesion.do">Cerrar Sesión</a></li>

                <%} else {%>

                <li ><a href="login.do">Iniciar Sesión</a></li>
            </ul>
            <%}%> 
            
        </div><!--/.nav-collapse -->
    </div>
</div>
