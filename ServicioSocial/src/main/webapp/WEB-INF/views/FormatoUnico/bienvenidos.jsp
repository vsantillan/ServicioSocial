<%-- 
    Document   : bienvenidos
    Created on : 20/02/2012, 07:33:45 PM
    Author     : ingluisestrada
<%@page session="true" contentType="text/html" pageEncoding="UTF-8" import="sia.login.Menus"%>
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" type="text/css" href="css/estilo_sia.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.8.17.custom.css"/>
<link rel="stylesheet" type="text/css" href="css/jquerycssmenu2.css" />
<link rel="stylesheet" type="text/css" href="css/screen.css" />
<link rel="shortcut icon" type="image/icon" href="imagenes/favicon.ico" /> 

<script type="text/javascript" src="lib/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="lib/js/jquerycssmenu2.js"></script>
<script type="text/javascript" src="lib/js/baner.js"></script>
<script type="text/javascript" src="lib/js/jquery-ui-1.8.17.custom.min.js"></script>
<script type="text/javascript" src="lib/js/jquery.validate.js" ></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Instituto Tecnológico de Toluca -> Sistema Integral Administrativo (SIA)</title>


</head>

	
<body onload="MM_preloadImages('imagenes/logo_tec_r.png')" >
	<div class="pagina" align="center">
        <div class="banner" align="left">
        <a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('itt_logo','','imagenes/logo_tec_r.png',1)"><img src="imagenes/logo_tec.png" name="itt_logo" width="100" height="100" border="0" id="itt_logo" /></a>
        </div>
	</div>
<%
HttpSession sesionOk = request.getSession();
if (sesionOk.getAttribute("usuario") == null) {
%>    
    <jsp:forward page="index.jsp">
    <jsp:param name="error" value="Es obligatorio identificarse"/>
    </jsp:forward>
<% } else {
 // todo el codigo que se muestra si se inicio la sesion
%>
    
<div id="menu">   
<div id="myjquerymenu" class="jquerycssmenu">

<br style="clear: left" />
</div>
</div>

<%-- inicio del contenido --%>
<div id="contenido">

    <h1 align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('wel','','imagenes/welcome1_e.png',1)"><img id="wel" src="imagenes/welcome1.png" /></a></h1>
    <h1 align="center"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('t_wel','','imagenes/texto_wel_e.png',1)"><img id="t_wel" src="imagenes/texto_wel.png" /></a></h1>
    <p> </p>			

</div>
<%-- fin del contenido --%>
<div id="footer">
<img  src="imagenes/foter.png"/>
</div>
<%    
//fin del codigo al ser iniciada la sesion    
   }
%>
</body>

</html>
