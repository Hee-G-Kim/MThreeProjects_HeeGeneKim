$(document).ready(function(){
    $("p").click(function(){
      $(this).hide();
    });
});

$(document).ready(function(){
    $("button#b1").click(function(){
      //$("p#p1").text("<h2>Welcome to jquery!</h2>");
      $("p#p1").html("<h2>Welcome to jquery lib!</h2>");
    });
});
$(document).ready(function(){
    $("button#b2").click(function(){
      $("input:text").val("Billy n");
    });
});

// # refers to  id  e,g button#newButton
$(document).ready(function(){
    $("button#newButton").click(function(){
        $('#emptyDiv').append('<p>A new paragraph of text...</p>');
        //$('.emptyDiv').prepend('<p>A new paragraph of text...</p>');
        //$('h1#first').remove();
    });
});

// . refers to  class  e,g button.changeColor  
$(document).ready(function(){
    $("button.changeColor").click(function(){
      $('h1').css('color', 'blue');
      $('h1').removeClass('color');
    });
  });
  
