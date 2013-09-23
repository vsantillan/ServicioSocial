<%-- 
    Document   : cartaMotivos
    Created on : 23/09/2013, 11:58:08 AM
    Author     : SATELLITE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/sinJavascript.jsp" %>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <jsp:include page="../Template/headsJQueryUI.jsp" /><!--Hay conflicto de datatables con estilo forms--->
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        <!-- Javascripts -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>
        <script src="js/jqueryUI/jquery.ui.core.js"></script>
        <script src="js/jqueryUI/jquery.ui.widget.js"></script>
        <script src="js/jqueryUI/jquery.ui.tabs.js"></script>
        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <title>Carta de Motivos</title>
    </head>
    <body class ="background" onload="recargaCombosOrgs(${formatoUnicoDatosOrganizaciones.idProyecto});">
        <%@ include file="../Template/banner.jsp" %>
        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <div id="tabs">
                <h1>Registro de Carta de motivos</h1>
                <h1>No. Control: ${idAlumno} Nombre: ${nombre}</h1>
                <h3>Para que puedas iniciar tu proceso formal en el Servicio social, es necesario que subas una Carta de Motivos, en donde contemples los siguientes puntos</h3>
                <ul>
                    <li>Nombre Completo</li>
                    <li>Motivos por los cuales no realiz&oacute; su servicio social a tiempo.</li>
                </ul>

                <form method="post" id="frmSubirFui" action="subirFui.do"  enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h3><p>Una vez que tengas esa informaci&oacute;n sube a continuaci&oacute;n tu documento en formato pdf, jpg, png o bmp. Para que pueda ser validado por el administrador</p></h3>
                            </td>
                        </tr>
                        <input type="hidden" name ="idAlumno" id="idAlumno" value="${idAlumno}"/>
                        <input type="hidden" name ="idDatosPersonales" id="idDatosPersonales" value="${idDatosPersonales}"/>
                        <tr>
                            <td>Carta de motivos</td>
                            <td><input type='file'  name ='file' value='Buscar en mi equipo'/> <br/>
                                <input type='submit' value='Subir' />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <h3><p>Ingresa tambi&eacute;n una direcci&oacute;n de correo electr&oacute; donde recibir&aacute;s retroalimetnaci&oacute;n del encargado de servicio social.</p></h3>
                            </td>
                        </tr>
                        <tr>
                            <td>Correo electr&oacute;nico</td>
                            <td><input type="text" name="email" value="${email}"/></td>
                        </tr>
                    </table>
                </form>
<!--                <ul>
                    <li><a href="#datosPersonales">1.Datos Personales</a></li>
                </ul>
                <div id="datosPersonales">

                </div>-->
                <div style="clear:both;"></div>
            </div>
            <%-- fin del contenido --%>
            <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
