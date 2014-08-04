<%-- 
    Document   : menuPanelUsuario
    Created on : 5/06/2013, 10:50:33 AM
    Author     : roy
--%>
<%@page import="edu.servicio.toluca.beans.ValidaSesion"%>
<%
    HttpSession sesionOk=request.getSession();
    ValidaSesion sesion = new ValidaSesion(sesionOk, request);
    String nombre="";
    String rol="";
    if(sesion.haySesion()){
        nombre=sesionOk.getAttribute("NOMBRE").toString();
        rol=sesionOk.getAttribute("ROL").toString();
    }
%>

<div id="menu">
    <div class="jquerycssmenu">
        <div id="smoothmenu1" class="ddsmoothmenu" >
            <ul>
                <li><a href="index.do">Inicio</a></li>
                <li><a href="convocatorias.do">Convocatorias</a></li>
                <li><a href="manualProcedimiento.do">Manual de Procedimiento</a></li>
                <li><a href="organizaciones.do">Organizaciones</a>
                    <ul>
                        <li><a href="registroOrganizaciones.do">Registro</a></li>
                   </ul>
                </li>
                <li><a href="ayuda.do">Ayuda</a>
                    <ul>
                        <li><a href="ayuda.do">Ayuda</a></li>
                        <li><a href="acercaDe.do">Acerca De</a></li>
                        <li><a href="preguntasFrecuentes.do">Preguntas Frecuentes</a></li>
                   </ul>
                </li>
                <li><a href="contacto.do">Contacto</a></li>
                <% if(sesion.haySesion()){
                        if(sesion.validaAlumno()){
                %>
                            <li><a href="panelUsuario.do">Mi Perfil</a></li>
                        <%}%>
                        <% if(sesion.validaOrganizacion()){ %>
                            <li><a href="panelOrganizacion.do">Organizacion <%=nombre%></a>
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
                            </li>
                        <%}%>
                        <% if(sesion.accesaPanelAdministrador()){ %>
                            <li><a href="panelAdministrador.do">Panel Administrador</a></li>
                        <%}%>
                        <li><a href="cerrarSesion.do">Cerrar Sesión</a></li>
                <%}else{%>
                    <li><a href="login.do">Login</a></li>
                <%}%>                
                
            </ul>
        </div>  
        <br style="clear: left" />
    </div>
</div>
