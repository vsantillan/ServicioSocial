<%-- 
    Document   : asignarSancion
    Created on : 14/05/2014, 02:00:32 PM
    Author     : jonny
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
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <br/>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h3>Asignar Sanción</h3></div>
                            <div class="panel-body">
                                <form:form  role="form"  name="sancion" action="asignaSancionAlumno.do"   method="POST" >

                                    <div class="form-group">
                                        <label for="no_control">Seleccione la sanción:</label>
                                        <select class="form-control" name="idSancion">
                                            <core:forEach items="${catalogoSancion}" var="sanciones" >
                                                <option value="${sanciones.id}">${sanciones.detalle}</option>
                                            </core:forEach>
                                        </select><br>
                                       ${errorSancion}
                                    </div>

                                    <div class="form-group">
                                        <label for="no_control">Número de Control:</label>
                                        <input type="text" class="form-control" autofocus="true" name="numeroControl" id="no_control" size="15" />
                                        ${errorAlumno}
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
                 </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
