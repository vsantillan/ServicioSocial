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


        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" /> 

        <title>Administraci&oacute;n de Alumnos Becados</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id ="contenido" align="left">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%;">
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
                                    <th>&nbsp;</th>
                                    <th>&nbsp;Fotograf&iacute;a&nbsp;</th>
                                    <th>&nbsp;Nombre&nbsp;</th>
                                    <th>&nbsp;Carrera&nbsp;</th>
                                    <th>&nbsp;Correo Electrónico&nbsp;</th>
                                    <th>&nbsp;Telefono celular&nbsp;</th>
                                    <th>&nbsp;Telefono de Casa&nbsp;</th>
                                    <th>&nbsp;Facebook&nbsp;</th>
                                    <th>&nbsp;Twitter&nbsp;</th>

                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${preseleccionado}" var="current">
                                    <tr class='gradeX'>
                                        <td><input type="checkbox" name="checkbox" value="${current.id}"></td> 
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.correoElectronico}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCel}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCasa}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.facebook}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.twitter}" /></td>

                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                        <table>
                            <tr>
                                <td><a href="preseleccionAlumnos.do" class="fancy"><img src="imagenes/agregar.jpg" title="Agregar" width="30"/></a></td>
                                <td><a id="quitarAlumno" href="#" ><img src="imagenes/eliminar.jpg" title="Eliminar" width="29"/></a></td>
                                <td><a  href="correo.do" rel="shadowbox"><img src="imagenes/enviarcorreo.jpg" title="Enviar Correo" width="30"/></a></td>
                                <td><a id="aceptarAlumno" href="#" ><img src="imagenes/paloma.png" title="Aceptar Alumno(s)" width="30"/></a></td>
                                <td><a href="#"><img src="imagenes/excel.jpg" title="Generar Excel" width="30"/></a></td>

                            </tr>
                        </table>
                    </div>
                    <div id="aceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="Aceptados" width='100%'>
                            <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;Fotograf&iacute;a&nbsp;</th>
                                    <th>&nbsp;Nombre&nbsp;</th>
                                    <th>&nbsp;Carrera&nbsp;</th>
                                    <th>&nbsp;Correo Electrónico&nbsp;</th>
                                    <th>&nbsp;Telefono celular&nbsp;</th>
                                    <th>&nbsp;Telefono de Casa&nbsp;</th>
                                    <th>&nbsp;Facebook&nbsp;</th>
                                    <th>&nbsp;Twitter&nbsp;</th>

                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${becado}" var="current">
                                    <tr class='gradeX'>
                                        <td><input type="checkbox" name="checkbox" value="${current.id}"></td> 
                                        <td><core:out value="${current.id}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.correoElectronico}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCel}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.telefonoCasa}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.facebook}" /></td>
                                        <td><core:out value="${current.datosPersonalesId.twitter}" /></td>

                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                        <table>
                            <tr>

                                <td><a href="correo.do" ><img src="imagenes/enviarcorreo.jpg" title="Enviar Correo" width="30"/></a></td>
                                <td><a href="#" ><img src="imagenes/imprimir.jpg" title="Imprimir" width="30"/></a></td>
                                <td><a href="#"><img src="imagenes/excel.jpg" title="Generar Excel" width="30"/></a></td>

                            </tr>
                        </table>
                    </div>       
                </div>  
            </div>
        </div>
        <div style="clear:both;"></div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
        <script type="text/javascript" language="javascript" src="js/becados.js"></script> 
        <div id="preseleccionado" style="display: none; ">
            <h1>Preselecci&oacute;n de Alumnos Becados</h1> 
            <div>
                <form:form id="form1" action="preseleccionadoBD.do" commandName="alumnoP" method="POST" >

                    <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                        <thead>
                            <tr>
                                <th>&nbsp;</th>
                                <th>&nbsp;Fotograf&iacute;a&nbsp;</th>
                                <th>&nbsp;N&uacute;mero de Control&nbsp;</th>
                                <th>&nbsp;Nombre&nbsp;</th>
                                <th>&nbsp;Carrera&nbsp;</th>
                                <th>&nbsp;Promedio&nbsp;</th>
                                <th>&nbsp;Modalidad&nbsp;</th>
                                <th>&nbsp;Sexo&nbsp;</th>

                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${alumno}" var="current">
                                <tr class='gradeX'>
                                    <td><form:checkbox path="alumno" value="${current.id}"/></td>
                                    <td><core:out value="${current.datosPersonalesId.id}" /></td>
                                    <td><core:out value="${current.datosPersonalesId.alumnoId.id}" /></td>
                                    <td><core:out value="${current.datosPersonalesId.apellidoP} ${espacio} ${current.datosPersonalesId.apellidoM} ${espacio} ${current.datosPersonalesId.nombre}" /></td>
                                    <td><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></td>
                                    <td><core:out value="${current.datosPersonalesId.alumnoId.promedio}" /></td>
                                    <td><core:out value="${current.modalidad}" /></td>
                                    <td><core:out value="${current.datosPersonalesId.sexo}" /></td>
                                </tr>
                            </core:forEach>
                        </tbody>
                    </table>
                    <br>
                    <table>
                        <tr>
                            <td> <input id="a" type ="submit" value = "Aceptar "  /> </td>                                
                            <td> <input type="button" value="Contar Alumnos" onClick="contar();"></td>
                        </tr>
                    </table>
                </form:form>            
            </div>

        </div>


    </body>
</html>