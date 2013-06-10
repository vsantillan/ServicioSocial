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
        <script src="js/jqueryUI/jquery.ui.datapicker.js"></script>
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
                $("#datepicker").datepicker({
                    showWeek: true,
                    firstDay: 1
                });
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
                    <form:form name="altaPlatica" id="MyForm" action="#" method="POST">

                        <table>
                            <tr>
                                <td> <label for="fecha">Fecha de Inicio del Reporte</label> </td>
                                <td><input type="text" id="datepicker" /></td>  
                            </tr>
                            <tr>
                                <td>  <label for="hora">Hora</label> </td>
                                <td>  <input type="text" name="hora" id="hora" size="15" /></td>  
                            </tr>
                            <tr>
                                <td>  <label for="lugar">Lugar De la Platica de Inducción</label></td>
                                <td>  <input type="text" name="lugar" id="lugar" size="20" /> </td>  
                            </tr>

                            <tr>
                                <td> <label for="semestre">Periodo</label> </td>
                                <td>
                                    <select id="semestre" name="semestre">
                                        <option value="ENE-JUN">ENE-JUN</option>
                                        <option value="AGO-DIC">AGO-DIC</option>
                                    </select>    
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="ano"> Año  </label> </td>   
                                <td>     
                                    <select id="anio" name="anio">         

                                        <option value="1"><core:out value="hola" /></option>

                                </td>

                            </tr>
                            <tr>
                                <td> <label for="tipoPlatica">Tipo de platica</label> </td>
                                <td> <select id="tipo" name="tipo">
                                        <option  value="NORMAL">Normal</option>
                                        <option  value="BECADO">Becado</option>
                                        <option  value="ESPECIAL">Especial</option>
                                    </select>    
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="descripcion"> Descripción </label> </td>
                                <td>  <textarea  name="descripcion" rows="4" cols="50" id="descripcion"></textarea> </td>  
                            </tr>

                            <tr> 
                                <td>  <label for="fecha_max_fui">Fecha máxima formato unico</label>  </td>
                                <td><input type="text" name="fecha_max_fui" id="datepicker2" size="15" /> </td>
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
                    <form:form name="subirReporte" id="MyForm" action="#" method="POST">
                        <input type="file" id="archivo"/>
                        <input type="submit" value="Enviar"/>
                    </form:form>
                    <h2 class="demoHeaders">Datepicker</h2>
                    <div id="datepicker"></div>
                </div>
            </div>




            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
