<%-- 
    Document   : SubirReporteBimestral
    Created on : 27/09/2013, 01:45:05 PM
    Author     : ekt
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
    <body class ="background">
        <%@ include file="../Template/banner.jsp" %>
        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <div id="tabs">
                <h1>Subir Reporte Bimestral</h1>

                <form method="post" id="frmSubirCartaMotivos" action="guardarReporteBimestral.do"  enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td colspan="2">
                                <h3><p>Una vez que tengas esa informaci&oacute;n sube a continuaci&oacute;n tu documento en formato pdf, jpg, png o bmp. Para que pueda ser validado por el administrador</p></h3>
                            </td>
                        </tr>
                        <tr>
                            <td>No. de Control</td>
                            <td>
                                <input name ="no_control" id="no_control" value="${no_control}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Carta de motivos</td>
                            <td><input type='file'  name ='file' value='Buscar en mi equipo'/> <br/>
                                
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type='submit' value='Subir' /></td>
                        </tr>
                    </table>
                </form>

                <div style="clear:both;"></div>
            </div>
            <%-- fin del contenido --%>
            <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
