<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../General/head.jsp"%>
        <title>Panel Organizaci&oacute;n</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="../General/menuOrganizacion.jsp"%>
                <div class="col-md-12">
                    <div class="help-block col-md-12 text-center"><h1><span class="glyphicon glyphicon-user"></span>&nbsp;Bienvenido al Sitio para Organizaciones</h1></div>
                    <!--<div class="row" id="edicionCorrecta" ><center>${mensaje1} ${mensaje}</center></div>-->
                    <div class="alert alert-warning col-md-6 col-md-offset-3">
                        <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-import"></span>&nbsp;A continuaci&oacute;n se muestran mensajes que el administrador le ha enviado:</h5></div>
                    </div>
                    <div class="col-md-14">
                        <%@include file="../General/footer.jsp"%> 
                    </div>
                </div>
            </div>
        </div>
        <script>document.getElementById("password").value = "";</script>
        <%@include file="../General/js.jsp"%>
        <script src="js/jquery.codigos.postales.js"></script>       
        <script src="js/jquery.manolo.js"></script>
    </body>
</html>
