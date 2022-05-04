"usestrict"
function verifyPassword() {
	let password = document.getElementById("password").value;
	let rPassword = document.getElementById("rPassword").value;
	if (password != rPassword) {
		document.getElementById("submit").setAttribute("disabled", "disabled");;
	} else {
		document.getElementById("submit").removeAttribute("disabled");
	}
}
document.getElementById("password").addEventListener("change", verifyPassword);
document.getElementById("rPassword").addEventListener("change", verifyPassword);