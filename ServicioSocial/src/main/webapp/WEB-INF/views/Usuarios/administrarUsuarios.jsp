<%-- 
    Document   : administrarUsuarios
    Created on : 3/09/2014, 11:55:07 AM
    Author     : Jorge Muñoz    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-list-alt"></span>Administrar Usuarios</h2></div>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-edit"></span>&nbsp; Administrar Usuarios</h1></div>
                    <div class="alert alert-warning col-md-9  col-md-offset-1">
                        <div class="alert-heading "><h4 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran los usuarios dados de alta en el sistema.</h4></div>
                    </div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'>
                        <thead>
                            <tr>
                                <th>Acci&oacute;n</th>
                                <th>Detalle</th> 
                                <th>Nombre</th>
                                <th>Puesto</th>
                                <th>Email</th>                                            
                                <th>Teléfono</th>                                            
                            </tr>
                        </thead>
                        <tbody>
                            <core:forEach items="${usuarios}" var="current">
                                <tr class='gradeX'>
                                    <!--onclick="if(!confirm('¿Está seguro?'))history.go(0);return' ' ;" -->
                                    <td><a href="editUser.do?id=${current.idUsuarioInstancia}" ><span class="glyphicon glyphicon-edit sizeIcon" title="Editar Usuario"></span></a>&nbsp;&nbsp;
                                        <a href="#" class="btn-validar-org"><span class="cambiaStatusUsuario glyphicon glyphicon-trash sizeIcon" ide="${current.idUsuarioInstancia}" title="Borrar Usuario"></span></a></td>
                                    <td><a href="detalleUsuario.do?id=${current.idUsuarioInstancia}" data-EditUsmodal="modal" class="fancy"><span class=" glyphicon glyphicon-search sizeIcon" title="Detalle Usuario"></span></a></td>
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

        <div class="modal-dialog" id="motivosUsuario" style="display: none;">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title titulos-naranja">Motivos de Rechazo de la Organización</h3>
                </div>
                <form id="observacionesUsuario" action="#"  onsubmit="return  false;">
                    <div class="modal-body">
                        <div class="list-group">
                            <core:forEach items="${listadoObservaciones}" var="observacion">
                                <a href="#" class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input class="imputUsuario" name="id[]" value="${observacion.id}" type="checkbox"/>
                                            <h4 class="list-group-item-heading">${observacion.detalle}</h4>
                                        </label>
                                    </div>
                                </a>
                            </core:forEach>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="guardarObservacionesUsuario btn btn-primary ">Eliminar y guardar las observaciones</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal" onClick="$.fancybox.close();">Cancelar</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->

        <%@include file="../General/js.jsp"%>
        
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
    <script type="text/javascript" src="js/usuariosAdmin.js"></script>
</html>
