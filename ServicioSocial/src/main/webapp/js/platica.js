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
                var opcion = document.getElementById("aceptacionleer"); //acceso al botón

                //var platica=document.getElementById("fecha").html;
                var platica = $("#fecha option:selected").html();
                if (opcion.checked == true) { //botón seleccionado
                    //alert("Esta seguro de registrarse a la plática de inducción:\nFecha \t "+platica)
                }
                else {  //botón no seleccionado
                    alert("El formulario no ha podido enviarse. \n Debe aceptar haber leido el manual para poder enviar el formulario");
                    return false; //el formulario no se envia
                }
}
     