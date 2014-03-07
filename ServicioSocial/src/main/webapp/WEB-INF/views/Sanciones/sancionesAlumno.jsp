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
                <h1>Sanciones <input type="button" value="  Presiona para Actualizar  " onclick="location.reload()"/></h1> 
                <p>A continuaci&oacute;n se muestran los alumnos con sanciones, de click en "Detalles" para ver sus reportes o click en "Pagar" para agregar reportes de pago de servicio.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
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
                            <th><a href="historialServicio.do"  target="_blank"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="detalleSancionAlumno.do?noControl=${current.idAlumno}&ins=sancion" rel="shadowbox" class="fancyFUI"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="detalleSancionAlumno.do?noControl=${current.idAlumno}&ins=pago" rel="shadowbox" class="fancyFUI"><img src="imagenes/lupa.png" width="30"/></a></th>
                            
                            <th><core:out value="${current.alumno.id}" /></th>
                            <th><core:out value="${current.alumno.nombre}" /></th>
                            <th><core:out value="${current.horas}" /></th>
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
    </body>
</html>