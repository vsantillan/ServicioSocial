<%-- 
    Document   : formatoReporteBimestral
    Created on : 5/06/2013, 02:14:42 PM
    Author     : roy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <!--CSS datepicker--->

        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>

        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <!--Scripts Datapicker-->
        <script src="js/jqueryUI/jquery.ui.datepicker.js"></script>
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
                $("#datepicker").datepicker();
            });
        </script>

        <title>Reportes Bimestrales</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
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
                    <form:form name="altaPlatica" id="MyForm" action="#" method="POST">

                        <table>
                            <tr>
                                <td> <label for="fecha">Fecha de Inicio del Reporte</label> </td>
                                <td><input type="text"  name="fechaInicio"id="datepicker" /></td>  
                                <td> <label for="fecha">Fecha de Fin del Reporte</label> </td>
                                <td><input type="text" name="fechaFin" disabled="disabled" value="13/03/1991"/></td> 
                            </tr>
                            <tr>
                                <td><label for="horasA">Horas del Reporte</label></td>
                                <td><input type="text" name="horasReporte" /></td>
                            </tr>
                            <tr>
                                <td><label for="actividad">Actividad</label></td>
                                <td><select name="actividad">
                                        <option value="1">Cierta Actividad1</option>
                                        <option value="2">Cierta Actividad2</option>
                                        <option value="3">Cierta Actividad3</option>
                                    </select></td>
                            </tr>

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
    </body>
</html>