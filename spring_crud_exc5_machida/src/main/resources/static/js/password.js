const password = document.getElementById('empPass');
const togglePassword = document.getElementById('togglePassword');

togglePassword.addEventListener('click', function() {
	if (togglePassword.checked) {
		//	チェックボックスにチェックが入った場合
		password.type = 'text';
	} else {
		//	チェックボックスにチェックが入らなかった場合
		password.type = 'password';
	}
}, false);