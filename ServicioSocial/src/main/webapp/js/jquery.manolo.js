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

    //Formulario alta admin proyectos
    var nActividades = 0;

    agregarActividad();
    agregarActividad();
    $("#agregarActividad").click(function(event) {
        agregarActividad();
    })

    function agregarActividad() {
        if (nActividades < 5) {
            $("#actividades").append("<li style='float:left;'><input type='text' size='35' class='actividad' id='" + nActividades + "'/><input type ='button' class='borrar' value = 'Quitar'  /></li>");
            masActividad();
        }
    }
    
    //Actualiza el campo hidden que almacena el numero de actividades
    function masActividad(){
        nActividades++;
        //document.getElementById("nActividades").value=nActividades;
    }
    
    function menosActividad(){
        nActividades--;
        //document.getElementById("nActividades").value=nActividades;
    }

    $("body").on("click", ".borrar", function(event) {
        if (nActividades > 2) {
            $(this).closest('li').remove();
            menosActividad();
        }
    })

    //Arreglo de perfiles
    var perfiles = new Array();

    function iniciarPerfiles() {
        console.log("Perfiles");
        $.get("cargarPerfiles.do", null, function(respuesta) {
            console.log(respuesta);
            for (i = 0; i < respuesta.nombre.length; i++) {
                console.log(respuesta.nombre[i] + " " + respuesta.idPerfil[i]);
                perfiles.push(new Perfil(respuesta.idPerfil[i], respuesta.nombre[i]));
            }

        });
    }
    iniciarPerfiles();
    var nPerfiles=0;
    function agregaComboPerfil() {
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
        //$("#perfiles").append("</select><input type ='button' class='borrarPerfil' value = 'Quitar'/></li>");
        li.appendChild(select);
        li.appendChild(button);
        document.getElementById("perfiles").appendChild(li);
        masPerfil();
    }

    //Clase Perfil
    function Perfil(id, nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    //Actualiza un el campo hidden de nPerfil
    function masPerfil(){
        nPerfiles++;
        //document.getElementById("nPerfiles").value=nPerfiles;
    }
    
    function menosPerfil(){
        nPerfiles--;
        //document.getElementById("nActividades").value=nPerfiles;
    }

    $("#agregaPerfil").click(function(event) {
        agregaComboPerfil();
    })

    $("body").on("click", ".borrarPerfil", function(event) {
        $(this).closest('li').remove();
        menosPerfil();
    });
    var habilCheck=true;
    $("#ningunPerfil").click(function(event){
        habilCheck= !habilCheck;
        var btnAgregarPerfil=document.getElementById("agregaPerfil");
        var ol = document.getElementById("perfiles");
        
        if(habilCheck){
            btnAgregarPerfil.disabled=false;
            btnAgregarPerfil.style.opacity = 1;
            ol.style.opacity=1;
            console.log("Habilitando!");
        }else{
            btnAgregarPerfil.disabled=true;
            btnAgregarPerfil.style.opacity = .5;
            ol.style.opacity=.5;            
            console.log("Deshabilitado");
        }
    });


});


