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
<form method="post" action="guardarIMG.do"  enctype="multipart/form-data">
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
</form>
<br/>
</body>
</html>

