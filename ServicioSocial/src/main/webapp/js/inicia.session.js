/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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