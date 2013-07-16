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
                $('#NoAceptados').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "200%",
                    "bScrollCollapse": true,
                    "bDestroy": true


                });
                $('#Aceptados').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "200%",
                    "bScrollCollapse": true,
                    "bDestroy": true

                });
            });


        </script> 
        
        <script>

            $(function() {
                $('#quitarAlumno').click(function() {
                    var categorias = new Array();

                    $("input[name='checkbox']:checked").each(function() {
                        categorias.push($(this).val());
                    });
                    console.log(categorias);
                    console.log("categorias");
                    $.post("quitarAlumno.do", {categorias: categorias}, function(respuesta) {
                        console.log(respuesta);
                    });
                });
            });
        </script>
        <title>Administraci&oacute;n de Alumnos Becados</title>
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
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="NoAceptados" width='100%'>
                            <thead>
                                <tr>
                                    <th>&nbsp;Fotograf&iacute;a&nbsp;</th>
                                    <th>&nbsp;Nombre&nbsp;</th>
                                    <th>&nbsp;Carrera&nbsp;</th>
                                    <th>&nbsp;Correo Electrónico&nbsp;</th>
                                    <th>&nbsp;Telefono celular&nbsp;</th>
                                    <th>&nbsp;Telefono de Casa&nbsp;</th>
                                    <th>&nbsp;Facebook&nbsp;</th>
                                    <th>&nbsp;Twitter&nbsp;</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${preseleccionado}" var="current">
                                    <tr class='gradeX'>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.correoElectronico}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCel}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCasa}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.facebook}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.twitter}" /></td>
                                        <td><input type="checkbox" name="checkbox" value="${current.id}"></td> 
                                    </tr>
                                </core:forEach>
                            </tbody
                        </table>
                        <table>
                            <tr>
                                <td><a href="preseleccionAlumnos.do" rel="shadowbox"><img src="imagenes/agregar.jpg" title="Agregar" width="30"/></td>
                                <td><a id="quitarAlumno" href="#" ><img src="imagenes/eliminar.jpg" title="Eliminar" width="29"/></td>
                                <td><a id="enviar" href="correo.do" rel="shadowbox"><img src="imagenes/enviarcorreo.jpg" title="Enviar Correo" width="30"/></td>
                                <td><a href="#" ><img src="imagenes/paloma.png" title="Aceptar Alumno(s)" width="30"/></td>
                                <td><a href="#"><img src="imagenes/excel.jpg" title="Generar Excel" width="30"/></td>
                            </tr>
                        </table>
                    </div>
                    <div id="aceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Aceptados" width='100%'>
                            <thead>
                                <tr>
                                    <th>&nbsp;Fotograf&iacute;a&nbsp;</th>
                                    <th>&nbsp;Nombre&nbsp;</th>
                                    <th>&nbsp;Carrera&nbsp;</th>
                                    <th>&nbsp;Correo Electrónico&nbsp;</th>
                                    <th>&nbsp;Telefono celular&nbsp;</th>
                                    <th>&nbsp;Telefono de Casa&nbsp;</th>
                                    <th>&nbsp;Facebook&nbsp;</th>
                                    <th>&nbsp;Twitter&nbsp;</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${preseleccionado}" var="current">
                                    <tr class='gradeX'>
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.correoElectronico}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCel}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCasa}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.facebook}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.twitter}" /></td>
                                        <td><input type="checkbox" name="checkbox" value="${current.id}"></td> 
                                    </tr>
                                </core:forEach>
                            </tbody
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