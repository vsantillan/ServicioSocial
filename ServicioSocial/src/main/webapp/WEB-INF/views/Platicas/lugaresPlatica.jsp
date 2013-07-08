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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de lugares</title>
    </head>
    <body  onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center>
                    <h1>Catálogo de lugares</h1>
                    <%-- Formulario Nueva lugar para platica de inducción --%>
                    <form:form action="altaLugarBD.do" method="post"  id="MyForm" modelAttribute="lugares">  
                        <table style="width:500px">
                            <tr>
                                <td>
                                    <form:input type="hidden" value="1" path="status"/>
                                    <label for="Lugar"><fmt:message key="lugar2" /></label> 
                                </td>

                                <td>  <form:textarea  path="lugar" rows="6" cols="15"/></td> 
                               

                            </tr>

                            <tr> 
                                <td> <input type ="submit" value = "Guardar " /> </td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>
                    </form:form>
                </center>
            </div>
            <div style="clear:both;"></div> 
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
