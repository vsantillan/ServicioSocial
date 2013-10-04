<%-- 
    Document   : pruebaPopover
    Created on : 04-oct-2013, 9:46:14
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-boot.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrap-popover.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />

    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="#" id="example" class="btn" data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="Popover on right">Popover on right</a>
        <table class="general">
            <tr>
                <td class="filas" id="filaPlatica" data-toggle="popover" data-placement="right" data-content="HoLa!" title="PLÁTICA">
                    Hola 
                <td>
            </tr>
        </table>

        <script>
            $(document).ready(function() {

                $("#filaPlatica").mouseover(function(event) {
                    $(this).popover("show");
                });

                $("#filaPlatica").mouseleave(function(event) {
                    $(this).popover("hide");
                });
            });
        </script>
    </body>
</html>
