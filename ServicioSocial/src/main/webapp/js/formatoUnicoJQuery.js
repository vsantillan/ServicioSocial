$(document).on('ready',listo);
var alumno = {};
function listo()
{
    timePicker();//Inicializa campos JQuery
    $('#loginA').submit(function() {  
            $("form#frmDatosPersonales :input").each(function(){prepararJSON($(this));
    });
    return false;
    });
}
function prepararJSON($atributo)
{
    if($atributo.attr ("type")!=="submit")
    {
        alumno[$atributo.attr ("name")]=$atributo.val();
        console.log(alumno);
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