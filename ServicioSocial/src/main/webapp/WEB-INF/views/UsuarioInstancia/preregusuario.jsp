<%-- 
    Document   : preregusuario
    Created on : 24/09/2014, 01:40:05 PM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container" >
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="../Instancias/menuPreregistroInstancia.jsp" %>
            </div>
            <br/>
            <div class="alert alert-danger">
                <p>
                    Para poder registrar una instancia, debes estar registrado
                    como un usuario del sistema. Puedes registrarte o 
                    <a href="#">iniciar sesión </a>si ya tienes una cuenta creada.
                </p>
            </div>  
            
            <form:form id="form-preregusuario" class="formprereg-con" 
                       commandName="usuarioInstancia" action="registrarUsuario.do" 
                       method="POST" style="box-shadow: 0 0 2px 0 #555" >
                <div class="formprereg-cont-header" >
                    <h2>Preregistro de usuario</h2>
                </div>
                
                <div class="form-group formprereg-fieldset">
                        
                    <div class="row">
                        <div class="col-md-4">
                            <label for="unombre">Nombre (s)</label>
                            <form:input  id="unombre" path="nombre" class="form-control" required="true" type="text" placeholder="Nombre del usuario" />
                            <form:errors path="nombre" class="alert alert-danger" />
                        </div>
                        <div class="col-md-4">
                            <label for="uapat">Apellido paterno</label>
                            <form:input  id="uapat" path="apellidoPat" class="form-control" required="true" type="text" placeholder="Apellido paterno" />
                            <form:errors path="apellidoPat" class="alert alert-danger" />
                        </div>
                        <div class="col-md-4">
                            <label for="uamat">Apellido materno</label>
                            <form:input  id="uamat" path="apellidoMat" class="form-control" required="true" type="text" placeholder="Apellido materno" />
                            <form:errors path="apellidoMat" class="alert alert-danger" />
                        </div>
                    </div>
                    
                    &nbsp;<br/>
                    <div class="row">
                        <div class="col-md-4">
                            <label for="utel">Teléfono</label>
                            <form:input  id="utel" path="telefono" class="form-control" required="true" type="text" placeholder="Teléfono" />
                            <form:errors path="telefono" class="alert alert-danger" />
                        </div>
                        <div class="col-md-4">
                            <label for="uext">Extensión</label>
                            <form:input  id="uext" path="extension" class="form-control" type="text" placeholder="Extensión telefonica" />
                            <form:errors path="extension" class="alert alert-danger" />
                        </div>
                        <div class="col-md-4">
                            <label for="upuesto">Puesto del usuario</label>
                            <form:input  id="upuesto" path="puesto" class="form-control" type="text" placeholder="Puesto dentro de la instancia" />
                            <form:errors path="puesto" class="alert alert-danger" />
                        </div>
                    </div>
                    
                    &nbsp;
                    <div class="row">
                        <div class="col-md-4">
                            <label for="utel">Email</label>
                            <form:input  id="utel" path="email" class="form-control" required="true" type="email" placeholder="Email del usuario" />
                            <form:errors path="email" class="alert alert-danger" />
                        </div>
                        <div class="col-md-4">
                            <label for="upass">Cree una contraseña</label>
                            <form:input  id="upass" path="password" class="form-control" required="true" type="password" placeholder="Password" />
                            <form:errors path="password" class="alert alert-danger" />
                        </div>
                        <div class="col-md-4">
                            <label for="ucpass">Confirme su contraseña</label>
                            <input id="ucpass" class="form-control" type="password" required="true" placeholder="Confirme su contraseña" />
                            <br/><div id="alert-pass" class="alert alert-danger" style="display: none">
                                Las contraseñas no coinciden
                            </div>
                        </div>
                    </div>
                    
                    &nbsp;<br/>
                    <div class="col-md-12" style="text-align: right">
                        <input id="send-b" type ="button" value="Crear usuario" class="btn btn-primary" />
                    </div>
                    
                    &nbsp;
                </div>
            </form:form>
            
            <%@include file="../General/footer.jsp" %>
        </div>
        
        <!-- Javascript -->
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/instancias.js"></script>
    </body>
</html>
