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
                    <div class="row col-md-6 col-md-offset-3">
                        <form:form name="nuevaSancion"  onsubmit="window.parent.Shadowbox.close();">
                            <input type="hidden" value="${idSancion}" name ="id" id="pidSancion"/>
                            <label for="descripcion">Descripci&oacute;n:</label>
                            <textarea name="descripcion" class="form-control" rows="4" cols="50" id="epDescripion">${descripcion}</textarea>
                            <div class="col-md-4 col-md-offset-4"><br/>
                                <input type ="button" class="form-control btn btn-primary" onclick="edtitarPagoSancion();" value = "Guardar " />
                            </div>
                        </form:form>
                    </div>


<!--                    <table>
                        <tr>
                        
                        <td> <label for="descripcion">Descripci&oacute;n:</label> </td>
                        <td>  </td>
                        </tr>

                        <tr> 
                            <td>  </td>
                            <td> <input type ="reset" value = "Limpiar" /></td>
                        </tr>
                    </table>-->

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
