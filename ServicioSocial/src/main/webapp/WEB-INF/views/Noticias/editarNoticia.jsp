<%-- 
    Document   : altaAdminOrganizacion
    Created on : 07-jun-2013, 14:29:04
    Author     : bustedvillain
--%>


<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" language="javascript" src="js/ckeditor/ckeditor.js"></script>
        <%@include file="../General/head.jsp"%>
        <title>Administrador</title>
    </head>
    <body class="background">
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%> 
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <h1>Editar Noticia</h1>
                        <form:form commandName="Noticias" id="Noticias" name="Noticias" action="editarNoticia-${id}.do"  class="MyForm"   method="POST" style="width:80%;" >
                            <label for="titulo">T&iacute;tulo:</label>
                            <form:input path="titulo"/>
                            <form:hidden path="id" />
                            <form:errors path="titulo" cssClass="error"/>

                            <label for="tipoNoticia">Tipo Noticia:</label> 
                            <form:select path="tipoServicio">
                                <form:option value="1" label="Noticas para página principal" />
                                <form:option value="2" label="Noticias para alumnos"/>
                                <form:option value="3" label="Noticias para organizaciones" />
                            </form:select>

                            <label for="detalle">Descripci&oacute;n:</label>
                            <form:textarea path="detalle" cols="200" rows="40"/>
                            <script type="text/javascript">

                                CKEDITOR.replace('detalle');
                                config.language = 'es';

                            </script>
                            <form:errors path="id" cssClass="error"/>   
                            <input type ="submit" value = "Guardar " />
                            <input type ="reset" value = "Limpiar" />
                        </form:form>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%> 
            </div>
            <%@include file="../General/js.jsp"%>
        </div>

    </body>
</html>
