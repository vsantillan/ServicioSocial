<%@include file="General/jstl.jsp"%>
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
                <%@include file="../General/submenuUsuario.jsp"%>
                <!--------------------------------------------------Contenido--> 
                <div class="bs-docs-section">
                    <div class="page-header">
                        <!---------------------------------------Bienvenido Nombre Usuario-->    
                        <h1 class="derecha" >Bienvenido Usuario</h1>
                        <!---------------------------------------Fin Bienvenido Nombre Usuario-->                                     
                    </div>
                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Noticias Generales</h3>
                        <!---------------------------------------Contenido Noticias Generales-------------------> 
                        <p>hola</p>
                        <p>hola</p>
                        <!---------------------------------------Fin Contenido Noticias Generales------------------->
                    </div>
                    <div class="page-header borde-naranja">
                        <h3 class="titulos-naranja">Observaciones</h3>
                        <!---------------------------------------Contenido Observaciones----------------------------->
                        <p>hola</p>
                        <p>hola</p>
                        <!---------------------------------------Fin Contenido Observaciones------------------->
                    </div>
                    <div class="page-header  borde-naranja">
                        <h3 class="titulos-naranja">Sanciones</h3>
                        <!---------------------------------------Contenido Sanciones----------------------------->
                        <p>hola</p>
                        <p>hola</p>
                        <!---------------------------------------Fin Contenido Sanciones------------------->
                    </div>
                </div>
                <!--------------------------------------------------Fin Contenido--> 
            </div>         
        </div><!--/row--> 
        <%@include file="../General/footer.jsp"%>            
    </div><!--/row-->
</div> <!-- /container -->
<%@include file="../General/js.jsp"%>
</body>
</html>
