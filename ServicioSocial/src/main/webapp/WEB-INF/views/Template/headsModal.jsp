<%-- 
    Document   : headsModal
    Created on : 7/08/2013, 12:30:46 PM
    Author     : rodrigo
--%>

<script type="text/javascript" language="javascript" src="js/modal/jquery.fancybox.js"></script>
<link rel="stylesheet" type="text/css" href="js/modal/jquery.fancybox.css" />

<script type="text/javascript" >
    $(document).ready(function() {
        // FANCY EFFECTT
        $(".fancybox-effects-a").fancybox({
            helpers: {
                title: {
                    type: 'outside'
                },
                overlay: {
                    speedOut: 0
                }
            }
        });
        //FACY EXTERNO
    $(".fancy").fancybox({  
        'autoScale'     : false,  
        'transitionIn'      : 'none',  
        'transitionOut'     : 'none',  
        'width'         : 680,  
        'height'        : 450,  
        'type'          : 'iframe'  
    }); 
    });
</script>