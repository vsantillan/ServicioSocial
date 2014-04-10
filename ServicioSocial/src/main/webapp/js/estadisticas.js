var data;
var chart;
google.load('visualization', '1', {'packages': ['corechart']});

function drawChartSexAltas(totalMasculino, totalFemenino, totalIndefinido) {
    if (validaInfoSexo(totalMasculino, totalFemenino, totalIndefinido, "sexoAltas", "altas por sexo")) {
        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
            ['Masculino', totalMasculino],
            ['Femenino', totalFemenino],
            ['Indefinido', totalIndefinido]
        ]);

        var options = {'title': 'Sexo (Altas)',
            'width': 400,
            'height': 300};
        chart = new google.visualization.PieChart(document.getElementById('sexoAltas'));
        chart.draw(data, options);
    }
}
function drawChartSexLiberaciones(totalMasculino, totalFemenino, totalIndefinido) {
    if (validaInfoSexo(totalMasculino, totalFemenino, totalIndefinido, "sexoLiberaciones", "liberaciones por sexo")) {

        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
            ['Masculino', totalMasculino],
            ['Femenino', totalFemenino],
            ['Indefinido', totalIndefinido]
        ]);

        var options = {'title': 'Sexo (Liberaciones)',
            'width': 400,
            'height': 300};
        chart = new google.visualization.PieChart(document.getElementById('sexoLiberaciones'));
        chart.draw(data, options);
    }
}

function validaInfoSexo(val1, val2, val3, contenedor, mensaje) {
    if (val1 === 0 && val2 === 0 && val3 === 0) {
        document.getElementById(contenedor).innerHTML = "";
        var node = "<div class='alert alert-warning col-md-9 col-md-offset-1'>\n\
                    <div class='alert-heading '><h4 class='text-center'><span class='glyphicon glyphicon-info-sign'></span>&nbsp;Lo sentimos aun no contamos con informaci&oacuten suficiente para calcular estadisticos para " + mensaje + ".</h4></div>\n\
                </div>";
        document.getElementById(contenedor).innerHTML += "<br>" + node;
        return false;

    }
    return true;
}

function drawChartCarrerasAltas(carrera1, carrera2, carrera3, carrera4, carrera5, carrera6, carrera7) {
    if (validaInfoCarreras(carrera1, carrera2, carrera3, carrera4, carrera5, carrera6, carrera7, "carrerasAltas", "altas por carrera")) {
        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
            ['Ing. Quimica', carrera1],
            ['Ing. Industrial', carrera2],
            ['Ing. Electromecanica', carrera3],
            ['Ing. Mecatronica', carrera4],
            ['Lic. Administracion', carrera5],
            ['Ing. Electronica', carrera6],
            ['Ing. Sistemas Computacioneles', carrera7]
        ]);

        var options = {'title': 'Carreras (Altas)',
            'width': 400,
            'height': 300};
        chart = new google.visualization.PieChart(document.getElementById('carrerasAltas'));
        chart.draw(data, options);
    }

}

function drawChartCarrerasLiberaciones(carrera1, carrera2, carrera3, carrera4, carrera5, carrera6, carrera7) {

    if (validaInfoCarreras(carrera1, carrera2, carrera3, carrera4, carrera5, carrera6, carrera7, "carrerasLiberaciones", "liberaciones por carrera")) {
        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
            ['Ing. Quimica', carrera1],
            ['Ing. Industrial', carrera2],
            ['Ing. Electromecanica', carrera3],
            ['Ing. Mecatronica', carrera4],
            ['Lic. Administracion', carrera5],
            ['Ing. Electronica', carrera6],
            ['Ing. Sistemas Computacioneles', carrera7]
        ]);

        var options = {'title': 'Carreras (Liberaciones)',
            'width': 400,
            'height': 300};
        chart = new google.visualization.PieChart(document.getElementById('carrerasLiberaciones'));
        chart.draw(data, options);
    }

}

function validaInfoCarreras(val1, val2, val3, val4, val5, val6, val7, contenedor, mensaje) {
    if (val1 === 0 && val2 === 0 && val3 === 0 && val4 === 0 && val5 === 0 && val6 === 0 && val7 === 0) {
        document.getElementById(contenedor).innerHTML = "";
        var node = "<div class='alert alert-warning col-md-9 col-md-offset-1'>\n\
                    <div class='alert-heading '><h4 class='text-center'><span class='glyphicon glyphicon-info-sign'></span>&nbsp;Lo sentimos aun no contamos con informaci&oacuten suficiente para calcular estadisticos para " + mensaje + ".</h4></div>\n\
                </div>";
        document.getElementById(contenedor).innerHTML += "<br>" + node;
        return false;

    }
    return true;
}

