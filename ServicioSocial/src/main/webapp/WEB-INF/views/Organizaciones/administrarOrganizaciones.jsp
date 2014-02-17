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
                    <h1>Administrar Organizaciones</h1>
                    <p>A continuaci&oacute;n se muestran las organizaciones dadas de alta en el sistema.</p>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'>
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
                            <core:forEach items="${organizaciones}" var="current">
                                <tr class='gradeX'>
                                    <!--onclick="if(!confirm('¿Está seguro?'))history.go(0);return' ' ;" -->
                                    <td><a href="editarOrganizacion.do?id=${current.idInstancia}" ><span class="glyphicon glyphicon-edit sizeIcon" title="Editar Organizaci&oacute;n"></span></a>&nbsp;&nbsp;
                                        <a href="#" class="btn-validar-org"><span class="cambiaStatusInstancia glyphicon glyphicon-remove sizeIcon" ide="${current.idInstancia}" title="Borrar Organización"></span></a></td>
                                    <td><a href="detalleOrganizacion.do?id=${current.idInstancia}" data-modal="modal" class="fancy"><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>
                                    <td><core:out value="${current.nombre}" /></td>
                                    <td><core:out value="${current.titular}" /></td>
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
        <div class="modal-dialog" id="a" style="display: none;">
          <div class="modal-content">
            <div class="modal-header">
        
                        <h1>Motivos de Rechazo</h1>
                    </div>
                    <div class="modal-body">
                        <form:form commandName="retroalimentacionInstancia"  id="MyForm" method="POST"  action="borrarInstancia.do">
                            <form:input hidden="hidden" type ="text"  id="idI" path="id" name="id" />                   
                            <form:input hidden="hidden" id="control" path="control" value="0" />
                            <div class="form-group">
                                <label>Nombre de la Organizaci&oacute;n:</label>
                                <form:input type ="text"  id="nombre" path="nombre" name="nombre" /> 
                            </div>
                            <div class="form-group">
                                <label>E-Mail:</label>
                                <td><form:input type ="text"  id="correo" path="correo" name="correo" /> 
                            </div>
                            <div class="form-group">
                                <label>Descripci&oacute;n:</label>
                                <form:textarea  id="descripcion" path="descripcion" rows="10" cols="70" name="descripcion" />
                            </div>
                            <div class="form-group">
                                <input type ="submit" value="Enviar Retroalimentaci&oacute;n"  class="enviarRetro btn btn-primary" >
                            </div>
                        </form:form>
                    </div>
                    <div class="modal-footer">Instituto Tecnologico de Toluca</div>
                </div>
            </div>
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" src="js/actualizaOrganizaciones.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
