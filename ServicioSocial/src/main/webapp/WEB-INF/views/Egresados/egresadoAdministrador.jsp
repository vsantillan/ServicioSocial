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

                <h1>P&aacute;gina de Egresado - Administrador</h1>
                <div id="tabs">

                    <ul>
                        <li><a href="#noRevisados">No revisados</a></li>
                        <li><a href="#noAceptados">No aceptados</a></li>
                        <li><a href="#enCorreccion">En correcci&oacute;n</a></li>
                        <li><a href="#aceptados">Aceptados</a></li>
                    </ul>
                    <div id="noRevisados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noRevisadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <th>Acci&oacute;nes</th>
<!--                                    <td>Periodo</td>-->
                                    <th>N. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>

                                </tr>
                            </thead>
                            <tbody>

                                <core:forEach items="${listadoCartasNoRevisadas}" var="filaNR">                                   
                                    <tr class='gradeX'>
                                        <td>
                                            <a href="#"> <img class="aceptar" idCa="${filaNR.idEgresado}" idDP="${filaNR.idDatosPersonales}"  title="Aceptar" width="30" height="30"  idCa="${filaNR.idEgresado}" idDP="${filaNR.idDatosPersonales}" src="imagenes/paloma.png" /></a>
                                            <a href="#"> <img class="rechazar" idCa="${filaNR.idEgresado}" idDP="${filaNR.idDatosPersonales}" title="Rechazar" width="30" height="30"  idCa="${filaNR.idEgresado}" idDP="${filaNR.idDatosPersonales}" src="imagenes/tache.png" /></a>
                                            <a href="#"> <img class="correccion" idCa="${filaNR.idEgresado}" idDP="${filaNR.idDatosPersonales}" title="Corrección" width="30" height="30"  idCa="${filaNR.idEgresado}" idDP="${filaNR.idDatosPersonales}" src="imagenes/editar.png" /></a>
                                        </td>

<!--                                        <td>${filaNR.periodo}</td>-->
                                        <td> <core:out value="${filaNR.noControl}"/>  </td>
                                        <td>
                                            <core:out value="${filaNR.nombre}"/>
                                        </td>
                                        <td><a href="mostarPDF.do?id=${filaNR.idDocumentoCartaMotivos}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
                                        <td><core:out value="${filaNR.fechaSubida}"/></td>

                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="noAceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="noAceptadosDT" width='100%'>
                            <thead>
                                <tr>
<!--                                    <th>Periodo</th>-->
                                    <td>No. Control</td>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Motivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listadoCartasRechazadas}" var="filaRech">
                                    <tr class='gradeX'>
                                        <!--<td>${filaRech.periodo}</td>-->
                                        <td> <core:out value="${filaRech.noControl}"/>  </td>
                                        <td><core:out value="${filaRech.nombre}"/></td>
                                        <td><a href="mostarPDF.do?id=${filaRech.idDocumentoCartaMotivos}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
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
                    <div id="enCorreccion">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="enCorreccionDT" width='100%'>
                            <thead>
                                <tr>
                                    <!--<th>Periodo</th>-->
                                    <td>No. Control</td>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Motivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listadoCartasCorreccion}" var="filaCorrec">
                                    <tr class='gradeX'>
                                        <!--<td>${filaCorrec.periodo}</td>-->
                                        <td> <core:out value="${filaCorrec.noControl}"/>  </td>
                                        <td><core:out value="${filaCorrec.nombre}"/></td>
                                        <td><a href="mostarPDF.do?id=${filaCorrec.idDocumentoCartaMotivos}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
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
                    <div id="aceptados">
                        <table cellpadding='0' cellspacing='0' border='0' class='display' id="aceptadosDT" width='100%'>
                            <thead>
                                <tr>
                                    <!--<th>Periodo</th>-->
                                    <th>No. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listadoCartasAceptadas}" var="filaA">
                                    <tr class='gradeX'>
                                        <!--<td>${filaA.periodo}</td>-->
                                        <td> <core:out value="${filaA.noControl}"/>  </td>
                                        <td><core:out value="${filaA.nombre}"/></td>
                                        <td><a href="mostarPDF.do?id=${filaA.idDocumentoCartaMotivos}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
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
        <script type="text/javascript" src="js/egresadoAdmin.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>

