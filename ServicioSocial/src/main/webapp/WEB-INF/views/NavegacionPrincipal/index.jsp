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
                <!---------------------------------------------Contenido------------------------------------------->                
                <div class="jumbotron">
                    <h1>Hello, world!</h1>
                    <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
                </div>


                <core:forEach items="${Noticias}" var="noticia">
                    <div class="col-6 col-sm-6 col-lg-4">
                        <h2>${noticia.titulo}</h2>
                        <p>${noticia.fecha}</p>
                        <p>${noticia.detalle}</p>
                        <p><a class="btn btn-default" href="#" role="button" ide="${noticia.id}">Ver Detalles &raquo;</a></p>
                    </div><!--/span-->
                </core:forEach>


                <!---------------------------------------------Fin Contenido------------------------------------------->                
            </div><!--/row-->
            <%@include file="../General/footer.jsp"%>           
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>