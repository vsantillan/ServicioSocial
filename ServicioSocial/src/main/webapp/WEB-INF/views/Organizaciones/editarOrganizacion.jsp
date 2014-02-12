<%-- 
    Document   : editarOrganizacion
    Created on : 19/06/2013, 12:21:32 PM
    Author     : ekt
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body onmousedown="elemento(event);">
        <div class="container">
            <div class="row">
                <h1>Editar Organizacion</h1>
                <form:form name="modificarOrganizacion" commandName="instancia" class="MyForm" action="modificarOrganizacion.do"  method="POST" >
                    <p>${error_sql}</p>
                    <table>
                        <tr>
                            <td><label for="nombre">Nombre de la Organizaci&oacute;n:</label> 
                                <form:hidden path="idInstancia" id="idInstancia" size="20"/><br/>
                                <form:hidden path="estatus" id="estatus" size="20"/><br/>
                            </td>
                            <td> 
                                <form:input path="nombre" id="nombre" size="20"/><br/>
                                <form:errors path="nombre" cssClass="error"/>
                                <!--input type="text" name="name" id="nombre" size="20" require="true" /-->                                
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="rfc">RFC:</label> </td>
                            <td>  
                                <form:input path="rfc" id="rfc" size="12"/><br/>
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
                                <form:input path="telefono" id="telefono" size="10"/><br/>
                                ${telefono}
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
                            <td> 
                                <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" value="${instanciaDireccion.idColonia.idCp.cp}">
                                <input type="hidden" id="preCP" value="${cp}"/><br>${codigo_postal}
                            </td>  
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
                            <td>
                                <input id="nombre_colonia" path="nombre_colonia" value="${instanciaDireccion.idColonia.nombre}" hidden="hidden"/>
                                <label for="colonia">Colonia:</label></td>
                            <td>  
                                <div id="notice"></div>
                                <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                <form:select id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                    <div id="otra_colonia" style="display:none;">
                                        <input type="text" name="otra_colonia" value="${otra_colonia}"/>
                                        <input type="hidden" id="existeCP" name="existeCP" value="true">
                                        <input type="hidden" id="preColonia" value="${idColonia}"/>
                                    ${error_otra_colonia}
                                </div>
                                <br/>
                            </td>  
                        </tr>                     
                        <tr>
                            <td> <label for="tipo_organizacion">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <form:select id="tipoOrganizacion" path="tipoOrganizacion.idTipoOrganizacion" name="tipoOrganizacion">
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
                        <form:errors path="tipoOrganizacion.idTipoOrganizacion" cssClass="error"/>
                        </td>  
                        </tr>
                        <tr>
                            <td>  <label for="validacionAdmin">Validación:</label></td>
                            <td>  <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                <form:select id="validacionAdmin" path="validacionAdmin" name="validacionAdmin">
                                    <form:option  value="0">Rechazada</form:option>
                                    <form:option  value="1">Aceptada</form:option>
                                    <form:option  value="2">Pre-registrada</form:option>
                                </form:select>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Nombre de Usuario:</label></td>
                            <td>  
                                <form:input path="usuario" id="usuario" size="20"/><br/>
                                <form:errors path="usuario" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/-->
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  
                                <form:input path="correo" id="correo" size="20"/><br/>
                                <form:errors path="correo" cssClass="error"/>
                                <!--input type="text" name="lugar" id="puesto" size="20" require="true"/--> 
                            </td>  
                        </tr>                        
                        <tr>
                            <td><label for="lugar">Cambiar contraseña:</label></td>
                            <td>
                                <input type="radio" name="passG1" id="passG1" value="si" onclick="pass(this)">Cambiar contraseña<br/>
                                <input type="radio" name="passG1" id="passG1" value="no" onclick="pass(this)" checked="checked">Mantener contraseña<br/>
                                ${confirma_password}
                            </td>
                        </tr>
                        <tr> 
                            <td><input type ="submit" value = "Guardar cambios"/></td>
                            <td><input type ="button" value = "Cancelar" onclick="window.parent.Shadowbox.close();"/></td>
                        </tr>
                    </table>
                    <table  id="cambiaPass" style="display: none">
                        <tr>
                            <td><label for="lugar">Contrase&ntilde;a:</label></td>
                            <td>  
                                <form:input path="password" id="password" size="20" type="password"/><br/>
                                <form:errors path="password" cssClass="error"/>
                                <!--                                input type="password" name="lugar" id="puesto" size="20" require="true"/ -->
                            </td>
                        </tr>
                        <tr>
                            <td><label for="lugar">Confirmar Contrase&ntilde;a:</label>
                                <input type="text" name="valid_pass" id="valid_pass" size="1" hidden="hidden" value="0"/> 
                            </td>
                            <td><input type="password" name="confirma_password" id="confirmPass" size="20"/> <br/>
                            </td>
                        </tr>
                    </table>
                </form:form>
                <br/>
            </div>
            <div style="clear: both;"/>
        </div>
    </div>
    <jsp:include page="../Template/footer.jsp" />
    
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

