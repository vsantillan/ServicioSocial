<%-- 
    Document   : altaProyecto
    Created on : 06-jun-2013, 11:53:01
    Author     : bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Alta de Organizaciones</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuOrganizacion.jsp"%>
                <div class="col-md-12">
                    <div class="help-block col-md-12 text-center"><h1><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Alta de Proyecto</h1></div>
                    &nbsp;
                    <form:form  name="altaOrganizacion" modelAttribute="proyecto" class="MyForm" action="gdaAltaProyecto.do" method="POST">
                        <table>
                            <form:input path="idInstancia.idInstancia" type="hidden"/>
                            <tr>
                                <td> <label for="nombre">Nombre del Proyecto:</label> </td>
                                <td> 
                                    <!--input type="text" name="nombre" id="nombre" size="20" require="true" /-->
                                    <form:input path="nombre" id="nombre" size="20"/><br/>
                                    <form:errors path="nombre" cssClass="error"/>${nombre}
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                                <td>  
                                    <!--input type="text" name="rfc" id="vacacntes" size="20" require="true" /-->
                                    <form:input path="vacantes" id="vacantes" size="20"/><br/>
                                    <form:errors path="vacantes" cssClass="error"/>${vacantes}
                                </td>  
                            </tr>                        
                            <tr>
                                <td>  <label for="lugar">Responsable del Programa:</label></td>
                                <td>  
                                    <!--input type="text" name="titular" id="titular" size="20" require="true"/--> 
                                    <form:input path="nombreResponsable" id="nombreResponsable" size="20"/><br/>
                                    <form:errors path="nombreResponsable" cssClass="error"/>${responsable}
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="lugar">Puesto del Responsable:</label></td>
                                <td>  
                                    <!--input type="text" name="titular" id="titular" size="20" require="true"/--> 
                                    <form:input path="responsablePuesto" id="responsablePuesto" size="20"/><br/>
                                    <form:errors path="responsablePuesto" cssClass="error"/>${puesto}
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                                <td>  
                                    <!--input type="text" name="puesto" id="puesto" size="20" require="true"/--> 
                                    <form:input path="telefonoResponsable" id="rfc" size="20" maxlength="10"/>
                                    Ext:<form:input path="ext" id="ext" size="7" maxlength="7"/><br/>
                                    ${telefono}
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="lugar">Domicilio del Programa:</label></td>
                                <td>  
                                    <!--input type="text" name="correo" id="puesto" size="20" require="true"/--> 
                                    <form:input path="domicilio" id="rfc" size="20"/><br/>
                                    <form:errors path="domicilio" cssClass="error"/>${domicilio}
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="codigo_postal">C&oacute;digo Postal:</label></td>
                                <td> 
                                    <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off">
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
                                <td>  <label for="colonia">Colonia:</label></td>
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
                                <td>  <label for="lugar">Tipo de Proyecto:</label></td>
                                <td>
                                    <form:select id="tipoProyecto" path="idTipoProyecto.idTipoProyecto" name="tipoProyecto">
                                        <core:forEach items="${tipoProyecto}" var="tipoProyecto">
                                            <form:option  value="${tipoProyecto.idTipoProyecto}">${tipoProyecto.descripcion}</form:option>
                                        </core:forEach> 
                                    </form:select>
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="lugar">Programa:</label></td>
                                <td>
                                    <form:select id="programa" path="idPrograma.idPrograma" name="programa">
                                        <core:forEach items="${programas}" var="programa">
                                            <form:option  value="${programa.idPrograma}">${programa.descripcion}</form:option>
                                        </core:forEach> 
                                    </form:select>
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="modalidad">Modalidad</label></td>
                                <td>  <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                    <form:select id="modalidad" path="modalidad" name="modalidad">
                                        <form:option  value="I">INTERNO</form:option>
                                        <form:option  value="E">EXTERNO</form:option>
                                    </form:select>
                                </td>  
                            </tr>
                            <tr>
                                <td><label for="perfil">Perfil buscado:</label></td>
                                <td>
                                    <p>Perfiles Disponibles:</p>
                                    <select name="selectfrom" id="select-from" multiple size="9">
                                        <core:forEach items="${perfiles}" var="perfil">
                                            <option value="${perfil.idPerfil}">${perfil.nombre}</option>
                                        </core:forEach>
                                    </select>

                                    <a href="JavaScript:void(0);" id="btn-add">Agregar &raquo; </a>

                                    <p>Perfiles Seleccionados:</p>
                                    <select name="selectto" id="select-to" multiple size="9"></select>                                            
                                    <a href="JavaScript:void(0);" id="btn-remove">&laquo; Quitar</a>

                                    <h5>Nota: Escoja el perfil que desea de los disponibles y de click Agregar para moverlo a los seleccionados. Y a su vez si desea remover un perfil seleccionado, escojalo en los seleccionados y de click en Quitar.</h5>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    ${validacion_actividades}
                                </td>
                            </tr>
                            <tr>                            
                                <td style="vertical-align: top; text-align: left;">  
                                    <label for="lugar">Actividades:</label><br/>
                                </td>
                                <td>

                                    <p><input type ="button" id="agregarActividad" value = "Agregar Actividad" /></p>
                                    <ol id="actividades"></ol>                                       
                                    <input type="hidden" name="nActividades" id="nActividades" value="0">
                                    <input type="hidden" name="PrenActividades" id="PrenActividades" value="${nActividades}">
                                    <input type="hidden" name="cadenaActividades" id="cadenaActividades">

                                    <input type="hidden" id="actividad0" value="${actividad0}">
                                    <input type="hidden" id="actividad1" value="${actividad1}">
                                    <input type="hidden" id="actividad2" value="${actividad2}">
                                    <input type="hidden" id="actividad3" value="${actividad3}">
                                    <input type="hidden" id="actividad4" value="${actividad4}">

                                </td>  
                            </tr>                               
                            <tr> 
                                <td> <input type ="button" value = "Guardar " id="btnGdaAdminProyecto"/> </td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>
                        <input type="hidden" name="nActividades" value="0">
                        <input type="hidden" name="nPerfiles" value="0">
                    </form:form>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <script>
            $('a#btn-add').click(function() {
                $('#select-from option:selected').each(function() {
                    $('#select-to').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
            $('a#btn-remove').click(function() {
                $('#select-to option:selected').each(function() {
                    $('#select-from').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
                    $(this).remove();
                });
            });
        </script>   
        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>
         <script> var iniciarAltaProyecto = true;</script>
    </body>
</html>
