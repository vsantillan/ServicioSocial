<%-- 
    Document   : mensajeOrganizacion
    Created on : 11-jun-2013, 13:56:30
    Author     : bustedvillain
--%>
<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Mensajes Organizador</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuOrganizacion.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class="help-block col-md-12 text-center"><h1><span class="glyphicon glyphicon-envelope "></span>&nbsp;Mensajes Organizaci&oacute;n</h1></div>
                </div>
                <div class="alert alert-warning col-md-6 col-md-offset-3">
                    <div class="alert-heading "><h5 class="text-center"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;A continuaci&oacute;n se muestran mensajes que el administrador le ha enviado:</h5></div>
                </div>
                <core:forEach items="${observaciones}" var="observacion">
                    <div class="alert alert-info col-md-10 col-md-offset-1">
                        <div class="alert-heading ">
                            <p class="text-center">
                                ${observacion}
                            </p>
                        </div>
                    </div>
                </core:forEach>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
    </body>
</html>