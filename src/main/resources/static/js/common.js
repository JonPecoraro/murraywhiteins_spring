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

$(function() {
	// Turn all inputs with the dateField class into date pickers
	$('input.dateField').datepicker();
});
