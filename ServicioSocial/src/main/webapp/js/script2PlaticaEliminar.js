// JavaScript Document

            $(document).ready(function(){
               fn_dar_eliminar();
             fn_editar2();
				//fn_cantidad();
               // $("#frm_usu").validate();
            });
			
			/*function fn_cantidad(){
				cantidad = $("#grilla tbody").find("tr").length;
				$("#span_cantidad").html(cantidad);
			};*/
            
            function fn_agregar(){
                cadena = "<tr Bgcolor='#FBF2EF'>";
                cadena = cadena + "<td><div  contenteditable >" + $("#id_platica").val() + "</div></td>";
                cadena = cadena + "<td><div  contenteditable >" + $("#fecha").val() + "</div></td>";
                cadena = cadena + "<td><div  contenteditable >" + $("#hora").val() + "</div></td>";
                cadena = cadena + "<td><div  contenteditable >" + $("#lugar").val() + "</div></td>";
                cadena = cadena + "<td><div  contenteditable >" + $("#semestre").val() + "</div></td>";
                cadena = cadena + "<td><div  contenteditable >" + $("#num_asis").val() + "</div></td>";
                
                
                cadena = cadena + "<td><a class='elimina'><img src='images/delete.png' /></a></td>";
               // cadena = cadena + "<td><a class='edita'><img src='./images/page_white_edit.png' /></a></td>";
                $("#grilla tbody").append(cadena);
                
                var rfc = $("#id_platica").val();
                var razon=$("#razon").val();
                var titular=$("#titular").val();
                var direccion=$("#direccion").val();
                var pagina=$("#pagina").val();
                var email=$("#email").val();
                var telefono1=$("#telefono1").val();
                var telefono2=$("#telefono2").val();
                var contacto=$("#contacto").val();
         
      ///
                /*mandar a agregar  la instancia*/
      //   $.post("AgregarInstanciaC.jsp", {rfc: rfc, razon: razon, titular: titular, direccion: direccion, pagina: pagina, email:email, telefono1: telefono1, telefono2: telefono2, contacto:contacto});
                
                
              fn_dar_eliminar();
               // fn_cantidad();
                alert("Usuario agregado");
            };
            
            function fn_dar_eliminar(){
                $("a.elimina").click(function(){
                    id = $(this).parents("tr").find("td").eq(10).html();
                    fecha = $(this).parents("tr").find("td").find("div").eq(0).html();
                    respuesta = confirm("Está seguro que desea eliminar la platica con fecha: " + fecha);
                    if (respuesta){
                        $(this).parents("tr").fadeOut("normal", function(){
                            $(this).remove();
                            alert("plática" + id+ " eliminada")
                            
                            var id_platica=id
                           
                                
                                $.post("eliminarPlatica.do", {id_platica: id_platica})
                            
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
                