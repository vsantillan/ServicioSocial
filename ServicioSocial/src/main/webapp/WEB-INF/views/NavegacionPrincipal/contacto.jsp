<%-- 
    Document   : contacto
    Created on : 10-jun-2013, 11:47:53
    Author     : bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuPrincipal.jsp"%> 
            </div><!--/row-->
            <div class="row">
                <!---------------------------------------------Contenido------------------------------------------->
                <br><br>
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-info ">
                        <div class="panel-heading"><h3>Contacto</h3></div>
                        <div class="panel-body">
                            <div class="col-md-12 col-md-offset-0">
                                <div>${message}</div>
                                <form:form role="form" commandName="Contacto" id="Contacto" name="Contacto" action="contacto.do" method="POST">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="nombre">
                                                    Nombre</label>
                                                <form:input class="form-control" placeholder="Nombre" path="nombre" maxlength="50" required="required" />
                                                <form:errors path="nombre" cssClass="alert alert-danger"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="asunto">
                                                    Asunto</label>
                                                <form:input class="form-control" placeholder="Asunto" path="asunto" maxlength="30" required="required" />
                                                <form:errors path="asunto" class="alert alert-danger"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="email">
                                                    Correo Electrónico</label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                                    </span>
                                                    <form:input class="form-control" type="email" placeholder="usuario@compañia.com" path="correo" maxlength="60" required="required"/>
                                                    <form:errors path="correo" cssClass="alert alert-danger"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="name">
                                                    Mensaje</label>
                                                <form:textarea class="form-control" path="detalle" rows="9" cols="25" maxlength="300" style="resize:none" />
                                                <form:errors path="detalle" cssClass="alert alert-danger"/>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <input class="btn btn-primary pull-right" type="submit" value="Enviar" />
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/row-->
            <%@include file="../General/footer.jsp"%>           
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>