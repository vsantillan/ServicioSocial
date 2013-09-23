<%-- 
    Document   : acercaDe
    Created on : 20-sep-2013, 12:52:48
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
        <title>Departamento de Servicio Social</title>
    </head>
    <body class="background">
        <%@ include file="../Template/banner.jsp" %>

        <%-- inicio del contenido --%>
        <jsp:include page="menuPrincipal.jsp" />
        <div id="contenido">
            <center>
                <br/>
                <h1>Acerca de</h1>
                
                <div class="MyForm" style="width:60%">
                    <p>El Sistema de Servicio Social, est&aacute; encargado de realizar la gesti&oacute;n del proceso del servicio social, de acuerdo al manual de operaci&oacute;n que otorga la DGEST.</p>
                    <p>v1.0</p>
                </div>
                <br/><br/>
                <div class="MyForm" style="width:60%">
                    <p>Este sistema fue desarrollado por estudiantes de la carrera de Ingenier&iacute;a en Sistemas Computacionales perteneciente al Instituto Tecnol&oacute;gico de Toluca.</p>
                    
                    <ul>
                        <li>Ing. Maricela Santiago Cayetano</li>
                        <li>Ing. Omar Nava Pulido</li>
                        <li>Ing. Rodrigo L&oacute;pez Rosales</li>
                        <li>Ing. Esteban Ismael Regules P&eacute;rez</li>
                        <li>Ing. Hector Morales Palma</li>
                        <li>Ing. Jonathan D&iacute;az Plata</li>
                        <li>Ing. Jos&eacute; Manuel Nieto G&oacute;mez</li>
                        <li>Ing. Jes&uacute;s Guzm&aacute;n Mondrag&oacute;n</li>                            
                    </ul>
                </div>
                <br/><br/><br/><br/><br/><br/><br/>
                
            </center>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>