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
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>      
        <script type="text/javascript" language="javascript" src="js/lugares.js"></script>
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
                                <th><a href="editarLugar.do?id=${current.id}" ><img src="imagenes/editar.png" width="30" title="Editar Lugar"/></a>
                                    <a href="#" class="btn-validar-org"><img class="cambiaStatusLugar" ide="${current.id}" src="imagenes/trash.png" width="30" title="Borrar Lugar"></a></th>
                                <th><core:out value="${current.lugar}" /></th>
                            </tr>
                        </core:forEach>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td><a href="#a" class="fancybox-effects-a"><img src="imagenes/agregar.jpg" title="Agregar Lugar" width="30"/></a></td>
                    </tr>
                </table>
                <div id="a" style="display:none">
                    <%-- Formulario Nueva lugar para platica de inducción --%>
                    <form:form commandName="lugar_i" id="nuevoLugar" action="nuevoLugar.do" method="POST">
                                <table>
                                    <tr>
                                        <td> <p><label for="lugar">Descripci&oacute;n:</label> </p></td>
                                        <td>  <form:textarea id="lugar"  name="lugar" path="lugar" rows="8" cols="50"  /> </td>
                                    </tr>
                                    <tr> 
                                        <td> <input type ="submit" value = "Guardar " /> </td>
                                    </tr>
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
