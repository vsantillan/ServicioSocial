<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : verProcesoAlumno
    Created on : 17-oct-2013, 10:31:52
    Author     : bustedvillain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../Template/headsMenuAdministracion.jsp" />
        <jsp:include page="../Template/metas.jsp" />
        <!--Include para Ventanas Modales-->
        <jsp:include page="../Template/headsModal.jsp" />

        <script src="js/jquery.manolo.js"></script>       
        <title>Ver Proceso del Alumno</title>
        <link rel="stylesheet" type="text/css" href="css/zebra-tables.css" />
    </head>
    <body class="background">
    <center>
        <div class="MyForm" style="width:80%;" id="contenido">

            <center>
                <table class="zebra">
                    <thead>
                    <th colspan="2"><h1>Informaci&oacute;n del Alumno</h1></th>
                    </thead>
                    <tbody>
                        <!--Datos Personales-->
                        <tr>
                            <td colspan="2"><h1>Datos Personales</h1></td>
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td>${alumno.nombre} ${alumno.apellidoP} ${alumno.apellidoM}</td>
                        </tr>
                        <tr>
                            <td>Sexo</td>
                            <td>${alumno.sexo}</td>
                        </tr>
                        <tr>
                            <td>Estado Civil</td>
                            <td>${alumno.estadoCivil}</td>
                        </tr>
                        <tr>
                            <td>Ocupaci&oacute;n</td>
                            <td>${alumno.ocupacion}</td>
                        </tr>
                        <tr>
                            <td>CURP</td>
                            <td>${alumno.curp}</td>
                        </tr>
                        <tr>
                            <td>Lugar de Nacimiento</td>
                            <td>${alumno.lugarNacimiento}</td>
                        </tr>
                        <tr>
                            <td>Folio de Documento de Identificaci&oacute;n</td>
                            <td>${alumno.folioDocIdentificaciin}</td>
                        </tr>
                        <tr>
                            <td>Clave de Documento de Identificaci&oacute;n</td>
                            <td>${alumno.claveDocIdentificacion}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><h1>Datos de Contacto</h1></td>
                        </tr>
                        <tr>
                            <td>Calle</td>
                            <td>${alumno.calle}</td>
                        </tr>
                        <tr>
                            <td>No. Interior</td>
                            <td>${alumno.numeroI}</td>
                        </tr>
                        <tr>
                            <td>No. Exterior</td>
                            <td>${alumno.numeroE}</td>
                        </tr>
                        <tr>
                            <td>Codigo Postal</td>
                            <td>${alumno.idColonia.idCp.cp}</td>
                        </tr>
                        <tr>
                            <td>Estado</td>
                            <td>${alumno.idColonia.idCp.idEstado.nombre}</td>
                        </tr>
                        <tr>
                            <td>Municipio</td>
                            <td>${alumno.idColonia.idCp.idMunicipio.nombre}</td>
                        </tr>
                        <tr>
                            <td>Ciudad</td>
                            <td>${alumno.idColonia.idCp.idCiudad.nombre}
                        </tr>
                        <tr>
                            <td>Colonia</td>
                            <td>${alumno.idColonia.nombre}</td>
                        </tr>
                        <tr>
                            <td>Entre Calles</td>
                            <td>${alumno.entreCalles}</td>
                        </tr>
                        <tr>
                            <td>Referencias</td>
                            <td>${alumno.referencia}</td>
                        </tr>
                        <tr>
                            <td>Tel&eacute;fono Casa</td>
                            <td>${alumno.telefonoCasa}</td>
                        </tr>
                        <tr>
                            <td>Tel&eacute;fono Celular</td>
                            <td>${alumno.telefonoCel}</td>
                        </tr>
                        <tr>
                            <td>Tel&eacute;fono Oficina</td>
                            <td>${alumno.telefonoOficina}</td>
                        </tr>
                        <tr>
                            <td>Correo Electr&oacute;nico</td>
                            <td>${alumno.correoElectronico}</td>
                        </tr>
                        <tr>
                            <td>Twitter</td>
                            <td>${alumno.twitter}</td>
                        </tr>
                        <tr>
                            <td>Facebook</td>
                            <td>${alumno.facebook}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><h1>Datos Acad&eacute;micos</h1></td>
                        </tr>
                        <tr>
                            <td>N&uacute;mero de Control</td>
                            <td>${alumno.alumnoId.id}</td>
                        </tr>
                        <tr>
                            <td>Carrera</td>
                            <td>${alumno.alumnoId.carrera}</td>
                        </tr>
                        <tr>
                            <td>Periodo</td>
                            <td>
                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                    ${formatoUnico.periodoInicio}"
                                </core:forEach> 
                            </td>
                        </tr>
                        <tr>
                            <td>Semestre</td>
                            <td>${alumno.alumnoId.semActual}</td>
                        </tr>
                        <tr>
                            <td>Total de cr&eacute;ditos cubiertos</td>
                            <td>${alumno.alumnoId.creditosAcumulados}</td>
                        </tr>
                        <tr>
                            <td>Porcentaje de cr&eacute;ditos cubiertos</td>
                            <td>${alumno.alumnoId.porcentaje}</td>
                        </tr>
                        <tr>
                            <td>Promedio</td>
                            <td>${alumno.alumnoId.promedio}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><h1>Datos de Proyecto</h1></td>
                        </tr>
                        <tr>
                            <td>Nombre de la Instancia</td>
                            <td>
                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                    ${formatoUnico.idproyecto.idInstancia.nombre}"
                                </core:forEach> 
                            </td>
                        </tr>
                        <tr>
                            <td>Nombre del proyecto</td>
                            <td>
                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                    ${formatoUnico.idproyecto.nombre}"
                                </core:forEach> 
                            </td>
                        </tr>
                        <tr>
                            <td>Ver Detalle del Proyecto</td>
                            <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                <td><a href="detalleProyecto.do?id=${formatoUnico.idproyecto.idInstancia.idInstancia}" class="fancy"><img src="imagenes/lupa.png" width="30"/></a></td>   
                            </core:forEach>               
                        </tr>
                        <tr>
                            <td colspan="2"><h1>Horario</h1></td>                            
                        </tr>
                        <tr>
                            <td>D&iacute;as</td>
                            <td>
                                <core:forEach items="${alumno.formatoUnicoCollection}" var="formatoUnico">
                                    <ul>
                                        <core:forEach items="${formatoUnico.horariosAlumnoCollection}" var="horario">
                                            <li>
                                                <core:choose>
                                                    <core:when test="${horario.dia == '1'}">
                                                        Lunes
                                                    </core:when>
                                                    <core:when test="${horario.dia == '2'}">
                                                        Martes
                                                    </core:when>
                                                    <core:when test="${horario.dia == '3'}">
                                                        Mi&eacute;rcoles
                                                    </core:when>
                                                    <core:when test="${horario.dia == '4'}">
                                                        Jueves
                                                    </core:when>
                                                    <core:when test="${horario.dia == '5'}">
                                                        Viernes
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
            </center>
            <br/>


        </div>
    </center>
</body>
</html>
