<%-- 
    Document   : editarProyecto
    Created on : 24/06/2013, 12:05:09 PM
    Author     : ekt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/metas.jsp" %>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        <link rel="stylesheet" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>
        <script src="js/cargaCodigosPostalesParaEditarOP.js"></script>
        <script src="js/jquery.manolo.js"></script>
        <script>
            $(document).ready(function() {
                $(".MyForm").formly();
            })
        </script>
        <title>Editar Proyecto</title>
    </head>
    <body class="background" onmousedown="elemento(event);">
        <jsp:include page="../Template/banner.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Alta de Proyecto</h1>
                <form:form name="modificarProyecto" commandName="proyecto" class="MyForm" action="modificarProyecto.do" method="POST" >
                    <table>
                        <tr>
                            <td><label for="nombre">Nombre del Proyecto:</label>
                                <form:hidden path="idProyecto" id="idProyecto" size="20"/>
                                <form:hidden path="estatus" id="estatus" size="20"/>
                                <form:hidden path="validacionAdmin" id="validacionAdmin" size="20"/>
                                <form:hidden path="modalidad" id="modalidad" size="20"/>
                            </td>
                            <td>
                                <form:input path="nombre" id="nombre" size="20"/><br/>
                                <form:errors path="nombre" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                            <td>
                                <form:input path="vacantes" id="vacantes" size="20"/><br/>
                                <form:errors path="vacantes" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes disponibles:</label> </td>
                            <td>
                                <form:input path="vacantesDisponibles" id="vacantesDisponibles" size="20"/><br/>
                                <form:errors path="vacantesDisponibles" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td> <label for="semestre">Instancia/Organizaci&oacute;n:</label> </td>
                            <td> 
                                <form:select id="organizacion" path="idInstancia.idInstancia" name="organizacion">
                                    <core:forEach items="${instancia}" var="current">
                                        <core:choose>
                                            <core:when test="${current.idInstancia==proyecto.idInstancia.idInstancia}">
                                        <option value="${current.idInstancia}" selected="selected">${current.nombre}</option>  
                                    </core:when>
                                    <core:otherwise>
                                        <option value="${current.idInstancia}">${current.nombre}</option>  
                                    </core:otherwise> 
                                </core:choose>
                            </core:forEach>
                        </form:select><br/>
                        <form:errors path="idInstancia.idInstancia" cssClass="error"/>
                        </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Responsable del Programa:</label></td>
                            <td>
                                <form:input path="nombreResponsable" id="nombreResponsable" size="20"/><br/>
                                <form:errors path="nombreResponsable" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto del responsable:</label></td>
                            <td>
                                <form:input path="responsablePuesto" id="responsablePuesto" size="20"/><br/>
                                <form:errors path="responsablePuesto" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                            <td>
                                <form:input path="telefonoResponsable" id="telefonoResponsable" size="20"/><br/>
                                <form:errors path="telefonoResponsable" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio del Programa:</label></td>
                            <td>
                                <form:input path="domicilio" id="domicilio" size="20"/><br/>
                                <form:errors path="domicilio" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>  <label for="codigo_postal">C&oacute;digo Postal:</label></td>
                            <td> <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" require="true" value="${proyecto.idColonia.idCp.cp}"></td>  
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
                                <input id="nombre_colonia" path="nombre_colonia" value="${proyecto.idColonia.nombre}" hidden="hidden"/>
                                <label for="colonia">Colonia:</label></td>
                            <td>  
                                <div id="notice"></div>
                                <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                <form:select id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                    <div id="otra_colonia" style="display:none;">
                                        <input type="text" name="otra_colonia" id="otra_colonia"/>
                                        <!--form:input path="usuario" id="usuario" size="20"/-->
                                    </div>
                                <form:errors path="idColonia.idColonia" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td><label for="lugar">Tipo de Proyecto:</label></td>
                            <td>
                                <form:select id="tipo_proyecto" path="idTipoProyecto.idTipoProyecto" name="tipo_proyecto">
                                    <core:forEach items="${tipoProyecto}" var="current">
                                        <core:choose>
                                            <core:when test="${current.idTipoProyecto==proyecto.idTipoProyecto.idTipoProyecto}">
                                        <option value="${current.idTipoProyecto}" selected="selected">${current.descripcion}</option>  
                                    </core:when>
                                    <core:otherwise>
                                        <option value="${current.idTipoProyecto}">${current.descripcion}</option>
                                    </core:otherwise>    
                                </core:choose>
                            </core:forEach>
                        </form:select><br/>
                        <form:errors path="idTipoProyecto.idTipoProyecto" cssClass="error"/>
                        </td>  
                        </tr>
                        <tr>
                            <td><label for="lugar">Perfiles para el proyecto:</label></td>
                            <td>
                                <fieldset>
                                    <select name="selectfrom" id="select-from" multiple size="5">
                                        <core:forEach items="${proyecto.proyectoPerfilCollection}" var="current">
                                            <option value="${current.idPerfil.idPerfil}">${current.idPerfil.nombre}</option>
                                        </core:forEach>
                                    </select>

                                    <a href="JavaScript:void(0);" id="btn-add">Quitar &raquo;</a>
                                    <a href="JavaScript:void(0);" id="btn-remove">&laquo; Agregar</a>

                                    <select name="selectto" id="select-to" multiple size="5">
                                        <core:forEach items="${perfil}" var="current">
                                            <core:forEach items="${proyecto.proyectoPerfilCollection}" var="colleccion">
                                                <core:choose>
                                                    <core:when test="${current.idPerfil==colleccion.idPerfil.idPerfil}">
                                                        <option value="${current.idPerfil}">${current.nombre}</option>
                                                    </core:when>
                                                </core:choose>
                                            </core:forEach>
                                        </core:forEach>
                                    </select>
                                </fieldset>
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
            <div style="clear: both;"/>
        </div>
    </div>
    <script>
            $('a#btn-add').click(function() {
                $('#select-from option:selected').each(function() {
                    $('#select-to').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
            $('a#btn-remove').click(function() {
                $('#select-to option:selected').each(function() {
                    $('#select-from').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
    </script>
    <jsp:include page="../Template/footer.jsp" />
</body>

</html>
