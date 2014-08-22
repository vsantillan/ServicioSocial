/* 
 * New Project Form Helper
 * 
 * @author: Giovanni Aguirre
 * @Creted on: Aug 13, 2014
 */

var perfiles = [];

// Visibility activated
var act3 = false;
var act4 = false;
var act5 = false;

// Dirección Fields
var estadoF    = document.getElementById('estado-f');
var ciudadF    = document.getElementById('ciudad-f');
var municipioF = document.getElementById('municipio-f');
var comboCol   = document.getElementById('combo-colonia');
var cpField  = document.getElementById('codigo-postal');


$(document).ready(function() 
{
    $('#codigo-postal').keyup(function(event) 
    {
        loadCP();
    });
    
    var act1F = $('#act1');
    var act2F = $('#act2');
    var act3F = $('#act3');
    var act4F = $('#act4');
    var act5F = $('#act5');
    
    if (act3F.val().length > 0) 
    {
        $('#actividad3').css('display', 'block');
        act3 = true;
    }
    if (act4F.val().length > 0) 
    {
        act4 = true;
        $('#actividad4').css('display', 'block');
    }
    if (act5F.val().length > 0) 
    {
        act5 = true;
        $('#actividad5').css('display', 'block');
    }
    
    // Cargar datos de dirección si el codigo postal ya ha sido asignado
    // (Solo en caso de que el Backend haya rechazado los datos del servidor)
    if ($('#codigo-postal').val().length === 5) 
    {
        loadCP();
    }
    
    
    // Cargar perfiles seleccionados anteriormente
    var perfilesProyf = $('#perfiles-proyf').val();
    if (perfilesProyf.length > 0) 
    {
        var perfilesArray = perfilesProyf.split(';');
        console.log('\nPERFILES: ');
        for (var i=0; i<perfilesArray.length; i++) 
        {
            console.log(perfilesArray[i]);
            $('#perfilesd option').each(function()
            {
                //alert($(this).text() + ' *|* ' + perfilesArray[i].trim());
                if ($(this).text().trim() === perfilesArray[i].trim())
                {
                    $('#perfilesp').append('<option value="' + perfilesArray[i].trim() + '">' + perfilesArray[i].trim() + "</option>");
                    $(this).remove();

                    perfiles.push(perfilesArray[i].trim());
                    $('#perfiles-proyf').val(perfiles.join(';'));
                }
            });
        }
    }
    
});

function addActivity()
{
    if (!act3) 
    {
        $('#actividad3').css('display', 'block');
        act3 = true;
    }
    else if (!act4) 
    {
        act4 = true;
        $('#actividad4').css('display', 'block');
    }
    else if (!act5) 
    {
        act5 = true;
        $('#actividad5').css('display', 'block');
    }
}

function addPerfil()
{
    var perfil = $('#perfilesd').find(":selected").text();
    if (perfil) 
    {
        $('#perfilesp').append('<option value="' + perfil + '">' + perfil + "</option>");
        $('#perfilesd').find(":selected").remove();
        
        perfiles.push(perfil);
        $('#perfiles-proyf').val(perfiles.join(';'));
    }
}

function loadCP()
{
    if (cpField.value.length > 0) 
    {
        if(cpField.value.match("^[0-9]*$"))
        {
            $('#alert-cp').css('display', 'none');
        }
        else
        {
            $('#alert-cp').css('display', 'block');
            cpField.value = cpField.value.slice(0, -1);
        }
    }
    if (cpField.value.length === 5) 
    {
        $.get("cargarColonias.do?cp="+cpField.value, function(response)
        {       
            if (response.statusJSON) 
            {
                estadoF.value    = response.estado;
                ciudadF.value    = response.ciudad;
                municipioF.value = response.municipio;

                // Append Colonias al combo
                comboCol.length = 0;
                for(var i=0; i<response.nombreColonia.length; i++)
                {
                    var option = document.createElement('option');
                    option.text  = response.nombreColonia[i];
                    option.value = response.idColonia[i];
                    comboCol.appendChild(option);
                }

                // Append option para "Otra colonia"
                var optionOtra   = document.createElement('option');
                optionOtra.text  = "OTRA (Especifique)";
                optionOtra.value = 0;
                comboCol.appendChild(optionOtra);
            }
            else
            {
                // Registrar otra dirección
                alert('El codigo postal no existe');
            }
        });
    }
}

function removePerfil()
{
    var perfil = $('#perfilesp').find(':selected').text();
    if (perfil) 
    {
        for (var i=0; i<perfiles.length; i++) 
        {
            if (perfiles[i] === perfil) 
            {
                perfiles.splice(i, 1);
                $('#perfilesp').find(':selected').remove();
                $('#perfiles-proyf').val(perfiles.join(';'));
                break;
            }
        }
    }
    
}
