/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var row = "";
var idUpdate = "";
var tabla = "";

$(document).on('click', ".editUser", updateUser);

function updateUser(e)
{
    if (confirm('\u00BFSeguro que desea aprobar esta organización?'))
    {
        var row = $(this).parents('tr')[0];
        var idUpdate = $(e.target).attr('ide');
        var tabla = $('.example').dataTable();
        $.post("addUsuariosAdmin.do", {id: idUpdate}, function(response) {
            if (response === "ok")
            {
                tabla.fnDeleteRow(row);
                $("#div-user").show('slow');
                setTimeout(function() {
                    $("#div-user").hide('slow');
                }, 3000);
            } else {
                alert("Imposible aceptar Instancia. ERROR Interno");
            }
        });
    }
}