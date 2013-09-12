<%-- 
    Document   : convocatorias
    Created on : 10-jun-2013, 11:47:53
    Author     : bustedvillain
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <title>Departamento de Servicio Social</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>Contacto</h1>
               
                <div>${message}</div>
                <form:form commandName="Contacto" id="Contacto" name="Contacto" action="contacto.do" method="POST">
                    
                    
                                <table>
                                    <tr>
                                        <td>Nombre:</td>
                                        <td><form:input path="nombre"/><br/>
                                            <form:errors path="nombre" cssClass="error"/>  
                                            
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Asunto:</td>
                                        <td><form:input path="asunto"/><br/>
                                            <form:errors path="asunto" cssClass="error"/> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Correo Electr&oacute;nico:</td>
                                        <td><form:input path="correo"/><br/>
                                            <form:errors path="correo" cssClass="error"/> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> <p><label for="detalle">Descripci&oacute;n:</label> </p></td>
                                        <td>  <form:textarea  path="detalle" rows="8" cols="50" maxlength="300" /><br/>
                                              <form:errors path="detalle" cssClass="error"/> 
                                        </td>
                                            
                                    </tr>
                                    <tr> 
                                        <td> <input type ="submit" value = "Guardar " /> </td>
                                    </tr>
                                </table>
                            </form:form>
                
            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>