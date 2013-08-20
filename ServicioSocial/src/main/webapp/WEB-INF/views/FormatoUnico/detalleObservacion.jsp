<%-- 
    Document   : demoAdministrador
    Created on : 07-jun-2013, 10:56:10
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <body>
        <div>
                <h1>Motivos de Rechazo</h1>
                <div id="scroll">
                    <ul>
                    <core:forEach items="${listadoObservaciones}" var="observacion">
                        <li> <core:out value="${observacion.catalogoObservacionId.detalle}" /></li>   
                     </core:forEach>
                        </ul>
                </div>
            </div>
    </body>
</html>


        