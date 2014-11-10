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

                <div class=" row help-block col-md-12 text-center"><h2 class=""><span class="glyphicon glyphicon-pencil"></span>&nbsp; Alta de Noticias</h2></div>
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="panel panel-info">
                            <div class="panel-heading"><h4>Alta de Noticia</h4></div>
                            <div class="panel-body">
                                <core:if test="${nuevaNoticia eq true}">
                                    <script type="text/javascript">

                                    </script>
                                </core:if>
                                <form:form  role="form" commandName="Noticias" id="Noticias" name="Noticias" action="altaNoticia.do"   method="POST" >

                                    <div class="form-group">
                                        <label for="titulo">T&iacute;tulo</label>

                                        <form:input class="form-control" path="titulo" placeholder="Título"/>
                                        <br/>
                                        <form:hidden path="id" value='-1'/>
                                        <form:errors class="alert alert-danger" path="titulo"/>
                                    </div>

                                    <div class="form-group">
                                        <label for="tipoNoticia">Tipo de Noticia</label>

                                        <form:select class="form-control" path="tipoServicio">
                                            <form:option value="1" label="Noticas para Página Principal" />
                                            <form:option value="2" label="Noticias para Alumnos"/>
                                            <form:option value="3" label="Noticias para Instancias" />
                                        </form:select>
                                        <br/>
                                    </div>

                                    <div class="form-group">
                                        <label for="detalle">Descripci&oacute;n</label>

                                        <form:textarea class="form-control" path="detalle"/>
                                        <script type="text/javascript">

                                            CKEDITOR.replace('detalle');
                                            config.language = 'es';

                                        </script>

                                    </div>

                                    <br><form:errors path="detalle" cssClass="alert alert-danger"/> 

                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-9">
                                            <div class="control-group">
                                                <br>
                                                <input class="btn btn-primary" type ="submit" value = "Guardar " />
                                                <input class="btn btn-primary" type ="reset" onClick="CKEDITOR.instances.detalle.setData('', function () {
                                                            this.updateElement();
                                                        })" value = "Limpiar" />
                                            </div>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade in" id="respuestaAltaNoticia">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title text-center">Operación Exitosa</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div id="noticiasOk" class="alert alert-success" style="display: none;">
                                        <div class="alert-heading"><h3><b>Información Alta de Noticias</b></h3></div>
                                        <div class="alert-body">
                                            <h5>Se ha agregado la nueva noticia satisfactoriamente.</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->

                <%@include file="../General/footer.jsp"%>
                <%@include file="../General/js.jsp"%>

            </div>
        </div>
        <core:if test="${nuevaNoticia eq true}">
            <input type="hidden" id="noticiaValida" value="true">
        </core:if>
        <script type="text/javascript">
//            $(window).load(function () {
            $(document).ready(function () {
                if ($("#noticiaValida").val() === "true")
                {
                    $('#respuestaAltaNoticia').modal('show');
                }
            });
//            });
        </script>
    </body>
</html>