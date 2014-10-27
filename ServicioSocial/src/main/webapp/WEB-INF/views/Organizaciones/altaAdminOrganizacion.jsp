<%-- 
    Document   : altaAdminOrganizacion
    Created on : 07-jun-2013, 14:29:04
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
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list"></span>&nbsp; Nueva Organizaci&oacute;n</h1></div>
                <div class="row col-md-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">Alta Organizaci&oacute;n</div> 
                        <div class="panel-body">
                            <form:form name="altaOrganizacion" commandName="instancia" class="MyForm" action="gdaAdminAltaOrganizacion.do"  method="POST">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombre">Nombre de la Organizaci&oacute;n:</label>                               
                                        <form:input path="nombre" id="nombre" size="20" class="form-control" placeholder="Introduzca �nicamente caracteres alfanum�ricos"/><br/>
                                        <form:errors path="nombre" class="alert alert-danger" />
                                        ${error_sql}
                                    </div>

                                    <div class="form-group">
                                        <label for="rfc">RFC:</label> 
                                        <form:input path="rfc" id="rfc" size="20" maxlength="13" class="form-control" placeholder="RFC debe tener entre 12 y 13 caraceres" /><br/>
                                        <form:errors path="rfc" class="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label> 
                                        <form:select id="tipoOrganizacion" path="TipoOrganizacion.idTipoOrganizacion" name="tipoOrganizacion" class="form-control">
                                            <core:forEach items="${tipoOrganizaciones}" var="tipoOrganizaciones">
                                                <form:option  value="${tipoOrganizaciones.idTipoOrganizacion}">${tipoOrganizaciones.detalle}</form:option>
                                            </core:forEach> 
                                        </form:select><br/>
                                        <form:errors path="tipoOrganizacion" class="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="calle">Calle:</label>
                                        <form:input path="domicilio" id="domicilio" size="20" class="form-control" placeholder="Ingrese su calle"/><br/>
                                        <form:errors path="domicilio" class="alert alert-danger"/>
                                    </div>
                                      <div class="form-group">
                                        <input type ="submit" value = "Guardar Nueva Organizaci�n" class="btn btn-primary" /> 
                                    </div>
                                </div>
                                <div class="col-md-6">

                                    <div class="form-group">
                                        <label for="codigo_postal">C&oacute;digo Postal:</label>
                                        <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" class="form-control" placeholder="Solo numeros">
                                        <input type="hidden" id="preCP" value="${cp}"/><br/>
                                        ${error_codigo_postal}
                                    </div>
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
                                        <!--input type="text" name="lugar" id="municipio" size="20" require="true" disabled="true"/--> 
                                        <select name="municipio" id="municipio" disabled="true" class="form-control"></select><br/>
                                    </div>

                                    <div class="form-group">
                                        <label for="ciudad">Ciudad:</label>
                                        <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                        <select name="ciudad" id="ciudad" disabled="true" class="form-control"></select><br/>
                                    </div>
                                    <div class="form-group">
                                        <label for="colonia">Colonia:</label>
                                        <div id="notice"></div>
                                        <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                        <form:select id="idColonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select> 
                                        </div>
                                        <div id="otra_colonia" style="display:none;">
                                            <input type="text" name="otra_colonia" value="${otra_colonia}" class="form-control"/>
                                        <input type="hidden" id="existeCP" name="existeCP" value="true">
                                        <input type="hidden" id="preColonia" value="${idColonia}"/>
                                        ${error_otra_colonia}
                                    </div>
                                    <br>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
          <!-- Javascript -->
        <script src="js/jquery.codigos.postales.js"></script>       
        <script src="js/jquery.manolo.js"></script>
<!--        <script src="js/instancias.js"></script>
        <script src="js/jquery-1.9.1.js"></script>-->
    </body>
</html>
