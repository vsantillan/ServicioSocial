<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
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
                <div class="row ">
                    <!---------------------------------------------Contenido------------------------------------------->      

                    <div class="col-md-8 col-md-offset-2">
                        <br>
                        <div class="panel panel-info">
                            <div class="panel-heading "
                        <center><h3>Nueva Pl&aacute;tica</h3></center>
                            ${alert}</div>
                        <!-- Formulario Nueva Plática -->  
                        <div class="panel-body">
                        <form:form action="altaPlaticaBD.do" method="post" commandName="platica" id="formPlatica"  class=" EnviarEnter" role="form" name="altaPlatica" > 

                            <div class="form-group">
                                <label for="fecha">Fecha de la pl&aacute;tica:</label>
                                <div class="input-group date dp3" data-date="" data-date-format="dd-mm-yyyy">
                                    <form:input class="form-control" path="fecha"/>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                </div><br>
                                <form:errors path="fecha" class="alert alert-danger" />
                            </div>
                            <div class="form-group">
                                <label for="hora" >Hora de la pl&aacute;tica: </label>
                                <div class="input-group input-append bootstrap-timepicker">
                                    <form:input id="timepicker1" path="hora" type="text" readonly="" class="form-control"/>
                                    <span class="input-group-addon add-on"><i class="glyphicon glyphicon-time"></i></span>
                                </div><br>
                                <form:errors path="hora" class="alert alert-danger" />
                            </div>
                            <div class="form-group">
                                <label for="lugar" >Lugar de la plática: </label>                              
                                <form:select class="form-control" path="idLugar.id">
                                    <core:forEach items="${lugares}" var="lugares" >
                                        <form:option value="${lugares.id}">${lugares.lugar}</form:option>
                                    </core:forEach>
                                </form:select><br>
                                <input type ="button" href="#nuevoL" class="btn btn-primary" id="agregaLugar" value = "Agregar lugar" data-toggle="modal" />
                            </div>
<!--                            <div class="form-group">
                                <label for="periodo">Periodo</label>
                                <form:select class="form-control" path="periodo">
                                    <form:option value="ENE-JUN"/>
                                    <form:option value="AGO-DIC"/>
                                </form:select> 
                            </div>
                            <div class="form-group">
                                <label for="ano">A&ntilde;o</label> 
                                <form:select class="form-control" id="anio" path="anio">         
                                    <core:forEach var="i" begin="${anioInicio}" end="${anioFin}" step="1">
                                        <form:option value="${i}"/><core:out value="${i}" />
                                    </core:forEach>
                                </form:select>
                            </div>-->
                            <div class="form-group">
                                <label for="tipoPlatica">Tipo de  pl&aacute;tica:</label>
                                <form:select  class="form-control" id="tipo" path="tipo">
                                    <form:option  value="1">NORMAL</form:option>
                                    <form:option  value="2">BECADOS</form:option>
                                    <form:option  value="3">ESPECIAL</form:option>
                                </form:select> 
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripci&oacute;n de la pl&aacute;tica</label> 
                                <form:textarea  path="descripcion"  id="descripcion"  class="form-control" rows="10"/><br>
                                <form:errors path="descripcion" class="alert alert-danger" />
                            </div>
                            <div class="form-group">
                                <label for="fecha_max_fui">Fecha m&aacute;xima para subir formato &uacute;nico</label>
                                <div class="input-group date dp3"  data-date="" data-date-format="dd-mm-yyyy">
                                    <form:input class="form-control"  path="fechaMxFui" type="text" />
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                </div><br>
                                <form:errors  path="fechaMxFui" class="alert alert-danger" /><br>
                                ${errorFm}
                            </div>
                            <div class="form-group">

                                <div class=" col-md-offset-2 col-sm-5">
                                    <input  class="btn btn-primary" type ="reset" value = "Limpiar" />
                                </div>
                                <div class="col-sm-5">
                                    <input   class="btn btn-primary" type ="submit" value = "Guardar " /> 
                                </div>
                            </div>
                        </form:form>
                        </div>

                        </div>
                    </div>




                    <!---------------------------------------------Fin Contenido-------------------------------------------> 
                </div><!--/row--> 
                <div id="nuevoL" class="modal fade" tabindex="-1" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <%-- Formulario Nueva lugar para platica de inducción --%>
                                <a data-dismiss="modal" class="close"><span class="glyphicon glyphicon-remove"></span></a>
                                <h1>Agregar un Lugar</h1>
                                <p>Escriba la descripcion del lugar.</p>
                            </div>
                            <div class="modal-body">
                                <form:form commandName="lugar_i" id="nuevoLugar" action="nuevoLugarAltaPlatica.do" method="POST">
                                    <div class="form-group">
                                        <p><label for="lugar">Descripci&oacute;n:</label> </p>
                                        <form:input id="lugar" class="lugares form-control" name="lugar" path="lugar" rows="8" cols="50"/> 
                                        <div id="errorVacio1"></div>
                                    </div>
                                    <input type ="submit" id="envioB1" value = "Guardar " class="btn btn-primary" />

                                </form:form>
                            </div>
                                <div class="modal-footer">Instituto Tecnol&oacute;gico de Toluca</div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
