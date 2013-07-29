var empresa = {};
var tablaNRevisados;
var tablaNAceptados;
var tablaEnCorreccion;
var tablaAceptados;

var arrayAcptadosFilaTemp = new Array();


$(document).ready(listo);
function listo()
{
    inicializarDataTables();
    $(document).on("click","#guardarObservaciones",obtenerDatos);
    $(document).on("click",".aceptar",cambiarEstadoFormatoAceptado);
    $(document).on("click",".correccion",modificarFormatoUnico);
    $(document).on("click",".rechazar",modificarFormatoUnico);
}



function inicializarDataTables()
{
    tablaNRevisados=$('#noRevisadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
    tablaNAceptados=$('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
    tablaEnCorreccion=$('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
     tablaAceptados=$('#aceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
}

function confirmacionEvento()
{
    if(! window.confirm("¿Desea realizar esta acción?"))
    {
        return false;
    }
    return true;
}

function cambiarEstadoFormatoAceptado(event)
{
    if(confirmacionEvento())
    {
        console.log();
        $.post("modificarFormatoUnicoNR_Aceptado.do",{id:$(this).attr('ide')},function(respuesta)
        {
            console.log(respuesta);
        });
    }
    
}




function modificarFormatoUnico(event)
{
    
//    var fila = $(this).parents('tr')[0];
//    var iTemp=0;
//    
//     $(fila).find('td').each(function(index) 
//     {
//         if(index!==3 && index!==6 && index!==7)
//         {//Descarta Campos:Documento,Accion, Modificar 
//            arrayAcptadosFilaTemp[iTemp]=$(this).text();
//            //console.log();
//            iTemp++;
//         }
//         
//        
//     });
    
    
//     $(fila).find('td').each(function(index) 
//     {
//         if(index!==3 && index!==6 && index!==7)
//         {//Descarta Campos:Documento,Accion, Modificar 
//            arrayAcptadosFilaTemp[iTemp]=$(this).text();
//            //console.log();
//            iTemp++;
//         }
//         
//        
//     });
//     
//     
//    var temp=arrayAcptadosFilaTemp[3];
//    arrayAcptadosFilaTemp[3]=arrayAcptadosFilaTemp[4];
//    arrayAcptadosFilaTemp[4]=temp;
//    console.log(arrayAcptadosFilaTemp);
//    
//    tablaNRevisados.fnDeleteRow(fila);
//    tablaAceptados.fnAddData(arrayAcptadosFilaTemp);
    
}

function obtenerDatos()
{
     var array = [];
     
     
                        
     
  $("form#observacionesCat input").each(function() {
     
      if( $(this).is(":checked") )
      {
          array.push($(this).attr("ide")); // id de Obserbacion
      }
  });
  
  $.post("modificarFormatoUnicoNR.do",{id:array},function(respuesta)
    {
        console.log(respuesta);
        
        if(respuesta==="OK")
        {
            window.parent.Shadowbox.close();
        }else
        {
            alert("Imposible Borrar Consulte a Team Developer");
        }
    }
    );
}


