$(document).ready(listo);
var alumno = {};
var contacto = {};
var proyecto = {};
var tabActual;
var contentActual;
function listo()
{
    var foliodociden = $(".foliodociden");
    if (foliodociden.val() === '0')
    {
        foliodociden.val("");
    }

    cambiaTab();
    $(document).on("click", ".tabsFormanotUnico", cambiaTab);
    timePicker();//Inicializa campos JQuery
    $('#frmDatosPersonales').submit(enviarDatosAlumno);
    $('#frmDatosContacto').submit(enviarDatosContactoAlumno);
    $('#frmDatosOrganizaciones').submit(enviarDatosOrganizaciones);
    $('#frmHorarios').submit(enviarHorarios);

    $('#cmdDescargaFui').click(cambiaStatusSubidaFui);
//    $('#subeFui').click(subirFUI);

    $('.otraorg').click(function(event) {
        alert('ola ke ase');
    });

    $("#comboOrganizaciones").change(function(event) {
        var idInstancia = $("#comboOrganizaciones").val();
        recargaProyectos(idInstancia);

    });

    $("#proyectos").change(function() {

        var idProyActual = $("#proyectos").val();
        var idInstancia = $("#comboOrganizaciones").val();
        var idDatosPer = $('.idDatosPersonalesOrg').val();

        recargaInfoProyectos(idProyActual, idInstancia, idDatosPer);

    });

    function prueba() {
        alert("funciona!");
    }

}

  $("#comboOrganizaciones").change(function(event) {
        var idInstancia = $("#comboOrganizaciones option:selected").val();
        recargaProyectos(idInstancia);

    });

$("#proyectos").change(function() {

    var idProyActual = $("#proyectos option:selected").val();
    var idInstancia = $("#comboOrganizaciones option:selected").val();
    var idDatosPer = $('.idDatosPersonalesOrg').val();
    recargaInfoProyectos(idProyActual, idInstancia, idDatosPer);
});


function recargaInfoProyectos(idProyActual, idInstancia, idDatosPer)
{
    console.log('--IdProyactual:' + idProyActual);
    for (i = 0; i < proyecto.nombre_responsable.length; i++) {

        if (parseInt(idProyActual) === proyecto.id_proyecto[i])
        {
            console.log('--------------------------------------------------------------------------------soniguales---------------------------------------------------------');
            //$('#idProyecto').val(proyecto.id_proyecto[i]);
            $('#linkMasInfoProyecto').attr("href", "detalleProyecto.do?id=" + proyecto.id_proyecto[i]);
            $('#domicilioOrg').val(proyecto.domicilio[i]);
            $('#nombre_responsable').val(proyecto.nombre_responsable[i]);
            $('#responsable_puesto').val(proyecto.responsable_puesto[i]);
            $('#telefono_responsable').val(proyecto.telefono_responsable[i]);
            $('#linkNuevoP').attr("href", "propAlProyecto.do?datos_personales=" + idDatosPer + "&idInstancia=" + idInstancia + "");
        }
    }


}
function cambiaStatusSubidaFui()
{
    var idDP = $('#idSubirFui').val();
    console.log('Se cambiará el estatus por descargado al id de datos personales ' + idDP);
    $.get("cambiaStatusSubidaFui.do?&id_datos_personales=" + idDP, null, function(respuesta) {
        console.log('Subida con respuesta = ' + respuesta);
    });
}
function abreFancy()
{
    alert('asdad');
}
function recargaProyectos(idInstancia, idProyecto)
{
    console.log('el id de la isntancia es: ' + idInstancia);
    var idDP = $('.idDatosPersonalesOrg').val();
    console.log('El id de los datos personales: ' + idDP);
    $.get("cargarProyectos.do?id_instancia=" + idInstancia + "&id_datos_personales=" + idDP, null, function(respuesta) {
        console.log(respuesta);
        if (respuesta.nombre_responsable.length !== 0) {
            $("#proyectos").empty();
            $('#domicilioOrg').empty();
            $('#nombre_responsable').empty();
            $('#responsable_puesto').empty();
            $('#telefono_responsable').empty();
            console.log('entro');
            for (i = 0; i < respuesta.nombre_responsable.length; i++) {
                proyecto = null;
                proyecto = respuesta;
                //$("#proyectos").append('<option value=' + respuesta.id_proyecto + '>' + respuesta.nombre + '</option>');
                console.log('Respuesda.id_proyecto es:' + respuesta.id_proyecto[i]);
                console.log('Respuesda.nombre es:' + respuesta.nombre[i]);
                //$('#idProyecto').val(proyecto.id_proyecto[i]);
//            $('#linkMasInfoProyecto').attr("href", "detalleProyecto.do?id=" + proyecto.id_proyecto[i]);
                $('<option value=' + respuesta.id_proyecto[i] + '>' + respuesta.nombre[i] + '</option>').appendTo("#proyectos");
                $('#domicilioOrg').val('');
                $('#nombre_responsable').val('');
                $('#responsable_puesto').val('');
                $('#telefono_responsable').val('');
                $('#domicilioOrg').val(respuesta.domicilio[i]);
                $('#nombre_responsable').val(respuesta.nombre_responsable[i]);
                $('#responsable_puesto').val(respuesta.responsable_puesto[i]);
                $('#telefono_responsable').val(respuesta.telefono_responsable[i]);
                $('#linkNuevoP').attr("href", "propAlProyecto.do?datos_personales=" + idDP + "&idInstancia=" + idInstancia + "");
            }

            $("#linkMasInfoProyecto").click(function() {
                var idProyectoCombo = $("#proyectos option:selected").val();
                $('#linkMasInfoProyecto').attr("href", "detalleProyecto.do?id=" + idProyectoCombo);
            });

            console.log('Pasando a proyectos');
            console.log('tamanio de proyec es' + $("#proyectos option").size());
            $("#proyectos option").each(function() {
                console.log('??');
                console.log('tiene:' + $(this).attr('value') + '--');
                if (parseInt($(this).attr('value')) === parseInt(idProyecto))
                {

                    console.log('lo halle en ' + $(this).attr('value'));
                    $("#proyectos").val(idProyecto);
                }
            });
        } else {
            console.log("No se recuperaron proyectos.");
            $('#domicilioOrg').val('');
            $('#nombre_responsable').val('');
            $('#responsable_puesto').val('');
            $('#telefono_responsable').val('');
            $('#proyectos').empty();
        }
    });

}

