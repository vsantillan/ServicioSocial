<%-- 
    Document   : registroOrganizaciones
    Created on : 10-jun-2013, 11:59:36
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
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <title>Departamento de Servicio Social :: Organizaciones ::</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>Registro Organizaciones</h1>

                <%-- Formulario Nueva Organizacion --%>
                <form:form name="altaOrganizacion" id="MyForm" action="gdaAltaOrganizacion.do" method="POST">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre de la Organizaci&oacute;n:</label> </td>
                            <td> <input type="text" name="fecha" id="nombre" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="hora">RFC:</label> </td>
                            <td>  <input type="text" name="hora" id="rfc" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Titular:</label></td>
                            <td>  <input type="text" name="lugar" id="titular" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto:</label></td>
                            <td>  <input type="text" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto:</label></td>
                            <td>  <input type="text" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono:</label></td>
                            <td>  <input type="text" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio:</label></td>
                            <td>  <input type="text" name="lugar" id="domicilio" size="20" require="true"/> </td>  
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
                            <td colspan="2"><h3>Datos de contacto y de acceso:</h3></td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  <input type="text" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Contrase&ntilde;a:</label></td>
                            <td>  <input type="password" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Confirmar Contrase&ntilde;a:</label></td>
                            <td>  <input type="password" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>                        
                        <tr> 
                            <td> <input type ="submit" value = "Guardar " /> </td>
                            <td> <input type ="reset" value = "Limpiar" /></td>
                        </tr>

                    </table>
                </form:form>


            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>