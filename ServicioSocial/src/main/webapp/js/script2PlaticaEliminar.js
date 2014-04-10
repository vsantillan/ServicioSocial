        $(document).ready(function(){
               fn_dar_eliminar();
             fn_editar2();
            });
			
	

            
            function fn_dar_eliminar(){
                $("a.elimina").click(function(){
                    id = $(this).attr("idP");
                    fecha = $(this).parents("tr").find("td").find("div").eq(0).html();
                    fechaString=fecha.toString();
                    
                    
                    var res = fechaString.replace("<div></div>"," "); 

                    respuesta = confirm("\u00BFEst\u00E1 seguro que desea eliminar la pl\u00E1tica con fecha: " + res+" ?");
                    if (respuesta){
                        $(this).parents("tr").fadeOut("normal", function(){
                            $(this).remove();
                            var id_platica=id;      
                                $.post("eliminarPlatica.do", {id_platica: id_platica});
                            
                        })
                    }
                });
            };
            
            
               function fn_editar2(){
                $("a.edita").click(function(){
                    
                    id = $(this).parents("tr").find("td").eq(0).html();
                    razon2 = $(this).parents("tr").find("td").eq(1).html();
                    titular2 = $(this).parents("tr").find("td").eq(2).html();
                    direccion2 = $(this).parents("tr").find("td").eq(3).html();
                    telefono12 = $(this).parents("tr").find("td").eq(4).html();
                    telefono22= $(this).parents("tr").find("td").eq(5).html();
                    pagina2 = $(this).parents("tr").find("td").eq(6).html();
                    email2= $(this).parents("tr").find("td").eq(7).html();
                    contacto2= $(this).parents("tr").find("td").eq(8).html();
                    
                 alert("Usuario " + id + " a editar"+razon2+titular2+direccion2+pagina2+email2+contacto2)
                 
                  var rfc=id
                  var razon=razon2
                  var titular=titular2
                  var direccion=direccion2
                  var telefono1=telefono12
                  var telefono2=telefono22
                  var pagina=pagina2
                  var email=email2
                  var contacto=contacto2
                  
                   $.post("ActualizarInstanciaC.jsp", {rfc: rfc, razon: razon, titular: titular, direccion: direccion, pagina: pagina, email:email, telefono1: telefono1, telefono2: telefono2, contacto:contacto});
                  
                    //obtner los campos a editar
                      //  $(this).parents("tr").fadeOut("normal", function(){
                           // $(this).remove();
                            
                            /*
                                aqui puedes enviar un conjunto de datos por ajax
                                $.post("eliminar.php", {ide_usu: id})
                            */
                        //})
                    
                });
            };
                 