<%-- 
    Document   : ayuda
    Created on : 19/08/2014, 11:31:34 AM
    Author     : Jorge Muñoz
--%>

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
                <%@include file="../General/menuUsuario.jsp"%> 
                <link href="<%=request.getContextPath()%>/css/carousel.help.css" rel="stylesheet">
                <br>
                <br>
                <br>
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">

                        <div class="item active">
                            <div class="jumbotron">
                                <img src="img/formUnic.png" width="760" height="400">
                            </div>
                            <div class="carousel-caption">
                                <h4><a class="label label-primaryhelp" href="#">Proceso de formato único</a></h4>
                            </div>
                        </div>

                        <div class="item">
                            <div class="jumbotron">
                                <img src="img/repBim.png" width="760" height="400">
                            </div>
                            <div class="carousel-caption">
                                <h4><a class="label label-primaryhelp" href="#">Proceso de Reporte Bimestral</a></h4>
                            </div>
                        </div>

                        <div class="item">
                            <div class="jumbotron">
                                <img src="img/docFin.png" width="760" height="400">
                            </div>
                            <div class="carousel-caption">
                                <h4><a class="label label-primaryhelp" href="#">Proceso de Documentos Finales</a></h4>
                            </div>
                        </div>

                        <div class="item">
                            <div class="jumbotron">
                                <img src="img/sanciones.png" width="760" height="400">
                            </div>
                            <div class="carousel-caption">
                                <h4><a class="label label-primaryhelp" href="#">Proceso de sanciones</a></h4>                           
                            </div>
                        </div>

                    </div>


                    <ul class="list-group col-sm-4">
                        <li data-target="#myCarousel" data-slide-to="0" class="list-group-item active"><h4>Ayuda para realizar correctamente el proceso de tu formato único</h4></li>
                        <li data-target="#myCarousel" data-slide-to="1" class="list-group-item"><h4>Cómo poder relizar de manera adecuada el proceso de llenar y subir tu Reporte Bimestral</h4></li>
                        <li data-target="#myCarousel" data-slide-to="2" class="list-group-item"><h4>Ayuda con el proceso de Documentos Finales </h4></li>
                        <li data-target="#myCarousel" data-slide-to="3" class="list-group-item"><h4>Cómo hacerte acreedor a una sanción y como se lleva acabo este proceso </h4></li>

                    </ul>


                    <div class="carousel-controls">
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>

                </div>
            </div>         
            <br>   
            <br>   
            <br>   
            <!--/row--> 
            <%@include file="../General/footer.jsp"%>            
            <%@include file="../General/js.jsp"%>
            <script type="text/javascript" src="js/helpCarousel.js"></script> 
        </div>
    </body>
</html>
