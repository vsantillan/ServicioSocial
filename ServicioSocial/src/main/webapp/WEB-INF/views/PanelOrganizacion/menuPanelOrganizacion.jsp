<%-- 
    Document   : menuPanelOrganizacion
    Created on : 06-jun-2013, 10:26:34
    Author     : bustedvillain
--%>

<!--%@ include file="../NavegacionPrincipal/menuPrincipal.jsp" %-->

<div id="menu" class="nav navbar-inverse" role="navigation">
  <div class="container">
    <div id="smoothmenu1" class="navbar-inner">
      <ul class="nav navbar-nav" role="navigation">
        <li><a href="panelOrganizacion.do">Inicio</a></li>
        <li><a href="convocatorias.do">Convocatorias</a></li>
        <!--li><a href="preregistrarinstancia.do">Registrar instancia</a></li>
        <li><a href="registrarproyectoa.do">Registrar proyecto</a></li-->
        <li><a href="manualProcedimiento.do">Manual de procedimiento</a></li>
        <li><a href="ayuda.do">Ayuda</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            Usuario organización: ${nombre} <b class="caret"></b>
          </a>
          <ul class="dropdown-menu">
            <li><a href="perfilOrganizacion.do"><span class="glyphicon glyphicon-user"></span> Ver Perfil</a></li>
            <li><a href="mensajeOrganizacion.do"><span class="glyphicon glyphicon-envelope"></span> Mensajes</a></li>
            <li role="presentation" class="divider"></li>
            <li><a href="cerrarSesion.do"><span class="glyphicon glyphicon-log-out"></span> Cerrar Sesión</a></li>                      
          </ul>
        </li>
      </ul>
    </div>  
    <br style="clear: left" />
  </div>
</div>
<%@include file="../General/js.jsp"%>