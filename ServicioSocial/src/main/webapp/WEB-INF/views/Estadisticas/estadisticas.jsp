<%-- 
    Document   : estadisticas
    Created on : 18/03/2014, 10:42:17 AM
    Author     : rodrigo
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
                    <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-stats"></span>&nbsp; Estadisticas</h1></div>
                    <div class="row">
                        <div id="sexoAltas" class="col-md-4"></div>
                        <div id="sexoLiberaciones" class="col-md-4"></div>
                        <div id="sexoResumen" class="col-md-4">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Sexo</th>
                                        <th>Altas</th>
                                        <th>Liberaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Femenino</td>
                                        <td>${totalFemenino}</td>
                                        <td>${totalFemeninoLiberaciones}</td>
                                    </tr>
                                    <tr>
                                        <td>Masculino</td>
                                        <td>${totalMasculino}</td>
                                        <td>${totalMasculinoLiberaciones}</td>
                                    </tr>
                                    <tr>
                                        <td>Indefinido</td>
                                        <td>${totalIndefinido}</td>
                                        <td>${totalIndefinidoLiberaciones}</td>
                                    </tr>
                                    <tr>
                                        <td>Total</td>
                                        <td>${totalFemenino + totalMasculino + totalIndefinido}</td>
                                        <td>${totalFemeninoLiberaciones + totalMasculinoLiberaciones + totalIndefinidoLiberaciones}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div id="carrerasAltas" class="col-md-4"></div>
                        <div id="carrerasLiberaciones" class="col-md-4"></div>
                        <div id="carrerasResumen" class="col-md-4">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Carreras</th>
                                        <th>Altas</th>
                                        <th>Liberaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Ing. Quimica</td>
                                        <td>${carrerasAltas[0]}</td>
                                        <td>${carrerasLiberaciones[0]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Industrial</td>
                                        <td>${carrerasAltas[1]}</td>
                                        <td>${carrerasLiberaciones[1]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Electromecanica</td>
                                        <td>${carrerasAltas[2]}</td>
                                        <td>${carrerasLiberaciones[2]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Mecatronica</td>
                                        <td>${carrerasAltas[3]}</td>
                                        <td>${carrerasLiberaciones[3]}</td>
                                    </tr>
                                    <tr>
                                        <td>Lic. en Administraci&oacute;n</td>
                                        <td>${carrerasAltas[4]}</td>
                                        <td>${carrerasLiberaciones[4]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Electronica</td>
                                        <td>${carrerasAltas[5]}</td>
                                        <td>${carrerasLiberaciones[5]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. en Sitemas Computacionales</td>
                                        <td>${carrerasAltas[6]}</td>
                                        <td>${carrerasLiberaciones[6]}</td>
                                    </tr>
                                    <tr>
                                        <td>Total</td>
                                        <td>${carrerasAltas[0] + carrerasAltas[1] + carrerasAltas[2] + carrerasAltas[3] + carrerasAltas[4] + carrerasAltas[5] + carrerasAltas[6]}</td>
                                        <td>${carrerasLiberaciones[0] + carrerasLiberaciones[1] + carrerasLiberaciones[2]+carrerasLiberaciones[3]+carrerasLiberaciones[4]+carrerasLiberaciones[5]+carrerasLiberaciones[6]}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div id="programasAltas" class="col-md-4"></div>
                        <div id="programasLiberaciones" class="col-md-4"></div>
                        <div id="programasResumen" class="col-md-4">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Programas</th>
                                        <th>Altas</th>
                                        <th>Liberaciones</th>
                                    </tr>
                                </thead>
                                <tbody id="tablaProgramas">

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div id="instanciasAltas" class="col-md-6"></div>
                        <div id="instanciasResumen" class="col-md-6">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Instancias</th>
                                        <th>Altas</th>
                                    </tr>
                                </thead>
                                <tbody id="tablaInstancias">

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%@include file="../General/footer.jsp"%> 
                </div>
            </div>
            <%@include file="../General/js.jsp"%>
            <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
            <script type="text/javascript">
                $('#formatoUnico-tabla a:first').tab('show');
            </script>
            <jsp:include page="../Template/headsModal.jsp" />
            <!--Load the AJAX API-->
            <script type="text/javascript" src="https://www.google.com/jsapi"></script>
            <script type="text/javascript" src="js/estadisticas.js"></script>
            <script type="text/javascript">
                $(document).ready(listo);

                function listo() {
                    $.get("programasEstadisticas.do?&ano=2014&periodo=ENE-AGO", null, function(respuesta) {
                        drawChartProgramas(respuesta);
                    });
                    $.get("programasEstadisticasLiberados.do?&ano=2014&periodo=ENE-AGO", null, function(respuesta) {
                        drawChartProgramasLiberaciones(respuesta);
                    });
                    $.get("programasEstadisticasLiberadosTabla.do?&ano=2014&periodo=ENE-AGO", null, function(respuesta) {
                        $('#tablaProgramas').append(construyeTabla(respuesta));
                    });
                    $.get("instanciasEstadisticas.do?&ano=2014&periodo=ENE-AGO", null, function(respuesta) {
                        $('#tablaInstancias').append(drawChartInstancias(respuesta));
                    });
                    drawChartSexAltas(${totalMasculino},${totalFemenino},${totalIndefinido});
                    drawChartSexLiberaciones(${totalMasculinoLiberaciones},${totalFemeninoLiberaciones},${totalIndefinidoLiberaciones});
                    drawChartCarrerasAltas(${carrerasAltas[0]},${carrerasAltas[1]},${carrerasAltas[2]},${carrerasAltas[3]},${carrerasAltas[4]},${carrerasAltas[5]},${carrerasAltas[6]});
                    drawChartCarrerasLiberaciones(${carrerasLiberaciones[0]},${carrerasLiberaciones[1]},${carrerasLiberaciones[2]},${carrerasLiberaciones[3]},${carrerasLiberaciones[4]},${carrerasLiberaciones[5]},${carrerasLiberaciones[6]});
                }

            </script>

    </body>
</html>
