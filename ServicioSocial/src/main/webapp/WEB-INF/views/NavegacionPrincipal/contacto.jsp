<%-- 
    Document   : convocatorias
    Created on : 10-jun-2013, 11:47:53
    Author     : bustedvillain
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
                <%@include file="../General/menuPrincipal.jsp"%> 
            </div><!--/row-->
            <div class="row ">
                <!---------------------------------------------Contenido------------------------------------------->                
                <center>
                    <h1>Contacto</h1>

                    <div>${message}</div>
                    <form:form commandName="Contacto" id="Contacto" name="Contacto" action="contacto.do" class="MyForm" method="POST" acceptCharset="UTF-8">
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
                                <td> <input type ="submit" value = "Enviar" /> </td>
                            </tr>
                        </table>
                    </form:form>
                </center>
            </div><!--/row-->
            <%@include file="../General/footer.jsp"%>           
        </div> <!-- /container -->
        <%@include file="../General/js.jsp"%>
    </body>