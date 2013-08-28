<%-- 
    Document   : AsistenciaPosteriorEspecial
    Created on : 4/06/2013, 12:19:34 PM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <link rel="stylesheet" href="css/platicasEstiloFormularioformly.css" type="text/css" />


        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>

        <script>

            $(document).ready(function() {

                $('#casistenciaespecial').formly();
            });
        </script>
        <title>Capturar Asistencia Especial Posterior</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center><h2>Capturar Asistencia Especial Posterior</h2></center>  
                <center> ${error}
                    <form:form name="casistenciaespecial" id="casistenciaespecial" action="ponerAsistenciaEspecial.do" method="Post">
                        <table>
                            <tr>
                                <td><label><fmt:message key="select_platica"/></label></td>
                                <td>
                                    <select name="idPlatica" id="idPlatica">
                                        <core:forEach items="${platicasPeriodo}" var="platicasPeriodo" >
                                            <c:choose>
                                                <c:when test="${idP==platicasPeriodo.id}">
                                                    <option value="${platicasPeriodo.id}" selected="selected" ><fmt:formatDate pattern="dd/MM/yyyy" value="${platicasPeriodo.fecha}" /></option> 
                                                </c:when>
                                                <c:otherwise>
                                                     <option value="${platicasPeriodo.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${platicasPeriodo.fecha}" /></option> 
                                                </c:otherwise>
                                            </c:choose>                                   
                                        </core:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="alumno"><fmt:message key="no_control"/></label></td>
                                <td> <input type="text" autofocus="true"name="no_control" id="no_control" size="15" /> </td>
                            </tr>
                            <tr>
                                <td><button type="submit"> Asistió</button></td>
                                <td><button type="reset">Limpiar</button></td>
                            </tr>
                        </table>
                        <fmt:message key="datosRequeridos" />
                    </form:form>
                    <h3>Folio:${folio}</h3>
                </center>
            </div>
            <div style="clear:both;"></div>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
