/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var row = "";
var idUpdate = "";
var tabla = "";
var status = "";
var statusPass = "";



$( document ).ready(function() {
   
});

$(document).on("click", ".guardarObservacionesUsuario", observacionesUsuario);
$(document).on("click", ".cambiaStatusUsuario", cambiarEstadoUsuario);
$(document).on('click', ".editUser", updateUser);
$(document).on('click', ".GuardarDatosUsuarios", ActualizarUsuario);

function updateUser(e)
{
    if (confirm('\u00BFSeguro que desea aprobar este usuario?'))
    {
        row = $(this).parents('tr')[0];
        idUpdate = $(e.target).attr('ide');
        tabla = $('.example').dataTable();
        $.post("addUsuariosAdmin.do", {id: idUpdate}, function(response) {
            if (response === "ok")
            {
                tabla.fnDeleteRow(row);
                $("#div-user").show('slow');
                setTimeout(function() {
                    $("#div-user").hide('slow');
                }, 3000);
            } else {
                alert("Imposible aceptar Usuario. ERROR Interno");
            }
        });
    }
}

function cambiarEstadoUsuario(e)
{
    if (confirm('\u00BF' + 'Seguro que desea eliminar usuario?'))
    {
        idUpdate = $(this).attr('ide');
        Observaciones();
    }
}

function  Observaciones()
{
    $.fancybox(
            $("#motivosUsuario").html(), //fancybox works perfect with hidden divs
            {}
    );
}

function observacionesUsuario(event)
{
    var array = [];
    $("form#observacionesUsuario input").each(function()
    {

        if ($(this).is(":checked"))
        {
            array.push($(this).attr("value")); // id de Obserbacion
        }
    });


    if (array.length > 0)
    {
        $('#guardarObservaciones').attr('disabled', true);
        status = 2;

        $.post("downUser.do", {id: idUpdate, status: status, observaciones: array}, function(respuesta)
        {
            if (respuesta === "ok")
            {
                window.location.reload();
            } else {
                alert("ERROR: Imposible eliminar Usuario.");
                window.location.reload();
            }

            $('#guardarObservaciones').attr('disabled', false);
        });
    }
    else
    {
        alert('No se ha seleccionado observación');
    }
}
function ActualizarUsuario() {
   
    var tabActivo = $('#mantenerPassword').attr('class');
    if (tabActivo === 'active') {
        statusPass = 1;
    } else {
        statusPass = 2;
    }

    var nombre = $('#nombre').val();
    var apellidopat = $("#apellidopat").val();
    var apellidomat = $('#apellidomat').val();
    var email = $('#email').val();
    var telefono = $('#telefono').val();
    var extension = $('#extension').val();
    var puesto = $('#puesto').val();
    var password = $('#pass').val();


    $.post("updateUserData.do", {id: idUpdate, nombre: nombre, apellidopat: apellidopat, apellidomat: apellidomat, puesto: puesto, telefono: telefono, extension: extension, email: email, password: password, statusPass: statusPass}, function(respuesta)
    {
        alert('manda algo');
        if ('ok' === respuesta) {
//                        $.get("administrarUsuarios.do");      
            alert("usuario modificado");
        } else {
            window.location.reload();
        }


    });
}

function soloNumeros(e) {
    tecla = e.keyCode || e.which;
    if ((tecla > 64 && tecla < 91) || tecla === 192) {
        document.getElementById(e.target.id).value = "";
        $("#alertNumber").remove('div');
        $(document.getElementById(e.target.id)).after('<div class="row-fluid" id="alertNumber"><br><div class="alert alert-danger">Ingrese solo Numeros</div></div>');


    } else {
        $("#alertNumber").remove('div');
    }
}

function tamanoPass(e){
    var lenght = $(document.getElementById(e.target.id)).val().length;

    if (lenght >= 6) {        
        $("#alertPassword").remove('div');      
    }else{
         $("#alertPassword").remove('div');     
         $(document.getElementById(e.target.id)).after('<div class="row-fluid" id="alertPassword"><br><div class="alert alert-danger">La contrase&ntildea debe ser mayor a 6 caracteres</div></div>');
    }   
}   

function verificarPassword(e) {
    var passPrincipal=$("#passPrincipal").val();   
    var passSecundario = $(document.getElementById(e.target.id)).val();
    if(passPrincipal === passSecundario){
        $("#alertPasswordConfirm").remove('div'); 
    }else{
        $("#alertPasswordConfirm").remove('div'); 
       $(document.getElementById(e.target.id)).after('<div class="row-fluid" id="alertPasswordConfirm"><br><div class="alert alert-danger">La contrase&ntildea no coincide</div></div>');
    }   
}
