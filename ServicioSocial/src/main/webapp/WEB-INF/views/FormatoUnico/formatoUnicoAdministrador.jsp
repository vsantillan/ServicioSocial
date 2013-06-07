<%-- 
    Document   : demoAdministrador
    Created on : 07-jun-2013, 10:56:10
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />
        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $('#noRevisadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#aceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>
        <title>Administrador</title>
        
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width:80%;">
                
                <h1>P&aacute;gina del Formato Unico - Administrador</h1>
                <div id="tabs">
                    
                    <ul>
                        <li><a href="#noRevisados">No revisados</a></li>
                        <li><a href="#noAceptados">No aceptados</a></li>
                        <li><a href="#enCorreccion">En correcci&oacute;n</a></li>
                        <li><a href="#aceptados">Aceptados</a></li>
                    </ul>
                    <div id="noRevisados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noRevisadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <td>Periodo</td>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Archivo</th>
                                    <th>Acci&oacute;n</th>
                                    <th>Establecer</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td><a href="algunLado.do" rel="shadowbox"><img src="imagenes/lupa.png"/></a></td>
                                    <td>13-06-07</td>
                                    <td>fui.pdf</td>
                                    <td>
                                        <select>
                                            <option>Selecionar...</option>
                                            <option>Aceptar</option>
                                            <option>Rechazar</option>
                                            <option>Correcci&oacute;n</option>
                                        </select>
                                    </td>
                                    <td><input type="button" value="Modificar"/></td>
                                </tr>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td><a href="algunLado.do" rel="shadowbox"><img src="imagenes/lupa.png"/></a></td>
                                    <td>13-06-07</td>
                                    <td>fui.pdf</td>
                                    <td>
                                        <select>
                                            <option>Selecionar...</option>
                                            <option>Aceptar</option>
                                            <option>Rechazar</option>
                                            <option>Correcci&oacute;n</option>
                                        </select>
                                    </td>
                                    <td><input type="button" value="Modificar"/></td>
                                </tr>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td><a href="algunLado.do" rel="shadowbox"><img src="imagenes/lupa.png"/></a></td>
                                    <td>13-06-07</td>
                                    <td>fui.pdf</td>
                                    <td>
                                        <select>
                                            <option>Selecionar...</option>
                                            <option>Aceptar</option>
                                            <option>Rechazar</option>
                                            <option>Correcci&oacute;n</option>
                                        </select>
                                    </td>
                                    <td><input type="button" value="Modificar"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="noAceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noAceptadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <td>n. Control</td>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Fecha Rechazo</th>
                                    <th>Motivo</th>
                                   

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td>fui.pdf</td>
                                    <td>13-06-07</td>
                                    <td>13-08-09</td>
                                    <td>Instancia no v&aacute;lida</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>    
                    <div id="enCorreccion">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="enCorreccionDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Motivo</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td>fui.pdf</td>
                                    <td>13-06-07</td>
                                    <td>Faltas</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>    
                    <div id="aceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="aceptadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Fecha Aceptaci&oacute;n</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td>fui.pdf</td>
                                    <td>13-06-07</td>
                                    <td>13-06-12</td>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>    
                </div>
                
            </div>
            <div style="clear:both;"></div>
            
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>


        