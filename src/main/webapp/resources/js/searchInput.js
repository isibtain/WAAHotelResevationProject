"use strict"

window.onload = function () {
    document.getElementById("check").onclick = search;
};

 // $(function() {
 //      $("#check").onclick(search);

 function search() {
     var checkIn = $("#checkIn").val();
     var checkOut = $("#checkOut").val();
     var roomType = $("#type").val();
     var roomView = $("#view").val();
     var withGym = $("#gym").val();
     var withParking = $("#parking").val();
     var formInput = {checkInDate: checkIn, checkOutDate: checkOut, type: roomType, view: roomView, gym: withGym, parking: withParking};
     $.post("available", {"formInput" : JSON.stringify(formInput)}, responseFunction, "json");

 }

 function responseFunction(data) {
     var messageBox = document.getElementById("messageDisplay");
     messageBox.innerText = data;
     messageBox.style.display = "block";
     var nextBtn = document.getElementById("submitBtn");
     var checkBtn = document.getElementById("check");
     if(data == "All set! The room you requested is available. Click NEXT to Proceed"){
         nextBtn.style.display = "block";
         nextBtn.style.margin = "auto";
         checkBtn.style.background = "green";
         checkBtn.innerText = "Congrats! Available";
     }

 }

 // });

// function search() {
//     var messageBox = document.getElementById("messageDisplay");
//     messageBox.innerHTML = "available";
//     messageBox.style.display = "block";
// }