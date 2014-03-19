<%-- 
    Document   : administrarOrganizaciones
    Created on : 4/06/2013, 02:17:52 PM
    Author     : roy
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
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-eye-open"></span>&nbsp; Validar Organizaciones</h1></div>
                    <div class="alert alert-warning col-md-9  col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran las organizaciones pendientes por validar.</h4></div>
                    </div>
                    <div id="div-validar-organizacion" style="display:none;">
                        <center>
                            <span class="glyphicon glyphicon-ok-circle sizeIconValid"></span>
                            <h2>Organizaci&oacute;n validada correctamente</h2>
                        </center>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="example" width='100%'>
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Detalle</th>
                                <th>Organizaci&oacute;n</th>
                                <th>Titular</th>
                                <th>RFC</th>
                                <th>Tipo de Organizaci&oacute;n</th>                        
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${organizacion}" var="current">
                                <core:choose>
                                    <core:when test="${current.estatus==1}">
                                        <tr class='gradeX'>
                                            <td><a href="#" ><span class="editOrg glyphicon glyphicon-ok sizeIcon" ide="${current.idInstancia}" ></span></a>&nbsp;&nbsp;
                                                <a href="#" class="mandaObservacionesInstancia" nombre="${current.nombre}" correo="${current.correo}" idO="${current.idInstancia}" ><span class="glyphicon glyphicon-remove sizeIcon"></span></a>
                                            </td>
                                            <td><a href="detalleOrganizacion.do?id=${current.idInstancia}" class="fancy" ><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>
                                            <td><core:out value="${current.nombre}" /></td>
                                            <td><core:out value="${current.titular}" /></td>
                                            <td><core:out value="${current.rfc}" /></td>
                                            <td><core:out value="${current.tipoOrganizacion.detalle}" /></td>
                                        </tr>
                                    </core:when>
                                </core:choose>
                            </core:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../General/footer.jsp"%>
            </div>
        </div>

        <div class="modal-dialog" id="motivos" style="display: none;">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title titulos-naranja">Motivos de Rechazo de la Organización</h3>
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
        <script type="text/javascript" language="javascript" src="js/actualizaOrganizaciones.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
