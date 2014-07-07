
function writeComments(e) {
	e.preventDefault();
	
	var eleForm = e.currentTarget.form
	var sID = eleForm[0].value;
	var formData = new FormData(eleForm);
	
	connectAjax({data:formData, url:'/board/' + +sID + '/test.json', callback:function(){
		var key = this.onreadystatechange.name;
		var curRequest = request[key];
		if(curRequest.readyState == 4) {
			if(curRequest.status == 200) {
				eleForm[2].value="";
				
				var obj = JSON.parse(curRequest.responseText);
				var commentList = eleForm.parentNode.parentNode.querySelector('div:nth-of-type(1)')
				var comment = createElement('div', null, {'class':'comment'});
				
				var info = createElement('div', obj.signBoard.name, {'class':'info'});
				var contents = createElement('div', obj.contents, {'class':'contents'});
				var option = createElement('div', null, {'class':'option'});
				
				var span1 = createElement('span', null, null);
				var modifyBtn = createElement('a', '수정', {'href':'baord/comments/'+ obj.id +'/modify'});
				span1.appendChild(modifyBtn);
				
				var span2 = createElement('span', null, null);
				var deleteBtn = createElement('a', '삭제', {'href':'baord/comments/'+ obj.id +'/delete'});
				span2.appendChild(deleteBtn);
				
				var newline = document.createTextNode('\n');
				option.appendChild(span1);
				option.appendChild(newline);
				option.appendChild(span2);
				
				comment.appendChild(info);
				comment.appendChild(contents);
				comment.appendChild(option);
				
				commentList.appendChild(comment);
				
				delete request[key];
			}
		}
	} });
}