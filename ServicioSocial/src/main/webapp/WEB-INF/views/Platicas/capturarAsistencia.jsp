<%-- 
    Document   : capturarAsistencia
    Created on : 4/06/2013, 09:47:02 AM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />

        <link rel="stylesheet" href="css/platicasEstiloFormularioformly.css" type="text/css" />


        <script type="text/javascript" src="js/platicasEstiloFormularioformly.js"></script>

        <script>

            $(document).ready(function() {

                $('#casistencia').formly();
            });
        </script>
        <title>Capturar Asistencia a Plática</title>
    </head>
    <body class="background" onload="document.casistencia.numeroFolio.focus()">
        <jsp:include page="../Template/banner.jsp" />
        <div id="contenido" >  
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center><h2>Capturar Asistencia a Plática</h2></center>  
                ${existe}
                <form:form  name="casistencia" id="casistencia" action="asistencia.do" method="post" commandName="foliosPlatica">
                    <center>
                        <table >
                            <tr>
                                <td><label for="alumno">Número de Folio</label></td>
                                 <td><form:input type="text" path="numeroFolio" size="25" name="numeroFolio" /></td>
                            </tr>
                      
                            <tr>
                               <td><button type="submit">Enviar</button></td>  
                            </tr>
                        
                        </table>
                            <form:errors path="numeroFolio" cssClass="error"/>
                    </center>
                    </form:form>
                <image src="${foto}"/>

            </div>
            <div style="clear:both;"></div>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
