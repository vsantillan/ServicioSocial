<%-- 
    Document   : proregexitoso
    Created on : 25/08/2014, 04:40:06 PM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <%@include file="../General/head.jsp" %>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <%@include file="../General/banner.jsp" %>
        <%@include file="../PanelOrganizacion/menuPanelOrganizacion.jsp" %>
      </div>
      <div class="row">
        <br/><br/>
        <div class="alert alert-success">
          <h2>El proyecto ha sido registrado exitosamente.</h2><br/>
          <a href="panelOrganizacion.do" class="btn btn-default">Volver al panel de inicio</a>
        </div>
      </div>
      <%@include file="../General/footer.jsp" %>
    </div>
  </body>
</html>
