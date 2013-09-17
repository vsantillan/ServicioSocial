<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cssTablaDetallesOrganizaciones.css" />
    </head>
    <body>
        <div id="muestradatos">
            <center>
                <table class="table">
                    <tr>
                        <td colspan="2">
                            <h2>Detalle de Empresas</h2>
                        </td>
                    </tr>
                    <tr>
                        <td><p>Nombre de la Organizaci&oacute;n</p></td>
                        <td><p><core:out value="${instancia.nombre}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Usuario:</p></td>
                        <td><p><core:out value="${instancia.usuario}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Correo:</p></td>
                        <td><p><core:out value="${instancia.correo}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>RCF:</p></td>
                        <td><p><core:out value="${instancia.rfc}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Titular:</p></td>
                        <td><p><core:out value="${instancia.titular}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Puesto del Titular:</p></td>
                        <td><p><core:out value="${instancia.puesto}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Tel&eacute;fono:</p></td>
                        <td><p><core:out value="${instancia.telefono}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Ext:</p></td>
                        <td><p><core:out value="${instancia.ext}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Domicilio:</p></td>
                        <td><p><core:out value="${instancia.domicilio}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Tipo de Organizaci&oacute;n:</p></td>
                        <td><p><core:out value="${instancia.tipoOrganizacion.detalle}" /></p></td>
                    </tr>
                </table>
            </center>
        </div> 
    </body>
</html>