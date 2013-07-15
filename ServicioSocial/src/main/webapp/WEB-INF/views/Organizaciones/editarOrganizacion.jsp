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
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>


        
        <link rel="stylesheet" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>
        <script src="js/cargaCodigosPostalesParaEditarOP.js"></script>
        <script src="js/jquery.manolo.js"></script>
        <script>
            $(document).ready(function() {
                $(".MyForm").formly();
            })
        </script>
        <title>Editar Organizaci&oacute;n</title>
    </head>
    <body class="background">

        <%-- inicio del contenido --%>
        <div id="contenido">
                <h1>Editar Organizacion</h1>
                <form:form name="altaOrganizacion" commandName="instancia" class="MyForm" action="gdaAltaOrganizacion.do"  method="POST" style="width:60%;" >
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre de la Organizaci&oacute;n:</label> </td>
                            <td> 
                                <form:input path="nombre" id="nombre" size="20"/>
                                <form:errors path="nombre" cssClass="error"/>
                                <!--input type="text" name="name" id="nombre" size="20" require="true" /-->                                
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="rfc">RFC:</label> </td>
                            <td>  
                                <form:input path="rfc" id="rfc" size="20"/>
                                <form:errors path="rfc" cssClass="error"/>
                                <!--input type="text" name="rfc" id="rfc" size="20" require="true" /-->
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="titular">Titular:</label></td>
                            <td>  
                                <form:input path="titular" id="titular" size="20"/>
                                <form:errors path="titular" cssClass="error"/>
                                <!--input type="text" name="titlar" id="titular" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="puesto">Puesto:</label></td>
                            <td>  
                                <form:input path="puesto" id="puesto" size="20"/>
                                <form:errors path="puesto" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="telefono">Tel&eacute;fono:</label></td>
                            <td>  
                                <form:input path="telefono" id="telefono" size="20"/>
                                <form:errors path="telefono" cssClass="error"/>
                                <!--input type="text" name="lugar" id="telefono" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="calle">Calle:</label></td>
                            <td>  
                                <form:input path="domicilio" id="domicilio" size="20"/>
                                <form:errors path="domicilio" cssClass="error"/>
                                <!--input type="text" name="lugar" id="domicilio" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="codigo_postal">C&oacute;digo Postal:</label></td>
                            <td> <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" require="true" value="${instancia.idColonia.idCp.cp}"></td>  
                        </tr>
                        <tr>
                            <td>  <label for="estado">Estado:</label></td>
                            <td>  <!--input type="text" name="estado" id="estado" size="20" require="true" disabled="true"/--> 
                                <select name="estado" id="estado" disabled="true">                                   
                                    <core:forEach items="${estados}" var="estados">
                                        <option value="${estados.idEstado}">${estados.nombre}</option>
                                    </core:forEach> 
                                </select>
                            </td>  
                        </tr>                        
                        <tr>
                            <td>  <label for="municipio">Municipio:</label></td>
                            <td>  <!--input type="text" name="lugar" id="municipio" size="20" require="true" disabled="true"/--> 
                                <select name="municipio" id="municipio" disabled="true"></select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="ciudad">Ciudad</label></td>
                            <td>  <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                <select name="ciudad" id="ciudad" disabled="true"></select>
                            </td>  
                        </tr>
                        <tr>
                            <td>
                                <input id="nombre_colonia" path="nombre_colonia" value="${instancia.idColonia.nombre}" hidden="hidden"/>
                                <label for="colonia">Colonia:</label></td>
                            <td>  
                                <div id="notice"></div>
                                <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                <form:select id="idColonia" path="${colonia.idColonia}" name="idColonia"></form:select> 
                                    <div id="otra_colonia" style="display:none;">
                                        <input type="text" name="otra_colonia" id="otra_colonia"/>
                                        <!--form:input path="usuario" id="usuario" size="20"/-->
                                    </div>
                                <form:errors path="idColonia" cssClass="error"/>
                            </td>  
                        </tr>                     
                        <tr>
                            <td> <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <select id="tipoOrganizacion" name="tipoOrganizacion">
                                    <core:forEach items="${tipoOrganizaciones}" var="current">
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
                                <form:errors path="tipoOrganizacion" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td colspan="2"><h3>Datos de contacto y de acceso:</h3></td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Nombre de Usuario:</label></td>
                            <td>  
                                <form:input path="usuario" id="usuario" size="20"/>
                                <form:errors path="usuario" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/-->
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  
                                <form:input path="correo" id="correo" size="20"/>
                                <form:errors path="correo" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Contrase&ntilde;a:</label></td>
                            <td>  
                                <form:input path="password" id="password" size="20" type="password"/>
                                <form:errors path="password" cssClass="error"/>
                                <!--input type="password" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Confirmar Contrase&ntilde;a:</label></td>
                            <td>  <input type="password" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>                        
                        <tr> 
                            <td></td>
                            <td><input type ="submit" value = "Guardar cambios" /></td>
                        </tr>

                    </table>
                </form:form>
                <br/>
        </div>
    </body>
</html>

