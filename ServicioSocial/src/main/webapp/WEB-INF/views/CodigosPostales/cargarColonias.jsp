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


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<core:forEach items="${codigoPostal.coloniaCollection}" var="colonias">            
    <option value="${colonias.idColonia}">${colonias.nombre}</option>  
</core:forEach>
    <option value="0">Otra</option>  




