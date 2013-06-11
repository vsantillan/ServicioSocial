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

        <script>
            $(document).ready(function(){
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
                                    <select id="combobox">
                                        <option value="">Select one...</option>
                                        <option value="ActionScript">ActionScript</option>
                                        <option value="AppleScript">AppleScript</option>
                                        <option value="Asp">Asp</option>
                                        <option value="BASIC">BASIC</option>
                                        <option value="C">C</option>
                                        <option value="C++">C++</option>
                                        <option value="Clojure">Clojure</option>
                                        <option value="COBOL">COBOL</option>
                                        <option value="ColdFusion">ColdFusion</option>
                                        <option value="Erlang">Erlang</option>
                                        <option value="Fortran">Fortran</option>
                                        <option value="Groovy">Groovy</option>
                                        <option value="Haskell">Haskell</option>
                                        <option value="Java">Java</option>
                                        <option value="JavaScript">JavaScript</option>
                                        <option value="Lisp">Lisp</option>
                                        <option value="Perl">Perl</option>
                                        <option value="PHP">PHP</option>
                                        <option value="Python">Python</option>
                                        <option value="Ruby">Ruby</option>
                                        <option value="Scala">Scala</option>
                                        <option value="Scheme">Scheme</option>
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
                <p><h4>Si no encontr&oacute; su Organizaci&oacute;n, registrela:</h4></p>
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