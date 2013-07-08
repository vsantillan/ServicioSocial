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
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.autocomplete.custom.css" />
        
        <script src="js/jqueryUI/jquery.ui.autocomplete.custom.js"></script>  
        
        <title>Administrador</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">
                <h1>Alta de Proyecto</h1>
                <form:form name="altaOrganizacion" id="MyForm" action="gdaAltaOrganizacion.do" method="POST">
                    <table>
                        <tr>
                            <td> <label for="nombre">Nombre del Proyecto:</label> </td>
                            <td> <input type="text" name="nombre" id="nombre" size="20" require="true" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="vacantes">N&uacute;mero de Vacantes:</label> </td>
                            <td>  <input type="text" name="rfc" id="vacacntes" size="20" require="true" /></td>  
                        </tr>                        
                        <tr>
                            <td> <label for="semestre">Instancia/Organizaci&oacute;n:</label> </td>
                            <td>
                                <select id="organizacion" name="organizacion">
                                    <option value="1">Instituto Tecnol&oacute;gico de Toluca</option>
                                    <option value="2">IMMS</option>
                                    <option value="3">Primaria D&iacute;z Ordaz</option>
                                    <option value="4">General Motors</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Responsable del Programa:</label></td>
                            <td>  <input type="text" name="titular" id="titular" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Tel&eacute;fono del Responsable:</label></td>
                            <td>  <input type="text" name="puesto" id="puesto" size="20" require="true"/> </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Domicilio del Programa:</label></td>
                            <td>  <input type="text" name="correo" id="puesto" size="20" require="true"/> </td>  
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
                            <td>  <label for="lugar">Tipo de Proyecto:</label></td>
                            <td>
                                <select id="tipo_proyecto" name="tipo_proyecto">
                                    <option value="1">Interno</option>
                                    <option value="2">Interno Becado</option>
                                    <option value="3">Externo</option>
                                    <option value="4">Externo Becado</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Perfil Buscado:</label></td>
                            <td>
                                <select id="organizacion" name="organizacion">
                                    <option value="1">Cualquiera</option>
                                    <option value="2">Ingeniero en Sistemas Computacionales</option>
                                    <option value="3">Ingeniero Industrial</option>
                                    <option value="4">Ingeniero en Gesti&oacute;n Empresarial</option>
                                    <option value="5">Ingeniero Electr&oacute;nica</option>
                                    <option value="6">Ingeniero en Mecatr&oacute;nica</option>
                                    <option value="7">Ingeniero Qu&iacute;mico</option>
                                </select>    
                            </td>  
                        </tr>                   
                        <tr> 
                            <td> <input type ="submit" value = "Guardar " /> </td>
                            <td> <input type ="reset" value = "Limpiar" /></td>
                        </tr>
                    </table>
                </form:form> 
                <div class="ui-widget">
                    <label>I: </label>
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
                <br/>
            </div>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
