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
            <p>A continuación generarás un reporte bimestral, una vez sea descargado, 
                debes acudir a la instancia donde realizas tu servicio social para que sea firmado y sellado por el responsable del programa. 
                Una vez que este listo deberás escanearlo ya sea en formato: png, jpg, gif, pdf y subirlo en la sección de "Anexar Reporte"
            </p>
            <div id="tabs">
                <ul>
                    <li><a href="#Generar">Generar Reporte Bimestral</a></li>
                    <li><a href="#Subir">Anexar Reporte</a></li>
                </ul>
                <div id="Generar">
                    <h1>Generar Reporte</h1>
                    <p>Introduzca los datos requeridos para llenar su formulario</p>
                    <form:form commandName="Reportes" name="reportesBimestrales" id="reportesBimestrales"  action="insertaReporte.do" method="POST" target="_blank">

                        <table>
                            <h4>N&uacute;mero de Revisiones del Reporte: ${noReviciones}</h4>
                            <tr>
                                <td><label for="noReporte">No de Reporte:</label></td>
                                <td><form:input path="numeroReporte" type="text" name=" numeroReporte" id=" numeroReporte"  value="${numeroReporte}" readonly="true" /></td>
                            </tr>
                            <tr>
                                <td> <label for="fecha">Fecha de Inicio del Reporte:</label> </td>
                                <core:choose>
                                    <core:when test="${empty fechaInicio}">
                                        <td><form:input path="fechaInicio" type="text"  name="fechaInicio" readonly="true"  onchange="actualizaFecha(this)" />
                                            <form:errors path="fechaInicio" cssClass="error"/>  
                                        </td>  
                                    </core:when>
                                    <core:otherwise>
                                        <td><form:input path="fechaInicio" type="text"  name="fechaInicio" readonly="true"  onchange="actualizaFecha(this)" />
                                            <form:errors path="fechaInicio" cssClass="error"/> 
                                        </td>  
                                    </core:otherwise>
                                </core:choose>                                   
                                <td> <label for="fecha">Fecha Limite del  Reporte:</label> </td>
                                <td><form:input path="fechaFin" type="text" name="fechaFin" id="fechaFin" readonly="true"   />
                                    <form:errors path="fechaFin" cssClass="error"/> 
                                </td> 
                            </tr>
                            <tr>
                                <td><label for="horasA">Horas del Reporte:</label></td>
                                <td>
                                    <form:input path="horas" type="text" name="horasReporte" />
                                    <form:errors path="horas" cssClass="error"/>
                                </td>
                                <td><label for="horasAcumuluadas">Horas Acumuladas:</label></td>
                                <td><form:input path="horasAcumuladas" type="text" name="horasAcumuladas" id="horasAcumuladas" readonly="true" value="${horasAcumuladas}"  />
                                    <form:errors path="horasAcumuladas" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="actividad">Actividades:</label></td>
                                <td>
                                    <fieldset>
                                        <select name="selectfrom" id="select-from" multiple size="5" >
                                            <core:forEach items="${datosPersonales}" var="current">
                                                <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                                    <core:forEach items="${formato.idproyecto.actividadesCollection}" var="actividades" >
                                                        <option value="${actividades.idActividad}">${actividades.detalle}</option>
                                                    </core:forEach>
                                                </core:forEach>
                                            </core:forEach>
                                        </select>
                                        
                                        <a href="JavaScript:void(0);" id="btn-add">&laquo; Quitar</a>
                                        <a href="JavaScript:void(0);" id="btn-remove">Agregar &raquo;</a>
                                        
                                        

                                        <select name="selectto" id="select-to" multiple size="5">
                                        </select>
                                    </fieldset>
                                </td>
                                <td>${errorActividades}</td>
                            </tr>
                            <core:forEach items="${datosPersonales}" var="current">
                                <core:forEach items="${current.formatoUnicoCollection}" var="formato">
                                    <core:choose>
                                        <core:when test="${formato.catalogoPlanId.detalle=='S'}" >
                                            <tr>
                                                <td><label for="calificacion">Calificaci&oacute;n</label></td>
                                                <td>
                                                    <form:input path="calificacion" type="text" name="actividad" />
                                                    <form:errors path="calificacion" cssClass="error"/>
                                                </td>                                            
                                            </tr>
                                        </core:when> 
                                        <core:otherwise>
                                            <tr>
                                                <td><label for="calificacion">Calificaci&oacute;n</label></td>
                                                <td>
                                                    <form:input path="calificacion" type="text" name="actividad" readonly="true"  />
                                                    <form:errors path="calificacion" cssClass="error"/>
                                                </td>                                            
                                            </tr>
                                        </core:otherwise>
                                    </core:choose>

                                </core:forEach>
                            </core:forEach>  
                            <form:input path="actividades" hidden="hidden" name="nActividades" id="nActividades" value="0" />
                            <tr> 
                                <td> <input type ="submit" value = "Generar Reporte" id="envia"  /></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="Subir">
                    <h1>Subir Reporte</h1>
                    <p>Seleccione su Reporte Bimestral</p>
                    <form:form name="subirReporte" id="MyForm" action="guardarReporteBimestral.do" method="POST" enctype="multipart/form-data">
                        <input type="file" name="file" value="Buscar Reporte" />
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
            
                    $('input#envia').click(function() {
            $('#select-from option').each(function()
            {
                $(this).attr("selected", "selected");
            });
        });
  


        </script>
    </body>
</html>
<!--Id 1 Id2 ---!>