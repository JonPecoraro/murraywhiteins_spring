$(function() {
	$('#contactForm').on('submit', function(e) {
		if (!contactFormIsValid()) {
			e.preventDefault();
		}
	});
});

function contactFormIsValid() {
	var isValid = true;
	var $contactForm = $('#contactForm');
	
	$('.successBg').addClass('hide');
	
	// remove error classes
	$contactForm
		.find('.errorBg').addClass('hide').end()
		.find('.errorField').removeClass('errorField').end()
		.find('.errorLabel').removeClass('errorLabel');

	// validate all required fields
	$contactForm.find('.required').each(function() {
		var $this = $(this);
		if (!$this.val()) {
			$this.addClass('errorField');
			$contactForm
				.find('label[for="' + $this.attr('id') + '"]').addClass('errorLabel').end()
				.find('.errorBg').removeClass('hide').end();
			isValid = false;
		}
	});

	return isValid;
}

/* Begin Google Maps related code */
function initialize() {
	var canvas = $('#map')[0];
	var companyLatLong = new google.maps.LatLng(35.980192, -80.022366);
	var mapOptions = {
		center: companyLatLong,
		zoom: 15,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(canvas, mapOptions);

	var marker = new google.maps.Marker({
		position: companyLatLong,
		map: map,
		title: 'Murray White Insurance Agency'
	});
}
google.maps.event.addDomListener(window, 'load', initialize);
/* End Google Maps related code */