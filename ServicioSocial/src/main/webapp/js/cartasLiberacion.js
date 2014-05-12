/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
   $(document).on('click', ".generaCartas", generaCartasLiberacion); 
});

function generaCartasLiberacion()
{
    var alumno = [];
    $("input[name='checkbox']:checked").each(function() {
        alumno.push($(this).val());
    });
    console.log(alumno);
    if (alumno.length === 0)
    {
        alert("No se selecciono ningun alumno");
    }
    else
    {
        $.post("generarCartasLiberacion.pdf", {'arrayAlumnos': alumno}, function(respuesta) {
            //location.reload();
            alert(respuesta);

        });
    }
    return false;
}


