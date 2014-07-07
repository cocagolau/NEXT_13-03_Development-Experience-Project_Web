function setEvents() {
	document.querySelector('body').addEventListener('click', setClickEvents, true);
}

function setClickEvents(e) {
	var target = e.target;
	console.log(target);
	
}