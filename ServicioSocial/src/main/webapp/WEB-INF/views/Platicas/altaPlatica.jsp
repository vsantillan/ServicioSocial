<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>
        <script src="js/jqueryUI/jquery.ui.timepicker.js"></script>
        <script type="text/javascript" src="js/jqueryUI/i18n/jquery.ui.datepicker-es"></script>
        <script>
            $(function() {
                $('#hora2').timepicker();


            });
        </script>
         

        <title>Alta Plática</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');" >
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center> 
                    <h1>Nueva Plática</h1>
                    ${notificacion}
                    <%-- Formulario Nueva Plática --%>
                    <form:form action="altaPlaticaBD.do" method="post" modelAttribute="platica" id="MyForm"> 
                        <table >
                            <tr>
                                <td>
                                    <form:input type="hidden" value="1" path="status"/>
                                    <label for="fecha">Fecha</label> </td>

                                <td> <form:input path="fecha" id="datepicker" size="15"/></td>  
                            </tr>
                            <tr>
                                <td>  <label for="hora">Hora</label> </td>
                                <td>  <form:input  path="hora" id="hora2" size="15" /></td>  
                            </tr>
                            <tr>
                                <td>  <label for="lugar">Lugar De la Platica de Inducción</label></td>
                                <td>  <form:input path="lugar" id="lugar" size="20" /> </td>  
                            </tr>

                            <tr>
                                <td> <label for="periodo">Periodo</label> </td>
                                <td>
                                    <form:select path="periodo">
                                        <form:option value="ENE-JUN"/>
                                        <form:option value="AGO-DIC"/>
                                    </form:select>    
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="ano"> Año  </label> </td>   
                                <td>     
                                    <form:select id="anio" path="anio">         
                                        <core:forEach var="i" begin="${anioInicio}" end="${anioFin}" step="1">
                                            <form:option value="${i}"/><core:out value="${i}" />
                                        </core:forEach>
                                    </form:select>
                                </td>

                            </tr>
                            <tr>
                                <td> <label for="tipoPlatica">Tipo de platica</label> </td>
                                <td> <form:select id="tipo" path="tipo">
                                        <form:option  value="1">Normal</form:option>
                                        <form:option  value="2">Becado</form:option>
                                        <form:option  value="3">Especial</form:option>
                                    </form:select>    
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="descripcion"> Descripción </label> </td>
                                <td>  <form:textarea  path="descripcion" rows="4" cols="50" id="descripcion"/></td>  
                            </tr>

                            <tr> 
                                <td>  <label for="fecha_max_fui">Fecha máxima formato unico</label>  </td>
                                <td><form:input  path="fechaMxFui" id="datepicker2" size="15" /> </td>
                            </tr>
                            <tr> 
                                <td> <input type ="submit" value = "Guardar " /> </td>
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
