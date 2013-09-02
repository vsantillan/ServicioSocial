<%-- 
    Document   : catalogoObservaciones
    Created on : 5/08/2013, 11:50:44 AM
    Author     : rodrigo
--%>


<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>


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
        <!--        Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>      
        <script type="text/javascript" language="javascript" src="js/observaciones.js"></script>

        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "two_button",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%"

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
                        <li><a href="#nuevaObservacion">Nueva Observaci&oacute;n</a></li>
                        <li><a href="#catalogoObservaciones">Cat&aacute;logo de Observaciones</a></li>

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
                                        <th><a href="#a" class="fancybox-effects-a  actualizaObservacion" detalle="${current.detalle}" idO="${current.id}"><img src="imagenes/editar.png" width="30" /></a><a href="#" ><img class="borrarObservacion" ide="${current.id}" src="imagenes/trash.png" width="30" /></a></th>
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
                            <form:form commandName="Observacion" id="nuevaDescrpcion" name="nuevaObservacion" action="nuevaObservacion.do" method="POST">
                                <table>
                                    <form:hidden path="id" id="id" />
                                    <tr>
                                        <td> <p><label for="detalle">Descripci&oacute;n:</label> </p></td>
                                        <td>  <form:textarea id="detalle"  name="detalle" path="detalle" rows="8" cols="50" maxlength="300" /> 
                                        <td>${errorBlanco}</td>
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
            <form:form commandName="Observacion" action="actualizaObservacion.do" method="POST" onsubmit="return validarForm(this);" >
                <table>
                    <form:input hidden="hidden" id="id" name="name" path="id" />
                    <tr>
                        <td>Descripci&oacute;n:</td>
                        <td><form:textarea type="text" id="detalleE" path="detalle" rows="10" cols="70" name="detalleE" maxlength="300"  /></td>
                    <tr>
                        <td>
                            <div class='error' style="display:none;">Error la descripcion esta vacia</div>
                        </td>
                    </tr>
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