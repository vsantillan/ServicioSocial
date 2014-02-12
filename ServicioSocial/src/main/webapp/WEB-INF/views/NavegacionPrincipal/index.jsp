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
            <div class="row ">
                <br/>
                <!---------------------------------------------Contenido------------------------------------------->                

                <core:forEach items="${Noticias}" var="noticia" >
                    <div class="noticia">
                        <div class="panel panel-warning panelNoticia">
                            <div class="panel-heading"><h2>${noticia.titulo}</h2></div>
                            <div class="panel-body">
                                ${noticia.detalle}
                                <p><a class="btn btn-primary" href="#" role="button">Ver Detalles &raquo;</a>${noticia.fecha}</p>
                              
                            </div><!--/span-->
                        </div>
                    </div>
                </core:forEach>

                <!---------------------------------------------Fin Contenido------------------------------------------->                

            </div><!--/row--> 
            <%@include file="../General/footer.jsp"%>  
        </div>
        <%@include file="../General/js.jsp"%>         
    </div> <!-- /container -->

</body>
</html>