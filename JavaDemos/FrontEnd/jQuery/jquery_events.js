
$(document).ready(function(){
    $("#toggleH1s").on("click", function () {
        $("h1").toggle("slow");
    })
});

$(document).ready(function(){
    $("p").hover(
        // in callback
        function () {
            $(this).css("background-color", "CornflowerBlue");
        },
        // out callback
        function () {
            $(this).css("background-color", "");
        }
    );
});

