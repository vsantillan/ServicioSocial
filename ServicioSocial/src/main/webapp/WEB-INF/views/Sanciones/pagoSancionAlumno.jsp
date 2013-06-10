<html>
    <head>
        <title>Seguimiento a Sancionado</title>
        <!--Scripts para tabla-->
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <script type="text/javascript" >
            $(document).ready(function() {
                $('#example').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "sScrollX": "100%",
                    "sScrollXInner": "100%",
                    "bScrollCollapse": true

                });

            });
        </script>
    </head>
    <body>
        <div style="padding-left: 10px; padding-right: 10px ">
    
        <h1>Sanciones</h1>
        <p>A continuaci&oacute;n se muestran los alumnos con sanciones, de click en "Detalles" para ver sus reportes o click en "Pagar" para agregar reportes de pago de servicio.</p>
        <table cellpadding='0' cellspacing='0' border='0' class='display' id="example" width='100%'>
            <thead>
                <tr>
                    <th>No. Reporte</th>
                    <th>Fecha</th>
                    <th>Horas</th>
                    <th>Descripci&oacute;n</th>
                </tr>
            </thead>
            <tbody>
                <tr class='gradeX'>
                    <th>1</th>
                    <th>23 Jun 2105</th>
                    <th>100</th>
                    <th>Labando ba&ntilde;os</th>
                </tr>
            </tbody>
        </table>

        <%-- fin del contenido --%>
    

</div>

    </body>
</html>
