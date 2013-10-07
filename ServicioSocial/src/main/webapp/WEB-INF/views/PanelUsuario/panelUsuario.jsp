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
        <script src="js/jquery-boot.js"></script>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrap-popover.js"></script>
        <script src="js/jquery.manolo.js"></script>

        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />


        <title>Home Usuario</title>
    </head>
    <body class="background" >
        <jsp:include page="../Template/banner.jsp" />

        <jsp:include page="menuPanelUsuario.jsp" />

        <div id="contenido">

            <h1>Panel de Usuario</h1>

            <!--Cuadro de bienvenida-->
            <div class="MyForm mensajeBienvenida">
                <h1>Bienvenido <%=nombre%></h1>
                <p>A continuaci&oacute;n se presenta un men&uacute; con el proceso de tu servicio social, te mostraremos que significan los &iacute;conos: </p>
                <ul>
                    <li><img src="imagenes/paloma.png" height="30"/>: Proceso Completado</li>
                    <li><img src="imagenes/reloj.png" height="30"/>: Proceso en Revisi&oacute;n</li>
                    <li><img src="imagenes/tache.png" height="30"/>: Proceso No realizado</li>
                </ul>
            </div>
            <br/>
            <!--/Cuadro de bienvenida-->            

            <!--Seccion de noticias generales-->
            <div class="seccionLateral MyForm ">
                <h1>Noticias Generales</h1>
                <ul class="scroll listaNoticias">
                    <core:forEach items="${noticiasAlumnos}" var="noticia">
                        <li class="error"><b>${noticia.fecha}</b>: ${noticia.detalle}</li>
                            </core:forEach>
                </ul>

            </div>
            <!--/Seccion de noticias generales-->

            <!--Menu proceso de servicio social-->
            <div class="seccionCentral MyForm">
                <h1>Proceso del Servicio Social</h1>
                <table class="general">
                    <tr>
                        <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajePlatica}" title="PLÁTICA">
                            <core:choose>
                                <core:when test="${accesoPlatica}">
                                    <a class="b" href="seleccionarPlatica.do">PL&Aacute;TICA</a>
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
                        <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeFormatoUnico}" title="FORMATO ÚNICO">
                            <core:choose>
                                <core:when test="${accesoFormatoUnico}">
                                    <a class="b" href="formatoUnicoUsuario.do">FORMATO UNICO</a>
                                </core:when>
                                <core:otherwise>
                                    <p class="text">FORMATO UNICO</p>
                                </core:otherwise>
                            </core:choose>                            
                        </td>
                        <td>
                            <core:choose>
                                <core:when  test="${statusFui==1}">
                                    <img class="imagenes" src="imagenes/paloma.png"/>
                                </core:when>    
                                <core:when  test="${statusFui==2}">
                                    <img class="imagenes" src="imagenes/tache.png"/>
                                </core:when> 
                                <core:when  test="${statusFui==3}">
                                    <img class="imagenes" src="imagenes/reloj.png"/>
                                </core:when>
                            </core:choose>                            
                        </td>
                    </tr>
                    <tr>
                        <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeReportesBimestrales}" title="REPORTES BIMESTRALES">
                            <a class="b" href="formatoReporteBimestral.do">REPORTES BIMESTRALES</a>
                            <!--
                            <core:choose>
                                <core:when test="${accesoReportesBimestrales}">
                                    <a class="b" href="formatoReporteBimestral.do">REPORTES BIMESTRALES</a>
                                </core:when>
                                <core:otherwise>
                                    <p class="text">REPORTES BIMESTRALES</p>
                                </core:otherwise>
                            </core:choose>    
                            -->
                        </td>
                        <td>
                            <core:choose>
                                <core:when  test="${statusReporteBimestrales==1}">
                                    <img class="imagenes" src="imagenes/paloma.png"/>
                                </core:when>    
                                <core:when  test="${statusReporteBimestrales==2}">
                                    <img class="imagenes" src="imagenes/tache.png"/>
                                </core:when> 
                                <core:when  test="${statusReporteBimestrales==3}">
                                    <img class="imagenes" src="imagenes/reloj.png"/>
                                </core:when>
                            </core:choose> 
                        </td>
                    </tr>
                    <!--                    <tr>
                                            <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeReportesMensuales}" title="REPORTES MENSUALES"><a class="b" href="#">REPORTES MENSUALES</a></td>
                                            <td><img class="imagenes" src="imagenes/tache.png"/></td>
                                        </tr>-->
                    <!--                    <tr>
                                            <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajePlaticaBecados}" title="PLATICA BECADOS"><a class="b" href="#">PLATICA DE BECADOS</a></td>
                                            <td><img class="imagenes" src="imagenes/tache.png"/></td>
                                        </tr>-->
                    <tr>
                        <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeDocumentosFinales}" title="DOCUMENTOS FINALES">
                            <a class="b" href="#">DOCUMENTOS FINALES</a>
                        </td>
                        <td>
                            <core:choose>
                                <core:when  test="${statusDocumentosFinales==1}">
                                    <img class="imagenes" src="imagenes/paloma.png"/>
                                </core:when>    
                                <core:when  test="${statusDocumentosFinales==2}">
                                    <img class="imagenes" src="imagenes/tache.png"/>
                                </core:when> 
                                <core:when  test="${statusDocumentosFinales==3}">
                                    <img class="imagenes" src="imagenes/reloj.png"/>
                                </core:when>
                            </core:choose> 
                        </td>
                    </tr>
                    <tr>
                        <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeSanciones}" title="SANCIONES">
                            <p class="text">SANCIONES</p>
                        </td>
                        <td>
                            <core:choose>
                                <core:when test="${tieneSancion}">
                                    <img class="imagenes" src="imagenes/tache.png"/>
                                </core:when>
                                <core:otherwise>
                                    <img class="imagenes" src="imagenes/paloma.png"/>
                                </core:otherwise>
                            </core:choose>
                        </td>
                    </tr> 
                </table>
            </div>

            <!--Menu proceso de servicio social-->

            <!--Mensajes personales-->
            <div class="seccionLateral MyForm">
                <h1>Mensajes Personales</h1>
                ${mensajePersonal}
            </div>
            <!--/Mensajes personales-->

            <div style="clear: both"></div>

            <!--Observaciones-->
            <div class="divInferior MyForm">
                <h1>Observaciones</h1>
                <ul class="scrollDivInferior">
                    <core:forEach items="${observaciones}" var="observacion">
                        <li class="error"><b>${observacion.fecha}</b>: ${observacion.catalogoObservacionId.detalle}</li>
                            </core:forEach>
                </ul>
            </div>
            <!--/Observaciones-->

            <!--Sanciones-->
            <div class="divInferior MyForm">
                <h1>Sanciones</h1>
                <ul class="scrollDivInferior">
                    <core:forEach items="${sanciones}" var="sancion">
                        <core:choose>
                            <core:when  test="${sancion.concepto==0}">
                                <li class="error"><b>${sancion.fecha}</b>: ${sancion.detalle}</li>
                                    </core:when>    
                                    <core:when  test="${sancion.concepto==1}">
                                <li class="success"><b>${sancion.fecha}</b>: ${sancion.detalle}</li>
                                    </core:when> 
                                </core:choose> 
                            </core:forEach>
                </ul>
            </div>
            <!--/Sanciones-->
            <br/>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>

    </body>


</html>
