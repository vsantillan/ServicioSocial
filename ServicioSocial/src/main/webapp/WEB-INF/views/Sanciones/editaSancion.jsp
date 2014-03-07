<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%--<%@include file="../General/banner.jsp"%>--%>  
                <%--<%@include file="../General/menuAdministrador.jsp"%>--%> 
                <div class="row col-md-12 center-block">
                    <center><h2>Editar Sanci&oacute;n</h2></center>
                        <form:form name="nuevaSancion"  onsubmit="window.parent.Shadowbox.close();">
                        <div class="row col-md-8 col-md-offset-2">
                            <div class="col-md-4">
                                <label for="hora">Horas: </label><input type="number" name="horas" id="eHoras" size="15" value="${horas}" class="form-control" />
                                <br/>
                                <label for="tolerancia">D&iacute;as de tolerancia: </label><input type="number" id="eTolerancia" class="form-control" name="tolerancia" size="2" value="${tolerancia}" pagoSanciones/>
                            </div>
                            <div class="col-md-8">
                                <br/>
                                <input type="hidden" value="${idSancion}" name ="id" id="idSancion"/>
                                <label for="descripcion">Descripci&oacute;n:</label><br/>
                                <textarea class="form-control" name="descripcion" rows="4" cols="50" id="eDescripion">${descripcion}</textarea>
                                <div class="col-md-4 col-md-offset-1"><br/>
                                    <input class="form-control btn btn-primary btn-sm" type ="button" onclick="editarSancion2();" value = "Guardar " />
                                </div>
                                <br/><br/><br/>
                            </div>
                        </div>
<!--                        <table>
                            <tr>
                            
                            <td> <label for="descripcion">Descripci&oacute;n:</label> </td>
                            <td>  </td>
                            </tr>
                            <tr>
                                <td>  <label for="hora">Horas:</label> </td>
                                <td>  </td>  
                            </tr>
                            <tr>
                                <td> <p><label for="tolerancia">D&iacute;as de tolerancia</label></p> </td>
                                <td>  </td>  
                            </tr>
                            <tr> 
                                <td> <input type ="button"   value = "Guardar " /> </td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>-->
                    </form:form>
                    <div id="observaciones" style="display: none">
                        <b>Debes atender los siguientes puntos</b><br/>
                        <ul id="listaObservaciones" >

                        </ul>

                    </div>
                    </center>
                </div><!--/row--> 
                <%--<%@include file="../General/footer.jsp"%>--%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>