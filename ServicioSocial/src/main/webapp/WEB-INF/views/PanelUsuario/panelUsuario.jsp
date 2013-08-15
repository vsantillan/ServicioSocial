<%-- 
    Document   : panelUsuario
    Created on : 3/06/2013, 10:52:04 AM
    Author     : roy
--%>
<%
    HttpSession sesionOk = request.getSession();
    String rol=sesionOk.getAttribute("ROL")+"";
    String ncontrol=sesionOk.getAttribute("NCONTROL")+"";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <title>Home Usuario</title>
    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />

        <jsp:include page="menuPanelUsuario.jsp" />

        <div id="contenido">

            <h1>Panel de Usuario</h1>
            <table class="general">
                <tr>
                    <td class="filas"><a id="b" href="seleccionarPlatica.do">PLATICA</a></td>
                    <td><img class="imagenes" src="imagenes/paloma.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="formatoUnicoUsuario.do">FORMATO UNICO</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="formatoReporteBimestral.do">FORMATOS BIMESTRALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">FORMATOS MENSUALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">PLATICA DE BECADOS</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">DOCUMENTOS FINALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas"><a id="b" href="#">SANCIONES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>                            
            </table>
            <h3>ROL:<%=rol%></h3>
            <h3>NCONTROL:<%=ncontrol%></h3>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>

    </body>


</html>
