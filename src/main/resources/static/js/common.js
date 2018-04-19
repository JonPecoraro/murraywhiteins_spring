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

common.httpsRedirect = function() {
	// Redirects all HTTP request to the HTTPS website
	if (location.protocol == 'http:' && location.href.indexOf('murraywhiteins') > -1) {
		if (location.href.indexOf('www.') > -1) {
			location.href = location.href.replace('http:', 'https:');
		} else {
			location.href = location.href.replace('http://', 'https://www.');
		}
	}
}

common.getTestimonial = function() {
	$.ajax({
		url: '/getTestimonial',
		dataType: 'json'
	}).done(function(data) {
		$('footer .information .testimonial')
			.find('.testimonialText').text(data.testimonial).end()
			.find('.testimonialSignature').text('- ' + data.author);
		
	}).fail(function(jqXHR, textStatus, errorThrown) {
		var defaultTestimonial = 'I love Murray White Insurance Agency. They have been serving me well for many years. The agents are always quick to respond and willing to work with my limited budget. They have helped my family and I get back on our feet during trying times.';
		var defaultAuthor = '- Jonathan Pecoraro'
		$('footer .information .testimonial')
			.find('.testimonialText').text(defaultTestimonial).end()
			.find('.testimonialSignature').text(defaultAuthor);
	});
}

// Gets the weather in High Point, NC
common.getWeather = function() {
	$.ajax({
		url: 'http://api.openweathermap.org/data/2.5/weather?q=High Point,us&units=imperial&APPID=83ecd15ea5083a22e88b77344a19d380',
		dataType: 'json'
	}).done(function(data) {
		var weatherData = data.weather[0];
		var temperature = Math.round(data.main.temp);
		var iconUrl = 'http://openweathermap.org/img/w/' + weatherData.icon + '.png';		
		$('footer .information .weather').html(
			'<div class="weatherText">' +
				'<p>High Point local weather</p>' +
				'<img src="' + iconUrl + '" /> ' + temperature + ' &deg; F ' + weatherData.description +
			'</div>'
		);
	}).fail(function(jqXHR, textStatus, errorThrown) {
		$('footer .information .weather').empty();
	});
}

$(function() {
	// Redirect HTTP requests to HTTPS website
	common.httpsRedirect();
	
	// Enable/Disable menu hover based on screen size
	common.toggleMenuHover();
	$(window).on('resize', common.toggleMenuHover);
	
	// Turn all inputs with the dateField class into date pickers
	$('input.dateField').datepicker();
	
	// Display a random testimonial
	common.getTestimonial();
	
	// Get the current weather
	common.getWeather();
});