$(document).on('click', ".eliminarNoticia", eliminarNoticia);

function eliminarNoticia(e)
{
    if (confirm('\u00BFSeguro que desea eliminar la noticia?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        $.post("eliminarNoticia.do", {id: idUpdate}, function(response)
        {
           row.remove();
           //$(location).attr("href","consultaNoticias.do"); 
        });
    }
}


