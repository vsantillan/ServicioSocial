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
                    <center><h2>Cat&aacute;logo de Sanciones</h2></center>

                    <div class="tab-content">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#catalogoSanciones" data-toggle="tab">Cat&aacute;logo de Sanciones</a></li>
                            <li><a href="#nuevaSancion" data-toggle="tab">Nueva Sanci&oacute;n</a></li>
                            <li><a href="#catalogoPagoSanciones" data-toggle="tab">Cat&aacute;logo de pago de Sanciones</a></li>
                            <li><a href="#nuevoPagoSancion" data-toggle="tab">Nuevo pago de Sanci&oacute;n</a></li>
                        </ul>&nbsp;
                        <div id="catalogoSanciones" class="tab-pane active">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="noRevisados_dt" width='100%'>
                                <thead>
                                    <tr>
                                        <th>No. Sanci&oacute;n</th>
                                        <th>Descripci&oacute;n</th>
                                        <th>Horas</th>
                                        <th>D&iacute;as de tolerancia</th>
                                        <th>Editar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${sanciones}" var="current">
                                        <tr class='gradeX'>
                                            <td><core:out value="${current.id}" /></td>
                                            <td><core:out value="${current.detalle}" /></td>
                                            <td><core:out value="${current.horasSancion}" /></td>
                                            <td><core:out value="${current.tolerancia}" /></td>
                                            <td><a href="editaSancion.do?id=${current.id}" class="fancyFUI" ><i class="glyphicon glyphicon-edit"></i></a></td>
                                        </tr>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div id="nuevaSancion" class="tab-pane">
                            <center> 
                                <!--<p>Nueva Sanci&oacute;n</p>-->
                                <form id="frmNuevaSancion" >
                                    <div class="row col-md-8 col-md-offset-2">
                                        <div class="col-md-4">
                                            <label for="hora">Horas: </label><input type="number" name="horas" size="2" value="0" required="required" class="form-control"/>
                                            <br/>
                                            <label for="tolerancia">D&iacute;as de tolerancia: </label><input type="number" name="tolerancia" class="form-control" size="2" value="0" pagoSanciones/>
                                        </div>
                                        <div class="col-md-8">
                                            <br/>
                                            <label for="descripcion">Descripci&oacute;n:</label><br/>
                                            <textarea  name="descripcion" required="required" rows="4" cols="50" id="descripcion"  class="form-control"></textarea>
                                            <div class="col-md-4 col-md-offset-1"><br/>
                                                <input class="form-control btn btn-primary btn-sm" type ="button" onclick="enviaSancionParaGuardado();" value = "Guardar " />
                                            </div>
                                            <br/><br/><br/>
                                        </div>
                                    </div>
                                    
                                </form>
                            </center>
                        </div>
                        <div id="catalogoPagoSanciones" class="tab-pane">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example'     width='100%'>
                                <thead>
                                    <tr>
                                        <th>No. Sanci&oacute;n</th>
                                        <th>Descripci&oacute;n</th>
                                        <th>Editar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${pagoSanciones}" var="current">
                                        <tr class='gradeX'>
                                            <td><core:out value="${current.id}" /></td>
                                            <td><core:out value="${current.detalle}" /></td>
                                            <td><a href="editaPagoSancion.do?id=${current.id}" class="fancyFUI"><i class="glyphicon glyphicon-edit"></i></a></td>
                                        </tr>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div id="nuevoPagoSancion" class="tab-pane">
                            <center> 
                                <div class="row col-md-6 col-md-offset-3">
                                    <form:form id="frmNuevoPagoSancion">
                                        <label for="descripcion">Descripci&oacute;n:</label>
                                        <textarea class="form-control" name="descripcion" rows="4" cols="50" id="descripcion"></textarea>
                                        <div class="col-md-4 col-md-offset-4"><br/>
                                        <input type ="button" class="form-control btn btn-primary" onclick="enviaPagoSancionParaGuardado();" value = "Guardar " /> 
                                        </div>
                                    </form:form>
                                </div>

                            </center>
                        </div>
                    </div>

                    <%-- fin del contenido --%>
                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
<%@include file="../Template/headsModal.jsp" %>
    </body>
</html>