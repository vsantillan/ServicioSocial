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
        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>
        <script language="javascript">

            function contar() {

            var checkboxes = form1.checkbox; //Array que contiene los checkbox
            var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados

            for (var x=0; x < checkboxes.length; x++) {
            if (checkboxes[x].checked) {
            cont = cont + 1;
            }
            }

            alert ("El número de alumnos seleccionados es: " + cont);

            }
            </script>


           <title>Preselecci&oacute;n de Alumnos Becados</title>
    </head>
    <body>
        <h1>Preselecci&oacute;n de Alumnos Becados</h1> 
               <form:form id="form1">
                   <div >
                            <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                                <thead>
                                    <tr>
                                        <th>&nbsp;Fotograf&iacute;a&nbsp;</th>
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
                                    <core:forEach items="${alumno}" var="current">
                                    <tr class='gradeX'>
                                      <td><core:out value="${current.id}" /></td>
                                      <td><core:out value="${current.id}" /></td>
                                      <td><core:out value="${current.nombre}" /></td>
                                      <td><core:out value="${current.carrera}" /></td>
                                      <td><core:out value="${current.promedio}" /></td>
                                      <td><core:out value="${current.id}" /></td>
                                      <td><core:out value="${current.sexo}" /></td>
                                      <td><input type="checkbox" name="checkbox" value="checkbox"></td> 
                                    </tr>
                                  </core:forEach>
                                </tbody>
                            </table>
                 <input type ="button" value = "Aceptar " />                                 
                 <input type="button" name="Submit" value="Contar Alumnos Seleccionados" onClick="contar();">
                 </form:form>            
            </div>
            <div style="clear:both;"></div>
    </body>
</html>