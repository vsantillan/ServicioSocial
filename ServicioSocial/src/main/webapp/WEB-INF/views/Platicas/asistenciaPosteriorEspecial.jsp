<%-- 
    Document   : AsistenciaPosteriorEspecial
    Created on : 4/06/2013, 12:19:34 PM
    Author     : mary
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
                    <div class="col-md-6 col-md-offset-3">
                        <center><h2>Capturar Asistencia Especial Posterior</h2></center> 
                            
                        ${alert}
                        <!-- Formulario Plática Posterios -->  
                        <core:choose>
                            <core:when test="${empty platicasPeriodo}">
                                <p class="bg-warning">No hay platicas activas</p>
                            </core:when>
                            <core:otherwise>                         
                                <form:form name="casistenciaespecial" id="casistenciaespecial" action="capturarAsistenciaPosteriorEspecial.do" method="Post" class="form-horizontal ">
                                    <div class="form-group">
                                        <label for="seleccionaFecha">Seleccione Plática:</label>
                                        <select class="form-control" name="idPlatica" id="idPlatica">
                                            <core:forEach items="${platicasPeriodo}" var="platicasPeriodo" >
                                                <core:choose>
                                                    <core:when test="${idP==platicasPeriodo.id}">
                                                        <option value="${platicasPeriodo.id}" selected="selected" ><fmt:formatDate pattern="dd-MM-yyyy"  value="${platicasPeriodo.fecha}" /></option> 
                                                    </core:when>
                                                    <core:otherwise>
                                                        <option value="${platicasPeriodo.id}"><fmt:formatDate pattern="dd-MM-yyyy" value="${platicasPeriodo.fecha}"/></option> 
                                                    </core:otherwise>
                                                </core:choose>                                   
                                            </core:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="no_control">Número de Control:</label>
                                        <input type="text" class="form-control" autofocus="true"name="no_control" id="no_control" size="15" />
                                    </div>
                                    ${error}
                                    <div class="form-group">
                                        <div class=" col-md-offset-2 col-sm-5">
                                            <input  class="btn btn-primary" type ="reset" value = "Limpiar" />
                                        </div>
                                        <div class="col-sm-5">
                                            <input   class="btn btn-primary" type ="submit" value = "Guardar " /> 
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="losCampos">Los campos con * son obligatorios</label>
                                    </div>
                                </form:form>
                                <h3>Folio:${folio}</h3>
                            </core:otherwise>
                        </core:choose>
                    </div>
                    <!---------------------------------------------Fin Contenido-------------------------------------------> 
                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
