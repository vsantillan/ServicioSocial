f<%-- 
    Document   : regproyecto
    Created on : 11/08/2014, 09:29:48 AM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp" %>
                <%@include file="menuPreregistroInstancia.jsp" %>
            </div>
            <div class="row"> <br />
                
                <!-- Formulario para preregistro de proyecto -->
                <form:form id="formulario-regp" class="formprereg-cont" commandName="proyecto" action="registrarproyecto.do" method="POST">
                    <div class="formprereg-cont-header">
                        <h2>Registro de proyecto</h2>
                    </div>
                    
                    <div class="form-group formprereg-fieldset">
                        <div class="row">
                            <h3>&nbsp;&nbsp;Proyecto</h3>
                            <div class="col-md-8">
                                <label for="nomp">Nombre del proyecto</label>
                                <form:input id="nomp" path="nombre" class="form-control" type="text" placeholder="Nombre del proyecto" required="true" />
                                <form:errors path="nombre" class="alert alert-danger" />
                            </div>
                            <div class="col-md-4">
                                <label for="numv">Número de vacantes</label>
                                <form:input id="numv" path="vacantes" class="form-control" type="number" placeholder="Número de vacantes" required="true" />
                                <form:errors path="vacantes" class="alert alert-danger" />
                            </div>
                            <div class="col-md-8">
                                <br><label for="tipop">Tipo de proyecto</label>
                                <form:select id="tipop" path="idTipoProyecto.idTipoProyecto" name="idTipoP" class="form-control">
                                    <core:forEach items="${tiposP}" var="tipoP">
                                        <form:option value="${tipoP.idTipoProyecto}">${tipoP.descripcion}</form:option>
                                    </core:forEach>
                                </form:select>
                            </div>
                        </div>
                        
                        <div class="row">
                            <br/> <h3>&nbsp;&nbsp;Perfiles para el proyecto</h3>
                            <div class="col-md-6">
                                <label for="perfilesp">Perfiles elegidos</label>
                                <input id="perfiles-proyf" name="perfilesproyecto" class="form-control" type="text" required="true" style="display: none"/>
                                <select name="perfilesp" id="perfilesp" size="5" class="combobox-autocomplete form-control">
                                    
                                </select>
                                <br /><button type="button" id="remove-perfilp" class="btn btn-primary" onclick="removePerfil()" >Quitar perfil</button>
                            </div>
                            <div class="col-md-6">
                                <label for="perfilesp">Perfiles disponibles</label>
                                <select name="perfilesd" id="perfilesd" size="5" class="combobox-autocomplete form-control">
                                    <core:forEach items="${perfiles}" var="perfil">
                                        <option value="${perfil.idPerfil}"> ${perfil.nombre} </option>
                                    </core:forEach>
                                </select>
                                <br /> <button type="button" id="remove-perfilp" class="btn btn-primary" onclick="addPerfil()">Agregar perfil</button>
                            </div>
                        </div>
                            
                        <div class="row">
                            <br /> <h3>&nbsp;&nbsp;Actividades del proyecto</h3>
                            <div class="col-md-6">
                                <label for="act1">Actividad 1</label>
                                <input name="actividad1" class="form-control" type="text" placeholder="Actividad para el proyecto" required="true" />
                                
                                <div id="actividad3"  style="display: none">
                                    <br /><label for="act3">Actividad 3</label>
                                    <input name="actividad3" class="form-control" type="text" placeholder="Actividad para el proyecto" />
                                </div>
                                
                                <div id="actividad5"  style="display: none">
                                    <br /><label for="act5">Actividad 5</label>
                                    <input name="actividad5" class="form-control" type="text" placeholder="Actividad para el proyecto"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="act2">Actividad 2</label>
                                <input name="actividad2" class="form-control" type="text" placeholder="Actividad para el proyecto"  required="true" />

                                <div id="actividad4"  style="display: none">
                                    <br /><label for="act4">Actividad 4</label>
                                    <input name="actividad4" class="form-control" type="text" placeholder="Actividad para el proyecto"/>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="text-align: right; padding-right: 17px; padding-top: 5px;">
                            <br><button type="button" class="btn btn-primary" onclick="addActivity()">Agregar actividad</button>
                        </div>
                        
                        &nbsp;<br>
                        <div class="row">
                            <br /> <h3>&nbsp;&nbsp;Datos del programa</h3>
                            <div class="col-md-6">
                                <label for="programa">Programa</label>
                                <form:select id="combo-programa" path="idPrograma.idPrograma" name="idPrograma" class="form-control">
                                    <core:forEach items="${programas}" var="programa">
                                    <option value="${programa.idPrograma}">${programa.descripcion}</option>
                                    </core:forEach>
                                </form:select>
                            </div>
                            <div class="col-md-6">
                                <label for="modalidad">Modalidad</label>
                                <form:select id="modalidad" path="modalidad" class="form-control" type="text" placeholder="Modalidad" >
                                    <core:forEach items="${modalidades}" var="modalidad">
                                        <option value="${modalidad}">${modalidad}</option>
                                    </core:forEach>
                                </form:select>
                                <form:errors path="Modalidad" class="alert alert-danger" />
                            </div>
                            
                            <div class="col-md-6">
                                <br/> <label for="calle">Domicilio (Solo Calle)</label>
                                <form:input path="domicilio" id="calle" size="70" class="form-control" placeholder="Calle" required="true" />
                                <form:errors path="domicilio" class="alert alert-danger" />
                            </div>
                            <div class="col-md-3">
                                <br/> <label for="cp">Código postal</label>
                                <input name="cp" id="codigo-postal" maxlength="5" class="form-control" placeholder="Código postal" autocomplete="off" required="true" value="${codigop}" >
                                <span id="alert-cp" class="alert alert-danger" style="display: none">Introduzca un C.P. valido</span>
                            </div>
                            <div class="col-md-3">
                                <br/> <label for="estado">Estado</label>
                                <input name="estado" id="estado-f" class="form-control" placeholder="Estado" disabled="true" />
                            </div>
                            
                            <div class="col-md-3">
                                <br/><label for="municipio">Municipio</label>
                                <input name="municipio" id="municipio-f" class="form-control" placeholder="Municipio" disabled="true" />
                            </div>
                            <div class="col-md-3">
                                <br/>   <label for="ciudad">Ciudad</label>
                                <input name="ciudad" id="ciudad-f" class="form-control" placeholder="Ciudad" disabled="true" />
                            </div>
                            <div class="col-md-6">
                                <br/><label for="colonia">Colonia</label>
                                <form:select id="combo-colonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select>
                            </div>
                        </div>
                            
                        <div class="row">
                            <br>
                            <h3>&nbsp;&nbsp;Responsable del proyecto</h3>
                            <div class="col-md-6">
                                <label for="nomresp">Nombre del responsable</label>
                                <form:input id="nomresp" path="nombreResponsable" class="form-control" type="text" placeholder="Nombre del responsable" required="true" />
                                <form:errors path="nombreResponsable" class="alert alert-danger" />
                            </div>
                            <div class="col-md-6">
                                <label for="nomresp">Puesto del responsable</label>
                                <form:input id="puestoresp" path="responsablePuesto" class="form-control" type="text" placeholder="Puesto del responsable" required="true" />
                                <form:errors path="responsablePuesto" class="alert alert-danger" />
                            </div>
                            <div class="col-md-3">
                                <br/> <label for="telresp">Teléfono</label>
                                <form:input id="telresp" path="telefonoResponsable" class="form-control" type="text" placeholder="Teléfono del responsable" required="true" />
                                <form:errors path="telefonoResponsable" class="alert alert-danger" />
                            </div>
                            <div class="col-md-3">
                                <br/> <label for="telresp">Extensión</label>
                                <form:input id="extresp" path="ext" class="form-control" type="text" placeholder="Extensión" maxlength="7" />
                                <form:errors path="ext" class="alert alert-danger" />
                            </div>
                        </div>
                            
                        <div class="row" style="padding-top: 30px; padding-right: 17px; text-align: right" >
                            <button class="btn btn-primary">Registrar proyecto</button>
                        </div>
                    </div>
                </form:form>
                <br/> <br />
            </div>
            <%@include file="../General/footer.jsp" %>
        </div>
        
        <!-- Scripts -->
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/instancias.regproyectos.js"></script>
        
    </body>
</html>
