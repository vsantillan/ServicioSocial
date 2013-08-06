$(document).on('click', ".borrarObservacion", borrarObservacion);
$(document).ready(listo);

function listo() {
    $(".actualizaObservacion").click(function() {
        $("textarea#descripcionE").text( $(this).attr("detalle"));
        $("input#id").attr("value", $(this).attr("idO"));
    });
}

function borrarObservacion(e) {
    
    var row = $(this).parents('tr')[0];
    var idDelete = $(e.target).attr('ide');
    var tabla = $('#example').dataTable();
    tabla.fnDeleteRow(row);
    alert("Este es el delete" + idDelete);
    //ajax(idUpdate);
   // $.post("deleteObservacion.do", {id: idDelete}, function(response) {
        //alert("Ya hizo el update");
   // });
}
