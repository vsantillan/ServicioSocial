$(document).on('click', ".aceptarDocumentos", aceptarReporteA);
//$(document).on('click', ".enviarRetroalimentacion", enviaRetroalimentacion);

$(document).ready(retroalimentacion);

function enviaRetroalimentacion(e)
{
    if($(".d").val()==='')
    {
        $(".d").attr("style","border: 2px solid #990000;");
        $("#errorDescripcion").attr("style","display; block");
        return false;
        $(".d").attr("style","border: 1px solid");
        $("#errorDescripcion").attr("style","display; none");
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
        $.post("aceptarDocumentos.do", {id: idUpdate,status:idStatus}, function(response) 
        {
//            tabla.fnDeleteRow(row);
//            $("#div-aceptar-reporte").show('slow');
//            setTimeout(function() 
//            {
//                $("#div-aceptar-reporte").hide('slow');
//            }, 3000);
            window.location.reload();
            location.reload();
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