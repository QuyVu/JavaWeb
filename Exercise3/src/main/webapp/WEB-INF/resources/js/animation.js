var interval = null;
var blinking = null;
function moving() {
	var elem = document.getElementById("animate");
	var pos = 0;
	if (interval == null && blinking == null) {
		blinking = setInterval(changeColor, 200);
		interval = setInterval(frame, 5);
	} else {
		clearInterval(interval);
		clearInterval(blinking);
		interval = setInterval(frame, 5);
		blinking = setInterval(changeColor, 200);
	}
	function changeColor() {
		var randomColor = Math.floor(Math.random()*16777215).toString(16);
		elem.style.backgroundColor = '#' + randomColor;
	}
	function frame() {
		if (pos == 350) {
			clearInterval(interval);
			clearInterval(blinking);
		} else {
			pos++;
			elem.style.top = pos + 'px';
			elem.style.left = pos + 'px';
		}
	}
}

function reflex() {
	var elem = document.getElementById("animate");
	var top = 0;
	var left = 0;
	if (interval == null) {
		interval = setInterval(goAround, 5);
	} else {
		clearInterval(interval);
		interval = setInterval(goAround, 5);
	}
	elem.style.top = 0 + 'px';
	elem.style.left = 0 + 'px';
	function goAround() {
		elem.style.display = 'inline';
		if (top < 350 && left == 0) {
			top++;
			elem.style.top = top + 'px';
		} else if (top == 350 && left < 350) {
			left++;
			elem.style.left = left + 'px';
		} else if (top > 0 && left == 350) {
			top--;
			elem.style.top = top + 'px';
		} else if (left > 0 && top == 0) {
			left--;
			elem.style.left = left + 'px';
		}
	}
}

function stop() {
	clearInterval(interval);
	clearInterval(blinking);
}