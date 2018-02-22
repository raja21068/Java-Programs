// hebrew-specific code in addition to ../functions10.js

function localInitialise () {
	}
	

function addshadda (addchar) {
	// used when the user clicks on a shadda in the phonic view to double the last character in the phoneme buffer
	if (_phonicstr == '') { add('\u0651'); return; }
	var lastchar = _phonicstr.charAt(_phonicstr.length-1);
	
	// check for surrogate pairs
	if (0xDC00 <= lastchar.charCodeAt(0) && lastchar.charCodeAt(0) <= 0xDFFF && _phonicstr.length > 1) { // this is second in s pair
		lastchar = _phonicstr.charAt(_phonicstr.length-1)+lastchar;
		}
		
	_phonicstr += lastchar;

	if (addchar) { add('\u0651'); }
	}
	

