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
        <script type="text/javascript" language="javascript" src="js/sanciones.js"></script>

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
        <script type="text/javascript" language="javascript" src="js/sanciones.js"></script>
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Sanciones <input type="button" value="  Presiona para Actualizar  " onclick="location.reload()"/></h1> 
                <p>A continuaci&oacute;n se muestran los alumnos con sanciones, de click en "Detalles" para ver sus reportes o click en "Pagar" para agregar reportes de pago de servicio.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Historial Servicio</th>
                            <th>Sanciones</th>
                            <th>Pago Sanciones</th>
                            <th>No control</th>
                            <th>Nombre</th>
                            <th>Horas restantes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${listaSanciones}" var="current">
                        <tr class='gradeX'>
                            <th><a href="historialServicio.do"  target="_blank"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="detalleSancionAlumno.do?noControl=${current.idAlumno}&ins=sancion" rel="shadowbox" class="fancyFUI"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><a href="detalleSancionAlumno.do?noControl=${current.idAlumno}&ins=pago" rel="shadowbox" class="fancyFUI"><img src="imagenes/lupa.png" width="30"/></a></th>
                            
                            <th><core:out value="${current.alumno.id}" /></th>
                            <th><core:out value="${current.alumno.nombre}" /></th>
                            <th><core:out value="${current.horas}" /></th>
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
