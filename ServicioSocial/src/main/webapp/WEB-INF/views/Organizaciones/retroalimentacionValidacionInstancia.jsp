<%-- 
    Document   : retroalimentacionOrganizacion
    Created on : 4/06/2013, 02:24:00 PM
    Author     : Regules
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>

        <script>
            $(function() {
                $("#tabs").tabs();
            });
            

        </script>
        <title>Cancelaci&oacute;n de Organizaci&oacute;n </title>
    </head>
    <body class="background">
        <div id="contenido">
            <h2>Cancelacion de Organizaci&oacute;n</h2>
            <div id="tabs">
                <ul>
                    <li><a href="#">Enviar Retroalimentaci&oacute;n</a></li>
                </ul>
                <div>
                    <form:form commandName="retroalimentacionInstancia" id="MyForm" action="borrarInstancia.do" method="POST">
                        <table>
                            <tr>
                                <form:hidden path="id" value="${instancia.idInstancia}" class="idIns" />
                                <form:hidden path="control" value="2" />
                                <td>Nombre de la Organizaci&oacute;n:</td>
                                <td><form:input type ="text" path="nombre" id="nombre" value="${instancia.nombre}"/> </td>
                            </tr>
                            <tr>
                                <td>E-Mail:</td>
                                <td><form:input type ="text" path="correo" id="correo" value="${instancia.correo}"/> </td>
                            </tr>
                            <tr>
                                <td>Descripci&oacute;n:</td>
                                <td><form:textarea path="descripcion" id="descripcion" rows="10" cols="70"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Enviar Retroalimentaci&oacute;n" class="redir borrarInstancia" /> </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>