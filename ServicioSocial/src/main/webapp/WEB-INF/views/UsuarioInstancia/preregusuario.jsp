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
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="../Instancias/menuPreregistroInstancia.jsp" %>
            </div>
            <div class="alert-danger">
                <p>
                    Para poder registrar una instancia, debes estar registrado
                    como un usuario del sistema. Puedes registrarte o <a href="#">inicia
                    sesión </a>si ya tienes una cuenta creada.
                </p>
            </div>
        </div>
    </body>
</html>
