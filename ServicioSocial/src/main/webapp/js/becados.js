/* 
 * Funciones del modulo de becados
 */

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

            });
        }
    });
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
    console.log(alumno);
    if (alumno.length === 0)
    {
        alert("No se selecciono ningun alumno");
    }
    else
    {
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

<<<<<<< HEAD
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
                alert(respuesta);

            });
        }

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

function contar() {

    var checkboxes = form1.alumno; //Array que contiene los checkbox
    var cont = 0; //Variable que lleva la cuenta de los checkbox pulsados
    for (var x = 0; x < checkboxes.length; x++) {
        if (checkboxes[x].checked) {
            cont = cont + 1;
        }
    }
    alert("El número de alumnos seleccionados es: " + cont);

}


  