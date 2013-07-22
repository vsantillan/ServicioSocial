

$(document).on('click', ".editOrg", updateOrganisation);
$(document).on('click', ".editProy", updateProyecto);
//$(document).on('click', ".redir", reloadPage);





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
    //ajax(idUpdate);
    $.post("updateStatus.do", {id: idUpdate}, function(response) {
        alert("Ya hizo el update");
    });
}
function reloadPage(e) {
    $('body').attr("ide","sss");
    alert("asd");
    //url = "http://taller-de-scripts.com.ar";
    //$(location).attr('href',url);
    //document.location.href = "http://www.miweb.com/Compra/PanelControl.aspx";
     //  window.parent.Shadowbox.close();
    //alert("Ya la hiciste");
}






