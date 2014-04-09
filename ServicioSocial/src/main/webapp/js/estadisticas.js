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
    tabla += "<tr><td>Total</td><td>" + totalAltas + "</td><td>" + totalLiberaciones + "</td></tr>";
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
        tabla += "<tr><td>Total</td><td>" + totalAltas + "</td></tr>";
        return tabla;
    }
}


