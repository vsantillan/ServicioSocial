var row="";
var idUpdate="";
var tabla="";
var tipo2 = "";
var estatus = "";

$(document).on('click', ".editOrg", updateOrganisation);
$(document).on('click', ".editProy", updateProyecto);
$(document).on('click', ".cambiaStatusInstancia", rechazarInstancia);
$(document).on('click', ".cambiaStatusProyecto", rechazarProyecto);
$(document).on('click', ".mandaObservacionesInstancia", cambiarEstadoInstancia);
$(document).ready(listo);

function cambiarEstadoInstancia(e)
{
    if (confirm('\u00BF'+'Seguro que desea eliminar instancia?'))
    {
        idUpdate = $(this).attr('idO');
        tipo2 = "0";
        mostrarDIVMotivos();
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
             if(response==="ok")
            {
                tabla.fnDeleteRow(row);
                $("#div-validar-organizacion").show('slow');
                setTimeout(function() {
                    $("#div-validar-organizacion").hide('slow');
                }, 3000);
            }else{
                alert("Imposible aceptar Instancia. ERROR Interno");
            }
        });
    }
}

function listo() {
    $(document).on("click", "#guardarObservacionesInstancia", obtenerDatosInstancia);
    $(document).on("click", "#guardarObservacionesProyecto", obtenerDatosProyecto);
}

function rechazarInstancia(e)
{
    if (confirm('\u00BF'+"Seguro que desea eliminar la Instancia?"))
    {
        row = $(this).parents('tr')[0];
        idUpdate = $(e.target).attr('ide');
        tabla = $('#example').dataTable();
        tipo2 = "2"; //el estatus de validacion de administrador para rechazado es 2
        estatus = "0"; //0:Organizacion eliminada
        mostrarDIVMotivos();
    }

}

function rechazarProyecto(e)
{
    if (confirm('\u00BF'+"Seguro que desea eliminar el Proyecto?"))
    {
        row = $(this).parents('tr')[0];
        idUpdate = $(e.target).attr('ide');
        tabla = $('#example').dataTable();
        tipo2 = "2";  //el estatus de validacion de administrador para rechazado es 2
        estatus = "0"; // 0:Proyecto eliminado
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
        $.post("cambiaStatusInstancia.do", {id: idUpdate,status: estatus,val_admin:tipo2, observaciones: array}, function(respuesta)
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

function obtenerDatosProyecto()
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
        $.post("cambiaStatusProyecto.do", {id: idUpdate,status: estatus,val_admin:tipo2, observaciones: array}, function(respuesta)
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