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
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-edit"></span>&nbsp; Administrar Organizaciones</h1></div>
                    <div class="alert alert-warning col-md-9  col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran las organizaciones dadas de alta en el sistema.</h4></div>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'>
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Detalle</th> 
                                <th>Organizaci&oacute;n</th>
                                <th>RFC</th>
                                <th>Tipo de Instancia</th>                                            
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${organizaciones}" var="current">
                                <tr class='gradeX'>
                                    <!--onclick="if(!confirm('¿Está seguro?'))history.go(0);return' ' ;" -->
                                    <td><a href="editarOrganizacion.do?id=${current.idInstancia}" ><span class="glyphicon glyphicon-edit sizeIcon" title="Editar Organizaci&oacute;n"></span></a>&nbsp;&nbsp;
                                        <a href="#" class="btn-validar-org"><span class="cambiaStatusInstancia glyphicon glyphicon-trash sizeIcon" ide="${current.idInstancia}" title="Borrar Organización"></span></a></td>
                                    <td><a href="detalleOrganizacion.do?id=${current.idInstancia}" data-modal="modal" class="fancy"><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>
                                    <td><core:out value="${current.nombre}" /></td>
                                    <td><core:out value="${current.rfc}" /></td>
                                    <td><core:out value="${current.tipoOrganizacion.detalle}" /></td>
                                </tr>
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
                        <button id="guardarObservacionesInstancia" type="button" class="btn btn-primary">Eliminar y guardar las observaciones a la Organización</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal" onClick="$.fancybox.close();">Cancelar</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
        
        <%@include file="../General/js.jsp"%>
            <script type="text/javascript" src="js/actualizaOrganizaciones.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
