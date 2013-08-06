<%-- 
    Document   : catalogoObservaciones
    Created on : 5/08/2013, 11:50:44 AM
    Author     : rodrigo
--%>


<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../Template/taglibs.jsp" %>


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
        <script type="text/javascript" language="javascript" src="js/observaciones.js"></script>

        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({enableKeys: false,language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

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
       
        <title>Cat&aacute;logo de Observaciones</title>
    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Cat&aacute;logo de Observaciones</h1>
                <p>A continuaci&oacute;n se muestra el catalogo de observaciones.</p>
                <div id="tabs">
                    <ul>
                        <li><a href="#catalogoObservaciones">Cat&aacute;logo de Observaciones</a></li>
                        <li><a href="#nuevaObservacion">Nueva Observaci&oacute;n</a></li>
                    </ul>
                    <div id="catalogoObservaciones">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;n</th>
                                    <th>No. Desccripci&oacute;n</th>
                                    <th>Descripci&oacute;n</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${Observaciones}" var="current">
                                    <tr class='gradeX'>
                                        <th><a href="#a" class="actualizaObservacion" detalle="${current.detalle}" idO="${current.id}" rel="shadowbox; width=400px; height=200px;"><img src="imagenes/editar.png" width="30" /></a><a href="#" ><img class="borrarObservacion" ide="${current.id}" src="imagenes/trash.png" width="30" /></a></th>
                                        <th><core:out value="${current.id}" /></th>
                                        <th><core:out value="${current.detalle}" /></th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="nuevaObservacion">
                         <h1>Nueva Observaci&oacute;n</h1>
                        <center> 
                           
                            <form:form commandName="Observacion" id="nuevaDescrpcion" action="nuevaObservacion.do" method="POST">
                                <table>
                                    <tr>
                                        <td> <p><label for="descripcion">Descripci&oacute;n:</label> </p></td>
                                        <td>  <form:textarea id="descripcion"  name="descripcion" path="descripcion" rows="4" cols="50"  /> </td>
                                    </tr>
                                    <tr> 
                                        <td> <input type ="submit" value = "Guardar " /> </td>
                                    </tr>
                                </table>
                            </form:form>
                        </center>
                    </div>
                </div>

                <%-- fin del contenido --%>
            </div>
            <div style="clear: both;"/></div>
    </div>
    <div id="a" style="display: none; font-size: 15px">
                    <center> 
                        <h1>Editar Observaci&oacute;n</h1>
                 <form:form  commandName="Observacion" name="nuevaObservacion" action="actualizaObservacion.do" method="POST" onsubmit="window.parent.Shadowbox.close();">
                    <table>
                        <form:input hidden="hidden" id="id" name="name" path="id" />
                        <tr>
                            <td> <label for="descripcion">Descripci&oacute;n:</label> </td>
                            <td></td>
                            <td><form:textarea id="descripcionE" name="descripcionE" path="descripcion" rows="4" cols="50"  /></td>
                        </tr>
                        <tr> 
                            <td> <input type ="submit" value = "Guardar " /> </td>
                        </tr>
                    </table>
                </form:form>
            </center> 
    </div>

    <jsp:include page="../Template/footer.jsp" />

</body>
</html>