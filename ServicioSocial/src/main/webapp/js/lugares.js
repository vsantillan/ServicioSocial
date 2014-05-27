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
    if (value.length > 0 && ValidarCadenaExpReg(value)) {
        e.preventDefault();
        $.get("validaLugares.do?Lugar=" + value, null, function(respuesta) {
            if (respuesta === "OK")
                $("#editarLugar").submit();
            else {
                e.preventDefault();
                $("#errorVacio").html("<br><div class='alert alert-danger'>Lo sentimos ya existe un edificio con el nombre: '" + value + "'</div>");
            }
        });
    } else {
        e.preventDefault();
        $("#errorVacio").html("<div class='alert alert-danger'>El campo no puede estar vacio o no es valido</div>");
    }
}

function verificaLugar1(e) {
    $("#errorVacio1").html("");
    var value = $("#lugar").val().trim();
    if (value.length > 0 && ValidarCadenaExpReg(value)) {
        $.get("validaLugares.do?Lugar=" + value, function(respuesta) {
            if (respuesta === "OK")
                $("#envioB").submit();
            else {
                $("#errorVacio1").html("<br><div class='alert alert-danger'>Lo sentimos ya existe un edificio con el nombre: '" + value + "'</div>");
                e.preventDefault();
            }
        });
    } else {
        e.preventDefault();
        $("#errorVacio1").html("<br><div class='alert alert-danger'>El campo no puede estar vacio o no es v\u00E1lido</div>");
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
function ValidarCadenaExpReg(lugar) {

    cadena = /^[A-Za-z\u00E1\u00E9\u00ED\u00F3\u00FA\u00C1\u00C9\u00CD\u00D3\u00DA0-9-\s]*$/;
    if (lugar.match(cadena))
        return true;
    else
        return false;
}