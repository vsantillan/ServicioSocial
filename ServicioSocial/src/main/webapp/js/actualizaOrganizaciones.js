
$(document).on('click', ".edit", updateOrganisation);

function updateOrganisation(e) {
    var row=$(this).parents('tr')[0];
    var idUpdate = $(e.target).attr('ide');
    var tabla = $('#example').dataTable();
    tabla.fnDeleteRow(row);
    ajax(idUpdate);
    alert(idUpdate);

}
    function ajax(id){ 
           $.ajax({
                beforeSend: function() {

                },
                cache: false,
                type: "POST",
                dataType: "json",
                url: "OrganizacionesController.do",
                data: "&id=" + id,
                success: function(response) {
                    if (!response.respuesta) {
                        $('div#contenidoAjax').html('<p><span class="label label-important">Lo sentimos Ocurrio un error...Intente Nuevamente</span>');
                        alert(response.mensaje);
                    } else {
                        $('div#contenidoAjax').html('<p><span class="label label-success">Registro Guardado</span></p>');
                        $('#formUsers input[type="text"]').val('');
                        $('#formUsers textArea[type="text"]').val('');
                        if ($('#sinDatos').length)
                            $('#sinDatos').remove();

                        if ($('#accion').val() === 'updateUser')
                            $('#listaProductos').empty();

                        $('#listaProductos').append(response.contenido);
                    }
                },
                error: function() {
                    $('div#contenidoAjax').html('<p><span class="label label-important">Lo sentimos Ocurrio un error...Intente Nuevamente</span>');
                    alert('COLAPSO TODO');
                }

            });
    
    }