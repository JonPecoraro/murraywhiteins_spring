$(function() {
	$('#propertyAddressSameAsAddress').on('change', function() {
		if ($('#propertyAddressSameAsAddress').is(':checked')) {
			$('#propertyAddress').val('Same as mailing address').addClass('hide');
		} else {
			$('#propertyAddress').val('').removeClass('hide');
		}
	});
	
	$('input[name="jewelry"]').on('click', function() {
		if ($(this).val() == 'Yes') {
			$('#hasJewelry').removeClass('hide');
		} else {
			$('#hasJewelry').addClass('hide');
		}
	});
	
	$('input[name="homeLoan"]').on('click', function() {
		if ($(this).val() == 'Yes') {
			$('#hasHomeLoan').removeClass('hide');
		} else {
			$('#hasHomeLoan').addClass('hide');
		}
	});
});