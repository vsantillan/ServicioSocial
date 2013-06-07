<!--Estilos para datatables-->
        <link rel="stylesheet" type="text/css" href="css/demo_page.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css" />
        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/> 
        <!--Scripts para tabs-->
            <script src="js/jqueryUI/jquery.ui.tabs.js"></script>
        <!--Scripts para DataTables-->
            <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script> 
            <script type="text/javascript">
                $(document).ready(function() {
                    $("#tabs").tabs();
                });
            </script>
       <!-- Ejemplo de Como llamar a varias tablas en diferentes tabs
       Para Mayor informacion consultar FormatoUnico/formatoUnicoAdministrador.jsp
       <script type="text/javascript">
            $(document).ready(function() {
                $('#noRevisadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#noAceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#enCorreccionDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });
                $('#aceptadosDT').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",

                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script> -->