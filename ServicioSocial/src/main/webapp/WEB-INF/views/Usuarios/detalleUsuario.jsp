<%-- 
    Document   : detalleUsuario
    Created on : 3/03/2015, 10:39:38 AM
    Author     : Jovic
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="row col-md-12 center-block">
                <table class="table table-hover">
                    <tr>
                        <td colspan="2">
                            <h2 class="text-info">Detalles de Usuario</h2>
                        </td>
                    </tr>
                    <tr>
                        <th><p>Nombre de Usuario</p></th>
                        <td><p><core:out value="${usuario.nombre}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Apellido Paterno</p></th>
                        <td><p><core:out value="${ususario.apellidoPat}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Apellido Materno</p></th>
                        <td><p><core:out value="${ususario.apellidoMat}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Puesto</p></th>
                        <td><p><core:out value="${usuario.puesto}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Telefono</p></th>
                        <td><p><core:out value="${usuario.telefono}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Extensión:</p></th>
                        <td><p><core:out value="${usuario.extension}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Email:</p></th>
                        <td><p><core:out value="${usuario.email}" /></p></td>
                    </tr>
                </table>
            </div>
            </div>
        </div> 
    </body>
</html>