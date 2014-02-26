var row="";
var idUpdate="";
var tabla="";

$(document).on('click', ".editOrg", updateOrganisation);
$(document).on('click', ".editProy", updateProyecto);
$(document).on('click', ".cambiaStatusInstancia", rechazarInstancia);
$(document).on('click', ".cambiaStatusProyecto", editarStatusProyecto);
$(document).ready(listo);

function editarStatusInstancia(e)
{
    if (confirm('\u00BF'+'Seguro que desea eliminar instancia?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("cambiaStatusInstancia.do", {id: idUpdate}, function(respuesta)
        {
            if(respuesta==="ok")
            {
                alert("Instancia eliminada");
                window.location.reload();
            }else{
                alert("ERROR: Imposible eliminar Instancia.");
            }
            
        });
    }
}

function editarStatusProyecto(e)
{
    if (confirm('\u00BFSeguro que desea eliminar proyecto?'))
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
    if (confirm('\u00BFSeguro que desea aprobar el proyecto?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('.example').dataTable();
        $.post("updateProyecto.do", {id: idUpdate}, function(response) {
            tabla.fnDeleteRow(row);
            $("#div-validar-proyecto").show('slow')
            setTimeout(function() {
                $("#div-validar-proyecto").hide('slow')
            }, 3000)
        });
    }
}
//
//
function updateOrganisation(e)
{
    if (confirm('\u00BFSeguro que desea aprobar esta organizacion?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('.example').dataTable();
        $.post("updateStatus.do", {id: idUpdate}, function(response) {
            tabla.fnDeleteRow(row);
            $("#div-validar-organizacion").show('slow')
            setTimeout(function() {
                $("#div-validar-organizacion").hide('slow')
            }, 3000)
        });
    }
}

function listo() {
    $(document).on("click", "#guardarObservacionesInstancia", obtenerDatosInstancia);
    $(document).on("click", "#guardarObservacionesProyecto", obtenerDatosPryecto);
}

function rechazarInstancia(e)
{
    if (confirm('\u00BF'+"Seguro que desea eliminar la Instancia?"))
    {
        row = $(this).parents('tr')[0];
        idUpdate = $(e.target).attr('ide');
        tabla = $('#example').dataTable();
        mostrarDIVMotivos();
    }

}
function cambiarEstadoFormatoRechazado(e)
{
    if (confirm('\u00BF'+"Seguro que desea eliminar la Instancia?"))
    {
        row = $(this).parents('tr')[0];
        idUpdate = $(e.target).attr('ide');
        tabla = $('#example').dataTable();
        mostrarDIVMotivos();
    }
}

function  mostrarDIVMotivos()
{
    $.fancybox(
            $("#motivos").html(), //fancybox works perfect with hidden divs
            {}
    );
}

function obtenerDatosInstancia()
{
    var array = [];
    $("form#observacionesCat input").each(function() 
    {
        if ($(this).is(":checked"))
        {
            array.push($(this).attr("value")); // id de Obserbacion
        }
    });
    if (array.length > 0)
    {
        $('#guardarObservaciones').attr('disabled', true);
        $.post("cambiaStatusInstancia.do", {id: idUpdate, observaciones: array}, function(respuesta)
        {
            if(respuesta==="ok")
            {
                alert("Instancia eliminada");
                window.location.reload();
            }else{
                alert("ERROR: Imposible eliminar Instancia.");
            }
            $('#guardarObservaciones').attr('disabled', false);
        });
    }else{
        alert('No se ha seleccionado Observación');
    }
}

function obtenerDatosPryecto()
{
    var array = [];
    $("form#observacionesCat input").each(function() 
    {
        if ($(this).is(":checked"))
        {
            array.push($(this).attr("value")); // id de Obserbacion
        }
    });
    if (array.length > 0)
    {
        $('#guardarObservaciones').attr('disabled', true);
        $.post("cambiaStatusProyecto.do", {id: idUpdate, observaciones: array}, function(respuesta)
        {
            if(respuesta==="ok")
            {
                alert("Instancia eliminada");
                window.location.reload();
            }else{
                alert("ERROR: Imposible eliminar Instancia.");
            }
            $('#guardarObservaciones').attr('disabled', false);
        });
    }else{
        alert('No se ha seleccionado Observación');
    }
}