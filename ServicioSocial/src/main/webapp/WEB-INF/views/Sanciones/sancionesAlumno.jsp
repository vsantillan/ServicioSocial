<%-- 
    Document   : sancionesAlumno
    Created on : 10/06/2013, 09:27:13 AM
    Author     : ekt
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
        <!-- CSS  Shadowbox-->
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

        <!--Script para DataTables-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <!--Scripts para shadowbox-->
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
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Sanciones</h1>
                <p>A continuaci&oacute;n se muestran los alumnos con sanciones, de click en "Detalles" para ver sus reportes o click en "Pagar" para agregar reportes de pago de servicio.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Detalle</th>
                            <th>Periodo</th>
                            <th>No control</th>
                            <th>Nombre</th>
                            <th>Estado</th>
                            <th>Horas de sanci&oacute;n</th>
                            <th>Horas restantes</th>
                            <th>Lugar</th>
                            <th>Acci&oacute;n</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${sancionAlumno}" var="current">
                        <tr class='gradeX'>
                            <th><a href="detalleSancionAlumno.do?nombre=${current.nombre}&noControl=${current.noControl}" rel="shadowbox"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><core:out value="${current.periodo}" /></th>
                            <th><core:out value="${current.noControl}" /></th>
                            <th><core:out value="${current.nombre}" /></th>
                            <th><core:out value="${current.status}" /></th>
                            <th><core:out value="${current.horasSancion}" /></th>
                            <th><core:out value="${current.horasRestantes}" /></th>
                            <th><core:out value="${current.lugar}" /></th>
                            <th><a href="pagoSancionAlumno.do?nombre=${current.nombre}&noControl=${current.noControl}" rel="shadowbox">Pagar</a></th>
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
