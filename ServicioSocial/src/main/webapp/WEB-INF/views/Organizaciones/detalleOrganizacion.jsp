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
                            <h2 class="text-info">Detalles de Instancia</h2>
                        </td>
                    </tr>
                    <tr>
                        <th><p>Nombre de la Organizaci&oacute;n</p></th>
                        <td><p><core:out value="${instancia.nombre}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Usuario:</p></th>
                        <td><p><core:out value="${instancia.usuario}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Correo:</p></th>
                        <td><p><core:out value="${instancia.correo}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>RCF:</p></th>
                        <td><p><core:out value="${instancia.rfc}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Titular:</p></th>
                        <td><p><core:out value="${instancia.titular}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Puesto del Titular:</p></th>
                        <td><p><core:out value="${instancia.puesto}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Tel&eacute;fono:</p></th>
                        <td><p><core:out value="${instancia.telefono}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Ext:</p></th>
                        <td><p><core:out value="${instancia.ext}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Domicilio:</p></th>
                        <td><p><core:out value="${instancia.domicilio}" /></p></td>
                    </tr>
                    <tr>
                        <th><p>Tipo de Organizaci&oacute;n:</p></th>
                        <td><p><core:out value="${instancia.tipoOrganizacion.detalle}" /></p></td>
                    </tr>
                </table>
            </div>
            </div>
        </div> 
    </body>
</html>