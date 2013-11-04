<%-- 
    Document   : administrarBajas
    Created on : 12/06/2013, 09:47:42 AM
    Author     : roy
--%>
<%@ include file="../Template/taglibs.jsp" %>


<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />


        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />
        <!--Scripts Datapicker-->
        <script src="js/jqueryUI/jquery.ui.datepicker.js"></script>

        <script type="text/javascript" language="javascript" src="js/bajaTemporal.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $("#tabs").tabs();
                $('#Asignar').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#Quitar').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#fechaBaja').datepicker(
                        {
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
                $('#fechaLimiteBaja').datepicker(
                        {
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

            });
        </script> 
        <title>Administrador</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">
                <div id="tabs">
                    <h1>Asignar Bajas Temporales</h1>
                    <p>En esta secci&oacute;n usted podra asginar bajas temporales</p>
                    <ul>
                        <li><a href="#AsignarBaja">Asignar Bajas</a></li>
                        <li><a href="#QuitarBaja">Quitar Bajas</a></li>
                        <!--                        <li><a href="javascript:void(0)" onclick="redirecciona('#AsignarBaja')">Asignar Bajas</a></li>
                                                <li><a href="javascript:void(0)" onclick="redirecciona('#QuitarBaja')">Quitar Bajas</a></li>-->
                    </ul>
                    <div id="AsignarBaja">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Asignar" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;n</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${alumnos}" var="current">
                                    <tr class='gradeX'>
                                        <th><a href="#bajaTemp" class="fancybox-effects-a  generarBaja" idP="${current.id}" ><img src="imagenes/baja.png" width="30" /></a></th>
                                        <th>${current.datosPersonalesId.nombre} ${current.datosPersonalesId.apellidoP}  ${current.datosPersonalesId.apellidoM}</th>
                                        <th>${current.datosPersonalesId.alumnoId.id}</th>
                                        <th>${current.periodoInicio}</th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div id="QuitarBaja">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Quitar" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;n</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>Periodo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${alumnosBaja}" var="current">
                                    <tr class='gradeX'>
                                        <th><a href="#" class="quitaBaja" idPer="${current.id}" ><img src="imagenes/alta.png" width="30" /></a></th>
                                        <th>${current.datosPersonalesId.nombre} ${current.datosPersonalesId.apellidoP}  ${current.datosPersonalesId.apellidoM}</th>
                                        <th>${current.datosPersonalesId.alumnoId.id}</th>
                                        <th>${current.periodoInicio}</th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
            <div style="clear:both;"></div>
        </div>
        <div id="bajaTemp" style="display: none; font-size: 15px">
            <center> 
                <h1>Asignar Baja Temporal</h1>
                <form:form commandName="bajas" action="guardaBaja.do" method="POST" onsubmit="return validarForm(this);" >
                   <!--guardaBaja.do-->
                    <table>
                        <tr>
                            <td><form:input id="idDatosPer" name="idDatosPer" path="idDatosPer" type="hidden" /></td>
                        </tr>
                        <tr>
                            <td>Fecha de Baja Temporal:</td>
                            <td><form:input id="fechaBaja" name="fechaBaja" path="fechaBaja" /></td>
                            <td><form:errors cssClass="error" path="fechaBaja" /></td>
                        </tr>
                        <tr>
                            <td>Fecha Limite de Baja:</td>
                            <td><form:input id="fechaLimiteBaja" name="fechaLimiteBaja" path="fechaLimiteBaja" readonly="" /></td>
                            <td><form:errors cssClass="error" path="fechaLimiteBaja" /></td>
                        </tr>
                        <tr>
                            <td> 
                                <div class='error' id="erroresFechas" style="display:none;"></div>
                            </td>
                        </tr>
                        <tr> 
                            <td> <input type="submit" value = "Asignar Baja " /> </td>
                        </tr>
                    </table>
                </form:form>
            </center> 
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>