function drawChartProgramas(respuesta) {

    if (validaInfoProgramas(respuesta, "programasAltas", "Altas por Programa")) {
        var programasNombre = new Array();
        var totalProgramas = new Array();

        var programas = respuesta.split('&');
        for (var i = 0; i < programas.length; i++) {
            var programasConteo = programas[i].split("|");
            programasNombre[i] = programasConteo[0];
            totalProgramas[i] = programasConteo[1];
        }
        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Programas');
        data.addColumn('number', 'Total');
        data.addRows(programas.length - 1);
        for (var i = 0; i < programas.length - 1; i++) {
            data.setValue(i, 0, programasNombre[i]);
            data.setValue(i, 1, totalProgramas[i]);
        }


        var options = {'title': 'Programas (Altas)',
            'width': 400,
            'height': 300};
        chart = new google.visualization.PieChart(document.getElementById('programasAltas'));
        chart.draw(data, options);
    }
}

function drawChartProgramasLiberaciones(respuesta) {
    if (validaInfoProgramas(respuesta, "programasLiberaciones", "liberaciones por programa")) {

        var programasNombre = new Array();
        var totalProgramas = new Array();

        var programas = respuesta.split('&');
        for (var i = 0; i < programas.length; i++) {
            var programasConteo = programas[i].split("|");
            programasNombre[i] = programasConteo[0];
            totalProgramas[i] = programasConteo[1];
        }
        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Programas');
        data.addColumn('number', 'Total');
        data.addRows(programas.length - 1);
        for (var i = 0; i < programas.length - 1; i++) {
            data.setValue(i, 0, programasNombre[i]);
            data.setValue(i, 1, totalProgramas[i]);
        }


        var options = {'title': 'Programas (Altas)',
            'width': 400,
            'height': 300};
        chart = new google.visualization.PieChart(document.getElementById('programasAltas'));
        chart.draw(data, options);
    }
}

function validaInfoProgramas(cadena, contenedor, mensaje) {
    if (cadena === "") {
        document.getElementById(contenedor).innerHTML = "";
        var node = "<div class='alert alert-warning col-md-9 col-md-offset-1'>\n\
                    <div class='alert-heading '><h4 class='text-center'><span class='glyphicon glyphicon-info-sign'></span>&nbsp;Lo sentimos aun no contamos con informaci&oacuten suficiente para calcular estadisticos para " + mensaje + ".</h4></div>\n\
                </div>";
        document.getElementById(contenedor).innerHTML += "<br>" + node;
        return false;

    }
    return true;
}

function construyeTabla(respuesta) {

    var tabla = "";
    var totalAltas = 0;
    var totalLiberaciones = 0;

    var programas = respuesta.split('&');
    for (var i = 0; i < programas.length - 1; i++) {
        tabla += "<tr>";
        var programasConteo = programas[i].split("|");
        tabla += "<td>" + programasConteo[0] + "</td>";
        var programasLiberados = programasConteo[1].split('%');
        tabla += "<td>" + programasLiberados[1] + "</td>";
        tabla += "<td>" + programasLiberados[0] + "</td>";
        tabla += "</tr>";
        totalAltas = totalAltas + parseInt(programasLiberados[1]);
        totalLiberaciones = totalLiberaciones + parseInt(programasLiberados[0]);
    }
    tabla += "<tr><th>Total:</th><td>" + totalAltas + "</td><td>" + totalLiberaciones + "</td></tr>";
    return tabla;
}

