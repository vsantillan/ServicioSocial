<%-- 
    Document   : editarOrganizacion
    Created on : 19/06/2013, 12:21:32 PM
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
                        <form:form name="modificarOrganizacion" commandName="instancia" class="MyForm" action="modificarOrganizacion.do"  method="POST" >
                            <div class="col-md-6">
                                ${error_sql}
                                <div class="form-group">
                                    <label for="nombre">Nombre de la Organizaci&oacute;n:</label> 
                                    <form:input class="form-control" placeholder="Nombre de la Organización" path="nombre" id="nombre" maxlength="44"/><br/>
                                    <form:hidden path="idInstancia" id="idInstancia" size="20"/>
                                    <form:hidden path="estatus" id="estatus" size="20"/>
                                    <form:errors path="nombre" cssClass="alert alert-danger"/>
                                </div>
                                <div class="form-group">
                                    <label for="titular">Titular:</label> 
                                    <form:input path="titular" id="titular" placeholder="Nombre del Titular" class="form-control" maxlength="45"/><br/>
                                    <form:errors path="titular" cssClass="alert alert-danger"/> 
                                </div>
                                <div class="form-group">
                                    <label for="puesto">Puesto:</label> 
                                    <form:input path="puesto" id="puesto" placeholder="Puesto del Titular" class="form-control" maxlength="45"/><br/>
                                    <form:errors path="puesto" cssClass="alert alert-danger"/>
                                </div>
                                <div class="form-group">
                                    <label for="codigo_postal">C&oacute;digo Postal:</label> 
                                    <input type="text" name="codigo_postal"  class="form-control" id="codigo_postal" size="20" maxlength="5" autocomplete="off" value="${instanciaDireccion.idColonia.idCp.cp}">
                                    <input type="hidden" class="form-control" id="preCP" value="${cp}"/><br>${codigo_postal}  
                                </div>
                                <div class="form-group">
                                    <label for="estado">Estado:</label> 
                                    <select name="estado" class="form-control" id="estado" disabled="true">                                   
                                        <core:forEach items="${estados}" var="estados">
                                            <option value="${estados.idEstado}">${estados.nombre}</option>
                                        </core:forEach> 
                                    </select> 

                                </div>
                                <div class="form-group">
                                    <label for="municipio">Municipio:</label> 
                                    <select name="municipio" class="form-control" id="municipio" disabled="true"></select>
                                </div>
                                <div class="form-group">
                                    <label for="ciudad">Ciudad</label>
                                    <select name="ciudad" class="form-control" id="ciudad" disabled="true"></select>
                                </div>
                                <div class="form-group">
                                    <label for="colonia">Colonia:</label>
                                    <input id="nombre_colonia" path="nombre_colonia" value="${instanciaDireccion.idColonia.nombre}" hidden="hidden"/>
                                    <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                    <div id="notice"></div>
                                    <form:select  class="form-control" id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                        <div id="otra_colonia" style="display:none;">
                                            <input type="text" class="form-control" name="otra_colonia" value="${otra_colonia}"/>
                                        <input type="hidden"  class="form-control" id="existeCP" name="existeCP" value="true">
                                        <input type="hidden" class="form-control" id="preColonia" value="${idColonia}"/>
                                        ${error_otra_colonia}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="calle">Calle:</label> 
                                    <form:input path="domicilio" placeholder="Calle" class="form-control" id="domicilio" maxlength="100"/><br/>
                                    <form:errors path="domicilio" cssClass="alert alert-danger"/> 
                                </div>

                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="rfc">RFC:</label>
                                    <form:input class="form-control" placeholder="RFC" path="rfc" id="rfc" maxlength="12"/><br/>
                                    <form:errors path="rfc" cssClass="alert alert-danger"/>
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Tel&eacute;fono:</label> 
                                    <form:input path="telefono" id="telefono" placeholder="Telefono" class="form-control" maxlength="13"/><br/>
                                    ${telefono}
                                </div>
                                <div class="form-group">
                                    <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label>
                                    <form:select id="tipoOrganizacion" path="tipoOrganizacion.idTipoOrganizacion" name="tipoOrganizacion" class="combobox-autocomplete form-control">
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
                                    </form:select><br/>
                                    <form:errors path="tipoOrganizacion.idTipoOrganizacion" cssClass="alert alert-danger"/>
                                </div>
                                <div class="form-group">
                                    <label for="validacionAdmin">Validación:</label>
                                    <form:select id="validacionAdmin" path="validacionAdmin" name="validacionAdmin" class="combobox-autocomplete form-control">
                                        <form:option  value="0">Rechazada</form:option>
                                        <form:option  value="1">Aceptada</form:option>
                                        <form:option  value="2">Pre-registrada</form:option>
                                    </form:select><br/>
                                </div>
                                <div class="form-group">
                                    <label for="lugar">Nombre de Usuario:</label>
                                    <form:input path="usuario" id="usuario" placeholder="Nombre de Usuario" class="form-control" maxlength="29" /><br/>
                                    <form:errors path="usuario" cssClass="alert alert-danger"/>
                                </div>
                                <div class="form-group">
                                    <label for="lugar">Correo:</label>
                                    <form:input path="correo" id="correo" size="20" placeholder="Correo" class="form-control" maxlength="50"/><br/>
                                    <form:errors path="correo" cssClass="alert alert-danger" />
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group col-md-6">
                                        <label for="lugar">Cambiar contraseña:</label>
                                        <div class="radio">
                                            <input type="radio" name="passG1" id="passG1" value="si" onclick="pass(this)">Cambiar contraseña<br/>
                                        </div>
                                        <div class="radio">
                                            <input type="radio" name="passG1" id="passG1" value="no" onclick="pass(this)" checked="checked">Mantener contraseña<br/>
                                        </div>
                                        ${confirma_password}
                                    </div>
                                    <div class="form-group col-md-6" id="cambiaPass" style="display: none">
                                        <div class="form-group">
                                            <label for="lugar">Contrase&ntilde;a:</label>
                                            <form:input path="password" id="password" class="form-control" type="password"/><br/>
                                            <form:errors path="password" cssClass="alert alert-danger"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="lugar">Confirmar Contrase&ntilde;a:</label>
                                            <input type="text" name="valid_pass" id="valid_pass" size="1" hidden="hidden" value="0"/> 
                                            <input type="password" name="confirma_password" class="form-control" id="confirmPass" /> <br/>
                                        </div>
                                    </div>
                                </div>
                                <div class=" col-md-offset-2 col-sm-5"></div>
                                <div class="col-sm-5">
                                    <input   class="btn btn-primary" type ="submit" value = " Guardar cambios " /> 
                                </div>
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
            function pass(elemento)
            {
                if (elemento.value === "no")
                {
                    document.getElementById("cambiaPass").style.display = "none";
                    document.getElementById("valid_pass").value = 0;
                    document.getElementById("confirmPass").removeAttribute("required");
                } else {
                    document.getElementById("cambiaPass").style.display = "block";
                    document.getElementById("valid_pass").value = 1;
                    document.getElementById("confirmPass").required = "true";
                }
            }
        </script>
    </body>
</html>
