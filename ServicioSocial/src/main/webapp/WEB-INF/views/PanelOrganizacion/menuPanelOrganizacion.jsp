<%-- 
    Document   : menuPanelOrganizacion
    Created on : 06-jun-2013, 10:26:34
    Author     : bustedvillain
--%>
<%
    HttpSession sesionOk = request.getSession();
    String nombre=sesionOk.getAttribute("NOMBRE")+"";
%>

<div id="menu">
    <div class="jquerycssmenu">
        <div id="smoothmenu1" class="ddsmoothmenu" >
            <ul>
                <li><a href="index.do">Inicio</a></li>
                <li><a href="convocatorias.do">Convocatorias</a></li>
                <li><a href="manualProcedimiento.do">Manual de Procedimiento</a></li>
                <li><a href="ayuda.do">Ayuda</a>

                </li>
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
                <li><a href="cerrarSesion.do">Cerrar Sesi&oacute;n</a></li>
            </ul>
        </div>  
        <br style="clear: left" />
    </div>
</div>
