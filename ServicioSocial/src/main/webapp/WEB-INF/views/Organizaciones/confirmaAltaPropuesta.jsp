<%-- 
    Document   : confirmaAltaPropuesta
    Created on : 14-ago-2013, 10:57:54
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="background">
        <div id="contenido" style="width:60%">
            <center>
                <br/>
                <h1>Propuesta registrada correctamente</h1>
                <img src="imagenes/paloma.png"/>
                <h3>Esta propuesta aún tiene que ser validada por el administrador.</h3>
                <button onclick="self.parent.location='formatoUnicoUsuario.do';">Continuar con mi formato &uacute;nico</button>
                <br/>
            </center>
        </div>
        
    </body>
    
</html>
