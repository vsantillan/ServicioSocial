<%-- 
    Document   : administracionAlumnosBecados
    Created on : 7/06/2013, 02:29:54 PM
    Author     : Jonny
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
        <!-- CSS  Shadowbox-->
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        
         <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

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
        <title>Administrar Reportes Bimestrales</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 700px;">
                <div id="tabs">
                    <h1>Administraci&oacute;n de Alumnos Becados</h1>
                    <ul>
                        <li><a href="#preseleccion">Alumnos Preseleccionados</a></li>
                        <li><a href="#aceptados">Alumnos Becados</a></li>
                    </ul>
                    <div id="preseleccion">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Rev" width='100%'>
                            <thead>
                                <tr>
                                    <th>&nbsp;N&uacute;mero de Control&nbsp;</th>
                                    <th>&nbsp;Nombre&nbsp;</th>
                                    <th>&nbsp;Carrera&nbsp;</th>
                                    <th>&nbsp;Promedio&nbsp;</th>
                                    <th>&nbsp;Tipo Servicio&nbsp;</th>
                                    <th>&nbsp;Sexo&nbsp;</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${authors}" var="current">
                                    <tr class='gradeX'>
                                        <td><core:out value="${current.name}" /></td>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.name}" /></td>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.name}" /></td>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><input type="checkbox" name="checkbox" value="checkbox"></td> 
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                        <table>
                            <tr>
                                <td><a href="preseleccionAlumnos.do" rel="shadowbox"><img src="imagenes/agregar.jpg" title="Agregar" width="30"/></td>
                                <td><a href="#" ><img src="imagenes/eliminar.jpg" title="Eliminar" width="29"/></td>
                                <td><a href="correo.do" rel="shadowbox"><img src="imagenes/enviarcorreo.jpg" title="Enviar Correo" width="30"/></td>
                                <td><a href="#" ><img src="imagenes/paloma.png" title="Aceptar Alumno(s)" width="30"/></td>
                                <td><a href="#"><img src="imagenes/excel.jpg" title="Generar Excel" width="30"/></td>
                            </tr>
                        </table>
                    </div>
                    <div id="aceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="NoRev" width='100%'>
                            <thead>
                                <tr>
                                    <th>&nbsp;N&uacute;mero de Control&nbsp;</th>
                                    <th>&nbsp;Nombre&nbsp;</th>
                                    <th>&nbsp;Carrera&nbsp;</th>
                                    <th>&nbsp;Promedio&nbsp;</th>
                                    <th>&nbsp;Tipo Servicio&nbsp;</th>
                                    <th>&nbsp;Sexo&nbsp;</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${authors}" var="current">
                                    <tr class='gradeX'>
                                        <td><core:out value="${current.name}" /></td>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.name}" /></td>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.name}" /></td>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><input type="checkbox" name="checkbox" value="checkbox"></td> 
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                        <table>
                            <tr>
                                <td><a href="#" ><img src="imagenes/enviarcorreo.jpg" title="Enviar Correo" width="30"/></td>
                                <td><a href="#" ><img src="imagenes/imprimir.jpg" title="Imprimir" width="30"/></td>
                                <td><a href="#"><img src="imagenes/excel.jpg" title="Generar Excel" width="30"/></td>
                            </tr>
                        </table>
                    </div>       
                </div>  
            </div>
            <div style="clear:both;"></div>

            <%-- fin del contenido --%>
        </div>
        <jsp:include page="../Template/footer.jsp" />


    </body>
</html>