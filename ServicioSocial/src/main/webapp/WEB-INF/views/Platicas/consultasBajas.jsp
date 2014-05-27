<%-- 
    Document   : consultasBajas
    Created on : 4/06/2013, 09:48:33 AM
    Author     : mary
--%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Consultas y Bajas de Pláticas</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-eye-open"></span>&nbsp; Eliminar y Consultar Pl&aacute;ticas</h1></div>
                    <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example ' >
                        <thead>
                            <tr>
                                <th>Eliminar</th>
                                <th >Fecha de la platica</th>
                                <th>Hora</th>
                                <th>Lugar</th>
                                <th>Periodo</th>
                                <th>Descripción</th>
<!--                                <th>Tipo</th>-->
                                <th>Asistentes</th>
                                <th>Formato &Uacute;nico Fecha m&aacute;xima</th>
                            </tr>
                        </thead>

                        <tbody>
                            <core:forEach items="${platica}" var="platica">
                                <tr>
                                    <td><a class="elimina" href="#" idP="${platica.id}" fecha="${platica.fecha}"> <span class="glyphicon glyphicon-trash center-block sizeIcon" ></span></a></td>
                                    <td ><div><fmt:formatDate value="${platica.fecha}" pattern="dd-MM-yyyy"></fmt:formatDate><div></td>
                                                <td>${platica.hora}</td>
                                                <td>${platica.idLugar.lugar}</td>
                                                <td>${platica.periodo}</td>            
                                                <td>${platica.descripcion}</td>
<!--                                                <td><core:choose>
                                                    <core:when test="${platica.tipo==1}">
                                                        BECADOS
                                                    </core:when>
                                                    <core:when test="${platica.tipo==2}">
                                                        ESPECIAL
                                                    </core:when>
                                                    <core:otherwise>
                                                         INDUCCIÓN
                                                    </core:otherwise>
                                                </core:choose>
                                                </td>-->
                                                <td>${platica.numeroAsistentes}</td> 
                                                <td><fmt:formatDate value="${platica.fechaMxFui}" pattern="dd-MM-yyyy"></fmt:formatDate></td> 
                                                </tr>
                                            </core:forEach>
                                            </tbody>
                                            </table>
                                        </div><!--/row--> 
                                        <%@include file="../General/footer.jsp"%> 
                                    </div>
                                    <!---------------------------------------------Contenido-------------------------------------------> 
                                    </div> <!-- /container -->

                                    <%@include file="../General/js.jsp"%>
                                    <script type="text/javascript" src="js/script2PlaticaEliminar.js"></script>
                                    </body>

                                    </html>
