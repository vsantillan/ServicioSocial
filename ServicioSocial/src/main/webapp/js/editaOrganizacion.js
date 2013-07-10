$(document).ready(listo);
var retroalimentacionProyecto = {};
var tabla = {};

function borrarFila()
{
    alert(tabla[2]);
    $("form#MyForm :input").each(function()
    {

    });
}

function listo()
{
    $('.borrarProyecto').on('click', function()
    {
        enviarDatosProyecto();
    });

    $('.borrarInstancia').on('click', function()
    {
        enviarDatosInstancia();
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
    borrarFila();
    window.parent.Shadowbox.close();
    //    return false;
}

function preparaJSON($atributo)
{
    if ($atributo.attr("type") !== "submit")
    {
        retroalimentacionProyecto[$atributo.attr("path")] = $atributo.val();
    }
}

function enviarDatosInstancia()
{
    $("form#MyForm :input").each(function()
    {
        preparaJSON($(this));
    });

    $.post("borrarInstancia.do", retroalimentacionProyecto, function(respuesta) {
        alert(respuesta);
        console.log(respuesta);
    });
    window.onload = cargarContenido("administrarOrganizaciones.do");
    alert("se recargo la tabla de instancias");
    window.parent.Shadowbox.close();
//    return false;
}
