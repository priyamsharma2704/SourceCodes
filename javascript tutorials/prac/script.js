var n1 = document.getElementById("field1");
var n2 = document.getElementById("field2");
var form = document.getElementById("form");
var result = document.getElementById("result");

form.addEventListener('submit',function(event){
	if(n1.value == null && n2.value == null)
		alert("enter value");
	else{
		console.log(parseInt(n1.value) + parseInt(n2.value));
		result.innerText = "result = " + (parseInt(n1.value) + parseInt(n2.value));	
		event.preventDefault();
	}
	

});