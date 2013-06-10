/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    $(".btn-validar-org").click(function(event) {
        $("#div-validar-organizacion").show('slow');
        
        setTimeout(function() {
            $("#div-validar-organizacion").hide('slow')
        }, 3000);
    })

    $(".btn-validar-proyecto").click(function(event) {
        $("#div-validar-proyecto").show('slow');
        
        setTimeout(function() {
            $("#div-validar-proyecto").hide('slow')
        }, 3000);
    })
});


