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

        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 
        <!--        Scripts para tablas-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

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
        <script type="text/javascript" src="js/editaOrganizacion.js"></script>
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body class="background">
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
                                
                                <th><a href="editarOrganizacion.do?id=${current.idInstancia}" rel="shadowbox"><img src="imagenes/editar.png" width="30" title="Editar Organizaci&oacute;n"/></a><a href="borrarOrganizacion.do?id=${current.idInstancia}" class="borrar" onclick="if(!confirm('¿Está seguro?'))history.go(0);return' ' ;" ><img src="imagenes/trash.png" width="30" title="Borrar Organizaci&oacute;n"></a></th>
                                <th><a href="detalleOrganizacion.do?id=${current.idInstancia}" rel="shadowbox; width=500px; height=500px;"><img src="imagenes/lupa.png" width="30"/></a></th>
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
    <jsp:include page="../Template/footer.jsp" />

</body>


</html>
