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
    

});


