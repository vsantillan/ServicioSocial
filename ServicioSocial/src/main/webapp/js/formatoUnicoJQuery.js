$(document).ready(listo);
var alumno = {};
function listo()
{
    timePicker();//Inicializa campos JQuery
    $('#frmDatosPersonales').submit(enviarDatosAlumno);
}

function enviarDatosAlumno()
{
    $("form#frmDatosPersonales :input").each(function(){
        prepararJSON($(this));   });
    
    $.post("modificarFormato.do",alumno,function(respuesta){
        alert(respuesta);
        console.log(respuesta);
    });
    
    
    return false;
}
function prepararJSON($atributo)
{
    if($atributo.attr("type") !== "submit")
    {
        alumno[$atributo.attr ("name")] = $atributo.val();
    }
    if($atributo.attr("type") === "checkbox")
    {
        alumno[$atributo.attr ("name")] = $("#"+$atributo.attr ("name")+"1" ).is(":checked");
    }
}
function timePicker()
{
    var idTimePicker = 14;
    var idCadena = "";
    var parametros= {hours: { starts: 6, ends: 21 },
                     minutes: { interval: 15 },showAnim: 'blind'};
    for(var i = 0; i <= idTimePicker; i++) 
    {
       idCadena = "#timepicker\\.\\["+i+"\\]";
       $(idCadena).timepicker(parametros);
    }
}

