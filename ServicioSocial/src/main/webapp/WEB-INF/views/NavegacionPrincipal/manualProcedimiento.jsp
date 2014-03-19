<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuPrincipal.jsp"%> 
            </div>
            <div class=" row help-block col-md-10 col-md-offset-2"><h1><span class="glyphicon glyphicon-list-alt"></span>&nbsp; Manual de Procedimientos</h1></div>
            <div class="row col-md-12 ">               
                &nbsp;
                <div class="panel panel-info">
                    <div class="panel-heading">Informaci&oacute;n Importante</div>
                    <div class="panel-body">
                        <div class="col-md-6">
                            <div class="row">
                                <h1 class="text-info">Reglamento de Servicio Social</h1>
                            </div>
                            <div class="row col-md-offset-5">
                                <a href="muestraReglamento.do" class="fancyFUI" target="_blank"><span class="glyphicon glyphicon-search sizeIconValid"></span></a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <h1 class="text-info">Instructivo de Reporte Final</h1>
                            </div>
                            <div class="row col-md-offset-5">
                                <a href="muestraReglamentoFinal.do" class="fancyFUI" target="_blank"><span class="glyphicon glyphicon-search sizeIconValid"></span></a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <%@include file="../General/footer.jsp"%>           
        </div><!--/row-->
    </div> <!-- /container -->
    <%@include file="../General/js.jsp"%>
</body>
</html>
