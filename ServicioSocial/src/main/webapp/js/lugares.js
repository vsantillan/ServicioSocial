$(document).on('click', ".cambiaStatusLugar", updateLugar);

function updateLugar(e)
{
    if (confirm('¿Seguro que desea eliminar instancia?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        alert(idUpdate);
        var tabla = $('#example').dataTable();
        $.post("cambiaStatusLugar.do", {id: idUpdate}, function(response)
        {
            tabla.fnDeleteRow(row);
        });
    }
}