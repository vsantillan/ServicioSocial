var arrayAcptadosFilaTemp = new Array();
var idDatosPersonales = "";
var idFormatoUnico = "";
var tipo="";

$(document).ready(listo);
function listo()
{
    inicializarDataTables();
    $(document).on("click","#guardarObservaciones",obtenerDatos);
    $(document).on("click",".aceptar",cambiarEstadoFormatoAceptado);
    $(document).on("click",".correccion",cambiarEstadoFormatoCorreccion);
    $(document).on("click",".rechazar",cambiarEstadoFormatoRechazado);
}

function inicializarDataTables()
{
    $('#noRevisadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
    $('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
    $('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
     $('#aceptadosDT').dataTable({
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
        $.post("modificarFormatoUnicoNR_Aceptado.do",{id:$(this).attr('ide')},function(respuesta)
        {
            console.log(respuesta);
        });
    }
    
}

function cambiarEstadoFormatoCorreccion(event)
{
    if(confirmacionEvento())
    {
       idDatosPersonales =$(this).attr('idDP');
       idFormatoUnico=$(this).attr('idFU');
       tipo="1";
       mostrarDIVMotivos();
    }
    
}
function cambiarEstadoFormatoRechazado()
{
    if(confirmacionEvento())
    {
       idDatosPersonales =$(this).attr('idDP');
       idFormatoUnico=$(this).attr('idFU');
       tipo="2";
       mostrarDIVMotivos();
    }
}

function  mostrarDIVMotivos()
{
    Shadowbox.open(
               { content:$("#motivos").html(), 
                 player:'html'
                }
         );
}


function obtenerDatos()
{
  var array = [];
     
  $("form#observacionesCat input").each(function() {
     
      if( $(this).is(":checked") )
      {
          array.push($(this).attr("value")); // id de Obserbacion
      }
  });
  
  $.post("modificarFormatoUnicoNR.do",{idDatoPersonales:idDatosPersonales,idFormatoUnico:idFormatoUnico,tipo:tipo,observaciones:array},function(respuesta)
    {        
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


