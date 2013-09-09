$(document).on('click', ".cambiaStatusLugar", updateLugar);
$(document).on('click', ".editLugar", loadLugar);
$(document).on('click', "#envioB", alterLugar);

var id_e;

function loadLugar(e)
{
    var row = $(this).parents('tr')[0];
    var lugar = $(e.target).attr('id');
    id_e = $(e.target).attr('ide');
    $("#lugar_s").val(lugar);
}

function alterLugar(e)
{
    var nuevo_val = $("#lugar_s").val();
    $.post("editarLugar1.do", {id: id_e , lugar_s:nuevo_val});
}

function clearLugar(e)
{
    $("#lugar").val("");
}

function updateLugar(e)
{
    if (confirm('¿Seguro que desea eliminar instancia?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("cambiaStatusLugar.do", {id: idUpdate}, function(response)
        {
            tabla.fnDeleteRow(row);
        });
    }
}