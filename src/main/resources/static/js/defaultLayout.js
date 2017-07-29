function toggleMenuHover() {
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

$(function() {
	toggleMenuHover();
	$(window).on('resize', toggleMenuHover);
});