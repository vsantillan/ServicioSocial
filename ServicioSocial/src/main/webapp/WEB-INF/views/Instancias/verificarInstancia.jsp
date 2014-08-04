<%-- 
    Document   : preregistro
    Created on : 21/07/2014, 02:52:42 PM
    Author     : giovanni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../General/jstl.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>
                <%@include file="menuPreregistroInstancia.jsp" %>
            </div>
            <div id="aviso-instancia" class="row">
                <br />
                <div class="aviso-instancia">
                    <div class="formprereg-cont-header">
                        <h2>Por favor asegurate de que la instancia no ha sido registrada previamente.</h2>
                    </div>
                    <br />
                    <div class="form-group col-md-6">
                        <label for="buscar-instanciaf">Buscar en instancias registradas</label>
                        <input id="buscar-instanciaf" name="buscar-instanciaf" class="form-control" placeholder="Buscar en instancias" type="text" />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="campoabuscar-combo">Buscar por el campo</label>
                        <select id="campoabuscar-combo" name="campoabuscar-combo" class="form-control" placeholder="Buscar por campo">
                            <option value="rfc">Buscar por RFC</option>
                            <option value="nom">Buscar por nombre de instancia</option>
                        </select>
                    </div>
                    <button id="buscar-instancia-btn" class="btn btn-primary" onclick="buscarInstancia()">Buscar Instancia</button>
                    <br /><br />
                    
                    <div id="instancias-result">
                        <div id="lista-instancias" class="instancias-list">
                            <h3 style="color: #e74c3c">Resultados de la búsqueda:</h3>
                            <br>
                            
                        </div>
                        <div class="instancias-list-footer">
                            <h4>¿No has encontrado la instancia buscada?</h4>
                            <button id="proceder-registro-btn" class="btn btn-primary" onclick="showFormPreregistro()">Proceder a registrar instancia</button>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../General/footer.jsp" %>
        </div>
        
        <!-- Javascript -->
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/instancias.js"></script>
    </body>
</html>
