<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 

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
    <body>
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#"><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
            <div id ="contenido" align="left">
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
                        <form:form id="frmDatosPersonales">
                            <table>
                                <tr>
                                    <td>Nombre:</td>
                                    <td><form:input type ="text" path ="nombre" /> </td>
                                </tr>
                                <tr>
                                    <td>Apellido Paterno</td>
                                    <td><form:input type ="text" path ="apellidoP" /> </td>
                                </tr>
                                <tr>
                                    <td>Apellido Materno:</td>
                                    <td><form:input type ="text" path ="apellidoM" /> </td>
                                </tr>
                                <tr>
                                    <td>Sexo</td>
                                    <td>
                                        <form:select path="sexo">
                                            <form:option value="">MASCULINO</form:option>
                                            <form:option value="">FEMENINO</form:option>
                                            <form:option value="">INDEFINIDO</form:option>
                                        </form:select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Estado civil:</td>
                                    <td>
                                        <form:select path="estado_civil">
                                            <form:option value="SOLTERO(A)">SOLTERO</form:option>
                                            <form:option value="CASADO(A)">CASADO(A)</form:option>
                                            <form:option value="VIUDO(A)">VIUDO(A)</form:option>
                                            <form:option value="DIVORCIADO(A)">DIVORCIADO(A)</form:option>
                                            <form:option value="AMASIATO">AMASIATO</form:option>
                                            <form:option value="SEPARADO(A)">SEPARADO(A)</form:option>
                                            <form:option value="CONCUBINATO">CONCUBINATO</form:option>
                                            <form:option value="OTRO">OTRO</form:option>
                                        </form:select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Ocupaci&oacute;n:</td>
                                    <td><form:input type ="text" path ="ocupacion" /> </td>
                                </tr>
                                <tr>
                                    <td>CURP:</td>
                                    <td><form:input type ="text"  path ="curp"/> </td>
                                </tr>
                                <tr>
                                    <td>Folio de Documento de Identificaci&oacute;n:</td>
                                    <td><form:input type ="text" path ="folioDocIdentificacion" /> </td>
                                </tr>
                                <tr>
                                    <td>Clave de Documento de Identificaci&oacute;n:</td>
                                    <td><form:input type ="text" path ="claveDocIdentificacion" /> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><form:input type ="checkbox" path ="terminos"  /> He le&iacute;do y acepto el <a href="#">Acuerdo de Confidencialidad</a> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><form:input type ="submit" value="Guardar Datos Personales"  path="cmdDatosPersonales"/> </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div id="datosContacto">
                        <form:form id="frmDatosContacto">
                            <table>
                                <tr>
                                    <td>Calle:</td>
                                    <td><form:input type ="text" path ="calle" /> </td>
                                </tr>
                                <tr>
                                    <td>No. Int.</td>
                                    <td><form:input type ="text" path ="numero_i" /> </td>
                                </tr>
                                <tr>
                                    <td>No. Ext.</td>
                                    <td><form:input type ="text" path ="numero_e" /> </td>
                                </tr>
                                <tr>
                                    <td>Colonia:</td>
                                    <td><form:input type ="text" path ="colonia" /> </td>
                                </tr>
                                <tr>
                                    <td>Localidad:</td>
                                    <td><form:input type ="text" path ="localidad" /> </td>
                                </tr>
                                <tr>
                                    <td>C&oacute;digo postal:</td>
                                    <td><form:input type ="text"  path ="cp" /> </td>
                                </tr>
                                <tr>
                                    <td>Entre Calles:</td>
                                    <td><form:input type ="text" path ="entre_calles" /> </td>
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono casa:</td>
                                    <td><form:input type ="text" path ="telefono_casa" /> </td>
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono cel:</td>
                                    <td><form:input type ="text" path ="telefono_cel" /> </td>
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono oficina:</td>
                                    <td><form:input type ="text" path ="telefono_oficina" /> </td>
                                </tr>
                                <tr>
                                    <td>Twitter:</td>
                                    <td><form:input type ="text" path ="twitter" /> </td>
                                </tr>
                                <tr>
                                    <td>Facebook:</td>
                                    <td><form:input type ="text" path ="facebook" /> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><form:input type ="submit" value="Guardar Datos de Contacto"  path="cmdDatosContacto"/> </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div id="datosAcademicos">
                        <form:form id="frmDatosAcademicos">
                            <table class="tablaInput300">
                                <tr> 
                                    <td>Numero de control</td>
                                    <td><form:input type ="text" path ="ncontrol" /></td>
                                </tr>
                                <tr>
                                    <td>Carrera</td>
                                    <td><form:input type ="text" path ="carrera" /></td>
                                </tr>
                                <tr>
                                    <td>Periodo</td>
                                    <td><form:input type ="text" path ="periodo" /></td>
                                </tr>
                                <tr>
                                    <td>Semestre</td>
                                    <td><form:input type ="text" path ="semestre" /></td>
                                </tr>
                                <tr>
                                    <td>Total de cr&eacute;ditos cubiertos</td>
                                    <td><form:input type ="text" path ="creditos" /></td>
                                </tr>
                                <tr>
                                    <td>Porcentaje del total de cr&eacute;ditos cubiertos</td>
                                    <td><form:input type ="text" path ="porcentaje" /></td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div id="datosOrganizaciones">
                        <form:form id="frmDatosOrganizaciones">
                            <table>
                                <tr>
                                    <td>Organizaci&oacute;n:</td>
                                    <td>
                                        <form:select path="organizacion">
                                            <form:option value="">ORG 1</form:option>
                                            <form:option value="">ORG 2</form:option>
                                            <form:option value="">ORG 3</form:option>
                                        </form:select> 
                                    </td>
                                    <td>
                                        Modalidad 
                                        <form:select path="modalidad">
                                            <form:option value="">Interno</form:option>
                                            <form:option value="">Externo</form:option>
                                        </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Proyecto:</td>
                                    <td>
                                        <form:select path="proyecto">
                                            <form:option value="">Proy 1</form:option>
                                            <form:option value="">Proy 2</form:option>
                                            <form:option value="">Proy 3</form:option>
                                        </form:select> 
                                    </td>
                                </tr>
                                
                            </table>
                            <table class="tablaInput300">
                                <tr>
                                    <td>Calle</td>
                                    <td><form:input type ="text" name="calle" path="calle" /></td> 
                                    <td colspan="2">N&uacute;mero exterior <form:input style="width:50px"  type ="text" name="numero_e" path="numero_e"/>
                                    N&uacute;mero interior <form:input style="width:50px"  type ="text" name="numero_i" path="numero_i"/></td>
                                </tr>
                                <tr>
                                    <td>Colonia/Fracc</td>
                                    <td><form:input type ="text" name="colonia" path="colonia"/></td> 
                                    <td>Municipio</td>
                                    <td><form:input type ="text" name="munipio" path="munipio"/></td> 
                                </tr>
                                <tr>
                                    <td>Estado</td>
                                    <td><form:input type ="text" name="estado" path="estado"/></td> 
                                    <td>C.P.</td>
                                    <td><form:input type ="text" name="cp" path="cp"/></td> 
                                </tr>
                                <tr>
                                    <td>Titular</td>
                                    <td><form:input type ="text" name="titular" path="titular"/></td> 
                                    <td>Puesto</td>
                                    <td><form:input type ="text" name="puesto" path="puesto"/></td> 
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono del titular</td>
                                    <td><form:input type ="text" name="telefono_titular" path="telefono_titular"/></td> 
                                    
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><form:input type ="submit" value="Guardar Datos de Organizaci&oacute;n" path="cmdDatosOrganizaciones"/> </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div id="horarios">
                        <form:form id="frmHorarios">
                            <table>
                                <tr>
                                    <th></th>
                                    <th>Lunes</th>
                                    <th>Martes</th>
                                    <th>Mi&eacute;rcoles</th>
                                    <th>Jueves</th>
                                    <th>Viernes</th>
                                    <th>S&aacute;bado</th>
                                    <th>Domingo</th> 
                                </tr>
                                <tr>
                                    <th>Horario Inicio:</th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[1]" value="" path="hlui" /></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[2]" value="" path="hmai" /></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[3]" value="" path="hmii"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[4]" value="" path="hjui"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[5]" value="" path="hvii"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[6]" value="" path="hsai"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[7]" value="" path="hdoi"/></th>
                                </tr>
                                <tr>
                                    <th>Horario Final</th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[8]" value="" path="hluf"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[9]" value="" path="hmaf"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[10]" value="" path="hmif"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[11]" value="" path="hjuf"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[12]" value="" path="hvif"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[13]" value="" path="hsabf"/></th>
                                    <th><form:input type="text" style="width: 70px;" id="timepicker.[14]" value="" path="hdomf"/></th>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="7"><form:input type ="submit" value="Guardar Datos de Horario"  path="cmdDatosHorarios"/></td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                    <div id="imprimirFui">
                        <h1>Presiona el bot&oacute;n para descargar</h1>
                        <a href=""><img src="imagenes/descargar.png" /></a>
                    </div>
                    <div id="subirFui">
                        <h1>Da clic en el bot&oacute;n y selecciona tu formato &Uacute;nico</h1>
                        <form:form id="frmSubirFui">
                            <form:input type="file"  path="archivoFui"/> <br/>
                            <form:input type="submit" value="Subir" path="cmdSubirFui"/>
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
            </div>
            
            <%-- fin del contenido --%>
            <div id="footer" align="left">
                <img  src="imagenes/foter.png"/>
            </div>
        </div>

    </body>
</html>
