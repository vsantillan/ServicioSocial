<%-- 
    Document   : validarUsuarios
    Created on : 5/09/2014, 02:36:57 PM
    Author     : Jorge Muñoz
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
                    <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-edit"></span>&nbsp; Administrar Usuarios</h2></div>
                    <div class="alert alert-warning col-md-9  col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran los usuarios dados de alta en el sistema.</h4></div>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class="table table-striped table-bordered example">
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Detalle</th> 
                                <th>Nombre</th>
                                <th>Puesto</th>
                                <th>Email</th>                                            
                                <th>Telefono</th>                                            
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${usuarios}" var="current">
                                <tr class='gradeX'>
                                    <!--onclick="if(!confirm('¿Está seguro?'))history.go(0);return' ' ;" -->
                                    <td><a href="#" ><span class="editUser glyphicon glyphicon-ok sizeIcon" ide="${current.idUsuarioInstancia}"></span></a>&nbsp;&nbsp;
                                    </td>
                                    <td><a href="#" class="fancy" ><span class="glyphicon glyphicon-search sizeIcon" ide=""></span></a></td>
                                    <td><core:out value="${current.nombre}" /></td>
                                    <td><core:out value="${current.puesto}" /></td>
                                    <td><core:out value="${current.email}" /></td>
                                    <td><core:out value="${current.telefono}" /></td>
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
        <script type="text/javascript" src="js/usuariosAdmin.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
