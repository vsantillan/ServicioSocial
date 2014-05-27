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
                <center class="row help-block  text-center" ><h2>Sanciones</h2></center>
                <h5 class="alert alert-warning">A continuaci&oacute;n se muestran los alumnos con sanciones.</h5>
                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' width='100%'>
                    <thead>
                        <tr>
                            <th>No.Control</th>
                            <th>Nombre</th>
                            <th>Detalle Sancion</th>
                            <th>Horas restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${listaSanciones}" var="current">
                        <tr class='gradeX'>
                            <td><core:out value="${current.datosPersonalesId.alumnoId.id}" /></td>
                            <td><core:out value="${current.datosPersonalesId.nombre}${espacio}${current.datosPersonalesId.apellidoP}${espacio}${current.datosPersonalesId.apellidoM}" /></td>
                            <td><core:out value="${current.catalogoSancionesId.detalle}" /></td>
                            <td><core:out value="${current.horasSancion}" /></td>
                            <td>
                                <a href="quitarSancion.do?idSancion=${current.id}"> <span class="glyphicon glyphicon-remove sizeIcon"  title="Quitar Sanción"></span></a>
                                <a href="pagoSancion.do?idSancion=${current.id}" class="fancy"><span class="glyphicon glyphicon-edit sizeIcon" title="Pagar Sanción"></span></a> 
                            </td>
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
         
</html>