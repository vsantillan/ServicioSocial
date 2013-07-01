$(document).ready(listo);

function nuevoAjax() 
{
    var xmlhttp = false;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }

    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function cargarContenido() 
{
    var contenedor;
    contenedor = document.getElementById('#example');
    ajax = nuevoAjax();
    ajax.open("GET", "administrarOrganizaciones.do", true);
    ajax.onreadystatechange = function()
    {
        if (ajax.readyState == 4)
        {
            contenedor.innerHTML = ajax.responseText;
        }
    }
    ajax.send(null);
}

function listo()
{
    $('.borrar').click(enviarDatos);
}

function enviarDatos()
{
    $.get($(this).attr("href"), null, function(respuesta)
    {
        alert(respuesta);
    });
    window.onload = cargarContenido();
    return false;
}
