"use strict"

window.onload = function () {
    document.getElementById("btn_add_review").onclick = showForm;
};


function showForm() {
	document.getElementById("myreviewform").style.display = "block";
	document.getElementById("fill")[0].reset();
	$("fill")[0].reset();	
	var reviewScore = $('#rating').val();
	var stars = [46, 86 , 128, 170, 211];
    var x = 0;
	var y = -stars[reviewScore-1];
	var totalReviews = 	$( ".review" ).length;
	$(".averageStars").css({"backgroundPosition": -x + 'px ' + (-y) + 'px' });
}