<%@include file="../General/jstl.jsp"%>

<html>
    <head>
        <%@ include file="../Template/sinJavascript.jsp" %>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="row col-md-12 center-block">
                    <table class="table">
                        <tr>
                            <td colspan="2">
                                <h2 class="text-info">Detalle de Proyectos</h2>
                            </td>
                        </tr>
                        <tr>
                            <th><p>Nombre del Proyecto:</p></th>
                        <td><p>${proyectoDetalle.nombre}</p></td>
                        </tr>
                        <tr>
                            <th><p>Número de vacantes:</p></th>
                        <td><p><core:out value="${proyectoDetalle.vacantes}" /></p></td>
                        </tr> 
                        <tr>
                            <th><p>Número de vacantes disponibles:</p></th>
                        <td><p><core:out value="${proyectoDetalle.vacantesDisponibles}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Instancia:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idInstancia.nombre}"/></p></td>
                        </tr>                
                        <tr>
                            <th><p>Titular de la Instancia:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idInstancia.usuarioInstancia.nombre} ${proyectoDetalle.idInstancia.usuarioInstancia.apellidoPat}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Puesto del Titular del proyecto:</p></th>
                        <td><p><core:out value="${proyectoDetalle.responsablePuesto}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Teléfono de la Instancia:</p></th>
                        <td><p><core:out value="${proyectoDetalle.telefonoResponsable}"/> EXT:<core:out value="${proyectoDetalle.telefonoResponsable}"/> </p></td>
                        </tr>
                        <tr>
                            <th><p>Domicilio de la Instancia:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idInstancia.domicilio}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Código Postal del proyecto:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idInstancia.idColonia.idCp.cp}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Colonia de la Instancia:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idInstancia.idColonia.nombre}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Actividades:</p></th>
                        <td><p>                        
                                <core:choose>
                                    <core:when test="${empty proyectoDetalle.actividadesCollection}">
                                    <p>No hay actividades</p>
                                </core:when>
                                <core:otherwise>
                                    <core:forEach items="${proyectoDetalle.actividadesCollection}" var="actividades">
                                        <core:choose>
                                            <core:when test="${actividades.estatus==1}">
                                                <p>${actividades.detalle}</p>
                                            </core:when>
                                        </core:choose>
                                    </core:forEach>
                                </core:otherwise>
                            </core:choose>                                                          
                            </p>
                        </td>
                        </tr>
                        <tr>
                            <th><p>Responsable del Programa:</p></th>
                        <td><p><core:out value="${proyectoDetalle.nombreResponsable}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Puesto del Responsable:</p></th>
                        <td><p><core:out value="${proyectoDetalle.responsablePuesto}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Teléfono del Responsable:</p></th>
                        <td><p><core:out value="${proyectoDetalle.telefonoResponsable}"/> EXT:<core:out value="${proyectoDetalle.ext}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Domicilio del programa:</p></th>
                        <td><p><core:out value="${proyectoDetalle.domicilio}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Código Postal del programa:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idColonia.idCp.cp}"/></p></td>
                        </tr>
                        <tr>
                            <th><p>Colonia del programa:</p></th>
                        <td><p><core:out value="${proyectoDetalle.idColonia.nombre}"/></p></td>
                        </tr>                
                        <tr>
                            <th><p>Tipo de Proyecto</p></th>
                        <td><p><core:out value="${proyectoDetalle.idTipoProyecto.descripcion}" /></p></td>
                        </tr>
                        <tr>
                            <th><p>Perfil buscado:</p></th>
                        <td><p>
                                <core:choose>
                                    <core:when test="${empty proyectoDetalle.proyectoPerfilCollection}">
                                    <p>Ninguno</p>
                                </core:when>
                                <core:otherwise>
                                    <core:forEach items="${proyectoDetalle.proyectoPerfilCollection}" var="perfiles">
                                        <ul>
                                            <li>  <p>Perfil: ${perfiles.idPerfil.nombre}</p></li>
                                        </ul>
                                    </core:forEach>
                                </core:otherwise>
                            </core:choose>
                            </p>
                        </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
    </body>
</html>