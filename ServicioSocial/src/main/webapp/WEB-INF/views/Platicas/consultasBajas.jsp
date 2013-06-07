<%-- 
    Document   : consultasBajas
    Created on : 4/06/2013, 09:48:33 AM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="tags"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <link rel="stylesheet" href="css/platicasEstiloFormularioformly.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/platicaSyntaxHighlighter.css" />


        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>


        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>
        <script type="text/javascript" src="js/platicajquery-latest.js"></script>
        <script type="text/javascript" src="js/platicajquery.tablesorter.js"></script>
        <script type="text/javascript" src="js/platicajquery.tablesorter.min.js"></script>


        <script type="text/javascript">
            $(function() {
                $("#grilla").tablesorter({sortList: [[0, 0], [2, 1]], widgets: ['zebra']});

            });
        </script>

        <title>Consultas y Bajas de Pláticas</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')">
        <jsp:include page="../Template/banner.jsp" />
        <%-- <jsp:include page="../../../menus/menuPanelAdministrador.jsp" flush="true" />--%>
        <%--<jsp:include page="../panelAdministrador/menuPanelAdministrador.jsp" /> --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center> <h2>Consultas y Bajas de Pláticas</h2></center>
                <div id="div_BajaPlatica">
                    <div style="height:400px;width:700px;overflow:scroll;"> 
                        <center>
                            <table id="grilla" class="tablesorter" border="1"  bordercolor="#FFFFFF">
                                <thead>
                                    <tr bgcolor="#0080FF">
                                        <th><font color="#1C1C1C">Eliminar</font></th>
                                        <th><font color="#1C1C1C">Fecha</font></th>
                                        <th><font color="#1C1C1C">Hora</font></th>
                                        <th><font color="#1C1C1C">Lugar</font></th>
                                        <th><font color="#1C1C1C">Periodo</font></th>
                                        <th><font color="#1C1C1C">Año</font></th>
                                        <th><font color="#1C1C1C">Asistentes</font></th>
                                        <th><font color="#1C1C1C">Fecha máxima formato unico</font></th>
                                        <th style="visibility: hidden"><font color="#1C1C1C">ID</font></th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%--  <%        
                           if (lista.size() > 0){
                           for (int i=0; i < lista.size(); i++){
                              
                               %> --%>
                                    <tr Bgcolor="#FBF2EF">
                                        <td><a class="elimina"><img src="imagenes/platicadelete.png" /></a></td>

                                        <td><div  contenteditable >31/07/13</div></td>
                                        <td><div  contenteditable >13:00 pm</div></td>
                                        <td><div  contenteditable >abc</div></td>
                                        <td><div  contenteditable >ENE-JUN</div></td>
                                        <td><div  contenteditable >2013</div></td>
                                        <td><div  contenteditable >2</div></td>
                                        <td><div  contenteditable >01/12/2013</div></td>
                                        <td style="visibility: hidden">2</td>              


                                    </tr>
                                    <tr Bgcolor="#FBF2EF">
                                        <td><a class="elimina"><img src="imagenes/platicadelete.png" /></a></td>

                                        <td><div  contenteditable >01/07/13</div></td>
                                        <td><div  contenteditable >11:00 am</div></td>
                                        <td><div  contenteditable >xyz</div></td>
                                        <td><div  contenteditable >AGO-DIC</div></td>
                                        <td><div  contenteditable >2014</div></td>
                                        <td><div  contenteditable >2</div></td>
                                        <td><div  contenteditable >01/12/2013</div></td>
                                        <td style="visibility: hidden">2</td>              


                                    </tr>

                                    <%--     <%
                               
                           }
                        }
                        
                        
                               else{
                            out.println("no hay platicas dadas de alta");
                               }
                         %>    --%>

                                </tbody>

                            </table>
                        </center>
                        <br />
                    </div>
                </div>
            </div>
            <div style="clear:both;"></div>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>

</html>
