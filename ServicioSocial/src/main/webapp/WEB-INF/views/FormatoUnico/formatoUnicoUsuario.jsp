<%@include file="../General/jstl.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Template/sinJavascript.jsp" %>
        <%@include file="../General/head.jsp"%>

        <!--        <link rel="stylesheet" type="text/css" href="css/formatoUnico.css" />-->
        <title>Formato &Uacute;nico - Usuario</title>

    </head>
    <body onload="recargaCombosOrgs(${formatoUnicoDatosOrganizaciones.idProyecto});">
        <div class="container">
            <div class="row">
                <%@include file="../General/banner.jsp"%>  
                <%@include file="../General/menuUsuario.jsp"%> 
                <!--------------------------------------------------Contenido--> 
                <div class="bs-docs-section">

                    <div class="tabbable">
                        <h1>P&aacute;gina del Formato Unico</h1>
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#datosPersonales" onclick="ocultaDiv();">1.Datos Personales</a></li>
                            <li><a data-toggle="tab" href="#datosContacto" onclick="ocultaDiv();">2.Datos Contacto</a></li>
                            <li><a data-toggle="tab" href="#datosAcademicos" onclick="ocultaDiv();">3.Datos Acad&eacute;micos</a></li>
                            <li><a data-toggle="tab" href="#datosOrganizaciones" onclick="ocultaDiv();">4.Datos Organizaciones</a></li>
                            <li><a data-toggle="tab" href="#horarios" onclick="ocultaDiv();">5.Horario</a></li>
                            <li><a data-toggle="tab" href="#imprimirFui" onclick="ocultaDiv();">6.Imprimir Formato &Uacute;nico</a></li>
                            <li><a data-toggle="tab" href="#subirFui" onclick="ocultaDiv();">7.Subir Formato &Uacute;nico</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="datosPersonales" class="tab-pane active col-md-6">
                                <form:form id="frmDatosPersonales" modelAttribute="formatoUnicoDatosPersonales">
                                    <div class="panel panel-warning">
                                        <div class="panel-heading "><h4><span class="glyphicon glyphicon-info-sign"></span>&nbsp;Los datos marcados con * son Obligatorios</h4></div>
                                    </div>
                                    <div class="form-group">
                                        <form:input  type="hidden" path ="id" />
                                        <label>*Nombre:</label>
                                        <form:input   maxlength="60" path ="nombre" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                    </div>
                                    <div class="form-group">
                                        <label>*Apellido Paterno</label>
                                        <form:input maxlength="30" path ="apellidoP" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                    </div>
                                    <div class="form-group">
                                        <label>*Apellido Materno:</label>
                                        <form:input maxlength="30" path ="apellidoM" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>*Sexo</label>
                                        <select name="sexo" class="form-control">
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
                                    </div>
                                    <div class="form-group">
                                        <label>*Estado civil:</label>
                                        <select name="estado_civil" class="form-control">
                                            <option value="SOLTERO(A)">SOLTERO</option>
                                            <option value="CASADO(A)">CASADO(A)</option>
                                            <option value="VIUDO(A)">VIUDO(A)</option>
                                            <option value="DIVORCIADO(A)">DIVORCIADO(A)</option>
                                            <option value="AMASIATO">AMASIATO</option>
                                            <option value="SEPARADO(A)">SEPARADO(A)</option>
                                            <option value="CONCUBINATO">CONCUBINATO</option>
                                            <option value="OTRO">OTRO</option>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label>*Ocupaci&oacute;n:</label>
                                        <form:input maxlength="30" path ="ocupacion" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                    </div>
                                    <div class="form-group">
                                        <label>*CURP:</label>
                                        <form:input maxlength="18" path ="curp" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>*Lugar de Nacimiento:</label>
                                        <form:input maxlength="100" path ="lugar_nacimiento" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                    </div>
                                    <div class="form-group">
                                        <label>*Folio de Documento de Identificaci&oacute;n:</label>
                                        <form:input maxlength="13" path ="folioDocIdentificacion" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                    </div>
                                    <div class="form-group">
                                        <label>*Clave de Documento de Identificaci&oacute;n:</label>
                                        <form:input maxlength="30" path ="claveDocIdentificacion" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>

                                    <div class="row col-md-12 ">  
                                        <div class="row col-md-2 form-group">
                                            <form:checkbox path="acuerdoC" class="form-control" />
                                        </div> 
                                        <div class="row col-md-10">
                                            <label>*He le&iacute;do y acepto el <a href="showpdf.do" class="fancyFUI" target="_blank">Acuerdo de Confidencialidad</a></label>
                                        </div>  

                                    </div>

                                    <div class="form-group">
                                        <label>&nbsp;</label>
                                        <input type ="submit"  value="Guardar Datos Personales" class="btn btn-primary" />
                                    </div>
                                </form:form>
                            </div>
                            <div id="datosContacto" class="tab-pane col-md-6">
                                <form:form id="frmDatosContacto" commandName="formatoUnicoDatosContacto" >
                                    <div class="panel panel-warning">
                                        <div class="panel-heading "><h4><span class="glyphicon glyphicon-info-sign"></span>&nbsp;Los datos marcados con * son Obligatorios</h4></div>
                                    </div>
                                    <div class="form-group">
                                        <form:input  type="hidden" path ="id" />
                                        <label>*Calle:</label>
                                        <form:input  path ="calle" maxlength="200" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>No. Int.</label>
                                        <form:input  path ="numeroI" maxlength="5" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>*No. Ext.</label>
                                        <form:input  path ="numeroE" maxlength="5" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" id="preCP" value="${codigoPostal}" />
                                        <input type="hidden" id="preColonia" value="${preColonia}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="codigo_postal">C&oacute;digo Postal:</label>
                                        <input type="text" name="codigo_postal" id="codigo_postal" size="20" maxlength="5" autocomplete="off" class="form-control">
                                        <input type="hidden" id="preCP" value="${cp}"/><br>${codigo_postal}
                                    </div>
                                    <div class="form-group">
                                        <label for="estado">Estado:</label>
                                        <select name="estado" id="estado" disabled="true" class="form-control">                                   
                                            <core:forEach items="${estados}" var="estados">
                                                <option value="${estados.idEstado}">${estados.nombre}</option>
                                            </core:forEach> 
                                        </select>
                                    </div>                        
                                    <div class="form-group">
                                        <label for="municipio">Municipio:</label>
                                        <select name="municipio" id="municipio" disabled="true" class="form-control"></select>

                                    </div>
                                    <div class="form-group">
                                        <label for="ciudad">Ciudad</label>
                                        <select name="ciudad" id="ciudad" disabled="true" class="form-control"></select>

                                    </div>
                                    <div class="form-group">
                                        <label for="colonia">Colonia:</label>

                                        <div id="notice"></div>
                                        <!--select name="colonia" id="colonia" disabled="true"></select--> 
                                        <form:select id="idColonia" path="idColonia.idColonia" name="idColonia" class="form-control"></form:select> 
                                            <div id="otra_colonia" style="display:none;">
                                                <input type="text" name="otra_colonia" value="${otra_colonia}" class="form-control"/>
                                            <input type="hidden" id="existeCP" name="existeCP" value="true">
                                            <input type="hidden" id="preColonia" value="${idColonia}"/>
                                            ${error_otra_colonia}
                                        </div>
                                    </div>       
                                    <div class="form-group">
                                        <label>*Entre Calles:</label>
                                        <form:input maxlength="255" path ="entreCalles" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>*Referencias:</label>
                                        <form:input maxlength="70" path ="referencias" require="true" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                    </div>
                                    <div cl class="row">
                                        <div class="form-group col-md-4">
                                            <label>Tel&eacute;fono casa:</label>
                                            <form:input maxlength="50"  path ="telefono_casa" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Tel&eacute;fono cel:</label>
                                            <form:input maxlength="30" path ="telefono_cel" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> 
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label>Tel&eacute;fono oficina:</label>
                                            <label><form:input maxlength="30" path ="telefono_oficina" onkeyup="javascript:this.value=this.value.toUpperCase();" class="form-control"/> </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>*Correo electr&oacute;nico:</label>
                                        <form:input maxlength="30" path ="correo_electronico" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Twitter:</label>
                                        <form:input maxlength="25" path ="twitter" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Facebook:</label>
                                        <form:input maxlength="30" path ="facebook" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label>&nbsp;</label>
                                        <input type ="submit" value="Guardar Datos de Contacto"  class="btn btn-primary">
                                    </div>
                                    </table>
                                </form:form>
                            </div>
                            <div id="datosAcademicos" class="tab-pane col-md-6">
                                <form:form modelAttribute="academicos" >
                                    <table class="tablaInput300">
                                        <div class="form-group"> 
                                            <label>Numero de control</label>
                                            <form:input path="ncontrol" readonly="true" class="form-control" />
                                        </div>
                                        <div class="form-group">
                                            <label>Carrera</label>
                                            <form:input path  ="carrera" readonly="true" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Periodo</label>
                                            <form:input path ="periodo" readonly="true" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Semestre</label>
                                            <form:input path ="semestre" readonly="true" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Total de cr&eacute;ditos cubiertos</label>
                                            <form:input path ="cc" readonly="true" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Porcentaje del total de cr&eacute;ditos cubiertos</label>
                                            <form:input path ="pcc" readonly="true" class="form-control"/>
                                        </div>
                                    </table>
                                </form:form>
                            </div>
                            <div id="datosOrganizaciones" class="tab-pane col-md-6">
                                <form:form id="frmDatosOrganizaciones" modelAttribute="formatoUnicoDatosOrganizaciones" >
                                    <table>
                                        <div class="panel panel-warning">
                                            <div class="panel-heading "><h4><span class="glyphicon glyphicon-info-sign"></span>&nbsp;Los datos marcados con * son Obligatorios</h4></div>
                                        </div>
                                        <div class="form-group">
                                            <form:input class="idDatosPersonalesOrg form-control" type="hidden" path ="id"/>
                                            <label>*Organizaci&oacute;n:</label>
                                            <select id="comboOrganizaciones" name="organizacion" class="form-control">
                                                <core:forEach items="${instancias}" var="instancia">
                                                    <option value="${instancia.idInstancia}">${instancia.nombre}</option>
                                                </core:forEach> 
                                            </select>
                                        </div>
                                        <div class=" form-group">
                                            <label>&nbsp;</label>
                                            <a id="linkNuevoI" href="propAlInstancia.do?datos_personales=${formatoUnicoDatosOrganizaciones.id}" class="fancyFU btn btn-primary" >Agregar una Instancia/Proyecto Nuevo</a>
                                        </div>
                                        <div class="form-group">
                                            <label for="fecha">*Fecha de Inicio (Fecha en que el Prestante del Servicio Social inicia sus actividades)</label>
                                            <div class="input-group date dp2" data-date="" data-date-format="dd-mm-yyyy">
                                                <form:input type="text" require="true"  size="15" path ="fecha_inicio"  class="form-control"/>
                                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                            </div><br>
                                        </div>
                                        <div class="form-group">
                                            <label>*Proyecto:</label>
                                            <select id="proyectos" name="proyecto" class="form-control"></select> 
                                        </div>
                                        <div class=" form-group">
                                            <label>&nbsp;</label>
                                            <a id="linkNuevoP" href="propAlProyecto.do?datos_personales=${formatoUnicoDatosOrganizaciones.id}&idInstancia=${idDeInstancia}" class="fancyFU btn btn-primary" >Agregar un proyecto</a>                             
                                        </div>

                                    </table>
                                    <table class="tablaInput300">
                                        <!--<div class="form-group">
                                            <label>Calle</label>
                                            <label><input type ="text"/></label> 
                                            <td colspan="2">N&uacute;mero exterior <input style="width:50px"  type ="text"/>
                                                N&uacute;mero interior <input style="width:50px"  type ="text"/></label>
                                        </div>
                                        <div class="form-group">
                                            <label>Colonia/Fracc</label>
                                            <label><input type ="text"/></label> 
                                            <label>Municipio</label>
                                            <label><input type ="text"/></label> 
                                        </div>
                                        <div class="form-group">
                                            <label>Estado</label>
                                            <label><input type ="text"/></label> 
                                            <label>C.P.</label>
                                            <label><input type ="text"/></label> 
                                        </div>-->
                                        <div class="form-group">
                                            <label>Domicilio</label>
                                            <input id="domicilioOrg" type ="text" style="width:99%" readonly="true" class="form-control" />
                                        </div>
                                        <div class="form-group">
                                            <label>Titular</label>
                                            <input id="nombre_responsable" type ="text" readonly="true" class="form-control" />
                                            <label>Puesto</label>
                                            <input id="responsable_puesto"type ="text" readonly="true" class="form-control" />
                                        </div>
                                        <div class="form-group">
                                            <label>Tel&eacute;fono del titular</label>
                                            <input id="telefono_responsable" type ="text" readonly="true" class="form-control" /> 
                                        </div>
                                        <div class="form-group">
                                            <label>Para ver más informaci&oacute;n del proyecto, da clic en la lupa</label>
                                            <a id="linkMasInfoProyecto"  class="fancy"><span class="glyphicon glyphicon-search sizeIcon"></span></a>
                                        </div>
                                        <div class="form-group">
                                            <label></label>
                                            <input type ="submit" value="Guardar Datos de Organizaci&oacute;n" class="btn btn-primary col-md-offset-2" >
                                        </div>
                                    </table>
                                </form:form>
                            </div>
                            <div id="horarios" class="tab-pane col-md-8">
                                <form:form id="frmHorarios"  modelAttribute="formatoUnicoHorarios">
                                    <div class="form-group">
                                        <form:input type = "hidden" path="id" />
                                    </div>
                                    <div class="row col-md-12">
                                        <h2>Horario Inicio:</h2>
                                        <div class="form-group col-md-2 ">
                                            <label>Lunes</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[1] form-control" path="luI"  />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label>Martes</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[3] form-control" path="maI"  />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label>Miercoles</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[5] form-control" path="miI"  />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label>Jueves</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[7] form-control" path="juI" />
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label>Viernes</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[9] form-control" path="viI"  />
                                        </div>
                                    </div>
                                    <div class="row col-md-12">
                                        <h2>Horario Final</h2>
                                        <div class="form-group col-md-2 ">
                                            <label>Lunes</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[2] form-control" path="luF" />
                                        </div>
                                        <div class="form-group col-md-2 ">
                                            <label>Martes</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[4] form-control" path="maF" />
                                        </div>
                                        <div class="form-group col-md-2 ">
                                            <label>Miercoles</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[6] form-control" path="miF" />
                                        </div>
                                        <div class="form-group col-md-2 ">
                                            <label>Jueves</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[8] form-control" path="juF" />
                                        </div>
                                        <div class="form-group col-md-2 ">
                                            <label>Viernes</label>
                                            <form:input maxlength="5" type="text"  class="timepicker.[10] form-control" path="viF" />
                                        </div>
                                    </div>
                                    <div class="form-group col-md-4 col-md-offset-2">
                                        <label></label>
                                        <input type ="submit" value="Guardar Datos de Horario" class="form-control btn btn-primary" >
                                    </div>
                                </form:form>
                            </div>
                            <div id="imprimirFui" class="tab-pane col-md-12">
                                <div class="col-md-6">
                                    <div class="panel panel-warning">
                                        <div class="panel-heading "><span class="glyphicon glyphicon-info-sign"></span>                <h5>A continuaci&oacute; descargar&aacute;s tu formato &uacute;nico, para posteriormente imprimirlo y acudir a la instancia donde realizarás tu servicio social para que te sellen tu documento como se muestra a continuación:</h5></div>
                                    </div>
                                
                                <img src="imagenes/fui.png" style="width:300; height:500px" alt="Formato Unico inicial"/>
                                </div>
                                <div class="col-md-6">
                                <h1>Ahora pulsa en el botón de descargar.</h1>
                                <h2>Cuando tu formato tenga el sello corespondiente s&uacute;belo en la siguiente secci&oacute;n</h2>
                                <a href="muestraReporteFUI.pdf" id="cmdDescargaFui" target="_blank" onclick="window.location.reload();" class="btn btn-primary col-md-4 col-md-offset-3"><span class="glyphicon glyphicon-download"></span>&nbsp;Descargar</a>
                                </div>
                            </div>
                            <div id="subirFui" class="tab-pane" col-md-6>
                                <h1>Sube aqu&iacute; tu formato &uacute;nico dellado como el que está a continuaci&oacute;n</h1>
                                <img src="imagenes/fui.png" style="width:300px; height:500px" alt="Formato Unico inicial"/>
                                <form method="post" id="frmSubirFui" action="subirFui.do"  enctype="multipart/form-data">
                                    <p>Subir Formato Único:</p>
                                    <input type="hidden" name ="id" id="idSubirFui" value="${idDatSubida}" class="form-control"/>
                                    ${infoDescarga}
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div id="observaciones" class="col-md-6 panel panel-danger" style="display: none;">
                    <div class="panel-heading"><b>Debes atender los siguientes puntos</b></div>
                    <div class="panel-body">
                        <ul id="listaObservaciones" ></ul>
                    </div>
                </div>
            </div>
            <!--------------------------------------------------Fin Contenido-->          
            <%@include file="../General/footer.jsp"%>  
        </div><!--/row--> 
        <%@include file="../General/js.jsp"%>
        <script src="js/formatoUnicoJQuery.js"></script> 
        <jsp:include page="../Template/headsModal.jsp" />

    </body>
</html>
