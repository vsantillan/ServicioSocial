<%-- 
    Document   : panelAdministrador
    Created on : 3/06/2013, 01:01:53 PM
    Author     : Regules
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
                <%@include file="../General/menuAdministrador.jsp"%> 
                <div class="row ">
                    <!---------------------------------------------Contenido------------------------------------------->                

                    <div class="jumbotron">
                        <h1 >Bienvenido(a)!</h1>
                        <br/><br/><br/>
                    </div>

                    <!---------------------------------------------Fin Contenido-------------------------------------------> 
                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
