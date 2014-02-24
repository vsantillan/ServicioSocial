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
                        <h1 class="derecha" >Bienvenido <%=nombre%></h1>
                        <!---------------------------------------Fin Bienvenido Nombre Usuario-->                                     
                    </div>
                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Noticias Generales</h3>
                        <!---------------------------------------Contenido Noticias Generales-------------------> 
                        <core:forEach items="${noticiasAlumnos}" var="noticia">
                            <li ><b><fmt:formatDate pattern="dd-MM-yyyy" value="${noticia.fecha}"/></b>: ${noticia.detalle}</li>
                                </core:forEach>
                        <!---------------------------------------Fin Contenido Noticias Generales------------------->
                    </div>          

                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Mensajes Personales</h3>
                        <!---------------------------------------Contenido Mensajes Personales-------------------> 
                        ${mensajePersonal}
                        <!---------------------------------------Fin Contenido Mensajes Personales------------------->
                    </div>
                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Observaciones</h3>
                        <!---------------------------------------Contenido Observaciones----------------------------->
                        <core:forEach items="${observaciones}" var="observacion">
                            <li ><b><fmt:formatDate pattern="dd-MM-yyyy" value="${observacion.fecha}"/></b>: ${observacion.catalogoObservacionId.detalle}</li>
                                </core:forEach>
                        <!---------------------------------------Fin Contenido Observaciones------------------->
                    </div>
                    <div class="page-header  borde-naranja">
                        <h3 class="titulos-naranja">Sanciones</h3>
                        <!---------------------------------------Contenido Sanciones----------------------------->
                        <core:forEach items="${sanciones}" var="sancion">
                            <core:choose>
                                <core:when  test="${sancion.concepto==0}">
                                    <li ><b><fmt:formatDate pattern="dd-MM-yyyy" value="${sancion.fecha}"/></b>: ${sancion.detalle}</li>
                                        </core:when>    
                                        <core:when  test="${sancion.concepto==1}">
                                    <li ><b><fmt:formatDate pattern="dd-MM-yyyy" value="${sancion.fecha}"/></b>: ${sancion.detalle}</li>
                                        </core:when> 
                                    </core:choose> 
                                </core:forEach>
                        <!---------------------------------------Fin Contenido Sanciones------------------->
                    </div>
                </div>
                <!--------------------------------------------------Fin Contenido-------------------------> 
            </div>         
        </div><!--/row--> 
        <%@include file="../General/footer.jsp"%>            
    </div><!--/row-->
</div> <!-- /container -->
<%@include file="../General/js.jsp"%>
</body>
</html>
