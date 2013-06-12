$(document).ready(listo);
var alumno = {};
function listo()
{
    timePicker();//Inicializa campos JQuery
    $('#frmDatosPersonales').submit(enviarDatosAlumno);
}

function prepararJSON($atributo)
{
    if($atributo.attr ("type")!=="submit")
    {
        alumno[$atributo.attr ("name")]=$atributo.val();
    }
}

function timePicker()
{
    var idTimePicker = 14;
    var idCadena = "";
    for(var i = 0; i <= idTimePicker; i++) 
    {
       idCadena = "#timepicker\\.\\["+i+"\\]";
       $(idCadena).timepicker({showAnim: 'blind'});
    }
}
function enviarDatosAlumno()
{
    $("form#frmDatosPersonales :input").each(function(){prepararJSON($(this));
    });
    console.log(alumno);
    
    $.post("modificarFormato.do",alumno,function(respuesta){
        alert(respuesta);
   });    
    return false;
}


