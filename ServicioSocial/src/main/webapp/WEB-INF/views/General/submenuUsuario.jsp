<%-- 
    Document   : submenuUsuario
    Created on : 22/01/2014, 03:56:21 PM
    Author     : Jonny
--%>
<%@include file="../General/jstl.jsp"%>
<div class="container bs-docs-container">
    <div class="row">
        <div class="col-md-3 lateral-menu" >
            <br>
            <p class="lateral">A continuación se presenta un menú con el proceso de tu servicio social, te mostraremos que significan los íconos:<p>
                <span class="glyphicon glyphicon-ok"></span>: Proceso Completo <br>                
                <span class="glyphicon glyphicon-time"></span>: Proceso en Corrección o Revisión<br> 
                <span class="glyphicon glyphicon-remove"></span>: Proceso no Realizado <br>

            <div class="bs-sidebar hidden-print panelLateral list-group" role="complementary">
                <ul class="nav bs-sidenav ">
                    <li class="filas borde" data-toggle="popover" data-placement="right" data-content="${mensajePlatica}" title="Plática">
                        <core:choose>
                            <core:when test="${accesoPlatica}">
                                 <a data-toggle="popover" href="seleccionarPlatica.do">Pl&aacute;tica
                            </core:when>
                            <core:otherwise>
                                <a class="b" href="#">Pl&aacute;tica
                            </core:otherwise>
                        </core:choose>  
                                <core:choose>
                            <core:when  test="${platica}">
                                <span class="glyphicon glyphicon-ok"></span>
                            </core:when>                            
                            <core:otherwise>
                                <span class="glyphicon glyphicon-remove"></span>
                            </core:otherwise>
                        </core:choose>
                                </a>
                    </li>
                    <li class="filas borde" data-toggle="popover" data-placement="right" data-content="${mensajeFormatoUnico}" title="Formato Único"> 
                        <core:choose>
                            <core:when test="${accesoFormatoUnico}">
                                <a class="b" href="formatoUnicoUsuario.do">Formato Único
                            </core:when>
                            <core:otherwise>
                                 <a class="b" href="#">Formato Unico
                            </core:otherwise>
                        </core:choose>
                                 <core:choose>
                            <core:when  test="${statusFui==1}">
                                <span class="glyphicon glyphicon-ok"></span>
                            </core:when>    
                            <core:when  test="${statusFui==2}">
                                <span class="glyphicon glyphicon-remove"></span>
                            </core:when> 
                            <core:when  test="${statusFui==3}">
                                <span class="glyphicon glyphicon-time"></span>
                            </core:when>
                        </core:choose>   
                                 </a>
                    </li>
                    <li  class="filas borde" data-toggle="popover" data-placement="right" data-content="${mensajeReportesBimestrales}" title="Reportes Bimestrales">
                        <core:choose>
                            <core:when test="${accesoReportesBimestrales}">
                                <a  href="formatoReporteBimestral.do">Reportes Bimestrales
                            </core:when>
                            <core:otherwise>
                                <a  href="#">Reportes Bimestrales
                            </core:otherwise>
                        </core:choose>  
                        <core:choose>
                            <core:when  test="${statusReporteBimestrales==1}">
                                 <span class="glyphicon glyphicon-ok"></span>
                            </core:when>    
                            <core:when  test="${statusReporteBimestrales==2}">
                                 <span class="glyphicon glyphicon-remove"></span>
                            </core:when> 
                            <core:when  test="${statusReporteBimestrales==3}">
                                <span class="glyphicon glyphicon-time"></span>
                            </core:when>
                        </core:choose> 
                      </a> </li>
                    <li class="filas borde" data-toggle="popover" data-placement="right" data-content="${mensajeDocumentosFinales}" title="Documentos Finales">
                        <core:choose>
                            <core:when test="${accesoDocumentosFinales}">
                                <a class="b" href="#">Documentos Finales
                            </core:when>
                            <core:otherwise>
                                 <a class="b" href="#">Documentos Finales
                            </core:otherwise>
                        </core:choose>
                                      <core:choose>
                            <core:when  test="${statusDocumentosFinales==1}">
                                 <span class="glyphicon glyphicon-ok"></span>
                            </core:when>    
                            <core:when  test="${statusDocumentosFinales==2}">
                                <span class="glyphicon glyphicon-remove"></span>
                            </core:when> 
                            <core:when  test="${statusDocumentosFinales==3}">
                                <span class="glyphicon glyphicon-time"></span>
                            </core:when>
                            <core:when  test="${statusDocumentosFinales==4}">
                                 <span class="glyphicon glyphicon-ok"></span>
                                <span class="glyphicon glyphicon-time"></span>
                            </core:when>
                        </core:choose> 
                      </a>
                    </li>
                    <li class="filas borde" data-toggle="popover" data-placement="right" data-content="${mensajeSanciones}" title="Sanciones">
                        <a href="#">Sanciones 
                        <core:choose>
                            <core:when test="${tieneSancion}">
                                 <span class="glyphicon glyphicon-remove"></span>
                            </core:when>
                            <core:otherwise>
                                <span class="glyphicon glyphicon-ok"></span>
                            </core:otherwise>
                        </core:choose></a></li>
                </ul>   
            </div>
            <br>
            <p class="lateral">Es importante que recuerdes que a pesar de que el proceso es digital, debes conservar todos tus documentos y formatos originales,
                ya que deben ser entregados físicamente al final de tu proceso de servicio social.<p>  
        </div>
        <div class="col-md-9" role="main">
