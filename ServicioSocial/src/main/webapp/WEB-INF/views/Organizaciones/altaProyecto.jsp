<%-- 
    Document   : altaProyecto
    Created on : 06-jun-2013, 11:53:01
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
        <%@ include file="../Template/headsOrganizaciones.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        
        <title>Alta de Organizaciones</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <%@ include file="../Template/banner.jsp" %>

        <jsp:include page="../PanelOrganizacion/menuPanelOrganizacion.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">
            <center> 
                <h1>Alta de Proyecto</h1>
                <form:form name="altaOrganizacion" id="MyForm" action="gdaAltaOrganizacionUsuario.do" method="POST">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre del Proyecto:</label> </td>
                            <td> <input type="text" name="nombre" id="nombre" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                            <td>  <input type="text" name="rfc" id="vacacntes" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Responsable del Programa:</label></td>
                            <td>  <input type="text" name="titular" id="titular" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                            <td>  <input type="text" name="puesto" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio del Programa:</label></td>
                            <td>  <input type="text" name="correo" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">C&oacute;digo Postal:</label></td>
                            <td>  <input type="text" name="lugar" id="cp" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Colonia:</label></td>
                            <td>  <select name="lugar" id="colonia" >
                                    <option value="0">Vicente Guerrero</option>
                                    <option value="1">Plazas de San Buenaventura</option>
                                  </select> 
                            </td>  
                        </tr>                        
                        <tr>
                            <td>  <label for="lugar">Estado:</label></td>
                            <td>  <input type="text" name="lugar" id="estado" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Municipio:</label></td>
                            <td>  <input type="text" name="lugar" id="municipio" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Ciudad</label></td>
                            <td>  <input type="text" name="lugar" id="ciudad" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tipo de Proyecto:</label></td>
                            <td>
                                <select id="tipo_proyecto" name="tipo_proyecto">
                                    <option value="1">Interno</option>
                                    <option value="2">Interno Becado</option>
                                    <option value="3">Externo</option>
                                    <option value="4">Externo Becado</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Perfil Buscado:</label></td>
                            <td>
                                <select id="organizacion" name="organizacion">
                                    <option value="1">Cualquiera</option>
                                    <option value="2">Ingeniero en Sistemas Computacionales</option>
                                    <option value="3">Ingeniero Industrial</option>
                                    <option value="4">Ingeniero en Gesti&oacute;n Empresarial</option>
                                    <option value="5">Ingeniero Electr&oacute;nica</option>
                                    <option value="6">Ingeniero en Mecatr&oacute;nica</option>
                                    <option value="7">Ingeniero Qu&iacute;mico</option>
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
            </center>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
