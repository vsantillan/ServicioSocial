/* 
 * Funciones del modulo de becados
 */

$('#aceptarAlumno').click(function() {
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
        $.post("aceptarAlumno.do", {'alumno': alumno}, function(respuesta) {
            location.reload();
            alert(respuesta);

        });
    }
});
$('#enviarCorreo').click(function() {
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
        $.post("enviarCorreo.do", {'alumno': alumno}, function(respuesta) {
            alert(respuesta);
        });
    }

});
$('#quitarAlumno').click(function() {
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
        $.post("quitarAlumno.do", {'alumno': alumno}, function(respuesta) {
            location.reload();
            // alert(respuesta);

        });
    }

});
//$('#aceptar').click(function() {
//    $("#preseleccionados").submit();
//
//});
$("#preseleccionados").submit(function(event) {
    parent.location.reload(true);
});

function contar() {

    var checkboxes = preseleccionados.alumno; //Array que contiene los checkbox
    var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados
    for (var x = 0; x < checkboxes.length; x++) {
        if (checkboxes[x].checked) {
            cont = cont + 1;
        }
    }
    alert("El numero de alumnos seleccionados es: " + cont);

}


  