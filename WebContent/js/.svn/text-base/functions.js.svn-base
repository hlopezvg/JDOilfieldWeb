function confirmDelete(id, loc, element) {
	result = confirm("Are you sure you wat to delete the " + element + ": "
			+ id + " ?");

	if (result) {
		location.href = loc;
		return true;
	} else {
		return false;
	}
}

function confirmBatchFuelRequestOperation(id, loc, element, operation) {
	result = confirm("Are you sure you wat to " + operation + " the " + element
			+ ": " + id + " ?");

	if (result) {
		location.href = loc;
		// alert("Messager Sent");
		return true;
	} else {
		return false;
	}
}

function checkform() {
	if (document.form.login.value == null) {
		// something is wrong
		alert('There is a problem with the field login');
		return false;
	}

	return true;
}

function clearPriceForm() {
	document.form.date.value = "";
	document.form.codeProduct.value = "0";
}

function popup(mylink, windowname) {
	if (!window.focus)
		return true;
	
	var href;
	
	if (typeof (mylink) == 'string')
		href = mylink;
	else
		href = mylink.href;
	
	win = window.open(href, windowname, 'width=500,height=400,scrollbars=yes');
	win.focus();
	
	return false;
}