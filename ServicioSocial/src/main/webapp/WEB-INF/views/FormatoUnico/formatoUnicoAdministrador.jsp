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
        <link href="shadowbox/shadowbox.css" rel="stylesheet" type="text/css" />
        <!--Scripts para shadowbox-->
        <script type="text/javascript" src="shadowbox/shadowbox.js"></script>  
        <script type="text/javascript"> Shadowbox.init({language: "es", players: ['img', 'html', 'iframe', 'qt',
                    'wmp', 'swf', 'flv']});</script> 
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
          
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
                                    <td>Periodo</td>
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Documento</th>
                                    <th>Fecha Subida</th>
                                    <th>Acci&oacute;nes</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <core:forEach items="${listadoFormatoUnicoNORevisados}" var="filaNR">
                                    <tr class='gradeX'>
                                    <td>${filaNR.periodo}</td>
                                    <td> <core:out value="${filaNR.noControl}"/>  </td>
                                    <td>
                                        <core:out value="${filaNR.nombre}"/>
                                    </td>
                                    <td><a href="#a" rel="shadowbox"><img width="30" src="imagenes/lupa.png"/></a></td>
                                    <td><core:out value="${filaNR.fechaSubida}"/></td>
                                    
                                    <td>
                                        <input type="button" value="Aceptar" class="aceptar" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}"/>
                                        <input type="button" value="Rechazar" class="rechazar" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}" />
                                        <input type="button" value="Corrección" class="correccion" idFU="${filaNR.idFormatoUnico}" idDP="${filaNR.idDatosPersonales}"/>
                                    </td>
                                    
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
                                    <td>n. Control</td>
                                    <th>Nombre</th>
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
                                        <td><core:out value="${filaRech.fechaSubida}"/></td>
                                        <td>
                                             <ul>
                                            <core:forEach items="${filaRech.listaObservaciones}" var="observacion">
                                                <li>${observacion}</li>
                                            </core:forEach>
                                            </ul>
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
                                    <td>n. Control</td>
                                    <th>Nombre</th>
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
                                        <td><core:out value="${filaCorrec.fechaSubida}"/></td>
                                        <td>
                                            <ul>
                                            
                                            <core:forEach items="${filaCorrec.listaObservaciones}" var="observacion">
                                                <li>${observacion}</li>
                                            </core:forEach>
                                            
                                            </ul>
                                            
                                            
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
                                    <th>n. Control</th>
                                    <th>Nombre</th>
                                    <th>Fecha Subida</th>
                                </tr>
                            </thead>
                            <tbody>
                               <core:forEach items="${listadoFormatoUnicoAceptados}" var="filaA">
                                    <tr class='gradeX'>
                                    <td>${filaA.periodo}</td>
                                    <td> <core:out value="${filaA.noControl}"/>  </td>
                                    <td><core:out value="${filaA.nombre}"/></td>
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
        
        
        <div id="motivos" style="display: none; font-size: 15px">
                <h1>Motivos de Rechazo</h1>
                <div id="scroll" >
                    <form id="observacionesCat" action="#" onsubmit="return  false;">
                    <table>
                        <core:forEach items="${listadoObservaciones}" var="observacion">
                        <tr>
                            <td style="width: 150px"><label><input name="id[]" value="${observacion.id}" type="checkbox"/>&nbsp;&nbsp;&nbsp;
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


        