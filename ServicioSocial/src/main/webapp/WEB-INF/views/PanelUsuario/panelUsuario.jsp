<%-- 
    Document   : panelUsuario
    Created on : 3/06/2013, 10:52:04 AM
    Author     : roy
--%>
<%
    HttpSession sesionOk = request.getSession();
    String rol = sesionOk.getAttribute("ROL").toString();
    String ncontrol = sesionOk.getAttribute("NCONTROL").toString();
    String nombre = sesionOk.getAttribute("NOMBRE").toString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <script src="js/jquery.manolo.js"></script>
        <title>Home Usuario</title>
    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />

        <jsp:include page="menuPanelUsuario.jsp" />

        <div id="contenido">

            <h1>Panel de Usuario</h1>

            <div class="MyForm" style="width: 70%; margin-left: auto; margin-right: auto;">
                <h1>Bienvenido <%=nombre%></h1>
                <p>A continuaci&oacute;n se presenta un men&uacute; con el proceso de tu servicio social, te mostraremos que significan los &iacute;conos:.</p>
                <ul>
                    <li><img src="imagenes/paloma.png" height="30"/>: Proceso Completado</li>
                    <li><img src="imagenes/reloj.png" height="30"/>: Proceso en Revisi&oacute;n</li>
                    <li><img src="imagenes/tache.png" height="30"/>: Proceso No realizado</li>
                </ul>
            </div>
            <br/>
            <table class="general">
                <tr>
                    <td class="filas" id="filaPlatica"><a id="b" href="seleccionarPlatica.do">PLATICA</a></td>
                    <td>
                        <core:choose>
                            <core:when  test="${platica}">
                                <img class="imagenes" src="imagenes/paloma.png"/>
                            </core:when>                            
                            <core:otherwise>
                                <img class="imagenes" src="imagenes/tache.png"/>
                            </core:otherwise>
                        </core:choose>
                    </td>
                </tr>
                <tr style="display:none;" id="platica">
                    <td>
                        <div class="MyForm">
                            <p>${mensajePlatica}</p>
                        </div>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="formatoUnicoUsuario.do">FORMATO UNICO</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr style="display:none;" id="">
                    <td colspan="2">
                        <div class="MyForm">

                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="formatoReporteBimestral.do">FORMATOS BIMESTRALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr style="display:none;" id="">
                    <td colspan="2">
                        <div class="MyForm">

                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">FORMATOS MENSUALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr style="display:none;" id="">
                    <td colspan="2">
                        <div class="MyForm">

                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">PLATICA DE BECADOS</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr style="display:none;" id="">
                    <td colspan="2">
                        <div class="MyForm">

                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">DOCUMENTOS FINALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr style="display:none;" id="">
                    <td colspan="2">
                        <div class="MyForm">

                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">SANCIONES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr> 
                <tr style="display:none;" id="">
                    <td colspan="2">
                        <div class="MyForm">

                        </div>
                    </td>
                </tr>
            </table>
            <br/><br/><br/>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>

    </body>


</html>
