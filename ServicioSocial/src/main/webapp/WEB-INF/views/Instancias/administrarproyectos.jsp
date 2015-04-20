<%-- 
    Document   : administrarproyectos
    Created on : 26/08/2014, 02:15:49 PM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp" %>
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
      <div class="row">
        <h3>Proyectos pertenecientes a: ${instancia.nombre}</h3>
        ${msgerror}
        <a href="registrarproyecto.do?idInstancia=${idinstancia}" type="button" class="btn btn-primary">Registrar proyecto</a>

        <c:choose>
            <c:when test="${fn:length(proyectos) gt 0}">
                <c:forEach items="${proyectos}" var="proyecto">
                    <br/><br/>
                    <div class="instancia-encontrada">
                      <div class="col-xs-8 instancia-encontrada-title">
                        ${proyecto.nombre}
                      </div>
                      <div class="col-xs-4">
                        <button class="btn btn-warning btn-xs pull-right" 
                                type="button" data-toggle="modal" data-target="#proyd-${proyecto.idProyecto}">
                          Detalles
                        </button>
                      </div>
                      <div class="space-helper"> &nbsp; </div>
                      <div class="col-sm-4">
                        <span class="instancia-encontrada-subtitle">Tipo de proyecto</span><br>
                        <span class="instancia-encontrada-info">${proyecto.idTipoProyecto.descripcion}</span>
                      </div>
                      <div class="col-sm-4">
                        <span class="instancia-encontrada-subtitle">Vacantes</span><br>
                        <span class="instancia-encontrada-info">
                          Hay ${proyecto.vacantesDisponibles} de ${proyecto.vacantes} 
                          vacantes disponibles.</span>
                      </div>
                      <div class="col-sm-4">
                        <span class="instancia-encontrada-subtitle">Activo desde</span><br>
                        <span class="instancia-encontrada-info">${proyecto.fechaAlta}</span>
                      </div>
                      <br><div class="space-helper"> &nbsp; </div>
                      <div class="space-helper"> &nbsp; </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <br/><br/><div class="alert alert-warning">
                  <h4>Esta instancia no tiene proyectos registrados</h4>
                  <br/><a href="registrarproyecto.do?idInstancia=${idinstancia}" class="btn btn-default">Agregar un proyecto</a>
                </div>
            </c:otherwise>
        </c:choose>
      </div>
    </div>
  </body>
</html>
