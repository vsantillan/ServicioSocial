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
                <%-- Formulario Nueva Plática --%>
                <form:form name="altaPlatica" id="MyForm" action="#" method="POST">
                    <table>
                        <tr>
                            <td> <label for="fecha">Fecha</label> </td>
                            <td> <input type="text" name="fecha" id="datepicker" size="15"/></td>  
                        </tr>
                        <tr>
                            <td>  <label for="hora">Hora</label> </td>
                            <td>  <input type="text" name="hora" id="hora" size="15" /></td>  
                        </tr>
                        <tr>
                            <td>  <label for="lugar">Lugar De la Platica de Inducción</label></td>
                            <td>  <input type="text" name="lugar" id="lugar" size="20" /> </td>  
                        </tr>

                        <tr>
                            <td> <label for="semestre">Periodo</label> </td>
                            <td>
                                <select id="semestre" name="semestre">
                                    <option value="ENE-JUN">ENE-JUN</option>
                                    <option value="AGO-DIC">AGO-DIC</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="ano"> Año  </label> </td>   
                            <td>     
                                <select id="anio" name="anio">         
                                    <core:forEach var="i" begin="${anioInicio}" end="${anioFin}" step="1">
                                        <option value="${i}"><core:out value="${i}" /></option>
                                    </core:forEach>
                            </td>

                        </tr>
                        <tr>
                            <td> <label for="tipoPlatica">Tipo de platica</label> </td>
                            <td> <select id="tipo" name="tipo">
                                    <option  value="NORMAL">Normal</option>
                                    <option  value="BECADO">Becado</option>
                                    <option  value="ESPECIAL">Especial</option>
                                </select>    
                            </td>  
                        </tr>
                        <tr>
                            <td>  <label for="descripcion"> Descripción </label> </td>
                            <td>  <textarea  name="descripcion" rows="4" cols="50" id="descripcion"></textarea> </td>  
                        </tr>

                        <tr> 
                            <td>  <label for="fecha_max_fui">Fecha máxima formato unico</label>  </td>
                            <td><input type="text" name="fecha_max_fui" id="datepicker2" size="15" /> </td>
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
