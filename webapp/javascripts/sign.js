// 회원가입창 열기
function openSignUpForm(e) {
	var key = this.onreadystatechange.name;
	var curRequest = request[key];
	if(curRequest.readyState == 4) {
		if(curRequest.status == 200) {
			
			document.querySelector('#overlay').innerHTML = curRequest.responseText;
			openOverlay(closeSignUpForm);
			
			var form = document.querySelector('#signUpForm');
			var email = form[0];
			var name = form[1];
			var topPassword = form[2];
			var bottomPassword = form[3];
			
			
			var overlay = document.querySelector('#overlay');
			var signInFormBtn = document.querySelector('#userStatus > .signInFormBtn');
			var signUpFormBtn = document.querySelector('#userStatus > .signUpFormBtn');
			var signUpTitle = document.querySelector('#userStatus > .title');
			signInFormBtn.className = addClass(signInFormBtn, 'out');
			signUpFormBtn.className = addClass(signUpFormBtn, 'out');
			signUpTitle.className = removeClass(signUpTitle, 'out');
			
			overlay.querySelector('#signUp').addEventListener('click', function(e){ e.stopPropagation(); } , false);
			overlay.querySelector('#signUp .closeBtn').addEventListener('click', closeSignUpForm, false);
			
			
			// verification
			email.addEventListener('blur', verifyEmail, false);
			name.addEventListener('blur', verifyName, false);
			topPassword.addEventListener('blur', verifyPassword, false);
			topPassword.addEventListener('keydown', verifyPassword, false);
			topPassword.addEventListener('keypress', verifyPassword, false);
			
			bottomPassword.addEventListener('keydown', verifyPassword, false);
			bottomPassword.addEventListener('keypress', verifyPassword, false);
			
			delete request[key];
		}
	}
}

function openSignUpBtn(form) {
	var bottom = form[3];
	var signUpBtn = form[4];

	bottom.className = addClass(bottom, 'fixed');
	bottom.setAttribute('disabled', 'true');
	signUpBtn.className = removeClass(signUpBtn, 'out');
}

function closeSignUpBtn(form) {
	var bottom = form[3];
	var signUpBtn = form[4];

	bottom.className = removeClass(bottom, 'fixed');
	bottom.removeAttribute('disabled');
	signUpBtn.className = addClass(signUpBtn, 'out');	
}


function closeSignUpForm(e) {
	if (!e.detail.custom) { closeOverlay(); }
	
	var signInFormBtn = document.querySelector('#userStatus > .signInFormBtn');
	var signUpFormBtn = document.querySelector('#userStatus > .signUpFormBtn');
	var signUpTitle = document.querySelector('#userStatus > .title')
	
	signInFormBtn.className = removeClass(signInFormBtn, 'out');
	signUpFormBtn.className = removeClass(signUpFormBtn, 'out');
	signUpTitle.className = addClass(signUpTitle, 'out');
}


function openSignInForm() {
	openOverlay(closeSignInForm);
	
	var signInForm = document.querySelector('#userStatus > .signInForm');
	var signInFormBtn = document.querySelector('#userStatus > .signInFormBtn');
	var signUpFormBtn = document.querySelector('#userStatus > .signUpFormBtn');
	var signInBtn = document.querySelector('#userStatus > .signInBtn');

	signInBtn.firstChild.addEventListener('click', function(){ document.querySelector('#signInForm').submit(); }, false);
	
	signInForm.className = removeClass(signInForm, 'out');
	signInFormBtn.className = addClass(signInFormBtn, 'out');
	signUpFormBtn.className = addClass(signUpFormBtn, 'out');
	signInBtn.className = removeClass(signInBtn, 'out');
	
}

function closeSignInForm() {
	var signInForm = document.querySelector('#userStatus > .signInForm');
	var signInFormBtn = document.querySelector('#userStatus > .signInFormBtn');
	var signUpFormBtn = document.querySelector('#userStatus > .signUpFormBtn');
	var signInBtn = document.querySelector('#userStatus > .signInBtn');
	
	signInBtn.firstChild.removeEventListener('click', function(){ document.querySelector('#signInForm').submit(); }, false);
	
	signInForm.className = addClass(signInForm, 'out');
	signInFormBtn.className = removeClass(signInFormBtn, 'out');
	signUpFormBtn.className = removeClass(signUpFormBtn, 'out');
	signInBtn.className = addClass(signInBtn, 'out');
}


