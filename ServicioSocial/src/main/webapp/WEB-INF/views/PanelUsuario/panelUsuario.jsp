<%-- 
    Document   : panelUsuario
    Created on : 3/06/2013, 10:52:04 AM
    Author     : Jose Manuel Nieto Gomez
--%>
<%
    HttpSession sesionOk = request.getSession();
    String nombre = sesionOk.getAttribute("NOMBRE").toString();
%>
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
                <%@include file="../General/menuUsuario.jsp"%> 
                <%@include file="../General/submenuUsuario.jsp"%>
                <!--------------------------------------------------Contenido--> 
                <div class="bs-docs-section">
                    <div class="page-header">
                        <!---------------------------------------Bienvenido Nombre Usuario-->    
                        <h2 class="text-center" ><span class="label label-info">Bienvenido <%=nombre%></span></h2>
                        <!---------------------------------------Fin Bienvenido Nombre Usuario-->                                     
                    </div>

                    <div class="panel-group" id="accordion">
                        <!---------------------------------------Contenido Noticias Generales------------------->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <h4 class="text-center">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#panelNoticias">
                                            Noticias Generales<span class="badge alert-info pull-right noticiasBadge"></span>
                                        </a>
                                    </h4>
                                </h4>
                            </div>
                            <div id="panelNoticias" class="panel-collapse collapse">
                                <div id="noticias" class="panel-body">
                                    <core:forEach items="${noticiasAlumnos}" var="noticia">
                                        <div class="bs-callout bs-callout-info">
                                            <h4>${noticia.titulo}</h4>
                                            <small>Fecha de publicación: <fmt:formatDate pattern="dd-MM-yyyy" value="${noticia.fecha}"/></small>
                                            <p>${noticia.detalle}</p>
                                        </div>
                                    </core:forEach>
                                </div>
                            </div>
                        </div>

                        <%--<div class="page-header borde-naranja">
                            <h3 class="titulos-naranja">Mensajes Personales</h3>
                            <!---------------------------------------Contenido Mensajes Personales-------------------> 
                            ${mensajePersonal}
                            <!---------------------------------------Fin Contenido Mensajes Personales------------------->
                        </div>--%>

                        <!---------------------------------------Contenido Observaciones------------------->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <h4 class="text-center">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#panelObservaciones">
                                            Observaciones<span class="badge alert-warning pull-right observacionesBadge"></span>
                                        </a>

                                    </h4>
                                </h4>
                            </div>
                            <div id="panelObservaciones" class="panel-collapse collapse">
                                <div id="observaciones" class="panel-body">
                                    <core:forEach items="${observaciones}" var="observacion">
                                        <div class="bs-callout bs-callout-warning">
                                            <h4>${noticia.titulo}</h4>
                                            <small>Fecha de revisión: <fmt:formatDate pattern="dd-MM-yyyy" value="${observacion.fecha}"/></small>
                                            <p>${observacion.catalogoObservacionId.detalle}</p>
                                        </div>
                                    </core:forEach>
                                </div>
                            </div>
                        </div>

                        <!---------------------------------------Contenido Sanciones------------------->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <h4 class="text-center">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#panelSanciones">
                                            Sanciones<span class="badge alert-warning pull-right sancionesBadge"></span>
                                        </a>
                                    </h4>
                                </h4>
                            </div>
                            <div id="panelSanciones" class="panel-collapse collapse">
                                <div id="sanciones" class="panel-body">
                                    <core:forEach items="${sanciones}" var="sancion">
                                        <%--<core:choose>--%>
                                            <%--<core:when  test="${sancion.concepto==0}">--%>
                                                <div class="bs-callout bs-callout-danger">
                                                    <p>${sancion.detalle}</p>
                                                </div>
                                            <%--</core:when>--%>
                                        <%--</core:choose>--%>
                                    </core:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--------------------------------------------------Fin Contenido-------------------------> 
            </div>         
        </div><!--/row--> 
        <%@include file="../General/footer.jsp"%>            
    </div><!--/row-->
</div> <!-- /container -->
<%@include file="../General/js.jsp"%>
<script type="text/javascript" src="js/panelusuario.js"></script>
</body>
</html>
