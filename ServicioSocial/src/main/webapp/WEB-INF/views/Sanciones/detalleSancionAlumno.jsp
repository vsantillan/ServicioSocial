<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="row col-md-12 center-block">
                    <br>
                    <div class="panel panel-tec">
                        <div class="panel-heading">
                            
                            <center><h2>Pago de Sanciones</h2></center>
                             </div>
                             <div class="page-body">
                            <br />
                            
                             <h4><b>No. Control:</b><core:out value="${sancion.datosPersonalesId.alumnoId.id}" /></h4>
                            <h4><b>Nombre:</b><core:out value="${sancion.datosPersonalesId.nombre}${espacio}${sancion.datosPersonalesId.apellidoP}${espacio}${sancion.datosPersonalesId.apellidoM}" /></h4>
                            <h4><b>Horas Restantes:</b>${sancion.horasSancion}</h4>
                            <div class="col-md-6">
                                <form:form action="pagoSancionAlumno.do" method="POST" >
                                <div class="form-group">
                                        <label for="horas">Horas a pagar:</label>
                                        <input type="number" class="form-control" autofocus="true" name="horas" id="horas" size="15" />
                                        ${mensajeSancion}
                                    </div>
                                     <input type="hidden" value="${sancion.id}" name ="id" id="id"/>
                                    <div class="form-group">
                                        <div class="col-md-3">
                                            <input class="btn btn-primary" type ="button" id="pagoSancion" value = "Guardar " /> 
                                        </div>
                                    </div>
                                </form:form>
                                     <div id="mensaje"></div>
                            </div>
                            
                        </div>

                        <%-- fin del contenido --%>
                    </div><!--/row--> 
                </div>
                <%--<%@include file="../General/footer.jsp"%>--%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
