<%-- 
    Document   : reporteBimestralAdministrador
    Created on : 5/06/2013, 02:15:04 PM
    Author     : roy
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <script type="text/javascript" language="javascript" src="js/reporteBimestalActualiza.js"></script> 
        <title>Administrar Reportes Bimestrales</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Administraci&oacute;n de Reportes Bimestrales</h1></div>
                    <div class="tab-content">
                        <ul class="nav nav-tabs" id="formatoUnico-tabla">
                            <li class="active"><a href="#Revisados" data-toggle="tab">Revisados</a></li>
                            <li><a href="#noRevisados" data-toggle="tab">No Revisados</a></li>
                            <li><a href="#enCorreccion" data-toggle="tab">En Correcci&oacute;n</a></li>
                            <li><a href="#Rechazados" data-toggle="tab">Rechazados</a></li>
                        </ul>
                        &nbsp;
                        <div class="tab-content">
                            <div id="Revisados" class="tab-pane active col-md-12">
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Rev" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Acci&oacute;n</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas Acumuladas</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <core:forEach items="${reportesRevisados}" var="reporte">
                                                    <tr class='gradeX'>
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                            <core:choose>
                                                                                <core:when test="${documentos.status==1 && documentos.catalogoDocumentosId.id==2}">
                                                                                    <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon" target="_blank"></span></a>
                                                                                    </core:when>
                                                                                </core:choose>
                                                                            </core:forEach>
                                                                        </core:when>
                                                                    </core:choose>
                                                                </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/> <core:out value="${reporte.datosPersonalesId.apellidoP}"/> <core:out value="${reporte.datosPersonalesId.apellidoM}"/></th>
                                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>                                                       
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                            <th><core:out value="${fu.periodoInicio}"/></th>
                                                                            <th><core:out value="${fu.horasAcumuladas}"/></th>
                                                                        </core:forEach>
                                                                    </core:when>
                                                                </core:choose>
                                                            </core:forEach>
                                                    </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div id="noRevisados" class="tab-pane col-md-12">
                                <div id="div-aceptar-reporte" style="display:none;">
                                    <center>
                                        <span class="glyphicon glyphicon-ok-circle sizeIconValid"><span/>
                                        <h2>Reporte validado correctamente</h2>
                                    </center>
                                </div>
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="NoRev" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Acci&oacute;n</th>
                                            <th>Ver detalle</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesNoRevisados}" var="reporte">
                                                    <tr class='gradeX'>
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                            <core:choose>
                                                                                <core:when test="${documentos.status==4 && documentos.catalogoDocumentosId.id==2}">
                                                                                    <a href="#" ><span class="glyphicon glyphicon-ok  sizeIcon aceptarReporte" ide="${reporte.id}" status="${1}" idDoc="${documentos.id}"> </span></a>
                                                                                    <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${reporte.datosPersonalesId.nombre}" correo="${reporte.datosPersonalesId.correoElectronico}" status="${3}" idReporte="${reporte.id}" idDoc="${documentos.id}"><span class="glyphicon glyphicon-edit sizeIcon"></span></a>
                                                                                    <a href="#a" class="fancybox-effects-a mandaRetro" nombre="${reporte.datosPersonalesId.nombre}" correo="${reporte.datosPersonalesId.correoElectronico}" status="${2}" idReporte="${reporte.id}" idDoc="${documentos.id}"><span class="glyphicon glyphicon-remove sizeIcon"></span></a>
                                                                                    </core:when>
                                                                                </core:choose>
                                                                            </core:forEach>
                                                                        </core:when>
                                                                    </core:choose>
                                                                </core:forEach>
                                                        </th>
                <!--                                                <th><a href="detalleReporteBimestral.do?id=${reporte.id}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></th>-->
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                            <core:choose>
                                                                                <core:when test="${documentos.status==4 && documentos.catalogoDocumentosId.id==2}">
                                                                                    <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU" target="_blank"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                                                    </core:when>
                                                                                </core:choose>
                                                                            </core:forEach>
                                                                        </core:when>
                                                                    </core:choose>
                                                                </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/> <core:out value="${reporte.datosPersonalesId.apellidoP}"/> <core:out value="${reporte.datosPersonalesId.apellidoM}"/></th>
                                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                            <core:out value="${fu.periodoInicio}"/>
                                                                        </core:forEach>
                                                                    </core:when>
                                                                </core:choose>
                                                            </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.horas}"/></th>
                                                    </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div> 
                            <div id="enCorreccion" class="tab-pane col-md-12">
                                <table ccellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Correccion" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Documento</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas del Reporte</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesEnCorreccion}" var="reporte">
                                                    <tr class='gradeX'>
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                            <core:choose>
                                                                                <core:when test="${documentos.status==3 && documentos.catalogoDocumentosId.id==2}">
                                                                                    <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                                                                    </core:when>
                                                                                </core:choose>
                                                                            </core:forEach>
                                                                        </core:when>
                                                                    </core:choose>
                                                                </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/></th>
                                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                            <core:out value="${fu.periodoInicio}"/>
                                                                        </core:forEach>
                                                                    </core:when>
                                                                </core:choose>
                                                            </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.horas}"/></th>
                                                    </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div id="Rechazados" class="tab-pane col-md-12">
                                <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Recha" width='100%'>
                                    <thead>
                                        <tr>
                                            <th>Documento</th>
                                            <th>Nombre</th>
                                            <th>N. Control</th>
                                            <th>Periodo</th>
                                            <th>Horas del Reporte</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <core:forEach items="${reportesRechazados}" var="reporte">
                                                    <tr class='gradeX'>
                                                        <!--<th><a href="mostarPDF.do?id=${2}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></th>
                                                            <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>-->                                                
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.documentosCollection}" var="documentos">
                                                                            <core:choose>
                                                                                <core:when test="${documentos.status==2 && documentos.catalogoDocumentosId.id==2}">
                                                                                    <a href="mostarPDF.do?id=${documentos.id}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a>
                                                                                    </core:when>
                                                                                </core:choose>
                                                                            </core:forEach>
                                                                        </core:when>
                                                                    </core:choose>
                                                                </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.datosPersonalesId.nombre}"/></th>
                                                        <th><core:out value="${reporte.datosPersonalesId.alumnoId.id}"/></th>
                                                        <th>
                                                            <core:forEach items="${datosPersonales}" var="datoPersonal">
                                                                <core:choose>
                                                                    <core:when test="${reporte.datosPersonalesId.id==datoPersonal.id}">
                                                                        <core:forEach items="${datoPersonal.formatoUnicoCollection}" var="fu">
                                                                            <core:out value="${fu.periodoInicio}"/>
                                                                        </core:forEach>
                                                                    </core:when>
                                                                </core:choose>
                                                            </core:forEach>
                                                        </th>
                                                        <th><core:out value="${reporte.horas}"/></th>
                                                    </tr>
                                        </core:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <div id="a" style="display: none; font-size: 15px">
            <form:form commandName="retroalimentacionReporte"  id="MyForm" method="POST"  action="actualizarStatusReporte.do">
                <h1>Envio de Retroalimentaci&oacute;n</h1>
                <h2>Motivos de Rechazo</h2>
                <table >
                    <tr>
                        <td>Nombre de la Organizaci&oacute;n:
                            <form:hidden id="status" nombre="status" path="status" size="20"/><br/>
                            <form:hidden id="idReporte" path="idReporte" name="idReporte" size="20"/><br/>
                            <form:hidden id="idDoc" path="idDoc" name="idDoc" size="20"/>
                        </td>
                        <td><form:input type ="text"  id="nombre" path="nombre" name="nombre" disabled="true" /> </td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><form:input type ="text"  id="correo" path="correo" name="correo" disabled="true" /> </td>
                    </tr>
                    <tr>
                        <td>Descripci&oacute;n:</td>
                        <td><form:textarea  id="descripcion" path="descripcion" rows="10" cols="70" name="descripcion" cssClass="d"/><br/>
                            <label id="errorDescripcion" style="display: none" class="error">La descripción no debe ser vacía</label>
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td><input type ="submit" value="Enviar Retroalimentaci&oacute;n" class="enviarRetroalimentacion"> </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <%@include file="../General/js.jsp"%>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
