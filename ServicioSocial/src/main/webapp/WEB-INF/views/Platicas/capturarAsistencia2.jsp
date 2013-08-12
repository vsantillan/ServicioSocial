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

        <title>Capturar Asistencia a Plática</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />
      <div id="contenido" >  
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left;">
                <center><h2>Capturar Asistencia a Plática</h2></center>  
                ${existe}
                <form:form  name="casistencia" id="casistencia" action="ponerAsistencia.do" method="post" commandName="foliosPlatica">
                    <center>
                        <table >
                            <tr>
                                <td><label for="alumno">Número de Folio</label></td>
                                <td><form:input type="text"  path="numeroFolio" size="25" name="numeroFolio" /></td>
                            </tr>
                      
                            <tr>
                                <td><button type="submit" autofocus="true">Asistió</button></td>  
                               <td><button type="button" id="regresar" onclick="redirecciona('capturarAsistencia.do')">Regresar</button></td>
                            </tr>
                        
                        </table>
                            <form:errors path="numeroFolio" cssClass="error"/>
                    </center>
                    </form:form>
                <table>
                    <tr>
                        <td><img src="mostrarFoto.do?id=${alumno.id}"  width="80px" alt="${alumno.id}"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td>${alumno.nombre}${espacio}${alumno.apellidoPat}${espacio}${alumno.apellidoMat}</td>
                    </tr>
                    <tr>
                        <td>Carrera:</td>
                        <td>${alumno.carrera}</td>
                    </tr>
                    <tr>
                        <td>Porcentaje de Créditos:</td>
                        <td>${alumno.porcentaje}</td>
                    </tr>
                </table>

            </div>
            <div style="clear:both;"></div>
        </div>
        <jsp:include page="../Template/footer.jsp" />
    </body>
</html>
