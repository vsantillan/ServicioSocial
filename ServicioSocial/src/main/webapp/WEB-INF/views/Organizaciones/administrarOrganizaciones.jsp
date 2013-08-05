<%-- 
    Document   : administrarOrganizaciones
    Created on : 4/06/2013, 02:17:52 PM
    Author     : roy
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />       
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
        <link type="text/css" href="shadowbox/shadowbox.css" rel="stylesheet" />
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
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
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body class="background" onmousedown="elemento(event);">
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Administrar Organizaciones</h1>
                <p>A continuaci&oacute;n se muestran las organizaciones dadas de alta en el sistema.</p>
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
                        <core:forEach items="${organizaciones}" var="current">
                            <tr class='gradeX'>
                                <!--onclick="if(!confirm('¿Está seguro?'))history.go(0);return' ' ;" -->
                                <th><a href="editarOrganizacion.do?id=${current.idInstancia}" ><img src="imagenes/editar.png" width="30" title="Editar Organizaci&oacute;n"/></a><a href="#a" class="mandaRetro" nombre="${current.nombre}" correo="${current.correo}" idO="${current.idInstancia}"  rel="shadowbox"><img src="imagenes/trash.png" width="30" title="Borrar Organizaci&oacute;n"></a></th>
                                <th><a href="detalleOrganizacion.do?id=${current.idInstancia}" rel="shadowbox; width=740px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
                                <th><core:out value="${current.nombre}" /></th>
                                <th><core:out value="${current.titular}" /></th>
                                <th><core:out value="${current.rfc}" /></th>
                                <th><core:out value="${current.tipoOrganizacion.detalle}" /></th>
                            </tr>
                        </core:forEach>
                    </tbody>
                </table>
                <%-- fin del contenido --%>
            </div>
            <div style="clear: both;"/>
        </div>
    </div>
    <div id="a" style="display: none; font-size: 15px">
            <h1>Motivos de Rechazo</h1>
            <form:form commandName="retroalimentacionInstancia"  id="MyForm" method="POST"  action="borrarInstancia.do">
                <table >
                    <form:input hidden="hidden" type ="text"  id="idI" path="id" name="id" />                   
                    <form:input hidden="hidden" id="control" path="control" value="0" />
                    <tr>

                        <td>Nombre de la Organizaci&oacute;n:</td>
                        <td><form:input type ="text"  id="nombre" path="nombre" name="nombre" /> </td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><form:input type ="text"  id="correo" path="correo" name="correo" /> </td>
                    </tr>
                    <tr>
                        <td>Descripci&oacute;n:</td>
                        <td><form:textarea  id="descripcion" path="descripcion" rows="10" cols="70" name="descripcion" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type ="submit" value="Enviar Retroalimentaci&oacute;n"  class="enviarRetro" > </td>
                    </tr>
                </table>
            </form:form>
        </div>
    <jsp:include page="../Template/footer.jsp" />
</body>


</html>
