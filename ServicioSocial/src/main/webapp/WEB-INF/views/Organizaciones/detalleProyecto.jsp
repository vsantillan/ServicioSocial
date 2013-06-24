<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/cssTablaDetallesOrganizaciones.css" />
    </head>
    <body>
        <div id="muestradatos">
            <table class="table">
                <tr>
                    <td colspan="2">
                        <h2>Detalle de Proyectos</h2>
                    </td>
                </tr>
                <tr>
                    <td><p>Nombre del Proyecto:</p></td>
                    <td><p>Sextor</p></td>
                </tr>
                <tr>
                    <td><p>N&uacute;mero de vacantes:</p></td>
                    <td><p><core:out value="${proyectoDetalle.vacantes}"/></p></td>
                </tr>
                <tr>
                    <td><p>N&uacute;mero de vacantes disponibles:</p></td>
                    <td><p><core:out value="${proyectoDetalle.vacantesDisponibles}"/></p></td>
                </tr>
                <tr>
                    <td><p>Titular:</p></td>
                    <td><p><core:out value="${proyectoDetalle.idInstancia.titular}"/></p></td>
                </tr>
                <tr>
                    <td><p>Puesto del Titular:</p></td>
                    <td><p><core:out value="${proyectoDetalle.idInstancia.puesto}"/></p></td>
                </tr>
                <tr>
                    <td><p>Tel&eacute;fono:</p></td>
                    <td><p><core:out value="${proyectoDetalle.idInstancia.telefono}"/></p></td>
                </tr>
                <tr>
                    <td><p>Instancia:</p></td>
                    <td><p><core:out value="${proyectoDetalle.idInstancia.nombre}"/></p></td>
                </tr>
                <tr>
                    <td><p>Domicilio de la Instancia:</p></td>
                    <td><p><core:out value="${proyectoDetalle.domicilio}"/></p></td>
                </tr>
                <tr>
                    <td><p>Actividades:</p></td>
                    <td><p><core:out value="${proyectosDetalle.actividadesCollection.detalle}"/></p></td>
                </tr>
                <tr>
                    <td><p>Horario:</p></td>
                    <td><p>Alg&uacute;n Domicilio</p></td>
                </tr>
                <tr>
                    <td><p>Responsable del Programa:</p></td>
                    <td><p><core:out value="${proyectoDetalle.nombreResponsable}"/></p></td>
                </tr>
                <tr>
                    <td><p>Puesto del Responsable:</p></td>
                    <td><p><core:out value="${proyectoDetalle.responsablePuesto}"/></p></td>
                </tr>
                <tr>
                    <td><p>Tel&eacute;fono del Responsable:</p></td>
                    <td><p><core:out value="${proyectoDetalle.telefonoResponsable}"/></p></td>
                </tr>
                <tr>
                    <td><p>Domicilio del programa:</p></td>
                    <td><p><core:out value="${proyectoDetalle.domicilio}"/></p></td>
                </tr>
                <tr>
                    <td><p>C&oacute;digo Postal:</p></td>
                    <td><p><core:out value="${proyectoDetalle.idColonia.idCp.cp}"/></p></td>
                </tr>
                <tr>
                    <td><p>Tipo de Proyecto</p></td>
                    <td><p>Alg&uacute;n Domicilio</p></td>
                </tr>
                <tr>
                    <td><p>Perfil buscado:</p></td>
                    <td><p>Alg&uacute;n Domicilio</p></td>
                </tr>
            </table>
        </div> 
    </body>
</html>