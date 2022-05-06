"use strict"
$(document).ready(function() {
	
	let selectedItem = localStorage.getItem("locales");
	console.log(selectedItem);
	$("#locales").val(selectedItem ? selectedItem : "en");
	$("#locales").change(function() {
		let selectedOption = $("#locales").val();
		console.log(selectedOption);
		if (selectedOption) {
			window.location.replace("?lang=" + selectedOption);
			localStorage.setItem("locales", selectedOption);
		}
	});
});

/*$(document).ready(function() {
	
});*/