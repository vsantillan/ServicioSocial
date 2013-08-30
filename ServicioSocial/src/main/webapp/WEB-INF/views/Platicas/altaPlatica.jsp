<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <jsp:include page="../Template/headsModal.jsp" />
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        <script type="text/javascript" src="js/jqueryUI/jquery.ui.timepicker.js"></script>
        <script type="text/javascript" src="js/platica.js"></script>
        <title>Alta Plática</title>
    </head>

    <body class="background" >

        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido style="width:500"--%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">
                <center> 
                    <h1>Nueva Plática</h1>
                    <%-- Formulario Nueva Plática --%>
                    <form:form action="altaPlaticaBD.do" method="post" commandName="platica" id="formPlatica" name="altaPlatica" > 
                        <table>
                            <tr>
                                <td> <label for="fecha"><fmt:message key="fecha" /></label></td>
                                <td> <form:input path="fecha" id="datepicker" size="15"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="3"><form:errors path="fecha" cssClass="error" /></td>
                            </tr>
                            <tr>
                                <td>  <label for="hora"><fmt:message key="hora" /></label> </td>
                                <td>  <form:input  path="hora" id="hora" size="15" /></td>  
                                <td></td>
                            </tr>
                             <tr>
                               <td><form:errors path="hora" cssClass="error" /></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><label for="lugar"><fmt:message key="lugar" /></label></td>
                                <td>  
                                    <form:select path="idLugar.id">
                                        <core:forEach items="${lugares}" var="lugares" >
                                            <form:option value="${lugares.id}">${lugares.lugar}</form:option>
                                        </core:forEach>
                                    </form:select>
                                </td>  
                                <td><input type ="button" id="agregaLugar" value = "Agregar lugar" /></td>
                            </tr>
                            <tr>
                                <td> <label for="periodo"><fmt:message key="periodo" /></label> </td>
                                <td>
                                    <form:select path="periodo">
                                        <form:option value="ENE-JUN"/>
                                        <form:option value="AGO-DIC"/>
                                    </form:select>    
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>  <label for="ano"> <fmt:message key="anio" />  </label> </td>   
                                <td>     
                                    <form:select id="anio" path="anio">         
                                        <core:forEach var="i" begin="${anioInicio}" end="${anioFin}" step="1">
                                            <form:option value="${i}"/><core:out value="${i}" />
                                        </core:forEach>
                                    </form:select>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> <label for="tipoPlatica"><fmt:message key="tipo" /></label> </td>
                                <td> <form:select id="tipo" path="tipo">
                                        <form:option  value="1">NORMAL</form:option>
                                        <form:option  value="2">BECADOS</form:option>
                                        <form:option  value="3">ESPECIAL</form:option>
                                    </form:select>    
                                </td>  
                                <td></td>
                            </tr>
                            <tr>
                                <td><label for="descripcion"> <fmt:message key="descripcion" /> </label> </td>
                                <td><form:textarea  path="descripcion" rows="10" cols="30" id="descripcion" onkeyup="javascript:this.value=this.value.toUpperCase();"/></td> 
                                <td></td>
                            </tr>

                            <tr> 
                                <td><label for="fecha_max_fui"><fmt:message key="fecha_max_fui" /> </label>  </td>
                                <td><form:input  path="fechaMxFui" id="datepicker2" size="15" /> </td>
                                <td></td>
                            </tr>
                             <tr> 
                                <td><form:errors path="fechaMxFui" cssClass="error" /></td>
                                <td colspan="2">${errorFm}</td>
                                
                            </tr>
                            <tr> 
                                <td><b><fmt:message key="datosRequeridos" /></b></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr> 
                                <th>${exito}</th>
                            </tr>

                            <tr> 
                                <td> <input type ="submit" value = "Guardar " /> </td>
                                <td></td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>
                    </form:form>
                    <div id="resultado"></div>
                    <div id="myDivID" style="display:none">
                        <form:form action="guardaLugar.do" commandName="lugares" method="post"  modelAttribute="lugaresPlatica" name="altaLugares">  
                            <table>
                                <tr>
                                    <td><label for="Lugar"><fmt:message key="agregarLugar" /></label></td>
                                    <td><form:input   path="lugar" size="50px" /></td>
                                    <td><form:errors path="lugar" cssClass="error" /></td>
                                </tr>
                                <tr> 
                                <td></td>
                                <td><b><fmt:message key="datosRequeridos" /></b></td>
                                <td></td>
                            </tr>
                                <tr> 
                                    <td> <input type ="submit" id="guardar" value = "Guardar " /> </td>
                                     <td> </td>
                                    <td><input type ="reset" value = "Limpiar" /></td>
                                </tr>
                            </table>
                        </form:form>
                    </div>

                </center>
            </div>

            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />

    </body>
</html>
