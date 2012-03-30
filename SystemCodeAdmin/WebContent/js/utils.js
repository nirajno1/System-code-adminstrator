function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false ;  // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}

function handleServerResponse(contorl) {
	   if (xmlhttp.readyState == 4) {
	     if(xmlhttp.status == 200) {
	    	 contorl.value=xmlhttp.responseText; //Update the HTML Form element 
	     }
	     else {
	        alert("Error during AJAX call. Please try again");
	     }
	   }
	}