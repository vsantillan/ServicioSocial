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

$(document).ready(function() 
{
    var estadoF    = document.getElementById('estado-f');
    var ciudadF    = document.getElementById('ciudad-f');
    var municipioF = document.getElementById('municipio-f');
    var comboCol   = document.getElementById('combo-colonia');
    
    var cpField  = document.getElementById('codigo-postal');
    
    $('#codigo-postal').keyup(function(event) 
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
    });
    
    $('#password-confirm').keyup(function(event)
    {
        if ($('#password-confirm').val() === $('#password').val()) 
        {
            $('#alert-password').css('display', 'none');
            document.getElementById('send-b').type = 'submit';
        }
        else
        {
            $('#alert-password').css('display', 'inline');
            document.getElementById('send-b').type = 'button';
        }
    });
    
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
