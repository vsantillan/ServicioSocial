$(document).on('ready',listo);
function listo()
{
    timePicker();//Inicializa campos JQuery
    
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