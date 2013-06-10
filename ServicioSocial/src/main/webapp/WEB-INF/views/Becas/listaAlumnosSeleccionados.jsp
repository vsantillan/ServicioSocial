<%-- 
    Document   : listaAlumnosSeleccionados
    Created on : 7/06/2013, 02:29:54 PM
    Author     : Jonny
--%>

<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  // Create an ArrayList with test data
  ArrayList list = new ArrayList();
  Map author1 = new HashMap();
  author1.put("name", "Ali");
  author1.put("id", new Integer(1));
  list.add(author1);
  Map author2 = new HashMap();
  author2.put("name", "Basdf");
  author2.put("id", new Integer(2));
  list.add(author2);
  Map author3 = new HashMap();
  author3.put("name", "Casdf");
  author3.put("id", new Integer(3));
  list.add(author3);
  pageContext.setAttribute("authors", list);
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
               <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!--CSS-->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" />         
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Estilos para tablas-->
        <link rel="stylesheet" type="text/css" href="css/demo_page.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.4.custom.css" />




        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>

       
        <!--        Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
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
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
               <h1>Preselecci&oacute;n de Alumnos Becados</h1> 
               <form:form id="form1">
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
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
                 <input type ="submit" value = "Enviar Correo " />                                 
                 <input type="button" name="Submit" value="Generar Exel" >
                 <input type="button" name="Submit" value="Eliminar" >
                  <input type="button" name="Submit" value="Agregar Alumno" >
                 </form:form>            
            </div>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>

