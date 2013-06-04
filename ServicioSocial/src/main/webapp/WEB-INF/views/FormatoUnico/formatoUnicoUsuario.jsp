<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 

        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        <!-- JSP -->
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
        <script type="text/javascript">
            $(document).ready(function() {
                $('#timepicker\\.\\[1\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[2\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[3\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[4\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[5\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[6\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[7\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[8\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[9\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[10\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[11\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[12\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[13\\]').timepicker({
                    showAnim: 'blind'
                });
                $('#timepicker\\.\\[14\\]').timepicker({
                    showAnim: 'blind'
                });
            });
        </script>
        <title>Formato &Uacute;nico - Usuario</title>
    </head>
    <body>
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#"><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
            <div id ="contenido" align="left">
                <div id="tabs">
                    <h1>Pagina del Formato Unico</h1>
                    <ul>
                        <li><a href="#datosPersonales">Datos Personales</a></li>
                        <li><a href="#datosContacto">Datos de Contacto</a></li>
                        <li><a href="#datosOrganizaciones">Datos de Organizaciones</a></li>
                        <li><a href="#horarios">Horario</a></li>
                    </ul>
                    <div id="datosPersonales">
                        <form>
                            <table>
                                <tr>
                                    <td>Nombre:</td>
                                    <td><input type ="text" name ="nombre"> </td>
                                </tr>
                                <tr>
                                    <td>Apellido Paterno</td>
                                    <td><input type ="text" name ="apellidoP"> </td>
                                </tr>
                                <tr>
                                    <td>Apellido Materno:</td>
                                    <td><input type ="text" name ="apellidoM"> </td>
                                </tr>
                                <tr>
                                    <td>Sexo</td>
                                    <td>
                                        <select name="sexo">
                                            <option value="">MASCULINO</option>
                                            <option value="">FEMENINO</option>
                                            <option value="">INDEFINIDO</option>
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
                                    <td><input type ="text" name ="ocupacion"> </td>
                                </tr>
                                <tr>
                                    <td>CURP:</td>
                                    <td><input type ="text" name ="curp"> </td>
                                </tr>
                                <tr>
                                    <td>Folio de Documento de Identificaci&oacute;n:</td>
                                    <td><input type ="text" name ="folioDocIdentificacion"> </td>
                                </tr>
                                <tr>
                                    <td>Clave de Documento de Identificaci&oacute;n:</td>
                                    <td><input type ="text" name ="claveDocIdentificacion"> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type ="submit" value="Guardar Datos Personales" > </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div id="datosContacto">
                        <form>
                            <table>
                                <tr>
                                    <td>Calle:</td>
                                    <td><input type ="text" name ="calle"> </td>
                                </tr>
                                <tr>
                                    <td>No. Int.</td>
                                    <td><input type ="text" name ="numero_i"> </td>
                                </tr>
                                <tr>
                                    <td>No. Ext.</td>
                                    <td><input type ="text" name ="numero_e"> </td>
                                </tr>
                                <tr>
                                    <td>Colonia:</td>
                                    <td><input type ="text" name ="colonia"> </td>
                                </tr>
                                <tr>
                                    <td>Localidad:</td>
                                    <td><input type ="text" name ="localidad"> </td>
                                </tr>
                                <tr>
                                    <td>C&oacute;digo postal:</td>
                                    <td><input type ="text" name ="cp"> </td>
                                </tr>
                                <tr>
                                    <td>Entre Calles:</td>
                                    <td><input type ="text" name ="entre_calles"> </td>
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono casa:</td>
                                    <td><input type ="text" name ="telefono_casa"> </td>
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono cel:</td>
                                    <td><input type ="text" name ="telefono_cel"> </td>
                                </tr>
                                <tr>
                                    <td>Tel&eacute;fono oficina:</td>
                                    <td><input type ="text" name ="telefono_oficina"> </td>
                                </tr>
                                <tr>
                                    <td>Twitter:</td>
                                    <td><input type ="text" name ="twitter"> </td>
                                </tr>
                                <tr>
                                    <td>Facebook:</td>
                                    <td><input type ="text" name ="facebook"> </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type ="submit" value="Guardar Datos de Contacto" > </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div id="datosOrganizaciones">
                        <form>
                            <table>
                                <tr>
                                    <td>Organizaci&oacute;n:</td>
                                    <td>
                                        <select name="organizacion">
                                            <option value="">ORG 1</option>
                                            <option value="">ORG 2</option>
                                            <option value="">ORG 3</option>
                                        </select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Proyecto:</td>
                                    <td>
                                        <select name="proyecto">
                                            <option value="">Proy 1</option>
                                            <option value="">Proy 2</option>
                                            <option value="">Proy 3</option>
                                        </select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type ="submit" value="Guardar Datos de Organizaci&oacute;n" > </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div id="horarios">
                        <form>
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
                                    <th><input type="text" style="width: 70px;" id="timepicker.[1]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[2]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[3]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[4]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[5]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[6]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[7]" value="" /></th>
                                </tr>
                                <tr>
                                    <th>Horario Final</th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[8]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[9]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[10]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[11]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[12]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[13]" value="" /></th>
                                    <th><input type="text" style="width: 70px;" id="timepicker.[14]" value="" /></th>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <%-- fin del contenido --%>
            <div id="footer" align="left">
                <img  src="imagenes/foter.png"/>
            </div>
        </div>

    </body>
</html>
