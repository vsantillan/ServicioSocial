<%-- 
    Document   : envioCorreo
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsJQueryUI.jsp" />
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />
        <title>Envio Correos</title>
    </head>
    <body >
         
      
        <%-- inicio del contenido --%>
        <div id="contenido">
            <center> 
            <h1>Envio Correos</h1>
             <%-- Envio Correos --%>
            <div>
                    <form>
                        <table>
                            <tr>
                                <td>Destinatarios:</td>
                                <td><input type ="text" name ="nombre"  disabled="disabled"> </td>
                            </tr>
                            <tr>
                                <td>Asunto:</td>
                                <td><input type ="text" > </td>
                            </tr>
                            <tr>
                                <td>Descripci&oacute;n:</td>
                                <td><textarea name="descripcion" rows="10" cols="70"></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Enviar" > </td>
                            </tr>
                        </table>
                    </form>
                </div>
          </center>
        </div>
        <%-- fin del contenido --%>
    </body>
</html>
