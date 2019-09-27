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
