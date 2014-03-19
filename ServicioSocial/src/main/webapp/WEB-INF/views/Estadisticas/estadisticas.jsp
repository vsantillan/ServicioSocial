<%-- 
    Document   : estadisticas
    Created on : 18/03/2014, 10:42:17 AM
    Author     : rodrigo
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
                <div class="row col-md-12 center-block">
                <div class=" row help-block col-md-12 text-center"><h1 class=""><span class="glyphicon glyphicon-stats"></span>&nbsp; Estadisticas</h1></div>


            </div>
            <%@include file="../General/footer.jsp"%> 
            </div>
        </div>


        
        <%@include file="../General/js.jsp"%>
        <script type="text/javascript" src="js/formatoUnicoAdmin.js"></script>
        <script type="text/javascript">
            $('#formatoUnico-tabla a:first').tab('show');
        </script>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>
