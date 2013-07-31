/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function actualizaFecha(fechaInicio){


    var fecha= fechaInicio.value;
    alert("Fecha Inicio reporte"+fecha);
    var arrayFecha=fecha.split('/');
    var año=arrayFecha[2];
    var mes=arrayFecha[1];
    var dia=arrayFecha[0];

  var final = new Date();
  final.setFullYear(año);
  final.setUTCMonth(mes);
  final.setDate(dia);
  final.setMonth(final.getMonth()+2);
  document.reportesBimestrales.fechaFin.defaultValue = final.toLocaleDateString();
    //alert("Fecha fin Reporte: "+final.getDate()+"/"+final.getUTCMonth()+"/"+final.getFullYear());
    
}
