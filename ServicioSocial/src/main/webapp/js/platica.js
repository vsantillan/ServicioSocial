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
    //baja platica
  fn_dar_eliminar();
});
              function fn_dar_eliminar(){
                $("a.elimina").click(function(){
                    id = $(this).parents("tr").find("td").eq(10).html();
                    fecha = $(this).parents("tr").find("td").find("div").eq(0).html();
                    respuesta = confirm("Está seguro que desea eliminar la platica con fecha: " + fecha);
                    if (respuesta){
                        $(this).parents("tr").fadeOut("normal", function(){
                            $(this).remove();
                            var id_platica=id;
                                $.post("eliminarPlatica.do", {id_platica: id_platica});
                            
                        });
                    }
                });
    };
