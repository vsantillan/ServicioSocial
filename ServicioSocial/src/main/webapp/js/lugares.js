$(document).on('click', ".cambiaStatusLugar", updateLugar);
$(document).on('click', ".editLugar", loadLugar);
$(document).on('click', "#envioB", verificaLugar);
$(document).on('click', "#envioB1", verificaLugar1);

var id_e;

function loadLugar(e)
{
    var row = $(this).parents('tr')[0];
    var lugar = $(e.target).attr('id');
    id_e = $(e.target).attr('ide');
    $("#lugar_e").val(lugar);
    $("input#id").attr("value", id_e);
}

function verificaLugar(e) {
    $("#errorVacio").html("");
    var value = $("#lugar_e").val().trim();
    if (value.length > 0) {
        e.preventDefault();
        $.get("validaLugares.do?Lugar=" + value, null, function(respuesta) {
            if (respuesta === "OK")
                $("#editarLugar").submit();
            else{
                e.preventDefault();
                $("#errorVacio").html("<br><div class='alert alert-danger'>Lo sentimos ya existe un edificio con el nombre: '" + value + "'</div>");
            }
        });
    } else {
        e.preventDefault();
        $("#errorVacio").html("<div class='alert alert-danger'>El campo no puede estar vacio</div>");
    }
}

function verificaLugar1(e) {
    $("#errorVacio1").html("");
    var value = $("#lugar").val().trim();
    if (value.length > 0) {
        $.get("validaLugares.do?Lugar=" + value, function(respuesta) {
            if (respuesta === "OK")
                $("#envioB").submit();
            else{
                $("#errorVacio1").html("<br><div class='alert alert-danger'>Lo sentimos ya existe un edificio con el nombre: '" + value + "'</div>");
                e.preventDefault();
            }
        });
    } else {
        e.preventDefault();
        $("#errorVacio1").html("<br><div class='alert alert-danger'>El campo no puede estar vacio</div>");
    }
}

function alterLugar(e)
{
    var nuevo_val = $("#lugar_s").val();
    $.post("editarLugar1.do", {id: id_e, lugar_s: nuevo_val}, function(response)
    {

    });
}

function updateLugar(e)
{
    if (confirm('\u00BFSeguro que desea eliminar el lugar?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('#example').dataTable();
        $.post("cambiaStatusLugar.do", {id: idUpdate}, function(response)
        {
            row.remove();
        });
    }
}
