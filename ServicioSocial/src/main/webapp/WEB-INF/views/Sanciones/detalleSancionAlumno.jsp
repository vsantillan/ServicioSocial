<%-- 
    Document   : detalleSancionAlumno
    Created on : 10/06/2013, 10:42:15 AM
    Author     : Regules
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Seguimiento a Sancionado</title>
        <!--Scripts para tabla-->
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
    </head>
    <body>
        <div style="padding-left: 10px; padding-right: 10px ">

            <h1>Sanciones</h1>

            <br />
            <h2><b>Nombre: </b>${nombre}</h2>
            <h2><b>No. Control: </b>${nombre}</h2>
            <div style ="background: #B5EBF6;  border-radius:30px; border: 2px; padding: 5px;border-color: #862E26; padding-left: 30px;">
                <form>
                    <input id="idDatosPersonales" type="hidden" value="${current.datosPersonalesId.id}"/>
                    <h3>Nueva sanci&oacute;n</h3>
                    <b>Sancion:</b>
                    <select id="idSancion" id="comboSancion">
                        <core:forEach items="${catalogoSanciones}" var="current">
                            <option><core:out value="${current.detalle}" /></option>
                        </core:forEach>
                    </select>
                    <b>Horas:</b>
                    <input id="horas" type="number" value ="0"/>
                    <input type="button" onclick="nuevaSancion();" value="Asignar"/>
                </form>
            </div>

            <br/>
            <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                <thead>
                    <tr>
                        <th>Acciones</th>
                        <th>Fecha</th>
                        <th>Horas</th>
                        <th>Descripci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <core:forEach items="${listaSanciones}" var="current">
                        <tr class='gradeX'>

                            <th><a href="detalleSancionAlumno.do?ins=sancion" rel="shadowbox" class="fancyFUI"><img src="imagenes/lupa.png" width="30"/></a></th>
                            <th><core:out value="${current.fecha}" /></th>
                            <th><core:out value="${current.horasSancion}" /></th>
                            <th><core:out value="${current.catalogoSancionesId.detalle}" /></th>
                        </tr>
                    </core:forEach>
                </tbody>
            </table>

            <%-- fin del contenido --%>
        </div>
    </body>
</html>
