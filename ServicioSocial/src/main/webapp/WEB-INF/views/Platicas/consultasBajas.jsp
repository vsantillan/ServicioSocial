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

        <link rel="stylesheet" type="text/css" href="css/platicaSyntaxHighlighter.css" />


        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>

        <link rel="stylesheet" type="text/css" href="css/jqueryUI/site.css">

        <link rel="stylesheet" type="text/css" href="css/jqueryUI/dataTables.editor.css">


        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>
        <script type="text/javascript" src="js/platicajquery-latest.js"></script>

        <script type="text/javascript" charset="utf-8" src="js/jqueryUI/datables1.9.js" ></script>
        <script type="text/javascript" src="js/jqueryUI/KeyTable/js/KeyTable.js"></script>
        <script type="text/javascript" src="js/jqueryUI/dataTables.editor.js"></script>
        <script type="text/javascript" src="js/jqueryUI/TableTools.js"></script>
        <script type="text/javascript" src="js/script2PlaticaEliminar.js"></script>
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
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <%-- <jsp:include page="../../../menus/menuPanelAdministrador.jsp" flush="true" />--%>
        <%--<jsp:include page="../panelAdministrador/menuPanelAdministrador.jsp" /> --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center> <h2 id="h1p">Consultas y Bajas de Pláticas</h2></center>
                <p></p>
                <p></p>

                <%-- <c:forEach items="${platica}" var="platica">
                    <b>ID:</b>${platica.id}<br/>
                    <b>Fecha</b>${platica.fecha}<br/>
                    <b>Hora</b>${platica.hora}<br/>
                </c:forEach> --%>



                <div style="width:700px;overflow:scroll">

                    <center>

                        <table cellpadding='0' border='0' class='display KeyTable' id="platicas" width='100%' >
                            <thead>
                                <tr bgcolor="#0080FF">
                                    <th class="elimina">Eliminar</th>
                                    <th >Fecha</th>
                                    <th>Hora</th>
                                    <th>Lugar</th>
                                    <th>Periodo</th>
                                    <th>Año</th>
                                    <th>Descripción</th>
                                    <th>Tipo</th>
                                    <th>Asistentes</th>
                                    <th>Fecha máxima formato unico</th>
                                    <th style="visibility: hidden">ID</th>

                                </tr>
                            </thead>
                            <tbody>
                                <%--  <%        
                       if (lista.size() > 0){
                       for (int i=0; i < lista.size(); i++){
                          
                           %> --%>
                                <c:forEach items="${platica}" var="platica">
                                    <tr>
                                        <td><a class="elimina"><img src="imagenes/trash.png" height="40" width="45" /></a></td>

                                        <td style="width: 100px"><div  contenteditable >${platica.fecha}</div></td>
                                        <td><div  contenteditable >${platica.hora}</div></td>
                                        <td style="width: 150px"><div  contenteditable >${platica.idLugar.lugar}</div></td>
                                        <td><div  contenteditable >${platica.periodo}</div></td>
                                        <td><div  contenteditable >${platica.anio}</div></td>
                                        <td style="width: 150px"><div  contenteditable >${platica.descripcion}</div></td>
                                        <td ><div  contenteditable >${platica.tipo}</div></td>
                                        <td ALIGN="RIGHT"><div  contenteditable >${platica.numeroAsistentes}</div></td>
                                        <td style="width: 150px"><div  contenteditable >${platica.fechaMxFui}</div></td>

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

            <div style="clear:both;"></div>
        </div>


        <jsp:include page="../Template/footer.jsp" />
    </body>

</html>
