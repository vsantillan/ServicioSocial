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
        <jsp:include page="js.jsp" />
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        <script src="js/jqueryUI/jquery.ui.timepicker.js"></script>


        <script>

            $(document).ready(function() {

                $('#formPlatica').formly();
            });

        </script>
        <script>
            var fecha = new Date();
            var anio = fecha.getFullYear();
            // var select = document.getElementsByTagName('anio')[0];
            var s = document.MyForm.anio;
            select.options.length = 0; // clear out existing items
            for (var i = 0; i < 4; i++) {
                var option = document.createElement("option");
                var d = ano + 1;
                option.value = anio + 1;
                //option.text="Aqui va el texto"; 
                s.appendChild(option); // y aqui lo añadiste
            }

        </script>
        <style type="text/css">
            <!--



            #MyForm label
            {
                width: 150px;
                display: block
            }
        </style>

        <title>Alta Plática</title>
    </head>

    <body class="background" onload="document.platica.fecha.focus()" >

        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido style="width:500"--%>
        <div id="contenido" >
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center> 
                    <h1>Nueva Plática</h1>
                    ${notificacion}
                    <%-- Formulario Nueva Plática --%>
                    <form:form action="altaPlaticaBD.do" method="post" commandName="platica" id="formPlatica" name="altaPlatica" > 
                        <table>
                            <tr>
                                <td> <label for="fecha"><fmt:message key="fecha" /></label></td>
                                <td> <form:input path="fecha" id="datepicker" size="15"/></td> 
                                <td><form:errors path="fecha" cssClass="error" /></td>
                                <td> <form:input type="hidden" value="1" path="status"/></td>
                            </tr>
                            <tr>
                                <td>  <label for="hora"><fmt:message key="hora" /></label> </td>
                                <td>  <form:input  path="hora" id="hora2" size="15" /></td>  
                                <td><form:errors path="hora" cssClass="error" /></td>
                            </tr>
                            <tr>
                                <td>  <label for="lugar"><fmt:message key="lugar" /></label></td>

                                <td>  

                                    <form:select path="idLugar.id">

                                        <core:forEach items="${lugares}" var="lugares" >
                                            <form:option value="${lugares.id}">${lugares.lugar}</form:option>
                                            <%--  <form:options items="${lugares}" itemValue="id" itemLabel="lugar" /> --%>
                                        </core:forEach>
                                    </form:select>

                                </td>  

                            </tr>
                            <td></td>
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
                                        <form:option  value="1">Normal</form:option>
                                        <form:option  value="2">Becarios</form:option>
                                        <form:option  value="3">Especial</form:option>
                                    </form:select>    
                                </td>  
                                <td></td>
                            </tr>
                            <tr>
                                <td>  <label for="descripcion"> <fmt:message key="descripcion" /> </label> </td>
                                <td>  <form:textarea  path="descripcion" rows="10" cols="40" id="descripcion"/></td> 
                                <td></td>
                            </tr>

                            <tr> 
                                <td>  <label for="fecha_max_fui"><fmt:message key="fecha_max_fui" /> </label>  </td>
                                <td><form:input  path="fechaMxFui" id="datepicker2" size="15" /> </td>
                                <td><form:errors path="fechaMxFui" cssClass="error" /></td>
                            </tr>
                            <tr> 
                                <td> <input type ="submit" value = "Guardar " /> </td>
                                <td></td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>
                    </form:form>
                </center>
            </div>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />

    </body>
</html>
