<%-- 
-    Document   : envioCorreo
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
---%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
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
        <title>Envio Correos</title>
    </head>
    <body >


        <%-- inicio del contenido --%>
        <div id="contenido">
            <center> 
                <h1>Envio Correos</h1>
                <%-- Envio Correos --%>
                <div>
                    <form>
                        <table>
                            <tr>
                                <td>Destinatarios:</td>
                                <td><input type ="text" name ="nombre"  disabled="disabled"> </td>
                            </tr>
                            <tr>
                                <td>Asunto:</td>
                                <td><input type ="text" > </td>
                            </tr>
                            <tr>
                                <td>Descripci&oacute;n:</td>
                                <td><textarea name="descripcion" rows="15" cols="70"></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Enviar" > </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </center>
        </div>
        <%-- fin del contenido --%>
    </body>
</html>