function drawChartInstancias(respuesta) {
    if (validaInfoProgramas(respuesta, "instanciasAltas", "liberaciones por Instancia")) {
        var tabla = "";
        var totalAltas = 0;
        var pintarGragifa = false;

        var programasNombre = new Array();
        var totalProgramas = new Array();

        var programas = respuesta.split('&');
        for (var i = 0; i < programas.length - 1; i++) {
            var programasConteo = programas[i].split("|");
            programasNombre[i] = programasConteo[0];
            totalProgramas[i] = programasConteo[1];
            if (programasConteo[1] > 0)
                pintarGragifa = true;
            tabla += "<tr>";
            tabla += "<td>" + programasConteo[0] + "</td>";
            tabla += "<td>" + programasConteo[1] + "</td>";
            tabla += "</tr>";
            totalAltas = totalAltas + parseInt(programasConteo[1]);
        }
        // Create our data table.
        data = new google.visualization.DataTable();
        data.addColumn('string', 'Instancias');
        data.addColumn('number', 'Total');
        data.addRows(programas.length - 1);
        for (var i = 0; i < programas.length - 1; i++) {
            data.setValue(i, 0, programasNombre[i]);
            data.setValue(i, 1, totalProgramas[i]);
        }


        var options = {'title': 'Instancias (Altas)',
            'width': 400,
            'height': 300};

        if (pintarGragifa) {
            chart = new google.visualization.PieChart(document.getElementById('instanciasAltas'));
            chart.draw(data, options);
        }
        else {
            document.getElementById("instanciasAltas").innerHTML = "";
            var node = "<div class='alert alert-warning col-md-9 col-md-offset-1'>\n\
                    <div class='alert-heading '><h4 class='text-center'><span class='glyphicon glyphicon-info-sign'></span>&nbsp;Lo sentimos aun no contamos con informaci&oacuten suficiente para calcular estadisticos para altas por instancia.</h4></div>\n\
                </div>";
            document.getElementById("instanciasAltas").innerHTML += "<br>" + node;
        }
        tabla += "<tr><th>Total:</th><td>" + totalAltas + "</td></tr>";
        return tabla;
    }
}
function contruyeTablaSexo(sexoAltasM, sexoAltasF, sexoAltasI, sexoLiberacionesM, sexoLiberacionesF, sexoLiberacionesI) {
    var tabla = "";
    tabla += "<tr>";
    tabla += "<td>Femenino</td>";
    tabla += "<td>" + sexoAltasF + "</td>";
    tabla += "<td>" + sexoLiberacionesF + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Masculino</td>";
    tabla += "<td>" + sexoAltasM + "</td>";
    tabla += "<td>" + sexoLiberacionesM + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Indefinido</td>";
    tabla += "<td>" + sexoAltasI + "</td>";
    tabla += "<td>" + sexoLiberacionesI + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<th>Total:</th>";
    tabla += "<td>" + (parseInt(sexoAltasF) + parseInt(sexoAltasM) + parseInt(sexoAltasI)) + "</td>";
    tabla += "<td>" + (parseInt(sexoLiberacionesF) + parseInt(sexoLiberacionesM) + parseInt(sexoLiberacionesI)) + "</td>";
    tabla += "</tr>";

    $("#tablaSexo").empty();
    $("#tablaSexo").append(tabla);
}

function contruyeTablaCarreras(carrraAlta1, carrraAlta2, carrraAlta3, carrraAlta4, carrraAlta5, carrraAlta6, carrraAlta7, carrraLib1, carrraLib2, carrraLib3, carrraLib4, carrraLib5, carrraLib6, carrraLib7) {
    var tabla = "";
    tabla += "<tr>";
    tabla += "<td>Ing. Qu\u00edmica</td>";
    tabla += "<td>" + carrraAlta1 + "</td>";
    tabla += "<td>" + carrraLib1 + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Ing. Industrial</td>";
    tabla += "<td>" + carrraAlta2 + "</td>";
    tabla += "<td>" + carrraLib2 + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Ing. Electromec\u00e1nica</td>";
    tabla += "<td>" + carrraAlta3 + "</td>";
    tabla += "<td>" + carrraLib3 + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Ing. Mecatr\u00f3nica</td>";
    tabla += "<td>" + carrraAlta4 + "</td>";
    tabla += "<td>" + carrraLib4 + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Lic. en Administraci\u00f3n</td>";
    tabla += "<td>" + carrraAlta5 + "</td>";
    tabla += "<td>" + carrraLib5 + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<td>Ing. Electr\u00f3nica</td>";
    tabla += "<td>" + carrraAlta6 + "</td>";
    tabla += "<td>" + carrraLib6 + "</td>";
    tabla += "</tr>";
    tabla += "<td>Ing. en Sistemas Computacionales</td>";
    tabla += "<td>" + carrraAlta7 + "</td>";
    tabla += "<td>" + carrraLib7 + "</td>";
    tabla += "</tr>";
    tabla += "<tr>";
    tabla += "<tr>";
    tabla += "<th>Total:</th>";
    tabla += "<td>" + (carrraAlta1+carrraAlta2+carrraAlta3+carrraAlta4+carrraAlta5+carrraAlta6+carrraAlta7) + "</td>";
    tabla += "<td>" + (carrraLib1+carrraLib2+carrraLib3+carrraLib4+carrraLib5+carrraLib6+carrraLib7) + "</td>";
    tabla += "</tr>";

    $("#tablaCarreras").empty();
    $("#tablaCarreras").append(tabla);
}


