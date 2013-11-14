///////Con éste commit llego a los 100 :D :D
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
    $('#observaciones').hide("fast");
    $("form#frmNuevaSancion :input").each(function() {
        prepararJSON($(this));
    });
    sancion['tipo'] = 'nuevo';
    console.log(sancion.valueOf());
    $.post("nuevaSancion.do", sancion, function(respuesta) {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            alert('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
            });
        }
        else
        {
            alert('Informacion almacenada correctamente');
            location.reload();
        }
    });
}
function editarSancion2()
{
    console.log('aqui');
    $('#observaciones').hide("fast");
    var idSancion = $("#idSancion").val();
    var horas = $("#eHoras").val();
    var tolerancia = $("#eTolerancia").val();
    var descripcion = $("#eDescripion").val();
    $.post("nuevaSancion.do", {tipo: 'editar', idSancion: idSancion, horas: horas, tolerancia: tolerancia, descripcion: descripcion}, function(respuesta)
    {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            alert('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
            });
        }
        else
        {
            alert('Informacion almacenada correctamente');
//            location.reload();
            parent.location = parent.location;
        }
    });

}
function enviaPagoSancionParaGuardado()
{
    $('#observaciones').hide("fast");
    $("form#frmNuevoPagoSancion :input").each(function() {
        prepararJSON($(this));
    });
    sancion['tipo'] = 'nuevo';
    console.log(sancion.valueOf());
    $.post("nuevoPagoSancion.do", sancion, function(respuesta) {
        console.log(sancion.valueOf());
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            alert('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
            });
        }
        else
        {
            alert('Informacion almacenada correctamente');
            location.reload();
        }
    });
}
function edtitarPagoSancion()
{
    $('#observaciones').hide("fast");
    var idSancion = $("#pidSancion").val();
    var descripcion = $("#epDescripion").val();
    $.post("nuevoPagoSancion.do", {tipo: 'editar', idSancion: idSancion, descripcion: descripcion}, function(respuesta)
    {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            alert('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
            });
        }
        else
        {
            alert('Informacion almacenada correctamente');
//            location.reload();
            parent.location = parent.location;
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
function nuevaSancion(tipo) {
    var idDatosPersonales = $('#idDatosPersonales').val();
    var idSancion = $('#idSancion').val();
    var horas = $('#horas').val();
    if (tipo === 'pago')
    {
        horas = horas * (-1);
    }
    console.log('Se agregará una sanción con idDatosP=' + idDatosPersonales + ", con iDSancion=" + idSancion + ", y horas=" + horas);
    $.post("asignaSancion.do", {idDatosPersonales: idDatosPersonales, idSancion: idSancion, horas: horas}, function(respuesta) {
        alert(respuesta);
        location.reload();
    });
}
function quitaSancionAlumno(idSancion)
{
    $.post("quitaSancion.do", {idSancion: idSancion}, function(respuesta) {
        alert(respuesta);
        location.reload();
    });
}