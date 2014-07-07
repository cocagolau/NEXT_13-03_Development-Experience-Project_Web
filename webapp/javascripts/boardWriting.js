function openWritingForm (e) {
	var key = this.onreadystatechange.name;
	var curRequest = request[key];
	if(curRequest.readyState == 4) {
		if(curRequest.status == 200) {
			
			document.querySelector('#overlay').innerHTML = curRequest.responseText;
			openOverlay(closeWritingForm);
			
			// resize
			var articleForm = document.querySelector('#writingForm .article > textarea');
			articleForm.addEventListener('change', resizeForm, false);
			articleForm.addEventListener('cut', autoResizeForm, false);
			articleForm.addEventListener('paste', autoResizeForm, false);
			articleForm.addEventListener('keydown', autoResizeForm, false);
			articleForm.addEventListener('click', function(e){ e.stopPropagation(); } , false);
			
			overlay.querySelector('#writing').addEventListener('click', function(e){ e.stopPropagation(); } , false);
			overlay.querySelector('#writing .closeBtn').addEventListener('click', closeWritingForm, false);
			
			delete request[key];
		}
	}
}

function closeWritingForm(e) {
//	do - something
	if (!e.detail.custom) { closeOverlay(); }
}


function autoResizeForm() {
	window.setTimeout(resizeForm, 0);
}


function resizeForm() {
	var articleForm = document.querySelector('#writingForm .article > textarea');
	var px = 'px';
	var scrollHeight = articleForm.scrollHeight;
	var offsetHeight = articleForm.offsetHeight;
	var parentHeight = parseInt(window.getComputedStyle(articleForm.parentNode, null).getPropertyValue('height'));
	var parentPadding = parseInt(window.getComputedStyle(articleForm.parentNode, null).getPropertyValue('padding-bottom'));
	
	if (offsetHeight < scrollHeight) {
		articleForm.style.height = scrollHeight + px;
	}
	if (parentHeight < scrollHeight) {
		articleForm.parentNode.style.height = (scrollHeight + (scrollHeight-parentHeight) + 6) + px;
	} 
	
}