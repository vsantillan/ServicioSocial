<%-- 
    Document   : registroOrganizaciones
    Created on : 10-jun-2013, 11:59:36
    Author     : bustedvillain
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>       

        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>
        <link rel="stylesheet" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>
        

        <title>Departamento de Servicio Social :: Organizaciones ::</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>
        
        <%-- inicio del contenido --%>
        <jsp:include page="../NavegacionPrincipal/menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <!--format:message key="fecha_max_fui"/-->
                <h1>Registro de Organizaciones</h1>
                <p><h4>Busque si la Organizaci&oacute;n ya esta pre-registrada</h4></p>
                <form:form name="altaOrganizacion" class="MyForm" action="confirmaOrganizacionVisitante.do" method="POST" style="width:60%;">
                    <table>
                        <tr> 
                            <td> <label for="nombre-organizacion">Organizaci&oacute;n:</label> </td>
                            <td> 
                                <div class="ui-widget">
                                    <select name="instancia" class="combobox-autocomplete">
                                        <option value="">Busqueda de Organizaci&oacute;n</option>
                                        <core:forEach items="${preOrganizaciones}" var="organizacion">
                                            <option value="${organizacion.idInstancia}">${organizacion.nombre}</option>
                                        </core:forEach> 
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr> 
                            <td colspan="2"> <input type ="submit" value = "Seleccionar Organizaci&oacute;n" /> </td>                            
                        </tr>
                    </table>
                </form:form>
                <br/>

                <p><h4>Si no encontr&oacute; su Organizaci&oacute;n, reg&iacute;strela:</h4></p>
                <%-- Formulario Nueva Organizacion --%>
                <form:form name="altaOrganizacion" commandName="instancia" class="MyForm" action="gdaAltaOrganizacion.do"  method="POST" style="width:60%;" >
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre de la Organizaci&oacute;n:</label> </td>
                            <td> 
                                <form:input path="nombre" id="nombre" size="20"/><br/>
                                <form:errors path="nombre" cssClass="error"/>
                                <!--input type="text" name="name" id="nombre" size="20" require="true" /-->                                
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="rfc">RFC:</label> </td>
                            <td>  
                                <form:input path="rfc" id="rfc" size="20" maxlength="12"/><br/>
                                <form:errors path="rfc" cssClass="error"/>
                                <!--input type="text" name="rfc" id="rfc" size="20" require="true" /-->
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="titular">Titular:</label></td>
                            <td>  
                                <form:input path="titular" id="titular" size="20"/><br/>
                                <form:errors path="titular" cssClass="error"/>
                                <!--input type="text" name="titlar" id="titular" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="puesto">Puesto:</label></td>
                            <td>  
                                <form:input path="puesto" id="puesto" size="20"/><br/>
                                <form:errors path="puesto" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="telefono">Tel&eacute;fono:</label></td>
                            <td>  
                                <form:input path="telefono" id="telefono" size="20"maxlength="10"/><br/>
                                <form:errors path="telefono" cssClass="error"/>
                                <!--input type="text" name="lugar" id="telefono" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="calle">Calle:</label></td>
                            <td>  
                                <form:input path="domicilio" id="domicilio" size="20"/><br/>
                                <form:errors path="domicilio" cssClass="error"/>
                                <!--input type="text" name="lugar" id="domicilio" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="codigo_postal">C&oacute;digo Postal:</label></td>
                            <td> <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5"></td>  
                        </tr>
                        <tr>
                            <td>  <label for="estado">Estado:</label></td>
                            <td>  <!--input type="text" name="estado" id="estado" size="20" require="true" disabled="true"/--> 
                                <select name="estado" id="estado" disabled="true">                                   
                                    <core:forEach items="${estados}" var="estados">
                                        <option value="${estados.idEstado}">${estados.nombre}</option>
                                    </core:forEach> 
                                </select>
                            </td>  
                        </tr>                        
                        <tr>
                            <td>  <label for="municipio">Municipio:</label></td>
                            <td>  <!--input type="text" name="lugar" id="municipio" size="20" require="true" disabled="true"/--> 
                                <select name="municipio" id="municipio" disabled="true"></select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="ciudad">Ciudad</label></td>
                            <td>  <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                <select name="ciudad" id="ciudad" disabled="true"></select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="colonia">Colonia:</label></td>
                            <td>  
                                <div id="notice"></div>
                                <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                <form:select id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                    <div id="otra_colonia" style="display:none;">
                                        <input type="text" name="otra_colonia" id="otra_colonia" />
                                        <!--form:input path="usuario" id="usuario" size="20"/-->
                                    </div>
                                <br/><form:errors path="idColonia" cssClass="error"/>
                            </td>  
                        </tr>                     
                        <tr>
                            <td> <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <form:select id="tipoOrganizacion" path="TipoOrganizacion.idTipoOrganizacion" name="tipoOrganizacion">
                                    <core:forEach items="${tipoOrganizaciones}" var="tipoOrganizaciones">
                                        <form:option  value="${tipoOrganizaciones.idTipoOrganizacion}">${tipoOrganizaciones.detalle}</form:option>
                                    </core:forEach> 
                                </form:select>  
                                <br/><form:errors path="tipoOrganizacion" cssClass="error"/>
                            </td>  
                        </tr>
                        <tr>
                            <td colspan="2"><h3>Datos de contacto y de acceso:</h3></td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Nombre de Usuario:</label></td>
                            <td>  
                                <form:input path="usuario" id="usuario" size="20" required="true"/><br/>
                                <form:errors path="usuario" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/-->
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  
                                <form:input path="correo" id="correo" size="20"required="true" /><br/>
                                <form:errors path="correo" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Contrase&ntilde;a:</label></td>
                            <td>  
                                <form:input path="password" id="password" size="20" type="password" required="true"/><br/>
                                <form:errors path="password" cssClass="error"/>
                                <!--input type="password" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Confirmar Contrase&ntilde;a:</label></td>
                            <td>  
                                <input type="password" name="confirma_password" id="puesto" size="20" required="true"/> <br>
                                ${confirma_password}                           
                            </td>  
                        </tr>                        
                        <tr> 
                            <td> <input type ="submit" value = "Guardar " /> </td>
                            <td> <input type ="reset" value = "Limpiar" /></td>
                        </tr>

                    </table>
                </form:form>
                <br/>

            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>