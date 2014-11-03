/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('.mustraNoticiaCompleta').click(function() {
        var idNoticia = $(this).attr("idNoticia");
        console.log("idNoticia: " + idNoticia);
        $.post("mostrarNoticiaCompleta.do", {idNoticia: idNoticia}, function(respuesta) {
            console.log(respuesta);
            $('#titulo').text(respuesta.titulo);
            $('#detalleNoticia').html(respuesta.detalle);

        });
    });

    $("FechaNoticias label").each(function(index) {
        alert();
    });

});

