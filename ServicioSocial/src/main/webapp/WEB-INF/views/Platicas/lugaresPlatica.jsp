<%-- 
    Document   : lugaresPlatica
    Created on : 3/07/2013, 01:27:11 PM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />       
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Catálogo de lugares</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Administrar Lugares</h1>
                <p>A continuaci&oacute;n se muestran los lugares dados de alta en el sistema.</p>
                <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
                    <thead>
                        <tr>
                            <th>Acci&oacute;n</th>
                            <th>Lugar</th>                                            
                        </tr>
                    </thead>
                    <tbody>
                        <core:forEach items="${lugares}" var="current">
                            <tr class='gradeX'>
                                <th><a href="editarOrganizacion.do?id=${current.id}" ><img src="imagenes/editar.png" width="30" title="Editar Lugar"/></a>
                                    <a href="#" class="btn-validar-org"><img class="cambiaStatusInstancia" ide="${current.id}" src="imagenes/trash.png" width="30" title="Borrar Lugar"></a></th>
                                <th><core:out value="${current.lugar}" /></th>
                            </tr>
                        </core:forEach>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td><a href="#preseleccionado" rel="shadowbox;height=300;width=500"><img src="imagenes/agregar.jpg" title="Agregar Lugar" width="30"/></a></td>
                    </tr>
                </table>
                <div id="agregarLugar">
                    <%-- Formulario Nueva lugar para platica de inducción --%>
                    <form:form action="altaLugarBD.do" method="post" commandName="lugar" id="formLugar" name="altaLugares" > 
                        <table style="width:500px">
                            <tr>
                                <td>
                                    <form:input type="hidden" value="1" path="status"/>
                                    <label for="Lugar"><fmt:message key="lugar" /></label> 
                                </td>

                            </tr>
                            <tr>
                                <td><form:textarea  path="lugar" rows="3" cols="60" /></td>    
                            </tr>
                            <tr>
                                 <td><form:errors path="lugar" cssClass="error" /></td>   
                            </tr>
                            <tr> 
                                <td> </td>
                                <td> <input type ="submit" value = "Guardar " /> </td>
                                <td><input type ="reset" value = "Limpiar" /></td>
                        </table>
                    </form:form>
                </div>
                <%-- fin del contenido --%>
            </div>
            <div style="clear:both;"></div> 
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
