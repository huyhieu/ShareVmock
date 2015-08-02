;
var overlay = null;
function showOverlay(en_key_message, vi_key_message) {
	if (overlay !== null) {
		overlay.hide();
	}

	var text_ = '';
	if (lang === null || lang === 'EN') {
		text_ = en_key_message;

	} else if (lang === 'VI') {
		text_ = vi_key_message;
	}

	// disableDialog();
	var opts = {
		lines : 10, // The number of lines to draw
		length : 9, // The length of each line
		width : 3, // The line thickness
		radius : 13, // The radius of the inner circle
		corners : 1, // Corner roundness (0..1)
		rotate : 0, // The rotation offset
		color : '#bbbcbd', // #rgb or #rrggbb
		speed : 1, // Rounds per second
		trail : 30, // Afterglow percentage
		shadow : false, // Whether to render a shadow
		hwaccel : false, // Whether to use hardware acceleration
		className : 'spinner', // The CSS class to assign to the spinner
		zIndex : 2e9, // The z-index (defaults to 2000000000)
		top : 'auto', // Top position relative to parent in px
		left : 'auto' // Left position relative to parent in px
	};
	var target = document.createElement("div");
	document.body.appendChild(target);
	var spinner = new Spinner(opts).spin(target);
	overlay = iosOverlay({
		text : text_,
		// duration : 2e3,
		spinner : spinner
	});
	return false;
};

function hideOverlay() {
	// enableDialog();
	if (overlay !== null) {
		overlay.hide();
	}
};