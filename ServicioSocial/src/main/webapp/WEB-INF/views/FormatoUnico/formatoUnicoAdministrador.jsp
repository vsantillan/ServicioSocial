<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 
        
        <!--Estilos para tablas-->
        <link rel="stylesheet" type="text/css" href="css/demo_page.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css" />
        <!--<link rel="stylesheet" type="text/css" href="css/demo_page.css" />-->
        
        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        
        
        <!-- Scripts -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>
        <script src="js/jqueryUI/jquery.ui.core.js"></script>
        <script src="js/jqueryUI/jquery.ui.widget.js"></script>
        <script src="js/jqueryUI/jquery.ui.tabs.js"></script>
      
        
        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 

        <!--Scripts para tablas-->
        <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function() {
                $("#tabs").tabs();
                $('#noRevisadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                  
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#aceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script> 
        
        <script src="js/jqueryUI/jquery.ui.timepicker.js"></script>
        
        
        
        <title>Formatos &Uacute;nicos</title>
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
                        <li><a href="#noRevisados">No revisados</a></li>
                        <li><a href="#noAceptados">No aceptados</a></li>
                        <li><a href="#enCorreccion">En correcci&oacute;n</a></li>
                        <li><a href="#aceptados">Aceptados</a></li>
                    </ul>
                    <div id="noRevisados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noRevisadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <td>Periodo</td>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Archivo</th>
                                    <th>Acci&oacute;n</th>
                                    <th>Establecer</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td><a href="algunLado.do" rel="shadowbox"><img src="imagenes/lupa.png"/></a></td>
                                    <td>13-06-07</td>
                                    <td>fui.pdf</td>
                                    <td>
                                        <select>
                                            <option>Selecionar...</option>
                                            <option>Aceptar</option>
                                            <option>Rechazar</option>
                                            <option>Correcci&oacute;n</option>
                                        </select>
                                    </td>
                                    <td><input type="button" value="Modificar"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="noAceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noAceptadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <td>n. Control</td>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Fecha Rechazo</th>
                                    <th>Motivo</th>
                                   

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td>fui.pdf</td>
                                    <td>13-06-07</td>
                                    <td>13-08-09</td>
                                    <td>Instancia no v&aacute;lida</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>    
                    <div id="enCorreccion">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="enCorreccionDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Motivo</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td>fui.pdf</td>
                                    <td>13-06-07</td>
                                    <td>Faltas</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>    
                    <div id="aceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="aceptadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Fecha Aceptaci&oacute;n</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr class='gradeX'>
                                    <td>Ene-Feb</td>
                                    <td>09271024</td>
                                    <td>Hector Guzman Nava</td>
                                    <td>fui.pdf</td>
                                    <td>13-06-07</td>
                                    <td>13-06-12</td>
                                    
                                </tr>
                            </tbody>
                        </table>
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
