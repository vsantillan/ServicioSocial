$(document).ready(function(){
    $("#fecha").change(function(event){
        var fecha=document.getElementById("fecha").value;
       //  alert(fecha);
        $.post("actualizarDetalle.do", {fecha: fecha}, function(respuesta){
            document.getElementById("hora").value=respuesta.detalle;
            document.getElementById("descripcion").value=respuesta.descripcion;
        })
       
    })
})

