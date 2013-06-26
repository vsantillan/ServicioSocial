$(document).ready(listo);
var idOrgnizacion = 0;
function listo()
{
    
    $('.borrar').click(enviarDatos);
}

function enviarDatos()
{   
    $.get($(this).attr("href"),null,function(respuesta){
        alert(respuesta);
    });
    return false;
}
