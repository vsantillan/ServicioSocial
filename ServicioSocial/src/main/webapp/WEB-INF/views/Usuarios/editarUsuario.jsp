<%-- 
    Document   : altaUsuarios
    Created on : 30/09/2014, 04:49:47 PM
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
                <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-user"></span>&nbsp; Editar Usuario</h1></div>
                <div class="row col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading panel-primary">Editar Usuario</div> 
                        <div class="panel-body">
                            ${error}
                             
                            <form:form name="form" commandName="usuarios" action="updateUserData.do" method="POST">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>                               
                                        <form:input path="nombre" id="nombre" size="20" class="form-control"/><br/>
                                        <form:errors path="nombre" class="alert alert-danger" />
                                        
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Apellido Paterno</label> 
                                        <form:input path="apellidoPat" id="apellidopat" size="20" class="form-control"/><br/>
                                        <form:errors path="apellidoPat" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Apellido Materno</label> 
                                        <form:input path="apellidoMat" id="apellidomat" size="20" class="form-control" placeholder="Introduza sólo su apellido materno"/><br/>
                                        <form:errors path="apellidoMat" class="alert alert-danger" />
                                    </div>
                                    <div class="form-group">
                                        <label for="calle">Email</label>
                                        <form:input path="email" id="email" size="20" class="form-control" placeholder="ejemplo@email.com"/><br/>
                                        <form:errors path="email" class="alert alert-danger" />
                                    </div>   
                                    <div class="row clearfix panel-primary">
                                        <div class="col-md-12 column">
                                            <div class="tabbable " id="tabs-155708">
                                                <ul class="nav nav-tabs panel-danger">
                                                    <li id="mantenerPassword" class="active">
                                                        <a id="mantener_pass"href="#panel-701803" data-toggle="tab" onclick="OptionPassGet()">Mantener Contraseña</a>
                                                    </li>
                                                    <li id="nuevoPassword">
                                                        <a  href="#panel-600468" data-toggle="tab" onclick="OptionPassSet()">Cambiar Contraseña</a>   
                                                    </li>
                                                </ul>
                                                <div class="tab-content">
                                                    <div class="tab-pane active" id="panel-701803" path="statusPass" value="1" >
                                                        <p> 
                                                        <div class="col-md-8 column">
                                                            <div class="input-group col-md-12">
                                                                <input  type="password" id="lockPassword" name="lockPass" class="form-control"  value="lockPassword" placeholder="**************" disabled>
                                                            </div>
                                                        </div>
                                                        </p>
                                                    </div>
                                                    <div class="tab-pane" id="panel-600468" path="statusPass" value="2" >
                                                        <p>
                                                        <div class="col-md-8 column">
                                                            <div class="input-group col-md-12">
                                                                <form:input path="password" id="pass" type="password" onkeyup="tamanoPass(event)" class="form-control"  maxlength="10" placeholder="Ingrese su conrtaseña"/>
                                                            </div>
                                                        </div>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">       
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Teléfono</label> 
                                        <form:input path="telefono" id="telefono" class="form-control"   maxlength="10" placeholder="Introduzca sólo numeros"/><br/>
                                        <form:errors path="telefono" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Extensión</label> 
                                        <form:input path="extension" id="extension" class="form-control"  maxlength="4" placeholder="Introduzca sólo numeros"/><br/>
                                        <form:errors path="extension" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_organizacion">Puesto</label> 
                                        <form:input path="puesto" id="puesto" class="form-control" maxlength="80"  placeholder="Introduzca únicamente caracteres alfanuméricos"/><br/>
                                        <form:errors path="puesto" cssClass="alert alert-danger"/>
                                    </div>
                                    <div class="form-group">
                                        <input type ="submit" class="btn btn-primary" value = "Editar Usuario" /> 
                                    </div>
                                </div>
                                    <form:input hidden="hidden" path="idUsuarioInstancia" />
                            </form:form>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>   
        <%@include file="../General/js.jsp"%>
    </body>
    <script src="js/instancias.js"></script>
    <script src="js/usuariosAdmin.js"></script>
    <script src="js/jquery-1.9.1.js"></script>
    <script>
                                                            $(document).ready(function()
                                                            {
                                                                $('#pass').removeAttr('value');
                                                            });
                                                            
                                                            function OptionPassGet() {
                                                           document.getElementById('pass').value = "";
                                                            }
                                                            function OptionPassSet() {
                                                           document.getElementById('lockPassword').value = "lockPassword";
                                                            }
    </script>
</html>
