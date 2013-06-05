<%-- 
    Document   : retroalimentacionOrganizacion
    Created on : 4/06/2013, 02:24:00 PM
    Author     : Regules
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Css -->
        <link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
        <link rel="stylesheet" type="text/css" href="css/screen.css" />
        <link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" />
        <!--JavaScrips -->
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/baner.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js" ></script>
        <script>
            $(function() {
                $("#tabs").tabs();
                $('#timepicker').timepicker();
            });
        </script>
        <title>Home Usuario</title>
    </head>
    <body>
        <div id="contenido">
            <h2>Cancelacion de Organizaci&oacute;n</h2>
            <div id="tabs">
                <ul>
                    <li><a href="#">Enviar Correo de Cancelado</a></li>
                </ul>
                <div>
                    <form>
                        <table>
                            <tr>
                                <td>Nombre de la Organizaci&oacute;n:</td>
                                <td><input type ="text" name ="nombre"  disabled=" disabled"> </td>
                            </tr>
                            <tr>
                                <td>E-Mail:</td>
                                <td><input type ="text" name ="email"  disabled=" disabled"> </td>
                            </tr>
                            <tr>
                                <td>Descripci&oacute;n:</td>
                                <td><textarea name="descripcion" rows="10" cols="70"></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Enviar Correo" > </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

