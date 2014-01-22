$(document).ready(listo);

///////////////////////////////////////////////////////////////////////
//Para la implementación de esta validación son necesarias 3 cosas:  //
//1.-El input 'file' debera de contener el id="archivo"              //
//2.-El boton o  input con el que se envia el formulario debera de   //
//ser type=button y contener el id="enviarArchivo"                  //
//3.-Finalmente la etiqueta <form> debera de contener el id="subirArchivo"      //
///////////////////////////////////////////////////////////////////////

function listo() {
    $(document).on("click", "#enviarArchivo", validaFile);
}

function validaFile() {
    var OK = true;
    if ($("#archivo").val() === "")
    {
        $('.error').show("slow").delay(2500).hide("slow");
        $('.error').html("<p>Agregue un archivo porfavor</p>");
        OK = false;
    }
    if (OK) {
        var extension = ($("#archivo").val().substring($("#archivo").val().lastIndexOf("."))).toLowerCase();
        switch (extension) {
            case ".jpg":
            case ".jpeg":
            case ".png":
            case ".pdf":
                alert("Formato valido");
                break;
            default :
                $('.error').show("slow").delay(2500).hide("slow");
                $('.error').html("<p>Recuerde agregar un archivo con extensión: '.jpg' ,'.jpeg' ,'.png' ,'.pdf' , </p>");
                break;
        }
    }
    //$("#subirArchivo").submit();
}


