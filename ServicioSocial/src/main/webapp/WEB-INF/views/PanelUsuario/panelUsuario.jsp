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
        <style>
            .mensajesProceso{
                position:fixed;
                width:80%;
                height:100px;
                bottom: 20px;
                left: 10%; 
                background-color: white;
                z-index:100;
                -webkit-border-radius: 6px;
		-moz-border-radius: 6px;
		border-radius: 6px;
		border:#01406a solid 1px;
            }
            .oculto{
                display:none;
            }
            .text{
                color:white;
            }
        </style>
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
            <div id="mensajesProceso" class="mensajesProceso oculto">
                <div id="platica"  class="oculto">            
                    <h1>Pl&aacute;tica</h1>
                    <p>${mensajePlatica}</p>                   
                </div>
                <div id="formatoUnico"  class="oculto">            
                    <h1>Formato &Uacute;nico</h1>
                    <p>${mensajeFormatoUnico}</p>                   
                </div>
                <div id="reportesBimestrales"  class="oculto">            
                    <h1>Reportes Bimestrales</h1>
                    <p>${mensajeReportesBimestrales}</p>                   
                </div>
                <div id="reportesMensuales"  class="oculto">            
                    <h1>Reportes Mensuales</h1>
                    <p>${mensajeReportesMensuales}</p>                   
                </div>
                <div id="platicaBecados"  class="oculto">            
                    <h1>Pl&aacute;tica Becados</h1>
                    <p>${mensajePlaticaBecados}</p>                   
                </div>
                <div id="documentosFinales"  class="oculto">            
                    <h1>Documentos Finales</h1>
                    <p>${mensajeDocumentosFinales}</p>                   
                </div>
                <div id="sanciones"  class="oculto">            
                    <h1>Sanciones</h1>
                    <p>${mensajeSanciones}</p>                   
                </div>
            </div>
            <table class="general">
                <tr>
                    <td class="filas" id="filaPlatica">
                        <core:choose>
                            <core:when test="${accesoPlatica}">
                                <a id="b" href="seleccionarPlatica.do">PL&Aacute;TICA</a>
                            </core:when>
                            <core:otherwise>
                                <p class="text">PL&Aacute;TICA</p>
                            </core:otherwise>
                        </core:choose>                        
                    </td>
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
                <tr>
                    <td class="filas" id="filaFormatoUnico"><a id="b" href="formatoUnicoUsuario.do">FORMATO UNICO</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas" id="filaReportesBimestrales"><a id="b" href="formatoReporteBimestral.do">REPORTES BIMESTRALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas" id="filaReportesMensuales"><a id="b" href="#">REPORTES MENSUALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas" id="filaPlaticaBecados"><a id="b" href="#">PLATICA DE BECADOS</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas" id="filaDocumentosFinales"><a id="b" href="#">DOCUMENTOS FINALES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr>
                <tr>
                    <td class="filas" id="filaSanciones"><a id="b" href="#">SANCIONES</a></td>
                    <td><img class="imagenes" src="imagenes/tache.png"/></td>
                </tr> 
            </table>
            <br/><br/><br/>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>

    </body>


</html>
