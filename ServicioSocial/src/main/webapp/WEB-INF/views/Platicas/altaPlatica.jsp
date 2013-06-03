<%-- 
    Document   : altaPlatica
    Created on : 3/06/2013, 01:01:28 PM
    Author     : Jonny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="tags"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="format"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
    <head>
        <%--  <link rel="stylesheet" type="text/css"  href="<c:url value="/css/estilo_sia.css" />" />--%>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui-1.8.17.custom.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estilo_sia.css"/>"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquerycssmenu.css" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/screen.css" />"/>
        <link rel="shortcut icon" type="image/icon" href="<c:url value="/resources/imagenes/favicon.ico "/>"/>
        
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.min.js"/>"> </script>
        <script type="text/javascript" src="<c:url value="/resources/js/jquerycssmenu.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/baner.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.8.17.custom.min.js"/>"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resourcesjs/jquery.validate.js" ></script>

        <script type="text/javascript" src="<c:url value="/resources/js/formly.js"/>"></script>
        <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script2.js"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/formly.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/screen.css" media="screen" />

        <LINK rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.clockpick.1.2.7.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.clockpick.1.2.7.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.clockpick.1.2.7.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.clockpick.1.2.7.pack.js"></script>



   <script type="text/javascript">
   		$(function(){

				// Accordion
				$("#accordion").accordion({ header: "h3", event: "mouseover" });
				
	
				// Tabs
				$('#tabs').tabs();
	

				// Dialog			
				$('#dialog').dialog({
					autoOpen: false,
					width: 600,
					buttons: {
						"Ok": function() { 
							$(this).dialog("close"); 
						}, 
						"Cancel": function() { 
							$(this).dialog("close"); 
						} 
					}
				});
				
				// Dialog Link
				$('#dialog_link').click(function(){
					$('#dialog').dialog('open');
					return false;
				});

				// Datepicker
				$('#datepicker').datepicker({
					inline: true
				});
                                $('#datepicker').datepicker('option', {dateFormat: 'dd/mm/yy'});
				
				// Slider
				$('#slider').slider({
					range: true,
					values: [17, 67]
				});
				
				// Progressbar
				$("#progressbar").progressbar({
					value: 20 
				});
				
				//hover states on the static widgets
				$('#dialog_link, ul#icons li').hover(
					function() { $(this).addClass('ui-state-hover'); }, 
					function() { $(this).removeClass('ui-state-hover'); }
				);
				
				//validaciones de formularios
				
				$.validator.setDefaults({
					submitHandler: function() { alert("submitted!"); }
				});
				
				$("#commentForm").validate();
                                
                                
				
			
				
			});
		</script>

        <script>

            $(document).on('ready', function() {

                $('#hora').clockpick({
                });

            });
        </script>
        <script>

            $(document).ready(function() {

                $('#MyForm').formly();
            });
        </script>

        <script>

            $(document).ready(function() {

                $('#casistencia').formly();
            });
        </script>
        <script>

            $(document).ready(function() {

                $('#casistenciaespecial').formly();
            });
        </script>


    </head>
     <body>
        <div class="pagina" align="center">
         <div class="banner" align="left">
        <img src="<c:url value="/resources/imagenes/banner2.png" />"/></a>
        </div>
        </div>



        <div id="menu">   
            <div id="myjquerymenu" class="jquerycssmenu">

                <br style="clear: left" />
            </div>
        </div>

        <div id="contenido" style="background-image: url(\'"<c:url value="/resources/imagenes/SIA-MarcaAgua.jpg" />" \');">
            <h1>PLATICAS</h1>  
            <div id="tabs">
                <ul>        

                    <li><a href="#tabcasistencia">Capturar Asistencia</a></li>        
                    <li><a href="#tabs-3">Alta Especial Posterior</a></li>   
                    <li><a href="#tabs-1">Operaciones con Platica</a></li> 
                </ul>   
                <div id="tabs-1">  

                    <p> 
                        <label for="operaciones">Opciones</label>
                        <input name="operaciones" id="operaciones"type="radio" value="m" checked="checked" onclick="toggle_BajaPlatica(this)" />Alta
                        <input name="operaciones" id="operaciones" type="radio" value="f" onclick="toggle_BajaPlatica(this)" />Consultas y Bajas
                        <br />
                    </p>
                    <div id="div_AltaPlatica" style="display:block">



                        <h1>holaaa</h1>

                    </div>

                </div>
                <div id="tabcasistencia">
                    <h2>asistencia</h2>
                    
                </div>
                
            </div>


                    <h2></h2>
             

                </div>

                <div id="footer">
                    <img  src="<c:url value="/resources/imagenes/foter.png"/>"/>
                </div>
                </body>
                <script language=JavaScript>


            var mm = new Date();
            var m2 = mm.getFullYear();


            document.altaPlatica.aaaa.value = m2;
            //document.algunNombre.texto2.value=mm.getFullYear();

                </script>
                
</html>
