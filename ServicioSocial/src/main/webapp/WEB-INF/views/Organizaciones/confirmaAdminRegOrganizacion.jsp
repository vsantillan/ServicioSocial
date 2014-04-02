<%-- 
    Document   : confirmaAdminRegOrganizacion
    Created on : 09-jul-2013, 10:56:56
    Author     : bustedvillain
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
                <div class="row col-md-12 center-block">
                    <center>
                        <h1>Organizaci&oacute;n registrada correctamente</h1>
                        <span class="glyphicon glyphicon-ok sizeIconValid"></span>

                        <br/>
                    </center>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <script src="js/jquery.codigos.postales.js"></script>
        <script src="js/jquery.manolo.js"></script>
    </body>
</html>
