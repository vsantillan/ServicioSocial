<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Bustedvillain
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsOrganizaciones.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <script src="js/jquery.codigos.postales.js"></script>       
        <script src="js/jquery.manolo.js"></script>
        <title>Panel Organizaci&oacute;n</title>
    </head>
    <body class="background" >

        <%@ include file="../Template/banner.jsp" %>

        <jsp:include page="menuPanelOrganizacion.jsp" />
        <%-- inicio del contenido --%>
        <div id="contenido">
            <center>
                <br/>
                <h1>Bienvenido al Sitio para Organizaciones</h1>
                <center>${mensaje1}</center>
                <img src="imagenes/organizacion.jpg">
                <h4>Perfil de la Organizaci&oacute;n</h4>
                <form:form name="editarOrganizacion" commandName="instancia" class="MyForm" action="gdaEdicionOrganizacion.do"  method="POST" style="width:70%;" >
                    <p>${error_sql}</p>
                    <center><p>${mensaje}</p></center>
                    <input type="hidden" name="idInstancia" value="${instancia.idInstancia}">
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
                                <form:input path="telefono" id="telefono" size="20"maxlength="10"/>
                                Ext:<form:input path="ext" id="ext" size="7"maxlength="7"/><br/>
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
                                <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" value="${instancia.idColonia.idCp.cp}">
                                <input type="hidden" id="preCP" value="${instancia.idColonia.idCp.cp}"/><br>${codigo_postal}
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
                                <form:select id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                    <div id="otra_colonia" style="display:none;">
                                        <input type="text" name="otra_colonia" value="${otra_colonia}"/>
                                    <input type="hidden" id="existeCP" name="existeCP" value="true">
                                    <input type="hidden" id="preColonia" value="${instancia.idColonia.idColonia}"/>
                                    ${error_otra_colonia}
                                </div>
                                <br/>
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
                                <form:input path="usuario" id="usuario" size="20" /><br/>
                                ${usuario}

                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  
                                <form:input path="correo" id="correo" size="20" /><br/>
                                <form:errors path="correo" cssClass="error"/>${correo}

                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Contrase&ntilde;a:</label></td>
                            <td>  
                                <form:input path="password" id="password" size="20" type="password" value=""/><br/>
                                ${password}
                                <input type="hidden" name="antiguoPass" value="${instancia.password}">
                                <p><h4>Si no desea guardar una nueva contraseña deje este campo vacío.</h4></p>
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Confirmar Contrase&ntilde;a:</label></td>
                            <td>  
                                <input type="password" name="confirma_password" id="confirma_password" size="20"/> <br>
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
        </div>
        <script>
            document.getElementById("password").value = "";
        </script>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
