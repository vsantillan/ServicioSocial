<%-- 
    Document   : seleccionarPlatica
    Created on : 4/06/2013, 12:56:28 PM
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
                <%@include file="../General/menuUsuario.jsp"%> 
                <div class="col-md-6 col-md-offset-3">
                    <core:choose>
                        <core:when test="${empty platicasPeriodo}">
                            <h1 class="alert alert-warning">  <span class="glyphicon glyphicon-warning-sign"></span> &nbsp; No hay pláticas disponibles</h1>
                        </core:when>
                        <core:otherwise>
                            <center><h1>Selecciona Plática</h1></center>
                                <form:form action="folioPlatica.pdf" method="post" target="_blank" class="form-horizontal" id="formSelecciona" commandName="platica" onsubmit="return marcado();" name="seleccionaPlatica">
                                <h1>Fechas Disponibles</h1>
                                <form:select path="fecha" class="form-control" >
                                    <core:forEach  items="${platicasPeriodo}" var="platicasPeriodo" >
                                        <form:option  value="${platicasPeriodo.id}"><fmt:formatDate pattern="dd/MM/yyyy" value="${platicasPeriodo.fecha}" /></form:option>                                    
                                    </core:forEach>
                                </form:select>
                                <p></p>               
                                <textarea id="hora"disabled="true" rows="1" class="form-control alert alert-info">Hora: ${platicasPeriodo.get(0).hora} </textarea>
                                <textarea id="lugar" disabled="true" rows="1" class="form-control alert alert-info">Lugar: ${platicasPeriodo.get(0).idLugar.lugar}</textarea>
                                <textarea  id="descripcion" rows="4" cols="50" disabled="true" class="form-control alert alert-info" >Descripción:${platicasPeriodo.get(0).descripcion}</textarea>
                                <input type="checkbox" name="aceptacionleer" value="aceptacionleer" id="aceptacionleer"><a href="muestraPdf.do" style="color:#029bef" class="fancyFU">  Acepto haber leído el manual</a>
                                donde se describe el uso del sistema via web sobre como dar de alta mi servicio social<p></p>
                                <input value="Generar Folio" class="btn btn-primary GenFolio" type="submit"/> <br>
                            </form:form>
                            ${existe}
                        </core:otherwise>
                    </core:choose>

                </div>         
            </div><!--/row--> 
            <%@include file="../General/footer.jsp"%> 
        </div><!--/row-->
    </div> <!-- /container -->
    <%@include file="../General/js.jsp"%>
    <%@include file="../Template/headsModal.jsp" %>
    <script type="text/javascript" src="js/platica.js"></script>
</body>
</html>