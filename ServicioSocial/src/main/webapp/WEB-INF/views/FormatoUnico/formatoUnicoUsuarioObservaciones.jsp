<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="js/formatoUnicoJQuery.js"></script>
        <title>Formato &Uacute;nico - Usuario Observaciones</title>
    </head>
    <body>
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#"><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
            <div id ="contenido" align="left">
                <h1>Estatus Formato Unico</h1>
                <div>
                    <p class="alineadoIzq" style="margin-top: 10px">En este momento tu Formato Único se encuentra:</p>
                    
                    <div class="alineadoIzq alert success textoCentrado">
                        Rechazado
                    </div>
                    <div style="clear: both"></div>
                    <div class="observaciones">
                        Observaciones del Alumno
                        
                        
                    </div>
                    
                    
                    <div>
                        <h3>Leyenda</h3>
                        <div>
                            <div>
                                <div class="alineadoIzq alert info textoCentrado">Revisión</div>
                                <div><p class="alineadoIzq leyenda">Tu Formato Único está en espera de revisión <br/> por la Oficina del Servicio Social.</p></div>
                            </div>
                            <div style="clear: both"></div>
                            <div>
                                <div class="alineadoIzq alert warning textoCentrado">Revisado</div>
                                <div><p class="alineadoIzq leyenda">Tu Formato Único  ha sido revisado, pero tiene <br/>algunos detalles que la Oficina <br/>de Servicio Social no ha aprobado, favor de revisar los detalles. </p></div>
                            </div>
                            <div style="clear: both"></div>
                            <div>
                                <div class="alineadoIzq alert error textoCentrado">Rechazado</div>
                                <div><p class="alineadoIzq leyenda">Tu formato Único ha sido rechazado, revisa <br/>los motivos para mayor Información favor de presentarse <br/>en la Oficina de Servicio Social.</p></div>
                            </div>
                            <div style="clear: both"></div>
                            <div>
                                <div class="alineadoIzq alert success textoCentrado">Aceptado</div>
                                <div><p class="alineadoIzq leyenda">Tu Formato Único ha sido revisado y aprobado <br/>por la Oficina del Servicio Social.</p></div>
                            </div>
                        </div>
                    </div>
                    <div style="clear: both"></div>
                </div>
                
                
                
            </div>
            <%-- fin del contenido --%>
            <div id="footer" align="left">
                <img  src="imagenes/foter.png"/>
            </div>
        </div>

    </body>
</html>