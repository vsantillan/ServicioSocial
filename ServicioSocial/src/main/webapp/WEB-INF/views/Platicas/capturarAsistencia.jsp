<%-- 
    Document   : capturarAsistencia
    Created on : 4/06/2013, 09:47:02 AM
    Author     : mary
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Capturar Asistencia a Pl�tica</title>
    </head>
    <body onload="document.casistencia.numeroFolio.focus()">
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-pencil"></span>&nbsp; Capturar Asitencia</h2></div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="panel panel-info">
                            <div class="panel-heading">Capturar Asistencia</div>
                            <div class="panel-body">
                                <form:form  name="casistencia" id="casistencia" action="ponerAsistencia.do" method="post" commandName="foliosPlatica" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-md-10">
                                            <label for="alumno">N�mero de Folio</label>
                                            <form:input class="form-control" type="text" path="numeroFolio" size="15" name="numeroFolio" />  
                                        </div>
                                        <div class="col-md-2">
                                            <label></label>
                                            ${colocado}
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <form:errors path="numeroFolio" class="alert alert-danger"/>
                                        ${existe}
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary col-md-offset-5">Enviar</button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
<!--                        <image src="${foto}"/>-->
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
    </body>
</html>
