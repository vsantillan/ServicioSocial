<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquerycssmenu2.css" />
        <link rel="stylesheet" type="text/css" href="css/screen.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 

        <link rel="stylesheet" href="css/platicasEstiloFormularioformly.css" type="text/css" />
        <LINK rel="stylesheet" href="css/platicajquery.clockpick.1.2.7.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>

        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquerycssmenu2.js"></script>
        <script type="text/javascript" src="js/baner.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js" ></script>
        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>


        <script type="text/javascript" src="js/platicajquery.clockpick.1.2.7.js"></script>
        <script type="text/javascript" src="js/platicajquery.clockpick.1.2.7.min.js"></script>
        <script type="text/javascript" src="js/platicajquery.clockpick.1.2.7.pack.js"></script>
        <title>Alta Plática</title>

        <script>

            $(document).ready(function() {

                $('#MyForm').formly();
            });
        </script>
           <script>

$(document).on('ready', function(){ 
	
	$('#hora').clockpick({
        });
         
});
</script>
   <script>

$(document).ready(function() { 
	
	$('#fecha_max_fui').datepicker; 
});
</script>
   <script type="text/javascript">
   		$(function(){

				
				
	
				// Tabs
				$('#tabs').tabs();
	

				
				
				

				// Datepicker
				$('#datepicker').datepicker({
					inline: true
				});
                                $('#datepicker').datepicker('option', {dateFormat: 'dd/mm/yy'});
                                
                                $('#datepicker2').datepicker({
					inline: true
				});
			       $('#datepicker2').datepicker('option', {dateFormat: 'dd/mm/yy'});
				
			});
		</script>

    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="#" onmouseout="MM_swapImgRestore()" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>

        <%-- inicio del contenido --%>
        <div id="contenido">
            <form name="altaPlatica" id="MyForm" action="controlador/PlaticasInduccion/AltaPlaticaC.jsp" method="POST">

                <center><p>
                        <label for="fecha">Fecha</label>
                        <input type="text" name="fecha" id="datepicker" size="15" require="true" />
                    </p>
                    <p>
                        <label for="hora">Hora</label>
                        <input type="text" name="hora" id="hora" size="15" require="true" />
                    </p>
                    <p>
                        <label for="lugar">Lugar De la Platica de Inducción</label>
                        <input type="text" name="lugar" id="lugar" size="20" require="true"/>
                    </p>			


                    <p>
                        <label for="semestre">Periodo</label>
                        <select id="semestre" name="semestre">
                            <option                              value="ENE-JUN">ENE-JUN</option>
                            <option                              value="AGO-DIC">AGO-DIC</option>
                        </select>   
                        Año (4 digitos)
                        <input type="text" name="aaaa" id="aaaa" size="8" require="true"/>

                    </p>
                    <p>
                        <label for="fecha_maxfu">Fecha máxima formato unico</label>   
                        <input type="text" name="fecha_max_fui" id="datepicker2" size="15" require="true" />
                    </p>


                    <p class="submit"><button type="submit">Alta</button></p>
                </center>

            </form>

        </div>
        <%-- fin del contenido --%>
        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>

    </body>


</html>
