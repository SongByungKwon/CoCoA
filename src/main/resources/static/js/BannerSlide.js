setInterval(function(){
    $("#banner> .banner>ul").animate({left:"-1920px"},400,function(){
        $("#banner> .banner>ul>li:first-child").appendTo("#banner> .banner>ul");
        $("#banner> .banner>ul").css("left",0);
    });
},4000);