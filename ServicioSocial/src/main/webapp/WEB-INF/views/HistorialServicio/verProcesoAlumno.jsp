<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : verProcesoAlumno
    Created on : 17-oct-2013, 10:31:52
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <script src="js/jquery.manolo.js"></script>       
        <title>Ver Proceso del Alumno</title>
        <style>
            .zebra td, .zebra th {
                padding: 10px;
                border-bottom: 1px solid #f2f2f2;    
            }

            .zebra tbody tr:nth-child(even) {
                background: #f5f5f5;
                -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
                -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
                box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
            }

            .zebra th {
                text-align: left;
                text-shadow: 0 1px 0 rgba(255,255,255,.5); 
                border-bottom: 1px solid #ccc;
                background-color: #eee;
                background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#eee));
                background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
                background-image:    -moz-linear-gradient(top, #f5f5f5, #eee);
                background-image:     -ms-linear-gradient(top, #f5f5f5, #eee);
                background-image:      -o-linear-gradient(top, #f5f5f5, #eee); 
                background-image:         linear-gradient(top, #f5f5f5, #eee);
            }

            .zebra th:first-child {
                -moz-border-radius: 6px 0 0 0;
                -webkit-border-radius: 6px 0 0 0;
                border-radius: 6px 0 0 0;  
            }

            .zebra th:last-child {
                -moz-border-radius: 0 6px 0 0;
                -webkit-border-radius: 0 6px 0 0;
                border-radius: 0 6px 0 0;
            }

            .zebra th:only-child{
                -moz-border-radius: 6px 6px 0 0;
                -webkit-border-radius: 6px 6px 0 0;
                border-radius: 6px 6px 0 0;
            }

            .zebra tfoot td {
                border-bottom: 0;
                border-top: 1px solid #fff;
                background-color: #f1f1f1;  
            }

            .zebra tfoot td:first-child {
                -moz-border-radius: 0 0 0 6px;
                -webkit-border-radius: 0 0 0 6px;
                border-radius: 0 0 0 6px;
            }

            .zebra tfoot td:last-child {
                -moz-border-radius: 0 0 6px 0;
                -webkit-border-radius: 0 0 6px 0;
                border-radius: 0 0 6px 0;
            }

            .zebra tfoot td:only-child{
                -moz-border-radius: 0 0 6px 6px;
                -webkit-border-radius: 0 0 6px 6px;
                border-radius: 0 0 6px 6px;
            }

        </style>
    </head>
    <body class="background">
    <center>
        <div class="MyForm" style="width:80%;" id="contenido">

            <h1>Proceso del Servicio Social</h1>        
            <center>
                <table class="zebra">
                    <thead>
                    <th>Proceso</th>
                    <th>Estatus</th>
                    </thead>
                    <tbody>
                        <!--Carta de motivos-->
                        <tr>
                            <td>Tipo de Alumno</td>
                            <td>
                                <core:choose>
                                    <core:when  test="${tipoPanel==0}">
                                        INTERNO
                                    </core:when>
                                    <core:when  test="${tipoPanel==1}">
                                        EXTERNO
                                    </core:when>
                                </core:choose>
                            </td>
                        </tr>
                        <core:choose>
                            <core:when  test="${tipoPanel==1 || tipoPanel == 2}">
                                <tr>
                                    <td>CARTA DE MOTIVOS</td>
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
                                        ${mensajeCartaMotivos}
                                    </td>
                                </tr>
                            </core:when>    

                            <core:when  test="${tipoPanel ==0 || tipoPanel == 2}">
                                <tr>
                                    <td>PL&Aacute;TICA</td>
                                    <td>
                                        <core:choose>
                                            <core:when  test="${platica}">
                                                <img class="imagenes" src="imagenes/paloma.png" width="30"/>
                                            </core:when>                            
                                            <core:otherwise>
                                                <img class="imagenes" src="imagenes/tache.png" width="30"/>
                                            </core:otherwise>
                                        </core:choose>
                                        ${mensajePlatica}
                                    </td>
                                </tr>
                                <tr>
                                    <td>FORMATO UNICO</td>
                                    <td>
                                        <core:choose>
                                            <core:when  test="${statusFui==1}">
                                                <img class="imagenes" src="imagenes/paloma.png" width="30"/>
                                            </core:when>    
                                            <core:when  test="${statusFui==2}">
                                                <img class="imagenes" src="imagenes/tache.png" width="30"/>
                                            </core:when> 
                                            <core:when  test="${statusFui==3}">
                                                <img class="imagenes" src="imagenes/reloj.png" width="30"/>
                                            </core:when>
                                        </core:choose>  
                                        ${mensajeFormatoUnico}
                                    </td>
                                </tr>
                                <tr>
                                    <td>REPORTES BIMESTRALES
                                    <td>
                                        <core:choose>
                                            <core:when  test="${statusReporteBimestrales==1}">
                                                <img class="imagenes" src="imagenes/paloma.png" width="30"/>
                                            </core:when>    
                                            <core:when  test="${statusReporteBimestrales==2}">
                                                <img class="imagenes" src="imagenes/tache.png" width="30"/>
                                            </core:when> 
                                            <core:when  test="${statusReporteBimestrales==3}">
                                                <img class="imagenes" src="imagenes/reloj.png" width="30"/>
                                            </core:when>
                                        </core:choose> 
                                        ${mensajeReportesBimestrales}
                                    </td>
                                </tr>
                                <tr>
                                    <td>DOCUMENTOS FINALES
                                    <td>
                                        <core:choose>
                                            <core:when  test="${statusDocumentosFinales==1}">
                                                <img class="imagenes" src="imagenes/paloma.png" width="30"/>
                                            </core:when>    
                                            <core:when  test="${statusDocumentosFinales==2}">
                                                <img class="imagenes" src="imagenes/tache.png" width="30"/>
                                            </core:when> 
                                            <core:when  test="${statusDocumentosFinales==3}">
                                                <img class="imagenes" src="imagenes/reloj.png" width="30"/>
                                            </core:when>
                                            <core:when  test="${statusDocumentosFinales==4}">
                                                <img class="imagenes" src="imagenes/paloma.png" width="30"/>
                                                <img class="imagenes" src="imagenes/reloj.png" width="30"/>
                                            </core:when>
                                        </core:choose> 
                                        ${mensajeDocumentosFinales}        
                                    </td>
                                </tr>
                                <tr>
                                    <td>SANCIONES</td>
                                    <td>
                                        <core:choose>
                                            <core:when test="${tieneSancion}">
                                                <img class="imagenes" src="imagenes/tache.png" width="30"/>
                                            </core:when>
                                            <core:otherwise>
                                                <img class="imagenes" src="imagenes/paloma.png" width="30"/>
                                            </core:otherwise>
                                        </core:choose>
                                        ${mensajeSanciones}
                                    </td>
                                </tr> 
                            </core:when> 
                        </core:choose> 
                        <tr>
                            <td>Desgloce de Sanciones</td>
                            <td>
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
                            </td>
                        </tr>
                        <tr>
                            <td>Desgloce de Observaciones</td>
                            <td>
                                <ul class="scrollDivInferior">
                                    <core:forEach items="${observaciones}" var="observacion">
                                        <li class="error"><b>${observacion.fecha}</b>: ${observacion.catalogoObservacionId.detalle}</li>
                                            </core:forEach>
                                </ul>
                            </td>
                        </tr>
                        <tr>
                            <td>Historial de Servicio Social</td>
                            <td>
                                <ul class="scrollDivInferior">
                                    <core:forEach items="${historialEventos}" var="evento">
                                        <li class="error"><b>${evento.fecha}</b>: ${evento.detalle}</li>
                                    </core:forEach>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </center>
            <br/>


        </div>
    </center>
</body>
</html>
