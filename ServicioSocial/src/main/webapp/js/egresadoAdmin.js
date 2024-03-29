var idDatosPersonales2 = "";
var idEgresado2 = "";
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
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
    $('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
    $('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true
                });
     $('#aceptadosDT').dataTable({
                    "bJQueryUI": true,
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
    console.log($(this).attr('idCa'));
    if(confirmacionEvento())
    {
        $('#guardarObservaciones').attr('disabled', true);
        
        $.post("modificarEgresadoNR_Aceptado.do",{id:$(this).attr('idCa')},function(respuesta)
        {
            if(respuesta==="OK")
            {
                window.location.reload();
                console.log(respuesta);
            }
            else
            {
                alert("Imposible Realizar Acción");
            }
        });
        $('#guardarObservaciones').attr('disabled', false);
    }
    
}

function cambiarEstadoFormatoCorreccion(event)
{
    if(confirmacionEvento())
    {
        console.log('En e campo de idCa tengo' + $(this).attr('idCa'));
       idDatosPersonales2 =$(this).attr('idDP');
       idEgresado2=$(this).attr('idCa');
       tipo2="1";
       mostrarDIVMotivos();
    }
    
}
function cambiarEstadoFormatoRechazado()
{
    if(confirmacionEvento())
    {
       idDatosPersonales2 =$(this).attr('idDP');
       idEgresado2=$(this).attr('idCa');
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
  
  
  if(array.length > 0)
  {
      
      $('#guardarObservaciones').attr('disabled', true);
      $.post("modificarEgresadoNR.do",{idDatoPersonales:idDatosPersonales2,idEgresado:idEgresado2,tipo:tipo2,observaciones:array},function(respuesta)
        {        
            if(respuesta==="OK")
            {
                //$.fancybox.close();
                window.location.reload();
            }else
            {
                alert("Imposible Realizar Acción");
            }
            $('#guardarObservaciones').attr('disabled', false);
        }
        );
  }
  else
  {
        alert('No se ha seleccionado Observación');
  }
  
}


