/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function actualizaFecha(fechaInicio){
    var fecha= fechaInicio.value;
    var arrayFecha=fecha.split('/');
    var año=arrayFecha[2];
    var mes=arrayFecha[1]-1;
    var dia=arrayFecha[0];
    var final = new Date(año,mes,dia);
    final.setMonth(final.getMonth()+2);
    document.reportesBimestrales.fechaFin.defaultValue = final.toLocaleDateString();

    
}
