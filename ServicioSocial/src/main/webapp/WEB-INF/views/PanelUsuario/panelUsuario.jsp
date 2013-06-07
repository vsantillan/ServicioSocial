<%-- 
    Document   : panelUsuario
    Created on : 3/06/2013, 10:52:04 AM
    Author     : roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/panelUsuario.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 
        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
        
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "smoothmenu1", //Menu DIV id
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                method: 'hover', // set to 'hover' (default) or 'toggle'
                arrowswap: true, // enable rollover effect on menu arrow images?
                //customtheme: ["#804000", "#482400"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })

        </script>



        <title>Home Usuario</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
        <div class="pagina" align="center">
            <div class="banner" align="left">
                <a href="http://www.ittoluca.edu.mx/version10/index.php" onmouseout="MM_swapImgRestore();" ><img src="imagenes/logo_tec_r.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
            </div>
        </div>

            <jsp:include page="menuPanelUsuario.jsp" />

        <div id="contenido">
            <table class="general">
                <tr>
                    <td class="filas"><a id="b" href="seleccionarPlatica.do">PLATICA</a></td>
                    <td><img class="imagenes" src="imagenes/paloma.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="formatoUnicoUsuario.do">FORMATO UNICO</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="reporteBimestralAdministrador">FORMATOS BIMESTRALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">FORMATOS MENSUALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">PLATICA DE BECADOS</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">DOCUMENTOS FINALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">SANCIONES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>                            
            </table>






        </div>
        <%-- fin del contenido --%>
        <div id="footer">
            <img  src="imagenes/foter.png"/>
        </div>

    </body>


</html>
