<%@include file="../General/jstl.jsp"%>


<!DOCTYPE html>
<html>
    <head>
        <%@include file="../General/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="row">
                    <%@include file="../General/banner.jsp"%>  
                    <br>
                    <div class="help-block text-center"><h1 class=""><span class="glyphicon glyphicon-list"></span>&nbsp; Información del Alumno</h1></div>
                    <br>
                    <div class="col-md-12">
                        <div class="col-md-6">
                            <div class="panel panel-primary">
                                <div class="panel-heading"><h3>Datos Personales</h3></div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <tbody>
                                            <tr>
                                                <th>Nombre:</th>
                                                <td>${alumno.nombre} ${alumno.apellidoP} ${alumno.apellidoM}</td>
                                            </tr>
                                            <tr>
                                                <th>Sexo:</th>
                                                <td>${alumno.sexo}</td>
                                            </tr>
                                            <tr>
                                                <th>Estado Civil:</th>
                                                <td>${alumno.estadoCivil}</td>
                                            </tr>
                                            <tr>
                                                <th>Ocupación:</th>
                                                <td>${alumno.ocupacion}</td>
                                            </tr>
                                            <tr>
                                                <th>CURP:</th>
                                                <td>${alumno.curp}</td>
                                            </tr>
                                            <tr>
                                                <th>Lugar de Nacimiento:</th>
                                                <td>${alumno.lugarNacimiento}</td>
                                            </tr>
                                            <tr>
                                                <th>Folio de Documento de Identificación:</th>
                                                <td>${alumno.folioDocIdentificaciin}</td>
                                            </tr>
                                            <tr>
                                                <th>Clave de Documento de Identificación:</th>
                                                <td>${alumno.claveDocIdentificacion}</td>
                                            </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="panel-primary">
                                <div class="panel-heading"><h3>Datos Académicos</h3></div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th>Número de Control:</th>
                                            <td>${alumno.alumnoId.id}</td>
                                        </tr>
                                        <tr>
                                            <th>Carrera:</th>
                                            <td>${alumno.alumnoId.carrera}</td>
                                        </tr>
                                        <tr>
                                            <th>Periodo:</th>
                                            <td>
                                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                                    ${formatoUnico.periodoInicio}"
                                                </core:forEach> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Semestre:</th>
                                            <td>${alumno.alumnoId.semActual}</td>
                                        </tr>
                                        <tr>
                                            <th>Total de créditos cubiertos:</th>
                                            <td>${alumno.alumnoId.creditosAcumulados}</td>
                                        </tr>
                                        <tr>
                                            <th>Porcentaje de créditos cubiertos:</th>
                                            <td>${alumno.alumnoId.porcentaje}</td>
                                        </tr>
                                        <tr>
                                            <th>Promedio:</th>
                                            <td>${alumno.alumnoId.promedio}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-primary">
                                <div class="panel-heading"><h3>Datos de Contacto</h3></div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th>Calle:</th>
                                            <td>${alumno.calle}</td>
                                        </tr>
                                        <tr>
                                            <th>No. Interior:</th>
                                            <td>${alumno.numeroI}</td>
                                        </tr>
                                        <tr>
                                            <th>No. Exterior:</th>
                                            <td>${alumno.numeroE}</td>
                                        </tr>
                                        <tr>
                                            <th>Codigo Postal:</th>
                                            <td>${alumno.idColonia.idCp.cp}</td>
                                        </tr>
                                        <tr>
                                            <th>Estado:</th>
                                            <td>${alumno.idColonia.idCp.idEstado.nombre}</td>
                                        </tr>
                                        <tr>
                                            <th>Municipio:</th>
                                            <td>${alumno.idColonia.idCp.idMunicipio.nombre}</td>
                                        </tr>
                                        <tr>
                                            <th>Ciudad:</th>
                                            <td>${alumno.idColonia.idCp.idCiudad.nombre}
                                        </tr>
                                        <tr>
                                            <th>Colonia:</th>
                                            <td>${alumno.idColonia.nombre}</td>
                                        </tr>
                                        <tr>
                                            <th>Entre Calles:</th>
                                            <td>${alumno.entreCalles}</td>
                                        </tr>
                                        <tr>
                                            <th>Referencias:</th>
                                            <td>${alumno.referencia}</td>
                                        </tr>
                                        <tr>
                                            <th>Teléfono Casa:</th>
                                            <td>${alumno.telefonoCasa}</td>
                                        </tr>
                                        <tr>
                                            <th>Teléfono Celular:</th>
                                            <td>${alumno.telefonoCel}</td>
                                        </tr>
                                        <tr>
                                            <th>Teléfono Oficina:</th>
                                            <td>${alumno.telefonoOficina}</td>
                                        </tr>
                                        <tr>
                                            <th>Correo Electrónico:</th>
                                            <td>${alumno.correoElectronico}</td>
                                        </tr>
                                        <tr>
                                            <th>Twitter:</th>
                                            <td>${alumno.twitter}</td>
                                        </tr>
                                        <tr>
                                            <th>Facebook:</th>
                                            <td>${alumno.facebook}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-6">
                            <div class="panel panel-primary">
                                <div class="panel-heading"><h3>Datos de Proyecto</h3></div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th>Nombre de la Instancia:</th>
                                            <td>
                                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                                    ${formatoUnico.idproyecto.idInstancia.nombre}
                                                </core:forEach> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Nombre del proyecto:</th>
                                            <td>
                                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                                    ${formatoUnico.idproyecto.nombre}"
                                                </core:forEach> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Ver Detalle del Proyecto:</th>
                                            <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                                <td><a href="detalleProyecto.do?id=${formatoUnico.idproyecto.idInstancia.idInstancia}" class="fancy"><span class="glyphicon glyphicon-search sizeIcon"></span></a></td>   
                                            </core:forEach>               
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel-primary">
                                <div class="panel-heading"><h3>Horario</h3></div>
                                <div class="panel-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th>Días</th>
                                            <td>
                                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                                    <ul>
                                                        <core:forEach items="${formatoUnico.horariosAlumnoCollection}" var="horario">
                                                            <li>
                                                                <core:choose>
                                                                    <core:when test="${horario.dia == '1'}">
                                                                        <b>Lunes</b>
                                                                    </core:when>
                                                                    <core:when test="${horario.dia == '2'}">
                                                                        <b>Martes</b>
                                                                    </core:when>
                                                                    <core:when test="${horario.dia == '3'}">
                                                                        <b>Miércoles</b>
                                                                    </core:when>
                                                                    <core:when test="${horario.dia == '4'}">
                                                                        <b>Jueves</b>
                                                                    </core:when>
                                                                    <core:when test="${horario.dia == '5'}">
                                                                        <b>Viernes</b>
                                                                    </core:when>
                                                                </core:choose>
                                                                Hora Inicio: ${horario.horaInicio} Hora Fin: ${horario.horaFin}
                                                            </li>
                                                        </core:forEach>
                                                    </ul>
                                                </core:forEach>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../General/footer.jsp"%>    
            </div>
        </div>
        <%@include file="../General/js.jsp"%>
        <jsp:include page="../Template/headsModal.jsp" />
    </body>
</html>