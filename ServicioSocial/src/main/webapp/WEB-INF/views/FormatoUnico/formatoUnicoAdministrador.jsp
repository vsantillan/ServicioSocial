<%-- 
    Document   : demoAdministrador
    Created on : 07-jun-2013, 10:56:10
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
        
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        
        <jsp:include page="../Template/headsModal.jsp" />
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
          <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />
        
        <title>Administrador</title>
        
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width:80%;">
                
                <h1>P&aacute;gina del Formato Unico - Administrador</h1>
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
                                        <a href="#"> <img class="aceptar" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}"  title="Aceptar" width="30" height="30"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" src="imagenes/paloma.png" /></a>
                                        <a href="#"> <img class="rechazar" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" title="Rechazar" width="30" height="30"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" src="imagenes/tache.png" /></a>
                                        <a href="#"> <img class="correccion" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" title="Corrección" width="30" height="30"  idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" src="imagenes/corregir.jpg" /></a>
                                    </td>
     
                                    <td>${filaNR.periodo}</td>
                                    <td> <core:out value="${filaNR.noControl}"/>  </td>
                                    <td>
                                        <core:out value="${filaNR.nombre}"/>
                                    </td>
                                    <td><a href="mostarPDF.do?id=${filaNR.idDocumentoFormatoUnico}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
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
                                        <td><a href="mostarPDF.do?id=${filaRech.idDocumentoFormatoUnico}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
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
                                        <td><a href="mostarPDF.do?id=${filaCorrec.idDocumentoFormatoUnico}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
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
                                    <td><a href="mostarPDF.do?id=${filaA.idDocumentoFormatoUnico}" class="fancyFU"><img width="30" src="imagenes/lupa.png"/></a></td>
                                    <td><core:out value="${filaA.fechaSubida}"/></td>
                                   
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>    
                </div>
                
            </div>
            
            
            <div style="clear:both;"></div>
            
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
        
        
        <div id="motivos" style="display: none; ">
                <h1>Motivos de Rechazo</h1>
                <div id="scroll" >
                    <form id="observacionesCat" action="#" onsubmit="return  false;">
                    <table>
                        <core:forEach items="${listadoObservaciones}" var="observacion">
                        <tr>
                            <td style="width: 450px;font-size: 20px"><label><input name="id[]" value="${observacion.id}" type="checkbox"/>&nbsp;&nbsp;&nbsp;
                             <core:out value="${observacion.detalle}" /></label>
                            </td>
                        </tr> 
                    </core:forEach>
                   </table>
                    </form>
                </div>
                    <button id="guardarObservaciones">Guardar</button>
            </div>
        
        <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
    </body>
</html>


        