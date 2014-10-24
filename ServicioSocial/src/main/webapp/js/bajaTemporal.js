$(document).on('click', ".generarBaja", generarBaja);
$(document).on('click', ".quitaBaja", quitarBaja);
$(document).on('click', ".actualizaInstancia", actualizaInstancia);
$(document).on('click', ".actualizaInput", actualizaInput);
$(document).on('click', ".guardarBaja", guardaBaja());

function generarBaja() {
    $(".error").hide('hide');
    $("#fechaBaja").val("");
    $("#fechaLimiteBaja").val("");
    $("input#idDatosPer").attr("value", $(this).attr("idP"));

}

function validarForm(formulario) {
    var fechaBajas = formulario.fechaBaja.value;
    var arrayFechaInicioBaja = fechaBajas.split('-');
    var fechaInicioBaja = new Date(arrayFechaInicioBaja[2], arrayFechaInicioBaja[1] - 1, arrayFechaInicioBaja[0]);
    var fechaLimiteBajas = formulario.fechaLimiteBaja.value;
    var arrayFechaBajaMax = fechaLimiteBajas.split('-');
    var fechaBajaMax = new Date(arrayFechaBajaMax[2], arrayFechaBajaMax[1] - 1, arrayFechaBajaMax[0]);
//    alert("Fecha Inicio: " + fechaInicioBaja.toLocaleString() + " Fecha Fin: " + fechaBajaMax.toLocaleString());

    if (formulario.fechaBaja.value.length === 0 || formulario.fechaLimiteBaja.value.length === 0) { //comprueba que no esté vacío
        $("div#erroresFechas").html("<p>Complete los campos Solicitados</p>");
        $(".error").show('slow');
        return false;

    }
    if (fechaInicioBaja > fechaBajaMax) {
        $("div#erroresFechas").html("<p>La fecha Maxima debe de ser mayor a la fecha de Inicio </p>");
        $(".error").show('slow');
        return false;
    }
    if (fechaInicioBaja.toLocaleString() === fechaBajaMax.toLocaleString()) {
        $("div#erroresFechas").html("<p>La fecha Maxima no puede ser igual a la fecha de Inicio </p>");
        $(".error").show('slow');
        return false;

    }
    alert("La baja fue asignada exitosamente (al parecer)");
    return true;
}

function quitarBaja() {
    if (confirm('\u00BFSeguro que desea retirar la Baja Temporal?'))
    {
        var idUpdate = $(this).attr('idPer');
        $.post("quitaBaja.do", {id: idUpdate}, function(response)
        {
            alert("Se retiro la baja exitosamente");
            url = "administrarBajas.do";
            $(location).attr('href', url);
        });
    }
}

function dameProyectos() {
    var id = $("#nuevaInstancia option:Selected").val();
    var str = str + "&idInstancia=" + id;
    if (id !== "NA")
        $.post("dameProyectos.do", str, function (respuesta) {
            $("#proyectosInstancia").empty();
            if (respuesta !== "")
                $("#proyectosInstancia").append(respuesta);
            else
                $("#proyectosInstancia").append("<option value='NA' selected='selected'>No hay proyectos para esta instancia</option>");
        });
}

function actualizaInstancia() {
    var OK = true;
    if ($("#nuevaInstancia option:Selected").val() === "NA") {
        $('.error').show("slow").delay(2500).hide("slow");
        $('.error').html("<p>Seleccione una nueva Instancia para el alumno</p>");
        OK = false;
    }
    if ($("#proyectosInstancia option:Selected").val() === "NA") {
        $('.error').show("slow").delay(2500).hide("slow");
        $('.error').html("<p>Seleccione un nuevo proyecto para el alumno </p>");
        OK = false;
    }
    if (OK) {
        alert("Se actualizo correctamente la informaci\u00f3n");
        $("#actulizaInstancia").submit();
    }
}

function actualizaInput() {
    $("#idFormatoUnico").val($(this).attr("idP"));
}

function guardaBaja()
{
    var fechaBaja = $("#fechaBaja").val();
    var fechalimiteBaja = $("#fechaLimiteBaja").val();
    alert(fechaBaja);
    alert(fechalimiteBaja);
}