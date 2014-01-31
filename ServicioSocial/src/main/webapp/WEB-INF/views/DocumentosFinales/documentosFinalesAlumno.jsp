<%-- 
    Document   : documentosFinalesAlumno
    Created on : 1/11/2013, 10:19:14 AM
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

        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <title>Documentos Finales</title>
    </head>
    <body class ="background">
        <%@ include file="../Template/banner.jsp" %>
        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <div id="tabs">
                <h1>Documentos Finales</h1>
                ${error}
                <core:choose>
                    <core:when test="${planAlumno=='S'}">
                        <form method="post" id="frmSubirCartaMotivos" action="guardarDocumentosFinales.do"  enctype="multipart/form-data">
                            <table>
                                <tr>
                                    <td colspan="2">
                                        <h3><p>Tus documentos debe de tener un formato <code>pdf</code> para que pueda ser validado por el administrador</p></h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>No. de Control</td>
                                    <td>
                                        <input name ="no_control" id="no_control" value="${no_control}" disabled="disabled"/>
                                    </td>
                                </tr>
                                ${muestraRF}
                                ${error_fr}
                                ${muestraCP}
                                ${error_cp}
                                ${muestraFUF}
                                ${error_fuf}
                                ${muestraRE}
                                ${error_fe}
                                <tr>
                                    <td></td>
                                    <td><input type='submit' value='Subir' /></td>
                                </tr>
                            </table>
                        </form>
                    </core:when>
                    <core:when test="${planAlumno=='N'}">
                        <form method="post" id="frmSubirCartaMotivos" action="guardarDocumentosFinalesAux.do"  enctype="multipart/form-data">
                            <table>
                                <tr>
                                    <td colspan="2">
                                        <h3><p>Tus documentos debe de tener un formato <code>pdf</code> para que pueda ser validado por el administrador</p></h3>
                                    </td>
                                </tr>
                                <tr>
                                    <td>No. de Control</td>
                                    <td>
                                        <input name ="no_control" id="no_control" value="${no_control}" disabled="disabled"/>
                                        <form:hidden  name ="no_control" path="no_control" value="${no_control}" size="20"/>
                                    </td>
                                </tr>
                                ${muestraRF}
                                ${error_fr}
                                ${muestraCP}
                                ${error_cp}
                                ${muestraFUF}
                                ${error_fuf}
                                <tr>
                                    <td></td>
                                    <td><input type='submit' value='Subir' /></td>
                                </tr>
                            </table>
                        </form>
                    </core:when>
                </core:choose>

                <div style="clear:both;"></div>
            </div>
            <%-- fin del contenido --%>
            <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
