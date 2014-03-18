<%@page import="edu.servicio.toluca.beans.ValidaSesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <div class="nav navbar-inverse " role="navigation">
                    <div class="container">
                        <div class="navbar-inner">
                            <ul class="nav navbar-nav" role="navigation">                                
                                <li>&nbsp;</li>
                            </ul>
                        </div><!--/.nav-collapse --></div></div></div>
            <div class="row ">
                <!---------------------------------------------Contenido------------------------------------------->                
                <br>               
                <div class="jumbotron alert alert-danger col-md-offset-1 col-md-10 ">

                    <h1>¡Error 404!</h1>
                    <p>Página no encontrada</p>
                </div> 
                <!---------------------------------------------Fin Contenido------------------------------------------->                

            </div><!--/row--> 
            <%@include file="../General/footer.jsp"%>           
        </div><!--/row-->
    </div> <!-- /container -->
    <%@include file="../General/js.jsp"%>
</body>
</html>
