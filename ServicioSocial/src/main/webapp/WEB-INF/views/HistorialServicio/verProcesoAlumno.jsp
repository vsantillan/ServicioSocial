<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="row">
                             <%@include file="../General/banner.jsp"%>  
                             <br>
                    <div class="help-block text-center"><h1 class=""><span class="glyphicon glyphicon-list"></span>&nbsp; Proceso del Servicio Social</h1></div>
                    <br>
                    <div class="col-md-10 col-md-offset-1">
                        <div class="panel panel-primary">
                            <div class="panel-heading"><h3>Inforaci&oacute;n del Proceso</h3></div>
                            <div class="panel-primary">
                                <table class="table table-striped">
                                    <tbody>
                                        <!--Carta de motivos-->
                                        <tr>
                                            <th>Tipo de Alumno:</th>
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
                                                    <th>CARTA DE MOTIVOS:</th>
                                                    <td>
                                                        <core:choose>
                                                            <core:when  test="${statusCartaMotivos==1}">
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                            </core:when>    
                                                            <core:when  test="${statusCartaMotivos==2}">
                                                                <span class="glyphicon glyphicon-remove sizeIcon"></span>
                                                            </core:when> 
                                                            <core:when  test="${statusCartaMotivos==3}">
                                                                <span class="glyphicon glyphicon-time sizeIcon"></span>
                                                            </core:when>
                                                        </core:choose> 
                                                        ${mensajeCartaMotivos}
                                                    </td>
                                                </tr>
                                            </core:when>    

                                            <core:when  test="${tipoPanel ==0 || tipoPanel == 2}">
                                                <tr>
                                                    <th>PL&Aacute;TICA:</th>
                                                    <td>
                                                        <core:choose>
                                                            <core:when  test="${platica}">
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                            </core:when>                            
                                                            <core:otherwise>
                                                                <span class="glyphicon glyphicon-remove sizeIcon"></span>
                                                            </core:otherwise>
                                                        </core:choose>
                                                        ${mensajePlatica}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>FORMATO UNICO:</th>
                                                    <td>
                                                        <core:choose>
                                                            <core:when  test="${statusFui==1}">
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                            </core:when>    
                                                            <core:when  test="${statusFui==2}">
                                                                <span class="glyphicon glyphicon-remove sizeIcon"></span>
                                                            </core:when> 
                                                            <core:when  test="${statusFui==3}">
                                                                <span class="glyphicon glyphicon-time sizeIcon"></span>
                                                            </core:when>
                                                        </core:choose>  
                                                        ${mensajeFormatoUnico}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>REPORTES BIMESTRALES:</th>
                                                    <td>
                                                        <core:choose>
                                                            <core:when  test="${statusReporteBimestrales==1}">
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                            </core:when>    
                                                            <core:when  test="${statusReporteBimestrales==2}">
                                                                <span class="glyphicon glyphicon-remove sizeIcon"></span>
                                                            </core:when> 
                                                            <core:when  test="${statusReporteBimestrales==3}">
                                                                <span class="glyphicon glyphicon-time sizeIcon"></span>
                                                            </core:when>
                                                        </core:choose> 
                                                        ${mensajeReportesBimestrales}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>DOCUMENTOS FINALES:</th>
                                                    <td>
                                                        <core:choose>
                                                            <core:when  test="${statusDocumentosFinales==1}">
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                            </core:when>    
                                                            <core:when  test="${statusDocumentosFinales==2}">
                                                                <span class="glyphicon glyphicon-remove sizeIcon"></span>
                                                            </core:when> 
                                                            <core:when  test="${statusDocumentosFinales==3}">
                                                                <span class="glyphicon glyphicon-time sizeIcon"></span>
                                                            </core:when>
                                                            <core:when  test="${statusDocumentosFinales==4}">
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                                <span class="glyphicon glyphicon-time sizeIcon"></span>
                                                            </core:when>
                                                        </core:choose> 
                                                        ${mensajeDocumentosFinales}        
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th>SANCIONES:</th>
                                                    <td>
                                                        <core:choose>
                                                            <core:when test="${tieneSancion}">
                                                                <span class="glyphicon glyphicon-remove sizeIcon"></span>
                                                            </core:when>
                                                            <core:otherwise>
                                                                <span class="glyphicon glyphicon-ok sizeIcon"></span>
                                                            </core:otherwise>
                                                        </core:choose>
                                                        ${mensajeSanciones}
                                                    </td>
                                                </tr> 
                                            </core:when> 
                                        </core:choose> 
                                        <tr>
                                            <th>Desgloce de Sanciones:</th>
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
                                            <th>Desgloce de Observaciones:</th>
                                            <td>
                                                <ul class="scrollDivInferior">
                                                    <core:forEach items="${observaciones}" var="observacion">
                                                        <li class="error"><b>${observacion.fecha}</b>: ${observacion.catalogoObservacionId.detalle}</li>
                                                            </core:forEach>
                                                </ul>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Historial de Servicio Social:</th>
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
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%>   
            </div>
            <%@include file="../General/js.jsp"%>
        </div>
    </body>
</html>

