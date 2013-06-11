<%-- 
    Document   : loginOrganizaciones
    Created on : 10-jun-2013, 11:24:26
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
        <script src="js/jquery.manolo.js"></script>  
        <title>Departamento de Servicio Social :: Organizaciones ::</title>
    </head>
    <body onload="MM_preloadImages('imagenes/logo_tec_r.png');">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>Login Organizaciones</h1>

                <form:form name="formLoginOrg" id="MyForm" action="validaLoginOrg.do" method="POST" style="width:400px; height:200px">
                    <table>
                        <tr>
                            <td> <label for="correo">Correo:</label> </td>
                            <td> 
                                <input type="text" name="correo" id="correo" size="20" require="true" />
                                <div style="color:red; display:none;" id="div_correo_organizacion"><b>*Campo de correo requerido</b></div>
                            </td>  
                        </tr>
                        <tr>
                            <td><label for="password">Contrase&ntilde;a:</label></td>
                            <td> 
                                <input type="password" name="pass" id="pass" size="20" require="true" />
                                <div style="color:red; display:none;" id="div_pass_organizacion"><b>*Campo de contrase&ntilde;a requerido</b></div>
                            </td> 
                        </tr>
                        <tr> 
                            <td> <input type ="button" id="btnLoginOrg" value = "Entrar" /> </td>
                            <td> <input type ="button" id="olvidoPassOrg"value = "Olvide mi Contrase&ntilde;a" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div id="respLoginOrg"></div>
                            </td>
                        </tr>
                    </table>
                </form:form> 
                <br/><br/><br/>
            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>