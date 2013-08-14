<%-- 
    Document   : administrarProyectos
    Created on : 4/06/2013, 02:17:29 PM
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
        <jsp:include page="../Template/headsModal.jsp" />
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

        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
        <title>Administracion de Proyectos</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width: 80%">
                <h1>Administrar Proyectos</h1>
                <p>A continuaci&oacute;n se muestran los proyectos activos.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Ver proyecto</th>
                            <th>Organizaci&oacute;n</th>
                            <th>Nombre del proyecto</th>
                            <th>Titular</th>
                            <th>Numero de vacantes</th>           
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${proyectos}" var="current">
                            <tr class='gradeX' id="${current.idProyecto}">
                                <th><a href="editarProyecto.do?id=${current.idProyecto}" ><img src="imagenes/editar.png" width="30" title="Editar Proyecto"/></a><a href="#" class="btn-validar-proyecto"><img class="cambiaStatusProyecto" ide="${current.idProyecto}" src="imagenes/trash.png" width="30" title="Borrar Proyecto"></a></th>
                                <th><a href="detalleProyecto.do?id=${current.idProyecto}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>
                                <th><core:out value="${current.idInstancia.nombre}" /></th>
                                <th><core:out value="${current.nombre}" /></th>
                                <th><core:out value="${current.idInstancia.titular}" /></th>
                                <th><core:out value="${current.vacantes}" /></th>
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
                <form:form commandName="retroalimentacionProyecto" id="MyForm" action="borrarProyecto.do" method="POST">
                    <table>
                        <tr>
                            <form:input hidden="hidden" type ="text"  id="idI" path="id" name="id" />                   
                            <form:input hidden="hidden" id="control" path="control" value="0" />
                            <td>Nombre del Proyecto:</td>
                            <td><form:input id="nombreProyecto" path="nombreProyecto"  /></td>
                        </tr>
                        <tr>
                            <td>Nombre de la Organizaci&oacute;n:</td>
                            <td><form:input id="nombre" path="nombreInstancia"  /></td>
                        </tr>
                        <tr>
                            <td>E-Mail:</td>
                            <td><form:input id="correo" path="email" disabled="disabled"  /></td>
                        </tr>
                        <tr>
                            <td>Descripci&oacute;n:</td>
                            <td><form:textarea rows="10" cols="70" id="descripcion" path="descripcion" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Enviar Retroalimentaci&oacute;n" class="borrarProyecto" /></td>
                        </tr>
                    </table>
                </form:form>
            </div>
    <jsp:include page="../Template/footer.jsp" />
</body>


</html>
