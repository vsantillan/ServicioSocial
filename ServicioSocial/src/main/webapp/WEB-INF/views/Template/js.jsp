<%-- 
    Document   : js
    Created on : 4/06/2013, 10:06:43 AM
    Author     : Jonny
--%>
<%-- Alta palticas --%>
<script>

    $(document).ready(function() {

                    $('#MyForm').formly();
                });


    $(document).on('ready', function(){ 

            $('#hora').clockpick({
            });

    });
    $(document).ready(function() { 
	
	$('#fecha_max_fui').datepicker; 
    });
</script>
 <script type="text/javascript">
   		$(function(){
				// Tabs
				$('#tabs').tabs();
                                
				// Datepicker
				$('#datepicker').datepicker({
					inline: true
				});
                                $('#datepicker').datepicker('option', {dateFormat: 'dd/mm/yy'});
                                
                                $('#datepicker2').datepicker({
					inline: true
				});
			       $('#datepicker2').datepicker('option', {dateFormat: 'dd/mm/yy'});
                               
                               
				
			});
</script>
         <script>
            // Traducci�n al espa�ol
$(function($){
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '<Ant',
        nextText: 'Sig>',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi�rcoles', 'Jueves', 'Viernes', 'S�bado'],
        dayNamesShort: ['Dom','Lun','Mar','Mi�','Juv','Vie','S�b'],
        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S�'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    };
    $.datepicker.setDefaults($.datepicker.regional['es']);
});
        </script>
<%-- Fin Alta palticas --%>