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
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        
        <!-- Javascripts -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>
        <script src="js/jqueryUI/jquery.ui.core.js"></script>
        <script src="js/jqueryUI/jquery.ui.widget.js"></script>
        <script src="js/jqueryUI/jquery.ui.tabs.js"></script>
        <script>
            $(function() {
                $("#tabs").tabs();
                $('#timepicker').timepicker();
            });
        </script>
        <script src="js/jqueryUI/jquery.ui.timepicker.js"></script>
        <script type="text/javascript" src="js/formatoUnicoJQuery.js"></script>
        
        <title>Formato &Uacute;nico - Usuario</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <div id="tabs">
                    <h1>P&aacute;gina del Formato Unico</h1>
                    <ul>
                        <li><a href="#datosPersonales">Datos Personales</a></li>
                        <li><a href="#datosContacto">Datos de Contacto</a></li>
                        <li><a href="#datosAcademicos">Datos Acad&eacute;micos</a></li>
                        <li><a href="#datosOrganizaciones">Datos de Organizaciones</a></li>
                        <li><a href="#horarios">Horario</a></li>
                        <li><a href="#imprimirFui">Imprimir Formato &Uacute;nico</a></li>
                        <li><a href="#subirFui">Subir Formato &Uacute;nico</a></li>
                    </ul>
                    <div id="datosPersonales">
                        <form:form id="frmDatosPersonales" modelAttribute="datos">
                            <table>
                                <tr>
                                    <td>Nombre:</td>
                                    <td><form:input  path ="nombre" /> </td>
                                </tr>
                                <tr>
                                    <td>Apellido Paterno</td>
                                    <td><form:input  path ="apellidoP" /> </td>
                                </tr>
                                <tr>
                                    <td>Apellido Materno:</td>
                                    <td><form:input  path ="apellidoM" /> </td>
                                </tr>
                                <tr>
                                    <td>Sexo</td>
                                    <td>
                                        <select name="sexo">
                                            <option  >MASCULINO</option>
                                            <option  >FEMENINO</option>
                                            <option  >INDEFINIDO</option>
                                        </select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Estado civil:</td>
                                    <td>
                                        <select name="sexo">
                                            <option value="SOLTERO(A)">SOLTERO</option>
                                            <option value="CASADO(A)">CASADO(A)</option>
                                            <option value="VIUDO(A)">VIUDO(A)</option>
                                            <option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
                                            <option value="AMASIATO">AMASIATO</option>
                                            <option value="SEPARADO(A)">SEPARADO(A)</option>
                                            <option value="CONCUBINATO">CONCUBINATO</option>
                                            <option value="OTRO">OTRO</option>
                                        </select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Ocupaci&oacute;n:</td>
                                    <td><form:input  path ="ocupacion" /> </td>
                                </tr>
                                <tr>
                                    <td>CURP:</td>
                                    <td><form:input  path ="curp" /> </td>
                                </tr>
                                <tr>
                                    <td>Folio de Documento de Identificaci&oacute;n:</td>
                                    <td><form:input  path ="folioDocIdentificacion" /> </td>
                                </tr>
                                <tr>
                                    <td>Clave de Documento de Identificaci&oacute;n:</td>
                                    <td><form:input  path ="claveDocIdentificacion" /> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type ="checkbox" name ="terminos" /> He le&iacute;do y acepto el <a href="#">Acuerdo de Confidencialidad</a> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type ="submit"  value="Guardar Datos Personales" /> </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>

                </div>
                <div id="observaciones">
                    <b>Debes atender los siguientes puntos</b><br/>
                    <ul>
                        <li>El nombre no fue escrito correctamente</li>
                        <li>La Tu direcci&oacute;n est&aacute; vac&iacute;a</li>
                    </ul>
                    
                </div>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>