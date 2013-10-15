$(document).ready(listo);
var sancion = {};

function listo() {

    $(".editaSancion").click(function() {
        $("input#nombre").attr("value", $(this).attr("nombre"));
        $("input#nombreProyecto").attr("value", $(this).attr("nombreProyecto"));
        $("input#correo").attr("value", $(this).attr("correo"));
        $("input#idI").attr("value", $(this).attr("idO"));

    });
    
    $('#frmNuevaSancion').submit(enviaSancionParaGuardado);
}
function enviaSancionParaGuardado()
{
    alert('asdasd');
    $('#observaciones').hide("fast");
    $("form#frmNuevaSancion :input").each(function() {
        prepararJSON($(this));
    });
    $.post("nuevaSancion.do", sancion, function(respuesta) {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            console.log('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
            });
        }
        else
        {
            alert('Informacion almacenada correctamente');
        }
    });
}
function prepararJSON($atributo)
{
    if ($atributo.attr("type") !== "submit")
    {
        sancion[$atributo.attr("name")] = $atributo.val();
    }
    if ($atributo.attr("type") === "checkbox")
    {
        sancion[$atributo.attr("name")] = $("#" + $atributo.attr("name") + "1").is(":checked");
    }
}
