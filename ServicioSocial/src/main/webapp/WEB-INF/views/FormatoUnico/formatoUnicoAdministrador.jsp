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
                        <li><a href="#noRevisados" data-toggle="tab">No revisados</a></li>
                        <li><a href="#noAceptados" data-toggle="tab">No aceptados</a></li>
                        <li><a href="#enCorreccion" data-toggle="tab">En correcci&oacute;n</a></li>
                        <li><a href="#aceptados" data-toggle="tab">Aceptados</a></li>
                    </ul>
                    <div id="noRevisados" class="tab-pane">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="noRevisados_dt" width='100%'>
                            
                            <thead>
                                <tr>
                                    <th>Acci&oacute;nes</th>
                                    <td>Periodo</td>
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
                                        <a href="#"> <span class="aceptar glyphicon glyphicon-ok sizeIcon" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}"  title="Aceptar" width="30" height="30"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" ></span></a>
                                        <a href="#"> <span class="rechazar glyphicon glyphicon-remove sizeIcon" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" title="Rechazar" width="30" height="30"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" ></span></a>
                                        <a href="#"> <span class="correccion glyphicon glyphicon-edit sizeIcon" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" title="Corrección" width="30" height="30"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" ></span></a>
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
                                    <td>No. Control</td>
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
                                            <%/*
                                             * <core:forEach items="${filaRech.listaObservaciones}" var="observacion">
                                                <li>${observacion}</li>
                                            </core:forEach>
                                            */%>
                                            <a href="mostarObservacion.do?idDatosPersonales=${filaRech.idDatosPersonales}" class="fancy">Detalles</a>
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
                                    <td>No. Control</td>
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
                                            <%/*
                                             * <ul>
                                            <core:forEach items="${filaCorrec.listaObservaciones}" var="observacion">
                                                <li>${observacion}</li>
                                            </core:forEach>
                                            </ul>
                                            */%>
                                            
                                            <a href="mostarObservacion.do?idDatosPersonales=${filaCorrec.idDatosPersonales}" class="fancy">Detalles</a>
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
        
        <div id="motivos" style="display: none; ">
             <form id="observacionesCat" action="#"  onsubmit="return  false;">
            <div style="height: 350px; overflow: scroll" >
                <h1>Motivos de Rechazo</h1>
                    <table>
                        <core:forEach items="${listadoObservaciones}" var="observacion">
                        <tr>
                            <td style="width: 450px;font-size: 20px"><label><input name="id[]" value="${observacion.id}" type="checkbox"/>&nbsp;&nbsp;&nbsp;
                             <core:out value="${observacion.detalle}" /></label>
                            </td>
                        </tr> 
                    </core:forEach>
                   </table>
                </div>
                 <div>
                      <button id="guardarObservaciones">Guardar</button>
                      &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="redirecciona('catalogoObservaciones.do')"   style="font-size: 20px"> Agregar Observación</a>
                 </div>
                 </form>  
            </div>
        
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
        <script type="text/javascript">
            $('#formatoUnico-tabla a:first').tab('show');
        </script>
    </body>
</html>


        