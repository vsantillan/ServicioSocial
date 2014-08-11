<%-- 
    Document   : verAlumnosProyecto
    Created on : 06-sep-2013, 16:21:51
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<%@include file="../General/head.jsp"%>--%>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <%@include file="../General/jstl.jsp"%>
        <title>Alumnos en Proyecto</title>
    </head>
    <body>
        <div class="container col-md-12">
            <div class="row">
                <div class="row col-md-12 center-block">
                    <div class="panel panel-info">
                        <div class="panel-heading"><h4 class="text-center">Alumnos en el proyecto ${proyecto.nombre}</h4></div>
                        <!-- Table -->
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th class="text-center">No. Control</th>
                                    <th class="text-center">Nombre</th>
                                    <th class="text-center">Carrera</th>
                                    <th class="text-center">E-mail</th> 
                                    <th class="text-center">Tel&eacute;fono</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${alumnos}" var="current">
                                    <tr id="${current.id}">
                                        <th class="text-center"><core:out value="${current.datosPersonalesId.alumnoId.id}" /></th>
                                        <th class="text-center"><core:out value="${current.datosPersonalesId.nombre} ${current.datosPersonalesId.apellidoP} ${current.datosPersonalesId.apellidoM}" /></th>
                                        <th class="text-center"><core:out value="${current.datosPersonalesId.alumnoId.carrera}" /></th>
                                        <th class="text-center"><core:out value="${current.datosPersonalesId.correoElectronico}" /></th>
                                        <th class="text-center"><core:out value="${current.datosPersonalesId.telefonoCel}" /></th>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
    </body>
</html>
