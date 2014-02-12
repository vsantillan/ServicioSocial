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
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="carousel slide" id="carousel-448230">
                                <ol class="carousel-indicators">
                                    <li class="active" data-slide-to="0" data-target="#carousel-448230">
                                    </li>
                                    <li data-slide-to="1" data-target="#carousel-448230">
                                    </li>
                                    <li data-slide-to="2" data-target="#carousel-448230">
                                    </li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img alt="" src="http://lorempixel.com/1600/500/sports/1" />
                                        <div class="carousel-caption">
                                            <h4>
                                                ¿Por que me ponen en el index?
                                            </h4>
                                            <p>
                                                Son unos putos apenas y se copiar y pegar cosas.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img alt="" src="http://lorempixel.com/1600/500/sports/2" />
                                        <div class="carousel-caption">
                                            <h4>
                                                Vete a la chingada
                                            </h4>
                                            <p>
                                                Me huele el Camaron
                                            </p>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img alt="" src="http://lorempixel.com/1600/500/sports/3" />
                                        <div class="carousel-caption">
                                            <h4>
                                                Third Thumbnail label
                                            </h4>
                                            <p>
                                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                            </p>
                                        </div>
                                    </div>
                                </div> <a class="left carousel-control" href="#carousel-448230" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-448230" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <core:forEach items="${Noticias}" var="noticia" varStatus="x">
                        <core:if test="${(x.index%2 == 0) && (x.index != 0)}">
                            <div class="row clearfix">    
                            </core:if>
                            <div class="col-md-4 column"> <!--Noticia-->
                                <div class="panel-group" id="panel-${noticia.id}">
                                    <div class="panel panel-default alert-info"> 
                                        <div class="panel-heading">
                                            <button class="btn btn-lg btn-primary btn-block panel-title collapsed" input type ="button" data-toggle="collapse" data-parent="#panel-${noticia.id}" href="#panel-element-${noticia.id}"><b>${noticia.titulo} &nbsp; ${noticia.fecha}</b></button>
                                        </div>
                                        <div id="panel-element-${noticia.id}" class="panel-collapse collapse ">
                                            <div class="panel-body alert-info">
                                                ${noticia.detalle}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> <!--Noticia-->
                            <core:if test="${((x.index%2 == 0) && (x.index != 0)) }">
                            </div>   
                        </core:if>
                    </core:forEach>

                </div>
            </div>
            <!---------------------------------------------Fin Contenido------------------------------------------->                

            <%@include file="../General/footer.jsp"%>           
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>