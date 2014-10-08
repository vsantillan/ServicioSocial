var fechaPLatica = "";
var url1 = "/Platicas/folio.jsp";
var url2 = "/Platicas/seleccionarPlatica.jsp";




$(document).ready(function() {
    $('#agregaLugar').click(function() {
        $.fancybox({
            'content': $("#myDivID").html(),
            onComplete: function() {

            }
        });
    });

});


function marcado() {
//    var opcion = document.getElementById("aceptacionleer");
    
    if (!($("#aceptacionleer").is(':checked'))) 
    {
        alert("Marque la casilla que indique que ley\u00f3 el manual de procedimiento");
        return false; //el formulario no se envia
    }
    
//    //var platica=document.getElementById("fecha").html;
//    var platica = $("#fecha option:selected").html();
//    if (opcion.checked == true) { //botón seleccionado
//        //alert("Esta seguro de registrarse a la plática de inducción:\nFecha \t "+platica)
//    }
//    else {  //botón no seleccionado
//        alert("Marque la casilla que indique que ley\u00f3 el manual de procedimiento");
//        return false; //el formulario no se envia
//    }
}

$(".GenFolioo").click(function Redirecciona() {

    window.setInterval(200);
    $(location).attr('href', "panelUsuario.do");
});
