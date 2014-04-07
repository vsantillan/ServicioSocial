<%-- 
    Document   : confirmaOrganizacionVisitante
    Created on : 07-ago-2013, 12:25:52
    Author     : bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%> 
        <title>Administrador</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuPrincipal.jsp"%> 
                <div class="row col-md-12">
                    <div class="row help-block text-center col-md-12"><h1 class=""><span class="glyphicon glyphicon-list"></span>&nbsp; Completando Pre-Registro</h1></div>
                    <br>
                    <form:form name="altaOrganizacion" commandName="instancia" class="MyForm" action="gdaAltaPreOrganizacion.do"  method="POST" >
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-info">
                                    <div class="panel-heading"><h3>Informaci&oacute;n de la Organizaci&oacute;n:</h3></div> 
                                    <div class="panel-body">
                                        <div class="col-md-6">
                                            <input type="hidden" id="idInstancia" name="idInstancia" value="${idInstancia}">
                                            <div class="form-group">
                                                <label for="nombre">Nombre de la Organizaci&oacute;n:</label>

                                                <form:input path="nombre" id="nombre" size="20" class="form-control" /><br/>
                                                <form:errors path="nombre" class="alert alert-danger"/>
                                                <!--input type="text" name="name" id="nombre" size="20" require="true" /-->                                

                                            </div>
                                            <div class="form-group">
                                                <label for="rfc">RFC:</label> 

                                                <form:input path="rfc" id="rfc" size="20" maxlength="12"class="form-control"/><br/>
                                                <form:errors path="rfc" class="alert alert-danger"/>
                                                <!--input type="text" name="rfc" id="rfc" size="20" require="true" /-->

                                            </div>
                                            <div class="form-group">
                                                <label for="titular">Titular:</label>

                                                <form:input path="titular" id="titular" size="20" class="form-control" /><br/>
                                                <form:errors path="titular" class="alert alert-danger"/>
                                                <!--input type="text" name="titlar" id="titular" size="20" require="true"/--> 

                                            </div>
                                            <div class="form-group">
                                                <label for="puesto">Puesto:</label>

                                                <form:input path="puesto" id="puesto" size="20" class="form-control" /><br/>
                                                <form:errors path="puesto" class="alert alert-danger"/>
                                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 

                                            </div>
                                            <div class="form-group">
                                                <label for="lugar">Tel&eacute;fono del Responsable:</label>
                                                <form:input path="telefono" id="rfc" size="20" maxlength="10" class="form-control" />
                                            </div>
                                            <div class="form-group">
                                                <label for="lugar">Extenci&oacute;n:</label>
                                                <form:input path="ext" id="ext" size="20" maxlength="7" class="form-control" /><br/>
                                                ${telefono}
                                            </div>
                                        <div class="form-group">
                                            <label for="calle">Calle:</label>

                                            <form:input path="domicilio" id="domicilio" size="20" class="form-control" /><br/>
                                            <form:errors path="domicilio" class="alert alert-danger"/>
                                            <!--input type="text" name="lugar" id="domicilio" size="20" require="true"/--> 

                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="codigo_postal">C&oacute;digo Postal:</label>

                                            <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" class="form-control" value="${instanciaDireccion.idColonia.idCp.cp}">
                                            <input type="hidden" id="preCP" value="${cp}" class="form-control"/><br>${codigo_postal}

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
                                            <input id="nombre_colonia" path="nombre_colonia" value="${instanciaDireccion.idColonia.nombre}" hidden="hidden"/>
                                            <div id="notice"></div>
                                            <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                            <form:select  class="form-control" id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                            <div id="otra_colonia" style="display:none;">
                                                <input type="text" class="form-control" name="otra_colonia" value="${otra_colonia}"/>
                                                <input type="hidden"  class="form-control" id="existeCP" name="existeCP" value="true">
                                                <input type="hidden" class="form-control" id="preColonia" value="${idColonia}"/>
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
                                </div>
                            </div>    
                        </div>
                    </div>
                    <div class="panel panel-info col-md-6 col-md-offset-2">
                        <div class="panel-heading"><h3>Datos de contacto y de acceso:</h3></div> 
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="lugar">Nombre de Usuario:</label>
                                <form:input path="usuario" id="usuario" placeholder="Nombre de Usuario" class="form-control" maxlength="29" /><br/>
                                <form:errors path="usuario" cssClass="alert alert-danger"/><br>
                                ${error_usuario}
                            </div>
                            <div class="form-group">
                                <label for="lugar">Correo:</label>
                                <form:input path="correo" id="correo" size="20" placeholder="Correo" class="form-control" maxlength="50"/><br/>
                                <form:errors path="correo" cssClass="alert alert-danger" /><br>
                                  ${error_correo}
                            </div>
                            <div class="form-group">
                                <label for="lugar">Contrase&ntilde;a:</label>
                                <form:input path="password" id="password" size="20" type="password" class="form-control"/><br/>
                                ${password}
                            </div>
                            <div class="form-group">
                                <label for="lugar">Confirmar Contrase&ntilde;a:</label>
                                <input type="password" name="confirma_password" id="confirma_password" size="20" class="form-control"/> <br>
                                ${confirma_password}                           

                            </div> 
                        </div>
                    </div>
                    <div class="row col-md-12 col-md-offset-4">
                        <div class="form-group"> 
                            <input type ="submit" value = "Guardar cambios" class="btn btn-primary" /> 
                        </div>
                    </div>
                </form:form>
                <br/>
            </div>
            <%@include file="../General/footer.jsp"%>  
        </div>
    </div>
    <%@include file="../General/js.jsp"%>
    <script src="js/cargaCodigosPostalesParaEditarOP.js"></script>
</body>
</html>
