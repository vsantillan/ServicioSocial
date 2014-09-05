<%-- 
    Document   : altaUsuarios
    Created on : 3/09/2014, 01:49:47 PM
    Author     : Jorge Mu�oz
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
                <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-user"></span>&nbsp; Nuevo Usuario</h1></div>
                <div class="row col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading panel-primary">Alta Usuario</div> 
                        <div class="panel-body">
                            <form:form name="#" commandName="usuarios" class="MyForm" action="#"  method="POST">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>                               
                                        <form:input path="nombre" id="nombre" size="20" class="form-control" placeholder="Introduzca s�lo su nombre"/><br/>
                                        <form:errors path="nombre" class="alert alert-danger" />
                                        ${error_sql}
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Apellido Paterno</label> 
                                        <form:input path="apellidoPat" id="apellidopat" size="20" class="form-control" placeholder="Introduza s�lo su apellido paterno"/><br/>
                                        <form:errors path="apellidoPat" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Apellido Materno</label> 
                                        <form:input path="apellidoMat" id="apellidomat" size="20" class="form-control" placeholder="Introduza s�lo su apellido materno"/><br/>
                                        <form:errors path="apellidoMat" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group">
                                        <label for="calle">Email</label>
                                        <form:input path="email" id="email" size="20" class="form-control" placeholder="ejemplo@email.com"/><br/>
                                        <form:errors path="email" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group" id="cambiaPass">
                                        <div class="form-group col-md-6">
                                            <label for="lugar">Contrase&ntilde;a:</label>
                                            <form:input path="password" id="password" class="form-control" type="password" maxlength="50" placeholder="Minimo 6 caracteres"/><br/>
                                            <form:errors path="password" cssClass="alert alert-danger"/>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="lugar">Confirmar Contrase&ntilde;a:</label>
                                            <form:input path="password" id="password" class="form-control" type="password" maxlength="50" placeholder="Confirme su contrase�a"/><br/>
                                            <form:errors path="password" cssClass="alert alert-danger"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">       
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Tel�fono</label> 
                                        <form:input path="telefono" id="telefono" class="form-control"  maxlength="10" placeholder="Introduzca s�lo numeros"/><br/>
                                        <form:errors path="telefono" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Extensi�n</label> 
                                        <form:input path="extension" id="extension" class="form-control"  maxlength="4" placeholder="Introduzca s�lo numeros"/><br/>
                                        <form:errors path="extension" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Puesto</label> 
                                        <form:input path="puesto" id="puesto" class="form-control" maxlength="80"  placeholder="Introduzca �nicamente caracteres alfanum�ricos"/><br/>
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
        <script src="js/instancias.js"></script>
        <script src="js/jquery-1.9.1.js"></script>
    </body>
</html>
