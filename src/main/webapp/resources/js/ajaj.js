"use strict"

window.onload = function () {
    document.getElementById("getbutton").onclick = getAvailableRooms;
};

// pathname is contextRoot/path/path/ so we want to get [1] 
    // that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function getAvailableRooms(){
   	var dataToSend = JSON.stringify(serializeObject($('#searchForm')));
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/getRooms',
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(responseObject){
			$('#errors').html("");
 			$("#result").append( '<H3 align="center"> OKAY!! <H3>');  
 			$("#result").append( '<H3 align="center"> ' + responseObject.name + ' Category Added <H3>');
	 	    $('#result').show();
		},
 
		error: function(errorObject ){				
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#result').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}

 
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();
}	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
}	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
}	   

function serializeObject (form) {
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;
};


 