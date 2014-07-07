window.onload = initPage;

function initPage() {
	// commentsWriting event 등록
	var formList
	if (formList = document.querySelectorAll('#articleList .right > .comments .writing .submitBtn > input')) {
		for (var i=formList.length; i>0; i--) {
			formList[i-1].addEventListener('click', writeComments, false);
		}
	}
	
	//boardWriting event등록
	var writingBtn;
	if (writingBtn = document.querySelector('#action > .writing'))
		writingBtn.addEventListener('click', function() { connectAjax({data:null, url:'board/writing', callback:openWritingForm}); }, false);
	
	//signUp event등록
	var signUpFormBtn, signInFormBtn, signOutBtn;
	if (signUpFormBtn = document.querySelector('#userStatus > .signUpFormBtn a'))
		signUpFormBtn.addEventListener('click', function() { connectAjax({data:null, url:'sign/up', callback:openSignUpForm}); }, false);
	
	//signIn event등록
	if (signInFormBtn = document.querySelector('#userStatus > .signInFormBtn a'))
		signInFormBtn.addEventListener('click', openSignInForm, false);
		
	
	// signOut Event등록
	if (signOutBtn = document.querySelector('#userStatus > .signOutBtn a')) {
		var signOutUrl = 'sign/out';
		signOutBtn.setAttribute('href', signOutUrl);
	}

}

function openOverlay(callBackFunction) {
	var overlay = document.querySelector('#overlay');
	overlay.className = 'overlay';
	overlay.addEventListener('click', closeOverlay, false);
	overlay.addEventListener('click', callBackFunction, false);
}

function closeOverlay(e) {
	//overlay에 event발생시, 상위element로 전파 막음
	if (e) { e.stopPropagation(); }
	var overlay = document.querySelector('#overlay');
	overlay.removeAttribute('class');
	
	// 하위 엘리먼트 삭제
	if (overlay.firstChild) {
		removeChild(overlay);
	}
}
