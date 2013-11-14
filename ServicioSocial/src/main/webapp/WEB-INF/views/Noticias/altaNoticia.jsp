<%-- 
    Document   : altaAdminOrganizacion
    Created on : 07-jun-2013, 14:29:04
    Author     : bustedvillain
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../Template/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />


        <script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
        
        <title>Administrador</title>
    </head>
    <body class="background">
        <jsp:include page="../Template/banner.jsp" />

        <%-- inicio del contenido --%>
        <div id="contenido">
            <jsp:include page="../PanelAdministrador/menuPanelAdministrador.jsp" />
            <div style="float:left; width: 80%">

                <%-- Formulario Nueva Noticia --%>
                <center>
                    <h1>Alta de Noticia</h1>
                    <form:form commandName="Noticias" id="Noticias" name="Noticias" action="altaNoticia.do"  class="MyForm"   method="POST" style="width:80%;" >
                        <table>
                            <tr>
                                <td> <label for="titulo">T&iacute;tulo:</label> </td>
                                <td style="width: 120%"><form:input path="titulo"/><br/>
                                    <form:hidden path="id" value='-1'/>
                                </td>
                            </tr>
                            <tr> <td colspan="2"><form:errors path="titulo" cssClass="error"/> </td> </tr>
                            <tr>
                                <td>  <label for="tipoNoticia">Tipo Noticia:</label></td>
                                <td>   
                                    <form:select path="tipoServicio">
                                     <form:option value="1" label="Noticas para página principal" />
                                     <form:option value="2" label="Noticias para alumnos"/>
                                     <form:option value="3" label="Noticias para organizaciones" />
                                    </form:select>
                                </td>  
                            </tr>
                            
                            <tr>
                                <td>  <label for="detalle">Descripci&oacute;n:</label></td>
                                <td>   
                                    <form:textarea path="detalle" cols="200" rows="40"/>
                                     <script type="text/javascript">
                                         
                                         CKEDITOR.replace ('detalle');
                                         config.language = 'es';
                                         
                                    </script>
                                </td>  
                            </tr>
                            <tr>
                                <td colspan="2"><form:errors path="id" cssClass="error"/></td>  
                            </tr>
                            
                            <tr> 
                                <td> <input type ="submit" value = "Guardar " /> </td>
                                <td> <input type ="reset" value = "Limpiar" /></td>
                            </tr>

                        </table>
                    </form:form>
                    <br/>
                </center>
            </div>
            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <jsp:include page="../Template/footer.jsp" />
        
    </body>
</html>
