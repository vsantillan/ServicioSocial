<%-- 
    Document   : altaAdminProyecto
    Created on : 07-jun-2013, 14:29:16
    Author     : bustedvillain
--%>


<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>  
        <title>Administrador</title> 
        <script>
            var iniciarAltaAdminProyecto = true;
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>                    

                <div class="row col-md-14">
                    <div class="panel-heading"> <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-list"></span>&nbsp; Nuevo Proyecto</h2></div></div> 
                    <div class="panel-body">
                        <form:form  name="altaOrganizacion" modelAttribute="proyecto" class="MyForm" action="gdaAltaAdminProyecto.do" method="POST">
                            <p>${error_sql}</p>
                            <br>
                            <br>
                            <br>
                            <div class="panel panel-info">
                                <div class="panel-heading"><h4>Datos del Proyecto:</h4></div>
                                <div class="panel-body">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="nombre">Nombre del Proyecto:</label> 
                                            <form:input path="nombre" id="nombre" size="20" class="form-control"/><br/>
                                            <form:errors path="nombre" cssClass="error"/>${nombre}

                                        </div>
                                        <div class="form-group">
                                            <label for="vacantes">Número de Vacantes:</label>
                                            <form:input path="vacantes" id="vacantes" class="form-control"/><br/>
                                            <form:errors path="vacantes" cssClass="alert alert-danger"/>${vacantes}
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="semestre">Instancia/Organización:</label>
                                            <form:select id="idInstancia" path="idInstancia.idInstancia" name="idInstancia" class="form-control">
                                                <core:forEach items="${instancias}" var="instancia">
                                                    <form:option  value="${instancia.idInstancia}">${instancia.nombre}</form:option>
                                                </core:forEach> 
                                            </form:select><br/>
                                            <form:errors path="idInstancia.idInstancia" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="lugar">Tipo de Proyecto:</label>
                                            <form:select id="tipoProyecto" path="idTipoProyecto.idTipoProyecto" name="tipoProyecto" class="form-control">
                                                <core:forEach items="${tipoProyecto}" var="tipoProyecto">
                                                    <form:option  value="${tipoProyecto.idTipoProyecto}">${tipoProyecto.descripcion}</form:option>
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
                                                </select>
                                                <br/><a href="JavaScript:void(0);" id="btn-add" class="btn btn-primary">Quitar &raquo;</a>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <p>Perfiles Disponibles:</p>
                                                <select name="selectto" id="select-to" multiple size="5" class="combobox-autocomplete form-control">
                                                    <core:forEach items="${perfiles}" var="current">
                                                        <option value="${current.idPerfil}">${current.nombre}</option>
                                                    </core:forEach>
                                                </select>
                                                <br/><a href="JavaScript:void(0);" id="btn-remove" class="btn btn-primary">&laquo; Agregar</a>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <div class="alert alert-warning"><h5>Nota: Escoja el perfil que desea de los disponibles y de click Agregar para moverlo a los seleccionados. Y a su vez si desea remover un perfil seleccionado, escojalo en los seleccionados y de click en Quitar.</h5></div>
                                </div>
                            </div>
                            <div class="panel panel-info">
                                <div class="panel-heading"><h4>Actividades del Proyecto:</h4></div>
                                <div class="panel-body">
                                    <div class="alert alert-warning"><h4>Mínimo deben ser 2 actividades y máximo pueden ser 5 actividades.</h4></div>
                                    <div class="col-md-12 form-group ">
                                        <p><input type ="button" id="agregarActividad" value = "Agregar Actividad" class="btn btn-primary"/></p>
                                        <ol id="actividades"></ol>
                                    </div>
                                </div>
                                <input type="hidden" name="nActividades" id="nActividades" value="0">
                                <input type="hidden" name="PrenActividades" id="PrenActividades" value="${nActividades}">
                                <input type="hidden" name="cadenaActividades" id="cadenaActividades">
                                <input type="hidden" name="cadenaPerfiles" id="cadenaPerfiles">

                                <input type="hidden" id="actividad0" value="${actividad0}" >
                                <input type="hidden" id="actividad1" value="${actividad1}">
                                <input type="hidden" id="actividad2" value="${actividad2}">
                                <input type="hidden" id="actividad3" value="${actividad3}">
                                <input type="hidden" id="actividad4" value="${actividad4}">
                                ${validacion_actividades}
                            </div>
                            <div class="panel panel-info">
                                <div class="panel-heading"><h4>Datos del Programa:</h4></div>
                                <div class="panel-body">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="lugar">Programa:</label>
                                            <form:select id="programa" path="idPrograma.idPrograma" name="programa" class="form-control">
                                                <core:forEach items="${programas}" var="programa">
                                                    <form:option  value="${programa.idPrograma}">${programa.descripcion}</form:option>
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
                                            <label for="lugar">Domicilio del Programa (Solo la calle):</label>
                                            <form:input path="domicilio" id="domicilio" class="form-control"/><br/>
                                            <form:errors path="domicilio" cssClass="alert alert-danger"/>${domicilio}
                                        </div>
                                        <div class="form-group">
                                            <label for="codigo_postal">Código Postal:</label>
                                            <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" class="form-control">
                                            <input type="hidden" id="preCP" value="${cp}"/><br>${codigo_postal}
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
                                            <label for="colonia">Colonia:</label>
                                            <div id="notice"></div>
                                            <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                            <form:select id="idColonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select> 
                                                <div id="otra_colonia" style="display:none;">
                                                    <input type="text" name="otra_colonia" value="${otra_colonia}" class="form-control"/>
                                                <input type="hidden" id="existeCP" name="existeCP" value="true">
                                                <input type="hidden" id="preColonia" value="${idColonia}"/>
                                                ${error_otra_colonia}
                                            </div><br/>
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
                                                <label for="lugar">Teléono del Responsable:</label>                         
                                                <form:input path="telefonoResponsable" id="telefono" size="20" maxlength="10" class="form-control"/>                       
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="lugar">Extensión:</label>                         
                                                <form:input path="ext" id="ext" size="7" maxlength="7" class="form-control"/><br/>                         
                                            </div>
                                        </div>
                                        ${telefono} 
                                    </div>
                                </div>            
                            </div>
                            <div class="col-md-offset-10">
                                <input id="btnGdaAdminProyecto" class="btn btn-primary guardar" type = "submit" value = "Guardar Nuevo Proyecto" /> 
                            </div>
                        </form:form> 
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>
        <script>
            $('a#btn-add').click(function () {
                $('#select-from option:selected').each(function () {
                    $('#select-to').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
            $('a#btn-remove').click(function () {
                $('#select-to option:selected').each(function () {
                    $('#select-from').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
        </script>   
</html>
