$(document).ready(function() {
    $('#formPlatica').formly();
    
    
    $('#datepicker').datepicker(
            {
                closeText: 'Cerrar',
                prevText: 'Anterior',
                nextText: 'Siguiente',
                currentText: 'Hoy',
                dateFormat: 'dd/mm/yy',
                monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
                minDate: 0,
                onClose: function(selectedDate) {
                    $("#datepicker2").datepicker("option", "minDate", selectedDate);
                }
            });
    $('#datepicker2').datepicker(
            {
                closeText: 'Cerrar',
                prevText: 'Anterior',
                nextText: 'Siguiente',
                currentText: 'Hoy',
                dateFormat: 'dd/mm/yy',
                monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
                minDate: 0

            });
    $('#hora').timepicker();
    
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
     