<%-- 
    Document   : capturarAsistencia
    Created on : 4/06/2013, 09:47:02 AM
    Author     : mary
--%>

<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
        <title>Capturar Asistencia a Plática</title>
    </head>
    <body onload="document.casistencia.numeroFolio.focus()">
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%>
                <center><h3>Capturar Asistencia</h3></center>

           
                    ${existe}
                    <form:form  name="casistencia" id="casistencia" action="asistencia.do" method="post" commandName="foliosPlatica">
                        <center>
                            <table >
                                <tr>
                                    <td><label for="alumno">Número de Folio</label></td>
                                    <td><form:input type="text" path="numeroFolio" size="25" name="numeroFolio" /></td>
                                </tr>

                                <tr>
                                    <td><button type="submit" class="btn btn-primary">Enviar</button></td>  
                                </tr>

                            </table>
                            <form:errors path="numeroFolio" cssClass="error"/>
                        </center>
                    </form:form>
                    <image src="${foto}"/>
                <%@include file="../General/footer.jsp"%> 
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
    </body>
</html>
