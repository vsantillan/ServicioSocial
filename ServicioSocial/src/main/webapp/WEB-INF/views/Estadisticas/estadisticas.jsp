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
                        <div class="col-md-2 col-md-offset-4">
                            <select id="anio" class="form-control" onchange="actualizaInformacion();">
                                <core:forEach items="${anio}" var="anioActual">
                                    <option value="${anioActual}">${anioActual}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" id="periodo" onchange="actualizaInformacion();">
                                <option value="ENE">ENE-JUN</option>
                                <option value="JUN">JUL-DIC</option>
                            </select>
                        </div>
                    </div>
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
                                <tbody id="tablaSexo">
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
                                        <th>Total</th>
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
                                <tbody id="tablaCarreras">
                                    <tr>
                                        <td>Ing. Qu&iacute;mica</td>
                                        <td>${carrerasAltas[0]}</td>
                                        <td>${carrerasLiberaciones[0]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Industrial</td>
                                        <td>${carrerasAltas[1]}</td>
                                        <td>${carrerasLiberaciones[1]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Electromec&aacute;nica</td>
                                        <td>${carrerasAltas[2]}</td>
                                        <td>${carrerasLiberaciones[2]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Mecatr&oacute;nica</td>
                                        <td>${carrerasAltas[3]}</td>
                                        <td>${carrerasLiberaciones[3]}</td>
                                    </tr>
                                    <tr>
                                        <td>Lic. en Administraci&oacute;n</td>
                                        <td>${carrerasAltas[4]}</td>
                                        <td>${carrerasLiberaciones[4]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. Electr&oacute;nica</td>
                                        <td>${carrerasAltas[5]}</td>
                                        <td>${carrerasLiberaciones[5]}</td>
                                    </tr>
                                    <tr>
                                        <td>Ing. en Sistemas Computacionales</td>
                                        <td>${carrerasAltas[6]}</td>
                                        <td>${carrerasLiberaciones[6]}</td>
                                    </tr>
                                    <tr>
                                        <th>Total</th>
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
                    var anio = $("#anio option:selected").text();
                    var periodo = $("#periodo option:selected").text();
                    $.get("programasEstadisticas.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        drawChartProgramas(respuesta);
                    });
                    $.get("programasEstadisticasLiberados.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        drawChartProgramasLiberaciones(respuesta);
                    });
                    $.get("programasEstadisticasLiberadosTabla.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        $('#tablaProgramas').append(construyeTabla(respuesta));
                    });
                    $.get("instanciasEstadisticas.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        $('#tablaInstancias').append(drawChartInstancias(respuesta));
                    });
                    drawChartSexAltas(${totalMasculino},${totalFemenino},${totalIndefinido});
                    drawChartSexLiberaciones(${totalMasculinoLiberaciones},${totalFemeninoLiberaciones},${totalIndefinidoLiberaciones});
                    drawChartCarrerasAltas(${carrerasAltas[0]},${carrerasAltas[1]},${carrerasAltas[2]},${carrerasAltas[3]},${carrerasAltas[4]},${carrerasAltas[5]},${carrerasAltas[6]});
                    drawChartCarrerasLiberaciones(${carrerasLiberaciones[0]},${carrerasLiberaciones[1]},${carrerasLiberaciones[2]},${carrerasLiberaciones[3]},${carrerasLiberaciones[4]},${carrerasLiberaciones[5]},${carrerasLiberaciones[6]});
                }
                function actualizaInformacion() {
                    var anio = $("#anio option:selected").text();
                    var periodo = $("#periodo option:selected").text();
                    $('#tablaProgramas').empty();
                    $('#tablaInstancias').empty();

                    $.get("programasEstadisticas.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        drawChartProgramas(respuesta);
                    });
                    $.get("programasEstadisticasLiberados.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        drawChartProgramasLiberaciones(respuesta);
                    });
                    $.get("programasEstadisticasLiberadosTabla.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        $('#tablaProgramas').append(construyeTabla(respuesta));
                    });
                    $.get("instanciasEstadisticas.do?&ano=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        $('#tablaInstancias').append(drawChartInstancias(respuesta));
                    });
                    $.get("datosSexoCarreras.do?&anio=" + anio + "&periodo=" + periodo + "", null, function(respuesta) {
                        var contenido = respuesta.split("|");
                        var sexoAlta = contenido[0].split(",");
                        var sexoLiberaciones = contenido[1].split(",");
                        var carrerasAltas = contenido[2].split(",");
                        var carrerasLiberaciones = contenido[3].split(",");
                        drawChartSexAltas(parseInt(sexoAlta[0]), parseInt(sexoAlta[1]), parseInt(sexoAlta[2]));
                        drawChartSexLiberaciones(parseInt(sexoLiberaciones[0]), parseInt(sexoLiberaciones[1]), parseInt(sexoLiberaciones[2]));
                        contruyeTablaSexo(sexoAlta[0], sexoAlta[1], sexoAlta[2], sexoLiberaciones[0], sexoLiberaciones[1], sexoLiberaciones[2]);
                        drawChartCarrerasAltas(parseInt(carrerasAltas[0]), parseInt(carrerasAltas[1]), parseInt(carrerasAltas[2]), parseInt(carrerasAltas[3]), parseInt(carrerasAltas[4]), parseInt(carrerasAltas[5]), parseInt(carrerasAltas[6]));
                        drawChartCarrerasLiberaciones(parseInt(carrerasLiberaciones[0]), parseInt(carrerasLiberaciones[1]), parseInt(carrerasLiberaciones[2]), parseInt(carrerasLiberaciones[3]), parseInt(carrerasLiberaciones[4]), parseInt(carrerasLiberaciones[5]), parseInt(carrerasLiberaciones[6]));
                        contruyeTablaCarreras(parseInt(carrerasAltas[0]), parseInt(carrerasAltas[1]), parseInt(carrerasAltas[2]), parseInt(carrerasAltas[3]), parseInt(carrerasAltas[4]), parseInt(carrerasAltas[5]), parseInt(carrerasAltas[6])
                                , parseInt(carrerasLiberaciones[0]), parseInt(carrerasLiberaciones[1]), parseInt(carrerasLiberaciones[2]), parseInt(carrerasLiberaciones[3]), parseInt(carrerasLiberaciones[4]), parseInt(carrerasLiberaciones[5]), parseInt(carrerasLiberaciones[6]));

                    });
                }
            </script>

    </body>
</html>
