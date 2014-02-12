<%-- 
    Document   : registroOrganizaciones
    Created on : 10-jun-2013, 11:59:36
    Author     : bustedvillain
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
                <%@include file="../General/menuPrincipal.jsp"%> 
            </div>
            <div class="row ">
                <!---------------------------------------------Contenido------------------------------------------->                
                <div class="col-md-10 col-md-offset-1">
                    <h1>Registro de Organizaciones</h1>
                    <div class="panel panel-warning ">
                        <div class="panel-heading"><h3>Busque si la Organizaci&oacute;n ya esta pre-registrada</h3></div>
                        <div class="panel-body">
                            <form:form name="altaOrganizacion" class="form-horizontal" action="confirmaOrganizacionVisitante.do" method="POST" >
                                <div class="col-md-8 col-md-offset-2">
                                    <div class="form-group">
                                        <label for="nombre-organizacion">Organizaci&oacute;n:</label> 
                                        <select name="idInstancia" id="idInstancia" class="combobox-autocomplete form-control">
                                            <option value="">Busqueda de Organizaci&oacute;n</option>
                                            <core:forEach items="${preOrganizaciones}" var="organizacion">
                                                <option value="${organizacion.idInstancia}">${organizacion.nombre}</option>
                                            </core:forEach> 
                                        </select>
                                        <br/>${pre_registro} 
                                    </div>
                                    <div class="form-group">
                                        <input class="btn btn-primary" type ="button" id="btnPreInstancia" value = "Seleccionar Organizaci&oacute;n" /> 
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <div class="panel panel-info">
                        <div class="panel-heading"><h3>Si no encontr&oacute; su Organizaci&oacute;n, reg&iacute;strela:</h3></div> 
                        <div class="panel-body">
                            <form:form name="altaOrganizacion" commandName="instancia"  action="gdaAltaOrganizacion.do"  method="POST"  >
                                <div class="col-md-6">
                                    ${error_sql}
                                    <div class="form-group">
                                        <label for="nombre">Nombre de la Organizaci&oacute;n:</label> 
                                        <form:input class="form-control" placeholder="Nombre de la Organización" path="nombre" id="nombre" size="20"/><br/>
                                        <form:errors path="nombre" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="titular">Titular:</label> 
                                        <form:input path="titular" id="titular" placeholder="Titular" class="form-control" size="20"/><br/>
                                        <form:errors path="titular" cssClass="alert alert-danger"/> 
                                    </div>
                                    <div class="form-group">
                                        <label for="puesto">Puesto:</label> 
                                        <form:input path="puesto" id="puesto" placeholder="Puesto" class="form-control"size="20"/><br/>
                                        <form:errors path="puesto" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="codigo_postal">C&oacute;digo Postal:</label> 
                                        <input type="text" name="codigo_postal"  class="form-control" id="codigo_postal" size="20" maxlength="5" autocomplete="off">
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
                                        <form:input path="domicilio" placeholder="Calle" class="form-control" id="domicilio" size="20"/><br/>
                                        <form:errors path="domicilio" cssClass="alert alert-danger"/> 
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="rfc">RFC:</label>  
                                        <form:input class="form-control" placeholder="RFC" path="rfc" id="rfc" size="20" maxlength="12"/><br/>
                                        <form:errors path="rfc" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Tel&eacute;fono:</label> 
                                        <form:input path="telefono" id="telefono" placeholder="Telefono" class="form-control " size="20" maxlength="10"/>

                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Ext:</label> 

                                        <form:input path="ext" id="ext" size="7" placeholder="Ext" class="form-control" maxlength="7"/><br/>
                                        ${telefono}
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label>  
                                        <form:select  class="form-control"id="tipoOrganizacion" path="TipoOrganizacion.idTipoOrganizacion" name="tipoOrganizacion">
                                            <core:forEach items="${tipoOrganizaciones}" var="tipoOrganizaciones">
                                                <form:option  value="${tipoOrganizaciones.idTipoOrganizacion}">${tipoOrganizaciones.detalle}</form:option>
                                            </core:forEach> 
                                        </form:select>  
                                        <br/><form:errors path="tipoOrganizacion" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading"><h3>Datos de contacto y de acceso:</h3></div>
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label for="lugar">Nombre de Usuario:</label>
                                                <form:input path="usuario" class="form-control" placeholder="Usuario" id="usuario" size="20"/><br/>
                                                ${usuario}

                                            </div>
                                            <div class="form-group">
                                                <label for="lugar">Correo:</label>
                                                <form:input path="correo" class="form-control" placeholder="Correo" id="correo" size="20"/><br/>
                                                <form:errors path="correo" cssClass="alert alert-danger"/>${correo}
                                            </div>
                                            <div class="form-group">
                                                <label for="lugar">Contrase&ntilde;a:</label> 
                                                <form:input class="form-control "path="password" id="password" size="20" type="password"/><br/>
                                                ${password}
                                            </div>
                                            <div class="form-group">
                                                <label for="lugar">Confirmar Contrase&ntilde;a:</label> 
                                                <input type="password" class="form-control" name="confirma_password" id="confirma_password" size="20"/> <br>
                                                ${confirma_password}  
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                            <div class=" col-md-offset-2 col-sm-5">
                                    <input  class="btn btn-primary" type ="reset" value = " Limpiar " />
                                </div>
                                <div class="col-sm-5">
                                    <input   class="btn btn-primary" type ="submit" value = " Guardar " /> 
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <!---------------------------------------------Fin Contenido-------------------------------------------> 
            </div><!--/row--> 
            <%@include file="../General/footer.jsp"%>           
        </div><!--/row-->
    </div> <!-- /container -->
    <%@include file="../General/js.jsp"%>
</body>
</html>
