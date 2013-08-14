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

        <title>Editar Proyecto</title>
    </head>
    <body class="background" onmousedown="elemento(event);">
        <jsp:include page="../Template/banner.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;width:80%">
                <h1>Editar Proyecto</h1>
                <form:form name="modificarProyecto" commandName="proyecto" class="MyForm" action="modificarProyecto.do" method="POST" >
                    <p>${error_sql}</p>
                    <table>
                        <tr>
                            <td><label for="nombre">Nombre del Proyecto:</label>
                                <form:hidden path="idProyecto" id="idProyecto" size="20"/>
                                <form:hidden path="estatus" id="estatus" size="20"/>
                            </td>
                            <td>
                                <form:input path="nombre" id="nombre" size="20"/><br/>
                                <form:errors path="nombre" cssClass="error"/>${nombre}
                            </td>
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                            <td>
                                <form:input path="vacantes" id="vacantes" size="20"/><br/>
                                <form:errors path="vacantes" cssClass="error"/>${vacantes}
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes disponibles:</label> </td>
                            <td>
                                <form:input path="vacantesDisponibles" id="vacantesDisponibles" size="20"/><br/>
                                <form:errors path="vacantesDisponibles" cssClass="error"/>${error_vacantes_disponibles}
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
                                <form:errors path="nombreResponsable" cssClass="error"/>${responsable}
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto del responsable:</label></td>
                            <td>
                                <form:input path="responsablePuesto" id="responsablePuesto" size="20"/><br/>
                                <form:errors path="responsablePuesto" cssClass="error"/>${puesto}
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                            <td>
                                <form:input path="telefonoResponsable" id="telefonoResponsable" size="20"/><br/>
                                <form:errors path="telefonoResponsable" cssClass="error"/>${telefono}
                            </td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio del Programa:</label></td>
                            <td>
                                <form:input path="domicilio" id="domicilio" size="20"/><br/>
                                <form:errors path="domicilio" cssClass="error"/>${domicilio}
                            </td>
                        </tr>
                        <tr>
                            <td>  <label for="codigo_postal">C&oacute;digo Postal:</label></td>
                            <td><input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" require="true" value="${proyectoDireccion.idColonia.idCp.cp}">
                                <input type="hidden" id="preCP" value="${cp}"/><br>${error_codigo_postal}
                            </td> 
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
                            <td>  <label for="lugar">Programa:</label></td>
                            <td>
                                <form:select id="programa" path="idPrograma.idPrograma" name="programa">
                                    <core:forEach items="${programas}" var="programa">
                                        <core:choose>
                                            <core:when test="${programa.idPrograma==proyecto.idPrograma.idPrograma}">
                                        <option value="${programa.idPrograma}" selected="selected">${programa.descripcion}</option>
                                    </core:when>
                                    <core:otherwise>
                                        <option value="${programa.idPrograma}">${programa.descripcion}</option>
                                    </core:otherwise>    
                                </core:choose>
                            </core:forEach>
                        </form:select><br/>
                        <form:errors path="idPrograma.idPrograma" cssClass="error"/>
                        </td>  
                        </tr>
                        <tr>
                            <td>  <label for="modalidad">Modalidad</label></td>
                            <td>  <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                <form:select id="modalidad" path="modalidad" name="modalidad">
                                    <form:option  value="I">INTERNO</form:option>
                                    <form:option  value="E">EXTERNO</form:option>
                                </form:select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="validacionAdmin">Validación:</label></td>
                            <td>
                                <form:select id="validacionAdmin" path="validacionAdmin" name="validacionAdmin">
                                    <form:option  value="0">Rechzada</form:option>
                                    <form:option  value="1">Aceptada</form:option>
                                </form:select>
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
                                        <core:forEach items="${perfilesSonProyecto}" var="current">
                                            <option value="${current.idPerfil}">${current.nombre}</option>
                                        </core:forEach>
                                    </select>

                                    <a href="JavaScript:void(0);" id="btn-add">Quitar &raquo;</a>
                                    <a href="JavaScript:void(0);" id="btn-remove">&laquo; Agregar</a>

                                    <select name="selectto" id="select-to" multiple size="5">
                                        <core:forEach items="${perfilesProyectoEx}" var="current">
                                            <option value="${current.idPerfil}">${current.nombre}</option>
                                        </core:forEach>
                                    </select>
                                </fieldset>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Actividades:</label></td>
                            <td>
                                <select name="prueba01" id="prueba01" hidden="hidden">
                                    <core:forEach items="${proyecto.actividadesCollection}" var="actividades">
                                        <option value="${actividades.detalle}"></option>
                                    </core:forEach>
                                    <core:forEach items="${actividadAux}" var="actividades">
                                        <option value="${actividades}"></option>
                                    </core:forEach>
                                </select>
                                <p><input type ="button" id="agregarActividad" value = "Agregar Actividad" /></p>
                                <ol id="actividades"></ol>
                                <input type="hidden" name="nActividades" id="nActividades" value="0">
                                <input type="hidden" name="cadenaActividades" id="cadenaActividades">

                            </td>  
                        </tr>
                        <tr> 
                            <td> <input type ="submit" value = "Guardar cambios" id="envia"/> </td>
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
        $('input#envia').click(function() {
            $('#select-from option').each(function()
            {
                $(this).attr("selected", "selected");
            });

            var cadenaActividades = "";

            $(".actividad").each(function() {
                console.log("Actividad:" + $(this).val());
                cadenaActividades += $(this).val() + ";";
            });
            console.log("Cadena actividades:" + cadenaActividades);
            document.getElementById("cadenaActividades").value = cadenaActividades;
        });

        var nActividades = 0;
        $('#prueba01 option').each(function()
        {
            agregarActividadIniciales($(this).attr("value"));
        });


        $("input#agregarActividad").click(function() {
            agregarActividad();
        });

        function agregarActividadIniciales(valor)
        {
            console.log("Pretendiendo agregar actividad, nActividades:" + nActividades);
            if (nActividades < 5) {
                $("#actividades").append("<li style='float:left;'><input type='text' size='40' name='actividades[" + nActividades + "]' class='actividad' id='" + nActividades + "' required='true' value='" + valor + "'/><input type ='button' class='borrar' value = 'Quitar'  /></li><br/>");
                masActividad();
                console.log("Actividad agregada");
            }
        }

        function agregarActividad() {
            console.log("Pretendiendo agregar actividad, nActividades:" + nActividades);
            if (nActividades < 5) {
                $("#actividades").append("<li style='float:left;'><input type='text' size='35' name='actividades[" + nActividades + "]' class='actividad' id='" + nActividades + "' required='true'/><input type ='button' class='borrar' value = 'Quitar'  /></li><br/>");
                masActividad();
                console.log("Actividad agregada");
            }
        }

        function masActividad() {
            nActividades++;
            document.getElementById("nActividades").value = nActividades;
            console.log("nActividades local:" + nActividades);
            console.log("nActividades form:" + document.getElementById("nActividades").value);
        }

        function menosActividad() {
            nActividades--;
            document.getElementById("nActividades").value = nActividades;
            console.log("nActividades local:" + nActividades);
            console.log("nActividades form:" + document.getElementById("nActividades").value);

        }

        $("body").on("click", ".borrar", function(event) {
            console.log("Borrar actividad, nActividades:" + nActividades);
            if (nActividades > 2) {
                $(this).closest('li').remove();
                menosActividad();
            }
        });
    </script>
    <jsp:include page="../Template/footer.jsp" />
</body>

</html>
