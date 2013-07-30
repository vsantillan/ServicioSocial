

$(document).on('click', ".editOrg", updateOrganisation);
$(document).on('click', ".editProy", updateProyecto);
//$(document).on('click', ".enviarRetro", enviaDatos);
$(document).ready(retroalimentacion);






function updateProyecto(e) {
    var row = $(this).parents('tr')[0];
    var idUpdate = $(e.target).attr('ide');
    var tabla = $('#example').dataTable();
    tabla.fnDeleteRow(row);
    alert("Este es el update" + idUpdate);
    //ajax(idUpdate);
    $.post("updateProyecto.do", {id: idUpdate}, function(response) {
        //alert("Ya hizo el update");
    });
}


function updateOrganisation(e) {
    var row = $(this).parents('tr')[0];
    var idUpdate = $(e.target).attr('ide');
    var tabla = $('#example').dataTable();
    tabla.fnDeleteRow(row);
    $.post("updateStatus.do", {id: idUpdate}, function(response) {
  
    });
}

function retroalimentacion() {
    $(".mandaRetro").click(function() {
        $("input#nombre").attr("value", $(this).attr("nombre"));
        $("input#nombreProyecto").attr("value", $(this).attr("nombreProyecto"));
        $("input#correo").attr("value", $(this).attr("correo"));
        $("input#idI").attr("value", $(this).attr("idO"));

    });





}

function enviaDatos() {
//    alert("work it");
  //  var tabla = $('#example').dataTable();
 //   tabla.fnDeleteRow(row);
//    var str = $("#MyForm").serialize();
//    console.log(str);
//    $.post("borrarOrganizacion.do", {id: "1", descripcion: "ola k ase", correo: "roy_006@hotmail.com"}, function(response) {
//        alert("Ya mando Post: " + response);
//    });


}





