/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.*/
function remagia(cp)
{

}
$(document).ready(function() {
    
    //usado por formato unico para la edición
    if ($('#preCP').length > 0 && document.getElementById("preCP").value !== "")
    {
        var cp = document.getElementById("preCP").value;
        cargarColonias(cp);
        document.getElementById("codigo_postal").value = cp;
        console.log('que trae' + document.getElementById("idColonia").value);
    }
    
    if ($('#preCP2').length > 0 && document.getElementById("preCP2").value !== "")
    {
        var cp = document.getElementById("preCP2").value;
        cargarColonias2(cp);
        document.getElementById("codigo_postal2").value = cp;
        console.log('que trae' + document.getElementById("idColonia").value);
    }
    //fin usado por formato unico

    var existeCP = true;
    
    var existeCP2 = true;

//Cargar colonias con JSON
    function cargarColonias(cp) {

        var comboColonias = document.getElementById("idColonia");
        var comboCiudad = document.getElementById("ciudad");
        var comboEstado = document.getElementById("estado");
        var comboMunicipio = document.getElementById("municipio");

        var notice = document.getElementById("notice");

        notice.innerHTML = "<img src='imagenes/loading.gif' width='30'>";
        $.get("cargarColonias.do?cp=" + cp, null, function(respuesta) {
            notice.innerHTML = "";
            console.log(respuesta);
            comboColonias.length = 0;
            comboCiudad.length = 0;
            comboMunicipio.length = 0;

            if (respuesta.statusJSON) {
                existeCP = true;

                //Actualizar combo de estados
                ubicarEstado(respuesta.idEstado);

                //Agregar Municipio
                var optionMunicipio = document.createElement("option");
                optionMunicipio.text = respuesta.municipio;
                optionMunicipio.value = respuesta.idMunicipio;
                comboMunicipio.appendChild(optionMunicipio);

                //Agregar Ciudad
                var optionCiudad = document.createElement("option");
                optionCiudad.text = respuesta.ciudad;
                optionCiudad.value = respuesta.idCiudad;
                comboCiudad.appendChild(optionCiudad);

                //alert("Antes de ubicar estado")

                //Agregar Colonias
                for (i = 0; i < respuesta.nombreColonia.length; i++) {
                    var option = document.createElement("option");
                    option.text = respuesta.nombreColonia[i];
                    option.value = respuesta.idColonia[i];
                    comboColonias.appendChild(option);
                    //usado por formato unico para la edición
                    if ($('#preColonia').length > 0 && document.getElementById("preColonia").value !== "" && document.getElementById("preColonia").value === respuesta.idColonia[i] )
                    {
                        option.selected = "selected";
                    }
                    //fin usado por formato unico
                }
                var option = document.createElement("option");
                option.text = "Otra (Especifique)";
                option.value = 0;
                comboColonias.appendChild(option);

                if (comboColonias.options[comboColonias.selectedIndex].value === 0) {
                    $("#otra_colonia").show("slow");
                }

                comboEstado.disabled = true;
                comboColonias.disabled = false;

            } else {
                existeCP = false;
                notice.innerHTML = "<h4>No poseemos información sobre este código postal, porfavor delo de alta</h4>";
                $("#otra_colonia").show("slow");
                comboEstado.disabled = false;
                comboMunicipio.disabled = false;
                comboColonias.disabled = true;
                cargarMunicipios();

//                inputCiudad.value = "No disponible";
//                inputEstado.value = "No disponible";
//                inputMunicipio.value = "No disponible";
            }

        });

    }
    
    function cargarColonias2(cp) {

        var comboColonias = document.getElementById("idColonia2");
        var comboCiudad = document.getElementById("ciudad2");
        var comboEstado = document.getElementById("estado2");
        var comboMunicipio = document.getElementById("municipio2");

        var notice = document.getElementById("notice2");

        notice.innerHTML = "<img src='imagenes/loading.gif' width='30'>";
        $.get("cargarColonias.do?cp=" + cp, null, function(respuesta) {
            notice.innerHTML = "";
            console.log(respuesta);
            comboColonias.length = 0;
            comboCiudad.length = 0;
            comboMunicipio.length = 0;

            if (respuesta.statusJSON) {
                existeCP = true;

                //Actualizar combo de estados
                ubicarEstado2(respuesta.idEstado);

                //Agregar Municipio
                var optionMunicipio = document.createElement("option");
                optionMunicipio.text = respuesta.municipio;
                optionMunicipio.value = respuesta.idMunicipio;
                comboMunicipio.appendChild(optionMunicipio);

                //Agregar Ciudad
                var optionCiudad = document.createElement("option");
                optionCiudad.text = respuesta.ciudad;
                optionCiudad.value = respuesta.idCiudad;
                comboCiudad.appendChild(optionCiudad);

                //alert("Antes de ubicar estado")

                //Agregar Colonias
                for (i = 0; i < respuesta.nombreColonia.length; i++) {
                    var option = document.createElement("option");
                    option.text = respuesta.nombreColonia[i];
                    option.value = respuesta.idColonia[i];
                    comboColonias.appendChild(option);
                    //usado por formato unico para la edición
                    if ($('#preColonia').length > 0 && document.getElementById("preColonia").value !== "" && document.getElementById("preColonia").value === respuesta.idColonia[i] )
                    {
                        option.selected = "selected";
                    }
                    //fin usado por formato unico
                }
                var option = document.createElement("option");
                option.text = "Otra (Especifique)";
                option.value = 0;
                comboColonias.appendChild(option);

                if (comboColonias.options[comboColonias.selectedIndex].value === 0) {
                    $("#otra_colonia").show("slow");
                }

                comboEstado.disabled = true;
                comboColonias.disabled = false;

            } else {
                existeCP2 = false;
                notice.innerHTML = "<h4>No poseemos información sobre este código postal, porfavor delo de alta</h4>";
                $("#otra_colonia2").show("slow");
                comboEstado.disabled = false;
                comboMunicipio.disabled = false;
                comboColonias.disabled = true;
                cargarMunicipios();

//                inputCiudad.value = "No disponible";
//                inputEstado.value = "No disponible";
//                inputMunicipio.value = "No disponible";
            }

        });

    }

    $("#idColonia").change(function(event) {
        //Actualiza los demas campos de acuerdo a la colonia
        var comboColonias = document.getElementById("idColonia");
        //console.log("")

        if (comboColonias.value === 0) {
            $("#otra_colonia").show("slow");
            if (existeCP) {
                document.getElementById("estado").disabled = true;
                document.getElementById("municipio").disabled = true;
                document.getElementById("ciudad").disabled = true;
            } else {
                document.getElementById("estado").disabled = false;
                document.getElementById("municipio").disabled = false;
                document.getElementById("ciudad").disabled = false;
            }

        } else {
            $("#otra_colonia").hide("slow");
            document.getElementById("estado").disabled = true;
            document.getElementById("municipio").disabled = true;
            document.getElementById("ciudad").disabled = true;
        }



    });
    
    $("#idColonia2").change(function(event) {
        //Actualiza los demas campos de acuerdo a la colonia
        var comboColonias = document.getElementById("idColonia2");
        //console.log("")

        if (comboColonias.value === 0) {
            $("#otra_colonia2").show("slow");
            if (existeCP2) {
                document.getElementById("estado2").disabled = true;
                document.getElementById("municipio2").disabled = true;
                document.getElementById("ciudad2").disabled = true;
            } else {
                document.getElementById("estado2").disabled = false;
                document.getElementById("municipio2").disabled = false;
                document.getElementById("ciudad2").disabled = false;
            }

        } else {
            $("#otra_colonia2").hide("slow");
            document.getElementById("estado2").disabled = true;
            document.getElementById("municipio2").disabled = true;
            document.getElementById("ciudad2").disabled = true;
        }
    });

//Evento para cambio en el estado
    $("#estado").change(function(event) {
        if (!existeCP) {
            cargarMunicipios();
        }
    });
    
     $("#estado2").change(function(event) {
        if (!existeCP) {
            cargarMunicipios();
        }
    });
//Evento de teclado para codigos postales registroOrganizacion.do
    $("#codigo_postal").keyup(function(event) {
        $("#otra_colonia").hide("slow");
        var cp = document.getElementById("codigo_postal").value;
        if (cp.length === 5)
            cargarColonias(cp);
    });
    
    $("#codigo_postal2").keyup(function(event) {
        $("#otra_colonia2").hide("slow");
        var cp = document.getElementById("codigo_postal2").value;
        if (cp.length === 5)
            cargarColonias2(cp);
    });

    function ubicarEstado(value) {
        console.log("value:" + value);
        //Ubicar el indice en el estado correspondiente
        var comboEstado = document.getElementById("estado");
        var encontrado = false;
        var i = 0;
        while (!encontrado)
        {
//            console.log("if " + comboEstado.options[i].value + "== " + value)
            if (comboEstado.options[i].value === value)
            {
                comboEstado.selectedIndex = i;
                encontrado = true;
//                alert("encotrado!");
            }
            else
                i++;
        }
    }
    
    function ubicarEstado2(value) {
        console.log("value:" + value);
        //Ubicar el indice en el estado correspondiente
        var comboEstado = document.getElementById("estado2");
        var encontrado = false;
        var i = 0;
        while (!encontrado)
        {
//            console.log("if " + comboEstado.options[i].value + "== " + value)
            if (comboEstado.options[i].value === value)
            {
                comboEstado.selectedIndex = i;
                encontrado = true;
//                alert("encotrado!");
            }
            else
                i++;
        }
    }

//    cargarEstados()
//    function cargarEstados() {
//        var comboEstado = document.getElementById("estado");
//        $.get("cargarEstados.do", null, function(respuesta) {
//            console.log(respuesta);
//            if (respuesta.statusJSON) {
//                for (i = 0; i < respuesta.nombreEstados.length; i++) {
//                    var option = document.createElement("option");
//                    option.text = respuesta.nombreEstados[i];
//                    option.value = respuesta.idEstados[i];
//                    comboEstado.appendChild(option);
//                }
//            } else {
//                alert("Error al cargar los estados de la republica")
//            }
//
//        });
//    }

    function cargarMunicipios() {

        if (!existeCP) {
            var idEstado = document.getElementById("estado").value;
            $.get("cargarMunicipios.do?idEstado=" + idEstado, null, function(respuesta) {
                console.log(respuesta);
                var comboMunicipio = document.getElementById("municipio");
                if (respuesta.statusJSON) {
                    comboMunicipio.length = 0;
                    for (i = 0; i < respuesta.municipios.length; i++) {
                        var option = document.createElement("option");
                        option.text = respuesta.municipios[i];
                        option.value = respuesta.idMunicipios[i];
                        comboMunicipio.appendChild(option);
                    }
                } else {
                    alert("Error al cargar los municipios del estado");
                }

            });
        }

    }
    function cargarMunicipios2() {

        if (!existeCP2) {
            var idEstado = document.getElementById("estado2").value;
            $.get("cargarMunicipios.do?idEstado=" + idEstado, null, function(respuesta) {
                console.log(respuesta);
                var comboMunicipio = document.getElementById("municipio2");
                if (respuesta.statusJSON) {
                    comboMunicipio.length = 0;
                    for (i = 0; i < respuesta.municipios.length; i++) {
                        var option = document.createElement("option");
                        option.text = respuesta.municipios[i];
                        option.value = respuesta.idMunicipios[i];
                        comboMunicipio.appendChild(option);
                    }
                } else {
                    alert("Error al cargar los municipios del estado");
                }

            });
        }

    }

});