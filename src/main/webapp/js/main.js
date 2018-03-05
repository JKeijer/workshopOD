function showText(target, message, index, interval) {   
	document.getElementById('textinput').type = 'hidden';
	document.getElementById('textinputbutton').type = 'hidden';
	if (index < message.length) {
		if (message[index] === "-") {
			$(target).append("</br>");
			index++;
			setTimeout(function () { showText(target, message, index, interval); }, interval*4);
		} else {
			$(target).append(message[index++]);
			setTimeout(function () { showText(target, message, index, interval); }, interval);
		}
	} else {
		document.getElementById('textinput').type = 'text';
		document.getElementById('textinputbutton').type = 'submit';
		document.getElementById('textinput').focus();
	}
}