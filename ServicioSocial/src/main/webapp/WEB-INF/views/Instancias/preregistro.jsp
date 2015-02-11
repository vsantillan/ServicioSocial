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
                <%@include file="../PanelOrganizacion/menuPanelOrganizacion.jsp" %>
            </div>
            <div class="">
                <br>
                <form:form id="formulario-prereg" class="formprereg-con" 
                           commandName="instancia" action="preregistrarinstancia.do" 
                           method="POST" style="box-shadow: 0 0 2px 0 #555" >
                    <div class="formprereg-cont-header">
                        <h2>Preregistro de instancia</h2>
                    </div>
                    <h3 class="" style="margin-left: 20px">Instancia</h3>
                    <div class="form-group formprereg-fieldset col-md-6">
                        <label for="nombre">Nombre de la instancia</label>
                        <form:input path="nombre" name="nombre" class="form-control" type="text" placeholder="Nombre de la instancia" />
                        <form:errors path="nombre" class="alert alert-danger"/>
                    </div>
                    
                    <div class="form-group formprereg-fieldset col-md-6">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="rfc">RFC</label>
                                <form:input path="rfc" name="rfc" class="form-control" maxlength="13" type="text" placeholder="RFC de la organización" />
                                <form:errors path="rfc" class="alert alert-danger" />
                                ${rfcError}
                            </div>
                            <div class="col-md-6">
                                <label for="tipo_organizacion">Tipo de Organización:</label>
                                <form:select class="form-control" path="TipoOrganizacion.idTipoOrganizacion">
                                    <form:options items="${tiposOrganizacion}" itemValue="idTipoOrganizacion" itemLabel="detalle" />
                                </form:select>
                                <form:errors path="tipoOrganizacion" class="alert alert-danger"/>
                            </div>
                        </div>
                    </div>

                    <h3 class="" style="margin-left: 20px">Domicilio de la instancia.</h3>
                    <div class="form-group formprereg-fieldset col-md-6">
                        <label for="calle">Calle</label>
                        <form:input path="domicilio" id="calle" size="70" class="form-control" placeholder="Calle" />
                        <form:errors path="domicilio" class="alert alert-danger" />
                        <div class="row">
                            <div class="col-md-6">
                                <br/><label for="municipio">Municipio</label>
                                <input name="municipio" id="municipio-f" class="form-control" placeholder="Municipio" disabled="true" />
                            </div>
                            <div class="col-md-6">
                                <br/><label for="ciudad">Ciudad</label>
                                <input name="ciudad" id="ciudad-f" class="form-control" placeholder="Ciudad" disabled="true" />
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <br/>
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
