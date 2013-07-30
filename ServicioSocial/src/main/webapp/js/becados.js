/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#tabs").tabs();
    $('#NoAceptados').dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers",
        "sScrollX": "100%",
        "sScrollXInner": "200%",
        "bScrollCollapse": true,
        "bDestroy": true


    });
    $('#Aceptados').dataTable({
        "bJQueryUI": true,
        "sPaginationType": "full_numbers",
        "sScrollX": "100%",
        "sScrollXInner": "200%",
        "bScrollCollapse": true,
        "bDestroy": true

    });
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
                alert(respuesta);

            });
        }

    });
//    $('#sb-nav-close').click(function() {

//    $(".seleccionar").click(function() {
//
//        $("input:checkbox").attr('checked', true);
//        $("input[type=checkbox]").attr('checked', true);
//    });
//    $(".desseelcionar").click(function() {
//
//        $("input:checkbox").attr('checked', false);
//        $("input[type=checkbox]").attr('checked', false);
//    });
});


  