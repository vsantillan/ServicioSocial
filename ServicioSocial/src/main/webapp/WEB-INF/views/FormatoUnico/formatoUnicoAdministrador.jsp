<%-- 
    Document   : demoAdministrador
    Created on : 07-jun-2013, 10:56:10
    Author     : bustedvillain
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                <center><h2>Página del Formato Unico - Administrador</h2></center>
                <div class="tab-content">
                    <ul class="nav nav-tabs" id="formatoUnico-tabla">
                        <li class="active"><a href="#noRevisados" data-toggle="tab">No revisados</a></li>
                        <li><a href="#noAceptados" data-toggle="tab">No aceptados</a></li>
                        <li><a href="#enCorreccion" data-toggle="tab">En correcci&oacute;n</a></li>
                        <li><a href="#aceptados" data-toggle="tab">Aceptados</a></li>
                    </ul>&nbsp;
                    <div id="noRevisados" class="tab-pane active">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="noRevisados_dt" width='100%'>
                            
                            <thead>
                                <tr>
                                    <th>Acci&oacute;nes</th>
                                    <th>Periodo</th>
                                    <th>N. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                
                                <core:forEach items="${listadoFormatoUnicoNORevisados}" var="filaNR">                                   
                                    <tr class='gradeX'>
                                    <td>
                                        <a href="#"> <span class="aceptar glyphicon glyphicon-ok sizeIcon" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}"  title="Aceptar" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" ></span></a>
                                        <a href="#"> <span class="rechazar glyphicon glyphicon-remove sizeIcon" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" title="Rechazar"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" ></span></a>
                                        <a href="#"> <span class="correccion glyphicon glyphicon-edit sizeIcon" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" title="Corrección" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" ></span></a>
                                    </td>
     
                                    <td>${filaNR.periodo}</td>
                                    <td> <core:out value="${filaNR.noControl}"/>  </td>
                                    <td>
                                        <core:out value="${filaNR.nombre}"/>
                                    </td>
                                    <td><a href="mostarPDF.do?id=${filaNR.idDocumentoFormatoUnico}" class="fancyFU"><i class="glyphicon glyphicon-search"></i></a></td>
                                    <td><core:out value="${filaNR.fechaSubida}"/></td>

                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="noAceptados" class="tab-pane">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="noAceptados_dt" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>No. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Motivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listadoFormatoUnicoRechazados}" var="filaRech">
                                    <tr class='gradeX'>
                                        <td>${filaRech.periodo}</td>
                                        <td> <core:out value="${filaRech.noControl}"/>  </td>
                                        <td><core:out value="${filaRech.nombre}"/></td>
                                        <td><a href="mostarPDF.do?id=${filaRech.idDocumentoFormatoUnico}" class="fancyFU"><i class="glyphicon glyphicon-search"></i></a></td>
                                        <td><core:out value="${filaRech.fechaSubida}"/></td>
                                        <td>
                                            <a href="mostarObservacion.do?idDatosPersonales=${filaRech.idDatosPersonales}" class="fancy"><i class="glyphicon glyphicon-list"></i>  Detalles</a>
                                        </td>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>    
                    <div id="enCorreccion" class="tab-pane">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="enCorreccion_dt" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>No. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Motivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listadoFormatoUnicoCorreccion}" var="filaCorrec">
                                    <tr class='gradeX'>
                                        <td>${filaCorrec.periodo}</td>
                                        <td> <core:out value="${filaCorrec.noControl}"/>  </td>
                                        <td><core:out value="${filaCorrec.nombre}"/></td>
                                        <td><a href="mostarPDF.do?id=${filaCorrec.idDocumentoFormatoUnico}" class="fancyFU"><i class="glyphicon glyphicon-search"></i></a></td>
                                        <td><core:out value="${filaCorrec.fechaSubida}"/></td>
                                        <td>
                                            <a href="mostarObservacion.do?idDatosPersonales=${filaCorrec.idDatosPersonales}" class="fancyFUI"><i class="glyphicon glyphicon-list"></i>  Detalles</a>
                                        </td>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>    
                    <div id="aceptados" class="tab-pane">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="aceptados_dt" width='100%'>
                            <thead>
                                <tr>
                                    <th>Periodo</th>
                                    <th>No. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                </tr>
                            </thead>
                            <tbody>
                               <core:forEach items="${listadoFormatoUnicoAceptados}" var="filaA">
                                    <tr class='gradeX'>
                                    <td>${filaA.periodo}</td>
                                    <td> <core:out value="${filaA.noControl}"/>  </td>
                                    <td><core:out value="${filaA.nombre}"/></td>
                                    <td><a href="mostarPDF.do?id=${filaA.idDocumentoFormatoUnico}" class="fancyFU"><i class="glyphicon glyphicon-search"></i></a></td>
                                    <td><core:out value="${filaA.fechaSubida}"/></td>
                                   
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>    
                </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%-- fin del contenido --%>     
             
        <div class="modal-dialog" id="motivos" style="display: none;">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title titulos-naranja">Motivos de Rechazo del Formato Único</h3>
            </div>
            <form id="observacionesCat" action="#"  onsubmit="return  false;">
            <div class="modal-body">
              <div class="list-group">
              <core:forEach items="${listadoObservaciones}" var="observacion">
              <a href="#" class="list-group-item">
                  <div class="checkbox">
                      <label>
                      <input name="id[]" value="${observacion.id}" type="checkbox"/>
                      <h4 class="list-group-item-heading">${observacion.detalle}</h4>
                      </label>
                  </div>
              </a>
              </core:forEach>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal" onClick="$.fancybox.close();">Cancelar</button>
              <a href="javascript:void(0)" onclick="redirecciona('catalogoObservaciones.do');" class="btn btn-danger" role="button">Agregar Observación</a>
              <button id="guardarObservaciones" type="button" class="btn btn-primary">Guardar las observaciones de el Formato Único</button>
            </div>
            </form>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->

        
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
        <script type="text/javascript">
            $('#formatoUnico-tabla a:first').tab('show');
        </script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>


        