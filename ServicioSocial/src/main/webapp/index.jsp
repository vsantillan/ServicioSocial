<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:redirect url="index.do"/>
        <h1>Hello World!</h1>
        <a href="panelUsuario.do">Usuario</a>
         <a href="administrarOrganizaciones.do">Organizaciones</a>
         <a href="panelAdministrador.do">Administracion</a>
         
    </body>
</html>
