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
                <form:form name="altaOrganizacion" id="MyForm" action="gdaAltaOrganizacion.do" method="POST">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre de la Organizaci&oacute;n:</label> </td>
                            <td> <input type="text" name="nombre" id="nombre" size="20" require="true" value="${instancia.nombre}"/></td>  
                        </tr>
                        <tr>
                            <td>  <label for="hora">RFC:</label> </td>
                            <td>  <input type="text" name="rfc" id="rfc" size="20" require="true" value="${instancia.rfc}" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Titular:</label></td>
                            <td>  <input type="text" name="titular" id="titular" size="20" require="true" value="${instancia.titular}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto:</label></td>
                            <td>  <input type="text" name="puesto" id="puesto" size="20" require="true" value="${instancia.puesto}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  <input type="text" name="correo" id="correo" size="20" require="true" value="${instancia.correo}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Status:</label></td>
                            <td>
                                <core:choose>
                                    <core:when test="${instancia.estatus==1}">
                                        <input type="text" name="status" id="status" size="20" require="true" value="Activa"/>
                                    </core:when>
                                    <core:otherwise>
                                        <input type="text" name="status" id="status" size="20" require="true" value="Inactiva"/>
                                    </core:otherwise>
                                </core:choose>
                                    
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono:</label></td>
                            <td>  <input type="text" name="telefono" id="telefono" size="20" require="true" value="${instancia.telefono}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio:</label></td>
                            <td>  <input type="text" name="domicilio" id="domicilio" size="20" require="true" value="${instancia.domicilio}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">C&oacute;digo Postal:</label></td>
                            <td>  <input type="text" name="codigoPostal" id="cp" size="20" require="true" value="${instancia.idColonia.idCp.cp}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Colonia:</label></td>
                            <td>  <input type="text" name="colonia" id="colonia" size="20" require="true" value="${instancia.idColonia.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Estado:</label></td>
                            <td>  <input type="text" name="lugar" id="estado" size="20" require="true" value="${instancia.idColonia.idCp.idEstado.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Municipio:</label></td>
                            <td>  <input type="text" name="lugar" id="municipio" size="20" require="true" value="${instancia.idColonia.idCp.idMunicipio.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Ciudad</label></td>
                            <td>  <input type="text" name="lugar" id="ciudad" size="20" require="true" value="${instancia.idColonia.idCp.idCiudad.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td> <label for="semestre">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <select id="tipo_organizacion" name="tipo_organizacion">
                                    <core:forEach items="${tipoOrg}" var="current">
                                        <core:choose>
                                            <core:when test="${current.idTipoOrganizacion==instancia.tipoOrganizacion.idTipoOrganizacion}">
                                                <option value="${current.idTipoOrganizacion}" selected="selected">${current.detalle}</option>  
                                            </core:when>
                                            <core:otherwise>
                                                <option value="${current.idTipoOrganizacion}">${current.detalle}</option>  
                                            </core:otherwise>    
                                        </core:choose>
                                    </core:forEach>
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
    </body>
</html>

