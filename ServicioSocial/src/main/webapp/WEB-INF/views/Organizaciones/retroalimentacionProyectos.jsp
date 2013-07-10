<%-- 
    Document   : retroalimentacionProyectos
    Created on : 5/06/2013, 10:43:26 AM
    Author     : ekt
--%>
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
        <script type="text/javascript" src="js/editaOrganizacion.js"></script>
        <script>
            $(function() {
                $("#tabs").tabs();
                $('#timepicker').timepicker();
            });
        </script>
        
        <title>Cancelacion de Proyecto</title>
    </head>
    <body>

        <div id="contenido">
            <h2>Cancelacion de Proyecto</h2>
            <div id="tabs">
                <ul>
                    <li><a href="#">Enviar Retroalimentaci&oacute;n</a></li>
                </ul>
                <!--<div>onsubmit="return borrarProyecto.do;" action="borrarProyecto.do"-->
                <form:form commandName="borrarProyecto" id="MyForm" action="">
                        <table>
                            <tr>
                                <td>Nombre del Proyecto:</td>
                                <td><form:input id="nombreProyecto" path="nombreProyecto" disabled="disabled" value="${proyectos.nombre}" /></td>
                            </tr>
                            <tr>
                                <td>Nombre de la Organizaci&oacute;n:</td>
                                <td><form:input id="nombreInstancia" path="nombreInstancia" disabled="disabled" value="${proyectos.idInstancia.nombre}" /></td>
                            </tr>
                            <tr>
                                <td>E-Mail:</td>
                                <td><form:input id="email" path="email" disabled="disabled" value="${proyectos.idInstancia.correo}" /></td>
                            </tr>
                            <tr>
                                <td>Descripci&oacute;n:</td>
                                <td><form:textarea rows="10" cols="70" id="descripcion" path="descripcion" /></td>
                            </tr>
                            <tr>
                                <td></td>
<!--                                onclick="alert('Hola');window.parent.Shadowbox.close();"-->
                                <td><input type="submit" value="Enviar Retroalimentaci&oacute;n" class="borrarProyecto" /></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>

    </body>
</html>