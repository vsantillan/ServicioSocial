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
                                <li><a href="#nuevaObservacion" data-toggle="tab">Nueva Observaci&oacute;n</a></li>
                                <li class="active"><a href="#catalogoObservaciones" data-toggle="tab">Cat&aacute;logo de Observaciones</a></li>
                            </ul>
                            &nbsp;
                            <div class="tab-content">
                                <div id="catalogoObservaciones" class="tab-pane active">
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
                                                    <th>
                                                        <a href="#a" class="fancybox-effects-a  actualizaObservacion" detalle="${current.detalle}" idO="${current.id}"><span class="glyphicon glyphicon-edit sizeIcon"></span></a>
                                                        <a href="#" class="borrarObservacion"><span class="glyphicon glyphicon-trash sizeIcon" idex="${current.id}"></span></a>
                                                    </th>
                                                    <th><core:out value="${current.id}" /></th>
                                                    <th><core:out value="${current.detalle}" /></th>
                                                    <th><core:choose>
                                                            <core:when test="${current.tipo == 1}">
                                                                Formato Unico.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 2}">
                                                                Reportes Bimestrales.
                                                            </core:when>
                                                            <core:when test="${current.tipo == 3}">
                                                                Documentos Finales
                                                            </core:when>
                                                            <core:otherwise>
                                                                Tipo Desconocido.
                                                            </core:otherwise>
                                                        </core:choose></th>
                                                </tr>
                                            </core:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div id="nuevaObservacion" class="tab-pane">
                                    <div class="col-md-8 col-md-offset-2">
                                        <h2>Nueva Observaci&oacute;n</h2>
                                        <p>Aqui puede agregar un nuevo tipo de observaci&oacute;n.</p>                          
                                        <form:form commandName="Observacion" id="nuevaDescrpcion" name="nuevaObservacion" action="nuevaObservacion.do" method="POST" role="form">

                                            <form:hidden path="id" id="id" value="-1"/>

                                            <div class="form-group">
                                                <label for="detalle">Descripci&oacute;n:</label>
                                                <form:textarea id="detalle"  name="detalle" path="detalle" rows="8" cols="50" maxlength="300" class="form-control"/> 
                                                ${errorBlanco}
                                            </div>

                                            <div class="form-group">
                                                <label for="tipo">Tipo:</label>
                                                <form:select id="tipo"  name="tipo" path="tipo" class="form-control">
                                                    <form:option value="1">Formato &Uacute;nico</form:option>
                                                    <form:option value="2">Reportes Bimestrales</form:option>
                                                    <form:option value="3">Documentos Finales</form:option>
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

                <div id="a" style="display: none; font-size: 15px">
                    <center> 
                        <h1>Editar Observaci&oacute;n</h1>
                        <form:form commandName="Observacion" action="actualizaObservacion.do" method="POST" onsubmit="return validarForm(this);" >
                            <table>
                                <form:input hidden="hidden" id="id" name="name" path="id" />
                                <tr>
                                    <td>Descripci&oacute;n:</td>
                                    <td><form:textarea type="text" id="detalleE" path="detalle" rows="10" cols="70" name="detalleE" maxlength="300"  /></td>
                                </tr>
                                <div class="form-group">
                                    <label for="tipo">Tipo:</label>
                                    <form:select id="tipo"  name="tipo" path="tipo" class="form-control">
                                        <form:option value="1">Formato &Uacute;nico</form:option>
                                        <form:option value="2">Reportes Bimestrales</form:option>
                                        <form:option value="3">Documentos Finales</form:option>
                                            <!--tipo 0:Eliminado 1: Formato Unico 2: Reportes Bimestrales 3:Documentos Finales-->
                                    </form:select>
                                </div>
                                <tr>
                                    <td>
                                        <div class='error' style="display:none;">Error la descripcion esta vacia</div>
                                    </td>
                                </tr>

                                <tr> 
                                    <td> <input type ="submit" value = "Guardar " /> </td>
                                </tr>
                            </table>
                        </form:form>
                    </center> 
                </div>
                <%@include file="../General/footer.jsp"%>
                <%@include file="../General/js.jsp"%>

            </div>
        </div>

    </body>
</html>