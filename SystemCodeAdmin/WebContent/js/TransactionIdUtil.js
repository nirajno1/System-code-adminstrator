/* isValidSubmit will check transaction id field is empty, then it will not submit */
function isValidSubmit() {
	var transactionId = document.getElementById('transactionId');
	// alert("transactionId" + (transactionId == null));
	if (transactionId.value != '') {
		/* alert("TransactionId :"+transactionId.value); */
		return true;
	}

	alert("TransactionId is empty.");
	return false;
}
/* Ajax method to fetch id from server */
var xmlhttp;
function getTransactionId() {
	/*
	 * controls need to be filled before fetching transaction id name="module"
	 * name="transactionType" name="airlineCode"
	 */

	var url = "http://localhost:8080/SystemCodeAdministration/GetNextIdServ";
	var module = document.getElementById('module');
	var transactionType = document.getElementById('transactionType');
	var airlineCode = document.getElementById('airlineCode');

	module.style.backgroundColor = 'white';
	transactionType.style.backgroundColor = 'white';
	if (module.value == '' || transactionType.value == '') {
		var errorStr;
		var obj = new Array();
		var i = 0;
		if (module.value == '') {
			module.style.backgroundColor = '#F6358A';
			obj[i] = module;
			i++;
			errorStr = "Module Code";
		}
		if (transactionType.value == '') {
			transactionType.style.backgroundColor = '#F6358A';
			obj[i] = transactionType;
			errorStr += " Transaction Type";
		}

		alert("Required field(s) empty: " + errorStr);
		obj[0].focus();
		return;
	}
	url += '?airlineCode=' + airlineCode.value + '&module=' + module.value
			+ '&transactionType=' + transactionType.value;

	if (xmlhttp == null) {
		xmlhttp = getXMLObject();
	}
	url = encodeURI(url);
	//alert(url);
	xmlhttp.open("GET", url, true);
	xmlhttp.onreadystatechange = function() {
		processRequest();
	};
	xmlhttp.send(null);

}
/**
 * This is the call back method If the call is completed when the readyState is
 * 4 and if the HTTP is successfull when the status is 200 update the
 * profileSection DIV
 */
function processRequest() {
	// alert("loading page\n"+ xmlhttp.status +":"+ xmlhttp.statusText);
	if (xmlhttp.readyState == 4) {
		if (xmlhttp.status == 200) {
			// get the XML send by the servlet
			var profileXML = xmlhttp.responseXML.getElementsByTagName("nextId")[0];
			var profileText = profileXML.childNodes[0].nodeValue;
			if (profileText == '') {

				alert("No rule defined, please contact administor.");

			}
			updateTransactionIDField(profileText);
			// Update the HTML
			// alert("Got from server: "+ profileText );
		} else {
			alert("Error loading page\n" + xmlhttp.status + ":"
					+ xmlhttp.statusText);
		}
	}
}
/**
 * This function parses the XML and updates the HTML DOM by creating a new text
 * node is not present or replacing the existing text node.
 */
function updateTransactionIDField(profileText) {

	if (profileText != null) {
		var transactionId = document.getElementById('transactionId');
		transactionId.value = profileText;
	}
}