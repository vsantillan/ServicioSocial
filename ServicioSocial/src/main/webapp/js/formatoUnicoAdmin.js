var arrayAcptadosFilaTemp = new Array();
var idDatosPersonales2 = "";
var idFormatoUnico2 = "";
var tipo2="";

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
       idDatosPersonales2 =$(this).attr('idDP');
       idFormatoUnico2=$(this).attr('idFU');
       tipo2="1";
       mostrarDIVMotivos();
    }
    
}
function cambiarEstadoFormatoRechazado()
{
    if(confirmacionEvento())
    {
       idDatosPersonales2 =$(this).attr('idDP');
       idFormatoUnico2=$(this).attr('idFU');
       tipo2="2";
       mostrarDIVMotivos();
    }
}

function  mostrarDIVMotivos()
{
 $.fancybox(
             $("#motivos").html(), //fancybox works perfect with hidden divs
             {}
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
  
  $.post("modificarFormatoUnicoNR.do",{idDatoPersonales:idDatosPersonales2,idFormatoUnico:idFormatoUnico2,tipo:tipo2,observaciones:array},function(respuesta)
    {        
        if(respuesta==="OK")
        {
            //$.fancybox.close();
            window.location.reload();
        }else
        {
            alert("Imposible Borrar Consulte a Team Developer");
        }
    }
    );
}


