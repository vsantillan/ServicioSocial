<%-- 
    Document   : seleccionarPlatica
    Created on : 4/06/2013, 12:56:28 PM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <script type="text/javascript" src="js/platica.js"></script>
        <script src="js/actualizaPlatica.js"></script>
        <title>Selecciona Plática</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>
        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <center>
            <c:choose>
                <c:when test="${empty platicasPeriodo}">
                    <h1>No hay pláticas disponibles</h1>
                </c:when>
                <c:otherwise>
                    <h1>Selecciona Plática</h1>
                    <table border="0">
                        <tr>
                            <td align="center">
                                <form:form action="folioPlatica.pdf" method="get"  id="formSelecciona" commandName="platica" onsubmit="return marcado();" name="seleccionaPlatica">
                                    <h1>Fechas Disponibles</h1>
                                    <form:select path="fecha" >
                                        <core:forEach items="${platicasPeriodo}" var="platicasPeriodo" >
                                            <form:option value="${platicasPeriodo.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${platicasPeriodo.fecha}" /></form:option>                                    
                                        </core:forEach>
                                    </form:select>
                                    <p></p>               
                                    <textarea id="hora" rows="4" cols="50" disabled="true" style="background-color:#FFEBCD;border: 2px solid #CB8B07">Hora: ${platicasPeriodo.get(0).hora} Lugar: ${platicasPeriodo.get(0).idLugar.lugar}</textarea><br>
                                    <textarea  id="descripcion" rows="4" cols="50" disabled="true" style="background-color:#FFEBCD;border: 2px solid #CB8B07">Descripción:${platicasPeriodo.get(0).descripcion}</textarea><br>
                                    <input type="checkbox" name="aceptacionleer" value="aceptacionleer" id="aceptacionleer"> Acépto haber leído el manual donde se describe el uso del<br>
                                    sistema via web sobre como dar de alta mi servicio social<p></p>
                                    <input type="submit" value="Generar Folio" /> <br>
                                </form:form>
                            </td>
                        </tr>
                        </tbody>
                    </table> 
                       ${existe}
                </c:otherwise>
            </c:choose>

            <div style="clear:both;"></div>
            </center>
        </div>

        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>

</html>
