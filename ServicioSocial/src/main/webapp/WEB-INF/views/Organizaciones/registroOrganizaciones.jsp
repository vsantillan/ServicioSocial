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

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>
        <script>
            $(document).ready(function() {
                $(".MyForm").formly();
            })
        </script>
        <title>Departamento de Servicio Social :: Organizaciones ::</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="../NavegacionPrincipal/menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>Registro de Organizaciones</h1>
                <p><h4>Busque si la Organizaci&oacute;n ya esta pre-registrada</h4></p>
                <form:form name="altaOrganizacion" class="MyForm" action="gdaAltaOrganizacion.do" method="POST" style="width:60%;">
                    <table>
                        <tr> 
                            <td> <label for="nombre-organizacion">Organizaci&oacute;n:</label> </td>
                            <td> 
                                <div class="ui-widget">
                                    <select class="combobox-autocomplete">
                                        <option value="">Busqueda de Organizaci&oacute;n</option>
                                        <option value="1">Instituto Tecnol&oacute;gico de Toluca</option>
                                        <option value="2">IMMS</option>
                                        <option value="3">Primaria D&iacute;z Ordaz</option>
                                        <option value="4">General Motors</option>
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
                <form:form name="altaOrganizacion" class="MyForm" action="gdaAltaOrganizacion.do" method="POST" style="width:60%;">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre de la Organizaci&oacute;n:</label> </td>
                            <td> <input type="text" name="fecha" id="nombre" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="hora">RFC:</label> </td>
                            <td>  <input type="text" name="hora" id="rfc" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Titular:</label></td>
                            <td>  <input type="text" name="lugar" id="titular" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Puesto:</label></td>
                            <td>  <input type="text" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono:</label></td>
                            <td>  <input type="text" name="lugar" id="telefono" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio:</label></td>
                            <td>  <input type="text" name="lugar" id="domicilio" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">C&oacute;digo Postal:</label></td>
                            <td>  <input type="text" name="lugar" id="cp" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Colonia:</label></td>
                            <td>  <select name="lugar" id="colonia" >
                                    <option value="0">Vicente Guerrero</option>
                                    <option value="1">Plazas de San Buenaventura</option>
                                </select> 
                            </td>  
                        </tr>                        
                        <tr>
                            <td>  <label for="lugar">Estado:</label></td>
                            <td>  <input type="text" name="lugar" id="estado" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Municipio:</label></td>
                            <td>  <input type="text" name="lugar" id="municipio" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Ciudad</label></td>
                            <td>  <input type="text" name="lugar" id="ciudad" size="20" require="true"/> </td>  
                        </tr>                        
                        <tr>
                            <td> <label for="semestre">Tipo de Organizaci&oacute;n:</label> </td>
                            <td>
                                <select id="tipo_organizacion" name="tipo_organizacion">
                                    <option value="1">Gobierno Federal</option>
                                    <option value="2">Gobierno Estatal</option>
                                    <option value="3">Gobierno Municipal</option>
                                    <option value="4">Organizaci&oacute;n Civil</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr>
                            <td colspan="2"><h3>Datos de contacto y de acceso:</h3></td>
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Correo:</label></td>
                            <td>  <input type="text" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Contrase&ntilde;a:</label></td>
                            <td>  <input type="password" name="lugar" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Confirmar Contrase&ntilde;a:</label></td>
                            <td>  <input type="password" name="lugar" id="puesto" size="20" require="true"/> </td>  
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