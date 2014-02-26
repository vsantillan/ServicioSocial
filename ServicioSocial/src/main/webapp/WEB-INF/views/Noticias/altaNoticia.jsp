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
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuAdministrador.jsp"%> 

                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <br/>
                        <div class="panel panel-info">
                            <div class="panel-heading"><h3>Alta de Noticia</h3></div>
                            <div class="panel-body">
                                <form:form  role="form" commandName="Noticias" id="Noticias" name="Noticias" action="altaNoticia.do"   method="POST" >

                                    <div class="form-group">
                                        <label for="titulo">T&iacute;tulo:</label>

                                        <form:input class="form-control" path="titulo"/>
                                        <br/>
                                        <form:hidden path="id" value='-1'/>
                                        <form:errors class="alert alert-danger" path="titulo"/>
                                    </div>

                                    <div class="form-group">
                                        <label for="tipoNoticia">Tipo Noticia:</label>

                                        <form:select class="form-control" path="tipoServicio">
                                            <form:option value="1" label="Noticas para página principal" />
                                            <form:option value="2" label="Noticias para alumnos"/>
                                            <form:option value="3" label="Noticias para organizaciones" />
                                        </form:select>
                                        <br/>
                                    </div>

                                    <div class="form-group">
                                        <label for="detalle">Descripci&oacute;n:</label>

                                        <form:textarea class="form-control" path="detalle"/>
                                        <script type="text/javascript">

                                            CKEDITOR.replace('detalle');
                                            config.language = 'es';

                                        </script>
                                        
                                    </div>

                                        <br><form:errors path="detalle" cssClass="alert alert-danger"/> 

                                    <div class="control-group">
                                         <br>
                                        <input class="btn btn-primary" type ="submit" value = "Guardar " />
                                        <input class="btn btn-primary" type ="reset" value = "Limpiar" />
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>

                <%@include file="../General/footer.jsp"%>
                <%@include file="../General/js.jsp"%>

            </div>
        </div>
    </body>
</html>