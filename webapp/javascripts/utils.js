function createRequest() {
	var request;
	try {
		request = new XMLHttpRequest();
	} catch (tryMS) {
		try {
			request = new ActiveXObject('Msxml2.XMLHTTP');
		} catch (otherMS) {
			try {
				request = new ActiveXObject('Microsoft.XMLHTTP');
			} catch (failed) {
				request = null;
			}
		}
	}
	return request;
}

function createElement(tag, textValue, attributeObj) {
	var elem = document.createElement(tag);

	if (textValue) {
		var text = document.createTextNode(textValue);
		elem.appendChild(text);
	}

	if (attributeObj) {
		var attriKeys = Object.keys(attributeObj);
		var attriKeysLength = attriKeys.length;
		if (attriKeysLength) {
			for (var i=0; i<attriKeysLength; i++) {
				var attribute = attriKeys[i];
				if (attribute && (typeof(attribute) != 'undefined')) {
					//  IE error
					elem.setAttribute(attribute, attributeObj[attribute]);
				}
			}
		}
	}
	return elem;
}

function removeChild(parent) {
	var num = parent.childNodes.length;
	if (num) {
		for (var i=num; i>0; i--) {
			parent.removeChild(parent.childNodes[i-1]);
		}
	}
	return parent;
}

function hasClass(tag, className) {
	var tagClass = tag.className;
	var space = ' ';
	var tagClasses = tagClass.split(space);
	
	for (var i=tagClasses.length; i>0; i--) {
		if (tagClasses[i-1] == className)
			return true;
	}
	return false;
}


function addClass(tag, className) {
	var tagClass = tag.className;
	var space = ' ';
	if (!tagClass) {
		return className;
	}
	var tagClasses = tag.className.split(' ');
	for (var i=tagClasses.length; i>0; i--) {
		if (tagClasses[i-1] == className) {
			return tagClass;
		}
	}
	return tagClass+= (space + className);
}

function removeClass(tag, className) {
	var tagClass = tag.className;
	var space = ' ';
	var tagClasses = tagClass.split(space);
	
	tagClass = '';
	for (var i=tagClasses.length; i>0; i--) {
		if (tagClasses[i-1]!=className)
			tagClass += (tagClasses[i-1] + space);
	}
	return tagClass.substring(0,tagClass.length-1);
}

function getRealFirstChild(parent) {
	var child = parent.firstChild;
	while (child.nodeName == "#text"){
  		child = child.nextSibling;
  	}
  	return child;
}

/* useAjax ('이름',
 * 				{ data    : post시 send에 보낼 데이터값,
 * 				  url     : 요청 주소,
 * 				  callback: 비동기식일 경우 실행할 함수
 * 				}
 * 
 * 예) useAjax('signUp', {data:null, url:'sign/up', callback:openSignUpForm})
 * 
 */ 
function connectAjax(requestDetail) {
	// request obj가 없는 경우 생성 
	try {
		request;
	} catch (error) {
		request = {};
	}	
	
	var url = requestDetail['url'];
	var callbackFunc = requestDetail['callback'];
	var asynchronous = false;
	var data = requestDetail['data'];
	var method = 'post';
	var curRequest;
	
	
	// callback 함수가 있을 때는 비동기식이므로 key값 등록이 필요.
	if (!callbackFunc) {
		curRequest = createRequest();
	}
	else {
		request[callbackFunc.name] = createRequest();
		curRequest = request[callbackFunc.name];
	}
	
	// request객체가 생성되지 않은 경우
	if (!curRequest) {
		console.log('Unable to create request'); // log 이용하는 방법.?
		return;
	}
	
	// send할 data가 null인 경우 get방식, 아닌 경우 post방
	if (requestDetail['data'] === null) {
		data = null;
		method='get';
	}
	
	//	null시 async:false
	if (callbackFunc !== null) {
		curRequest.onreadystatechange = callbackFunc; 
		asynchronous = true;
	}
	
	curRequest.open(method, url, asynchronous);
	curRequest.send(data);
}