<%-- 
    Document   : altaAdminProyecto
    Created on : 07-jun-2013, 14:29:16
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
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />   
        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>

        <title>Administrador</title>       
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">
                <center>
                    <h1>Alta de Proyecto</h1>
                    <div style="float:left; width: 80%">
                        <form:form  name="altaOrganizacion" commandName="proyecto" class="MyForm" action="gdaAltaAdminProyecto.do" method="POST">
                            <table>
                                <tr>
                                    <td> <label for="nombre">Nombre del Proyecto:</label> </td>
                                    <td> 
                                        <!--input type="text" name="nombre" id="nombre" size="20" require="true" /-->
                                        <form:input path="nombre" id="nombre" size="20"/><br/>
                                        <form:errors path="nombre" cssClass="error"/>
                                    </td>  
                                </tr>
                                <tr>
                                    <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                                    <td>  
                                        <!--input type="text" name="rfc" id="vacacntes" size="20" require="true" /-->
                                        <form:input path="vacantesDisponibles" id="rfc" size="20"/><br/>
                                        <form:errors path="vacantesDisponibles" cssClass="error"/>
                                    </td>  
                                </tr>                        
                                <tr>
                                    <td> <label for="semestre">Instancia/Organizaci&oacute;n:</label> </td>
                                    <td>
                                        <form:select id="instancia" path="idInstancia.idInstancia" name="instancia">
                                            <core:forEach items="${instancias}" var="instancia">
                                                <form:option  value="${instancia.idInstancia}">${instancia.nombre}</form:option>
                                            </core:forEach> 
                                        </form:select>
                                    </td>  
                                </tr>
                                <tr>
                                    <td>  <label for="lugar">Responsable del Programa:</label></td>
                                    <td>  
                                        <!--input type="text" name="titular" id="titular" size="20" require="true"/--> 
                                        <form:input path="nombreResponsable" id="rfc" size="20"/><br/>
                                        <form:errors path="nombreResponsable" cssClass="error"/>
                                    </td>  
                                </tr>
                                <tr>
                                    <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                                    <td>  
                                        <!--input type="text" name="puesto" id="puesto" size="20" require="true"/--> 
                                        <form:input path="telefonoResponsable" id="rfc" size="20"maxlength="10"/><br/>
                                        <form:errors path="telefonoResponsable" cssClass="error"/>
                                    </td>  
                                </tr>
                                <tr>
                                    <td>  <label for="lugar">Domicilio del Programa:</label></td>
                                    <td>  
                                        <!--input type="text" name="correo" id="puesto" size="20" require="true"/--> 
                                        <form:input path="domicilio" id="rfc" size="20"/><br/>
                                        <form:errors path="domicilio" cssClass="error"/>
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
                                        <form:errors path="idColonia" cssClass="error"/>
                                    </td>  
                                </tr>
                                <!--tr>
                                    <td>  <label for="lugar">Modalidad:</label></td>
                                    <td>
                                        <form:select id="tipoProyecto" path="idTipoProyecto.idTipoProyecto" name="tipoProyecto">
                                            <form:option  value="I">I</form:option>
                                            <form:option  value="E">E</form:option>                                            
                                        </form:select>
                                    </td>  
                                </tr-->
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
                                    <td>  <label for="lugar">Perfil Buscado:</label></td>
                                    <td>
                                        <p><input type="checkbox" id="ningunPerfil" name="ningunPerfil"/>Ninguno<input type ="button" id="agregaPerfil" value = "Agregar Perfil" /></p>
                                        <ol id="perfiles"></ol> 
                                        <!--select id="perfil"  name="perfil"-->
                                            <!--core:forEach items="${perfiles}" var="perfil"-->
                                                <!--option value="${perfil.idPerfil}">${perfil.nombre}</option-->
                                        <!--/core:forEach--> 
                                        <!--select-->
                                    </td>  
                                </tr> 
                                <tr>
                                    <td style="vertical-align: top; text-align: left;">  
                                        <label for="lugar">Actividades:</label><br/>

                                    </td>
                                    <td>
                                        <p><input type ="button" id="agregarActividad" value = "Agregar Actividad" /></p>
                                        <ol id="actividades"></ol>  
                                    </td>  
                                </tr>                               
                                <tr> 
                                    <td> <input type ="submit" value = "Guardar " /> </td>
                                    <td> <input type ="reset" value = "Limpiar" /></td>
                                </tr>
                            </table>
                                        <input type="hidden" name="nActividades" value="0">
                                        <input type="hidden" name="nPerfiles" value="0">
                        </form:form>
                    </div>
                </center>

            </div> 

            <div style="clear:both;"></div>
            <br/><br/><br/><br/>
        </div>


    </div>
    <%-- fin del contenido --%>
    <jsp:include page="../Template/footer.jsp" />
    
</body>
</html>
