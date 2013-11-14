$(document).on('click', ".generarBaja", generarBaja);
$(document).on('click', ".quitaBaja", quitarBaja);

function generarBaja() {
    $(".error").hide('hide');
    $("#fechaBaja").val("");
    $("#fechaLimiteBaja").val("");
    $("input#idDatosPer").attr("value", $(this).attr("idP"));

}

function validarForm(formulario) {
    var fechaBajas = formulario.fechaBaja.value;
    var arrayFechaInicioBaja = fechaBajas.split('-');
    var fechaInicioBaja = new Date(arrayFechaInicioBaja[0], arrayFechaInicioBaja[1], arrayFechaInicioBaja[2]);

    var fechaLimiteBajas = formulario.fechaLimiteBaja.value;
    var arrayFechaBajaMax = fechaLimiteBajas.split('-');
    var fechaBajaMax = new Date(arrayFechaBajaMax[0], arrayFechaBajaMax[1], arrayFechaBajaMax[2]);

    if (fechaInicioBaja > fechaBajaMax) {
        $("div#erroresFechas").html("<p>La fecha Maxima debe de ser mayor a la fecha de Inicio </p>");
        $(".error").show('slow');
        return false;

    }

    if (formulario.fechaBaja.value.length === 0 || formulario.fechaLimiteBaja.value.length === 0) { //comprueba que no esté vacío   
        $("div#erroresFechas").html("<p>Complete los campos Solicitados</p>");
        $(".error").show('slow');
        return false;

    }
    return true;
}

function quitarBaja() {
    if (confirm('¿Seguro que desea retirar la Baja Temporal?'))
    {
        var idUpdate = $(this).attr('idPer');
        $.post("quitaBaja.do", {id: idUpdate}, function(response)
        {
            url = "administrarBajas.do";
            $(location).attr('href',url);
        });
    }
}


