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
            </div><!--/row-->
            <div class="row col-md-12">
                <br/>
                <!---------------------------------------------Contenido------------------------------------------->                

                <core:forEach items="${Noticias}" var="noticia" >

                    <div class="col-md-4 col-md-offset-0">
                        <div class="panel panel-primary panelNoticia  ">
                            <div class="panel-heading"><h4>${noticia.titulo}</h4></div>
                            <div class="panel-body">
                                <p><strong>Fecha de publicaci&oacute;n:<fmt:formatDate pattern="dd-MM-yyyy"  value="${noticia.fecha}"/></strong></p>
                                <br/>
                                <p>${fn:substring(noticia.detalle, 0, 150)}<b>...&nbsp;</b><a class="mustraNoticiaCompleta btn btn-warning btn-xs"  idNoticia="${noticia.id}" data-toggle="modal" data-target="#detalle" role="button">Leer M&aacutes.</a></p>
                                
                                <!--<p><a class="btn btn-warning mustraNoticiaCompleta"  idNoticia="${noticia.id}" data-toggle="modal" data-target="#detalle" role="button">Ver Detalles &raquo;</a></p>-->

                            </div><!--/span-->
                        </div>
                    </div>
                </core:forEach>

                <!---------------------------------------------Fin Contenido------------------------------------------->                

            </div><!--/row--> 
            <div class="modal fade" id="detalle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="titulo"></h4>
                        </div>
                        <div class="modal-body" id="detalleNoticia">
                            
                        </div>
                        <div class="modal-footer">
                            <p>Instituto Tecnológico de Toluca</p>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../General/footer.jsp"%>  
        </div>
        <%@include file="../General/js.jsp"%>         
    </div> <!-- /container -->

</body>
</html>