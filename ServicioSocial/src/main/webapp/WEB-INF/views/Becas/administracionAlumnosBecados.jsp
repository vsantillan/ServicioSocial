<%-- 
    Document   : administracionAlumnosBecados
    Created on : 7/06/2013, 02:29:54 PM
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
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/reporteBimestral.css" /> 
               <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Estilos para tablas-->
        <link rel="stylesheet" type="text/css" href="css/demo_page.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css" />


        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>


        <!-- Scripts -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>
        <script src="js/jqueryUI/jquery.ui.core.js"></script>
        <script src="js/jqueryUI/jquery.ui.widget.js"></script>
        <script src="js/jqueryUI/jquery.ui.tabs.js"></script>


        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

        <!--Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>

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
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Estado</th>
                                        <th>Horas Acumuladas</th>
                                        <th>Acci&oacute;n</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09280536</th>
                                        <th>José Antonio Villanueva Gonzalez</th>
                                        <th>En proceso</th>
                                        <th>360</th>
                                        <th><a href="algunlado.do" rel="shadowbox;"><img src="imagenes/lupa.png"/></a></th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09280545</th>
                                        <th>Alberto Martinez Behumea</th>
                                        <th>En proceso</th>
                                        <th>360</th>
                                        <th><a href="algunLado" rel="shadowbox"><img src="imagenes/lupa.png"/></a></th>
                                    </tr>
                                </tbody>
                            </table>
                            <table>
                                  <tr>
                                    <td><a href="preseleccionAlumnos.do" rel="shadowbox">Agregar</td>
                                    <td><a href="#" >Eliminar</td>
                                    <td><a href="#" >Enviar Correo</td>
                                    <td><a href="#" >Imprimir</td>
                                    <td><a href="#" >Aceptar Alumno</td>
                                     <td><a href="#">Generar Excel</td>
                               </tr>
                            </table>
                        </div>
                        <div id="aceptados">
                            <table cellpadding='0' cellspacing='0' border='0' class='display' id="NoRev" width='100%'>
                                <thead>
                                    <tr>
                                        <th>Periodo</th>
                                        <th>N. Control</th>
                                        <th>Nombre</th>
                                        <th>Fecha Subida</th>
                                        <th>Archivo</th>
                                        <th>Acci&oacute;n</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class='gradeX'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09280539</th>
                                        <th>Marco Antonio Cuellar</th>
                                        <th>14 Abril 2014</th>
                                        <th>Rerpote1.docx</th>
                                        <th><a href="#" ><img class="imagenes" src="imagenes/paloma.png"/><img class="imagenes" src="imagenes/tache.png"/></a></th>
                                    </tr>
                                    <tr class='gradeC'>
                                        <th>Ago-Dic 2014</th>
                                        <th>09275643</th>
                                        <th>Jose Luis Albarran Martinez</th>
                                        <th>10 Abril 2014</th>
                                        <th>Rerporte348.docx</th>
                                        <th><a href="#"><img class="imagenes" src="imagenes/paloma.png"/><img class="imagenes" src="imagenes/tache.png"/></a></th>
                                    </tr>
                                </tbody>
                            </table>
                             <table>
                                  <tr>
                                    <td><a href="enviarCorreo.do" rel="shadowbox">Enviar Correo</td>
                                    <td><a href="#" rel="shadowbox">Imprimir</td>
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