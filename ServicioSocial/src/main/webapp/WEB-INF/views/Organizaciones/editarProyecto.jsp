<%-- 
    Document   : editarProyecto
    Created on : 24/06/2013, 12:05:09 PM
    Author     : Regules
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-14">
                    <div class="panel-heading"><h1>Editar Organizacion</h1></div> 
                    <div class="panel-body">
                    <form:form name="modificarProyecto" commandName="proyecto" class="MyForm" action="modificarProyecto.do" method="POST" >
                        <p>${error_sql}</p>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Datos del Proyecto:</h4></div>
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombre">Nombre del Proyecto:</label>
                                        <form:hidden path="idProyecto" id="idProyecto" size="20"/>
                                        <form:hidden path="estatus" id="estatus" size="20"/>
                                        <form:input path="nombre" id="nombre" class="form-control"/><br/>
                                        <form:errors path="nombre" cssClass="alert alert-danger"/>${nombre}
                                    </div>
                                    <div class="form-group">
                                        <label for="vacantes">N&uacute;mero de Vacantes:</label>
                                        <form:input path="vacantes" id="vacantes" class="form-control"/><br/>
                                        <form:errors path="vacantes" cssClass="alert alert-danger"/>${vacantes}
                                    </div>
                                    <div class="form-group">
                                        <label for="vacantes">N&uacute;mero de Vacantes disponibles:</label>
                                        <form:input path="vacantesDisponibles" id="vacantesDisponibles" class="form-control"/><br/>
                                        <form:errors path="vacantesDisponibles" cssClass="error"/>${error_vacantes_disponibles}
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="semestre">Instancia/Organizaci&oacute;n:</label>
                                        <form:select id="organizacion" path="idInstancia.idInstancia" name="organizacion" class="combobox-autocomplete form-control">
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
                                    </div>
                                    <div class="form-group">
                                        <label for="validacionAdmin">Validación:</label>
                                        <form:select id="validacionAdmin" path="validacionAdmin" name="validacionAdmin" class="combobox-autocomplete form-control">
                                            <form:option  value="0">Rechzada</form:option>
                                            <form:option  value="1">Aceptada</form:option>
                                        </form:select><br/>
                                    </div>
                                    <div class="form-group">
                                        <label for="lugar">Tipo de Proyecto:</label>
                                        <form:select id="tipo_proyecto" path="idTipoProyecto.idTipoProyecto" name="tipo_proyecto" class="combobox-autocomplete form-control">
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
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Perfiles para el Proyecto:</h4></div>
                            <div class="panel-body">
                                <fieldset>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <p>Perfiles Seleccionados:</p>
                                        <select name="selectfrom" id="select-from" multiple size="5" class="combobox-autocomplete form-control">
                                            <core:forEach items="${damePerfilesDelProyecto}" var="current">
                                                <option value="${current.idPerfil}">${current.nombre}</option>
                                            </core:forEach>
                                            <core:forEach items="${perfilesSonProyecto}" var="current">
                                                <option value="${current.idPerfil}">${current.nombre}</option>
                                            </core:forEach>
                                        </select>
                                        <a href="JavaScript:void(0);" id="btn-add" class="btn btn-primary">Quitar &raquo;</a>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <p>Perfiles Disponibles:</p>
                                        <select name="selectto" id="select-to" multiple size="5" class="combobox-autocomplete form-control">
                                            <core:forEach items="${perfilesProyectoEx}" var="current">
                                                <option value="${current.idPerfil}">${current.nombre}</option>
                                            </core:forEach>
                                        </select>
                                        <a href="JavaScript:void(0);" id="btn-remove" class="btn btn-primary">&laquo; Agregar</a>
                                    </div>
                                </div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Actividades del Proyecto:</h4></div>
                            <div class="panel-body">
                                <div class="alert alert-warning"><h4>Mínimo deben ser 2 actividades y máximo pueden ser 5 actividades.</h4></div>
                                <div class="col-md-12 form-group ">
                                    <select name="prueba01" id="prueba01" hidden="hidden">
                                        <core:forEach items="${proyecto.actividadesCollection}" var="actividadesProyecto">
                                            <core:choose>
                                                <core:when test="${actividadesProyecto.estatus==1}">
                                                    <option value="${actividadesProyecto.detalle}"></option>
                                                </core:when>
                                            </core:choose>
                                            <%--<option value="${actividadesProyecto.detalle}"></option>--%>
                                        </core:forEach>
                                        <core:forEach items="${actividadAux}" var="actividadesw">
                                            <option value="${actividadesw}"></option>
                                        </core:forEach>
                                    </select>
                                    <p><input type ="button" id="agregarActividad" value = "Agregar Actividad" class="btn btn-primary"/></p>
                                    <ol style="list-style-type: none;" id="actividades"></ol>
                                    <input type="hidden" name="nActividades" id="nActividades" value="0">
                                    <input type="hidden" name="cadenaActividades" id="cadenaActividades">
                                </div>
                            </div>
                            ${validacion_actividades}
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Datos del Programa:</h4></div>
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="lugar">Programa:</label>
                                        <form:select id="programa" path="idPrograma.idPrograma" name="programa" class="combobox-autocomplete form-control">
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
                                    </div>
                                    <div class="form-group">
                                        <label for="modalidad">Modalidad del Programa:</label>
                                        <form:select id="modalidad" path="modalidad" name="modalidad" class="combobox-autocomplete form-control">
                                            <form:option  value="I">INTERNO</form:option>
                                            <form:option  value="E">EXTERNO</form:option>
                                        </form:select><br/>
                                    </div>
                                    <div class="form-group">
                                        <label for="lugar">Domicilio del Programa:</label>
                                        <form:input path="domicilio" id="domicilio" class="form-control"/><br/>
                                        <form:errors path="domicilio" cssClass="alert alert-danger"/>${domicilio}
                                    </div>
                                    <div class="form-group">
                                        <label for="codigo_postal">C&oacute;digo Postal:</label>
                                        <input type="text" name="codigo_postal" id="codigo_postal" class="form-control" maxlength="5" require="true" value="${proyectoDireccion.idColonia.idCp.cp}">
                                        <input type="hidden" id="preCP" value="${cp}"/><br>${error_codigo_postal}
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="estado">Estado:</label>
                                        <select name="estado" id="estado" disabled="true" class="form-control">                                   
                                            <core:forEach items="${estados}" var="estados">
                                                <option value="${estados.idEstado}">${estados.nombre}</option>
                                            </core:forEach> 
                                        </select><br/>
                                    </div>
                                    <div class="form-group">
                                        <label for="municipio">Municipio:</label>
                                        <select name="municipio" id="municipio" disabled="true" class="form-control"></select><br/>
                                    </div>
                                    <div class="form-group">
                                        <label for="ciudad">Ciudad:</label>
                                        <select name="ciudad" id="ciudad" disabled="true" class="form-control"></select><br/>
                                    </div>
                                    <div class="form-group">
                                        <input id="nombre_colonia" path="nombre_colonia" value="${proyecto.idColonia.nombre}" hidden="hidden"/>
                                        <label for="colonia">Colonia:</label>
                                        <div id="notice"></div>
                                        <form:select id="idColonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select> <br/>
                                            <div id="otra_colonia" style="display:none;">
                                                <input type="text" name="otra_colonia" id="otra_colonia" class="form-control"/>
                                            </div>
                                        <form:errors path="idColonia.idColonia" cssClass="error"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Datos del Responsable:</h4></div>
                            <div class="panel-body">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="lugar">Responsable del Programa:</label>
                                        <form:input path="nombreResponsable" id="nombreResponsable" class="form-control"/><br/>
                                        <form:errors path="nombreResponsable" cssClass="alert alert-danger"/>${responsable}
                                    </div>
                                    <div class="form-group">
                                        <label for="lugar">Puesto del Responsable:</label>
                                        <form:input path="responsablePuesto" id="responsablePuesto" class="form-control"/><br/>
                                        <form:errors path="responsablePuesto" cssClass="alert alert-danger"/>${puesto}
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label for="lugar">Tel&eacute;fono del Responsable:</label>                         
                                            <form:input path="telefonoResponsable" id="telefono" size="20" maxlength="10" class="form-control"/>                       
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="lugar">Ext:</label>                         
                                            <form:input path="ext" id="ext" size="7" maxlength="7" class="form-control"/><br/>                         
                                        </div>
                                        ${telefono} 
                                    </div>
                                </div>
                            </div>            
                        </div>
                        <div class="col-sm-5">
                            <input id="envia" class="btn btn-primary" type = "submit" value = "Guardar cambios" /> 
                        </div>
                    </form:form> 
                    </div>
                </div>
                
                <%@include file="../General/footer.jsp"%>
            </div><!--/row-->            
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
        <script src="js/cargaCodigosPostalesParaEditarOP.js"></script>
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
                $("#actividades").append("<li><input type='text' size='90' maxlength='90' name='actividades[" + nActividades + "]' class='actividad form-control' id='" + nActividades + "' required='true' value='" + valor + "'/><input type ='button' class='borrar btn btn-primary' value = 'Quitar' /></li>");
                masActividad();
                console.log("Actividad agregada");
            }
        }

        function agregarActividad() {
            console.log("Pretendiendo agregar actividad, nActividades:" + nActividades);
            if (nActividades < 5) {
                $("#actividades").append("<li><input type='text' size='90' maxlength='90' name='actividades[" + nActividades + "]' class='actividad form-control' id='" + nActividades + "' required='true'/><input type ='button' class='borrar btn btn-primary' value = 'Quitar'  /></li>");
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
    
    </body>
</html>
