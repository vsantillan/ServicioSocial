<%-- 
    Document   : altaAdminOrganizacion
    Created on : 07-jun-2013, 14:29:04
    Author     : bustedvillain
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />       
        <title>Administrador</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">
                <h1>Alta de Organizaciones</h1>
                <form:form name="altaOrganizacion" id="MyForm" action="gdaAltaOrganizacion.do" method="POST">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre de la Organizaci&oacute;n:</label> </td>
                            <td> <input type="text" name="nombre" id="nombre" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="hora">RFC:</label> </td>
                            <td>  <input type="text" name="rfc" id="rfc" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Titular:</label></td>
                            <td>  <input type="text" name="titular" id="titular" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto:</label></td>
                            <td>  <input type="text" name="puesto" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  <input type="text" name="correo" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono:</label></td>
                            <td>  <input type="text" name="telefono" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio:</label></td>
                            <td>  <input type="text" name="domicilio" id="domicilio" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">C&oacute;digo Postal:</label></td>
                            <td>  <input type="text" name="codigo_postal" id="domicilio" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td> <label for="semestre">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <select id="tipo_organizacion" name="tipo_organizacion">
                                    <option value="1">Gobierno Federal</option>
                                    <option value="2">Gobierno Estatal</option>
                                    <option value="3">Gobierno Municipal</option>
                                    <option value="4">Organizaci&oacute;n Civil</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr> 
                            <td> <input type ="submit" value = "Guardar " /> </td>
                            <td> <input type ="reset" value = "Limpiar" /></td>
                        </tr>
                    </table>
                </form:form> 
                <br/>
            </div>
             <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
