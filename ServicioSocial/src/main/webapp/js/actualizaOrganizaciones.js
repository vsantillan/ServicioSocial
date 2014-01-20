

$(document).on('click', ".editOrg", updateOrganisation);
$(document).on('click', ".editProy", updateProyecto);
$(document).on('click', ".cambiaStatusInstancia", editarStatusInstancia);
$(document).on('click', ".cambiaStatusProyecto", editarStatusProyecto);
$(document).ready(retroalimentacion);

function editarStatusInstancia(e)
{
    if (confirm('¿Seguro que desea eliminar instancia?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("cambiaStatusInstancia.do", {id: idUpdate}, function(response)
        {
            tabla.fnDeleteRow(row);
        });
    }
}

function editarStatusProyecto(e)
{
    if (confirm('¿Seguro que desea eliminar proyecto?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("cambiaStatusProyecto.do", {id: idUpdate}, function(response)
        {
            tabla.fnDeleteRow(row);
        });
    }
}

function updateProyecto(e)
{
    if (confirm('¿Seguro que desea aprobar el proyecto?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("updateProyecto.do", {id: idUpdate}, function(response) {
            tabla.fnDeleteRow(row);
            $("#div-validar-proyecto").show('slow')
            setTimeout(function() {
                $("#div-validar-proyecto").hide('slow')
            }, 3000)
        });
    }
}


function updateOrganisation(e)
{
    if (confirm('¿Seguro que desea aprobar esta organizacion?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("updateStatus.do", {id: idUpdate}, function(response) {
            tabla.fnDeleteRow(row);
            $("#div-validar-organizacion").show('slow')
            setTimeout(function() {
                $("#div-validar-organizacion").hide('slow')
            }, 3000)
        });
    }
}

function retroalimentacion() {
    $(".mandaRetro").click(function() {
        $(".error").hide('hide');
        $("input#nombre").attr("value", $(this).attr("nombre"));
        $("input#nombreProyecto").attr("value", $(this).attr("nombreProyecto"));
        $("input#correo").attr("value", $(this).attr("correo"));
        $("input#idI").attr("value", $(this).attr("idO"));
    });
}

function validarForm(formulario) {

  if(formulario.descripcion.value.length===0) { //comprueba que no esté vacío   
    $(".error").show('slow'); 
    return false; //devolvemos el foco
  }
  return true;
}