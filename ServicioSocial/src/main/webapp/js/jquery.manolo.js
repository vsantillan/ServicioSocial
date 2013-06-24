/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    $(".btn-validar-org").click(function(event) {
        $("#div-validar-organizacion").show('slow')

        setTimeout(function() {
            $("#div-validar-organizacion").hide('slow')
        }, 3000)
    })

    $(".btn-validar-proyecto").click(function(event) {
        $("#div-validar-proyecto").show('slow');

        setTimeout(function() {
            $("#div-validar-proyecto").hide('slow')
        }, 3000)
    })

    $("#btnLoginOrg").click(function(event) {

        var correo = document.getElementById("correo")
        var pass = document.getElementById("pass")
        var ok = true

        $("#respLoginOrg").html("")
        $("#div_correo_organizacion").hide("slow")
        $("#div_pass_organizacion").hide("slow")

        if (correo.value == "") {
            ok = false
            $("#div_correo_organizacion").show("slow")
        }
        if (pass.value == "") {
            ok = false;
            $("#div_pass_organizacion").show("slow")
        }
        if (ok) {
            $("#respLoginOrg").html("<center><img src='imagenes/loading.gif' width='40'/><br/>Cargando...</center>")
            setTimeout(function() {
                window.location.href = "panelOrganizacion.do";
            }, 3000)
        }
    })

    function objetoAjax() {
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

//Cargar escuelas con AJAX
    function cargarColonias(cp) {

        var comboColonias = document.getElementById("colonia");
        var inputCiudad = document.getElementById("ciudad");
        var inputEstado = document.getElementById("estado");
        var inputMunicipio = document.getElementById("municipio");

        var notice = document.getElementById("notice");        

        notice.innerHTML = "<img src='imagenes/loading.gif' width='30'>";
        $.get("cargarColonias.do?cp=" + cp, null, function(respuesta) {
            
            notice.innerHTML = "";
            statusJSON = true;
            console.log(respuesta);

            comboColonias.length = 0;

            inputCiudad.value = respuesta.ciudad;
            inputEstado.value = respuesta.estado;
            inputMunicipio.value = respuesta.municipio;
            //alert(colonias.length);
            for (i = 0; i < respuesta.nombreColonia.length; i++) {
                var option = document.createElement("option");
                option.text = respuesta.nombreColonia[i];
                option.value = respuesta.idColonia[i];
                comboColonias.appendChild(option);
            }
            var option = document.createElement("option");
            option.text = "Otra (Especifique)";
            option.value = 0;
            comboColonias.appendChild(option);

            if (comboColonias.options[comboColonias.selectedIndex].value == 0) {
                $("#otra_colonia").show("slow");
            }    
            

        });
        
      
       
        
    }

    $("#colonia").change(function(event) {
        //Actualiza los demas campos de acuerdo a la colonia
        var comboColonias = document.getElementById("colonia");
        //console.log("")

        if (comboColonias.value == 0) {
            $("#otra_colonia").show("slow");
            document.getElementById("estado").disabled = false;
            document.getElementById("municipio").disabled = false;
            document.getElementById("ciudad").disabled = false;
        } else {
            $("#otra_colonia").hide("slow");
            document.getElementById("estado").disabled = true;
            document.getElementById("municipio").disabled = true;
            document.getElementById("ciudad").disabled = true;
        }
    })

//Evento de teclado para codigos postales registroOrganizacion.do
    $("#codigo_postal").keyup(function(event) {
        var cp = document.getElementById("codigo_postal").value
        cargarColonias(cp);
    })



});