function verifyPassword (e) {
	var passwords = document.querySelectorAll('#signUp > .form .password');
	var topPassword = passwords[0];
	var bottomPassword = passwords[1];
	
	if (typeof e != 'undefined') {
		if (e.type == 'blur') {	
			topPassword.className = removeClass(topPassword, 'incorrect');
			topPassword.className = removeClass(topPassword, 'correct');
			
			var range = /^.{8,15}$/;
			var minNum = /(.*\d{1}.*){4}/;
			var letter = /[^a-zA-Z0-9^\`\~\!\@\#\$\%\^\&|*\(\)\-\_\=\=\+\\\|\,\.\<\>\/\?\[\]\{\}\;\:\'\"]/;
		
			if (!range.test(topPassword.value) || !minNum.test(topPassword.value) || letter.test(topPassword.value)) {
				topPassword.className = addClass(topPassword, 'incorrect');
			}
			else {
				topPassword.className = addClass(topPassword, 'correct');
			}
			verifyForm();
		}
		else if (e.type == 'keydown' || e.type == 'keypress') {
			var code = { 8:'backspace', 46:'delete' };
			// event keydown시 keycode가 8,46이 아니면 종료 
			if ((e.type == 'keydown') && !code[e.keyCode]) { return; }
			// 분당 3000천타시 1타당 0.83초 소요. 100ms면 충분, bottomPassword가 입력되어있지 않으면 아래함수를 실행하지 않음
			if (bottomPassword.value.length) {				
				window.setTimeout(function() {verifyPassword();}, 100);
			}
		}
	}
	else {
		if (topPassword.value == bottomPassword.value) {
			bottomPassword.className = addClass(topPassword, 'correct');
			verifyForm();
		}
		else {
			bottomPassword.className = addClass(topPassword, 'incorrect');
			closeSignUpBtn(document.querySelector('#signUpForm'));
		}
		
	}
}
function verifyForm() {
	var form = document.querySelector('#signUpForm');
	
	closeSignUpBtn(form);
	for (var i=form.length-2; i>0; i--) {
		var input = form[i-1];
		if (!hasClass(input, 'correct')) {
			return;
		}
	}
	openSignUpBtn(form);
}


function verifyEmail(e) {
	var obj = e.target;
	var pattern = /^[\w\.\-\+]+@[\w\.\-\+]+(\.\w{2,4})+$/;
	
	obj.className = removeClass(obj, 'incorrect');
	obj.className = removeClass(obj, 'correct');
	
	if (!pattern.test(obj.value)) {
		obj.className = addClass(obj, 'incorrect');
		closeSignUpBtn(document.querySelector('#signUpForm'));
	}
	else { //success
		obj.className = addClass(obj, 'loading');
		var formdata = new FormData();
		formdata.append('value', obj.value);
		connectAjax({data:formdata, url:'sign/verify', callback:getVerificationResult});
	}
}


function getVerificationResult(e) {
	var key = this.onreadystatechange.name;
	var curRequest = request[key];
	if(curRequest.readyState == 4) {
		if(curRequest.status == 200) {
			var flag = curRequest.responseText;
			var obj = document.querySelector('#signUp > .form .email')
			obj.className = removeClass(obj, 'loading');

			if (flag === 'true') {
				obj.className = addClass(obj, 'incorrect');
			}
			else {
				obj.className = addClass(obj, 'correct');
				
			}
			verifyForm();
			delete request[key];
		}
	}
}

function verifyName(e) {
	var obj = e.target;
	var pattern = /^[가-힣a-zA-Z]{3,}$/;
	
	obj.className = removeClass(obj, 'incorrect');
	obj.className = removeClass(obj, 'correct');
	if (!pattern.test(obj.value)) {
		obj.className = addClass(obj, 'incorrect');
	}
	else { //success
		obj.className = addClass(obj, 'correct');
	}
	verifyForm();
}
