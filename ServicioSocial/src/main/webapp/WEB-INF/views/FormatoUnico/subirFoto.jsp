<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>SIA</title>
            <%@ include file="../Template/sinJavascript.jsp" %>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <jsp:include page="../Template/headsJQueryUI.jsp" /><!--Hay conflicto de datatables con estilo forms--->
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />

        
        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
</head>
<body class ="background">
    

<h3>Selecciona tu foto</h3>
<form method="post" action="guardarImagenFui.do"  enctype="multipart/form-data">
    <table>
        <tr>
        <td>Id</td>
        <td>
            <input type="text" name="id" value="${idUsuario}"/>    
        </td> 
    </tr>
    <tr>
        <td>Foto</td>
        <td><input type="file" name="file" value="Examinar"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Subir"/>
        </td>
    </tr>
</table>  
</form>
<br/>
</body>
</html>
