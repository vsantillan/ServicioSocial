<%-- 
    Document   : editaSancion
    Created on : 11/06/2013, 11:21:00 AM
    Author     : Regules
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
        <script type="text/javascript" language="javascript" src="js/sanciones.js"></script>
        <title>Editar Sanci&oacute;n</title>
    </head>
    <body>
        <%-- inicio del contenido --%>
        <div id="contenido" style="width: 700px">
            <div style="padding-left: 10px; padding-right: 10px; padding-bottom: 10px ">
                <center> 
                    <h1>Editar Sanci&oacute;n</h1>
                    <form:form name="nuevaSancion"  onsubmit="window.parent.Shadowbox.close();">
                        <table>
                            <tr>
                            <input type="hidden" value="${idSancion}" name ="id" id="idSancion"/>
                            <td> <label for="descripcion">Descripci&oacute;n:</label> </td>
                            <td> <textarea name="descripcion" rows="4" cols="50" id="eDescripion">${descripcion}</textarea> </td>
                            </tr>
                            <tr>
                                <td>  <label for="hora">Horas:</label> </td>
                                <td>  <input type="text" name="horas" id="eHoras" size="15" value="${horas}" /></td>  
                            </tr>
                            <tr>
                                <td> <p><label for="tolerancia">D&iacute;as de tolerancia</label></p> </td>
                                <td>  <input type="number" id="eTolerancia" name="tolerancia" size="2" value="${tolerancia}" pagoSanciones/></td>  
                            </tr>
                            <tr> 
                                <td> <input type ="button"  onclick="editarSancion2();" value = "Guardar " /> </td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>
                        </table>
                    </form:form>
                    <div id="observaciones" style="display: none">
                        <b>Debes atender los siguientes puntos</b><br/>
                        <ul id="listaObservaciones" >

                        </ul>

                    </div>
                </center>
            </div>                
        </div>
    </body>
</html>

