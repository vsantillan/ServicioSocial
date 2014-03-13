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
                    <h1>Cartas de Liberaci�n</h1>
                    <p>A continuaci&oacute;n se muestra una lista de los alumnos a los cuales se les puede generar la Carta de Liberaci�n.</p>
                    <div id="cartasLiberacion">
                        <table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered example' id="Rev" width='100%'>
                            <thead>
                                <tr>
                                    <th>Generar</th>
                                    <th>Nombre</th>
                                    <th>N. Control</th>
                                    <th>�Se entrego anteriormente?</th>
                                    <th>Horas Acumuladas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <core:forEach items="${listaCartasLiberacion}" var="carta">
                                    <tr class='gradeX'>
                                        <td><input type="checkbox" name="checkbox" value="${carta.noControl}">&nbsp;Generar Carta de Liberaci�n</td>
                                        <td><core:out value="${carta.nombreCompleto}"/></td>
                                        <td><core:out value="${carta.noControl}"/></td>
                                        <td><core:out value="No"/></td>
                                        <td><core:out value="${carta.horasAcumuladas}"/></td>
                                    </tr>
                                </core:forEach>
                            </tbody>
                        </table>
                        <br/>
                        <button type="button" class="btn btn-primary generaCartas">Genera Cartas de Liberaci�n</button>
                        <hr>
                    </div>
                </div>  
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" language="javascript" src="js/cartasLiberacion.js"></script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
