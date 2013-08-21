<%-- 
    Document   : detalleReporteBimestra
    Created on : 21/08/2013, 10:27:12 AM
    Author     : Regules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
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
                            <h2>Detalle de Reporte Bimestral</h2>
                        </td>
                    </tr>
                    <tr>
                        <td><p>Nombre del alumno:</p></td>
                        <td><p><core:out value="${reportes.datosPersonalesId.nombre} ${reportes.datosPersonalesId.apellidoP} ${reportes.datosPersonalesId.apellidoM}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Número de control:</p></td>
                        <td><p><core:out value="${reportes.datosPersonalesId.alumnoId.id}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Teléfono celular:</p></td>
                        <td><p><core:out value="${reportes.datosPersonalesId.telefonoCel}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Correo:</p></td>
                        <td><p><core:out value="${reportes.datosPersonalesId.correoElectronico}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Número de Reporte</p></td>
                        <td><p><core:out value="${reportes.numeroReporte}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Horas acumuladas:</p></td>
                        <td><p><core:out value="${reportes.horas}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Calificación:</p></td>
                        <td><p><core:out value="${reportes.calificacion}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Fecha Inicio:</p></td>
                        <td><p><core:out value="${reportes.fechaInicio}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Fecha Fin:</p></td>
                        <td><p><core:out value="${reportes.fechaFin}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Fecha de entrega máxima:</p></td>
                        <td><p><core:out value="${reportes.fechaEntregaMax}" /></p></td>
                    </tr>
                    <tr>
                        <td><p>Número de revisiones:</p></td>
                        <td><p><core:out value="${reportes.numeroRevisiones}" /></p></td>
                    </tr>
                </table>
            </center>
        </div> 
    </body>
</html>