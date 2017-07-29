common = {};

common.clearErrors = function($parentElement) {
	$parentElement.find('.errorField').removeClass('errorField');
	$parentElement.find('.errorLabel').removeClass('errorLabel');
}

common.isValid = function($parentElement) {
	var valid = true;
	
	common.clearErrors($parentElement);

	$parentElement.find('.required').each(function() {
		var $this = $(this);
		if (!$this.val()) {
			$this.addClass('errorField');
			$this.siblings('label').addClass('errorLabel');
			valid = false;
		}
	});
	
	return valid;
};

common.toggleMenuHover = function() {
	// remove the hover capability if screen size is too small.
	if (!$('#nav .navbar-toggle').is(':visible')) {
		$('#navbar li.dropdown').hover(function() {
		   $(this).find('.dropdown-menu').stop(true, true).delay(50).fadeIn(250); 
		}, function() {
			$(this).find('.dropdown-menu').stop(true, true).delay(50).fadeOut(250);
		});
	} else {
		$('#navbar li.dropdown').unbind('mouseenter mouseleave')
	}
}

common.httpsRedirect() {
	// Redirects all HTTP request to the HTTPS website
	if (location.protocol == 'http:' && location.href.indexOf('murraywhiteins') > -1) {
		location.href = location.href.replace('http:', 'https:');
	}
}

$(function() {
	// Redirect HTTP requests to HTTPS website
	common.httpsRedirect();
	
	// Enable/Disable menu hover based on screen size
	common.toggleMenuHover();
	$(window).on('resize', common.toggleMenuHover);
	
	// Turn all inputs with the dateField class into date pickers
	$('input.dateField').datepicker();
});