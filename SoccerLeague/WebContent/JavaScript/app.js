function validateForm() {
	var x = document.forms['myForm']['year'].value;
	var y = document.forms['myForm']['title'].value;
	var z=document.forms['myForm']['season'].value;


	if(x==""){
		alert("Year field required");
	return false;
		}
	if(y==""){
		alert("title field required");
	return false;
		}
	if(z=='UNKNOWN'){
		alert("Season required");
	return false;
		}
}

function onCancel() {
	location.href = "index.html";
}