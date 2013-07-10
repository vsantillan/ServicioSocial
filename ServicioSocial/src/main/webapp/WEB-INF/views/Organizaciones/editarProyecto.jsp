<%-- 
    Document   : editarProyecto
    Created on : 24/06/2013, 12:05:09 PM
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
        <title>Editar Proyecto</title>
    </head>
    <body>
        <div id="contenido">
            <div>
                <h1>Alta de Proyecto</h1>
                <form:form name="altaOrganizacion" id="MyForm" action="gdaAltaOrganizacion.do" method="POST">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre del Proyecto:</label> </td>
                            <td> <input type="text" name="nombre" id="nombre" size="20" require="true" value="${proyectos.nombre}"/></td>
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                            <td>  <input type="text" name="rfc" id="vacacantes" size="20" require="true" value="${proyectos.vacantes}" /></td>  
                        </tr>                        
                        <tr>
                            <td> <label for="semestre">Instancia/Organizaci&oacute;n:</label> </td>
                            <td> 
                                <select id="organizacion" name="organizacion">
                                    <core:forEach items="${instancias}" var="current">
                                        <core:choose>
                                            <core:when test="${current.idInstancia==proyectos.idInstancia.idInstancia}">
                                                <option value="${current.idInstancia}" selected="selected">${current.nombre}</option>  
                                            </core:when>
                                            <core:otherwise>
                                                <option value="${current.idInstancia}">${current.nombre}</option>  
                                            </core:otherwise>    
                                        </core:choose>
                                    </core:forEach>
                                </select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Responsable del Programa:</label></td>
                            <td>  <input type="text" name="titular" id="titular" size="20" require="true" value="${proyectos.nombreResponsable}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                            <td>  <input type="text" name="puesto" id="puesto" size="20" require="true" value="${proyectos.telefonoResponsable}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio del Programa:</label></td>
                            <td>  <input type="text" name="correo" id="puesto" size="20" require="true" value="${proyectos.domicilio}"/> </td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">C&oacute;digo Postal:</label></td>
                            <td>  <input type="text" name="cp" id="cp" size="20" require="true" value="${proyectos.idColonia.idCp.cp}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Colonia:</label></td>
                            <td>  <input type="text" name="colonia" id="colonia" size="20" require="true" value="${proyectos.idColonia.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Estado:</label></td>
                            <td>  <input type="text" name="estado" id="estado" size="20" require="true" value="${proyectos.idColonia.idCp.idEstado.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Municipio:</label></td>
                            <td>  <input type="text" name="lugar" id="municipio" size="20" require="true" value="${proyectos.idColonia.idCp.idMunicipio.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Ciudad</label></td>
                            <td>  <input type="text" name="lugar" id="ciudad" size="20" require="true" value="${proyectos.idColonia.idCp.idCiudad.nombre}"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tipo de Proyecto:</label></td>
                            <td>
                                <select id="tipo_proyecto" name="tipo_proyecto">
                                    <core:forEach items="${tipoProyecto}" var="current">
                                        <core:choose>
                                            <core:when test="${current.idTipoProyecto==proyectos.idTipoProyecto.idTipoProyecto}">
                                                <option value="${current.idTipoProyecto}" selected="selected">${current.descripcion}</option>  
                                            </core:when>
                                            <core:otherwise>
                                                <option value="${current.idTipoProyecto}">${current.descripcion}</option>
                                            </core:otherwise>    
                                        </core:choose>
                                    </core:forEach>
                                </select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Perfil Buscado:</label></td>
                            <td>
                                <select id="perfil" name="perfil">
                                    <core:forEach items="${perfil}" var="current">
                                        <core:choose>
                                            <core:when test="${1==1}">
                                                <option value="${current.idPerfil}" selected="selected">${current.nombre}</option>  
                                            </core:when>
                                            <core:otherwise>
                                                <option value="${current.idPerfil}">${current.nombre}</option>
                                            </core:otherwise>    
                                        </core:choose>
                                    </core:forEach>
                                </select>
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
        </div>
    </body>
</html>
