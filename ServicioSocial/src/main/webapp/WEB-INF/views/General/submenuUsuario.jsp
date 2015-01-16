<%-- 
    Document   : submenuUsuario
    Created on : 22/01/2014, 03:56:21 PM
    Author     : Jonny
--%>

<%@page import="edu.servicio.toluca.entidades.Platica"%>
<%
    Platica p = new Platica();
    
    
%>

<%@include file="../General/jstl.jsp"%>
<div class="container bs-docs-container">
    <div class="row">
        <div class="col-md-3 lateral-menu" >
            <br>
            <p class="lateral">A continuaci�n se presenta un men� con el proceso de tu servicio social, te mostraremos que significan los �conos:<p>
                <span class="glyphicon glyphicon-ok"></span>: Proceso Completo <br>                
                <span class="glyphicon glyphicon-time"></span>: Proceso en Correcci�n o Revisi�n<br> 
                <span class="glyphicon glyphicon-remove"></span>: Proceso no Realizado <br>              
                <br>
                <label class="list-group-item active-menu">Proceso de tu servicio social
                    <span class="glyphicon glyphicon-home pull-right"></span>
                </label>
            <div class=" hidden-print panelLateral " role="complementary">
                <ul class="nav bs-sidenav ">   
                    <li class="filas" data-toggle="popover" data-placement="right" data-content="${mensajePlatica}" title="Pl�tica">
                        <core:choose>
                            <core:when test="${accesoPlatica}">
                                <a class="b list-group-item" data-toggle="popover" href="seleccionarPlatica.do">Pl&aacute;tica
                                </core:when>
                                <core:otherwise>
                                    <a class="b list-group-item" href="#">Pl&aacute;tica
                                    </core:otherwise>
                                </core:choose>  
                                <core:choose>
                                    <core:when  test="${platica}">
                                        <span class="glyphicon glyphicon-ok pull-right"></span>
                                    </core:when>                            
                                    <core:otherwise>
                                        <span class="glyphicon glyphicon-remove pull-right"></span>
                                    </core:otherwise>
                                </core:choose>
                            </a>
                    </li>
                    <li class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeFormatoUnico}" title="Formato �nico"> 
                        <core:choose>
                            <core:when test="${accesoFormatoUnico}">
                                <a class="b list-group-item " href="formatoUnicoUsuario.do">Formato �nico
                                </core:when>
                                <core:otherwise>
                                    <a class="b list-group-item" href="#">Formato Unico
                                    </core:otherwise>
                                </core:choose>
                                <core:choose>
                                    <core:when  test="${statusFui==1}">
                                        <span class="glyphicon glyphicon-ok pull-right"></span>
                                    </core:when>    
                                    <core:when  test="${statusFui==2}">
                                        <span class="glyphicon glyphicon-remove pull-right"></span>
                                    </core:when> 
                                    <core:when  test="${statusFui==3}">
                                        <span class="glyphicon glyphicon-time pull-right"></span>
                                    </core:when>
                                </core:choose>   
                            </a>
                    </li>
                    <li  class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeReportesBimestrales}" title="Reportes Bimestrales">
                        <core:choose>
                            <core:when test="${accesoReportesBimestrales}">
                                <a class="list-group-item" href="formatoReporteBimestral.do">Reportes Bimestrales
                                </core:when>
                                <core:otherwise>
                                    <a class="list-group-item" href="#">Reportes Bimestrales
                                    </core:otherwise>
                                </core:choose>  
                                <core:choose>
                                    <core:when  test="${statusReporteBimestrales==1}">
                                        <span class="glyphicon glyphicon-ok pull-right"></span>
                                    </core:when>    
                                    <core:when  test="${statusReporteBimestrales==2}">
                                        <span class="glyphicon glyphicon-remove pull-right"></span>
                                    </core:when> 
                                    <core:when  test="${statusReporteBimestrales==3}">
                                        <span class="glyphicon glyphicon-time pull-right"></span>
                                    </core:when>
                                </core:choose> 
                            </a> </li>
                    <li class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeDocumentosFinales}" title="Documentos Finales">
                        <core:choose>
                            <core:when test="${accesoDocumentosFinales}">
                                <a class="b list-group-item" href="documentosFinalesAlumno.do">Documentos Finales
                                </core:when>
                                <core:otherwise>
                                    <a class="b list-group-item" href="#">Documentos Finales
                                    </core:otherwise>
                                </core:choose>
                                <core:choose>
                                    <core:when  test="${statusDocumentosFinales==1}">
                                        <span class="glyphicon glyphicon-ok pull-right"></span>
                                    </core:when>    
                                    <core:when  test="${statusDocumentosFinales==2}">
                                        <span class="glyphicon glyphicon-remove pull-right"></span>
                                    </core:when> 
                                    <core:when  test="${statusDocumentosFinales==3}">
                                        <span class="glyphicon glyphicon-time pull-right"></span>
                                    </core:when>
                                    <core:when  test="${statusDocumentosFinales==4}">
                                        <span class="glyphicon glyphicon-ok pull-right"></span>
                                        <span class="glyphicon glyphicon-time pull-right"></span>
                                    </core:when>
                                </core:choose> 
                            </a>
                    </li>
                    <li class="filas" data-toggle="popover" data-placement="right" data-content="${mensajeSanciones}" title="Sanciones">
                        <a class="list-group-item" href="#">Sanciones 
                            <core:choose>
                                <core:when test="${tieneSancion}">
                                    <span class="glyphicon glyphicon-remove pull-right"></span>
                                </core:when>
                                <core:otherwise>
                                    <span class="glyphicon glyphicon-ok pull-right"></span>
                                </core:otherwise>
                            </core:choose></a></li>
                </ul>   
            </div>
            <br>
            <p class="alert alert-info informativo">Es importante que recuerdes que a pesar de que el proceso es digital, debes conservar todos tus documentos y formatos originales,
                ya que deben ser entregados f�sicamente al final de tu proceso de Servicio Social.<p>  
        </div>
        <div class="col-md-9" role="main">
