$(document).ready(listo);
var alumno = {};
var contacto = {};
function listo()
{
    timePicker();//Inicializa campos JQuery
    $('#frmDatosPersonales').submit(enviarDatosAlumno);
    $('#frmDatosContacto').submit(enviarDatosContactoAlumno);
    $('#frmDatosOrganizaciones').submit(enviarDatosOrganizaciones);
    $('#frmHorarios').submit(enviarHorarios);
    
    $("#comboOrganizaciones").change(function(event) {
        var idInstancia = $("#comboOrganizaciones").val()
        recargaProyectos(idInstancia);
    })

}
function recargaProyectos(idInstancia)
{
    console.log('el id de la isntancia es' + idInstancia);
    
    $.get("cargarProyectos.do?id_instancia=" + idInstancia, null, function(respuesta) {
        $("#proyectos").empty();
        $('#domicilioOrg').empty();
        $('#nombre_responsable').empty();
        $('#responsable_puesto').empty();
        $('#telefono_responsable').empty();
        console.log('entro');
        for (i = 0; i < respuesta.nombre_responsable.length; i++) {
            $("#proyectos").append('<option value=' + respuesta.id_proyecto + '>' + respuesta.nombre + '</option>');
            $('#domicilioOrg').val(respuesta.domicilio);
            $('#nombre_responsable').val(respuesta.nombre_responsable);
            $('#responsable_puesto').val(respuesta.nombre_responsable);
            $('#telefono_responsable').val(respuesta.telefono_responsable);
        }
    });
}

function recargaCombosOrgs(idProyecto)
{
    console.log("el id del proyecto es:"+ idProyecto);
    {
        //Obtener el id de la instancia para seleccionarlo en el combo
        $.get("idInstancia.do?idProyecto=" + idProyecto, null, function(respuesta) {
            console.log('el id de la isnt es' + respuesta.idProyecto);
            idInstancia = respuesta.idProyecto;
            $('#comboOrganizaciones option:eq(' + idInstancia + ')').prop('selected',true);
            recargaProyectos(idInstancia);
            $('#proyectos option:eq(' + idProyecto + ')').prop('selected',true);
        });
    }
}
function enviarDatosAlumno()
{
    $("form#frmDatosPersonales :input").each(function() {
        prepararJSON($(this));
    });

    $.post("modificarDatosPersonales.do", alumno, function(respuesta) {
        alert(respuesta);
        console.log(respuesta);
    });


    return false;
}
function enviarDatosContactoAlumno()
{
    $("form#frmDatosContacto :input").each(function() {
        prepararJSON($(this));
    });

    $.post("modificarDatosContacto.do", alumno, function(respuesta) {
        alert(respuesta);
        console.log(respuesta);
    });


    return false;
}
function enviarHorarios()
{
    $("form#frmHorarios :input").each(function() {
        prepararJSON($(this));
    });

    $.post("modificarHorarios.do", alumno, function(respuesta) {
        alert(respuesta);
        console.log(respuesta);
    });


    return false;
}
function enviarDatosOrganizaciones()
{
    console.log('el id de proy que subo '+ $('#proyectos').val());
    $("form#frmDatosOrganizaciones :input").each(function() {
        prepararJSON($(this));
    });
    console.log(alumno);
    $.post("modificarDatosOrganizaciones.do", alumno, function(respuesta) {
        alert(respuesta);
        console.log(respuesta);
    });


    return false;
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
    var parametros = {hours: {starts: 6, ends: 21},
        minutes: {interval: 15}, showAnim: 'blind'};
    for (var i = 0; i <= idTimePicker; i++)
    {
        idCadena = ".timepicker\\.\\[" + i + "\\]";
        $(idCadena).timepicker(parametros);
    }
}

