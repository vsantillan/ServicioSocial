<%-- 
    Document   : formatoReporteBimestral
    Created on : 5/06/2013, 02:14:42 PM
    Author     : roy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <!--CSS datepicker--->

        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>

        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" /><!--Hay conflicto de datatables con estilo forms--->
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <!--Scripts Datapicker-->
        <script src="js/jqueryUI/jquery.ui.datepicker.js"></script>
        <script type="text/javascript" language="javascript" src="js/reportesBimestrales.js"></script>
        <script type="text/javascript">

            $(document).ready(function() {

                $("#tabs").tabs();
                $('#Rev').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#NoRev').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script> 
        <script>
            $(function() {
                // $('#datepicker').datepicker();
                $('#datepicker').datepicker({
                    closeText: 'Cerrar',
                    prevText: 'Anterior',
                    nextText: 'Siguiente',
                    currentText: 'Hoy',
                    dateFormat: 'yy-mm-dd',
                    monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                    dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                    dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
                    minDate: 0


                });
                $('#formPlatica').formly();
            });
        </script>

        <title>Reportes Bimestrales</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <h1>Reporte Bimestral</h1>
            <div id="tabs">
                <ul>
                    <li><a href="#Generar">Generar Reporte Bimestral</a></li>
                    <li><a href="#Subir">Anexar Reporte</a></li>
                </ul>
                <div id="Generar">
                    <h1>Generar Reporte</h1>
                    <p>Introduzca los datos requeridos para llenar su formulario</p>
                    <form:form name="reportesBimestrales" id="reportesBimestrales"  action="#" method="POST">

                        <table>
                            <tr>
                                <td> <label for="fecha">Fecha de Inicio del Reporte:</label> </td>
                                <core:choose>
                                    <core:when test="${empty fechaInicio}">
                                        <td><input type="text"  name="fechaInicio"id="datepicker" value="" onchange="actualizaFecha(this)" /></td>  
                                    </core:when>
                                    <core:otherwise>
                                             <td><input type="text"  name="fechaInicio"id="datepicker" disabled="disabled" value="${fechaInicio}" onchange="actualizaFecha(this)" /></td>  
                                    </core:otherwise>
                                </core:choose>                                   
                                <td> <label for="fecha">Fecha Limite del  Reporte:</label> </td>
                                <td><input type="text" name="fechaFin" id="fechaFin" disabled="disabled" value="${fechaFin}"  /></td> 
                            </tr>
                            <tr>
                                <td><label for="horasA">Horas del Reporte:</label></td>
                                <td><input type="text" name="horasReporte" /></td>
                            </tr>
                            <tr>
                                <td><label for="actividad">Actividades:</label></td>
                                <td>
                                    <fieldset>
                                        <select name="selectfrom" id="select-from" multiple size="5">
                                            <core:forEach items="${datosPersonales}" var="current">
                                                <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                                    <core:forEach items="${formato.idproyecto.actividadesCollection}" var="actividades" >
                                                        <option value="${actividades.idActividad}">${actividades.detalle}</option>
                                                    </core:forEach>
                                                </core:forEach>
                                            </core:forEach>
                                        </select>

                                        <a href="JavaScript:void(0);" id="btn-add">Agregar &raquo;</a>
                                        <a href="JavaScript:void(0);" id="btn-remove">&laquo; Quitar</a>

                                        <select name="selectto" id="select-to" multiple size="5">
                                        </select>
                                    </fieldset>


                                </td>
                            </tr>
                            <core:forEach items="${datosPersonales}" var="current">
                                <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                    <core:choose>
                                        <core:when test="${formato.catalogoPlanId.detalle=='S'}" >
                                            <tr>
                                                <td><label for="calificacion">Calificaci&oacute;n</label></td>
                                                <td><input type="text" name="actividad" /></td>                                            
                                            </tr>
                                        </core:when> 
                                    </core:choose>

                                </core:forEach>
                            </core:forEach>  
                            <tr> 
                                <td> <input type ="submit" value = "Generar Reporte" /> </td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="Subir">
                    <h1>Subir Reporte</h1>
                    <p>Seleccione su Reporte Bimestral</p>
                    <form:form name="subirReporte" id="MyForm" action="#" method="POST">
                        <input type="file" id="archivo"/>
                        <input type="submit" value="Enviar"/>
                    </form:form>
                </div>
            </div>




            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
        <script>
            $('a#btn-add').click(function() {
                $('#select-from option:selected').each(function() {
                    $('#select-to').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
            $('a#btn-remove').click(function() {
                $('#select-to option:selected').each(function() {
                    $('#select-from').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
        </script>
    </body>
</html>
<!--Id 1 Id2 ---!>