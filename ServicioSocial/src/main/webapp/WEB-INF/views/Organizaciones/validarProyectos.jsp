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

        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />

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
        <title>Administraci&oacute;n de Organizaciones
            <title>Administracion de Proyectos</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />


        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width: 80%">
                <h1>Validar Proyectos</h1>

                <p>A continuaci&oacute;n se muestran los proyectos por validar.</p>
                <div id="div-validar-proyecto" style="display:none;">
                    <center>
                        <img src="imagenes/paloma.png" width="100"/>
                        <h2>Proyecto validado correctamente</h2>
                    </center>
                </div>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Ver proyecto</th>
                            <th>Nombre del proyecto</th>
                            <th>Organizaci&oacute;n</th>
                            <th>Numero de vacantes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${proyecto}" var="current">
                            <tr class='gradeX'>
                                <th><a href="#" class="btn-validar-proyecto"><img class="editProy" ide="${current.idProyecto}" src="imagenes/paloma.png" width="30"/></a><a href="#a" class="fancybox-effects-a mandaRetro" nombreProyecto="${current.nombre}" nombre="${current.idInstancia.nombre}" correo="${current.idInstancia.correo}" idO="${current.idProyecto}"><img src="imagenes/tache.png" width="30"/></a></th>
                                <th><a href="detalleProyecto.do?id=${current.idProyecto}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>
                                <th><core:out value="${current.nombre}" /></th>
                                <th><core:out value="${current.idInstancia.nombre}" /></th>
                                <th><core:out value="${current.vacantes}" /></th>                                      
                            </tr>
                        </core:forEach>

                    </tbody>
                </table>
            </div>

            <div style="clear:both;"></div>
            <%-- fin del contenido --%>
        </div>
        <div id="a" style="display: none; font-size: 15px">
            <form:form commandName="borrarProyecto" id="MyForm" action="borrarProyecto.do" method="POST">
                <h1>Envio de Retroalimentaci&oacute;n</h1>
                <h2>Motivos de Rechazo</h2>
                <table>
                    <tr>
                        <form:input hidden="hidden" type ="text"  id="idI" path="id" name="id" />                   
                        <form:input hidden="hidden" id="control" path="control" value="1" />
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
