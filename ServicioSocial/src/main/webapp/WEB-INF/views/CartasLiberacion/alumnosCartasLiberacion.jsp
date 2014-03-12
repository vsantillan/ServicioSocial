<%-- 
    Document   : alumnosCartasLiberacion
    Created on : 7/10/2013, 10:23:20 AM
    Author     : Regules
--%>

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
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class="row col-md-12 center-block">
                    <h1>Cartas de Liberación</h1>
                    <div id="cartasLiberacion">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Rev" width='100%'>
                            <thead>
                                <tr>
                                    <th>Generar</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>¿Se entrego anteriormente?</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listaCartasLiberacion}" var="carta">
                                    <tr class='gradeX'>
                                        <td><span class="glyphicon glyphicon-search sizeIcon"><input type="checkbox" name="option1" value="${carta.noControl}"/></span>Generar Carta de Liberación</td>
                                        <td><core:out value="${carta.nombreCompleto}"/></td>
                                        <td><core:out value="${carta.noControl}"/></td>
                                        <td><core:out value="No"/></td>
                                        <td><core:out value="${carta.horasAcumuladas}"/></td>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>  
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        
        <%@include file="../General/js.jsp"%>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
