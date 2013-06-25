<%-- 
    Document   : consultasBajas
    Created on : 4/06/2013, 09:48:33 AM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="../Template/taglibs.jsp" %>
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
        <jsp:include page="../Template/headsJQueryUI.jsp" />
<jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript">
            $(document).ready(function() {
                $('#platicas').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });


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


                <%-- <c:forEach items="${platica}" var="platica">
                    <b>ID:</b>${platica.id}<br/>
                    <b>Fecha</b>${platica.fecha}<br/>
                    <b>Hora</b>${platica.hora}<br/>
                </c:forEach> --%>


                <center> <h2>Consultas y Bajas de Pláticas</h2></center>
                <div id="div_BajaPlatica">
                   
                        <center>
                            <table cellpadding='0' border='0' class='display' id="platicas" width='100%' >
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
                                    <c:forEach items="${platica}" var="platica">
                                        <tr Bgcolor="#FBF2EF">
                                            <td><a class="elimina"><img src="imagenes/platicadelete.png" /></a></td>

                                            <td><div  contenteditable >${platica.fecha}</div></td>
                                            <td><div  contenteditable >${platica.hora}</div></td>
                                            <td><div  contenteditable >${platica.lugar}</div></td>
                                            <td><div  contenteditable >${platica.periodo}</div></td>
                                            <td><div  contenteditable >${platica.anio}</div></td>
                                            <td><div  contenteditable >${platica.numeroAsistentes}</div></td>
                                            <td><div  contenteditable >${platica.fechaMxFui}</div></td>
                                            <td style="visibility: hidden">${platica.id}</td>              


                                        </tr>
                                    </c:forEach>


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
        
        <jsp:include page="../Template/footer.jsp" />
    </body>

</html>
