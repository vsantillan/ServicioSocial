/* 
 * Function for instancias module
 * 
 * @author Giovanni Aguirre
 * @Created on Jul 23, 2014
 */

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

function buscarInstancia()
{
    var toSearch = $('#buscar-instanciaf').val();
    var searchIn = $('#campoabuscar-combo').val();
    
    // Buscar instancias
    var url = 'buscarinstancias.do?field=' + searchIn + '&value=' + toSearch;
    $.get(url, function(response)
    {
        var container = $('#lista-instancias');
        $('.instancia-encontrada').remove();
        
        if (response.length > 0) 
        {
            for(var i=0; i<response.length; i++)
            {
                var instanciaElement = '<div class="instancia-encontrada">'
                                   + '<div class="instancia-encontrada-title">'
                                   + response[i].nombre
                                   + '</div> <div class="col-md-4">'
                                   + '<span class="instancia-encontrada-subtitle">Email de la instancia</span><br/>'
                                   + '<span class="instancia-encontrada-info">'
                                   + response[i].email
                                   + '</span> </div> <div class="col-md-4">'
                                   + '<span class="instancia-encontrada-subtitle">Titular de la instancia</span><br/>'
                                   + '<span class="instancia-encontrada-info">'
                                   + response[i].titular
                                   + '</span> </div> <div class="col-md-4">'
                                   + '<span class="instancia-encontrada-subtitle">RFC de la instancia</span><br/>'
                                   + '<span class="instancia-encontrada-info">'
                                   + response[i].rfc
                                   + '</span> </div> <div class="space-helper"> &nbsp; </div> </div>';
                 container.append(instanciaElement);
            }
        }
        else
        {
            var instanciaElement2 = '<div class="instancia-encontrada">'
                                   + '<div class="instancia-encontrada-title">'
                                   + 'No se ha encontrada ninguna instancia'
                                   + '<div class="space-helper"> &nbsp; </div> </div>';
            container.append(instanciaElement2);
        }
    });
    
    $('#instancias-result').css('display', 'block');
}

function showFormPreregistro()
{
    location.href="preregistrarinstancia.do";
}