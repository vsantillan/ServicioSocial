<%-- 
    Document   : administrarOrganizaciones
    Created on : 4/06/2013, 02:17:52 PM
    Author     : roy
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
        
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>


        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <!--        Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
        <script type="text/javascript" charset="utf-8">
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
        <script src="js/jquery.manolo.js"></script>     

        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width: 80%">
                <h1>Validar Organizaciones</h1>
                <p>A continuaci&oacute;n se muestran las organizaciones pendientes por validar.</p>
                <div id="div-validar-organizacion" style="display:none;">
                    <center>
                        <img src="imagenes/paloma.png" width="100"/>
                        <h2>Organizaci&oacute;n validada correctamente</h2>
                    </center>
                </div>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Detalle</th>
                            <th>Organizaci&oacute;n</th>
                            <th>Titular</th>
                            <th>RFC</th>
                            <th>Tipo de Organizaci&oacute;n</th>                        
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${organizacion}" var="current">
                            <core:choose>
                                <core:when test="${current.estatus==1}">
                                    <tr class='gradeX'>
                                        <th><a href="#" ><img class="editOrg" ide="${current.idInstancia}" src="imagenes/paloma.png" width="30"/></a><a href="#a" class="fancybox-effects-a mandaRetro" nombre="${current.nombre}" correo="${current.correo}" idO="${current.idInstancia}" ><img  src="imagenes/tache.png" width="30"></a></th>
                                        <th><a href="detalleOrganizacion.do?id=${current.idInstancia}" class="fancy" ><img src="imagenes/lupa.png" width="30"/></a></th>
                                        <th><core:out value="${current.nombre}" /></th>
                                        <th><core:out value="${current.titular}" /></th>
                                        <th><core:out value="${current.rfc}" /></th>
                                        <th><core:out value="${current.tipoOrganizacion.detalle}" /></th>
                                <input type="hidden" value="${current.correo}" x="${current.idInstancia}"/>
                                <input type="hidden" value="${current.nombre}" x="${current.idInstancia}"/>
                                </tr>
                            </core:when>
                        </core:choose>
                    </core:forEach>
                    </tbody>
                </table>

            </div>
            <div style="clear:both;"></div>
            <%-- fin del contenido --%>
        </div>
        <div id="a" style="display: none; font-size: 15px">
            <form:form commandName="retroalimentacionInstancia"  id="MyForm" method="POST"  action="borrarInstancia.do" onsubmit="return validarForm(this);">
                <h1>Envio de Retroalimentaci&oacute;n</h1>
                <h2>Motivos de Rechazo</h2>
                <table >
                    <form:input hidden="hidden" type ="text"  id="idI" path="id" name="id" />                   
                    <form:input hidden="hidden" id="control" path="control" value="1" />
                    <tr>

                        <td>Nombre de la Organizaci&oacute;n:</td>
                        <td><form:input type ="text"  id="nombre" path="nombre" name="nombre" disabled="true" /> </td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><form:input type ="text"  id="correo" path="correo" name="correo" disabled="true" /> </td>
                    </tr>
                    <tr>
                        <td>Descripci&oacute;n:</td>
                        <td><form:textarea  id="descripcion" path="descripcion" rows="10" cols="70" name="descripcion" maxlength="200" /></td>
                    </tr>
                    <tr>
                        <td>
                            <div class='error' style="display:none;">Error la descripcion esta vacia</div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type ="submit" value="Enviar Retroalimentaci&oacute;n"  > </td>
                    </tr>
                </table>
            </form:form>
        </div>

        <jsp:include page="../Template/footer.jsp" />

    </body>
</html>
