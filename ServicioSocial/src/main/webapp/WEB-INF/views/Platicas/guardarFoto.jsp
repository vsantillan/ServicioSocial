<%-- 
    Document   : guardarFoto
    Created on : 29/07/2013, 12:15:49 PM
    Author     : mary
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Document Manager</title>
</head>
<body>
 
<h2>Document Manager</h2>
 
<h3>Add new document</h3>
<form:form method="post" action="subirFoto.do" enctype="multipart/form-data">
    <form:errors path="*" cssClass="error"/>
    <table>
         <tr>
        <td>Id</td>
        <td>
            <input name="id"/>    
        </td> 
    </tr>
    <tr>
        <td>Foto</td>
        <td><input type="file" name="file"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Document"/>
        </td>
    </tr>
</table>  
</form:form>
 
<br/>

</body>
</html>

