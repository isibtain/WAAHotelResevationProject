"use strict"

window.onload = function () {
    document.getElementById("btn_add_review").onclick = showForm;
};


function showForm() {
	document.getElementById("myreviewform").style.display = "block";
	document.getElementById("fill")[0].reset();
	$("fill")[0].reset();
}