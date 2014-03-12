var row="";
var idUpdate="";
var tabla="";
var tipo2 = "";

$(document).ready(listo);

function aceptarReporteA(e)
{
    if (confirm('\u00BF'+'Seguro que desea aprobar este reporte?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var idStatus = $(e.target).attr('status');
        var tabla = $('#NoRev').dataTable();
        $.post("aceptarDocumentos.do", {id: idUpdate,status:idStatus}, function(response) 
        {
            if(response==="ok")
            {
                $("#div-validar-organizacion").show('slow');
                setTimeout(function() {
                    $("#div-validar-organizacion").hide('slow');
                }, 3000);
            }else{
                alert("Imposible aceptar Reporte. ERROR Interno");
            }
            window.location.reload();
        });
    }
    
}

function listo() {
    $(document).on('click', ".aceptarDocumentos", aceptarReporteA);
    $(document).on('click', ".mandaRetro", enviaObservaciones);
    $(document).on("click", "#guardarObservacionesDocumentos", obtenerObservacionesDocumentos);
}

function enviaObservaciones(e)
{
    if (confirm('\u00BF'+"Seguro que desea rechazar el Reporte?"))
    {
        row = $(this).parents('tr')[0];
        idUpdate = $(e.target).attr('ide');
        tabla = $('#example').dataTable();
        tipo2 = "2";
        mostrarDIVMotivos();
    }
}

function  mostrarDIVMotivos()
{
    $.fancybox(
            $("#motivos").html(), //fancybox works perfect with hidden divs
            {}
    );
}

function obtenerObservacionesDocumentos()
{
    var array = [];
    $("form#observacionesCat input").each(function() 
    {
        if ($(this).is(":checked"))
        {
            array.push($(this).attr("value")); // id de Obserbacion
        }
    });
    if (array.length > 0)
    {
        $('#guardarObservaciones').attr('disabled', true);
        $.post("rechazaDocumentos.do", {id: idUpdate,status: tipo2, observaciones: array}, function(respuesta)
        {
            if(respuesta==="ok")
            {
                alert("Reporte Rechazado");
                window.location.reload();
            }else{
                alert("ERROR: Imposible rechazar reporte.");
            }
            $('#guardarObservaciones').attr('disabled', false);
        });
    }else{
        alert('No se ha seleccionado Observación');
    }
}