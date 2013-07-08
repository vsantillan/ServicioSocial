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
            $(function() {
                $('#hora2').timepicker();


            });
        </script>
<%-- Fin Alta palticas --%>