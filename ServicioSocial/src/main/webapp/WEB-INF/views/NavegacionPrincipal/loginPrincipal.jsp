<%-- 
    Document   : loginAlumnos
    Created on : 10-jun-2013, 11:24:14
    Author     : bustedvillain
--%>
<%
    String error = "";
    if (request.getParameter("error") != null) {
        error = request.getParameter("error");
    }
%>
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
                    <br>
                    <form:form name="formLogin" class="form-signin EnviarEnter" role="form" action="validaLogin.do" method="POST"  >
                        <h3 class="form-signin-heading">Iniciar Sesión</h3>
                        <input type="text" name="usuario" id="usuario" class="form-control" placeholder="Usuario o alu_00289999" required="required" autofocus>
                        <input type="password" name="pass" id="pass" class="form-control" placeholder="Contraseña" required="required" />
                        <button class="btn btn-lg btn-primary btn-block" input type ="button"  id="btnLogin">Entrar</button>
                         <h5>Recuerda que para acceder debes de contar con los cr&eacute;ditos suficientes especificados en el manual del proceso del Servicio Social.</h5>
                        <div id="respLoginOrg" style="display:none;">
                            <center><img src='img/loading.gif' width="10px"><br/>Iniciando sesión, espere un momento...</center> 
                            </div>
                            ${error}
                            <%=error%>
                          
                    </form:form>
                       <br/><br/><br/><br/><br/>
                </div><!--/row-->
                <%@include file="../General/footer.jsp"%>           
            </div> <!-- /container -->
            <%@include file="../General/js.jsp"%>
        </body>
