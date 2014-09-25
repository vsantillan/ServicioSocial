<%-- 
    Document   : preregusuexitoso
    Created on : 25/09/2014, 03:27:06 PM
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
            
            <br/><br/>
            <div class="panel panel-danger" style="text-align: center">
                <h3>
                    Su registro ha sido procesado, la administración de
                    servicio social validará los datos ingresados y se
                    pondrá en contacto con usted via telefónica o email cuando
                    su cuenta este validada y activada.
                </h3>
            </div>
            
            <%@include file="../General/footer.jsp" %>
        </div>
    </body>
</html>
