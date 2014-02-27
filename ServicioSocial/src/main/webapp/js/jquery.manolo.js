/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    $(".btn-validar-org").click(function(event) {
        $("#div-validar-organizacion").show('slow');

        setTimeout(function() {
            $("#div-validar-organizacion").hide('slow');
        }, 3000);
    });

//    $(".btn-validar-proyecto").click(function(event) {
//        $("#div-validar-proyecto").show('slow');
//
//        setTimeout(function() {
//            $("#div-validar-proyecto").hide('slow');
//        }, 3000);
//    });

    $("#btnLoginOrg").click(function(event) {

        var correo = document.getElementById("correo");
        var pass = document.getElementById("pass");
        var ok = true;

        $("#respLoginOrg").html("");
        $("#div_correo_organizacion").hide("slow");
        $("#div_pass_organizacion").hide("slow");

        if (correo.value === "") {
            ok = false;
            $("#div_correo_organizacion").show("slow");
        }
        if (pass.value === "") {
            ok = false;
            $("#div_pass_organizacion").show("slow");
        }
        if (ok) {
            $("#respLoginOrg").html("<center><img src='imagenes/loading.gif' width='40'/><br/>Cargando...</center>");
            setTimeout(function() {
                window.location.href = "panelOrganizacion.do";
            }, 3000);
        }
    });

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

    //Formulario alta admin proyectos
    if (typeof(iniciarAltaAdminProyecto) !== 'undefined' || typeof(iniciarAltaPropuestaInstancia) !== 'undefined' || typeof (iniciarAltaProyecto) !== 'undefined') {
        console.log("Iniciando alta admin proyecto");
        //iniciarPerfiles();
        var nActHidden = document.getElementById("PrenActividades");
        nActHidden.value = Number(nActHidden.value);
        nActividades = 0;

        for (var i = 0; i < 5; i++) {
            var actHidden = document.getElementById("actividad" + i);
            if (i < 2) {
                if (actHidden.value === 'undefined') {
                    agregarActividad();
                } else {
                    agregarActividad(actHidden.value);
                }
            } else {
                if (nActHidden.value > 2) {
                    if (actHidden.value !== '') {
                        agregarActividad(actHidden.value);
                    }
                }
            }
        }
    }

    var nActividades;
    $("#agregarActividad").click(function(event) {
        agregarActividad();
    })

    function agregarActividad(actividad) {
        console.log("Pretendiendo agregar actividad, nActividades:" + nActividades);
        console.log("actividad:" + actividad);
        if (nActividades < 5) {
            if (typeof(actividad) === 'undefined') {
                $("#actividades").append("<li style='float:left;'><input type='text' size='35' maxlength='60' name='actividades[" + nActividades + "]' class='actividad' id='" + nActividades + "' /><input type ='button' class='borrar btn btn-primary' value = 'Quitar'  /></li>");
            }
            else {
                $("#actividades").append("<li style='float:left;'><input type='text' size='35' maxlength='60' name='actividades[" + nActividades + "]' class='actividad' id='" + nActividades + "' value='" + actividad + "'/><input type ='button' class='borrar btn btn-primary' value = 'Quitar'  /></li>");
            }
            masActividad();
            console.log("Actividad agregada");
        }
    }

    //Actualiza el campo hidden que almacena el numero de actividades
    function masActividad() {
        nActividades++;
        document.getElementById("nActividades").value = nActividades;
        console.log("nActividades local:" + nActividades);
        console.log("nActividades form:" + document.getElementById("nActividades").value);
    }

    function menosActividad() {
        nActividades--;
        document.getElementById("nActividades").value = nActividades;
        console.log("nActividades local:" + nActividades);
        console.log("nActividades form:" + document.getElementById("nActividades").value);

    }

    $("body").on("click", ".borrar", function(event) {
        console.log("Borrar actividad, nActividades:" + nActividades);
        if (nActividades > 2) {
            $(this).closest('li').remove();
            menosActividad();
        }
    });

    //Arreglo de perfiles
    var perfiles = new Array();
    var maxPerfiles = 0;

    function iniciarPerfiles() {
        console.log("Perfiles");
        $.get("cargarPerfiles.do", null, function(respuesta) {
            console.log(respuesta);
            for (i = 0; i < respuesta.nombre.length; i++) {
                console.log(respuesta.nombre[i] + " " + respuesta.idPerfil[i]);
                perfiles.push(new Perfil(respuesta.idPerfil[i], respuesta.nombre[i]));
                maxPerfiles++;
            }

        });
    }

    var nPerfiles = 0;
    function agregaComboPerfil() {
        if (nPerfiles < maxPerfiles) {
            console.log("Agregando combo");
            //$("#perfiles").append("<li style='float:left;'><select>");
            var li = document.createElement("li");
            var select = document.createElement("select");
            var button = document.createElement("button");
            button.appendChild(document.createTextNode("Quitar"));
            $(button).attr("class", "borrarPerfil");
            for (i = 0; i < perfiles.length; i++) {
                console.log("<option value='" + perfiles[i].id + "'>" + perfiles[i].nombre + "</option>");
                var option = document.createElement("option");
                option.text = perfiles[i].nombre;
                option.value = perfiles[i].id;
                $(option).attr("class", "opPerfil");
                select.appendChild(option);
                //$("#perfiles").append("<option value='" + perfiles[i].id + "'>" + perfiles[i].nombre + "</option>");
            }
            $(select).attr("name", "perfiles[" + nPerfiles + "]");
            $(select).attr("class", "perfil");
            //$("#perfiles").append("</select><input type ='button' class='borrarPerfil' value = 'Quitar'/></li>");
            li.appendChild(select);
            li.appendChild(button);
            document.getElementById("perfiles").appendChild(li);
            masPerfil();
        }
    }

    //Clase Perfil
    function Perfil(id, nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Actualiza un el campo hidden de nPerfil
    function masPerfil() {
        nPerfiles++;
        document.getElementById("nPerfiles").value = nPerfiles;
        console.log("nPerfiles local:" + nPerfiles);
        console.log("nPerfiles form:" + document.getElementById("nPerfiles").value);

    }

    function menosPerfil() {
        nPerfiles--;
        document.getElementById("nActividades").value = nPerfiles;
        console.log("nPerfiles local:" + nPerfiles);
        console.log("nPerfiles form:" + document.getElementById("nPerfiles").value);
    }

    $("#agregaPerfil").click(function(event) {
        agregaComboPerfil();
    });

    $("body").on("click", ".borrarPerfil", function(event) {
        $(this).closest('li').remove();
        menosPerfil();
        if (nPerfiles === 0) {
            document.getElementById("ningunPerfil").checked = true;
            validarCheck();
        }
    });

    $("#ningunPerfil").click(function(event) {
        validarCheck();
    });

    function validarCheck() {
        var habilCheck = document.getElementById("ningunPerfil").checked;
        //alert(habilCheck);
        var btnAgregarPerfil = document.getElementById("agregaPerfil");
        var ol = document.getElementById("perfiles");

        if (!habilCheck) {
            btnAgregarPerfil.disabled = false;
            btnAgregarPerfil.style.opacity = 1;
            ol.style.opacity = 1;
            console.log("Habilitando!");
            if (nPerfiles === 0) {
                agregaComboPerfil();
            }
        } else {
            btnAgregarPerfil.disabled = true;
            btnAgregarPerfil.style.opacity = .5;
            ol.style.opacity = .5;
            console.log("Deshabilitado");
        }
    }

    function preparaActividadesPerfiles() {
        console.log("Guardar");
        //var cadenaPerfiles = "";
        var cadenaActividades = "";

        $(".actividad").each(function() {
            console.log("Actividad:" + $(this).val());
            cadenaActividades += $(this).val() + ";";
        });
        console.log("Cadena actividades:" + cadenaActividades);
        document.getElementById("cadenaActividades").value = cadenaActividades;

        //Preparar perfiles seleccionados
        var perfiles = document.getElementById("select-to");
        for (i = 0; i < perfiles.length; i++) {
            console.log("Seleccionando:" + perfiles.options[i].text);
            perfiles.options[i].selected = true;
        }
    }

    $("#btnGdaAdminProyecto").click(function(event) {
        preparaActividadesPerfiles();
        document.forms["altaOrganizacion"].submit();
    });

    $("#btnGdaPropProyecto").click(function(event) {
        preparaActividadesPerfiles();
        document.forms["altaPropProyecto"].submit();
    });

    $("#btnGdaPropAlInst").click(function(event) {
        preparaActividadesPerfiles();
        document.forms["altaPropInstancia"].submit();
    });

    $("#btnPreInstancia").click(function(event) {

        var select = document.getElementById("idInstancia");

        if (select.selectedIndex > 0) {
            document.forms["altaOrganizacion"].submit();
        }
    });

    $("#btnLogin").click(function(event) {
        $("#respLoginOrg").show("fast");
        $("#formLogin").animate({width: 400, height: 400}, "slow");
        document.forms["formLogin"].submit();
    });

    $(".EnviarEnter").keyup(function(event) {
        if (event.keyCode === 13) {
            $("#respLoginOrg").show("fast");
            $("#formLogin").animate({width: 400, height: 300}, "slow");
            document.forms["formLogin"].submit();
        }
    });
     $("#casistenciaespecial").keyup(function(event) {
        if (event.keyCode === 13) {
            document.forms["casistenciaespecial"].submit();
        }
    });
     $("#casistencia").keyup(function(event) {
        if (event.keyCode === 13) {
            document.forms["casistencia"].submit();
        }
    });

    $('form').keypress(function(e) {
        if (e === 13) {
            return false;
        }
    });

    $('input').keypress(function(e) {
        if (e.which === 13) {
            return false;
        }
    });

    //Panel de usuario
    $(".filas").mouseover(function(event) {
        $(this).popover("show");

    });

    $(".filas").mouseleave(function(event) {
        $(this).popover("hide");
    });
//
//    $("td").mouseleave(function(event) {
//        $("#mensajesProceso").hide("fast");
//    });
//    //Platica
//    $("#filaPlatica").mouseover(function(event) {        
//        $(this).popover("show");
//    });
//
//    $("#filaPlatica").mouseleave(function(event) {
//        $(this).popover("hide");
//    });
//    //Formato Unico
//    $("#filaFormatoUnico").mouseover(function(event) {
//        $(this).popover("show");
//    });
//
//    $("#filaFormatoUnico").mouseleave(function(event) {
//        $("#formatoUnico").hide("fast");
//    });
//    //Reportes Bimestrales
//    $("#filaReportesBimestrales").mouseover(function(event) {
//        $(this).popover("show");
//    });
//
//    $("#filaReportesBimestrales").mouseleave(function(event) {
//        $("#reportesBimestrales").hide("fast");
//    });
//    //Reportes Mensuales
//    $("#filaReportesMensuales").mouseover(function(event) {
//        $(this).popover("show");
//    });
//
//    $("#filaReportesMensuales").mouseleave(function(event) {
//        $("#reportesMensuales").hide("fast");
//    });
//    //Platica Becados
//    $("#filaPlaticaBecados").mouseover(function(event) {
//        $(this).popover("show");
//    });
//
//    $("#filaPlaticaBecados").mouseleave(function(event) {
//        $("#platicaBecados").hide("fast");
//    });
//    //Documentos Finales
//    $("#filaDocumentosFinales").mouseover(function(event) {
//        $(this).popover("show");
//    });
//
//    $("#filaDocumentosFinales").mouseleave(function(event) {
//        $("#documentosFinales").hide("fast");
//    });
//    //Sanciones
//    $("#filaSanciones").mouseover(function(event) {
//        $(this).popover("show");
//    });
//
//    $("#filaSanciones").mouseleave(function(event) {
//        $("#sanciones").hide("fast");
//    });


});


