<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
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
                        <center><h3>Nueva Pl&aacute;tica</h3></center>
                            ${alert}
                        <!-- Formulario Nueva Pl�tica -->  
                        <form:form action="altaPlaticaBD.do" method="post" commandName="platica" id="formPlatica"  class="form-horizontal" role="form" name="altaPlatica" > 

                            <div class="form-group">
                                <label for="fecha">Fecha </label>
                                
                            </div>
                            <div class="form-group">
                                <label for="hora" >Hora </label>
                                <form:input class="form-control" path="fecha" id="datepicker" size="15"/>
                            </div>
                            <div class="form-group">
                                <label for="lugar" >Lugar de la pl�tica de inducci�n </label>                              
                                <form:input class="form-control" path="fecha" id="datepicker" size="15"/>
                            </div>
                            <div class="form-group">
                                <label for="periodo">Periodo</label>
                                <form:input class="form-control" path="fecha" id="datepicker" size="15"/>
                            </div>
                            <div class="form-group">
                                <label for="ano">A&ntilde;o</label> 
                                <form:select class="form-control" id="anio" path="anio">         
                                    <core:forEach var="i" begin="${anioInicio}" end="${anioFin}" step="1">
                                        <form:option value="${i}"/><core:out value="${i}" />
                                    </core:forEach>
                                </form:select>
                            </div>
                            <div class="form-group">
                                <label for="tipoPlatica">Tipo de Platica</label>
                                <form:select  class="form-control" id="tipo" path="tipo">
                                    <form:option  value="1">NORMAL</form:option>
                                    <form:option  value="2">BECADOS</form:option>
                                    <form:option  value="3">ESPECIAL</form:option>
                                </form:select> 
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripci&oacute;n de la platica</label> 
                                <form:textarea  path="descripcion"  id="descripcion"  class="form-control" rows="3"/>
                            </div>
                            <div class="form-group">
                                <label for="fecha_max_fui">Fecha m&aacute;xima para subir formato &uacute;nico</label>
                                <form:input class="form-control"  path="fechaMxFui" id="datepicker2" size="15" /> 
                            </div>
                            <div class="form-group">

                                <div class=" col-md-offset-2 col-sm-5">
                                    <input  class="btn btn-primary" type ="reset" value = "Limpiar" />
                                </div>
                                <div class="col-sm-5">
                                    <input   class="btn btn-primary" type ="submit" value = "Guardar " /> 
                                </div>
                            </div>
                        </form:form>


                    </div>




                    <!---------------------------------------------Fin Contenido-------------------------------------------> 
                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>           
            </div><!--/row-->
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>
</html>
