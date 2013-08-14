<%-- 
    Document   : loginAlumnos
    Created on : 10-jun-2013, 11:24:14
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <title>Departamento de Servicio Social :: Organizaciones ::</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>Login</h1>
                <form:form name="formLoginOrg" class="MyForm" action="validaLogin.do" method="POST" style="width:400px; height:230px">
                    <table>
                        <tr>
                            <td> <label for="usuario">Usuario (alu_00289999):</label> </td>
                            <td> 
                                <input type="text" name="usuario" id="usuario" size="20" require="true" />
                            </td>  
                        </tr>
                        <tr>
                            <td><label for="password">Contrase&ntilde;a:</label></td>
                            <td> 
                                <input type="password" name="pass" id="pass" size="20" require="true" />
                            </td> 
                        </tr>
                        <tr> 
                            <td colspan="2"> <input type ="submit" value = "Entrar" /> </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div id="respLoginOrg"></div>
                            </td>
                        </tr>
                        ${error}
                    </table>
                    <h3>Recuerda que para acceder tienes que contar con los cr&eacute;ditos suficientes.</h3>
                </form:form> 
                
                <br/><br/><br/><br/><br/><br/><br/>
                
            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>