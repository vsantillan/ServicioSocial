/**
 * Funcionq ue actualiza los detalles de la platica en la vista selecciona
 * platica 
 */
$(document).ready(function() {
    $("#fecha").change(function(event) {
        var fecha = document.getElementById("fecha").value;
        $.post("actualizarDetalle.do", {fecha: fecha}, function(respuesta) {
            $('#hora').val(respuesta.hora);
            $('#lugar').val(respuesta.lugar);
            $('#descripcion').val(respuesta.descripcion);
        });

    });
});

