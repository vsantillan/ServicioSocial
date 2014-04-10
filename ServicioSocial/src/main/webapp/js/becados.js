/* 
 * Funciones del modulo de becados
 */

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
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
>>>>>>> parent of ae53da8... algo

        });
    }
});
$('#enviarCorreo').click(function() {
    var alumno = [];
    $("input[name='checkbox']:checked").each(function() {
        alumno.push($(this).val());
    });
<<<<<<< HEAD
    $('#enviarCorreo').click(function() {
        var alumno = [];
        $("input[name='checkbox']:checked").each(function() {
            alumno.push($(this).val());
=======
$('#aceptarAlumno').click(function() {
    var alumno = [];
    $("input[name='checkbox']:checked").each(function() {
        alumno.push($(this).val());
    });
=======
>>>>>>> parent of ae53da8... algo
    console.log(alumno);
    if (alumno.length === 0)
    {
        alert("No se selecciono ningun alumno");
    }
    else
    {
<<<<<<< HEAD
        $.post("aceptarAlumno.do", {'alumno': alumno}, function(respuesta) {
            location.reload();
          //  alert(respuesta);

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

>>>>>>> a10c6c3907278c50789f6b72a603095aaca73f19
=======
        $.post("enviarCorreo.do", {'alumno': alumno}, function(respuesta) {
            alert(respuesta);
>>>>>>> parent of ae53da8... algo
        });
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
});
$('#quitarAlumno').click(function() {
    var alumno = [];
    $("input[name='checkbox']:checked").each(function() {
        alumno.push($(this).val());
>>>>>>> parent of ae53da8... algo
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

<<<<<<< HEAD
    });
=======
});
$('#enviarcorreo1').click(function() {
    var alumno = [];
    $("input[name='checkbox']:checked").each(function() {
        alumno.push($(this).val());
    });
    var asunto = $( "#asunto" ).val();
    var descripcion=$( "#descripcion" ).val();
    if (alumno.length === 0 || asunto.length == 0 || descripcion.length == 0)
    {
        $( "#respuesta" ).addClass("alert alert-danger");
        $( "#respuesta" ).text( "Error todos los campos son requeridos o no se seleccionaron alumnos" ).show();
    }
    else
    {

        $.post("envioCorreoBecados.do", {'alumno': alumno,'asunto':asunto,'descripcion':descripcion}, function(respuesta) {
            $( "#respuesta" ).addClass("alert alert-succes");
            $( "#respuesta" ).text( "Enviado" ).show();
            location.reload();
          //  alert(respuesta);

        }); 
    }
    
//    console.log(alumno);
//    console.log(asunto);
//    console.log(descripcion);
});



$("#preseleccionados").submit(function(event) {
    parent.location.reload(true);
});
>>>>>>> a10c6c3907278c50789f6b72a603095aaca73f19
=======
});
//$('#aceptar').click(function() {
//    $("#preseleccionados").submit();
//
//});
$("#preseleccionados").submit(function(event) {
    parent.location.reload(true);
});
>>>>>>> parent of ae53da8... algo

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


  