<%-- 
    Document   : confirmaAltaProyectos
    Created on : 15-ago-2013, 17:55:18
    Author     : bustedvillain
--%>

<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%> 
        <title>Alta de Proyectos</title>

    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuPrincipal.jsp"%> 
                <div class="row col-md-12">
                    <center>
                        <br/>
                        <h1>Proyecto registrado correctamente</h1>
                        <span class="glyphicon glyphicon-search sizeIconValid"></span>
                        <h3>Espere la confirmaci&oacute;n del administrador para validar su proyecto. Ser&aacute; notificado en la direcci&oacute;n de correo que nos ha proporcionado o en su cuenta de usuario a la brevedad posible.</h3>
                        <br/>
                    </center>
                </div>
                <%@include file="../General/footer.jsp"%>  
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
    </body>
</html>
