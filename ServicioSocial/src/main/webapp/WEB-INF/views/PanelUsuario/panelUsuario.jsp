<%-- 
    Document   : panelUsuario
    Created on : 3/06/2013, 10:52:04 AM
    Author     : Jose Manuel Nieto Gomez
--%>
<%
    HttpSession sesionOk = request.getSession();
    String nombre = sesionOk.getAttribute("NOMBRE").toString();
%>
<%@include file="General/jstl.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <%@include file="../General/head.jsp"%>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuUsuario.jsp"%> 
                <%@include file="../General/submenuUsuario.jsp"%>
                <!--------------------------------------------------Contenido--> 
                <div class="bs-docs-section">
                    <div class="page-header">
                        <!---------------------------------------Bienvenido Nombre Usuario-->    
                        <h1 class="derecha" >Bienvenido <%=nombre%></h1>
                        <!---------------------------------------Fin Bienvenido Nombre Usuario-->                                     
                    </div>
                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Noticias Generales</h3>
                        <!---------------------------------------Contenido Noticias Generales-------------------> 
                        <core:forEach items="${noticiasAlumnos}" var="noticia">
                            <li class="error"><b>${noticia.fecha}</b>: ${noticia.detalle}</li>
                                </core:forEach>
                        <!---------------------------------------Fin Contenido Noticias Generales------------------->
                    </div>          

                    <!--Menu proceso de servicio social-->
                    <div class="seccionCentral MyForm">
                        <h1>Proceso del Servicio Social</h1>
                        <table class="general">
                            <!--Carta de motivos-->
                            <core:choose>
                                <core:when  test="${tipoPanel==1 || tipoPanel == 2}">
                                    <tr>
                                        <td class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeCartaMotivos}" title="CARTA DE MOTIVOS">
                                            <core:choose>
                                                <core:when test="${accesoCartaMotivos}">
                                                    <a class="b" href="cartaMotivos.do">CARTA DE MOTIVOS</a>
                                                </core:when>
                                                <core:otherwise>
                                                    <p class="text">CARTA DE MOTIVOS</p>
                                                </core:otherwise>
                                            </core:choose>                        
                                        </td>
                                        <td>
                                            <core:choose>
                                                <core:when  test="${statusCartaMotivos==1}">
                                                    <img class="imagenes" src="imagenes/paloma.png"/>
                                                </core:when>    
                                                <core:when  test="${statusCartaMotivos==2}">
                                                    <img class="imagenes" src="imagenes/tache.png"/>
                                                </core:when> 
                                                <core:when  test="${statusCartaMotivos==3}">
                                                    <img class="imagenes" src="imagenes/reloj.png"/>
                                                </core:when>
                                            </core:choose> 
                                        </td>
                                    </tr>
                                </core:when>    

                                <core:when  test="${tipoPanel ==0 || tipoPanel == 2}">
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
                                            <!--<a class="b" href="formatoReporteBimestral.do">REPORTES BIMESTRALES</a>-->
                                            <core:choose>
                                                <core:when test="${accesoReportesBimestrales}">
                                                    <a class="b" href="formatoReporteBimestral.do">REPORTES BIMESTRALES</a>
                                                </core:when>
                                                <core:otherwise>
                                                    <p class="text">REPORTES BIMESTRALES</p>
                                                </core:otherwise>
                                            </core:choose>                                        
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
                                            <!--
                                            <core:choose>
                                                <core:when test="${accesoDocumentosFinales}">
                                                    <a class="b" href="#">DOCUMENTOS FINALES</a>
                                                </core:when>
                                                <core:otherwise>
                                                    <p class="text">DOCUMENTOS FINALES</p>
                                                </core:otherwise>
                                            </core:choose>    
                                            -->
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
                                                <core:when  test="${statusDocumentosFinales==4}">
                                                    <img class="imagenes" src="imagenes/paloma.png"/>
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
                                </core:when> 
                            </core:choose> 

                        </table>
                    </div>

                    <!--Menu proceso de servicio social-->

                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Mensajes Personales</h3>
                        <!---------------------------------------Contenido Noticias Generales-------------------> 
                        ${mensajePersonal}
                        <!---------------------------------------Fin Contenido Noticias Generales------------------->
                    </div>
                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Observaciones</h3>
                        <!---------------------------------------Contenido Observaciones----------------------------->
                        <core:forEach items="${observaciones}" var="observacion">
                            <li class="error"><b>${observacion.fecha}</b>: ${observacion.catalogoObservacionId.detalle}</li>
                                </core:forEach>
                        <!---------------------------------------Fin Contenido Observaciones------------------->
                    </div>
                    <div class="page-header  borde-naranja">
                        <h3 class="titulos-naranja">Sanciones</h3>
                        <!---------------------------------------Contenido Sanciones----------------------------->
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
                        <!---------------------------------------Fin Contenido Sanciones------------------->
                    </div>
                </div>
                <!--------------------------------------------------Fin Contenido--> 
            </div>         
        </div><!--/row--> 
        <%@include file="../General/footer.jsp"%>            
    </div><!--/row-->
</div> <!-- /container -->
<%@include file="../General/js.jsp"%>
</body>
</html>


