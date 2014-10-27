<%-- 
    Document   : catalogoObservaciones
    Created on : 5/08/2013, 11:50:44 AM
    Author     : rodrigo
--%>


<%@include file="../General/jstl.jsp"%>


<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Administraci&oacute;n de Observaciones</title>
    </head>
    <body class="background">
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%> 

                <div class="row">
                    <div class="col-md-12 center-block">
                        <br/>
                        <center><h1>Observaciones</h1></center>
                        <div id="tabs">
                            <ul class="nav nav-tabs" id="formatoUnico-tabla">
                                <li class="active"><a href="#nuevaObservacion" data-toggle="tab">Nueva Observaci&oacute;n</a></li>
                                <li><a href="#catalogoObservaciones" data-toggle="tab">Cat&aacute;logo de Observaciones</a></li>
                            </ul>
                            &nbsp;
                            <div class="tab-content">
                                <div id="catalogoObservaciones" class="tab-pane">
                                    <p>A continuaci&oacute;n se muestra el catalogo de observaciones.</p>
                                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="example" width='100%'>
                                        <thead>
                                            <tr>
                                                <th>Acci&oacute;n</th>
                                                <th>No. Desccripci&oacute;n</th>
                                                <th>Descripci&oacute;n</th>
                                                <th>Tipo</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <core:forEach items="${Observaciones}" var="current">
                                                <tr class='gradeX'>
                                                    <td>
                                                        <a href="#editarOrganizacion" data-toggle="modal" class="fancybox-effects-a  actualizaObservacion" detalle="${current.detalle}" idO="${current.id}"><span class="glyphicon glyphicon-edit sizeIcon"></span></a>
                                                        <a href="#" class="borrarObservacion"><span class="glyphicon glyphicon-trash sizeIcon" idex="${current.id}"></span></a>
                                                    </td>
                                                    <td><core:out value="${current.id}" /></td>
                                                    <td><core:out value="${current.detalle}" /></td>
                                                    <td><core:choose>
                                                            <core:when test="${current.tipo == 1}">
                                                                Formato Unico.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 2}">
                                                                Reportes Bimestrales.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 3}">
                                                                Documentos Finales.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 4}">
                                                                Organizaciones.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 5}">
                                                                Proyectos.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 6}">
                                                                Usuarios.
                                                            </core:when>
                                                            <core:otherwise>
                                                                Tipo Desconocido.
                                                            </core:otherwise>
                                                        </core:choose></th>
                                                </td>
                                            </core:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div id="nuevaObservacion" class="tab-pane active">
                                    <div class="col-md-8 col-md-offset-2">
                                        <h2>Nueva Observaci&oacute;n</h2>
                                        <p>Aqui puede agregar un nuevo tipo de observaci&oacute;n.</p>                          
                                        <form:form commandName="Observacion" id="nuevaDescrpcion" name="nuevaObservacion" action="nuevaObservacion.do" method="POST" role="form">

                                            <form:hidden path="id" id="id" value="-1"/>

                                            <div class="form-group">
                                                <label for="detalle">Descripci&oacute;n:</label>
                                                <form:textarea id="detalle"  name="detalle" path="detalle" rows="8" cols="50" maxlength="300" class="form-control"/> 
                                                <br>
                                               ${errorBlanco}
                                            </div>

                                            <div class="form-group">
                                                <label for="tipo">Tipo:</label>
                                                <form:select id="tipo"  name="tipo" path="tipo" class="form-control">
                                                    <form:option value="1">Formato &Uacute;nico</form:option>
                                                    <form:option value="2">Reportes Bimestrales</form:option>
                                                    <form:option value="3">Documentos Finales</form:option>
                                                    <form:option value="4">Organizaciones</form:option>
                                                    <form:option value="5">Proyectos</form:option>
                                                    <form:option value="6">Usuarios</form:option>
                                 <!--tipo 0:Eliminado 1: Formato Unico 2: Reportes Bimestrales 3:Documentos Finales-->
                                                </form:select>
                                            </div>

                                            <div class="control-group">
                                                <input class="btn btn-primary" type ="submit" value = "Guardar " />
                                            </div>


                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div id="editarOrganizacion" class="modal fade" tabindex="-1" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <a data-dismiss="modal" class="close"><span class="glyphicon glyphicon-remove"></span></a>
                                <h1>Editar Observaci&oacute;n</h1>
                                Edite la Observac&oacute;n.
                            </div>
                            <div class="modal-body">
                                <form:form commandName="Observacion" action="actualizaObservacion.do" method="POST" onsubmit="return validarForm(this);" >

                                    <form:input hidden="hidden" id="id" name="name" path="id" />
                                    <div class="form-group">
                                        <label for="tipo">Descripci&oacute;n:</label>
                                        <form:textarea type="text" id="detalleE" path="detalle" rows="10" cols="70" name="detalleE" maxlength="300" class="form-control" />
                                        <div class='error alert alert-danger' style="display:none;">Error la descripcion esta vacia</div>
                                    </div>

                                    <div class="form-group">
                                        <label for="tipo">Tipo:</label>
                                        <form:select id="tipoe"  name="tipo" path="tipo" class="form-control">
                                            <form:option value="1">Formato &Uacute;nico</form:option>
                                            <form:option value="2">Reportes Bimestrales</form:option>
                                            <form:option value="3">Documentos Finales</form:option>
                                            <form:option value="4">Organizaciones</form:option>
                                            <form:option value="5">Proyectos</form:option>
                                                <!--tipo 0:Eliminado 1: Formato Unico 2: Reportes Bimestrales 3:Documentos Finales-->
                                        </form:select>
                                    </div>



                                    <div class="control-group">
                                        <input type ="submit" class="btn btn-primary" value = "Guardar " />
                                    </div>

                                </form:form>
                                <div class="modal-footer">Instituto Tecnologico de Toluca</div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%>
                <%@include file="../General/js.jsp"%>

            </div>
        </div>

    </body>
</html>