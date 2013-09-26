<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/sinJavascript.jsp" %>
        <%@ include file="../Template/headsMenuUsuario.jsp" %>
        <%@ include file="../Template/metas.jsp" %>
        <jsp:include page="../Template/headsJQueryUI.jsp" /><!--Hay conflicto de datatables con estilo forms--->
        <jsp:include page="../Template/headsDataTablesConTabs.jsp" />


        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />
        <!--css de tabs-->
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.all.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/demos.css"/>
        <link rel="stylesheet" type="text/css" href="css/jqueryUI/jquery.ui.timepicker.css"/>


        <!-- Javascripts -->
        <script src="js/jqueryUI/jquery-1.9.1.js"></script>

        <script src="js/jqueryUI/jquery.ui.core.js"></script>
        <script src="js/jqueryUI/jquery.ui.widget.js"></script>
        <script src="js/jqueryUI/jquery.ui.datepicker.js"></script>
        <script src="js/jqueryUI/jquery.ui.tabs.js"></script>
        <script>
            $(function() {
                $("#tabs").tabs();
                $('#timepicker').timepicker();
                $('#fecha_inicio').datepicker(
                        {
                            closeText: 'Cerrar',
                            prevText: 'Anterior',
                            nextText: 'Siguiente',
                            currentText: 'Hoy',
                            dateFormat: 'yy-mm-dd',
                            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                            monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                            dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                            dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
                            minDate: 0

                        });

            });
        </script>
        <script src="js/jqueryUI/jquery.ui.timepicker.js"></script>

        <script type="text/javascript" src="js/jqueryUI/i18n/jquery.ui.datepicker-es.js"></script>
        <script src="js/jquery.codigos.postales.js"></script>   
        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />
        <script type="text/javascript" src="js/formatoUnicoJQuery.js"></script>

        <title>Formato &Uacute;nico - Usuario</title>

    </head>
    <body class ="background" onload=" //recargaProyectos(2);
                recargaCombosOrgs(${formatoUnicoDatosOrganizaciones.idProyecto});">


        <%@ include file="../Template/banner.jsp" %>


        <%-- inicio del contenido --%>
        <jsp:include page="../PanelUsuario/menuPanelUsuario.jsp" />
        <div id="contenido">
            <div id="tabs">
                <h1>P&aacute;gina del Formato Unico</h1>
                <ul>
                    <li><a href="#datosPersonales">1.Datos Personales</a></li>
                    <li><a href="#datosContacto">2.Datos Contacto</a></li>
                    <li><a href="#datosAcademicos">3.Datos Acad&eacute;micos</a></li>
                    <li><a href="#datosOrganizaciones">4.Datos Organizaciones</a></li>
                    <li><a href="#horarios">5.Horario</a></li>
                    <li><a href="#imprimirFui">6.Imprimir Formato &Uacute;nico</a></li>
                    <li><a href="#subirFui">7.Subir Formato &Uacute;nico</a></li>
                </ul>
                <div id="datosPersonales">
                    <form:form id="frmDatosPersonales" modelAttribute="formatoUnicoDatosPersonales">
                        Los datos marcados con * son Obligatorios
                        <table>
                            <tr>
                                <form:input  type="hidden" path ="id" />
                                <td>*Nombre:</td>
                                <td><form:input   maxlength="60" path ="nombre" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Apellido Paterno</td>
                                <td><form:input maxlength="30" path ="apellidoP" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Apellido Materno:</td>
                                <td><form:input maxlength="30" path ="apellidoM" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Sexo</td>
                                <td>



                                    <select name="sexo">
                                        <core:choose>
                                            <core:when test="${formatoUnicoDatosPersonales.getSexo() == 'M' || formatoUnicoDatosPersonales.getSexo() == 'MASCULINO'}">
                                                <option  selected="selected">MASCULINO</option>
                                                <option  >FEMENINO</option>
                                                <option  >INDEFINIDO</option>
                                            </core:when>
                                            <core:when test="${formatoUnicoDatosPersonales.getSexo() == 'F' || formatoUnicoDatosPersonales.getSexo() == 'FEMENINO'}">

                                                <option  selected="selected">FEMENINO</option>
                                                <option  >MASCULINO</option>
                                                <option  >INDEFINIDO</option>
                                            </core:when>
                                            <core:otherwise>
                                                <option  selected="selected">INDEFINIDO</option>
                                                <option  >FEMENINO</option>
                                                <option  >MASCULINO</option>

                                            </core:otherwise>
                                        </core:choose>
                                    </select> 
                                </td>
                            </tr>
                            <tr>
                                <td>*Estado civil:</td>
                                <td>
                                    <select name="estado_civil">
                                        <option value="SOLTERO(A)">SOLTERO</option>
                                        <option value="CASADO(A)">CASADO(A)</option>
                                        <option value="VIUDO(A)">VIUDO(A)</option>
                                        <option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
                                        <option value="AMASIATO">AMASIATO</option>
                                        <option value="SEPARADO(A)">SEPARADO(A)</option>
                                        <option value="CONCUBINATO">CONCUBINATO</option>
                                        <option value="OTRO">OTRO</option>
                                    </select> 
                                </td>
                            </tr>
                            <tr>
                                <td>*Ocupaci&oacute;n:</td>
                                <td><form:input maxlength="30" path ="ocupacion" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*CURP:</td>
                                <td><form:input maxlength="18" path ="curp" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Lugar de Nacimiento:</td>
                                <td><form:input maxlength="150" path ="lugar_nacimiento" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Folio de Documento de Identificaci&oacute;n:</td>
                                <td><form:input maxlength="13" path ="folioDocIdentificacion" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Clave de Documento de Identificaci&oacute;n:</td>
                                <td><form:input maxlength="30" path ="claveDocIdentificacion" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <form:checkbox path="acuerdoC" />  *He le&iacute;do y acepto el <a href="showpdf.do" class="fancyFUI">Acuerdo de Confidencialidad</a> </td>

                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit"  value="Guardar Datos Personales" /> </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="datosContacto">
                    <form:form id="frmDatosContacto" commandName="formatoUnicoDatosContacto" >
                        Los datos marcados con * son Obligatorios
                        <table>

                            <tr>
                                <form:input  type="hidden" path ="id" />
                                <td>*Calle:</td>
                                <td><form:input  path ="calle" maxlength="200" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>No. Int.</td>
                                <td><form:input  path ="numeroI" maxlength="5" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*No. Ext.</td>
                                <td><form:input  path ="numeroE" maxlength="5" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>

                            <tr>
                            <input type="hidden" id="preCP" value="${codigoPostal}" />
                            <input type="hidden" id="preColonia" value="${preColonia}" />

                            <tr>
                                <td>  <label for="codigo_postal">C&oacute;digo Postal:</label></td>
                                <td> 
                                    <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off">
                                    <input type="hidden" id="preCP" value="${cp}"/><br>${codigo_postal}
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="estado">Estado:</label></td>
                                <td>  <!--input type="text" name="estado" id="estado" size="20" require="true" disabled="true"/--> 
                                    <select name="estado" id="estado" disabled="true">                                   
                                        <core:forEach items="${estados}" var="estados">
                                            <option value="${estados.idEstado}">${estados.nombre}</option>
                                        </core:forEach> 
                                    </select>
                                </td>  
                            </tr>                        
                            <tr>
                                <td>  <label for="municipio">Municipio:</label></td>
                                <td>  <!--input type="text" name="lugar" id="municipio" size="20" require="true" disabled="true"/--> 
                                    <select name="municipio" id="municipio" disabled="true"></select>
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="ciudad">Ciudad</label></td>
                                <td>  <!--input type="text" name="lugar" id="ciudad" size="20" require="true" disabled="true"/--> 
                                    <select name="ciudad" id="ciudad" disabled="true"></select>
                                </td>  
                            </tr>
                            <tr>
                                <td>  <label for="colonia">Colonia:</label></td>
                                <td>  
                                    <div id="notice"></div>
                                    <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                    <form:select id="idColonia" path="idColonia.idColonia" name="idColonia"></form:select> 
                                        <div id="otra_colonia" style="display:none;">
                                            <input type="text" name="otra_colonia" value="${otra_colonia}"/>
                                        <input type="hidden" id="existeCP" name="existeCP" value="true">
                                        <input type="hidden" id="preColonia" value="${idColonia}"/>
                                        ${error_otra_colonia}
                                    </div>
                                    <br/>
                                </td>  
                            </tr>       


                            <tr>


                                <td>*Entre Calles:</td>
                                <td><form:input maxlength="255" path ="entreCalles" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Referencias:</td>
                                <td><form:input maxlength="70" path ="referencias" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>Tel&eacute;fono casa:</td>
                                <td><form:input maxlength="50"  path ="telefono_casa" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>Tel&eacute;fono cel:</td>
                                <td><form:input maxlength="30" path ="telefono_cel" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>Tel&eacute;fono oficina:</td>
                                <td><form:input maxlength="30" path ="telefono_oficina" onkeyup="javascript:this.value=this.value.toUpperCase();"/> </td>
                            </tr>
                            <tr>
                                <td>*Correo electr&oacute;nico:</td>
                                <td><form:input maxlength="30" path ="correo_electronico"/> </td>
                            </tr>
                            <tr>
                                <td>Twitter:</td>
                                <td><form:input maxlength="25" path ="twitter" /> </td>
                            </tr>
                            <tr>
                                <td>Facebook:</td>
                                <td><form:input maxlength="30" path ="facebook" /> </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Guardar Datos de Contacto" > </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="datosAcademicos">
                    <form:form modelAttribute="academicos" >
                        <table class="tablaInput300">
                            <tr> 
                                <td>Numero de control</td>
                                <td><form:input path="ncontrol" readonly="true" /></td>
                            </tr>
                            <tr>
                                <td>Carrera</td>
                                <td><form:input path  ="carrera" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Periodo</td>
                                <td><form:input path ="periodo" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Semestre</td>
                                <td><form:input path ="semestre" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Total de cr&eacute;ditos cubiertos</td>
                                <td><form:input path ="cc" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Porcentaje del total de cr&eacute;ditos cubiertos</td>
                                <td><form:input path ="pcc" readonly="true"/></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="datosOrganizaciones">
                    <form:form id="frmDatosOrganizaciones" modelAttribute="formatoUnicoDatosOrganizaciones" >
                        Los datos marcados con * son Obligatorios
                        <table>
                            <tr>
                                <form:input class="idDatosPersonalesOrg" type="hidden" path ="id" />
                                <td>*Organizaci&oacute;n:</td>
                                <td>
                                    <select id="comboOrganizaciones" name="organizacion">
                                        <core:forEach items="${instancias}" var="instancia">
                                            <option value="${instancia.idInstancia}">${instancia.nombre}</option>
                                        </core:forEach> 
                                    </select> 
                                    <a id="linkNuevoI" href="propAlInstancia.do?datos_personales=${formatoUnicoDatosOrganizaciones.id}" class="fancyFU" >Agregar una Instancia/Proyecto Nuevo</a>
                                </td>
                                <td style="padding-left: 50px; text-align:right">
                                    *Fecha de Inicio 
                                    <form:input  type="text" require="true"  size="15" path ="fecha_inicio"  style="width:100px"/>
                                </td>
                            </tr>
                            <tr>
                                <td>*Proyecto:</td>
                                <td>
                                    <select id="proyectos" name="proyecto">

                                    </select> 
                                    <a id="linkNuevoP" href="propAlProyecto.do?datos_personales=${formatoUnicoDatosOrganizaciones.id}&idInstancia=${idDeInstancia}" class="fancyFU" >Agregar un proyecto</a>

                                </td>
                            </tr>

                        </table>
                        <table class="tablaInput300">
                            <!--<tr>
                                <td>Calle</td>
                                <td><input type ="text"/></td> 
                                <td colspan="2">N&uacute;mero exterior <input style="width:50px"  type ="text"/>
                                    N&uacute;mero interior <input style="width:50px"  type ="text"/></td>
                            </tr>
                            <tr>
                                <td>Colonia/Fracc</td>
                                <td><input type ="text"/></td> 
                                <td>Municipio</td>
                                <td><input type ="text"/></td> 
                            </tr>
                            <tr>
                                <td>Estado</td>
                                <td><input type ="text"/></td> 
                                <td>C.P.</td>
                                <td><input type ="text"/></td> 
                            </tr>-->
                            <tr>
                                <td>Domicilio</td>
                                <td colspan="3"><input id="domicilioOrg" type ="text" style="width:99%" readonly="true" /></td> 
                            </tr>
                            <tr>
                                <td>Titular</td>
                                <td><input id="nombre_responsable" type ="text" readonly="true" /></td> 
                                <td>Puesto</td>
                                <td><input id="responsable_puesto"type ="text" readonly="true" /></td> 
                            </tr>
                            <tr>
                                <td>Tel&eacute;fono del titular</td>
                                <td><input id="telefono_responsable" type ="text" readonly="true" /></td> 

                            </tr>
                            <tr>
                                
                                <td>Para ver más informaci&oacute;n del proyecto, da clic en la lupa
                                    <!--<input type="text" id="idProyecto" />-->
                                </td>
                                <td style="text-align: left;"><a id="linkMasInfoProyecto"  class="fancyFU"><img src="imagenes/lupa.png" width="30"/></a></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type ="submit" value="Guardar Datos de Organizaci&oacute;n" > </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="horarios">
                    <form:form id="frmHorarios"  modelAttribute="formatoUnicoHorarios">
                        <table>
                            <tr>
                                <th><form:input type = "hidden" path="id" /></th>
                                <th>Lunes</th>
                                <th>Martes</th>
                                <th>Mi&eacute;rcoles</th>
                                <th>Jueves</th>
                                <th>Viernes</th>

                            </tr>
                            <tr>
                                <th>Horario Inicio:</th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[1]" path="luI" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[3]" path="maI" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[5]" path="miI" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[7]" path="juI" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[9]" path="viI" /></th>

                            </tr>
                            <tr>
                                <th>Horario Final</th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[2]" path="luF" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[4]" path="maF" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[6]" path="miF" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[8]" path="juF" /></th>
                                <th><form:input maxlength="5" type="text" style="width: 70px;" class="timepicker.[10]" path="viF" /></th>

                            </tr>
                            <tr>
                                <td></td>
                                <td colspan="8"><input type ="submit" value="Guardar Datos de Horario" ></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id="imprimirFui">
                    <h1>A continuaci&oacute; descargar&aacute;s tu formato &uacute;nico, para posteriormente imprimirlo y acudir a la instancia donde realizarás tu servicio social para que te sellen tu documento como se muestra a continuación:</h1>
                    <img src="imagenes/fui.png" style="width:300; height:500px" alt="Formato Unico inicial"/>
                    <h1>Ahora pulsa en el botón de descargar.</h1>
                    <h2>Cuando tu formato tenga el sello corespondiente s&uacute;belo en la siguiente secci&oacute;n</h2>
                    <a href="muestraReporteFUI.pdf" id="cmdDescargaFui" target="_blank" onclick="window.location.reload();"><img src="imagenes/descargar.png" /></a>
                </div>
                <div id="subirFui">
                    <h1>Sube aqu&iacute; tu formato &uacute;nico dellado como el que está a continuaci&oacute;n</h1>
                    <img src="imagenes/fui.png" style="width:300; height:500px" alt="Formato Unico inicial"/>
                    <form method="post" id="frmSubirFui" action="subirFui.do"  enctype="multipart/form-data">
                        <input type="hidden" name ="id" id="idSubirFui" value="${idDatSubida}"/>
<!--                        <input type='file'  name ='file' value='Buscar en mi equipo'/> <br/>
                        <input type='submit' value='Subir' />-->
                        ${infoDescarga}
                    </form>
                </div>
            </div>
            <div id="observaciones" style="display: none">
                <b>Debes atender los siguientes puntos</b><br/>
                <ul id="listaObservaciones" >

                </ul>

            </div>

            <div style="clear:both;"></div>
        </div>
        <%-- fin del contenido --%>
        <%@ include file="../Template/footer.jsp" %>
    </body>
</html>
