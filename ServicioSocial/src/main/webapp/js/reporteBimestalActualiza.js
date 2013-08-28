$(document).on('click', ".aceptarReporte", aceptarReporteA);
$(document).on('click', ".rechazaReporte", rechazaReporte);
$(document).on('click', ".editarReporte", editarReporte);

$(document).ready(retroalimentacion);

function rechazaReporte(e)
{
    if (confirm('¿Seguro que desea aprobar el proyecto?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var idStatus = $(e.target).attr('status');
        var tabla = $('#NoRev').dataTable();
        $.post("actualizarStatusReporte.do", {id: idUpdate,status:idStatus}, function(response) 
        {
            tabla.fnDeleteRow(row);
        });
    }
}

function editarReporte(e)
{
    if (confirm('¿Seguro que desea aprobar el proyecto?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var idStatus = $(e.target).attr('status');
        var tabla = $('#NoRev').dataTable();
        $.post("actualizarStatusReporte.do", {id: idUpdate,status:idStatus}, function(response) 
        {
            tabla.fnDeleteRow(row);
        });
    }
}

function aceptarReporteA(e)
{
    if (confirm('¿Seguro que desea aprobar este reporte?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var idStatus = $(e.target).attr('status');
        var tabla = $('#NoRev').dataTable();
        $.post("aceptarReporte.do", {id: idUpdate,status:idStatus}, function(response) 
        {
            tabla.fnDeleteRow(row);
            $("#div-aceptar-reporte").show('slow');
            setTimeout(function() 
            {
                $("#div-aceptar-reporte").hide('slow');
            }, 3000);
        });
    }
    
}

function retroalimentacion() {
    $(".mandaRetro").click(function() {
        $("input#nombre").attr("value", $(this).attr("nombre"));
        $("input#status").attr("value", $(this).attr("status"));
        $("input#idReporte").attr("value", $(this).attr("idReporte"));
        $("input#correo").attr("value", $(this).attr("correo"));
    });
}