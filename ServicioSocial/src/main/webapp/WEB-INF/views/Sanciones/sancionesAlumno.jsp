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
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                <center><h2>Sanciones</h2>  <input type="button" value="  Presiona para Actualizar  " onclick="location.reload()"/></center>
                <h5>A continuaci&oacute;n se muestran los alumnos con sanciones.</h5>
                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                    <thead>
                        <tr>
                            <th>Historial Servicio</th>
                            <th>Sanciones</th>
                            <th>Pago Sanciones</th>
                            <th>No control</th>
                            <th>Nombre</th>
                            <th>Horas restantes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${listaSanciones}" var="current">
                        <tr class='gradeX'>
                            <td><a href="historialServicio.do"  target="_blank"><i class="glyphicon glyphicon-search"></i></a></td>
                            <td><a href="detalleSancionAlumno.do?noControl=${current.idAlumno}&ins=sancion" rel="shadowbox" class="fancyFU"><i class="glyphicon glyphicon-search"></i></a></td>
                            <td><a href="detalleSancionAlumno.do?noControl=${current.idAlumno}&ins=pago" rel="shadowbox" class="fancyFU"><i class="glyphicon glyphicon-search"></i></a></td>
                            
                            <td><core:out value="${current.alumno.id}" /></td>
                            <td><core:out value="${current.alumno.nombre}" /></td>
                            <td><core:out value="${current.horas}" /></td>
                        </tr>
                      </core:forEach>
                    </tbody>
                </table>

                <%-- fin del contenido --%>
            </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
        <%@include file="../Template/headsModal.jsp" %>
    </body>
</html>