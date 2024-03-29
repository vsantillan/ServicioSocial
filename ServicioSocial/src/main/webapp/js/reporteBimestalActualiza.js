var idDatosPersonales = "";
var idReporte = "";
var idDocumento = "";
var tipo = "";
var status = "";

$(document).on("click", ".pideObservaciones", obtieneObservacionesReporteBimestral);
$(document).ready(listo);

function listo()
{
    $(document).on('click', ".aceptarReporte", aceptarReporteA);
    $(document).on("click", ".correccion", cambiarEstadoReporteCorreccion);
    $(document).on("click", "#guardarObservaciones", obtenerDatos);
}

function confirmacionEvento()
{
    if (!confirm('\u00BF' + "Desea realizar esta acci" + '\u00f3' + "n?"))
    {
        return false;
    }
    return true;
}

function  mostrarDIVMotivos()
{
    $.fancybox(
            $("#motivos").html(), //fancybox works perfect with hidden divs
            {}
    );
}

function enviaRetroalimentacion(e)
{
    if ($(".d").val() === '')
    {
        $(".d").attr("style", "border: 2px solid #990000;");
        $("#errorDescripcion").attr("style", "display; block");
        return false;
    }
}

function aceptarReporteA(e)
{
    if (confirm('\u00BFSeguro que desea aprobar este reporte?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var idStatus = $(e.target).attr('status');
        var idDoc = $(e.target).attr('idDoc');
        var tabla = $('#NoRev').dataTable();
        $.post("aceptarReporte.do", {id: idUpdate, status: idStatus, idDoc: idDoc}, function(response)
        {
            tabla.fnDeleteRow(row);
            $("#div-aceptar-reporte").show('slow');
            setTimeout(function()
            {
                $("#div-aceptar-reporte").hide('slow');
            }, 3000);
            window.location.reload();
        });
    }

}

function cambiarEstadoReporteCorreccion(event)
{
    if (confirmacionEvento())
    {
        idDatosPersonales = $(this).attr('idDP');
        idReporte = $(this).attr('idReporte');
        idDocumento = $(this).attr('idDoc');
        status = $(this).attr('status');
        tipo = "1";
        mostrarDIVMotivos();
    }

}

function obtenerDatos()
{
    var array = [];

    $("form#observacionesCat input").each(function() {

        if ($(this).is(":checked"))
        {
            array.push($(this).attr("value")); // id de Obserbacion
        }
    });


    if (array.length > 0)
    {

        $('#guardarObservaciones').attr('disabled', true);
        $.post("actualizarStatusReporte.do", {idDatoPersonales: idDatosPersonales, idReporte: idReporte, idDocumento: idDocumento, status: status, tipo: tipo, observaciones: array}, function(respuesta)
        {
            if (respuesta === "OK")
            {
                //$.fancybox.close();
                window.location.reload();
            } else
            {
                alert("Imposible Realizar Acción");
            }
            $('#guardarObservaciones').attr('disabled', false);
        }
        );
    }
    else
    {
        alert('No se ha seleccionado ninguna Observaci\u00f3n');
    }

}

function obtieneObservacionesReporteBimestral()
{
    var idAlu = $(this).attr('datospersonales');
    var observacionesDiv = $('#contenidoObservaciones');
    observacionesDiv.empty();
    var urlObtieneReportes = 'dameObservaciones.do?id=' + idAlu;

    $.get(urlObtieneReportes, function(response)
    {
        if (response.length > 0)
        {
            for (var i = 0; i < response.length; i++)
            {
                var observacionElem = '<li class="list-group-item text-center">'
                        + response[i]
                        + '</li>';
                observacionesDiv.append(observacionElem);
            }
        }
    });
}