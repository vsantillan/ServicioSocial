
function actualizaFecha(fechaInicio) {
    // Obtenemos la Fecha
    var fecha = fechaInicio.value;
    alert(fecha);
    var arrayFecha = fecha.split('-');
    var anio = arrayFecha[0];
    var mes = arrayFecha[1] - 1;
    var dia = arrayFecha[2];
    var final = new Date(anio, mes, dia);
    final.setMonth(final.getMonth() + 2);

    //FORMATEANDO LA FECHA

    var fechaEntrega = final.toLocaleDateString();
    var arrayFechaFinal = fechaEntrega.split('/');
    
    if (arrayFechaFinal[1] < 10)
        arrayFechaFinal[1] = '0' + arrayFechaFinal[1];
    if (arrayFechaFinal[0] < 10)
        arrayFechaFinal[0] = '0' + arrayFechaFinal[0];
    
    document.reportesBimestrales.fechaFin.defaultValue = arrayFechaFinal[2] + "-" + arrayFechaFinal[1] + "-" + arrayFechaFinal[0];


}
