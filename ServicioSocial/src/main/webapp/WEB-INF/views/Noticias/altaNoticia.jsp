<%-- 
    Document   : altaNoticia
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
                    <%-- inicio del contenido --%>
                    <div class="col-md-6 col-md-offset-3">
                        <%-- Formulario Nueva Noticia --%>
                        <h1>Alta de Noticia</h1>
                        <form:form class="form-horizontal" role="form" commandName="Noticias" id="Noticias" name="Noticias" action="altaNoticia.do"   method="POST" >

                            <div class="form-group">
                                <label for="titulo">T&iacute;tulo:</label>
                                
                                    <form:input class="form-control" path="titulo"/>
                                
                                <form:hidden path="id" value='-1'/>
                                <form:errors path="titulo" cssClass="error"/>
                            </div>

                            <div class="form-group">
                                <label for="tipoNoticia">Tipo Noticia:</label>
                                
                                    <form:select class="form-control" path="tipoServicio">
                                        <form:option value="1" label="Noticas para página principal" />
                                        <form:option value="2" label="Noticias para alumnos"/>
                                        <form:option value="3" label="Noticias para organizaciones" />
                                    </form:select>
                                
                            </div>

                            <div class="form-group">
                                <label for="detalle">Descripci&oacute;n:</label>
                                
                                    <form:textarea class="form-control" path="detalle"/>
                                    <script type="text/javascript">

                                        CKEDITOR.replace('detalle');
                                        config.language = 'es';

                                    </script>
                                
                            </div>

                            <form:errors path="id" cssClass="error"/> 
                            
                            <div class="control-group">
                            <input class="btn btn-primary" type ="submit" value = "Guardar " />
                            <input class="btn btn-primary" type ="reset" value = "Limpiar" />
                            </div>

                        </form:form>
                        <br/>
                    </div>
                </div><!--/row--> 
                <%@include file="../General/footer.jsp"%>  
            </div><!--/row--> 
        </div><!-- /container -->
        <%@include file="../General/js.jsp"%>
    </div>
    <%-- fin del contenido --%>
    <jsp:include page="../Template/footer.jsp" />

</body>
</html>