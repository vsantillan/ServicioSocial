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
        <script type="text/javascript" src="js/editaOrganizacion.js"></script>
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
                                <th><a href="editarOrganizacion.do?id=${current.idInstancia}" ><img src="imagenes/editar.png" width="30" title="Editar Organizaci&oacute;n"/></a><a href="#prueba" class="retroalimentacion" rel="shadowbox" idInstancia="${current.idInstancia}" nombreInstancia="${current.nombre}" correo="${current.correo}" ><img src="imagenes/trash.png" width="30" title="Borrar Organizaci&oacute;n"></a></th>
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
    <div id="prueba" style="display: none">
        <h2>Cancelacion de Organizaci&oacute;n</h2>
        <div id="tabas">
            <ul>
                <li><a href="#">Enviar Retroalimentaci&oacute;n</a></li>
            </ul>
            <div>
                <form id="MyForm" action="">
                    <table>
                        <tr>
                            <input id="idInstancia" type="hidden"/>
                            <td>Nombre de la Organizaci&oacute;n:</td>
                            <td><input type ="text" id="nombre" /> </td>
                        </tr>
                        <tr>
                            <td>E-Mail:</td>
                            <td><input type ="text" id="correo" /> </td>
                        </tr>
                        <tr>
                            <td>Descripci&oacute;n:</td>
                            <td><textarea id="descripcion" name="descripcion" rows="10" cols="70"></textarea></td>
                        </tr>
                        <tr>
                            <td><input type ="submit" class="borrarInstancia" value="Enviar Retroalimentaci&oacute;n" /> </td>
                            <td><input type ="button" value="Cancelar" onclick="window.parent.Shadowbox.close();"/> </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="../Template/footer.jsp" />
</body>


</html>
