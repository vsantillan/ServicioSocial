<%-- 
    Document   : cargarColonias
    Created on : 20-jun-2013, 14:22:27
    Author     : bustedvillain
--%>
<%-- 
    Document   : administrarOrganizaciones
    Created on : 4/06/2013, 02:17:52 PM
    Author     : roy
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>        
        <title>Administraci&oacute;n de Organizaciones</title>
    </head>
    <body>
        <core:forEach items="${estados}" var="estados">
        <option value="${estados.idEstado}">${estados.nombre} </option>
            <core:forEach items="${estados.codigosPostalesCollection}" var="codigos">
                
                <option value="${codigos.idCp}">${codigos.cp} </option>
                
                        
            </core:forEach>
    </core:forEach>
</body>


</html>


