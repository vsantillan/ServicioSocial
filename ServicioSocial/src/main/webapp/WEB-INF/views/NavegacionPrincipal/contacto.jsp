<%-- 
    Document   : convocatorias
    Created on : 10-jun-2013, 11:47:53
    Author     : bustedvillain
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
                <%@include file="../General/menuPrincipal.jsp"%> 
            </div><!--/row-->
            <div class="row ">
                <!---------------------------------------------Contenido------------------------------------------->                
                <div class="col-md-6 col-md-offset-3">
                    <h1>Contacto</h1>
                    <div>${message}</div>  
                    <form:form class="form-horizontal" role="form" commandName="Contacto" id="Contacto" name="Contacto" action="contacto.do"  method="POST">
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <form:input class="form-control" placeholder="Nombre" path="nombre" /><br>
                            <form:errors path="nombre" cssClass="alert alert-danger"/> 
                        </div>
                        <div class="form-group">
                            <label for="asunto">Asunto:</label>
                            <form:input class="form-control" placeholder="Asunto" path="asunto"/><br>
                            <form:errors path="asunto" class="alert alert-danger"/>
                        </div>
                        <div class="form-group">
                            <label for="correo">Correo electr&oacute;nico:</label>
                            <form:input class="form-control" placeholder="Correo electrónico" path="correo"/><br>
                            <form:errors path="correo" cssClass="alert alert-danger"/> 
                        </div>
                        <div class="form-group">
                            <label for="nombre">Descripci&oacute;n:</label>
                            <form:textarea  class="form-control" path="detalle" rows="8" cols="50" maxlength="300" /><br>
                           <form:errors path="detalle" cssClass="alert alert-danger"/> 
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

            </div><!--/row-->
            <%@include file="../General/footer.jsp"%>           
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>