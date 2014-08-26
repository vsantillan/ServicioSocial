<%-- 
    Document   : administrarproyectos
    Created on : 26/08/2014, 02:15:49 PM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp" %>
        <link href="<%=request.getContextPath()%>/css/instanciasadminproy.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp" %>
                <%@include file="../General/menuOrganizacion.jsp" %>
            </div>
            <div class="row">
                <div class="col-md-6 admnp-lista-proyectos">
                    <div class="admnp-lista-proyectos-list">
                        <div class="admnp-lista-proyectotitle">
                            Proyectos disponibles
                        </div>
                        <div class="admnp-lista-proyecto">
                            Un proyectito
                        </div>
                        <div class="admnp-lista-proyecto">
                            Un proyectito
                        </div>
                        <div class="admnp-lista-proyecto">
                            Un proyectito
                        </div>
                    </div>
                </div>
                <div class="col-md-6 admnp-lista-proyectos">
                    <br/><br/><br/>
                </div>
            </div>
        </div>
    </body>
</html>
