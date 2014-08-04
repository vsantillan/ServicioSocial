<%-- 
    Document   : preregistro
    Created on : 21/07/2014, 02:52:42 PM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <%@include file="menuPreregistroInstancia.jsp" %>
            </div>
            <div class="row">
                <br>
                <form:form id="formulario-prereg" class="formprereg-cont" commandName="instancia" action="preregistrarinstancia.do" method="POST">
                    <div class="formprereg-cont-header">
                        <h2>Preregistro de instancia</h2>
                    </div>
                    <div class="form-group formprereg-fieldset col-md-6">
                        <h3 class="">Instancia</h3>
                        <label for="nombre">Nombre de la instancia</label>
                        <form:input path="nombre" name="nombre" class="form-control" type="text" placeholder="Nombre de la instancia" />
                        <form:errors path="nombre" class="alert alert-danger"/>
                        
                        <br/> <label for="rfc">RFC</label>
                        <form:input path="rfc" name="rfc" class="form-control" maxlength="13" type="text" placeholder="RFC de la organización" />
                        <form:errors path="rfc" class="alert alert-danger" />
                        ${rfcError}
                        
                        <br /> <label for="tipo_organizacion">Tipo de Organización:</label> 
                        <core:forEach items="${tiposOrganizacion}" var="tipoOrganizacion">
                            <br/>
                            <form:radiobutton path="TipoOrganizacion.idTipoOrganizacion" value="${tipoOrganizacion.idTipoOrganizacion}" class="formprereg-radiob" />
                            <label for="${tipoOrganizacion.idTipoOrganizacion}" class="formprereg-radiob">${tipoOrganizacion.detalle}</label>
                        </core:forEach>
                        <form:errors path="tipoOrganizacion" class="alert alert-danger"/>
                    </div>
                    
                    <div class="form-group formprereg-fieldset col-md-6">
                        <h3 class="">Titular de la instancia</h3>
                        <label for="titular">Nombre del Titular</label>
                        <form:input path="titular" name="titular" class="form-control" type="text" placeholder="Nombre del titular" />
                        <form:errors path="titular" class="alert alert-danger" />
                        
                        <br /> <label for="puesto">Puesto</label>
                        <form:input path="puesto" name="puesto" class="form-control" type="text" placeholder="Puesto del titular dentro de la instancia" />
                        <form:errors path="puesto" class="alert alert-danger" />
                        
                        <br />
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="telefono">Teléfono</label>
                                <form:input path="telefono" id="telefono" maxlength="10" class="form-control" placeholder="Teléfono" />
                                <br/><form:errors path="telefono" class="alert alert-danger" />
                            </div>
                            <div class="form-group col-md-6">
                                <label for="telefono">Extensión</label>
                                <form:input path="ext" id="ext" maxlength="7" class="form-control" placeholder="Extensión" />
                                <form:errors path="ext" class="alert alert-danger" />
                            </div>
                        </div>
                            
                        <label for="email">Email</label>
                        <form:input path="correo" name="puesto" class="form-control" type="text" placeholder="Correo electrónico del estudiante" />
                        <form:errors path="correo" class="alert alert-danger" />
                        
                        <br />
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="password">Cree una contraseña</label>
                                <form:input path="password" id="password" required="true" class="form-control" type="password" placeholder="Cree una contraseña" />
                                <form:errors path="password" class="alert alert-danger" />
                            </div>
                            <div class="form-group col-md-6">
                                <label for="password-confirm">Confirme su contraseña</label>
                                <input type="password" id="password-confirm" required="true" class="form-control" placeholder="Confirme su contraseña"/>
                                <br><span id="alert-password" class="alert alert-danger" style="display: none">Las contraseñas no coinciden</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <h3 style="margin-left: 15px">Dirección de la Instancia</h3>
                        <div class="col-md-6">
                            <label for="calle">Calle</label>
                            <form:input path="domicilio" id="calle" size="70" class="form-control" placeholder="Calle" />
                            <form:errors path="domicilio" class="alert alert-danger" />
                            <div class="row">
                                <div class="col-md-6">
                                    <br/><label for="municipio">Municipio</label>
                                    <input name="municipio" id="municipio-f" class="form-control" placeholder="Municipio" disabled="true" />
                                </div>
                                <div class="col-md-6">
                                    <br/>   <label for="ciudad">Ciudad</label>
                                    <input name="ciudad" id="ciudad-f" class="form-control" placeholder="Ciudad" disabled="true" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="cp">Código postal</label>
                                    <input name="cp" id="codigo-postal" maxlength="5" class="form-control" placeholder="Código postal" autocomplete="off" required="true" />
                                    <span id="alert-cp" class="alert alert-danger" style="display: none">Introduzca un C.P. valido</span>
                                </div>
                                <div class="col-md-6">
                                    <label for="estado">Estado</label>
                                    <input name="estado" id="estado-f" class="form-control" placeholder="Estado" disabled="true" />
                                </div>
                            </div>
                            <br/><label for="colonia">Colonia</label>
                            <form:select id="combo-colonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select>
                            
                            <br/>
                            <div class="row">
                                <div class="col-md-6"></div>
                                <div class="col-md-6" style="text-align: right">
                                    <input id="send-b" type ="submit" value = "Preregistrar Organización" class="btn btn-primary" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <span>&nbsp</span>
                </form:form>
                <br>
            </div>
            <%@include file="../General/footer.jsp" %>
        </div>
        
        <!-- Javascript -->
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/instancias.js"></script>
    </body>
</html>
