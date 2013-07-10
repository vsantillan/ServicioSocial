<%-- 
    Document   : editarOrganizacion
    Created on : 19/06/2013, 12:21:32 PM
    Author     : ekt
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
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>  
        <title>Editar Organizaci&oacute;n</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">

        <%-- inicio del contenido --%>
        <div id="contenido">
                <h1>Editar Organizacion</h1>
                <form:form commandName="editaOrganizacion" id="MyForm" action="modificarOrganizacion.do" method="POST">
                    <table>
                        <tr>
                            <form:hidden path="idInstancia" value="${instancia.idInstancia}"/>
                            <td><label for="nombre">Nombre de la Organizaci&oacute;n:</label></td>
                            <td><form:input type="text" path="nombre" id="nombre" size="20" require="true" value="${instancia.nombre}"/></td>  
                            <td><form:errors path="nombre" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="hora">RFC:</label> </td>
                            <td><form:input type="text" path="rfc" id="rfc" size="20" require="true" value="${instancia.rfc}" /></td>  
                            <td><form:errors path="rfc" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Titular:</label></td>
                            <td><form:input type="text" path="titular" id="titular" size="20" require="true" value="${instancia.titular}"/> </td>  
                            <td><form:errors path="titular" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Puesto:</label></td>
                            <td><form:input type="text" path="puesto" id="puesto" size="20" require="true" value="${instancia.puesto}"/> </td>  
                            <td><form:errors path="puesto" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Correo:</label></td>
                            <td><form:input type="text" path="correo" id="correo" size="20" require="true" value="${instancia.correo}"/> </td>  
                            <td><form:errors path="correo" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Contrase&ntilde;a</label></td>
                            <td><form:input type="text" path="password" id="contrasena" size="20" require="true" value="${instancia.password}"/> </td>  
                            <td><form:errors path="password" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Status:</label></td>
                            <td>
                                <core:choose>
                                    <core:when test="${instancia.estatus==1}">
                                        <form:input type="text" path="estatus" id="status" size="20" require="true" value="${instancia.estatus}"/>
                                    </core:when>
                                    <core:otherwise>
                                        <form:input type="text" path="estatus" id="status" size="20" require="true" value="${instancia.estatus}"/>
                                    </core:otherwise>
                                </core:choose>
                                    
                            </td>  
                        </tr>
                        <tr>
                            <td><label for="lugar">Tel&eacute;fono:</label></td>
                            <td><form:input type="text" path="telefono" id="telefono" size="20" require="true" value="${instancia.telefono}"/> </td>  
                            <td><form:errors path="telefono" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Domicilio:</label></td>
                            <td><form:input type="text" path="domicilio" id="domicilio" size="20" require="true" value="${instancia.domicilio}"/> </td>  
                            <td><form:errors path="domicilio" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label for="lugar">C&oacute;digo Postal:</label></td>
                            <!--<td><input type="text" path="codigoPostal" id="cp" size="20" require="true" value="${instancia.idColonia.idCp.cp}"/> </td>-->
                            <form:hidden path="idCodigoPostal" value="${instancia.idColonia.idCp.idCp}"/>
                        </tr>
                        <tr>
                            <td><label for="lugar">Colonia:</label></td>
                            <!--<td><input type="text" name="colonia" id="colonia" size="20" require="true" value="${instancia.idColonia.nombre}"/> </td>--> 
                            <td><form:hidden path="idColonia" id="colonia" size="20" require="true" value="${instancia.idColonia.idColonia}"/> </td> 
                            <td><form:errors path="idColonia" cssClass="error" /></td>
                        </tr>
<!--                        <tr>
                            <td>  <label for="lugar">Estado:</label></td>
                            <td>  <input type="text" name="estado" id="estado" size="20" require="true" value="${instancia.idColonia.idCp.idEstado.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Municipio:</label></td>
                            <td>  <input type="text" name="municipio" id="municipio" size="20" require="true" value="${instancia.idColonia.idCp.idMunicipio.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Ciudad</label></td>
                            <td>  <input type="text" name="ciudad" id="ciudad" size="20" require="true" value="${instancia.idColonia.idCp.idCiudad.nombre}"/> </td>  
                        </tr>-->
                        <tr>
                            <td> <label for="semestre">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <form:select path="tipoOrganizacion" id="tipo_organizacion" name="tipo_organizacion">
                                    <core:forEach items="${tipoOrg}" var="current">
                                        <core:choose>
                                            <core:when test="${current.idTipoOrganizacion==instancia.tipoOrganizacion.idTipoOrganizacion}">
                                                <form:option path="tipoOrganizacion" value="${current.idTipoOrganizacion}" selected="selected">${current.detalle}</form:option>
                                            </core:when>
                                            <core:otherwise>
                                                <form:option path="tipoOrganizacion" value="${current.idTipoOrganizacion}" >${current.detalle}</form:option>
                                            </core:otherwise>    
                                        </core:choose>
                                    </core:forEach>
                                </form:select>
                            </td>  
                        </tr>
                        <tr> 
                            <td> <input type ="submit" value = "Guardar cambios" /> </td>
                            <td> <input type ="button" value = "Cancelar" onclick="window.parent.Shadowbox.close();"/></td>
                        </tr>
                    </table>
                </form:form> 
                <br/>
        </div>
    </body>
</html>

