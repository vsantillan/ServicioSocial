<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Panel Organizaci&oacute;n</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="../General/menuOrganizacion.jsp"%>
                <div class="col-md-12">
                    <div class="help-block col-md-12 text-center"><h1><span class="glyphicon glyphicon-user"></span>&nbsp;Bienvenido al Sitio para Organizaciones</h1></div>
                    <div class="row" id="edicionCorrecta" ><center>${mensaje1} ${mensaje}</center></div>
                    <p>&nbsp;</p>
                    <div class="col-md-12">
                        <form:form name="editarOrganizacion" commandName="instancia" class="MyForm" action="gdaEdicionOrganizacion.do"  method="POST" >
                            <div class="panel panel-info">
                                <div class="panel-heading">Perfil de la Organizaci&oacute;n</div>
                                <div class="panel-body">
                                    <div class="col-md-6">
                                        <p>${error_sql}</p>
                                        <input type="hidden" name="idInstancia" value="${instancia.idInstancia}" class="form-control">
                                        <div class="form-group"> 
                                            <label for="nombre">Nombre de la Organizaci&oacute;n:</label> 
                                            <form:input path="nombre" id="nombre" size="20" class="form-control"/><br/>
                                            <form:errors path="nombre" class="alert alert-danger"/>
                                            <!--input type="text" name="name" id="nombre" size="20" require="true" /-->                                
                                        </div>  
                                        <div class="form-group">  
                                            <label for="rfc">RFC:</label> 
                                            <form:input path="rfc" id="rfc" size="20" maxlength="12" class="form-control"/><br/>
                                            <form:errors path="rfc" class="alert alert-danger"/>
                                            <!--input type="text" name="rfc" id="rfc" size="20" require="true" /-->
                                        </div>  
                                        <div class="form-group"> 
                                            <label for="titular">Titular:</label> 
                                            <form:input path="titular" id="titular" size="20" class="form-control"/><br/>
                                            <form:errors path="titular" class="alert alert-danger"/>
                                            <!--input type="text" name="titlar" id="titular" size="20" require="true"/--> 
                                        </div>  
                                        <div class="form-group"> 
                                            <label for="puesto">Puesto:</label>  
                                            <form:input path="puesto" id="puesto" size="20" class="form-control"/><br/>
                                            <form:errors path="puesto" class="alert alert-danger"/>
                                            <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 
                                        </div>  
                                        <div class="row">
                                            <div class="form-group col-md-6">
                                                <label for="telefono">Tel&eacute;fono:</label> 
                                                <form:input path="telefono" id="telefono" size="20"maxlength="10" class="form-control"/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Ext:</label>
                                                <form:input path="ext" id="ext" size="7"maxlength="7" class="form-control"/><br/>
                                                ${telefono}
                                            </div>  
                                        </div>
                                        <div class="form-group">
                                            <label for="calle">Calle:</label> 
                                            <form:input path="domicilio" id="domicilio" size="20" class="form-control"/><br/>
                                            <form:errors path="domicilio" class="alert alert-danger"/>
                                            <!--input type="text" name="lugar" id="domicilio" size="20" require="true"/--> 
                                        </div>  
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="codigo_postal">C&oacute;digo Postal:</label>
                                            <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" value="${instancia.idColonia.idCp.cp}" class="form-control">
                                            <input type="hidden" id="preCP" value="${instancia.idColonia.idCp.cp}" class="form-control"/><br>${codigo_postal}
                                        </div>  
                                        <div class="form-group">
                                            <label for="estado">Estado:</label>
                                            <select name="estado" id="estado" disabled="true" class="form-control">                                   
                                                <core:forEach items="${estados}" var="estados">
                                                    <option value="${estados.idEstado}">${estados.nombre}</option>
                                                </core:forEach> 
                                            </select>
                                        </div>  
                                        <div class="form-group">
                                            <label for="municipio">Municipio:</label>
                                            <select name="municipio" id="municipio" disabled="true" class="form-control"></select>
                                        </div>  
                                        <div class="form-group">  
                                            <label for="ciudad">Ciudad</label>
                                            <select name="ciudad" id="ciudad" disabled="true" class="form-control"></select>
                                        </div>  
                                        <div class="form-group">  
                                            <label for="colonia">Colonia:</label>
                                            <div id="notice"></div>
                                            <form:select id="idColonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select> 
                                                <div id="otra_colonia" style="display:none;">
                                                    <input type="text" name="otra_colonia" value="${otra_colonia}" class="form-control"/>
                                                <input type="hidden" id="existeCP" name="existeCP" value="true">
                                                <input type="hidden" id="preColonia" value="${instancia.idColonia.idColonia}"/>
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
                                            <br/><form:errors path="tipoOrganizacion" class="alert alert-danger"/>
                                        </div>  
                                    </div>
                                </div>
                            </div>
                        </div>
                        &nbsp;
                        <div class="col-md-6 col-md-offset-3">
                            <div class="panel panel-info">
                                <div class="panel-heading">Datos de contacto y de acceso:</div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="lugar">Nombre de Usuario:</label> 
                                        <form:input path="usuario" id="usuario" size="20" class="form-control" /><br/>
                                        ${usuario}

                                    </div>  
                                    <div class="form-group">
                                        <label for="lugar">Correo:</label> 
                                        <form:input path="correo" id="correo" size="20"  class="form-control" /><br/>
                                        <form:errors path="correo" class="alert alert-danger"/>${correo}

                                    </div>  
                                    <div class="form-group">
                                        <label for="lugar">Contrase&ntilde;a:</label> 
                                        <form:input path="password" id="password" size="20" type="password" value="" class="form-control"/><br/>
                                        ${password}
                                        <input type="hidden" name="antiguoPass" value="${instancia.password}">
                                        <div class="alert alert-warning col-md-12">
                                            <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;Si no desea guardar una nueva contrase&ntilde;a deje este campo vac&iacute;o.</h5></div>
                                        </div>

                                    </div>  
                                    <div class="form-group">
                                        <label for="lugar">Confirmar Contrase&ntilde;a:</label> 
                                        <input type="password" name="confirma_password" id="confirma_password" size="20" class="form-control"/> <br>
                                        ${confirma_password}                                  
                                    </div>  
                                </div>
                            </div>                        
                            <div class="row col-md-offset-3">
                                <input type ="submit" value = "Guardar " class="btn btn-primary" />
                                <input type ="reset" value = "Limpiar" class="btn btn-primary" />
                            </div>
                            &nbsp;
                        </div>
                    </form:form>
                    <%@include file="../General/footer.jsp"%> 
                </div>
            </div>
        </div>
        <script>document.getElementById("password").value = "";</script>
        <%@include file="../General/js.jsp"%>
        <script src="js/jquery.codigos.postales.js"></script>       
        <script src="js/jquery.manolo.js"></script>
    </body>
</html>
