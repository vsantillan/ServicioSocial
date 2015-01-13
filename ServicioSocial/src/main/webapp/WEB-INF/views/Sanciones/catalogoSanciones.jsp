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
                   <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-folder-open "></span> Catálogo Sanciones</h2></div>

                    <div class="tab-content">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#catalogoSanciones" data-toggle="tab">Cat&aacute;logo de Sanciones</a></li>
                            <li><a href="#nuevaSancion" data-toggle="tab">Nueva Sanci&oacute;n</a></li>
                        </ul>&nbsp;
                        <div id="catalogoSanciones" class="tab-pane active">
                            <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="noRevisados_dt" width='100%'>
                                <thead>
                                    <tr>
                                        <th>No. Sanci&oacute;n</th>
                                        <th>Descripci&oacute;n</th>
                                        <th>Horas</th>
<!--                                        <th>D&iacute;as de tolerancia</th>-->
                                        <th>Editar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${sanciones}" var="current">
                                        <tr class='gradeX'>
                                            <td><core:out value="${current.id}" /></td>
                                            <td><core:out value="${current.detalle}" /></td>
                                            <td><core:out value="${current.horasSancion}" /></td>
<!--                                            <td><core:out value="${current.tolerancia}" /></td>-->
                                            <td><a href="editaSancion.do?id=${current.id}" class="fancyFUI" ><i class="glyphicon glyphicon-edit"></i></a></td>
                                        </tr>
                                    </core:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div id="nuevaSancion" class="tab-pane">
                                <!--<p>Nueva Sanci&oacute;n</p>-->
                                <form id="frmNuevaSancion" >
                                    <div class="row col-md-8 col-md-offset-2">
                                        <h3>Nueva Sanción</h3>
                                            <label for="hora">Horas: </label><input type="number" name="horas" size="2" value="0" required="required" class="form-control"/>
                                            <br/>
<!--                                            <label for="tolerancia">D&iacute;as de tolerancia: </label><input type="number" name="tolerancia" class="form-control" size="2" value="0" pagoSanciones/>-->
                                            <br/>
                                            <input type="hidden" value="0" name="tolerancia" id="idSancion"/>
                                            <label for="descripcion">Descripci&oacute;n:</label><br/>
                                            <textarea  name="descripcion" required="required" rows="4" cols="50" id="descripcion"  class="form-control"></textarea>
                                            <br/>
                                                <input class="btn btn-primary" type ="button" onclick="enviaSancionParaGuardado();" value = "Guardar " />
                                            <br/><br/><br/>
                                        </div>
                                      </form>  
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