$(document).ready(listo);
var retroalimentacionProyecto = {};
var retroalimentacionInstancia = {};

function listo()
{
    $('.borrarProyecto').on('click', function()
    {
        
    });

    $('.borrarInstancia').on('click', function()
    {
        alert("click");
    });
}

function enviarDatosProyecto()
{
    $("form#MyForm :input").each(function()
    {
        preparaJSON($(this));
    });

    $.post("borrarProyecto.do", retroalimentacionProyecto, function(respuesta)
    {
        alert(respuesta);
        console.log(respuesta);
    });
    window.parent.Shadowbox.close();
    //    return false;
}

function preparaJSON($atributo)
{
    if ($atributo.attr("type") !== "submit")
    {
        retroalimentacionProyecto[$atributo.attr("id")] = $atributo.val();
    }
}

function enviarDatosInstancia()
{
    $("form#MyForm :input").each(function()
    {
        preparaJSONInstancia($(this));
    });
    $.POST("borrarInstancia.do", retroalimentacionInstancia, function(respuesta) {
        alert(respuesta);
        console.log(respuesta);
    });
    //window.parent.Shadowbox.close();
//    return false;
}

function preparaJSONInstancia($atributo)
{
    if ($atributo.attr("type") !== "submit")
    {
        retroalimentacionInstancia[$atributo.attr("id")] = $atributo.val();
    }
}
