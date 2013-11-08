<%-- 
    Document   : preselccionAlumnos
    Created on : 3/06/2013, 01:01:28 PM
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
    <head>
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <title>Preselecci&oacute;n de Alumnos Becados</title>
    </head>
    <body>
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
        <div style="clear:both;"></div>
        <script type="text/javascript" language="javascript" src="js/becados.js"></script>
    </body>
</html>