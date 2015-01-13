<%-- 
    Document   : altaUsuarios
    Created on : 3/09/2014, 01:49:47 PM
    Author     : Jorge Muñoz
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Administrador</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-user"></span>&nbsp; Nuevo Usuario</h2></div>
                <div class="row col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading panel-primary">Alta Usuario</div> 
                        <div class="panel-body">
                            <form:form name="#" commandName="usuarios" class="MyForm" action="upUserAdmin.do"  method="POST">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>                               
                                        <form:input path="nombre" onkeyup="soloTexto(event)" id="nombre" size="20" class="form-control" placeholder="Introduzca sólo su nombre" required="true"/><br/>
                                        <form:errors path="nombre" class="alert alert-danger" />
                                        ${error_sql}
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Apellido Paterno</label> 
                                        <form:input path="apellidoPat" onkeyup="soloTexto(event)" id="apellidopat" size="20" class="form-control" placeholder="Introduza sólo su apellido paterno" required="true"/><br/>
                                        <form:errors path="apellidoPat" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Apellido Materno</label> 
                                        <form:input path="apellidoMat" id="apellidomat" size="20" class="form-control" placeholder="Introduza sólo su apellido materno" required="true"/><br/>
                                        <form:errors path="apellidoMat" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group">
                                        <label for="calle">Email</label>
                                        <form:input path="email" id="email" autocomplete='off' size="20" class="form-control" placeholder="ejemplo@email.com" type="email" required="true"/><br/>
                                        <form:errors path="email" autocomplete='off' class="alert alert-danger" />
                                    </div>
                                    <div class="form-group" id="cambiaPass">
                                        <div class="form-group col-md-6">
                                            <label for="lugar">Contrase&ntilde;a:</label>
                                            <form:input path="password" onkeyup="tamanoPass(event)" autocomplete='off' id="passPrincipal" class="form-control" type="password" maxlength="50" placeholder="Minimo 6 caracteres" required="true"/><br/>
                                            <form:errors path="password" autocomplete='off' cssClass="alert alert-danger"/>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="lugar">Confirmar Contrase&ntilde;a:</label>
                                            <form:input path="password" onkeyup="verificarPassword(event)" autocomplete='off'  id="passConfirm" class="form-control" type="password" placeholder="Confirme su contraseña" required="true"/><br/>
                                            <form:errors path="password" autocomplete='off' cssClass="alert alert-danger"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">       
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Teléfono</label> 
                                        <form:input path="telefono" onkeyup="soloNumeros(event)" id="telefono" class="form-control" maxlength="10" placeholder="Introduzca sólo numeros" required="true"/><br/>
                                        <form:errors path="telefono" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Extensión</label> 
                                        <form:input path="extension" onkeyup="soloNumeros(event)" id="extension" class="form-control"  maxlength="4" placeholder="Introduzca sólo numeros" required="true"/><br/>
                                        <form:errors path="extension" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Puesto</label> 
                                        <form:input path="puesto" id="puesto" class="form-control" maxlength="80"  placeholder="Introduzca únicamente caracteres alfanuméricos" required="true"/><br/>
                                        <form:errors path="puesto" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <input type ="submit" value = "Guardar Usuario" class="btn btn-primary" /> 
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <!-- Javascript -->   
        
    </body>
    <script src="js/usuariosAdmin.js"></script>
</html>
