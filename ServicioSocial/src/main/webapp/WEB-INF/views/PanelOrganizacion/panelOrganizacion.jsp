<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Bustedvillain
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
  <head
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="../General/head.jsp"%>
    <title>Panel Organización</title>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <%@include file="../General/banner.jsp"%>
        <%@include file="menuPanelOrganizacion.jsp"%>
        <div class="col-md-7">
          <h2>Instancias registradas:</h2>
          <a href="verificarinstancia.do" type="button" class="btn btn-primary">
            Agregar instancia
          </a><br/><br/>

          <!-- Foreach instancia en instancias del usuario -->
          <c:choose>
            <c:when test="${numinstancias > '0'}">
              <c:forEach items="${instanciasu}" var="instancia">
                <c:if test="${instancia.status == '0'}"> <!-- Instancia no validada -->
                  <div class="instancia-encontrada instancia-invalida">
                    <div class="col-xs-8 instancia-encontrada-title">
                      ${instancia.nombre}
                    </div>
                    <div class="col-xs-4">
                      <a href="#" class="btn btn-warning btn-xs pull-right">Detalles</a>
                    </div>
                    <div class="space-helper"> &nbsp; </div>
                    <div class="col-sm-5">
                      <span class="instancia-encontrada-subtitle">RFC de instancia</span><br>
                      <span class="instancia-encontrada-info">${instancia.rfc}</span>
                    </div>
                    <div class="col-sm-2">
                      <span class="instancia-encontrada-subtitle">Teléfono</span><br>
                      <span class="instancia-encontrada-info">${instancia.telefono}</span>
                    </div>
                    <div class="col-sm-5" style="padding-top: 5px">
                      <a href="#" class="btn btn-default pull-right">
                        Administrar proyectos
                      </a>
                      <div class="space-helper"> &nbsp; </div>
                    </div>
                    <br><div class="space-helper"> &nbsp; </div>
                    <div class="space-helper"> &nbsp; </div>
                  </div>
                </c:if>
                <c:if test="${instancia.status == '1'}"> <!-- Instancia aprobada -->
                  <div class="instancia-encontrada instancia-valida">
                    <div class="col-xs-8 instancia-encontrada-title">
                      ${instancia.nombre}
                    </div>
                    <div class="col-xs-4">
                      <a href="#" class="btn btn-warning btn-xs pull-right">Detalles</a>
                    </div>
                    <div class="space-helper"> &nbsp; </div>
                    <div class="col-sm-5">
                      <span class="instancia-encontrada-subtitle">RFC de instancia</span><br>
                      <span class="instancia-encontrada-info">${instancia.rfc}</span>
                    </div>
                    <div class="col-sm-2">
                      <span class="instancia-encontrada-subtitle">Teléfono</span><br>
                      <span class="instancia-encontrada-info">${instancia.telefono}</span>
                    </div>
                    <div class="col-sm-5" style="padding-top: 5px">
                      <a href="#" class="btn btn-primary pull-right">
                        Administrar proyectos
                      </a>
                      <div class="space-helper"> &nbsp; </div>
                    </div>
                    <br><div class="space-helper"> &nbsp; </div>
                    <div class="space-helper"> &nbsp; </div>
                  </div>
                </c:if>
                <c:if test="${instancia.status == '2'}"> <!-- Instancia dada de baja -->
                  <div class="instancia-encontrada instancia-baja">
                    <div class="col-xs-8 instancia-encontrada-title">
                      ${instancia.nombre}
                    </div>
                    <div class="col-xs-4">
                      <a href="#" class="btn btn-warning btn-xs pull-right">Detalles</a>
                    </div>
                    <div class="space-helper"> &nbsp; </div>
                    <div class="col-sm-5">
                      <span class="instancia-encontrada-subtitle">RFC de instancia</span><br>
                      <span class="instancia-encontrada-info">${instancia.rfc}</span>
                    </div>
                    <div class="col-sm-2">
                      <span class="instancia-encontrada-subtitle">Teléfono</span><br>
                      <span class="instancia-encontrada-info">${instancia.telefono}</span>
                    </div>
                    <div class="col-sm-5" style="padding-top: 5px">
                      <a href="#" class="btn btn-default pull-right">
                        Administrar proyectos
                      </a>
                      <div class="space-helper"> &nbsp; </div>
                    </div>
                    <br><div class="space-helper"> &nbsp; </div>
                    <div class="space-helper"> &nbsp; </div>
                  </div>
                </c:if>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <div class="alert alert-warning">
                <h4>Usted no tiene instancias registradas en el sistema</h4>
                <a href="verificarinstancia.do" class="btn btn-default">Registrar instancia</a>
              </div>
            </c:otherwise>
          </c:choose>

        </div>

        <div class="col-md-5">
          <h2>Mensajes recibidos:</h2>
          <div class="alert alert-warning">Por el momento no hay mensajes sin revisar.</div>
        </div>
      </div>
      <br/><br/><%@include file="../General/footer.jsp"%>
    </div>

    <!--script>document.getElementById("password").value = "";</script>
    <script src="js/jquery.codigos.postales.js"></script>       
    <script src="js/jquery.manolo.js"></script-->
  </body>
</html>
