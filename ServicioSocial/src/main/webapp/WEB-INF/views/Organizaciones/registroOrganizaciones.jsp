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
                <div class="col-md-6 col-md-offset-3">
                    <h1>Registro de Organizaciones</h1>
                    <p><h4>Busque si la Organizaci&oacute;n ya esta pre-registrada</h4></p>
                    <form:form name="altaOrganizacion" class="form-horizontal" action="confirmaOrganizacionVisitante.do" method="POST" >
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
                    </form:form>
                <p><h4>Si no encontr&oacute; su Organizaci&oacute;n, reg&iacute;strela:</h4></p>
                  <form:form name="altaOrganizacion" commandName="instancia" class="form-horizontal" action="gdaAltaOrganizacion.do"  method="POST"  >
                  <p>${error_sql}</p>
                  <div class="form-group">
                            <label for="nombre">Nombre de la Organizaci&oacute;n:</label> 
                            <form:input class="form-control" path="nombre" id="nombre" size="20"/><br/>
                                <form:errors path="nombre" cssClass="alert alert-danger"/>
                            <br/>${pre_registro} 
                        </div>
                        <div class="form-group">
                             <label for="rfc">RFC:</label>  
                            <select name="idInstancia" id="idInstancia" class="combobox-autocomplete form-control">
                                <option value="">Busqueda de Organizaci&oacute;n</option>
                                <core:forEach items="${preOrganizaciones}" var="organizacion">
                                    <option value="${organizacion.idInstancia}">${organizacion.nombre}</option>
                                </core:forEach> 
                            </select>
                            <br/>${pre_registro} 
                        </div>
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
                            <label for="nombre-organizacion">Organizaci&oacute;n:</label> 
                            <select name="idInstancia" id="idInstancia" class="combobox-autocomplete form-control">
                                <option value="">Busqueda de Organizaci&oacute;n</option>
                                <core:forEach items="${preOrganizaciones}" var="organizacion">
                                    <option value="${organizacion.idInstancia}">${organizacion.nombre}</option>
                                </core:forEach> 
                            </select>
                            <br/>${pre_registro} 
                        </div>   
                </form:form>
                </div>
                <!---------------------------------------------Fin Contenido-------------------------------------------> 
            </div><!--/row--> 
            <%@include file="../General/footer.jsp"%>           
        </div><!--/row-->
    </div> <!-- /container -->
    <%@include file="../General/js.jsp"%>
</body>
</html>
