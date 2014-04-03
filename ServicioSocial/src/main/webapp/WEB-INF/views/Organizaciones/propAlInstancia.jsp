<%-- 
    Document   : propAlInstancia
    Created on : 13-ago-2013, 8:47:17
    Author     : bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/sinJavascript.jsp" %>
        <%@include file="../General/head.jsp"%>
        <script>
            var iniciarAltaPropuestaInstancia = true;
        </script>
        <title>Propuesta de Alumno Instancia/Proyecto</title>
    </head>
    <body>
        <div class="container">
            <div class="row col-md-12">
                <%@include file="../General/banner.jsp"%>  
                <div class="row col-md-10 col-md-offset-2"> 
                    <form:form name="altaPropInstancia" commandName="propuesta" class="MyForm" action="gdaPropAlInstancia.do"  method="POST" style="width:80%;" id="contenido">
                        <div class="panel panel-info">
                            <div class="panel-heading">Datos de la instancia:</div>
                            <div class="panel-body">
                                <input type="hidden" name="datos_personales" value="${datos_personales}">
                                <div class="form-group">
                                    <label for="nombre">Nombre de la Instancia:</label> 

                                    <form:input path="nombre_instancia" id="nombre" size="20" class="form-control"/><br/>
                                    <form:errors path="nombre_instancia" class="alert alert-danger"/>${nombre_instancia}
                                    <!--input type="text" name="name" id="nombre" size="20" require="true" /-->                                

                                </div>
                                <div class="form-group">
                                    <label for="rfc">RFC:</label> 

                                    <form:input path="rfc" id="rfc" size="20" maxlength="12" class="form-control"/><br/>
                                    <form:errors path="rfc" class="alert alert-danger"/>${rfc}
                                    <!--input type="text" name="rfc" id="rfc" size="20" require="true" /-->

                                </div>
                                <div class="form-group">
                                    <label for="titular">Titular:</label>

                                    <form:input path="titular" id="titular" size="20" class="form-control"/><br/>
                                    <form:errors path="titular" class="alert alert-danger"/>${titular}
                                    <!--input type="text" name="titlar" id="titular" size="20" require="true"/--> 

                                </div>
                                <div class="form-group">
                                    <label for="puesto">Puesto:</label>

                                    <form:input path="puesto_titular" id="puesto" size="20" class="form-control"/><br/>
                                    <form:errors path="puesto_titular" class="alert alert-danger"/>${puesto_titular}
                                    <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 

                                </div>
                                <div class="row col-md-12">
                                    <div class="form-group col-md-6">
                                        <label for="telefono">Tel&eacute;fono:</label>
                                        <form:input path="telefono_titular" id="telefono" size="20" maxlength="10" class="form-control"/>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="telefono">Extensi&oacute;n:</label>
                                        <form:input path="ext" id="ext" size="20" maxlength="7" class="form-control"/><br/>
                                    </div>
                                    <!--input type="text" name="lugar" id="telefono" size="20" require="true"/--> 
                                </div>
                                <div class="row col-md-12">
                                    ${telefono}
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="calle">Calle:</label>
                                <form:input path="domicilio_instancia" id="domicilio" size="20" class="form-control"/><br/>
                                <form:errors path="domicilio_instancia" class="alert alert-danger"/>${domicilio_instancia}
                                <!--input type="text" name="lugar" id="domicilio" size="20" require="true"/--> 

                            </div>
                            <div class="form-group">
                                <label for="codigo_postal">C&oacute;digo Postal:</label>
                                <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" class="form-control">
                                <input type="hidden" id="preCP" value="${cp}"/><br>${codigo_postal}

                            </div>
                            <div class="form-group">
                                <label for="estado">Estado:</label>
                                <!--input type="text" name="estado" id="estado" size="20" require="true" disabled="true"/--> 
                                <select name="estado" id="estado" disabled="true" class="form-control">                                   
                                    <core:forEach items="${estados}" var="estados">
                                        <option value="${estados.idEstado}">${estados.nombre}</option>
                                    </core:forEach> 
                                </select>

                            </div>                        
                            <div class="form-group">
                                <label for="municipio">Municipio:</label>
                                <!--input type="text" name="lugar" id="municipio" size="20" require="true" disabled="true"/--> 
                                <select name="municipio" id="municipio" disabled="true" class="form-control"></select>

                            </div>
                            <div class="form-group">
                                <label for="ciudad">Ciudad</label>
                                <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                <select name="ciudad" id="ciudad" disabled="true" class="form-control"></select>

                            </div>
                            <div class="form-group">
                                <label for="colonia">Colonia:</label>

                                <div id="notice"></div>
                                <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                <form:select id="idColonia" path="idColonia_instancia.idColonia" name="idColonia" class="form-control"></form:select> 
                                    <div id="otra_colonia" style="display:none;">
                                        <input type="text" name="otra_colonia" value="${otra_colonia}" class="form-control"/>
                                    <input type="hidden" id="existeCP" name="existeCP" value="true">
                                    <input type="hidden" id="preColonia" value="${idColonia}"/>
                                    ${error_otra_colonia}
                                </div>
                                <br/>

                            </div>                      
                            <div class="form-group">
                                <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label> 

                                <form:select id="tipoOrganizacion" path="TipoOrganizacion.idTipoOrganizacion" name="tipoOrganizacion" class="form-control">
                                    <core:forEach items="${tipoOrganizaciones}" var="tipoOrganizaciones">
                                        <form:option  value="${tipoOrganizaciones.idTipoOrganizacion}">${tipoOrganizaciones.detalle}</form:option>
                                    </core:forEach> 
                                </form:select>  
                                <form:errors path="tipoOrganizacion" class="alert alert-danger"/>

                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">Datos del Proyecto:</div>
                            <div class="panel-body">              
                                <div class="form-group">
                                    <label for="nombre"></label> 

                                    <!--input type="text" name="nombre" id="nombre" size="20" require="true" /-->
                                    <form:input path="nombre_proyecto" id="nombre" size="20" class="form-control"/><br/>
                                    <form:errors path="nombre_proyecto" class="alert alert-danger"/>${nombre_proyecto}

                                </div>
                                <div class="form-group">
                                    <label for="vacantes">N&uacute;mero de Vacantes:</label> 

                                    <!--input type="text" name="rfc" id="vacacntes" size="20" require="true" /-->
                                    <form:input path="vacantes" id="vacantes" size="20" class="form-control"/><br/>
                                    <form:errors path="vacantes" class="alert alert-danger"/>${vacantes}

                                </div>                        
                                <div class="form-group">
                                    <label for="lugar">Responsable del Programa:</label>

                                    <!--input type="text" name="titular" id="titular" size="20" require="true"/--> 
                                    <form:input path="nombreResponsable" id="nombreResponsable" size="20" class="form-control"/><br/>
                                    <form:errors path="nombreResponsable" class="alert alert-danger"/>${nombreResponsable}

                                </div>
                                <div class="form-group">
                                    <label for="lugar">Puesto del Responsable:</label>

                                    <!--input type="text" name="titular" id="titular" size="20" require="true"/--> 
                                    <form:input path="responsablePuesto" id="responsablePuesto" size="20" class="form-control"/><br/>
                                    <form:errors path="responsablePuesto" class="alert alert-danger"/>${responsablePuesto}

                                </div>
                                <div class="row col-md-12">
                                    <div class="form-group col-md-6">
                                        <label for="lugar">Tel&eacute;fono del Responsable:</label>
                                        <form:input path="telefonoResponsable" id="rfc" size="20" maxlength="10" class="form-control"/>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="lugar">Extensi&oacute;n:</label>
                                        <form:input path="ext2" id="ext2" size="20" maxlength="7" class="form-control"/><br/>
                                    </div>
                                    <div class="row col-md-12">
                                        ${telefono2}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lugar">Domicilio del Programa:</label>

                                    <!--input type="text" name="correo" id="puesto" size="20" require="true"/--> 
                                    <form:input path="domicilio_proyecto" id="rfc" size="20" class="form-control"/><br/>
                                    <form:errors path="domicilio_proyecto" class="alert alert-danger"/>${domicilio_proyecto}

                                </div>
                                <div class="form-group">
                                    <label for="codigo_postal">C&oacute;digo Postal:</label>

                                    <input type="text" name="codigo_postal2" id="codigo_postal2" size="20" maxlength="5" autocomplete="off" class="form-control">
                                    <input type="hidden" id="preCP2" value="${cp2}"/><br>${codigo_postal2}

                                </div>
                                <div class="form-group">
                                    <label for="estado">Estado:</label>
                                    <!--input type="text" name="estado" id="estado" size="20" require="true" disabled="true"/--> 
                                    <select name="estado2" id="estado2" disabled="true" class="form-control">                                   
                                        <core:forEach items="${estados}" var="estados">
                                            <option value="${estados.idEstado}">${estados.nombre}</option>
                                        </core:forEach> 
                                    </select>

                                </div>                        
                                <div class="form-group">
                                    <label for="municipio">Municipio:</label>
                                    <!--input type="text" name="lugar" id="municipio" size="20" require="true" disabled="true"/--> 
                                    <select name="municipio2" id="municipio2" disabled="true" class="form-control"></select>

                                </div>
                                <div class="form-group">
                                    <label for="ciudad">Ciudad</label>
                                    <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                    <select name="ciudad2" id="ciudad2" disabled="true" class="form-control"></select>

                                </div>
                                <div class="form-group">
                                    <label for="colonia">Colonia:</label>

                                    <div id="notice2"></div>
                                    <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                    <form:select id="idColonia2" path="idColonia_proyecto.idColonia" name="idColonia" class="form-control"></form:select> 
                                        <div id="otra_colonia2" style="display:none;">
                                            <input type="text" name="otra_colonia2" value="${otra_colonia2}" class="form-control"/>
                                        <input type="hidden" id="existeCP2" name="existeCP2" value="true">
                                        <input type="hidden" id="preColonia2" value="${idColonia2}"/>
                                        ${error_otra_colonia2}
                                    </div>
                                    <br/>

                                </div>  
                                <div class="form-group">
                                    <label for="lugar">Tipo de Proyecto:</label>
                                    <form:select id="tipoProyecto" path="idTipoProyecto.idTipoProyecto" name="tipoProyecto" class="form-control">
                                        <core:forEach items="${tipoProyecto}" var="tipoProyecto">
                                            <form:option  value="${tipoProyecto.idTipoProyecto}">${tipoProyecto.descripcion}</form:option>
                                        </core:forEach> 
                                    </form:select>

                                </div>
                                <div class="form-group">
                                    <label for="lugar">Programa:</label>

                                    <form:select id="programa" path="idPrograma.idPrograma" name="programa" class="form-control">
                                        <core:forEach items="${programas}" var="programa">
                                            <form:option  value="${programa.idPrograma}">${programa.descripcion}</form:option>
                                        </core:forEach> 
                                    </form:select>

                                </div>
                                <div class="form-group">
                                    <label for="modalidad">Modalidad</label>
                                    <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                    <form:select id="modalidad" path="modalidad" name="modalidad" class="form-control">
                                        <form:option  value="I">INTERNO</form:option>
                                        <form:option  value="E">EXTERNO</form:option>
                                    </form:select>

                                </div>
                                <div class="form-group">
                                    <label for="perfil">Perfil buscado:</label>
                                    <p>Perfiles Disponibles:</p>
                                    <select name="selectfrom" id="select-from" multiple size="9" class="form-control">
                                        <core:forEach items="${perfiles}" var="perfil">
                                            <option value="${perfil.idPerfil}">${perfil.nombre}</option>
                                        </core:forEach>
                                    </select>

                                    <a href="JavaScript:void(0);" id="btn-add" class="btn btn-primary">Agregar &raquo; </a>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <p>Perfiles Seleccionados:</p>
                                        <select name="selectto" id="select-to" multiple size="9"></select>     
                                    </div>
                                    <a href="JavaScript:void(0);" id="btn-remove" class="btn btn-primary">&laquo; Quitar</a>
                                </div>
                                <h5 class="text-warning"><span class="glyphicon glyphicon-info-sign"></span>&nbsp; Escoja el perfil que desea de los disponibles y de click Agregar para moverlo a los seleccionados. Y a su vez si desea remover un perfil seleccionado, escojalo en los seleccionados y de click en Quitar.</h5>
                                <div class="row">
                                    <div class="form-group">
                                        <label for="lugar">Actividades:</label><br/>
                                        <p><input type ="button" id="agregarActividad" value = "Agregar Actividad" class="btn btn-primary" /></p>
                                        <ol id="actividades" style="width:500px;"></ol>
                                    </div> 
                                    <input type="hidden" name="nActividades" id="nActividades" value="0">
                                    <input type="hidden" name="PrenActividades" id="PrenActividades" value="${nActividades}">
                                    <input type="hidden" name="cadenaActividades" id="cadenaActividades">

                                    <input type="hidden" id="actividad0" value="${actividad0}">
                                    <input type="hidden" id="actividad1" value="${actividad1}">
                                    <input type="hidden" id="actividad2" value="${actividad2}">
                                    <input type="hidden" id="actividad3" value="${actividad3}">
                                    <input type="hidden" id="actividad4" value="${actividad4}">
                                </div>
                                <div class="row"><p>${validacion_actividades}</p></div>


                                <input type="hidden" name="nActividades" value="0">
                                <input type="hidden" name="nPerfiles" value="0">
                                <div class="row">&nbsp;</div>
                                <div class="col-md-12 col-md-offset-3">
                                    <div class="form-group"> 
                                        <input type ="button" value = "Guardar" id="btnGdaPropAlInst" class="btn btn-primary" /> 
                                        <input type ="reset" value = "Limpiar" class="btn btn-primary" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%> 
        <script src="js/jquery.codigos.postales.js"></script>       
     <script src="js/jquery.manolo.js"></script>
        <!--<a onclick="$.fancybox.close();">Redireccion</a>-->

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
    </body>
</html>
