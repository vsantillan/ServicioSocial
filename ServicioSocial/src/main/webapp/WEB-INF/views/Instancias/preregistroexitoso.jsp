<%-- 
    Document   : preregistroexitoso
    Created on : 2407/2014, 02:08:42 PM
    Author     : Giovanni Aguirre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <%@include file="../General/head.jsp"%>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <%@include file="../General/banner.jsp"%>
        <%@include file="../PanelOrganizacion/menuPanelOrganizacion.jsp" %>
      </div>
      <br/><br/>
      <div class="alert alert-success" style="text-align: center">
        <h2>
          El preregistro se ha realizado satisfactoriamente. Ahora
          debes esperar a que el administrador valide tu instancia.
          El sistema te notificará via correo electrónico cuando tu
          instancia este aprobada.
        </h2><br/>
        <a href="panelOrganizacion.do" class="btn btn-default">Volver al panel principal</a>
      </div>
      <%@include file="../General/footer.jsp" %>
    </div>

    <!-- Javascript -->
  </body>
</html>