function recargaCombosOrgs(idProyecto)
{
    var idInstancia = $("#comboOrganizaciones option:selected").val();
    recargaProyectos(idInstancia);
//    console.log("el id del proyecto es:" + idProyecto);
//    //Obtener el id de la instancia para seleccionarlo en el combo
//    $.get("idInstancia.do?idProyecto=" + idProyecto, null, function(respuesta) {
//        console.log('el id de la isnt es' + respuesta.idProyecto + '--');
//        var idInstancia = respuesta.idProyecto;
//        $('#comboOrganizaciones option:eq(' + idInstancia + ')').prop('selected', true);
//
//        console.log('La org a seleccionar ' + idProyecto + "--");
//        console.log('tamanio de org es' + $("#comboOrganizaciones option").size());
//        $("#comboOrganizaciones option").each(function() {
//            console.log('::');
//            console.log('tiene:' + $(this).attr('value') + '--');
//            if (parseInt($(this).attr('value')) === parseInt(idInstancia))
//            {
//                console.log('lo halle en ' + $(this).attr('value'));
//                $("#comboOrganizaciones").val(idInstancia);
//            }
//        });
//
//
//    });


}
//Ubicar el indice en el numero de habitaciones correspondiente

function enviarDatosAlumno()
{
    $('#observacionesOK').hide("fast");
    $('#observaciones').hide("fast");
    $("form#frmDatosPersonales :input").each(function() {
        prepararJSON($(this));
    });

    $.post("modificarDatosPersonales.do", alumno, function(respuesta) {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            console.log('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
                window.location.hash = '#observaciones';
            });
        }
        else
        {
            cambioAutomatico();
            $('#listaObservacionesOK').empty();
            $('#contenidoRespuesta').modal('show');
            $('#observacionesOK').show('slow');
            $('#listaObservacionesOK').append("<li class= 'observacion'>Los <b>Datos Personales</b> fueron guradados correctamente</li><li>Continue con el llenado de su Formato &Uacute;nico</li>");
            window.location.hash = '#foco';
        }
    });


    return false;
}
function enviarDatosContactoAlumno()
{
    $('#observacionesOK').hide("fast");
    $('#observaciones').hide("fast");
    $("form#frmDatosContacto :input").each(function() {
        prepararJSON($(this));
    });

    $.post("modificarDatosContacto.do", alumno, function(respuesta) {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            console.log('Tienes errores');
            $('.observacion').remove();
            $.each(respJ, function(i, accion) {
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
                window.location.hash = '#observaciones';
            });
        }
        else
        {
            cambioAutomatico();
            $('#listaObservacionesOK').empty();
            $('#contenidoRespuesta').modal('show');
            $('#observacionesOK').show('slow');
            $('#listaObservacionesOK').append("<li class= 'observacion'>Los <b>Datos de Contacto</b> fueron guradados correctamente</li><li>Continue con el llenado de su Formato &Uacute;nico</li>");
            window.location.hash = '#foco';
        }
    });


    return false;
}
function enviarHorarios()
{
    $('#observacionesOK').hide("fast");
    $('#observaciones').hide("fast");
    $("form#frmHorarios :input").each(function() {
        prepararJSON($(this));
    });

    $.post("modificarHorarios.do", alumno, function(respuesta) {
        var respJ = {};
        if (respuesta !== "noInfo")
        {
            respJ = jQuery.parseJSON(respuesta);
        }
        if (respJ.length > 0)
        {
            //alert('Tienes errores');
            console.log('Tienes errores');
            $.each(respJ, function(i, accion) {
                $('#listaObservaciones').empty();
                $('#observaciones').show('slow');
                $('#listaObservaciones').append("<li class= 'observacion'>" + accion.observacion + "</li>");
                window.location.hash = '#observaciones';
            });
        }
        else
        {
            cambioAutomatico();
            $('#listaObservacionesOK').empty();
            $('#contenidoRespuesta').modal('show');
            $('#observacionesOK').show('slow');
            $('#listaObservacionesOK').append("<li class= 'observacion'>Los <b>Horarios</b> fueron guradados correctamente</li><li>Continue con el llenado de su Formato &Uacute;nico</li>");
            window.location.hash = '#foco';
        }
    });


    return false;
}
function enviarDatosOrganizaciones()
{
    $('#observacionesOK').hide("fast");
    $('#observaciones').hide("fast");
    console.log('el id de proy que subo ' + $('#proyectos').val());
    $("form#frmDatosOrganizaciones :input").each(function() {
        prepararJSON($(this));
    });
    $('.observacion').remove();
    if ($("input#fecha_inicio").val() === "") {
        $('#observaciones').show('slow');
        $('#listaObservaciones').append("<li class= 'observacion'>El campo Fecha de Inicio no puede estar vacío</li>");
        window.location.hash = '#observaciones';
    }
    console.log(alumno);
    $.post("modificarDatosOrganizaciones.do", alumno, function(respuesta) {
        if (respuesta !== "" && respuesta !== "fallo fecha") {
            cambioAutomatico();
            $('#listaObservacionesOK').empty();
            $('#contenidoRespuesta').modal('show');
            $('#observacionesOK').show('slow');
            $('#listaObservacionesOK').append("<li class= 'observacion'>Los datos de <b>Organizaci&oacute;n y Proyecto</b> fueron almacenados correctamente</li><li>Continue con el llenado de su Formato &Uacute;nico</li>");
            window.location.hash = '#foco';
        } else {
            $('#listaObservaciones').empty();
            $('#observaciones').show('slow');
            $('#listaObservaciones').append("<li class= 'observacion'>El campo Fecha de Inicio sobrepasa la fecha m\u00e1xima permitida con respecto a la Pl\u00e1tica del Servicio Social. Verificalo</li>");
            window.location.hash = '#observacionesOK';
        }
    });

    return false;
}
function subirFUI()
{
    $('#observaciones').hide("fast");
    $('.observacion').remove();
    if ($('input#idfile').val() === "")
    {
        $('#observaciones').show('slow');
        $('#listaObservaciones').append("<li class= 'observacion'>El campo Subir Formato Único está vacío.</li>");
        return false;
    }

}
function prepararJSON($atributo)
{
    if ($atributo.attr("type") !== "submit")
    {
        alumno[$atributo.attr("name")] = $atributo.val();
    }
    if ($atributo.attr("type") === "checkbox")
    {
        alumno[$atributo.attr("name")] = $("#" + $atributo.attr("name") + "1").is(":checked");
    }
}
function prepararJSONC($atributo)
{

    if ($atributo.attr("type") !== "submit")
    {
        concacto[$atributo.attr("name")] = $atributo.val();
    }

}
function timePicker()
{
    var idTimePicker = 14;
    var idCadena = "";
//    var parametros = {hours: {starts: 6, ends: 21},
//        minutes: {interval: 15}, showAnim: 'blind'};
    var parametros = {
        defaultTime: '6:00',
        minuteStep: 15,
        showInputs: false,
        modalBackdrop: true,
        showSeconds: false,
        showMeridian: false};
    for (var i = 0; i <= idTimePicker; i++)
    {
        idCadena = ".timepicker\\.\\[" + i + "\\]";
        $(idCadena).timepicker(parametros);
    }
}


function ocultaDiv() {
    $('#observaciones').hide();
    $('#observacionesOK').hide();
}

function cambiaTab() {
    var reg = /active/;
    $(".tabsFormanotUnico").each(function() {
        if ($(this).attr("class").match(reg)) {
            tabActual = this;
        }
    });
    $(".contensFormanotUnico").each(function() {
        if ($(this).attr("class").match(reg)) {
            contentActual = this;
        }
    });
}
function cambioAutomatico() {
    cambiaTab();
    $(tabActual).removeClass('active');
    $(contentActual).removeClass('active');
    var tab = $(tabActual).attr("noTab");
    tab++;
    $("#tab" + tab).addClass("active");
    $("#contensFormanotUnico" + tab).addClass("active");

}



